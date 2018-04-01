package ru.job4j.optimization;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

/**
 * Class for converting xml file.
 */
public class XMLtoXSL {
    /**
     * Convert xml file.
     */
    public void convertXML() {
        try {
            TransformerFactory ttf = TransformerFactory.newInstance();
            Transformer tf = ttf.newTransformer(new StreamSource(new File("src\\main\\java\\ru\\job4j\\optimization\\resources\\converter.xsl")));
            StreamSource ss = new StreamSource(new File("src\\main\\java\\ru\\job4j\\optimization\\resources\\1.xml"));
            StreamResult sr = new StreamResult(new File("src\\main\\java\\ru\\job4j\\optimization\\resources\\2.xml"));
            tf.transform(ss, sr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
