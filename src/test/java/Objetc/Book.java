package Objetc;

import Driver.Selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;

import java.io.IOException;

import Models.Books;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


public class Book extends Selenium {

    @CacheLookup
    @FindBy(xpath = "//div[contains(@class,'main-header')]")
    WebElement textTitle;
    @CacheLookup
    @FindBy(id = "searchBox")
    WebElement inputSearchBox;
    @CacheLookup
    @FindBy(id = "basic-addon2")
    WebElement buttonSearch;

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
    WebElement selectBook;

    public Book(WebDriver driver) throws IOException {
        super(driver);
    }

    public void verifyTitleText(String value) {
        assertEquals(value, getText(textTitle), "The text presented does not match the page of Book");
    }

    public void typeSearchBook(String name) {
        sendKeys(inputSearchBox, name);
    }

    public void clickSearchBook() {
        click(buttonSearch);
    }

    public void validateGetSearchBook(String name) {
        assertEquals(name, getText(textTitleBook), "the book you are looking for is not available");
    }

    public void validateNotGetSearchBook(String name) {
        assertNotEquals(name, getText(textTitleBook), "the book you are looking for is not available");
    }


    public void getDataSearchBook() {
        String title = getText(textTitleBook);
        String author = getText(textAuthorBook);
        String publisher = getText(textPublisherBook);
        new Books(title, author, publisher);
    }

    public void selectBook() throws IOException {
        WebElement selectBook = findElement(By.xpath("//a[contains(.,'"+Books.getTitle()+"')]"));
        click(selectBook);
    }
}
