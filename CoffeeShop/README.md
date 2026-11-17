# Coffee Shop App

**Difficulty:** Medium | **Platform:** Android (Kotlin, XML)

## Description
- Provides a modern digital platform for browsing artisanal coffee products and placing orders.
- Developed using Kotlin/Java, XML, RecyclerView, and sleek UI/UX design.
- Uses custom Adapters, product listing, cart management, click events, and multi-screen navigation.
- Includes coffee categories, product details, quantity selection, size options, and a shopping cart.

## Features
| Feature | Where it is implemented |
|---|---|
| Product listing (RecyclerView) | `MainActivity.kt`, `ProductAdapter.kt`, `item_product.xml` |
| Coffee categories (filter chips) | `MainActivity.kt`, `activity_main.xml` |
| Click events and navigation | Adapter click lambda, then `Intent` to `DetailActivity` |
| Product details | `DetailActivity.kt`, `activity_detail.xml` |
| Size options (Small / Medium / Large) | `RadioGroup` in `activity_detail.xml` |
| Quantity selection (+ / -) | `DetailActivity.kt` |
| Shopping cart (add, merge, remove, total) | `Models.kt` (`Cart`), `CartActivity.kt`, `CartAdapter.kt` |
| Dark coffee theme | `themes.xml`, `colors.xml` |
| View Binding | `buildFeatures { viewBinding = true }` |

## Screens
1. **Home**: category chips and the product list.
2. **Product Details**: size, quantity, Add to Cart.
3. **Cart**: items, remove, total, Place Order.

## Project structure
```
CoffeeShop/
├── .devcontainer/          # Codespaces setup (Java 17, Gradle, Android SDK)
├── app/
│   ├── build.gradle.kts
│   └── src/main/
│       ├── AndroidManifest.xml
│       ├── java/com/example/coffeeshop/
│       │   ├── Models.kt
│       │   ├── ProductAdapter.kt
│       │   ├── CartAdapter.kt
│       │   ├── MainActivity.kt
│       │   ├── DetailActivity.kt
│       │   └── CartActivity.kt
│       └── res/ (layout, values, drawable)
├── build.gradle.kts
├── settings.gradle.kts
└── gradle.properties
```

## Build in GitHub Codespaces
1. Create a new GitHub repository and upload all files from this folder. Keep the folder structure, including the hidden `.devcontainer` folder.
2. Click **Code > Codespaces > Create codespace on main** (choose the 4-core machine).
3. Wait for setup to finish (about 5 minutes the first time; it installs the Android SDK).
4. In the terminal run:
   ```bash
   gradle assembleDebug
   ```
5. The APK is created at `app/build/outputs/apk/debug/app-debug.apk`.
6. Right-click the APK in the Explorer, choose **Download**, copy it to your Android phone and install it (allow "Install unknown apps").

Codespaces has no emulator, so test the APK on a real phone.

## Using Android Studio instead
Open the folder in Android Studio, let Gradle sync, and press Run.

Download the APK from the Releases section on the right.

## Tech stack
Kotlin, XML layouts, RecyclerView, Material Design 3, View Binding, Gradle (Kotlin DSL)

## Author
Sameeha Sultana, Sridevi Women's Engineering College
