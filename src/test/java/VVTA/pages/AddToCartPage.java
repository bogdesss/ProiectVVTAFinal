package VVTA.pages;


import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class AddToCartPage extends PageObject {
    private By searchInput = By.id("_autocompleteSearchMainHeader");
    private By searchButton = By.id("_doSearch");
    private By firstProductLink = By.cssSelector(".product-box .image-holder a");
    private By addToCartButton = By.cssSelector("a.add2cart");

    private By cartIcon = By.cssSelector("a[href*='/cos-de-cumparaturi']");

    private By finalizeOrderButton = By.cssSelector("a[href*='/finalizeaza-comanda']");


    public void searchForPokemonLostOrigin(String query) {
        $(searchInput).type(query);
        $(searchButton).click();
        waitFor(ExpectedConditions.visibilityOfElementLocated(firstProductLink));
    }

    public void selectFirstProduct() {
        $(firstProductLink).waitUntilVisible().click();
    }

    public void addProductToCart() {
        $(addToCartButton).waitUntilClickable().click();
    }

    public void goToCart() {

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        WebElement cartIconElement = wait.until(ExpectedConditions.elementToBeClickable(cartIcon));
        cartIconElement.click();
    }

    public boolean isFinalizeOrderButtonPresent() {

        waitFor(ExpectedConditions.visibilityOfElementLocated(finalizeOrderButton));
        return $(finalizeOrderButton).isDisplayed();
    }
}