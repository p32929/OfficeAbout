package p32929.officeaboutapp;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import p32929.officeaboutlib.Others.OfficeAboutHelper;

public class MainActivity extends AppCompatActivity {

    OfficeAboutHelper officeAboutHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        officeAboutHelper = new OfficeAboutHelper(this, "https://raw.githubusercontent.com/p32929/SomeHowTosAndTexts/master/Office/OfficeInfo.json");
        officeAboutHelper.showAboutActivity();
    }

    public void showAboutActivity(View view) {
        officeAboutHelper.showAboutActivity();
    }
}
