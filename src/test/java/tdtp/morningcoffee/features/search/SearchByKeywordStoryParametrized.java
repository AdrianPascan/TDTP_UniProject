package tdtp.morningcoffee.features.search;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import tdtp.morningcoffee.steps.serenity.EndUserSteps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("src/test/resources/WikiTestData.csv")
public class SearchByKeywordStoryParametrized {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public EndUserSteps anna;

    String name, definition;

    @Issue("#WIKI-1")
    @Test
    public void searching_by_keyword_should_display_the_corresponding_article() {
        anna.is_the_home_page();
        anna.looks_for(name);
        anna.should_see_definition(definition);

    }

//    @Test
//    public void searching_by_keyword_banana_should_display_the_corresponding_article() {
//        anna.is_the_home_page();
//        anna.looks_for("pear");
//        anna.should_see_definition("An edible fruit produced by the pear tree, similar to an apple but elongated towards the stem.");
//    }

//    @Pending @Test
//    public void searching_by_ambiguious_keyword_should_display_the_disambiguation_page() {
//    }
} 