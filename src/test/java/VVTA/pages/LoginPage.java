package VVTA.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@DefaultUrl("https://shop.guildhall.ro/inregistrare")
public class LoginPage extends PageObject {

    private By emailInput = By.id("_loginEmail");
    private By passwordInput = By.id("_loginPassword");
    private By signInButton = By.id("doLogin");
    private By loggedInIndicator = By.cssSelector("a.active-account");


    private By errorMessage = new By.ByClassName("errorMsg");

    public void enterEmail(String email) {
        $(emailInput).type(email);
    }

    public void enterPassword(String password) {
        $(passwordInput).type(password);
    }

    public void clickSignIn() {
        $(signInButton).click();
    }

    public boolean isUserSeeingErrorMessage() {
        return $(errorMessage).isPresent();
    }
    public boolean isUserLoggedIn() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        try {
            // Wait for the active-account element to be visible as an indication that the user is logged in
            return wait.until(ExpectedConditions.visibilityOfElementLocated(loggedInIndicator)).isDisplayed();
        } catch (Exception e) {
            return false; // Return false if the active-account element does not appear within the timeout
        }
    }

}