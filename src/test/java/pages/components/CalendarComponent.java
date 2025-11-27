package pages.components;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    void openCalendarInput() {

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $("[aria-label='Choose Saturday, July 5th, 2025']").click();
    }
}
