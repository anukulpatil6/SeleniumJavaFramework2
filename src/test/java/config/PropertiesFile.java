package config;

import test.TestNG_DEMO_PropertiesFile;

import java.io.*;
import java.util.Properties;

public class PropertiesFile {
    static Properties prop = new Properties();
    static String projectpath = System.getProperty("user.dir");

    public static void main(String[] args) {
        getProperties();
        setProperties();
        getProperties();
    }

    public static void getProperties() {


        try {

            InputStream input = new FileInputStream(projectpath + "\\src\\test\\java\\config\\config.properties");
            prop.load(input);
            String browser = prop.getProperty("browser");
            System.out.println(browser);
            TestNG_DEMO_PropertiesFile.browsername = browser;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    public static void setProperties() {
        try {
            OutputStream output = new FileOutputStream(projectpath + "\\src\\test\\java\\config\\config.properties");
            prop.setProperty("result","pass");
            prop.store(output,"null");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
