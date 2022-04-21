# Crypto

Investing cryptocurrencies could make you a millionaire within one year or even several months. CryptoCoin is intended for users who are interested in cryptocurrency market and/or investment. You can get both real time and historical market changes of cryptocurrencies from this app.

## Features

* Monitor the cryptocurrency market
* Get the latest updates on you favorite cryptocurrencies
* Check the historical data of selected cryptocurrencies
* Add targeted cryptocurrencies into the list

## Dependencies

* [Moshi](https://github.com/square/moshi)
* [Okhttp](https://github.com.square/okhttp)
* [Picasso](https://github.com/square/picasso)
* [Coroutines](https://github.com/Kotlin/kotlinx.coroutines)
* [Koin](https://github.com/InsertKoinIO/koin)
* [MPAndroidChart](https://github.com/PhilJay/MPAndroidChart)
* [Timber](https://github.com/JakeWharton/timber)

## Screenshots

<img src="../master/screenshots/3.jpg" alt="alt text" width="250"> <img src="../master/screenshots/4.jpg" alt="alt text" width="250"> <img src="../master/screenshots/1.jpg" alt="alt text" width="250"> <img src="../master/screenshots/2.jpg" alt="alt text" width="250"> 

## How To Install

This project uses the Gradle build system. To build this project, use the "gradlew build" command or use "Import Project" in Android Studio. 

This app uses [CoinMarketCap API](https://coinmarketcap.com/api/) to retrieve Cryptocurrencies. You must provide your own API key in order to build the app. 
To get the API Key you have you register on CoinMarketCap website.
When you get the API Key you have to add you API Key in local.properties as given below:

    api_key = your api key

Make sure that your app level build.gradle have these code present in defaultConfig field to read the API Key from local.properties:

    Properties properties = new Properties()
    properties.load(project.rootProject.file('local.properties').newDataInputStream())

    buildConfigField "String", "API_KEY", "\"${properties.getProperty('api_key')}\""


