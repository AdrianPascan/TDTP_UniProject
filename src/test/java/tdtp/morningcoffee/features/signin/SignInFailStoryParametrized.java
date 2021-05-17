package tdtp.morningcoffee.features.signin;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import tdtp.morningcoffee.steps.serenity.EndUserSteps;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("src/test/resources/SignInFailTestData.csv")
public class SignInFailStoryParametrized {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public EndUserSteps user;

    private String username;
    private String password;

    @Issue("SIGN_IN_FAIL")
    @Test
    public void signing_in_should_fail() {
        webdriver.manage().window().maximize();

        user.is_the_sign_in_page();
        user.signs_in(username, password);
        user.should_see_sign_in_page();
    }
}
