package VVTA.features.search;

import VVTA.steps.serenity.EndUserAddPokemonCards;
import VVTA.steps.serenity.EndUserAddToCartSteps;
import VVTA.steps.serenity.EndUserContactPageNav;
import VVTA.steps.serenity.EndUserLoginSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;






@RunWith(SerenityRunner.class)
public class Story {

    @Managed(uniqueSession = true, driver = "firefox")
    public WebDriver webdriver;

    @Steps
    public EndUserLoginSteps user;

   @Steps
    public EndUserAddToCartSteps addToCartSteps;

    @Steps
    public EndUserAddPokemonCards addProductPage;

    @Steps
    public EndUserContactPageNav contactPageNav;

    private void loginWithValidCredentials() {
        user.is_on_the_login_page();
        user.enters_email("domide4@gmail.com");
        user.enters_password("redred123.");
        user.initiates_sign_in();
    }
    @BeforeEach
    public void initialization(){
        user.is_on_the_login_page();
        user.enters_email("domide4@gmail.com");
        user.enters_password("redred123.");
        user.initiates_sign_in();

    }

    @Test
    public void should_not_be_able_to_login(){
        user.is_on_the_login_page();
        user.enters_email("fasfaweq");
        user.enters_password("352352");
        user.initiates_sign_in();
        user.should_not_be_logged_in();
    }

    @Test
    public void should_navigate_to_contact_page() {
        initialization();
        user.is_on_the_login_page();
        contactPageNav.opens_contact_page();
        contactPageNav.should_be_on_contact_page();
    }


    // This test should be self-contained and not rely on @Before setup
    @Test
    public void should_be_able_to_login() {
        loginWithValidCredentials();
        user.should_be_logged_in();
    }

@Test
public void should_be_able_to_add_pokemon_card_to_wish_list_and_verify() {
    initialization();
    addProductPage.search_for_pokemon_card("Pokemon Lost Origin");
    addProductPage.select_first_pokemon_card_result();
    addProductPage.should_be_on_product_page("PKM - Sword & Shield 11 Lost Origin Booster - EN");

}

    @Test
    public void user_can_add_product_to_cart_and_verify() {
        initialization();
        String productName = "PKM - Sword & Shield 11 Lost Origin Booster - EN";
        addToCartSteps.search_for_product(productName);
        addToCartSteps.select_first_search_result();
        addToCartSteps.add_selected_product_to_cart();
        addToCartSteps.go_to_cart();
        addToCartSteps.should_see_finalize_order_button();
    }

}
