package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {

    static Properties getLoadedPropertiesObject() throws IOException {
        // 1. read the file
        FileInputStream fis = new FileInputStream("Config/config.properties");

        // 2. create the object of properties file
        Properties prop = new Properties();

        // 3. load this properties object with file object
        prop.load(fis);

        return prop;
    }

    public static String getUrl() throws IOException {
        return getLoadedPropertiesObject().getProperty("url");
    }

    public static String getSampleRestUrl() throws IOException {
        return getLoadedPropertiesObject().getProperty("sampleRestUrl");
    }


}
