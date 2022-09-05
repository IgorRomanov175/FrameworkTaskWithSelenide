package com.epam.framework.browserSetUp;

import com.codeborne.selenide.Selenide;
import com.epam.framework.driver.DriverSingleton;
import com.epam.framework.pages.GoogleCloudsPages.GoogleCloudCalculatorPage;
import com.epam.framework.pages.GoogleCloudsPages.GoogleCloudHomePage;
import com.epam.framework.pages.GoogleCloudsPages.GoogleCloudSearchPage;
import com.epam.framework.pages.YopmailPage.YopmailPage;
import com.epam.framework.utils.TestDataReader;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BrowserSetUp {

    public final static String googleUrl = "https://cloud.google.com/";

    @Parameters({"browser"})
    @BeforeTest
    public void setUp(String browser){
        DriverSingleton.driverSetUp(browser);
    }

    @AfterTest
    public void tearDown(){
        Selenide.closeWebDriver();
    }

    public void openUrl(String url){
        Selenide.open(url);
    }

    public GoogleCloudHomePage googleCloudHomePage(){
        return new GoogleCloudHomePage();
    }

    public GoogleCloudSearchPage googleCloudSearchPage(){
        return new GoogleCloudSearchPage();
    }

    public GoogleCloudCalculatorPage googleCloudCalculatorPage(){
        return new GoogleCloudCalculatorPage();
    }

    public YopmailPage yopmailPage(){
        return new YopmailPage();
    }

    public String dataReader(String key){
        TestDataReader data = new TestDataReader();
        return data.getTestData(key);
    }
}
