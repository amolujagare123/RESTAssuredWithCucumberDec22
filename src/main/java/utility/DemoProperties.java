package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DemoProperties {

    public static void main(String[] args) throws IOException {

        // 1. read the file
        FileInputStream fis = new FileInputStream("Config/config.properties");

        // 2. create the object of properties file
        Properties prop = new Properties();

        // 3. load this properties object with file object
        prop.load(fis);

        // 4. get the property value
        System.out.println(prop.getProperty("url"));
    }
}
