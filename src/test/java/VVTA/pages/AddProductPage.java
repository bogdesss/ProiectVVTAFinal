package VVTA.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddProductPage  extends PageObject{
    private By searchInput = By.id("_autocompleteSearchMainHeader"); // Update if the name attribute is different
    private By searchButton = By.id("_doSearch");  // Update if the button has a different selector
    private By firstProductLink = By.cssSelector(".product-box .image-holder a"); // Update based on the actual structure
    private By productTitle = By.cssSelector("h1.title"); // Use the correct selector to match your product title element


    public void searchForPokemonLostOrigin(String query) {
        $(searchInput).type(query);
        $(searchButton).click();
        waitFor(ExpectedConditions.visibilityOfElementLocated(firstProductLink));
    }

    public void selectFirstProduct() {
        $(firstProductLink).waitUntilVisible().click();
    }

    public boolean isOnProductPage(String expectedTitle) {
        String actualTitle = $(productTitle).waitUntilPresent().getText();
        return actualTitle.contains(expectedTitle);
    }

}
