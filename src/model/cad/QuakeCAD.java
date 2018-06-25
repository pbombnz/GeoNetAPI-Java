package model.cad;

import com.tickaroo.tikxml.annotation.Attribute;
import com.tickaroo.tikxml.annotation.Element;
import com.tickaroo.tikxml.annotation.PropertyElement;
import com.tickaroo.tikxml.annotation.Xml;

import java.util.List;

@Xml(name = "alert"/*, writeNamespaces = {"urn:oasis:names:tc:emergency:cap:1.2"}*/)
public class QuakeCAD {
    @Attribute
    String xmlns;

    @PropertyElement
    String identify;

    @PropertyElement
    String sender;

    @PropertyElement
    String status;

    @PropertyElement
    String msgType;

    @PropertyElement
    String scope;

    @Element
    QuakeCAD.Info info;

    @Xml
    public static class Info {
        @PropertyElement
        String language;

        @PropertyElement
        String category;

        @PropertyElement
        String event;

        @PropertyElement
        String responseType;

        @PropertyElement
        String urgency;

        @PropertyElement
        String severity;

        @PropertyElement
        String certainty;

        @PropertyElement(name = "onset")
        String onSet;

        @PropertyElement
        String expires;

        @PropertyElement
        String senderName;

        @PropertyElement
        String headline;

        @PropertyElement
        String description;

        @PropertyElement
        String instruction;

        @PropertyElement
        String web;

        @PropertyElement
        String contact;

        @Element
        List<QuakeCAD.Info.Parameter> parameter;

        @Element
        QuakeCAD.Info.Area area;

        @Xml
        public static class Parameter {
            @PropertyElement
            String valueName;

            @PropertyElement
            String value;
        }

        @Xml
        public static class Area {
            @PropertyElement
            String areaDesc;

            @PropertyElement
            String circle;
        }
    }
}
