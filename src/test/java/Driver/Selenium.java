package Driver;

import Data.ConfigReader;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static Utils.Log.LogError;
import static Utils.Log.logInfo;

public class Selenium {
    private WebDriver driver = Hook.driver;
    ConfigReader data = new ConfigReader();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(data.getTimeOut()));


    public Selenium(WebDriver driver) throws IOException {
        PageFactory.initElements(driver, this);
    }

    public void navigateTo(String url) {
        try {
            driver.get(url);
            logInfo("Navigate page" + url);

        } catch (NoSuchElementException | TimeoutException e) {
            LogError(e.getRawMessage());
            Assert.fail("[Selenium] : [Selenium]: Unable to perform" + Thread.currentThread().getStackTrace()[1].getMethodName() + " Para la : " + url + " The class where it was called is : " + String.format(("")));


        } catch (Exception e) {
            LogError(e.getMessage());
            Assert.fail("[Selenium] : [Selenium]: Unable to perform" + Thread.currentThread().getStackTrace()[1].getMethodName() + " Para la : " + url + " The class where it was called is : " + String.format(("")));

        }
    }

    public WebElement findElement(By element) throws IOException {
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        return driver.findElement(element);
    }

    public void waitElementVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitElementClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }


    public String getText(WebElement element) {
        try {
            waitElementVisibility(element);

        } catch (NoSuchElementException | TimeoutException e) {
            LogError(e.getRawMessage());
            Assert.fail("[Selenium] : [Selenium]: Unable to perform " + Thread.currentThread().getStackTrace()[1].getMethodName() + " for element : " + element.toString() + " The class where it was called is : " + String.format(("")));

        } catch (Exception e) {
            LogError(e.getMessage());
            Assert.fail("[Selenium] : [Selenium]: Unable to perform " + Thread.currentThread().getStackTrace()[1].getMethodName() + " for element : " + element.toString() + " The class where it was called is : " + String.format(("")));
        }
        return element.getText();
    }

    public void click(WebElement element) {
        try {
            waitElementVisibility(element);
            waitElementClickable(element);
            element.click();
            logInfo("Click the button " + element.toString());

        } catch (NoSuchElementException | TimeoutException e) {
            LogError(e.getRawMessage());
            Assert.fail("[Selenium] : [Selenium]: Unable to perform" + Thread.currentThread().getStackTrace()[1].getMethodName() + "for element : " + element.toString() + "The class where it was called is : " + String.format(("")));


        } catch (Exception e) {
            LogError(e.getMessage());
            Assert.fail("[Selenium] : [Selenium]: Unable to perform" + Thread.currentThread().getStackTrace()[1].getMethodName() + "for element : " + element.toString() + "The class where it was called is : " + String.format(("")));

        }
    }

    public void iframeSwitchig () {
        try {
            driver.switchTo().frame(0);
            logInfo("Switch to first iframe ");

        } catch (NoSuchElementException | TimeoutException e) {
            LogError(e.getRawMessage());
            Assert.fail("[Selenium] : [Selenium]: Unable to Switch to first iframe" + Thread.currentThread().getStackTrace()[1].getMethodName() +  "The class where it was called is : " + String.format(("")));


        } catch (Exception e) {
            LogError(e.getMessage());
            Assert.fail("[Selenium] : [Selenium]: Unable to Switch to first iframe" + Thread.currentThread().getStackTrace()[1].getMethodName() +  "The class where it was called is : " + String.format(("")));

        }
    }

    public void iframeSwitchigDefault () {
        try {
            driver.switchTo().defaultContent();
            logInfo("Switch to default iframe ");

        } catch (NoSuchElementException | TimeoutException e) {
            LogError(e.getRawMessage());
            Assert.fail("[Selenium] : [Selenium]: Unable to Switch to first iframe" + Thread.currentThread().getStackTrace()[1].getMethodName() +  "The class where it was called is : " + String.format(("")));


        } catch (Exception e) {
            LogError(e.getMessage());
            Assert.fail("[Selenium] : [Selenium]: Unable to Switch to first iframe" + Thread.currentThread().getStackTrace()[1].getMethodName() +  "The class where it was called is : " + String.format(("")));

        }
    }


    public void sendKeys(WebElement element, String text) {
        try {
            waitElementVisibility(element);
            element.clear();
            element.sendKeys(text);
            logInfo("type " + text);
        } catch (NoSuchElementException | TimeoutException e) {
            LogError(e.getRawMessage());
            Assert.fail("[Selenium] : [Selenium]: Unable to perform" + Thread.currentThread().getStackTrace()[1].getMethodName() + " for element : " + element.toString() + " The class where it was called is : " + String.format(("")));


        } catch (Exception e) {
            LogError(e.getMessage());
            Assert.fail("[Selenium] : [Selenium]: Unable to perform" + Thread.currentThread().getStackTrace()[1].getMethodName() + " for element : " + element.toString() + " The class where it was called is : " + String.format(("")));

        }
    }

    public void focusElement(WebElement element) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView();", element);
        } catch (NoSuchElementException | TimeoutException e) {
            LogError(e.getRawMessage());
            Assert.fail("[Selenium] : [Selenium]: Unable to perform" + Thread.currentThread().getStackTrace()[1].getMethodName() + " for element : " + element.toString() + " The class where it was called is : " + String.format(("")));


        } catch (Exception e) {
            Assert.fail("[Selenium] : [Selenium]: Unable to perform" + Thread.currentThread().getStackTrace()[1].getMethodName() + " for element : " + element.toString() + " The class where it was called is : " + String.format(("")));

        }
    }


    public void alertAccept() {
        try {
            driver.switchTo().alert().accept();

        } catch (NoSuchElementException | TimeoutException e) {
            LogError(e.getRawMessage());
            Assert.fail("[Selenium] : [Selenium]: Unable to perform " + Thread.currentThread().getStackTrace()[1].getMethodName() + " for element : Alert The class where it was called is : " + String.format(("")));


        } catch (Exception e) {
            LogError(e.getMessage());
            Assert.fail("[Selenium] : [Selenium]: Unable to perform " + Thread.currentThread().getStackTrace()[1].getMethodName() + " for element :Alert The class where it was called is : " + String.format(("")));

        }
    }


    public String alertGetText() {
        String alertText = "";
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
             alertText = alert.getText();
            logInfo("get text: " + alertText);
        } catch (NoSuchElementException | TimeoutException e) {
            String errorMessage = "[Selenium] : Could not perform " + Thread.currentThread().getStackTrace()[1].getMethodName() + " for element: Alert. The class where it was called is: " + String.format((""));
            LogError(e.getRawMessage());
            Assert.fail(errorMessage);
        } catch (Exception e) {
            String errorMessage = "[Selenium] : Could not perform " + Thread.currentThread().getStackTrace()[1].getMethodName() + " for element: Alert. The class where it was called is: " + String.format((""));
            LogError(e.getMessage());
            Assert.fail(errorMessage);
        }
        return alertText;
    }






}