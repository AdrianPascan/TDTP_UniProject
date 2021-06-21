package tdtp.morningcoffee.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

// TODO: complete with user & password
@DefaultUrl("https://user:password@lighthouse-demo.evozon.com/login")
public class SignInPage extends PageObject {
    @FindBy(css = "img[src='/login-logo/login_logo.png']")
    private WebElementFacade logoImage;

    @FindBy(name = "username")
    private WebElementFacade usernameInput;

    @FindBy(name = "password")
    private WebElementFacade passwordInput;

    @FindBy(css = "button[class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-fullWidth']")
    private WebElementFacade signInButton;

    public boolean is_logo_image_displayed() {
        return logoImage.isDisplayed();
    }

    public void enter_username(String username) {
        usernameInput.type(username);
    }

    public void enter_password(String password) {
        passwordInput.type(password);
    }

    public void initiate_sign_in() {
        signInButton.click();
    }

    public List<String> getErrorMessages() {
        return findAll(By.cssSelector("p[class='MuiFormHelperText-root MuiFormHelperText-contained Mui-error MuiFormHelperText-marginDense']"))
                .stream()
                .map(WebElementFacade::getText)
                .collect(Collectors.toList());
    }

    public WebElementFacade getLogoImage() {
        return logoImage;
    }
}
