package pages.components;

import static com.codeborne.selenide.Selenide.$;

public class SubjectsComponent {

    void openSubjectsComponentInput() {

        $(".subjects-auto-complete__value-container").click();
        $("#subjectsContainer input").setValue("english").pressEnter();
    }
}
