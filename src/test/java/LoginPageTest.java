import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Selenide.*;

public class LoginPageTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }


    @Test
    void successfulLoginPage() {

        String firstName = "Denis";
        String lastName = "Rudovich";
        String userEmail = "d.rudovich@gmail.com";
        String userNumber = "375445856566";
        File address = new File(
                "C:\\Users\\Lenovo\\OneDrive\\Desktop\\календарь\\Coat_of_Arms_of_Łuniniec,_Belarus.svg.png");
        String currentAddress = "Bogdanovicha 6";


        open("https://demoqa.com/automation-practice-form");

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $(".custom-control-label").click();
        $("#userNumber").setValue(userNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(6);
        $("[aria-label='Choose Saturday, July 5th, 2025']").click();
        $(".subjects-auto-complete__value-container").click();
        $(".subjects-auto-complete__value-container input").setValue("e").pressEnter();
        $$(".custom-control-label").get(4).click();
        $("#uploadPicture").uploadFile(address);
        $("#currentAddress").setValue(currentAddress);


        $("#submit").click();

        sleep(2000);


    }


}
