package com.epam.framework.pages.YopmailPage;

import com.codeborne.selenide.SelenideElement;
import com.epam.framework.pages.GoogleCloudsPages.GoogleCloudCalculatorPage;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.switchTo;

public class YopmailPage {

    private final SelenideElement mailTitle = $x("//span[text()='Google Cloud Sales']");
    private final SelenideElement totalCost = $x("//h3[contains(text(), 'USD 1,081.20')]");
    private final SelenideElement refresh = $x("//button[@id='refresh']");
    private final SelenideElement frameMailList = $x("//iframe[@id='ifinbox']");
    private final SelenideElement frameMailText = $x("//iframe[@id='ifmail']");
    private final SelenideElement addNewMail = $x("//input[@class='ycptinput']");

    public GoogleCloudCalculatorPage addMail(String text){
        addNewMail.setValue(text);
        addNewMail.sendKeys(Keys.ENTER);
        switchTo().window(0);
        return new GoogleCloudCalculatorPage();
    }

    public YopmailPage refreshMailList(){
        refresh.click();
        return this;
    }

    public String assertMailTitle(){
        switchTo().frame(frameMailList);
        return mailTitle.getText();
    }

    public String assertTotalCost(){
        switchTo().defaultContent();
        switchTo().frame(frameMailText);
        return totalCost.getText();
    }

    public YopmailPage switchToWindow(String window){
        switchTo().window(window);
        return this;
    }

}
