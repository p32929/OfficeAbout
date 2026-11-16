package p32929.officeaboutlib.Others

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Handler
import android.os.Looper
import android.util.LruCache
import android.widget.ImageView
import java.net.HttpURLConnection
import java.net.URL
import java.util.concurrent.Executors

// ponytail: tiny in-memory loader, no disk cache. Fine for a handful of team photos.
internal object ImageLoader {
    private val cache = object : LruCache<String, Bitmap>(8 * 1024 * 1024) {
        override fun sizeOf(key: String, value: Bitmap) = value.byteCount
    }
    private val pool = Executors.newFixedThreadPool(3)
    private val main = Handler(Looper.getMainLooper())

    fun load(url: String, into: ImageView, sizePx: Int, onDone: (Boolean) -> Unit = {}) {
        into.tag = url
        cache.get(url)?.let { into.setImageBitmap(it); onDone(true); return }
        pool.execute {
            val bmp = runCatching { fetch(url, sizePx) }.getOrNull()
            main.post {
                if (into.tag != url) return@post
                if (bmp != null) {
                    cache.put(url, bmp)
                    into.setImageBitmap(bmp)
                }
                onDone(bmp != null)
            }
        }
    }

    private fun fetch(url: String, sizePx: Int): Bitmap? {
        val bytes = (URL(url).openConnection() as HttpURLConnection).run {
            connectTimeout = 10_000; readTimeout = 15_000
            try { inputStream.use { it.readBytes() } } finally { disconnect() }
        }
        val opts = BitmapFactory.Options().apply { inJustDecodeBounds = true }
        BitmapFactory.decodeByteArray(bytes, 0, bytes.size, opts)
        var sample = 1
        while (opts.outWidth / (sample * 2) >= sizePx && opts.outHeight / (sample * 2) >= sizePx) sample *= 2
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.size, BitmapFactory.Options().apply { inSampleSize = sample })
    }
}
