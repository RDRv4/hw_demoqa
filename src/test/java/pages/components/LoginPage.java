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

    public LoginPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public LoginPage setFirstNameInput(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public LoginPage setLastNameInput(String value) {
        lastNameInput.setValue(value);
        return this;

    }

    public LoginPage setUserEmailInput(String value) {
        userEmailInput.setValue(value);
        return this;

    }

    public LoginPage setGenterWrapperInput(String value) {
        genterWrapperInput.$(byText(value)).click();
        return this;

    }

    public LoginPage setUserNumberInput(String value) {
        userNumberInput.setValue(value);
        return this;

    }

    public LoginPage setHobbiesWrapperInput(String value) {
        hobbiesWrapperInput.$(byText(value)).click();
        return this;

    }

    public LoginPage setUploadPicture(File file) {
        uploadPicture.uploadFile(file);
        return this;

    }

    public void setCurrentAddress(String value) {
        currentAddress.setValue(value);
    }
}
