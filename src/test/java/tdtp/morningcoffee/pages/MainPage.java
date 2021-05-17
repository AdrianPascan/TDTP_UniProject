package tdtp.morningcoffee.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://lighthouse-demo.evozon.com/")
public class MainPage extends PageObject {
    @FindBy(css = "div[aria-controls='user-menu']")
    private WebElementFacade userDiv;

    public boolean is_user_div_displayed() {
        return userDiv.isDisplayed();
    }
}
