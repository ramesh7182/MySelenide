package com.home.Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Configuration.startMaximized;
import static com.codeborne.selenide.Selenide.open;

import static com.codeborne.selenide.Selenide.$;
import static org.testng.CommandLineArgs.LOG;

public class GoogleHome {

    public GoogleHome()
    {
        baseUrl = "https://www.google.com";
        open(baseUrl);
        startMaximized = true;
    }
    private SelenideElement searchBox = $(By.id("lst-ib"));

    public void enterSearchTerm(String searchTerm)
    {
        System.out.println("Enter:enterSearchTerm");
        searchBox.should(Condition.visible);
        searchBox.sendKeys(searchTerm);
        System.out.println("Exit:enterSearchTerm");
    }
}
