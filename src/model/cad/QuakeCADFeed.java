package model.cad;

import com.tickaroo.tikxml.annotation.*;

@Xml(name="feed"/*, writeNamespaces= {"w3.org/2005/Atom"}*/) // Namespace disabled as it is known bug.
public class QuakeCADFeed {
    @Attribute
    String xmlns;

    @PropertyElement
    String id;

    @PropertyElement
    String title;

    @PropertyElement
    String updated;

    @Element(name = "author")
    QuakeCADFeed.Author author;

    @Element(name = "link")
    QuakeCADFeed.Link link;

    public QuakeCADFeed() {
    }

    @Override
    public String toString() {
        return "QuakeCADFeed{" +
                ", id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", updated='" + updated + '\'' +
                ", author=" + author +
                ", link=" + link +
                '}';
    }

    @Xml
    public static class Author {
        @PropertyElement
        String name;

        @PropertyElement
        String email;

        @PropertyElement
        String uri;

        @Override
        public String toString() {
            return "{" +
                    "name='" + name + '\'' +
                    ", email='" + email + '\'' +
                    ", uri='" + uri + '\'' +
                    '}';
        }
    }

    @Xml
    public static class Link {
        @Attribute
        String rel;

        @Attribute
        String href;

        @Override
        public String toString() {
            return "{" +
                    "rel='" + rel + '\'' +
                    ", href='" + href + '\'' +
                    '}';
        }
    }
}
