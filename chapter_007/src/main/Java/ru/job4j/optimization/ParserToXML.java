package ru.job4j.optimization;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

/**
 * Class for parsing data from database to xml.
 *
 */
public class ParserToXML {

    private int[] numbers;

    public ParserToXML(int[] numbers) {
        this.numbers = numbers;
    }

    /**
     * Start parsing.
     * @throws ParserConfigurationException - exception.
     * @throws TransformerException - exception.
     */
    public void startParsing() throws ParserConfigurationException, TransformerException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        Document doc = factory.newDocumentBuilder().newDocument();

        Element entries = doc.createElement("entries");
        doc.appendChild(entries);

        for (int number : numbers) {
            String value = String.valueOf(number);
            entries.appendChild(getEntry(doc, "field", value));
        }
        File xmlFile = new File("src\\\\main\\\\java\\\\\\\\ru\\\\job4j\\\\optimization\\\\resources\\\\1.xml");
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.transform(new DOMSource(doc), new StreamResult(xmlFile));
    }

    /**
     * Create element.
     * @param doc - document.
     * @param name - element name.
     * @param value - element value.
     * @return Node.
     */
    private Node getElement(Document doc, String name, String value) {
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));
        return node;
    }

    /**
     * Return entry node.
     * @param doc - document.
     * @param name - entry name.
     * @param value - entry value.
     * @return Node.
     */
    private Node getEntry(Document doc, String name, String value) {
        Element entry = doc.createElement("entry");
        entry.appendChild(getElement(doc, name, value));
        return entry;
    }
}