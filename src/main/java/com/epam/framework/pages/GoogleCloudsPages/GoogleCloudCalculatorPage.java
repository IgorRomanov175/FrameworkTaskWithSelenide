package com.epam.framework.pages.GoogleCloudsPages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.epam.framework.pages.YopmailPage.YopmailPage;
import com.epam.framework.pages.toolsForPages.Tools;
import lombok.Getter;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;

import static com.codeborne.selenide.Selenide.*;
import static com.epam.framework.pages.toolsForPages.Tools.*;

@Getter
public class GoogleCloudCalculatorPage {

    private final SelenideElement waitSetOperationSystem = $x("//md-select[@ng-model=\"listingCtrl.computeServer.os\"]");
    private final SelenideElement calculatorFrameFirstLayer = $x("//iframe[@src='https://cloud.google.com/products/calculator/index_d6a98ba38837346d20babc06ff2153b68c2990fa24322fe52c5f83ec3a78c6a0.frame?hl=sv']");
    private final SelenideElement calculatorFrameSecondLayer = $x("//iframe[@id='myFrame']");
    private final SelenideElement computeEngine = $x("//div[text()='Compute Engine']");
    private final SelenideElement numberOfInstances = $x("//label[contains(text(), 'Number of instances')]/following-sibling::input");
    private final SelenideElement operatingSystemSpan = $x("//label[contains(text() , 'Operating System / Software')]/following-sibling::md-select");
    private final ElementsCollection operatingSystemAnswer = $$x("//div[contains(text() , 'Free: Debian')]/parent::md-option/parent::md-content/md-option/div");
    private final SelenideElement seriesSpan = $x("//label[contains(text(), 'Series')]/following-sibling::md-select");
    private final ElementsCollection seriesAnswer = $$x("//div[contains(text(), 'N1')]/parent::md-option/parent::md-content/md-option");
    private final SelenideElement machineTypeSpan = $x("//label[contains(text(), 'Machine type')]/following-sibling::md-select");
    private final ElementsCollection machineTypeAnswer = $$x("//label[contains(text(), 'standard')]/following-sibling::md-option/div");
    private final SelenideElement addGPU = $x("(//div[@ng-transclude])[3]");
    private final SelenideElement gpuTypeSpan = $x("//md-select[@placeholder='GPU type']");
    private final ElementsCollection gpuTypeAnswer = $$x("//div[contains(text(), 'NVIDIA Tesla K80')]/parent::md-option/parent::md-content/md-option");
    private final SelenideElement numOfGPUSpan = $x("//md-select[@placeholder='Number of GPUs']");
    private final ElementsCollection numOfGPUAnswer = $$x("//md-option[@ng-disabled='item.value != 0 && item.value < listingCtrl.minGPU']/div");
    private final SelenideElement localSSDSpan = $x("//md-select[@ng-model='listingCtrl.computeServer.ssd']");
    private final ElementsCollection localSSDAnswer = $$x("//div[contains(text(), '2x375')]/parent::md-option/parent::md-content/md-option/div");
    private final SelenideElement datacenterLocationSpan = $x("//md-select[@ng-model='listingCtrl.computeServer.location']");
    private final ElementsCollection datacenterLocationAnswer = $$x("//md-option[@ng-repeat='item in listingCtrl.fullRegionList | filter:listingCtrl.inputRegionText.computeServer']");
    private final SelenideElement commitedLocationSpan = $x("//md-select[@ng-disabled='listingCtrl.isCudDisabled']");
    private final SelenideElement commitedLocationWaiter = $x("//div[@class='md-select-menu-container md-active md-clickable']//div[text()='None']");
    private final ElementsCollection commitedLocationAnswer = $$x("//div[@class='md-select-menu-container md-active md-clickable']//md-option/div");
    private final SelenideElement estimateButton = $x("//button[@aria-label='Add to Estimate']");
    private final SelenideElement assertVMClass = $x("//md-content[@id='compute']//span[text()='Compute Engine']");
    private final SelenideElement assertInstanceType = $x("//sub[@ng-if='item.items.isInstanceCommitted']/parent::div/parent::div");
    private final SelenideElement assertRegion = $x("(//md-list-item//div[@class='md-list-item-text ng-binding'])[1]");
    private final SelenideElement assertCommitmentTerm = $x("(//md-list-item//div[@class='md-list-item-text ng-binding'])[3]");
    private final SelenideElement assertLocalSSD = $x("//sub[@ng-if='item.items.isSsdCommitted']/parent::div/parent::div");
    private final SelenideElement assertTotalCost = $x("//h2[@class='md-title']/b");
    private final SelenideElement mailButton = $x("//button[@ng-click='cloudCartCtrl.showEmailForm();']");
    private final SelenideElement mailAddress = $x("//input[@ng-model='emailQuote.user.email']");
    private final SelenideElement sendEmail = $x("//button[@ng-click='emailQuote.emailQuote(true); emailQuote.$mdDialog.hide()']");

    public GoogleCloudCalculatorPage switchToFrame(WebElement frame){
        switchTo().frame(frame);
        return this;
    }

    public GoogleCloudCalculatorPage computeEngineClick(){
        computeEngine.click();
        return this;
    }

    public GoogleCloudCalculatorPage setNumberOfInstances(String text){
        numberOfInstances.click();
        numberOfInstances.sendKeys(text);
        return this;
    }

    public GoogleCloudCalculatorPage setOperatingSystem(String operatingSystem){
        operatingSystemSpan.click();
        operatingSystemAnswer.get(getInstanceForName(operatingSystemAnswer, operatingSystem)).click();
        numberOfInstances.scrollIntoView(true);
        return this;
    }

    public GoogleCloudCalculatorPage setSeries(String series) {
        seriesSpan.click();
        seriesAnswer.get(getInstanceForName(seriesAnswer, series)).click();
        return this;
    }

    public GoogleCloudCalculatorPage setMachineType(String machineType) {
        machineTypeSpan.click();
        machineTypeAnswer.get(getInstanceForName(machineTypeAnswer, machineType)).click();
        return this;
    }

    public GoogleCloudCalculatorPage addGPUclick(){
        addGPU.click();
        seriesSpan.scrollIntoView(true);
        return this;
    }

    public GoogleCloudCalculatorPage setGpuType(String gpuType){
        gpuTypeSpan.click();
        gpuTypeAnswer.get(getInstanceForName(gpuTypeAnswer, gpuType)).click();
        return this;
    }

    public GoogleCloudCalculatorPage setNumOfGPU(String numOfGPU){
        numOfGPUSpan.click();
        setNumberOfGPU(numOfGPU).click();
        addGPU.scrollIntoView(true);
        return this;
    }

    public GoogleCloudCalculatorPage setLocalSSD(String localSSD){
        localSSDSpan.click();
        localSSDAnswer.get(getInstanceForName(localSSDAnswer, localSSD)).click();
        return this;
    }

    public GoogleCloudCalculatorPage setDatacenterLocation(String datacenterLocation){
        datacenterLocationSpan.click();
        datacenterLocationAnswer.get(getInstanceForName(datacenterLocationAnswer, datacenterLocation)).click();
        return this;
    }

    public GoogleCloudCalculatorPage setCommitmentLocation(String commitmentLocation){
        commitedLocationSpan.click();
        setYearCommitment(commitmentLocation).click();
        return this;
    }

    public GoogleCloudCalculatorPage clickEstimateButton(){
        estimateButton.click();
        return this;
    }

    public YopmailPage switchToNewWindow(String url){
        switchTo().newWindow(WindowType.TAB);
        Selenide.open(url);
        return new YopmailPage();
    }

    public GoogleCloudCalculatorPage mailButtonClick(){
        mailButton.click();
        return this;
    }

    public YopmailPage setMailAddress(String mail) throws InterruptedException {
        mailAddress.click();
        mailAddress.sendKeys(mail + "@yopmail.com", Keys.ENTER);
        mailAddress.scrollIntoView(true);
        sendEmail.click();
        switchTo().window(1);
        Thread.sleep(10000);
        return new YopmailPage();
    }

}
