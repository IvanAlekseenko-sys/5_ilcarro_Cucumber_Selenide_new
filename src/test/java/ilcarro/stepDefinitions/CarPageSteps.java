package ilcarro.stepDefinitions;

import ilcarro.pages.CarPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CarPageSteps {
    @When("Пользователь вводит данные автомобиля")
    public void userEnterCarData(DataTable table){
        new CarPage().enterCarData(table);
    }

    @And("Пользователь нажимает кнопку Submit")
    public void userClickOnSubmitButton() {
        new CarPage().clickOnSubmitButton();
    }

    @Then("Пользователь проверяет сообщение {string}")
    public void userVerifySuccessMessage(String text) {
        new CarPage().verifySuccessMessage(text);
    }
}
