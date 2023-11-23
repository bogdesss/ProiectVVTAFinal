package VVTA.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

public class ContactPage  extends PageObject {

    // The locator for the contact button in the footer
    private By contactButton = By.cssSelector("footer a[href$='/contact']");



    // Method to scroll to the footer and click the contact button
    public void navigateToContactPage() {
        WebElementFacade button = $(contactButton).waitUntilClickable();
        button.click();
    }

    public boolean isContactFormVisible() {
        By contactFormLocator = By.id("contact-form-identifier");
        return $(contactFormLocator).isDisplayed();
    }

}
