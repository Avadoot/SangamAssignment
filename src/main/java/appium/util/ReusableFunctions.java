package appium.util;

import appium.base.TestBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReusableFunctions extends TestBase {

    private int timeout;

    public int timeoutValue() {
        try {
            timeout = Integer.parseInt(prop.getProperty("TIMEOUT"));
        } catch (Exception Ex) {
            logger.error("Exception Occurred While Getting Timeout Property:" + Ex.getMessage());
        }
        return timeout;
    }

    public boolean waitForElementPresent(AppiumDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutValue());
        boolean flag = true;
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Exception Ex) {
            flag = false;
            logger.error("Exception Occurred While Locating The Element: " + Ex.getMessage());
        }
        return flag;
    }

    public boolean waitForElementClickable(AppiumDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutValue());
        boolean flag = true;
        try {
            wait.until(ExpectedConditions.elementToBeClickable(locator));
        } catch (Exception Ex) {
            flag = false;
            logger.error("Exception Occurred While Locating The Element: " + Ex.getMessage());
        }
        return flag;
    }

    public void click(AppiumDriver driver, By locator) {
        try {
            if (waitForElementClickable(driver, locator)) {
                MobileElement element = (MobileElement) driver.findElement(locator);
                element.click();
                logger.info("Clicking on element: " + element.getClass());
            }
        } catch (Exception Ex) {
            logger.error("Exception Occurred While Clicking The Element: " + Ex.getMessage());
        }

    }

    public String getTextByInnerText(AppiumDriver driver, By locator) {
        String text = null;
        try {
            if (waitForElementClickable(driver, locator)) {
                MobileElement element = (MobileElement) driver.findElement(locator);
                text = element.getText();
                logger.info("Getting Text From locator: " + text);
            }
        } catch (Exception Ex) {
            logger.error("Exception Occurred While Getting The Text: " + Ex.getMessage());
        }
        return text;
    }
}

