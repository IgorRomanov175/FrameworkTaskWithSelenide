package com.epam.framework.pages.toolsForPages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;
import static com.codeborne.selenide.Selenide.*;

public class Tools {
    public static int getInstanceForName(ElementsCollection collection, String name) {
        int numOfInstance = 0;
        for (int i = 0; i < collection.size(); i++) {
            if(collection.get(i).getText().contains(name) || collection.get(i).getText().equals(name)){
                System.out.println(collection.get(i).getText());
                numOfInstance = i;
            }
        }
        return numOfInstance;
    }

    public static SelenideElement setYearCommitment(String year){
        return $x("//div[@class='md-select-menu-container md-active md-clickable']//md-option/div[text()='" + year +"']");
    }

    public static SelenideElement setNumberOfGPU(String num){
        return $x("//md-option[@ng-disabled='item.value != 0 && item.value < listingCtrl.minGPU']/div[contains(text(), " + num +")]");
    }
}
