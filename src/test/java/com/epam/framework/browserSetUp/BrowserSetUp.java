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

    public final static String NUMBER_OF_INSTANCES = "Settings.test.data.numberOfInstances";
    public final static String OPERATING_SYSTEM = "Settings.test.data.operatingSystem";
    public final static String SERIES = "Settings.test.data.series";
    public final static String MACHINE_TYPE = "Settings.test.data.machineType";
    public final static String GPU_TYPE = "Settings.test.data.GPUType";
    public final static String NUM_OF_GPU = "Settings.test.data.numOfGPU";
    public final static String LOCAL_SSD = "Settings.test.data.localSSD";
    public final static String DATACENTER_LOCATION = "Settings.test.data.datacenterLocation";
    public final static String COMMITMENT_LOCATION = "Settings.test.data.commitmentLocation";

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
