package guru.qa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests {

    @BeforeAll
    static void setup() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";

    }

    @Test
    void fillFormTest() {


        Selenide.open("/automation-practice-form");
        $("#firstName").setValue("Lu");
        $("#lastName").setValue("Chon");
        $("#userEmail").setValue("lee@gmail.com");
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("9165355574");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("December");
        $(".react-datepicker__year-select").selectOption("1990");
        $("[aria-label$='December 30th, 1990']").click();
        $("#subjectsInput").setValue("E").pressEnter();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("1.jpg");


    }
}
