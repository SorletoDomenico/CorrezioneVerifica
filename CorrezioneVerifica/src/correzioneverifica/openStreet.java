/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package correzioneverifica;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author palazzolo_thomas
 */
public class openStreet {

    public openStreet() {

    }

    public static List<Place> getPlaces(String ricerca) throws UnsupportedEncodingException, MalformedURLException, ParserConfigurationException, SAXException, IOException {
        String url = "https://nominatim.openstreetmap.org/search?q=";
        String path = URLEncoder.encode(ricerca, "UTF-8");
        url += path + "&format=xml&addressdetails=1";

        URL fileUrl = new URL(url);

        Element root = getRoot(fileUrl);

        List<Place> tmp = new ArrayList<>();
        NodeList listaDiPlace = root.getElementsByTagName("place");
        int numEl = listaDiPlace.getLength();

        for (int i = 0; i < numEl; i++) {
            Element place = (Element) listaDiPlace.item(i);

            //parsing...
            Place p = parseXMLPlace(place);
            //mi salvo un oggetto Place con tutte le info un una lista
            tmp.add(p);
        }

        return tmp;
    }

    public static Element getRoot(URL url) throws IOException, SAXException, ParserConfigurationException {
        DocumentBuilderFactory factory;
        DocumentBuilder builder;
        Element root, element;
        NodeList nodelist;

        Document document;

        factory = DocumentBuilderFactory.newDefaultInstance();
        builder = factory.newDocumentBuilder();
        document = builder.parse(url.openStream());
        root = document.getDocumentElement();
        return root;
    }

    public static Place parseXMLPlace(Element place) {
        Place p = new Place();

        double lat = Double.parseDouble(place.getAttribute("lat"));
        double lon = Double.parseDouble(place.getAttribute("lon"));

        p.setCity(contenuto(place,"city"));
        p.setTown(contenuto(place,"town"));
        p.setStreet(contenuto(place,"street"));
        p.setCountry(contenuto(place,"country"));
        
        return p;

    }

    private static String contenuto(Element place, String tag) {
        //restituire il contenuto di place con il mio tag
        NodeList listaDiTown = place.getElementsByTagName(tag);
        if (listaDiTown.getLength() != 0) {
            return listaDiTown.item(0).getTextContent();
        }
        return "";
    }

}
