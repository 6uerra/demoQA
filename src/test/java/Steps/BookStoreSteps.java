package Steps;

import Driver.Hook;

import Objetc.Book;
import Objetc.DetailBook;
import Objetc.Profile;
import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
public class BookStoreSteps {
    Book book = new Book(Hook.driver);
    DetailBook detailBook = new DetailBook(Hook.driver);
    Profile profile = new Profile(Hook.driver);
    public BookStoreSteps() throws IOException {
    }

    @Given("I search for a book by name {string}")
    public void i_search_for_a_book_by_name(String name) {
        book.verifyTitleText("Book Store");
        book.typeSearchBook(name);
        book.clickSearchBook();
        book.validateGetSearchBook(name);
        book.getDataSearchBook();
    }

    @When("I select the desired book from the search results")
    public void i_select_the_desired_book_from_the_search_results() throws IOException {
        book.selectBook();
        detailBook.validateDataBookSelected();

    }

    @And("I add the book to my cart")
    public void i_add_the_book_to_my_cart() throws InterruptedException {
        detailBook.clickAddNewRecordButton();
    }

    @Then("the book should be added successfully to my cart")
    public void the_book_should_be_added_successfully_to_my_cart()  {
        profile.clickProfile();
        profile.validateBookCart();
        profile.deleteBook();
    }

    @Given("I want to look for a book {string}")
    public void i_want_to_look_for_a_book(String name) {
        book.typeSearchBook(name);
    }
    @When("this does not exist")
    public void this_does_not_exist() {
        book.clickSearchBook();
    }
    @Then("there should be no results a book {string}")
    public void there_should_be_no_results(String name) {
        book.validateNotGetSearchBook(name);
    }

}
