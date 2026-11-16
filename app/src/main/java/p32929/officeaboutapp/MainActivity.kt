package p32929.officeaboutapp

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import p32929.officeaboutlib.Others.OfficeAboutHelper

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.sampleBtn).setOnClickListener {
            val json = assets.open("team.json").bufferedReader().use { it.readText() }
            OfficeAboutHelper.fromJson(this, json).showAboutActivity()
        }
        findViewById<Button>(R.id.urlBtn).setOnClickListener {
            OfficeAboutHelper(this, "https://raw.githubusercontent.com/p32929/SomeHowTosAndTexts/master/Office/OfficeInfo.json")
                .showAboutActivity()
        }
    }
}
