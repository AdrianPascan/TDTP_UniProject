package tdtp.morningcoffee.features.signin;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import tdtp.morningcoffee.steps.serenity.EndUserSteps;

@RunWith(SerenityRunner.class)
public class SignInFailWithMessageStory {
    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public EndUserSteps user;

    @Test
    public void signing_in_with_no_username_should_fail_with_username_error_message() {
        webdriver.manage().window().maximize();

        user.is_the_sign_in_page();
        user.signs_in("", "password");
        user.should_see_username_sign_in_error();
    }

    @Test
    public void signing_in_with_no_password_should_fail_with_password_error_message() {
        webdriver.manage().window().maximize();

        user.is_the_sign_in_page();
        user.signs_in("username", "");
        user.should_see_password_sign_in_error();
    }

    @Test
    public void signing_in_with_no_credentials_should_fail_with_error_messages() {
        webdriver.manage().window().maximize();

        user.is_the_sign_in_page();
        user.signs_in("", "");
        user.should_see_username_sign_in_error();
        user.should_see_password_sign_in_error();
    }
}
