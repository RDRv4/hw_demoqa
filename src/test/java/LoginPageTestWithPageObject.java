import org.junit.jupiter.api.*;
import pages.components.LoginPage;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class LoginPageTestWithPageObject extends TestBase {


    @DisplayName("Test for Login Page")
    @Test
    @Tags({@Tag("UI_TEST_WITH_ALLURE")})
    void successfulLoginPage() {

        TestBase data = new TestBase();

        String firstName = data.firstName;
        String lastName = data.lastName;
        String userEmail = data.userEmail;
        String genterWrapper = "Other";
        String userNumber = data.userNumber;
        String hobbiesWrapper = "Sports";
        File file = new File("src/test/resources/IMG_8298.jpg");
        String currentAddress = data.currentAddress;

        LoginPage loginPage = new LoginPage();

        step("Open Page and Enter values", () -> {
            loginPage.openPage()
                    .setFirstNameInput(firstName)
                    .setLastNameInput(lastName)
                    .setUserEmailInput(userEmail)
                    .setGenterWrapperInput(genterWrapper)
                    .setUserNumberInput(userNumber)
                    .setHobbiesWrapperInput(hobbiesWrapper)
                    .setUploadPicture(file)
                    .setCurrentAddress(currentAddress)
                    .setComponentalendarComponent()
                    .setSubjectsComponent();
        });

        step("Enter submit button", () -> {
            $("#submit").shouldBe(visible, enabled).click();
        });

        step("Some chek for ower form", () -> {
            $(".table-dark").shouldHave(text("Label"));
            $(".table-dark").shouldHave(text(firstName));
        });
    }

}
