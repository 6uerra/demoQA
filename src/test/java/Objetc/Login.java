package Objetc;
import Driver.Selenium;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import java.io.IOException;

import static Utils.Log.logInfo;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Login extends Selenium{

    @CacheLookup
    @FindBy(id = "login")
    WebElement buttonLogin;
    @CacheLookup
    @FindBy(xpath = "//button[@type='button'][contains(.,'Login')]")
    WebElement buttonLoginPage;

    @CacheLookup
    @FindBy(id = "userName")
    WebElement inputUser;

    @CacheLookup
    @FindBy(id = "password")
    WebElement inputPassword;

    @CacheLookup
    @FindBy(xpath = "//label[contains(@id,'userName-value')]")
    WebElement textUserName;


    public Login(WebDriver driver) throws IOException {
        super(driver);
    }

    public void navigateToDemoqa(String url)  {
        navigateTo(url);
    }
    public void typeUser(String user)  {
        sendKeys(inputUser,user );
    }
    public void typePassword(String password)  {
        sendKeys(inputPassword,password);
    }
    public void clickLoginButton(){
        click(buttonLogin);
    }
    public void clickLoginPageButton(){
        click(buttonLoginPage);
    }



    public void validateLoginUser(String user){
        assertEquals(user,getText(textUserName),"the user entered is not the same as the one presented in the login");
    }

}
