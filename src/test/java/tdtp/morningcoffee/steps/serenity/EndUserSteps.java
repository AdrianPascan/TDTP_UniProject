package tdtp.morningcoffee.steps.serenity;

import net.thucydides.core.annotations.Step;
import tdtp.morningcoffee.pages.BuildingsPage;
import tdtp.morningcoffee.pages.MainPage;
import tdtp.morningcoffee.pages.SignInPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

public class EndUserSteps {

    SignInPage signInPage;
    MainPage mainPage;
    BuildingsPage buildingsPage;


    // SIGN IN PAGE

    @Step
    public void is_the_sign_in_page() {
        signInPage.open();
        signInPage.waitFor(signInPage.getLogoImage());
    }

    @Step
    public void enters_username(String username) {
        signInPage.enter_username(username);
    }

    @Step
    public void enters_password(String password) {
        signInPage.enter_password(password);
    }

    @Step
    public void initiates_sign_in() {
        signInPage.initiate_sign_in();
    }

    @Step
    public void signs_in(String username, String password) {
        enters_username(username);
        enters_password(password);
        initiates_sign_in();
    }

    @Step
    public void should_see_sign_in_page() {
        assert (signInPage.is_logo_image_displayed());
    }

    @Step
    public void should_see_username_sign_in_error() {
        assertThat(signInPage.getErrorMessages(), hasItem(containsString("Username is a required field.")));
    }

    @Step
    public void should_see_password_sign_in_error() {
        assertThat(signInPage.getErrorMessages(), hasItem(containsString("Please enter a password.")));
    }


    // MAIN PAGE

    @Step
    public void is_the_main_page() {
        mainPage.open();
    }

    @Step
    public void should_see_main_page() {
        assert (mainPage.is_user_div_displayed());
    }

    // BUILDINGS PAGE

    @Step
    public void is_the_buildings_page() {
        buildingsPage.open();
    }

    @Step
    public void initiate_add_building() {
        buildingsPage.initiateAddBuilding();
    }

    @Step
    public void enters_bulding_name(String name) {
        buildingsPage.enter_name(name);
    }

    @Step
    public void enters_safe_distance(String dist) {
        buildingsPage.enter_distance(dist);
    }

    @Step
    public void add_building() {
        buildingsPage.save_building();
    }

    @Step
    public void saves_building(String name, String dist) {
        initiate_add_building();
        enters_bulding_name(name);
        enters_safe_distance(dist);
        add_building();
    }

    @Step
    public void should_see_error() {
        assertThat(buildingsPage.getErrorMessages(), hasItem(containsString("Error adding building!")));
    }

    @Step
    public void should_see_success() {
        assertThat(buildingsPage.getErrorMessages(), hasItem(containsString("Building saved!")));
    }
}