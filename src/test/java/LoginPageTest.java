import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class LoginPageTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";

        Configuration.browser = "chrome";
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";

        ChromeOptions options = new ChromeOptions();
        Map<String, Object> selenoidOptions = new HashMap<>();
        selenoidOptions.put("enableVNC", true);
        selenoidOptions.put("enableVideo", false);

        options.setCapability("selenoid:options", selenoidOptions);
        Configuration.browserCapabilities = options;

    }

    @Test
    void successfulLoginPage() {

        String firstName = "Denis";
        String lastName = "Rudovich";
        String userEmail = "d.rudovich@gmail.com";
        String userNumber = "375445856568";
        File address = new File(
                "C:\\Users\\Lenovo\\OneDrive\\Desktop\\календарь\\Coat_of_Arms_of_Łuniniec,_Belarus.svg.png");
        String currentAddress = "Bogdanovicha 6";

        //open form for testing
        open("/automation-practice-form");

        //enter all values
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#genterWrapper").$(byText("Other")).click();
        $("#userNumber").setValue(userNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $("[aria-label='Choose Saturday, July 5th, 2025']").click();
        $(".subjects-auto-complete__value-container").click();
        $("#subjectsContainer input").setValue("english").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFile(address);
        $("#currentAddress").setValue(currentAddress);

        //added JS for remove banner
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        //enter submit button
        $("#submit").shouldBe(visible, enabled).click();

        //some chek for ower form
        $(".table-dark").shouldHave(text("Label"));
        $(".table-dark").shouldHave(text(firstName));

        //sleep for 2ms
        sleep(2000);
    }
}
