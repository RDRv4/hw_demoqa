import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.components.LoginPage;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class LoginPageTestWithPageObject {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successfulLoginPage() {

        String firstName = "Denis";
        String lastName = "Rudovich";
        String userEmail = "d.rudovich@gmail.com";
        String genterWrapper = "Other";
        String userNumber = "375445856568";
        String hobbiesWrapper = "Sports";

        File file = new File(
                "src/test/resources/IMG_8298.jpg");
        String currentAddress = "Bogdanovicha 6";

        LoginPage loginPage = new LoginPage();
        loginPage.openPage();

        loginPage.setFirstNameInput(firstName);
        loginPage.setLastNameInput(lastName);
        loginPage.setUserEmailInput(userEmail);
        loginPage.setGenterWrapperInput(genterWrapper);
        loginPage.setUserNumberInput(userNumber);
        loginPage.setHobbiesWrapperInput(hobbiesWrapper);
        loginPage.setUploadPicture(file);
        loginPage.setCurrentAddress(currentAddress);

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $("[aria-label='Choose Saturday, July 5th, 2025']").click();
        $(".subjects-auto-complete__value-container").click();
        $("#subjectsContainer input").setValue("english").pressEnter();

        //enter submit button
        $("#submit").shouldBe(visible, enabled).click();

        //some chek for ower form
        $(".table-dark").shouldHave(text("Label"));
        $(".table-dark").shouldHave(text(firstName));

        //sleep for 2ms
        sleep(2000);
    }

}
