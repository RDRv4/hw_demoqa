package pages.components;

import com.codeborne.selenide.SelenideElement;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class LoginPage {

    private final SelenideElement firstNameInput = $("#firstName");
    private final SelenideElement lastNameInput = $("#lastName");
    private final SelenideElement userEmailInput = $("#userEmail");
    private final SelenideElement genterWrapperInput = $("#genterWrapper");
    private final SelenideElement userNumberInput = $("#userNumber");
    private final SelenideElement hobbiesWrapperInput = $("#hobbiesWrapper");
    private final SelenideElement uploadPicture = $("#uploadPicture");
    private final SelenideElement currentAddress = $("#currentAddress");

    public void openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
    }

    public void setFirstNameInput(String value) {
        firstNameInput.setValue(value);
    }

    public void setLastNameInput(String value) {
        lastNameInput.setValue(value);
    }

    public void setUserEmailInput(String value) {
        userEmailInput.setValue(value);
    }

    public void setGenterWrapperInput(String value) {
        genterWrapperInput.$(byText(value)).click();
    }

    public void setUserNumberInput(String value) {
        userNumberInput.setValue(value);
    }

    public void setHobbiesWrapperInput(String value) {
        hobbiesWrapperInput.$(byText(value)).click();
    }

    public void setUploadPicture(File file) {
        uploadPicture.uploadFile(file);
    }

    public void setCurrentAddress(String value) {
        currentAddress.setValue(value);
    }
}
