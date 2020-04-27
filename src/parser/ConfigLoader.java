package parser;

import iitb.shared.XMLConfigs;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public abstract class ConfigLoader {
    // absolute path to configuration folder (only for build. Not works with jar artifact)
    private static final String configFolder = "/Users/vladislav.tupikin/Desktop/UnitTagger/configs/";

    public static Element loadConfig(String configName) throws IOException, SAXException, ParserConfigurationException {
        return XMLConfigs.load(new InputSource(ConfigLoader.getResourceStream(configName)));
    }

    public static InputStream getResourceStream(String path) throws FileNotFoundException {
        // TODO For JAR uncomment the next line
        // return ClassLoader.class.getResourceAsStream(path);

        var absolutePath = ConfigLoader.getAbsolutePath(path);

        return new FileInputStream(absolutePath);
    }

    private static String getAbsolutePath(String relativePath) {
        return ConfigLoader.configFolder + relativePath;
    }
}
