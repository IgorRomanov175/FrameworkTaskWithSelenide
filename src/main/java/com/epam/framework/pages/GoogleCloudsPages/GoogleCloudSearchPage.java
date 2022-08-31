package com.epam.framework.pages.GoogleCloudsPages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class GoogleCloudSearchPage {

    private final SelenideElement searchElement = $x("//a/b[text()='Google Cloud Platform Pricing Calculator']");

    public GoogleCloudCalculatorPage clickSearchElement(){
        searchElement.click();
        return new GoogleCloudCalculatorPage();
    }

}
