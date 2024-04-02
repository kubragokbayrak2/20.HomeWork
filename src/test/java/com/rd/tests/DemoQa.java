package com.rd.tests;

import com.rd.drivers.Driver;
import com.rd.utils.PropertyManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.List;

public class DemoQa {

    public static WebDriver driver;
    Driver webDriver = new Driver();
    PropertyManager propertyManager = new PropertyManager();

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        driver = webDriver.initializeDriver();
        driver.get(propertyManager.getProperty("APP_URL"));
    }
    @Test(priority = 1)
    public void testScenario() throws InterruptedException, MalformedURLException {
        // Adım 1: WebDriver başlat ve sayfayı yükle
        driver = webDriver.initializeDriver();
        driver.get(propertyManager.getProperty("APP_URL"));

        // Adım 2: DEMOQA başlığını kontrol et
        String pageTitle = driver.getTitle();
        String expectedTitle = "DEMOQA";
        Assert.assertEquals(pageTitle, expectedTitle);

        // Adım 3: Butonları seç
        WebElement buttons = driver.findElement(By.cssSelector("ul li#item-4"));
        buttons.click();

        // Adım 4: Sayfayı aşağı kaydır ve "Click Me" butonuna tıkla
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        WebElement clickMeButton = driver.findElement(By.cssSelector("div div:nth-child(4) button.btn-primary"));
        clickMeButton.click();

        // Adım 5: "You have done a dynamic click" mesajını kontrol et
        String actualResult = driver.findElement(By.id("dynamicClickMessage")).getText();
        String expectedMessage = "You have done a dynamic click";
        Assert.assertEquals(actualResult, expectedMessage);

        // Adım 6: WebDriver'ı kapat
        webDriver.quitDriver();
    }

    @Test
    public void webTables() throws InterruptedException, MalformedURLException{
        // Adım 1: WebDriver başlat ve sayfayı yükle
        driver = webDriver.initializeDriver();
        driver.get(propertyManager.getProperty("APP_URL"));

        // Adım 2: DEMOQA başlığını kontrol et
        String pageTitle = driver.getTitle();
        String expectedTitle = "DEMOQA";
       Assert.assertEquals(pageTitle, expectedTitle);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Elementleri bul
        List<WebElement> buttons = driver.findElements(By.cssSelector(".btn.btn-light"));

        // Element var mı yok mu kontrol et
        if (!buttons.isEmpty()) {
            // Belirli bir süre boyunca elementin tıklanabilir olmasını bekleyin
            WebElement clickableElement = wait.until(ExpectedConditions.elementToBeClickable(buttons.get(3)));

            // Elemente tıklayın
            clickableElement.click();
        } else {
            System.out.println("No matching element found!");
        }


        // Adım 4: Add butonuna tıkla
        WebElement addNewRecordButton = driver.findElement(By.cssSelector("#addNewRecordButton"));
        addNewRecordButton.click();

        WebElement firstName = driver.findElement(By.cssSelector("#firstName"));
        firstName.sendKeys("Kübra");

        WebElement lastName = driver.findElement(By.cssSelector("#lastName"));
        lastName.sendKeys("Gökbayrak");

        WebElement emailButton = driver.findElement(By.cssSelector("#userEmail"));
        emailButton.sendKeys("kubragokbayrak@gmail.com");

        WebElement ageButton = driver.findElement(By.cssSelector("#age"));
        ageButton.sendKeys("28");

        WebElement salaryButton = driver.findElement(By.cssSelector("#salary"));
        salaryButton.sendKeys("10000");

        WebElement departmentButton = driver.findElement(By.cssSelector("#department"));
        departmentButton.sendKeys("Test Department");

        WebElement submit = driver.findElement(By.cssSelector("#submit"));
        submit.click();
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500)");
        List<WebElement> element = driver.findElements(By.cssSelector(".action-buttons.mr-2"));

        // Eğer collection'da eleman varsa, istediğimiz elementi seç ve tıkla
        if (!element.isEmpty()) {
            // Örneğin ilk elemente tıklamak için:
            buttons.get(3).click();
        } else {
            System.out.println("No matching element found!");
        }
        WebElement editBtton = driver.findElement(By.cssSelector("#edit-record-4"));
        editBtton.click();
        Thread.sleep(3000);
        WebElement UpdateName = driver.findElement(By.cssSelector("#firstName"));

        UpdateName.click();
        UpdateName.clear();
        UpdateName.sendKeys("Esra");
        WebElement submitUpdate = driver.findElement(By.cssSelector("#submit"));
        submitUpdate.click();

    }
}
