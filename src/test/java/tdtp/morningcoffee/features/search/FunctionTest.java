package tdtp.morningcoffee.features.search;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import io.restassured.specification.RequestSender;
import net.thucydides.core.util.EnvironmentVariables;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import model.User;

import tdtp.morningcoffee.steps.serenity.EndUserSteps;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.isEmptyString;

@RunWith(SerenityRunner.class)
public class FunctionTest {
    private String theRestApiBaseUrl;
    private EnvironmentVariables environmentVariables;
    private Actor sam;


    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public EndUserSteps anna;

    @Before
    public void configureBaseUrl() {
        theRestApiBaseUrl = environmentVariables.optionalProperty("restapi.baseurl")
                    .orElse("https://lighthouse-demoapi.evozon.com");

        sam = Actor.named("Sam the supervisor").whoCan(CallAnApi.at(theRestApiBaseUrl));
    }
    @Test
    public void test1() {
        Gson g = new Gson();
        User user = new User("camelia.zalum@stud.ubbcluj.ro", "Aa#123456");
        System.out.println(g.toJson(user));
        sam.attemptsTo(Post.to(theRestApiBaseUrl + "https://lighthouse-demoapi.evozon.com/login").with(
                request-> request.body(g.toJson(user))));

        sam.should(seeThatResponse(response -> response.statusCode(200)));


    }
    @Test
    public void test2() {
        Gson g = new Gson();
        User user = new User("camelia.zalum@stud.ubbcluj.ro", "Aa#1234.56");
        System.out.println(g.toJson(user));
        sam.attemptsTo(Post.to(theRestApiBaseUrl + "https://lighthouse-demoapi.evozon.com/login").with(
                request-> request.body(g.toJson(user))));

        sam.should(seeThatResponse(response -> response.statusCode(503)));


    }
    @Test
    public void test3() {
        Gson g = new Gson();
        User user = new User("camelia.zalum@stud.ubbcluj.ro", "");
        System.out.println(g.toJson(user));
        sam.attemptsTo(Post.to(theRestApiBaseUrl + "https://lighthouse-demoapi.evozon.com/login").with(
                request-> request.body(g.toJson(user))));

        sam.should(seeThatResponse(response -> response.statusCode(503)));


    }
    @Test
    public void test4() {
        Gson g = new Gson();
        User user = new User("camelia.zalum", "Aa#123456");
        System.out.println(g.toJson(user));
        sam.attemptsTo(Post.to(theRestApiBaseUrl + "https://lighthouse-demoapi.evozon.com/login").with(
                request-> request.body(g.toJson(user))));

        sam.should(seeThatResponse(response -> response.statusCode(403)));


    }
    @Test
    public void test5() {
        Gson g = new Gson();
        User user = new User("cameliazalum@stud.ubbcluj.ro", "Aa#123456");
        System.out.println(g.toJson(user));
        sam.attemptsTo(Post.to(theRestApiBaseUrl + "https://lighthouse-demoapi.evozon.com/login").with(
                request-> request.body(g.toJson(user))));

        sam.should(seeThatResponse(response -> response.statusCode(403)));


    }
    @Test
    public void test6() {
        Gson g = new Gson();
        User user = new User("", "Aa#123456");
        System.out.println(g.toJson(user));
        sam.attemptsTo(Post.to(theRestApiBaseUrl + "https://lighthouse-demoapi.evozon.com/login").with(
                request-> request.body(g.toJson(user))));

        sam.should(seeThatResponse(response -> response.statusCode(403)));


    }
}