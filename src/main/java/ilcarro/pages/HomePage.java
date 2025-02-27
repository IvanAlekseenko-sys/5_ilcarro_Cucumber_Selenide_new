package ilcarro.pages;

import ilcarro.core.BasePage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HomePage{

    public void openHomePage() {
        open("https://ilcarro.web.app/");
    }

    public boolean isHomePageTitlePresent() {
        return $("h1").shouldHave(text("Find your car now!")).isDisplayed();
    }

    public void clickOnLoginLink() {
         $(byXpath("//a[.=' Log in ']")).click();
    }
}
