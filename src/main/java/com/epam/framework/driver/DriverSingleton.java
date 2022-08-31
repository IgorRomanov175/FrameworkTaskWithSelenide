package com.epam.framework.driver;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Objects;

public class DriverSingleton {

    public static void driverSetUp(String browser){
        if(Objects.equals(System.getProperty("browser"), "edge") || browser.equals("edge")){
            WebDriverManager.edgedriver().setup();
            Configuration.browser = "edge";
            Configuration.driverManagerEnabled = true;
            Configuration.browserSize = "1920x1080";
            Configuration.headless = false;

        } else if(Objects.equals(System.getProperty("browser"), "firefox") || browser.equals("firefox")){
            WebDriverManager.firefoxdriver().setup();
            Configuration.browser = "firefox";
            Configuration.driverManagerEnabled = true;
            Configuration.browserSize = "1920x1080";
            Configuration.headless = false;

        } else if (Objects.equals(System.getProperty("browser"), "chrome") || browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            Configuration.browser = "chrome";
            Configuration.driverManagerEnabled = true;
            Configuration.browserSize = "1920x1080";
            Configuration.headless = false;
        }
    }

}
