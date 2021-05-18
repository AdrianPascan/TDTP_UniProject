package tdtp.morningcoffee.features.addbuilding;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.Qualifier;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import tdtp.morningcoffee.steps.serenity.EndUserSteps;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("src/test/resources/AddBuildingSuccess.csv")
public class AddBuildingStory {
    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public EndUserSteps user;

    public String name;
    public String distance;

    @Qualifier
    public String getQualifier() {
        return name;
    }

    public String getName() {
        return name;
    }

    public String getDistance() {
        return distance;
    }

    public void setName(String _name) {
        this.name = _name;
    }

    public void setDistance(String _dist) {
        this.distance = _dist;
    }

    @Test
    public void add_building_should_succeed() {
        webdriver.manage().window().maximize();

        user.is_the_sign_in_page();
        user.signs_in("marius.gabriel.teodorescu@stud.ubbcluj.ro", "Aa#123456");
        user.should_see_main_page();

        user.is_the_buildings_page();
        user.saves_building(getName(), getDistance());
        user.should_see_success();
    }
}
