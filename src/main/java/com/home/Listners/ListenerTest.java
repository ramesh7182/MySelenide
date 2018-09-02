package com.home.Listners;

import org.testng.ITestResult;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.testng.AllureTestListener;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ListenerTest extends AllureTestListener					
{		

	@Override
    public void onTestFailure(ITestResult iTestResult) {
        if ("failed".equals(iTestResult.getStatus())) {
            attach();
        }
        super.onTestFailure(iTestResult);
    }

    @Attachment(type = "image/png")
    public byte[] attach() {
        try {
            BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(image, "png", baos);
            baos.flush();
            byte[] imageInByte = baos.toByteArray();
            baos.close();
            return imageInByte;
        } catch (AWTException | IOException e) {
            return null;
        }

    }

}			