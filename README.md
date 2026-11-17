# OfficeAbout

A ready-made "About us" screen for Android apps made by a team. It shows your company name, logo, links and a card for every team member, all filled from one JSON file. You can host the JSON online and change the team without shipping an app update.

## Features

1. **Team cards:** photo (or initials when there is no photo), name, role and a Contact button.
2. **Company links** as chips: Google Play, Facebook page, community group, YouTube, GitHub and website. Links you leave empty are hidden.
3. **JSON from a URL or a string:** load it from the web, or from an asset in your app.
4. **Material 3, light and dark:** it follows the phone's dark mode, and you can give it your own colours.
5. **Loading and error states** with a Try again button.
6. **Small:** written in Kotlin with no image or JSON libraries. Works on Android 5.0 (API 21) and newer.

## Screenshots

<img src="docs/screenshots/light.png" width="280"> <img src="docs/screenshots/dark.png" width="280">

## Install

1. Add JitPack to your repositories (in `settings.gradle.kts`):

```kotlin
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io")
    }
}
```

2. Add the dependency:

```kotlin
dependencies {
    implementation("com.github.p32929:OfficeAbout:2.0.0")
}
```

## Usage

Kotlin:

```kotlin
// From a JSON file you host
OfficeAboutHelper(this, "https://example.com/team.json").showAboutActivity()

// From a JSON string, for example an asset
val json = assets.open("team.json").bufferedReader().use { it.readText() }
OfficeAboutHelper.fromJson(this, json).showAboutActivity()
```

Java:

```java
new OfficeAboutHelper(this, "https://example.com/team.json").showAboutActivity();

OfficeAboutHelper.fromJson(this, json).showAboutActivity();
```

## JSON

Every field is optional. `officeName` and `about` are new in 2.0; the rest is the same as 1.x, so your old JSON still works.

```json
{
  "officeName": "Pixel & Pine Studio",
  "about": "A small team building friendly apps.",
  "officeLogoUrl": "https://example.com/logo.png",
  "googlePlayUrl": "https://play.google.com/store/apps/developer?id=Your+Name",
  "facebookPageUrl": "https://www.facebook.com/yourpage",
  "facebookPageID": "104754327537968",
  "groupUrl": "https://www.facebook.com/groups/yourgroup/",
  "youtubeUrl": "https://www.youtube.com/@yourchannel",
  "githubUrl": "https://github.com/you",
  "webUrl": "https://example.com",
  "members": [
    {
      "imageUrl": "https://example.com/amara.jpg",
      "name": "Amara Rahman",
      "post": "Founder and CEO",
      "contactUrl": "mailto:amara@example.com"
    }
  ]
}
```

If `facebookPageID` is set and the Facebook app is installed, the Facebook chip opens the page in the app.

## Your own colours

The screen uses the theme `Theme.OfficeAbout` (Material 3, DayNight). To use your colours, define a style with the same name in your app:

```xml
<style name="Theme.OfficeAbout" parent="Theme.Material3.DayNight.NoActionBar">
    <item name="colorPrimary">@color/your_primary</item>
</style>
```

The title and labels are normal string resources (`office_about_title`, `office_about_team`, `office_about_contact` and others), so you can change or translate them the same way.

## Migrating from 1.x

1. The two lines you used before still work: `new OfficeAboutHelper(context, url)` and `showAboutActivity()`.
2. Your JSON still works without changes.
3. The library now needs Android 5.0 (API 21) or newer, and an app built with a recent Android Gradle Plugin.
4. `OfficeInfo` and `Member` are plain Kotlin classes now. They are no longer `Parcelable`, but their getters and setters have the same names.
5. The internal classes `OfficeAboutLoader`, `MembersListener`, `GlobalMethods` and `AboutRecyclerviewAdapter` were removed.
6. Picasso, Gson and CircleImageView are no longer pulled into your app.
7. You no longer need a ProGuard rule; the library ships its own.

## Sample app

The `app` module opens the screen with a sample team from `app/src/main/assets/team.json`, or from a JSON URL.

## License

MIT License — Copyright (c) 2019 Fayaz Bin Salam. See [LICENSE](LICENSE) for the full text.

## Contributing

Contributions are very welcome, thank you! Before you start on a pull request, please open an issue and tell me what you would like to add or change. That way we can agree on it first, and your time is not wasted on something that might not fit.

<p><a href="https://p32929.github.io/share/?repo=OfficeAbout"><picture><source media="(prefers-color-scheme: dark)" srcset="https://p32929.github.io/readme/footer-share-dark.svg"><img src="https://p32929.github.io/readme/footer-share-light.svg" width="50%" align="top" alt="Share this project with your friends in one click"></picture></a><a href="https://p32929.github.io/support/"><picture><source media="(prefers-color-scheme: dark)" srcset="https://p32929.github.io/readme/footer-support-dark.svg"><img src="https://p32929.github.io/readme/footer-support-light.svg" width="50%" align="top" alt="If you like my work and want to support me, feel free to support"></picture></a><br><a href="https://openstore.pfay.workers.dev/add"><picture><source media="(prefers-color-scheme: dark)" srcset="https://p32929.github.io/readme/footer-join-dark.svg"><img src="https://p32929.github.io/readme/footer-join-light.svg" width="100%" align="top" alt="Put your own apps on OpenStore: free, your listing lives in your own repo"></picture></a></p>
