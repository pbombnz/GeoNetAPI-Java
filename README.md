# ![GeoNet NZ Logo](https://www.geonet.org.nz/assets/images/quake-apple-icon-57x57.png) GeoNet New Zealand API for Java and Android
API Library written in Java for GeoNet NZ to access information on earthquakes and volcanoes. Please ensure you have
read and understood GeoNet NZ's [Data Policy](https://www.geonet.org.nz/policy) and [Disclaimer](https://www.geonet.org.nz/disclaimer) 
before using any of these services.

The API is designed to match the documentation on the [GeoNet API official documentation](https://api.geonet.org.nz/),
hence I will not write my own documentation, although javadocs have been created.

## Dependencies
* *com.squareup.retrofit2:retrofit2:2.4.0* - RESTful Client used to access the Web Service.
* *com.squareup.retrofit2:converter-gson:2.4.0* - Transforms JSON data into Java Objects via GSON.
* *com.tickaroo.tikxml:annotation:0.8.13* - Transforms XML data in Java Objects.
* *com.tickaroo.tikxml:core:0.8.13* - - Transforms XML data in Java Objects.
* *com.tickaroo.tikxml:processor:0.8.13* - Transforms XML data in Java Objects. Annotation processing must be enabled in IDE.
* *junit:junit:4.12* - Unit testing.

## Why TikXML?
Although SimpleXML is more well known and the API is will documented, it is deprecated when used with Retrofit2 due to 
the number of CVEs, hence chose to use an alternative that seems viable, known as TikXML. Additionally, TikXML uses less 
memory and has faster processing.

For more documentation on TikXML, [click here](https://github.com/Tickaroo/tikxml/blob/master/docs/AnnotatingModelClasses.md)

## Issues
### CAD APIs not working
Although both the Quake CAD Feed and Quake CAD calls exists in the library, they will not work if a feed item exists. 
At the moment it is unclear how feed items results are presented in XML hence cannot complete the CAD model classes.
Additionally, the API documentation is very vaugue on the output expected.

Tragically, I guess I have to wait for a major earthquake to finish coding these API calls.

## Upcoming
* Possibly GeoNet FITS API
