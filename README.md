# GeoNet New Zealand API for Java and Android
API Library written in Java for GeoNet NZ to access information on earthquakes and volcanoes. Please ensure you have
read and understood our Data Policy and Disclaimer before using any of these services on the GeoNet website.

The API is designed to match the documentation on the GeoNet API official documentation (https://api.geonet.org.nz/),
hence I will not write my own documentation.

## Dependencies
* *com.squareup.retrofit2:retrofit2:2.4.0* - RESTful Client used to access the Web Service.
* *com.squareup.retrofit2:converter-gson:2.4.0* - Transforms JSON data into Java Objects via GSON.
* *junit:junit:4.12* - Unit testing.

The Junit library can be completely removed as a dependency if the unit testing Class file is also deleted.

## Features coming soon
* Definitely: Quake CAD Feed Call
* Definitely: Quake CAD Call
* Possibly: FITS API
