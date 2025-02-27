package ilcarro.stepDefinitions;

import ilcarro.core.BasePage;
import ilcarro.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;


public class HomePageSteps {
    @Given("Пользователь запускает браузер")
    public void userLaunchesBrowser() {
        new BasePage().launchBrowser();
    }

    @When("Пользователь открывает домашнюю страницу ilcarro")
    public void userOpensHomePage() {
        new HomePage().openHomePage();
    }

    @Then("Проверить что заголовок домашней страницы отображается")
    public void verifyHomePageTitle() {
        Assertions.assertTrue(new HomePage().isHomePageTitlePresent());
    }

    @And("Пользователь закрывает браузер")
    public void userQuitBrowser() {
        new BasePage().quitBrowser();
    }

    @And("Пользователь нажимает на ссылку Login")
    public void userClickOnLoginLink() {
        new HomePage().clickOnLoginLink();
    }
}
