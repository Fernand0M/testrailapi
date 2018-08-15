package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {

    private Properties properties;
    private InputStream inputreader;

    public PropertiesReader() {
        properties = new Properties();

        try {

            inputreader = new FileInputStream("config.properties");

            // load a properties file
            properties.load(inputreader);

            // get the property value and print it out
           // System.out.println(properties.getProperty("labcorpCocBody"));


        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (inputreader != null) {
                try {
                    inputreader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public String getProperty(String key){
        return properties.getProperty(key);
    }

}
