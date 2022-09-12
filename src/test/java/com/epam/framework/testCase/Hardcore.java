package com.epam.framework.testCase;

import com.epam.framework.browserSetUp.BrowserSetUp;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Hardcore extends BrowserSetUp {

    private final static String YOPMAIL_URL = "Hardcore.test.data.mail.url";
    private final static String SEARCH = "Hardcore.test.data.search";
    String mailText = "Hardcore.test.data.mail.url.text";

    @Test
    public void hardcore() throws InterruptedException {
        openUrl(googleUrl);
        googleCloudHomePage()
                .searchFieldInput(dataReader(SEARCH))
                .clickSearchElement()
                .switchToFrame(googleCloudCalculatorPage().getCalculatorFrameFirstLayer())
                .switchToFrame(googleCloudCalculatorPage().getCalculatorFrameSecondLayer())
                .computeEngineClick()
                .setNumberOfInstances(dataReader(NUMBER_OF_INSTANCES))
                .setOperatingSystem(dataReader(OPERATING_SYSTEM))
                .setSeries(dataReader(SERIES))
                .setMachineType(dataReader(MACHINE_TYPE))
                .addGPUclick()
                .setGpuType(dataReader(GPU_TYPE))
                .setNumOfGPU(dataReader(NUM_OF_GPU))
                .setLocalSSD(dataReader(LOCAL_SSD))
                .setDatacenterLocation(dataReader(DATACENTER_LOCATION))
                .setCommitmentLocation(dataReader(COMMITMENT_LOCATION))
                .clickEstimateButton()
                .switchToNewWindow(dataReader(YOPMAIL_URL))
                .addMail(dataReader(mailText))
                .switchToFrame(googleCloudCalculatorPage().getCalculatorFrameFirstLayer())
                .switchToFrame(googleCloudCalculatorPage().getCalculatorFrameSecondLayer())
                .mailButtonClick()
                .setMailAddress(dataReader(mailText))
                .refreshMailList();
        Assert.assertEquals("Google Cloud Sales", yopmailPage().assertMailTitle());
        Assert.assertTrue(yopmailPage().assertTotalCost().contains("USD 1,081.20"));

    }

}
