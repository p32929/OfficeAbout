package p32929.officeaboutlib.Activities

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import p32929.officeaboutlib.Models.Member
import p32929.officeaboutlib.Models.OfficeInfo
import p32929.officeaboutlib.Others.ImageLoader
import p32929.officeaboutlib.R
import java.net.HttpURLConnection
import java.net.URL
import kotlin.concurrent.thread

class OfficeAboutActivity : AppCompatActivity() {

    private lateinit var content: View
    private lateinit var progress: View
    private lateinit var error: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_office_about)
        val root = findViewById<View>(R.id.officeAboutRoot)
        ViewCompat.setOnApplyWindowInsetsListener(root) { v, insets ->
            val bars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.updatePadding(left = bars.left, top = bars.top, right = bars.right, bottom = bars.bottom)
            insets
        }
        findViewById<MaterialToolbar>(R.id.officeAboutToolbar).setNavigationOnClickListener { finish() }
        content = findViewById(R.id.officeAboutContent)
        progress = findViewById(R.id.officeAboutProgress)
        error = findViewById(R.id.officeAboutError)
        findViewById<Button>(R.id.officeAboutRetry).setOnClickListener { load() }
        load()
    }

    private fun load() {
        progress.visibility = View.VISIBLE
        error.visibility = View.GONE
        content.visibility = View.GONE
        val json = intent.getStringExtra(EXTRA_JSON)
        val url = intent.getStringExtra(EXTRA_URL).orEmpty()
        val main = Handler(Looper.getMainLooper())
        thread {
            val info = runCatching { OfficeInfo.fromJson(json ?: download(url)) }.getOrNull()
            main.post {
                if (isFinishing) return@post
                progress.visibility = View.GONE
                if (info == null) error.visibility = View.VISIBLE else show(info)
            }
        }
    }

    private fun download(url: String): String =
        (URL(url).openConnection() as HttpURLConnection).run {
            connectTimeout = 10_000; readTimeout = 15_000
            try { inputStream.bufferedReader().use { it.readText() } } finally { disconnect() }
        }

    private fun show(info: OfficeInfo) {
        content.visibility = View.VISIBLE
        val density = resources.displayMetrics.density

        val logo = findViewById<ImageView>(R.id.officeLogoImage)
        info.officeLogoUrl?.let { url ->
            ImageLoader.load(url, logo, (240 * density).toInt()) { ok -> logo.visibility = if (ok) View.VISIBLE else View.GONE }
        }
        setText(R.id.officeName, info.officeName)
        setText(R.id.officeAbout, info.about)

        val links = findViewById<ChipGroup>(R.id.officeLinks)
        links.removeAllViews()
        fun link(label: Int, url: String?, open: () -> Unit = { open(url!!) }) {
            if (url.isNullOrBlank()) return
            links.addView(Chip(this).apply { text = getString(label); setOnClickListener { open() } })
        }
        link(R.string.office_about_play, info.googlePlayUrl)
        link(R.string.office_about_facebook, info.facebookPageUrl) { openFacebook(info) }
        link(R.string.office_about_group, info.groupUrl)
        link(R.string.office_about_youtube, info.youtubeUrl)
        link(R.string.office_about_github, info.githubUrl)
        link(R.string.office_about_web, info.webUrl)
        links.visibility = if (links.childCount == 0) View.GONE else View.VISIBLE

        val list = findViewById<LinearLayout>(R.id.officeMembers)
        list.removeAllViews()
        findViewById<View>(R.id.officeTeamLabel).visibility = if (info.members.isEmpty()) View.GONE else View.VISIBLE
        val inflater = LayoutInflater.from(this)
        info.members.forEach { list.addView(memberView(inflater, list, it, (56 * density).toInt())) }
    }

    private fun memberView(inflater: LayoutInflater, parent: LinearLayout, m: Member, avatarPx: Int): View {
        val v = inflater.inflate(R.layout.office_member, parent, false)
        v.findViewById<TextView>(R.id.nameTv).text = m.name.orEmpty()
        v.findViewById<TextView>(R.id.postTv).apply { text = m.post.orEmpty(); visibility = if (m.post.isNullOrBlank()) View.GONE else View.VISIBLE }
        v.findViewById<TextView>(R.id.memberInitials).text = initials(m.name)
        val face = v.findViewById<ImageView>(R.id.faceImage)
        m.imageUrl?.let { url -> ImageLoader.load(url, face, avatarPx) { ok -> face.visibility = if (ok) View.VISIBLE else View.GONE } }
        m.contactUrl?.let { url ->
            v.findViewById<Button>(R.id.contactBtn).apply { visibility = View.VISIBLE; setOnClickListener { open(url) } }
        }
        return v
    }

    private fun setText(id: Int, text: String?) {
        findViewById<TextView>(id).apply { this.text = text; visibility = if (text.isNullOrBlank()) View.GONE else View.VISIBLE }
    }

    private fun openFacebook(info: OfficeInfo) {
        val id = info.facebookPageID
        val hasApp = runCatching { packageManager.getApplicationInfo("com.facebook.katana", 0).enabled }
            .getOrDefault(false)
        open(if (hasApp && !id.isNullOrBlank()) "fb://page/$id" else info.facebookPageUrl!!)
    }

    private fun open(url: String) {
        try {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(this, R.string.office_about_no_app, Toast.LENGTH_SHORT).show()
        }
    }

    companion object {
        const val EXTRA_URL = "officeabout.url"
        const val EXTRA_JSON = "officeabout.json"

        internal fun initials(name: String?): String =
            name.orEmpty().trim().split(Regex("\\s+")).filter { it.isNotEmpty() }.take(2)
                .joinToString("") { it.first().uppercase() }
    }
}
