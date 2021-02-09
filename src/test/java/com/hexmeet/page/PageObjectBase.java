package com.hexmeet.page;

import org.openqa.selenium.WebElement;

public interface PageObjectBase {
    void navigate();
    WebElement findElementByXPath(String xpath);
    WebElement findElementByAccessibilityId(String id);
}
