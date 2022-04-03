package guru.qa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class TextBoxTests {

    @BeforeAll
    static void setup() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1980x1020";

    }

    @Test
    void fillFormTest() {

        Selenide.open("/automation-practice-form");
        executeJavaScript("document.querySelector(\"footer\").hidden = " +
                "'true';document.querySelector(\"#fixedban\").hidden = 'true'");

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
        $("#currentAddress").setValue("1st street");
        $("#state").scrollTo();
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Karnal")).click();
        $("#submit").click();

        $(".table-responsive").shouldHave(text("Student Name Lu Chon"), text("Student Email lee@gmail.com")
                , text("Gender Female"), text("Mobile 9165355574"), text("Date of Birth 30 December,1990")
                , text("Subjects English"), text("Hobbies Music"), text("Picture 1.jpg"), text("Address 1st street"),
                text("State and City Haryana Karnal"));
        $("#closeLargeModal").click();
    }
}