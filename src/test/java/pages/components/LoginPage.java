package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class LoginPage {

    private final SelenideElement firstNameInput = $("#firstName");
    private final SelenideElement lastNameInput = $("#lastName");
    private final SelenideElement userEmailInput = $("#userEmail");

    public void openPage(){
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
    }

    public void setFirstNameInput(String value){
        firstNameInput.setValue(value);
    }

    public void setLastNameInput(String value){
        lastNameInput.setValue(value);
    }

    public void setUserEmailInput(String value) {
        userEmailInput.setValue(value);
    }
}
