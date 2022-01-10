package config;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JDBCProperties {
    public String driver;
    public String userName;
    public String password;
    public String urlDB;

    private Properties prop;

    private static final String PROPERTIES_FILE="propertiesFiles/server.xml";

    public JDBCProperties() {
        super();
        this.setProperties(PROPERTIES_FILE);
    }

    /**
     * Assigns XML property values to class attributes

     */
    private void setProperties(String fileName) {
        prop = new Properties();

        try {
            prop.loadFromXML(Files.newInputStream(Paths.get(fileName)));
        } catch (IOException ex) {
            Logger.getLogger(JDBCProperties.class.getName()).log(Level.SEVERE, null, ex);
        }


        this.userName = this.prop.getProperty("user_name");
        this.password = this.prop.getProperty("password");
        this.urlDB = this.prop.getProperty("urlDB");




    }

    public String getDriver() {
        return driver;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getUrlDB() {
        return urlDB;
    }
}
