package Steps;

import Data.ConfigReader;
import Driver.Hook;
import Objetc.Login;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import java.io.IOException;

public class LoginSteps {
    ConfigReader data = new ConfigReader();
    Login login = new Login(Hook.driver);


    public LoginSteps() throws IOException {
    }

    @Given("I access demoQA")
    public void i_access_demo_qa() {
        login.navigateToDemoqa(data.getUrl());
    }

    @When("I log in with the user credentials")
    public void i_log_in_with_the_user_credentials() {
        login.clickLoginButton();
        login.typeUser(data.getUser());
        login.typePassword(data.getPassword());
        login.clickLoginPageButton();
    }

    @Then("I validate that the user information is displayed")
    public void i_validate_that_the_user_information_is_displayed() {
        login.validateLoginUser(data.getUser());
    }


}
