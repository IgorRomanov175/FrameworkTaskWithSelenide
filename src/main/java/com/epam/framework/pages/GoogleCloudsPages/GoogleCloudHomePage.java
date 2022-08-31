package com.epam.framework.pages.GoogleCloudsPages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$x;

public class GoogleCloudHomePage {

    private final SelenideElement inputField = $x("//input[@aria-label='Search']");

    public GoogleCloudSearchPage searchFieldInput(String text){
        inputField.setValue(text);
        inputField.sendKeys(Keys.ENTER);
        return new GoogleCloudSearchPage();
    }

}
