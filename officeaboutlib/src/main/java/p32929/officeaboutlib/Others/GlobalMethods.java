package p32929.officeaboutlib.Others;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;

public class GlobalMethods {
    public static boolean isAvailable(String something) {
        if (something == null) {
            return false;
        } else {
            if (something.isEmpty()) {
                return false;
            } else {
                return true;
            }
        }
    }

    public static Intent getFacebookIntent(Context context, String url) {
        PackageManager pm = context.getPackageManager();
        Uri uri = Uri.parse(url);
        try {
            ApplicationInfo applicationInfo = pm.getApplicationInfo("com.facebook.katana", 0);
            if (applicationInfo.enabled) {
                uri = Uri.parse("fb://facewebmodal/f?href=" + url);
            }
        } catch (Exception e) {

        }

        return new Intent(Intent.ACTION_VIEW, uri);
    }
}
