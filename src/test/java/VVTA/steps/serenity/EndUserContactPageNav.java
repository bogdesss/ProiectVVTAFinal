package VVTA.steps.serenity;
import net.thucydides.core.annotations.Step;
import VVTA.pages.ContactPage;
import static org.junit.Assert.assertEquals;
public class EndUserContactPageNav {
    ContactPage contactPage;

    @Step
    public void opens_contact_page() {
        contactPage.navigateToContactPage();
    }

    @Step
    public void should_be_on_contact_page() {
        String expectedUrl = "https://shop.guildhall.ro/contact";
        String actualUrl = contactPage.getDriver().getCurrentUrl();
        assertEquals("User is not on the expected contact page.", expectedUrl, actualUrl);

    }
}
