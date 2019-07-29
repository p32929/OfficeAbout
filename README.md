# OfficeAbout
A simple about screen library for Android for a Team of people

## Screenshot

<img src="https://user-images.githubusercontent.com/6418354/61729396-e7f8fe80-ad98-11e9-9477-9c0b4f8943ba.png" width="300">

## Installation
Add it in your root build.gradle at the end of repositories:
```
allprojects {
  repositories {
    maven { url 'https://jitpack.io' }
  }
}
```

Add the dependency
```
dependencies {
     implementation 'com.github.p32929:OfficeAbout:1.0.0.2'
}
```

# Usage:
* Initialize:

`OfficeAboutHelper officeAboutHelper = new OfficeAboutHelper(this, "https://raw.githubusercontent.com/p32929/SomeHowTosAndTexts/master/Office/OfficeInfo.json");`

* Show about activity:

`officeAboutHelper.showAboutActivity();`

That's it. Simple as ever :)

# JSON
Your JSON data should be somewhat like this:
```
{
    "officeLogoUrl": "http://pngimg.com/uploads/google/google_PNG19635.png",
    "googlePlayUrl": "https://play.google.com/store/apps/developer?id=p32929",
    "facebookUrl": "https://www.facebook.com/p32929",
    "groupUrl": "https://www.facebook.com/p32929",
    "youtubeUrl": "https://www.youtube.com/user/marquesbrownlee",
    "githubUrl": "http://github.com/p32929",
    "webUrl": "https://p32929.github.io/Portfolio/",
    "members": [
        {
            "imageUrl": "https://scontent.fcgp3-1.fna.fbcdn.net/v/t1.0-9/61069086_2465569913454726_6242359099263025152_n.jpg?_nc_cat=100&_nc_eui2=AeE08W4JxHQM5kdcBSu_DMnyQhiOIeVI7htWSilF60wOqofAU5lz6mD6cEi0j4Ffw-cIKMF0PyZJ6o9NcI4wbXxTykihh0CdDLMk5P6P5hm3AA&_nc_oc=AQklh0l53rvvGnV6yu1on1aQPKphOIWhWwOAZZfk5A4nyP0cxYvAOECJzZioFRDzS3s&_nc_ht=scontent.fcgp3-1.fna&oh=3014624cc68591b9822150ccdd80e739&oe=5DE20B4A",
            "name": "Fayaz Bin Salam",
            "post": "Founder & CEO",
            "contactUrl": "https://www.facebook.com/p32929"
        },
        {
            "imageUrl": "https://scontent.fcgp3-1.fna.fbcdn.net/v/t1.0-1/c2.0.960.960a/p960x960/67244969_2416711698412352_616770845737484288_o.jpg?_nc_cat=100&_nc_eui2=AeEgwJv2z1nDfglLKRc1jhq39kOr1vO5nBBdU7uGZ-bpKsd9F7sBPHrG9hHd8ktl5bbRC1c7MX-OWRYuciboIfkrJ6US0WpxdpBleSpnsAa8BQ&_nc_oc=AQlXlAeXrnroazeWxkFR8Fla2eC_otrTCdnIAsA8sMvIJPQmJN1cVBFsO2L0_TqRGfM&_nc_ht=scontent.fcgp3-1.fna&oh=31700ed8c2b38ed36be2b8cea639c564&oe=5DB4D041",
            "name": "Farhaz Bin Salam",
            "post": "Marketing Manager",
            "contactUrl": "https://www.facebook.com/Farhaz22"
        },
        {
            "imageUrl": "https://scontent.fcgp3-1.fna.fbcdn.net/v/t1.0-9/46777067_975546439306795_6539865831679983616_n.jpg?_nc_cat=104&_nc_eui2=AeE1b19hE_bVIlQHknLH7ZR6AR1IBMiIskSOSZyHyO-EkO5o2ZlM2fbFMobzDHDtTaG-XwgHqRFJLUT_tRZZXZy_wN2EpKoz9NtJSZ1uhvSVKA&_nc_oc=AQnJEEPwcOuweeNQY9yEj6d14vT1EajIaYVU9Ljaf0bk832yY1Cmjsg4jByKLUe7dDg&_nc_ht=scontent.fcgp3-1.fna&oh=52cfb1d2de7b12990c114359bea0f5d6&oe=5DE20AD3",
            "name": "Fahim Bin Lokman",
            "post": "Software Developer",
            "contactUrl": "https://www.facebook.com/fahim.ezio"
        },
        {
            "imageUrl": "https://scontent.fcgp3-1.fna.fbcdn.net/v/t1.0-9/31087202_1723265177721867_5594483950044053504_n.jpg?_nc_cat=110&_nc_eui2=AeHdQZkWhQqcQCAEhNoyy9Me_NRtuJEszzLUrn1mPoPbMn_usrMDfrUicnKK1zZNOMtkAy_ewG_nqpB9_l2Nfa5vMzQcnpKFtR1A78rMemzCkw&_nc_oc=AQnUUhMOuUrrNwUWvr-IA4KZjJu_IACzrurEkx7MbRZyMlE_bVmPLEQktNY-PZ02M5g&_nc_ht=scontent.fcgp3-1.fna&oh=4b80dd97387fbaf7ce394ff253673156&oe=5DE891CD",
            "name": "Farhan Sayed",
            "post": "UI/UX Designer",
            "contactUrl": "https://www.facebook.com/profile.php?id=100001152043426"
        }
    ]
}
```

And lastly, if you're using pro-guard, add these lines in your app `proguard-rules.pro` file:

`-keep public class p32929.officeaboutlib.Models.** { *; }`

# LICENSE
```
MIT License

Copyright (c) 2019 Fayaz Bin Salam

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

```