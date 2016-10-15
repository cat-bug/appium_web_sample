package glue;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by mburunducova on 10/14/2016.
 */
public class Hooks {

    @Before
    public void setUp() throws MalformedURLException {
        //tutorial:
        //http://www.software-testing-tutorials-automation.com/2015/09/steps-to-download-and-install-android.html

        // Created object of DesiredCapabilities class.
        DesiredCapabilities capabilities = new DesiredCapabilities();

        // Set android deviceName desired capability. Set your device name.
        capabilities.setCapability("deviceName", Context.getInstance().getDeviceName());

        // Set BROWSER_NAME desired capability. It's Android in our case here.
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "Chrome");

        // Set android VERSION desired capability. Set your mobile device's OS version.
        capabilities.setCapability(CapabilityType.VERSION, Context.getInstance().getAndroidVersion());

        // Set android platformName desired capability. It's Android in our case here.
        capabilities.setCapability("platformName", "Android");

        // Set android appPackage desired capability.
        capabilities.setCapability("appPackage", "com.android.chrome");

        // Set android appActivity desired capability.
        capabilities.setCapability("appActivity", "com.google.android.apps.chrome");

        // Created object of RemoteWebDriver will all set capabilities.
        // Set appium server address and port number in URL string.
        Context.getInstance().setDriver(new RemoteWebDriver(new URL(Context.getInstance().getAppiumServerAddress()),
                capabilities));
        Context.getInstance().getDriver().manage().timeouts().implicitlyWait(Integer.parseInt(Context.getInstance()
                .getBrowserTimeout()), TimeUnit.SECONDS);
//        Context.getInstance().getDriver().manage().timeouts().pageLoadTimeout(8, TimeUnit.SECONDS);
    }

    @After
    public void tearDown(){
        Context.getInstance().getDriver().quit();

    }
}
