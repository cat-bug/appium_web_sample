package glue;

import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

/**
 * Created by mburunducova on 10/14/2016.
 */
public class Context {
    private static Context instance = new Context();
    private HashMap<String, Object> data = new HashMap<String, Object>();
    private WebDriver driver;
    private Properties properties;
    private String mainUrl;
    private String mobileUrl;
    private String deviceName;
    private String androidVersion;
    private String appiumServerAddress;
    private String browserTimeout;
    private String username;
    private String password;
    private String email;

    private Context() {
        super();

        properties = new Properties();
        try {
            InputStream input = new FileInputStream("config.properties");
            properties.load(input);
            mainUrl = properties.getProperty("url");
            mobileUrl = properties.getProperty("mobile_url");
            deviceName = properties.getProperty("device_name");
            androidVersion = properties.getProperty("android_version");
            appiumServerAddress = properties.getProperty("appium_server_address");
            browserTimeout = properties.getProperty("browser_timeout");
            email = properties.getProperty("email");
            password = properties.getProperty("password");
            username = properties.getProperty("username");

        } catch (IOException ex) {
            System.out.printf(ex.getLocalizedMessage());
        }

    }

    public static Context getInstance() {
        return instance;
    }

    public void save(String key, Object value) {
        data.put(key, value);
    }

    public Object get(String key) {
        return data.get(key);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        getInstance().driver = driver;
    }

    public String getMainUrl() {
        return mainUrl;
    }

    public String getMobileUrl() {
        return mobileUrl;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public String getAndroidVersion() {
        return androidVersion;
    }

    public String getAppiumServerAddress() {
        return appiumServerAddress;
    }

    public String getBrowserTimeout() {
        return browserTimeout;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}
