package com.pcgus.ci;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;
import java.lang.*;

public class Element {

    private static final Logger log = LogManager.getLogger(Element.class);
    protected static WebDriver driver;
    protected static SoftAssert softAssert = new SoftAssert();
    private static final int POLLING_INTERVAL = 250;

    public Element(WebDriver driver) {
        this.driver = driver;
    }

    public void enterValue(WebElement ele,String text){
        ele.sendKeys(text);
    }

    public String getValue(WebElement element){
        String a= element.getText();
        return element.getText();
    }

    public static WebElement getElementFromProperties(String propertyFileName, String locatorKey) {
        WebElement elem = null;
        try {
            if (locatorKey.endsWith("_id"))
                elem = driver.findElement(By.id(TestProperties.get(locatorKey, propertyFileName)));
            else if (locatorKey.endsWith("_name"))
                elem = driver.findElement(By.name(TestProperties.get(locatorKey, propertyFileName)));
            else if (locatorKey.endsWith("_xpath"))
                elem = driver.findElement(By.xpath(TestProperties.get(locatorKey, propertyFileName)));
            else if (locatorKey.endsWith("_class"))
                elem = driver.findElement(By.className(TestProperties.get(locatorKey, propertyFileName)));
            else if (locatorKey.endsWith("_css"))
                elem = driver.findElement(By.cssSelector(TestProperties.get(locatorKey, propertyFileName)));
            else {
                log.error("Element Key Not found for ", locatorKey);
                Assert.fail("Element Key Not found for " + locatorKey);
            }
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.visibilityOf(elem));
            wait.until(ExpectedConditions.elementToBeClickable(elem));
        } catch (Exception e) {
            log.info("Exception occurred. ", e.getMessage());
            Assert.fail("Failed the test - " + e.getMessage());
        }
        return elem;
    }

    public static WebElement waitForBy(WebDriver driver, int timeout, final By by, final boolean andDisplayed) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofSeconds(POLLING_INTERVAL)).ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);
        return wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                WebElement element = driver.findElement(by);
                if (andDisplayed && !element.isDisplayed()) {
                    log.error("Element is not displayed, but expected displayed.");
                    throw new NoSuchElementException("Element is not displayed; Element String is " + element.getText()
                            + "Element locator is By" + by.toString());
                }
                return element;
            }
        });
    }

    public void waitClickable(WebDriver driver, WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        try {
            wait.ignoring(NoSuchElementException.class).ignoring(StaleElementReferenceException.class)
                    .until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            log.error("Exception is occurred. ", e.getMessage());
            Assert.assertFalse(false, "Failed the test - " + e.getMessage());
        }
    }

    public static WebElement waitUntilIsClickable(WebDriver driver, By by, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.elementToBeClickable(by));
    }

    public static WebElement waitUntilIsClickable(WebDriver driver, WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(InvalidElementStateException.class)
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitPresenceBy(WebDriver driver, By by, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        try {
            wait.ignoring(NoSuchElementException.class).ignoring(StaleElementReferenceException.class)
                    .until(ExpectedConditions.presenceOfElementLocated(by));
        } catch (Exception e) {
            log.error("Exception is occurred. ", e.getMessage());
            Assert.assertFalse(false, "Failed the test - " + e.getMessage());
        }
    }

    public void waitVisibility(WebDriver driver, WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        try {
            wait.ignoring(NoSuchElementException.class).ignoring(StaleElementReferenceException.class)
                    .until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            log.error("Exception is occurred. ", e.getMessage());
            Assert.assertFalse(false, "Failed the test - " + e.getMessage());
        }
    }

    public void waitVisibleBy(WebDriver driver, By by, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        try {
            wait.ignoring(NoSuchElementException.class).ignoring(StaleElementReferenceException.class)
                    .until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (Exception e) {
            log.error("Exception is occurred. ", e.getMessage());
            Assert.assertFalse(false, "Failed the test - " + e.getMessage());
        }
    }

    public void waitForInvisibleBy(WebDriver driver, By by, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        try {
            wait.ignoring(NoSuchElementException.class).ignoring(StaleElementReferenceException.class)
                    .until(ExpectedConditions.invisibilityOfElementLocated(by));
        } catch (Exception e) {
            log.error("Exception is occurred. ", e.getMessage());
            Assert.assertFalse(false, "Failed the test - " + e.getMessage());
        }
    }

    public static boolean isDisplayed(WebDriver driver, By by, int timeOutSeconds) throws InterruptedException {
        long maxTime = System.currentTimeMillis() + timeOutSeconds;
        while (System.currentTimeMillis() < maxTime) {
            try {
                if (driver.findElement(by).isDisplayed()) {
                    return true;
                } else {
                    Thread.sleep(POLLING_INTERVAL);
                }
            } catch (Exception e) {
                Thread.sleep(POLLING_INTERVAL);
            }
        }
        return false;
    }

    public boolean isDisplayed(WebElement element) {

        try {
            if (element.isDisplayed()) {
                return true;
            } else {
                return false;
            }
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void hoverOverClick(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
    }

    public void hoverOver(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }

    public void clickByJs(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public void enableButton(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('disabled','disabled')", element);
    }

    public void clear(WebElement element) {
        element.clear();
    }

    public boolean isCheckboxSelected(WebElement element) {
        return element.isSelected();
    }

    public String getFirstOptionValue(WebElement element) {
        String optionText = new Select(element).getFirstSelectedOption().getText();
        return optionText;
    }

    public String getOptionTextByIndex(WebElement element, int index) {
        WebElement optionElement = new Select(element).getOptions().get(index);
        return optionElement.getText();
    }

    public List<String> getAllDropDownValues(WebElement locator) {
        Select select = new Select(locator);
        List<WebElement> elementList = select.getOptions();
        List<String> valueList = new LinkedList<>();
        for (WebElement element : elementList) {
            valueList.add(element.getText());
        }
        return valueList;
    }

    public void selectOption(WebElement element, int index) {
        Select select = new Select(element);
        select.selectByIndex(index);
    }

    public void selectVisibleOption(WebElement element, String text) {
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    public void selectOption(WebElement element, String text) {
        Select select = new Select(element);
        select.selectByValue(text);
    }

    public void click(WebDriver driver, WebElement element) {
        element.click();
    }

    public void sendKeys(WebElement element, String text) {
        element.sendKeys(text);
    }

    public void actionEnter(){
        Actions hitEnter = new Actions(driver);
        hitEnter.sendKeys(Keys.chord(Keys.ENTER)).perform();
    }
}
