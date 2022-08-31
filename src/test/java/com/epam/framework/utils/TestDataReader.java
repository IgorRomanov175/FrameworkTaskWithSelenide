package com.epam.framework.utils;

import java.util.ResourceBundle;

public class TestDataReader {

    private static final ResourceBundle resourceBundle = ResourceBundle.getBundle(System.getProperty("environment"));

    public String getTestData(String key) {
        return resourceBundle.getString(key);
    }

}
