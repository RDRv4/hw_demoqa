import org.junit.jupiter.api.*;
import pages.components.LoginPage;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class LoginPageTestWithPageObject extends TestBase {


    //@Disabled
    @DisplayName("Login page on /automation-practice-form")
    @Test
    @Tags({@Tag("UI_TEST")})
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


        //enter submit button
        $("#submit").shouldBe(visible, enabled).click();

        //some chek for ower form
        $(".table-dark").shouldHave(text("Label"));
        $(".table-dark").shouldHave(text(firstName));

        //sleep for 2ms
        sleep(2000);
    }

}
