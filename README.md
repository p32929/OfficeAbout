# Update!!!
A newer, easier & better version of this library can be found here: https://github.com/p32929/MaterialOfficeAbout

# OfficeAbout

A drop-in "About us" screen for Android apps built by a team — company logo, social links and a member list, all filled from a JSON file you host. Two lines of code, no layout to write.

## Features

- **JSON-driven** — update the team without shipping an app update
- **Team member list** with photo, name, role and a contact link each
- **Company links** built in: Play Store, Facebook page and group, YouTube, GitHub, website
- **Two lines to integrate** — construct the helper, call `showAboutActivity()`

## Screenshot

<img src="https://user-images.githubusercontent.com/6418354/61729396-e7f8fe80-ad98-11e9-9477-9c0b4f8943ba.png" width="300">

## Installation
Add it in your root build.gradle at the end of repositories:
```gradle
allprojects {
  repositories {
    maven { url 'https://jitpack.io' }
  }
}
```

Add the dependency
```gradle
dependencies {
     implementation 'com.github.p32929:OfficeAbout:1.0.0.7'
}
```

## Usage
* Initialize:

`OfficeAboutHelper officeAboutHelper = new OfficeAboutHelper(this, "https://raw.githubusercontent.com/p32929/SomeHowTosAndTexts/master/Office/OfficeInfo.json");`

* Show about activity:

`officeAboutHelper.showAboutActivity();`

That's it. Simple as ever :)

## JSON
Your JSON data should be somewhat like this:
```json
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

## License

MIT License — Copyright (c) 2019 Fayaz Bin Salam. See [LICENSE](LICENSE) for the full text.

## Contributing

Contributions are warmly welcomed and greatly appreciated! Whether it's a bug fix, new feature, or improvement, your input helps make this project better for everyone.

Before submitting a pull request, please:

1. Create an issue describing the feature or bug fix you'd like to work on
2. Wait for discussion and approval to ensure alignment with project goals
3. Fork the repository and create your feature branch
4. Submit your pull request with a clear description of changes

This approach helps avoid duplicate efforts and ensures smooth collaboration. Thank you for considering contributing!

## Share

Sharing this repository with your friends is just one click away from here

[![facebook](https://user-images.githubusercontent.com/6418354/179013321-ac1d1452-0689-493f-9066-940cf2302b6e.png)](https://www.facebook.com/sharer/sharer.php?u=https://github.com/p32929/OfficeAbout/)
[![twitter](https://user-images.githubusercontent.com/6418354/179013351-7d8d6d1c-4ce2-46ab-bef8-4c4765a1b888.png)](https://twitter.com/intent/tweet?url=https://github.com/p32929/OfficeAbout/)
[![tumblr](https://user-images.githubusercontent.com/6418354/179013343-3111f55a-3b90-40c7-8487-9777348672b0.png)](https://www.tumblr.com/share?v=3&u=https://github.com/p32929/OfficeAbout/)
[![pocket](https://user-images.githubusercontent.com/6418354/179013334-b095c45f-becf-49f4-9ee1-5a731a9b1f85.png)](https://getpocket.com/save?url=https://github.com/p32929/OfficeAbout/)
[![pinterest](https://user-images.githubusercontent.com/6418354/179013331-44cd9206-11b1-4b65-becb-5863b61c828f.png)](https://pinterest.com/pin/create/button/?url=https://github.com/p32929/OfficeAbout/)
[![reddit](https://user-images.githubusercontent.com/6418354/179013338-7416ae3f-73ba-4522-86e1-1374d7082d22.png)](https://www.reddit.com/submit?url=https://github.com/p32929/OfficeAbout/)
[![linkedin](https://user-images.githubusercontent.com/6418354/179013327-ca7b7102-1da8-4b1c-858f-1a6e5f21bd70.png)](https://www.linkedin.com/shareArticle?mini=true&url=https://github.com/p32929/OfficeAbout/)
[![whatsapp](https://user-images.githubusercontent.com/6418354/179013353-f477fa0b-3e6f-4138-a357-c9991b23ff88.png)](https://api.whatsapp.com/send?text=https://github.com/p32929/OfficeAbout/)

---

## Support

If this saved you time, you can buy me a coffee — it keeps these projects maintained and free. Other payment options: https://p32929.github.io/SendMoney2MeV1/

[![Buy Me A Coffee](https://img.shields.io/badge/Buy%20me%20a%20coffee-%E2%98%95-FFDD00?style=for-the-badge&logo=buymeacoffee&logoColor=black)](https://www.buymeacoffee.com/p32929)

<!-- hire-block -->

---

## 💼 Need this customised — or need it yesterday?

I take fixed-price native Android work on my own projects. No hourly billing, no surprise scope:

| | |
|---|---|
| **Drop-in integration** — I wire this into your codebase and hand you a PR that builds | **$45** · 3 days |
| **Priority bug fix or small feature** — jumps ahead of the free issue queue | **$95** · 72 hours |
| **Custom build** — branded, packaged and deployed, source yours | **$130** · 7 days |
| **A full app from scratch** | **from $350** · quoted first |

All prices and how to buy → **[p32929.github.io/hire](https://p32929.github.io/hire/)**  
Or buy through [Fiverr](https://www.fiverr.com/fayazbinsalam) (escrow, ID-verified, 5.0★) — safest for a first job.

Scoping and quotes are free: [open an issue](https://github.com/p32929/hire/issues/new) and describe the job.
