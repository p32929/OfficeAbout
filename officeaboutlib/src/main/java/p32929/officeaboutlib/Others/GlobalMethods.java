package p32929.officeaboutlib.Others;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;

import p32929.officeaboutlib.Models.OfficeInfo;

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

    public static Intent getFacebookPageIntent(Context context, OfficeInfo officeInfo) {
        PackageManager pm = context.getPackageManager();
        Uri uri = Uri.parse(officeInfo.getFacebookPageUrl());
        try {
            ApplicationInfo applicationInfo = pm.getApplicationInfo("com.facebook.katana", 0);
            if (applicationInfo.enabled) {
                uri = Uri.parse("fb://page/" + officeInfo.getFacebookPageID());
            }
        } catch (Exception e) {
            //
        }

        return new Intent(Intent.ACTION_VIEW, uri);
    }
}
