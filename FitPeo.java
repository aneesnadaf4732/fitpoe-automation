package javaPackage;

import static org.testng.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FitPeo {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    private JavascriptExecutor js;

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\anees\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "https://www.fitpeo.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        js = (JavascriptExecutor) driver;
    }

    @Test
    public void testFitPoe() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Home'])[1]/preceding::*[name()='svg'][1]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='CPT Codes'])[2]/following::span[2]")).click();
        
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement inputElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(":R57alklff9da:")));

        // Debug info before setting value
        System.out.println("Before setting value: " + inputElement.getAttribute("value"));

        clearAndSetField(inputElement, "560");

        // Debug info after setting value
        System.out.println("After setting value: " + inputElement.getAttribute("value"));

        // Verify the value is set to 560
        String value = inputElement.getAttribute("value");
        assert value.equals("560") : "The input value should be 560 but found [" + value + "]";

        driver.findElement(By.xpath("//input[@type='checkbox']")).click();
        driver.findElement(By.xpath("//div[2]/label/span/input")).click();
        driver.findElement(By.xpath("//div[3]/label/span/input")).click();
        driver.findElement(By.xpath("//div[8]/label/span/input")).click();
        
        driver.findElement(By.id(":R57alklff9da:")).click();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }

    private void clearAndSetField(WebElement element, String value) {
        // Clear the field
        element.clear();

        // Use JavaScript to set the value
        js.executeScript("arguments[0].value = arguments[1];", element, value);

        // Trigger any event listeners
        js.executeScript("arguments[0].dispatchEvent(new Event('change', { bubbles: true }));", element);
    }
}
