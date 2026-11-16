package p32929.officeaboutlib.Others

import android.app.Activity
import android.content.Context
import android.content.Intent
import p32929.officeaboutlib.Activities.OfficeAboutActivity

/**
 * Opens the about screen.
 *
 * Kotlin: `OfficeAboutHelper(this, url).showAboutActivity()`
 * Java:   `new OfficeAboutHelper(this, url).showAboutActivity();`
 */
class OfficeAboutHelper(private val context: Context, private val jsonUrl: String) {

    private var json: String? = null

    fun showAboutActivity() {
        val intent = Intent(context, OfficeAboutActivity::class.java)
            .putExtra(OfficeAboutActivity.EXTRA_URL, jsonUrl)
            .putExtra(OfficeAboutActivity.EXTRA_JSON, json)
        if (context !is Activity) intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        context.startActivity(intent)
    }

    companion object {
        /** Show the screen from a JSON string you already have (an asset, for example) instead of a URL. */
        @JvmStatic
        fun fromJson(context: Context, json: String) = OfficeAboutHelper(context, "").also { it.json = json }
    }
}
