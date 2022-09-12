package com.epam.framework.testCase;

import com.epam.framework.browserSetUp.BrowserSetUp;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HurtMePlenty extends BrowserSetUp {


    private final static String search = "HurtMePlenty.test.data.search";
    private final static String vmClass = "HurtMePlenty.test.data.vmClass";
    private final static String instanceType = "HurtMePlenty.test.data.instanceType";
    private final static String region = "HurtMePlenty.test.data.region";
    private final static String localSSD = "HurtMePlenty.test.data.localSSD";
    private final static String commitmentTerm = "HurtMePlenty.test.data.commitmentTerm";
    private final static String totalCost = "HurtMePlenty.test.data.totalCost";

    @Test
    public void hurtMePlenty(){
        openUrl(googleUrl);
        googleCloudHomePage()
                .searchFieldInput(dataReader(search))
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
                .clickEstimateButton();

        Assert.assertEquals(dataReader(vmClass), googleCloudCalculatorPage().getAssertVMClass().getText());
        Assert.assertEquals(dataReader(instanceType), googleCloudCalculatorPage().getAssertInstanceType().getText());
        Assert.assertEquals(dataReader(region), googleCloudCalculatorPage().getAssertRegion().getText());
        Assert.assertEquals(dataReader(localSSD), googleCloudCalculatorPage().getAssertLocalSSD().getText());
        Assert.assertEquals(dataReader(commitmentTerm), googleCloudCalculatorPage().getAssertCommitmentTerm().getText());
        Assert.assertEquals(dataReader(totalCost), googleCloudCalculatorPage().getAssertTotalCost().getText());
    }

}
