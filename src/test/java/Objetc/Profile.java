package Objetc;

import Data.ConfigReader;
import Driver.Selenium;

import Models.Books;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.openqa.selenium.By.xpath;

public class Profile extends Selenium {
    @CacheLookup
    @FindBy(xpath = "//span[@class='text'][contains(.,'Profile')]")
    WebElement buttonProfile;


    @CacheLookup
    @FindBy(xpath = "(//div[contains(@class,'rt-td')])[2]")
    WebElement textTitleBook;

    @CacheLookup
    @FindBy(xpath = "(//div[contains(@class,'rt-td')])[3]")
    WebElement textAuthorBook;

    @CacheLookup
    @FindBy(xpath = "(//div[contains(@class,'rt-td')])[4]")
    WebElement textPublisherBook;

    @CacheLookup
    @FindBy(id = "delete-record-undefined")
    WebElement iConDeleteBook;

    @CacheLookup
    @FindBy(id = "closeSmallModal-ok")
    WebElement modalOkdeleteBook;


    public Profile(WebDriver driver) throws IOException {
        super(driver);
    }

    public void clickProfile() {
        focusElement(buttonProfile);
        click(buttonProfile);

    }
    public void validateBookCart()  {
        assertEquals(Books.getTitle(), getText(textTitleBook), "The expected value does not correspond to the one sent");
        assertEquals(Books.getAuthor(), getText(textAuthorBook), "The expected value does not correspond to the one sent");
        assertEquals(Books.getPublisher(), getText(textPublisherBook), "The expected value does not correspond to the one sent");

    }
    public void deleteBook() {
        click(iConDeleteBook);
        iframeSwitchig();
        click(modalOkdeleteBook);
        iframeSwitchigDefault();
        alertAccept();
    }

}
