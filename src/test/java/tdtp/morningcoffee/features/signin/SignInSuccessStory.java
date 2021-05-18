package tdtp.morningcoffee.features.signin;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import tdtp.morningcoffee.steps.serenity.EndUserSteps;

@RunWith(SerenityRunner.class)
public class SignInSuccessStory {
    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public EndUserSteps user;

    @Test
    public void signing_in_should_succeed() {
        webdriver.manage().window().maximize();

        user.is_the_sign_in_page();
        user.signs_in("adrian.pascan@stud.ubbcluj.ro", "Aa#123456");
        user.should_see_main_page();
    }
}
