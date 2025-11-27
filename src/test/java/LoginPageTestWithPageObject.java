import org.junit.jupiter.api.Test;
import pages.components.LoginPage;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class LoginPageTestWithPageObject extends TestBase {

    @Test
    void successfulLoginPage() {

        String firstName = "Denis";
        String lastName = "Rudovich";
        String userEmail = "d.rudovich@gmail.com";
        String genterWrapper = "Other";
        String userNumber = "375445856568";
        String hobbiesWrapper = "Sports";
        File file = new File("src/test/resources/IMG_8298.jpg");
        String currentAddress = "Bogdanovicha 6";

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
