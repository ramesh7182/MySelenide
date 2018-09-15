package com.home.Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.nio.channels.SelectableChannel;

public class CommonMethod {

    public void wait(int milliseconds)
    {
        try{Thread.sleep(milliseconds);}catch (InterruptedException e){}
    }

    public void clickElement(SelenideElement element)
    {
        element.should(Condition.visible);
        element.click();
    }

    public void enterText(SelenideElement element, String text)
    {
        element.should(Condition.visible);
        element.sendKeys(text);
    }



}
