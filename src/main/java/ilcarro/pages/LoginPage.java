package ilcarro.pages;

import ilcarro.utils.PropertiesLoader;
import io.cucumber.datatable.DataTable;

import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {
    public static String VALID_EMAIL = PropertiesLoader.loadProperty("valid.email");
    public static String VALID_PASSWORD = PropertiesLoader.loadProperty("valid.password");
    
    public void enterCredentials(String email, String password) {
        $("#email").setValue(email);
        $("#password").setValue(password);
    }

    public void clickOnYallaButton() {
        $(byXpath("//button[.='Y’alla!']")).click();
    }

    public void verifyTextMessage(String textToCheck) {
        $(".message").shouldHave(text(textToCheck));
        $(byXpath("//button[contains(text(),'Ok')]")).click();
    }

    public void enterCredentials(DataTable table) {
        List<Map<String, String>> dataTable = table.asMaps();
        String email = dataTable.get(0).get("email");
        String password = dataTable.get(0).get("password");
        enterCredentials(email, password);
    }
}
