package VVTA.steps.serenity;

import VVTA.pages.AddToCartPage;
import net.thucydides.core.annotations.Step;

import static org.junit.Assert.assertTrue;

public class EndUserAddToCartSteps {
    AddToCartPage addToCartPagePage;

    @Step
    public void search_for_product(String productName) {
        addToCartPagePage.searchForPokemonLostOrigin(productName);
    }

    @Step
    public void select_first_search_result() {
        addToCartPagePage.selectFirstProduct();
    }

    @Step
    public void add_selected_product_to_cart() {
        addToCartPagePage.addProductToCart();
    }

    @Step
    public void go_to_cart() {
        addToCartPagePage.goToCart();
    }

    @Step
    public void should_see_finalize_order_button() {
        assertTrue("The 'Finalizeaza Comanda' button was not found in the cart.",
                addToCartPagePage.isFinalizeOrderButtonPresent());
    }
}
