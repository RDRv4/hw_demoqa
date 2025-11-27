package pages.components;

import com.codeborne.selenide.SelenideElement;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class LoginPage {

    CalendarComponent calendarComponent = new CalendarComponent();
    SubjectsComponent subjectsComponent = new SubjectsComponent();

    private final SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genterWrapperInput = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            hobbiesWrapperInput = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            currentAddress = $("#currentAddress");

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

    public LoginPage setCurrentAddress(String value) {
        currentAddress.setValue(value);
        return this;
    }

    public LoginPage setComponentalendarComponent() {
        calendarComponent.openCalendarInput();
        return this;
    }

    public void setSubjectsComponent() {
        subjectsComponent.openSubjectsComponentInput();

    }


}
