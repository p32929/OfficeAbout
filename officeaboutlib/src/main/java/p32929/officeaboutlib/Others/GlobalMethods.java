package p32929.officeaboutlib.Others;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class GlobalMethods {
    public static Intent openFacebookUrl(Context context, String id) {
        try {
            context.getPackageManager().getPackageInfo("com.facebook.katana", 0);
            return new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/" + id));
        } catch (Exception e) {
            return new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/" + id));
        }
    }

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
}
