package p32929.officeaboutlib.Models

import org.json.JSONObject

/** One person on the team. Same fields as the 1.x JSON. */
class Member(
    var imageUrl: String? = null,
    var name: String? = null,
    var post: String? = null,
    var contactUrl: String? = null,
)

/**
 * Everything the about screen shows. The JSON format is the same as 1.x;
 * [officeName] and [about] are new and optional.
 */
class OfficeInfo(
    var officeName: String? = null,
    var about: String? = null,
    var officeLogoUrl: String? = null,
    var googlePlayUrl: String? = null,
    var facebookPageUrl: String? = null,
    var facebookPageID: String? = null,
    var groupUrl: String? = null,
    var youtubeUrl: String? = null,
    var githubUrl: String? = null,
    var webUrl: String? = null,
    var members: ArrayList<Member> = ArrayList(),
) {
    companion object {
        @JvmStatic
        fun fromJson(json: String): OfficeInfo {
            val o = JSONObject(json)
            fun JSONObject.str(key: String) = optString(key).takeIf { it.isNotBlank() && it != "null" }
            val list = ArrayList<Member>()
            o.optJSONArray("members")?.let { arr ->
                for (i in 0 until arr.length()) {
                    val m = arr.optJSONObject(i) ?: continue
                    list += Member(m.str("imageUrl"), m.str("name"), m.str("post"), m.str("contactUrl"))
                }
            }
            return OfficeInfo(
                o.str("officeName"), o.str("about"), o.str("officeLogoUrl"), o.str("googlePlayUrl"),
                o.str("facebookPageUrl"), o.str("facebookPageID"), o.str("groupUrl"),
                o.str("youtubeUrl"), o.str("githubUrl"), o.str("webUrl"), list,
            )
        }
    }
}
