package com.epam.arlouskaya.testMobileAndroid.pages;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Katsiaryna_Arlouskay on 8/3/2015.
 */
public class MainPage {
    @FindBy(xpath = "//android.widget.TextView[@resource-id='android:id/text1'][1]")
    private WebElement btnAccessibility;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='android:id/text1'][2]")
    private WebElement btnAnimation;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Content\")")
    private WebElement btnContent;

    private AndroidDriver driver;


    public MainPage(AndroidDriver driver){
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }

    public void clickAccessibility(){
        System.out.println("Click on " + btnAccessibility.getText());
        btnAccessibility.click();
        // driver.navigate().back();
        driver.sendKeyEvent(AndroidKeyCode.BACK);
    }

    public void clickAnimation(){
        System.out.println("Click on " + btnAnimation.getText());
        btnAnimation.click();
        driver.navigate().back();
    }

    public void clickApp(){
        WebElement btnApp = driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().className(\"android.widget.TextView\").instance(3)"));
        System.out.println("Click on " + btnApp.getText());
        btnApp.click();
        driver.sendKeyEvent(AndroidKeyCode.BACK);
    }

    public void clickContent(){
        System.out.println("Click on " + btnContent.getText());
        btnContent.click();
        driver.sendKeyEvent(AndroidKeyCode.BACK);
    }
}
