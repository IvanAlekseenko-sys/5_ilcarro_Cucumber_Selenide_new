package ilcarro.pages;

import com.codeborne.selenide.CollectionCondition;
import io.cucumber.datatable.DataTable;

import java.io.File;
import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class CarPage {

    public void enterCarData(DataTable table) {
        List<Map<String, String>> dataTable = table.asMaps();
        String location = dataTable.get(0).get("location");
        String manufacture = dataTable.get(0).get("manufacture");
        String model = dataTable.get(0).get("model");
        String year = dataTable.get(0).get("year");
        String fuel = dataTable.get(0).get("fuel");
        String seats = dataTable.get(0).get("seats");
        String classCar = dataTable.get(0).get("classCar");
        String price = dataTable.get(0).get("price");
        String about = dataTable.get(0).get("about");
        String photo = dataTable.get(0).get("photo");
        System.out.println("Photo path: " + photo);

        enterCarDataToForm(location, manufacture, model, year, fuel, seats, classCar, price, about, photo);
    }

    private void enterCarDataToForm(
            String location,
            String manufacture,
            String model,
            String year,
            String fuel,
            String seats,
            String classCar,
            String price,
            String about,
            String photo) {
        $("#pickUpPlace").setValue(location);
        $$(".pac-item").shouldBe(CollectionCondition.sizeGreaterThan(0));
        $$(".pac-item").first().click();
        $("#make").setValue(manufacture);
        $("#model").setValue(model);
        $("#year").setValue(year);
        $("#fuel").selectOption(fuel);
        $("#seats").setValue(seats);
        $("#class").setValue(classCar);
        $("#serialNumber").setValue(String.valueOf(System.currentTimeMillis()));
        $("#price").setValue(price);
        $("#about").setValue(about);

//        $("#photos").setValue(photo);
//        $("#photos").val(photo);
//        $("#photos").append(photo);
        File file = new File(photo);
        System.out.println("Absolute file path: " + file.getAbsolutePath());
        System.out.println("File exists: " + file.exists());
        $("#photos").uploadFile(file);
        //$("#photos").uploadFile(new File(photo));
    }

    public void clickOnSubmitButton() {
        $x("//button[contains(text(),'Submit')]").click();
    }

    public void verifySuccessMessage(String textToCheck) {
        $(".message").shouldHave(text(textToCheck));
    }
}
