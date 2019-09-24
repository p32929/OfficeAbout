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
     implementation 'com.github.p32929:OfficeAbout:1.0.0.7'
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
    "officeLogoUrl": "https://user-images.githubusercontent.com/6418354/62771043-1af00180-babe-11e9-8830-7904a358ccc0.png",
    "googlePlayUrl": "https://play.google.com/store/apps/developer?id=Rich+IT",
    "facebookPageUrl": "https://www.facebook.com/rich.it.ctg",
    "facebookPageID": "104754327537968",
    "groupUrl": "https://www.facebook.com/groups/518485748694084/",
    "youtubeUrl": "https://www.youtube.com/user/marquesbrownlee",
    "githubUrl": "http://github.com/p32929",
    "webUrl": "https://p32929.github.io/Portfolio/",
    "members": [
        {
            "imageUrl": "https://avatars1.githubusercontent.com/u/6418354?s=460&v=4",
            "name": "Fayaz Bin Salam",
            "post": "Founder & CEO",
            "contactUrl": "https://www.facebook.com/p32929"
        },
        {
            "imageUrl": "https://user-images.githubusercontent.com/6418354/62595278-92c3fd80-b8ff-11e9-89b1-8a4b0d3fbae4.jpg",
            "name": "Arfatul Mowla Shuvo",
            "post": "Software Developer",
            "contactUrl": "https://www.facebook.com/mowla.shuvo"
        },
        {
            "imageUrl": "https://user-images.githubusercontent.com/6418354/62595308-b25b2600-b8ff-11e9-86e1-5d58cb1a6cac.JPG",
            "name": "Masrur Mehedi",
            "post": "Software Developer",
            "contactUrl": "https://www.facebook.com/masrorulhoque.mehedi.1"
        },
        {
            "imageUrl": "https://user-images.githubusercontent.com/6418354/62595290-a0798300-b8ff-11e9-9b78-ea9262f4bf94.JPG",
            "name": "Xenon",
            "post": "Software Developer",
            "contactUrl": "https://www.facebook.com/plabon.shuvo1"
        },
        {
            "imageUrl": "https://user-images.githubusercontent.com/6418354/62595321-bdae5180-b8ff-11e9-8b44-3378b8a88ce3.jpg",
            "name": "Misbah",
            "post": "Software Developer",
            "contactUrl": ""
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