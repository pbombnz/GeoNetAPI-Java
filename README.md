# GeoNet New Zealand API for Java and Android
API Library written in Java for GeoNet NZ to access information on earthquakes and volcanoes. Please ensure you have
read and understood our Data Policy and Disclaimer before using any of these services on the GeoNet website.

The API is designed to match the documentation on the GeoNet API official documentation (https://api.geonet.org.nz/),
hence I will not write my own documentation.

## Dependencies
* Retrofit 2.4.0 - RESTful Client used to access the Web Service.
* Retrofit GSON Converter 2.4.0 - Transforms JSON data into Java Objects via GSON.
* OkHttp 3 Logging interceptor 3.10.0 - Displays debug logs for API Calls.
* Junit 4.12 - Unit testing.

Both *OkHttp 3 Logging interceptor 3.10.0* and/or *Junit 4.12* could be completely removed as dependencies if the
code used to enables OkHttp logging is deleted and/or unit tests class file is also deleted.

## Features coming soon
* Quake CAD Feed Call
* Quake CAD Call

