package tdtp.morningcoffee.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

@DefaultUrl("https://lighthouse-demo.evozon.com/buildings")
public class BuildingsPage extends PageObject {
    @FindBy(className = "notification-error")
    private WebElementFacade notificationError;

    @FindBy(className = "notification-success")
    private WebElementFacade notificationSuccess;

    @FindBy(css = "button[class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-fullWidth']")
    private WebElementFacade addBuildingButton;

    @FindBy(name = "label")
    private WebElementFacade buildingNameInput;

    @FindBy(name = "safeDistance")
    private WebElementFacade safeDistanceInput;

    @FindBy(tagName = "button")
    private List<WebElementFacade> saveButton_;

    public void initiateAddBuilding() {addBuildingButton.click();}

    public void enter_name(String buildingName) {
        buildingNameInput.type(buildingName);
    }

    public void enter_distance(String safeDistance) {
        safeDistanceInput.type(safeDistance);
    }

    public void save_building() {
        for (WebElementFacade element : saveButton_) {
            if (element.getText().equals("SAVE")) {
                element.click();
            }
        }
    }

    public boolean is_error_displayed() {
        return notificationError.isDisplayed();
    }

    public boolean is_success_displayed() {
        return notificationSuccess.isDisplayed();
    }

    public List<String> getErrorMessages() {
        return findAll(By.className("notification"))
                .stream()
                .map(WebElementFacade::getText)
                .collect(Collectors.toList());
    }
}
