package VVTA.steps.serenity;

import VVTA.pages.AddProductPage;
import net.thucydides.core.annotations.Step;

import static org.junit.Assert.assertTrue;

public class EndUserAddPokemonCards {
    AddProductPage addProductPage;

    @Step
    public void search_for_pokemon_card(String cardName) {
        addProductPage.searchForPokemonLostOrigin(cardName);
    }

    @Step
    public void select_first_pokemon_card_result() {
        addProductPage.selectFirstProduct();
    }
    @Step
    public void should_be_on_product_page(String expectedTitle) {
        assertTrue("Not on the expected product page.",
                addProductPage.isOnProductPage(expectedTitle));
    }
}
