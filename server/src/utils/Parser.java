package utils;

import marine.SpaceMarine;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileWriter;
import java.util.ArrayDeque;

public class Parser {

    private Document document;
    private final String path;
    private final MarineBuilder builder;

    public Parser() {
        path = System.getenv().get("XML_PATH");
        //path = "test.xml";
        this.builder = new MarineBuilder();
    }

    public void generate(ArrayDeque<SpaceMarine> marines) throws Exception {
        DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();

        document = documentBuilder.newDocument();
        Element collection = document.createElement("collection");
        document.appendChild(collection);
        for (SpaceMarine marine : marines) {
            Element element = document.createElement("element");
            collection.appendChild(element);

            element.appendChild(createElement("id", marine.getId().toString()));
            element.appendChild(createElement("name", marine.getName()));
            Element coordinates = document.createElement("coordinates");
            element.appendChild(coordinates);
            coordinates.appendChild(createElement("x", String.valueOf(marine.getCoordinates().getX())));
            coordinates.appendChild(createElement("y", String.valueOf(marine.getCoordinates().getY())));
            element.appendChild(createElement("creationDate", marine.getCreationDate().toString()));
            element.appendChild(createElement("health", String.valueOf(marine.getHealth())));
            element.appendChild(createElement("heartCount", marine.getHeartCount().toString()));
            element.appendChild(createElement("loyal", marine.getLoyal().toString()));
            element.appendChild(createElement("weaponType", marine.getWeaponType().toString()));
            Element chapter = document.createElement("chapter");
            element.appendChild(chapter);
            chapter.appendChild(createElement("name", marine.getChapter().getName()));
            chapter.appendChild(createElement("parentLegion", marine.getChapter().getParentLegion()));

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            FileWriter writer = new FileWriter(path);
            transformer.transform(domSource, new StreamResult(writer));
        }
    }

    public ArrayDeque<SpaceMarine> parse() throws Exception {
        ArrayDeque<SpaceMarine> marines = new ArrayDeque<>();
        String fileName = path;
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();

        DefaultHandler handler = new DefaultHandler() {
            String tagName;
            boolean element = false;
            boolean chapter = false;

            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) {
                if (qName.equalsIgnoreCase("element")) {
                    element = true;
                }
                if (qName.equalsIgnoreCase("chapter")) {
                    chapter = true;
                }
                tagName = qName;
            }

            @Override
            public void characters(char[] ch, int start, int length) {
                String str = new String(ch, start, length);
                if (element) {
                    try {
                        switch (tagName) {
                            case "id":
                                builder.setId(str);
                                break;
                            case "name":
                                if (chapter) {
                                    builder.setChapterName(str);
                                } else {
                                    builder.setName(str);
                                }
                                break;
                            case "x":
                                builder.setX(str);
                                break;
                            case "y":
                                builder.setY(str);
                                break;
                            case "creationDate":
                                builder.setCreationDate(str);
                                break;
                            case "health":
                                builder.setHealth(str);
                                break;
                            case "heartCount":
                                builder.setHeartCount(str);
                                break;
                            case "loyal":
                                builder.setLoyal(str);
                                break;
                            case "weaponType":
                                builder.setWeaponType(str);
                                break;
                            case "parentLegion":
                                builder.setParentLegion(str);
                                break;
                            default:

                                break;
                        }
                    } catch (Exception e) {
                        System.out.println("Ошибка при загрущке файла: " + e.getMessage());
                    }
                }
            }

            @Override
            public void endElement(String uri, String localName, String qName) {
                if (qName.equalsIgnoreCase("element")) {
                    element = false;
                    chapter = false;
                    SpaceMarine marine = builder.buildMarine();
                    marines.add(marine);
                }
            }
        };

        saxParser.parse(fileName, handler);
        return marines;
    }

    private Element createElement(String name, String value) {
        Element element = document.createElement(name);
        element.appendChild(document.createTextNode(value));
        return element;
    }
}

