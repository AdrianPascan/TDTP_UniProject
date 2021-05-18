package tdtp.morningcoffee.features.signin;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import tdtp.morningcoffee.steps.serenity.EndUserSteps;

@RunWith(SerenityRunner.class)
public class AddBuildingStory {
    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public EndUserSteps user;

    @Test
    public void add_building_should_succeed() {
        webdriver.manage().window().maximize();

        user.is_the_sign_in_page();
        user.signs_in("george.marian@stud.ubbcluj.ro", "Aa#123456");
        user.should_see_main_page();

        user.is_the_buildings_page();
        user.saves_building("mine", "99");
        user.should_see_success();
    }

    @Test
    public void add_building_should_fail() {
        webdriver.manage().window().maximize();

        user.is_the_sign_in_page();
        user.signs_in("george.marian@stud.ubbcluj.ro", "Aa#123456");
        user.should_see_main_page();

        user.is_the_buildings_page();
        user.saves_building("mine", "0");
        user.should_see_error();
    }
}
