# Update!!!
A newer, easier & better version of this library can be found here: https://github.com/p32929/MaterialOfficeAbout

# OfficeAbout
A simple about screen library for Android for a Team of people

## Screenshot

<img src="https://user-images.githubusercontent.com/6418354/61729396-e7f8fe80-ad98-11e9-9477-9c0b4f8943ba.png" width="300">

[![](https://badgen.net/github/release/p32929/OfficeAbout)]() [![](https://badgen.net/github/release/p32929/OfficeAbout/stable)]() [![](https://badgen.net/github/tag/p32929/OfficeAbout)]() [![](https://badgen.net/github/watchers/p32929/OfficeAbout)]() [![](https://badgen.net/github/checks/p32929/OfficeAbout)]() [![](https://badgen.net/github/status/p32929/OfficeAbout)]() [![](https://badgen.net/github/stars/p32929/OfficeAbout)]() [![](https://badgen.net/github/forks/p32929/OfficeAbout)]() [![](https://badgen.net/github/issues/p32929/OfficeAbout)]() [![](https://badgen.net/github/open-issues/p32929/OfficeAbout)]() [![](https://badgen.net/github/closed-issues/p32929/OfficeAbout)]() [![](https://badgen.net/github/label-issues/p32929/OfficeAbout/help-wanted/open)]() [![](https://badgen.net/github/prs/p32929/OfficeAbout)]() [![](https://badgen.net/github/open-prs/p32929/OfficeAbout)]() [![](https://badgen.net/github/closed-prs/p32929/OfficeAbout)]() [![](https://badgen.net/github/merged-prs/p32929/OfficeAbout)]() [![](https://badgen.net/github/commits/p32929/OfficeAbout)]() [![](https://badgen.net/github/last-commit/p32929/OfficeAbout)]() [![](https://badgen.net/github/branches/p32929/OfficeAbout)]() [![](https://badgen.net/github/releases/p32929/OfficeAbout)]() [![](https://badgen.net/github/tags/p32929/OfficeAbout)]() [![](https://badgen.net/github/license/p32929/OfficeAbout)]() [![](https://badgen.net/github/contributors/p32929/OfficeAbout)]() [![](https://badgen.net/github/dependents-pkg/p32929/OfficeAbout)]() 

## Share
Sharing with your friends is just one click away from here

[![facebook](https://image.flaticon.com/icons/png/32/124/124010.png)](https://www.facebook.com/sharer/sharer.php?u=https://github.com/p32929/OfficeAbout)
[![twitter](https://image.flaticon.com/icons/png/32/124/124021.png)](https://twitter.com/intent/tweet?source=https://github.com/p32929/OfficeAbout)
[![tumblr](https://image.flaticon.com/icons/png/32/124/124012.png)](https://www.tumblr.com/share?v=3&u=https://github.com/p32929/OfficeAbout)
[![pocket](https://image.flaticon.com/icons/png/32/732/732238.png)](https://getpocket.com/save?url=https://github.com/p32929/OfficeAbout)
[![pinterest](https://image.flaticon.com/icons/png/32/124/124039.png)](https://pinterest.com/pin/create/button/?url=https://github.com/p32929/OfficeAbout)
[![reddit](https://image.flaticon.com/icons/png/32/2111/2111589.png)](https://www.reddit.com/submit?url=https://github.com/p32929/OfficeAbout)
[![linkedin](https://image.flaticon.com/icons/png/32/1409/1409945.png)](https://www.linkedin.com/shareArticle?mini=true&url=https://github.com/p32929/OfficeAbout)
[![whatsapp](https://image.flaticon.com/icons/png/32/733/733585.png)](https://api.whatsapp.com/send?text=https://github.com/p32929/OfficeAbout)

## Support
If you like my works and want to support me/my works, feel free to support or donate. My payment details can be found here: https://p32929.github.io/SendMoney2Me/

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
