package Objetc;

import Driver.Selenium;
import Models.Books;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import java.io.IOException;


import static org.junit.jupiter.api.Assertions.assertEquals;


public class DetailBook extends Selenium {

    @CacheLookup
    @FindBy(xpath = "(//label[contains(@id,'userName-value')])[3]")
    WebElement textTitleBook;

    @CacheLookup
    @FindBy(xpath = "(//label[contains(@id,'userName-value')])[5]")
    WebElement textAuthorBook;

    @CacheLookup
    @FindBy(xpath = "(//label[contains(@id,'userName-value')])[6]")
    WebElement textPublisherBook;


    @CacheLookup
    @FindBy(xpath= "(//button[contains(@id,'addNewRecordButton')])[2]")
    WebElement buttonAddNewRecordButton;


    public DetailBook(WebDriver driver) throws IOException {
        super(driver);
    }

    public void validateDataBookSelected() {
        assertEquals(Books.getTitle(), getText(textTitleBook), "The expected value does not correspond to the one sent");
        assertEquals(Books.getAuthor(), getText(textAuthorBook), "The expected value does not correspond to the one sent");
        assertEquals(Books.getPublisher(), getText(textPublisherBook), "The expected value does not correspond to the one sent");
    }

    public void clickAddNewRecordButton() throws InterruptedException {
        focusElement(buttonAddNewRecordButton);
        click(buttonAddNewRecordButton);
        assertEquals("Book added to your collection.",  alertGetText(), "The expected value does not correspond to the one sent");
        alertAccept();

    }
}
