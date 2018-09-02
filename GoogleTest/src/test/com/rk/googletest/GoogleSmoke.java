package com.rk.googletest;
import com.home.Listners.ListenerTest;
import com.home.Pages.TestDataProvider;
import org.testng.annotations.*;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.open;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Properties;

@Listeners(ListenerTest.class)

public class GoogleSmoke extends  TestDataProvider{

    @BeforeMethod
    public void nameBefore(Method method)
    {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kumar\\Downloads\\chromedriver_win32\\chromedriver.exe");
		System.setProperty("selenide.browser", "Chrome");
		timeout = 10000;
		baseUrl = "https://www.amazon.com";
    }

    @DataProvider(name = "readTestData")
    public static Object[][] readData(Method method) {
        System.out.println("Reading Test Data before test case execution ");
        return TestDataProvider.readTestData(method);

    }


	@Step("Opening Google")
	@Test(description="Opening Google", dataProvider = "readTestData")
	public static void openGoogle(HashMap<Object, Object> data) {
			//System.out.println("Opening Google");
			baseUrl = "https://www.google.com";
			open(baseUrl);
			startMaximized = true;
	}

	@Test(description="Test Method", dataProvider = "readTestData")
	public static void testMethod(HashMap<Object, Object> data) {

        System.out.println("Test Case "+data.get("testcase").toString());
        System.out.println("To Run "+data.get("torun").toString());
        System.out.println("Language "+data.get("language").toString());
        System.out.println("Test Data 1 "+data.get("testdata1").toString());
	}

   

}

