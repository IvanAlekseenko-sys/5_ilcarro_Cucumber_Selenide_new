package ilcarro.core;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BasePage {

    public BasePage() {
        Configuration.browser = "chrome";
        Configuration.timeout = 5000;
        Configuration.holdBrowserOpen = false;
        Configuration.browserSize = "1200x800";
        Configuration.pageLoadTimeout = 5000;
    }

    public void launchBrowser() {
        open("about:blank");
        getWebDriver().manage().window().setPosition(new Point(2200, 200));
        getWebDriver().manage().window().maximize();
    }

    public void quitBrowser() {
        closeWebDriver();
    }
}
