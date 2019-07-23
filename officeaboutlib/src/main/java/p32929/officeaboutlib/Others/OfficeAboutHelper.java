package p32929.officeaboutlib.Others;

import android.content.Context;
import android.content.Intent;

import p32929.officeaboutlib.Activities.OfficeAboutActivity;

public class OfficeAboutHelper {
    Context context;
    String jsonUrl;

    public OfficeAboutHelper(Context context, String jsonUrl) {
        this.context = context;
        this.jsonUrl = jsonUrl;

        OfficeAboutActivity.jsonUrl = jsonUrl;
    }

    public void showAboutActivity() {
        context.startActivity(new Intent(context, OfficeAboutActivity.class));
    }
}
