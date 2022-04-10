package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponents;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationFormPage {

    CalendarComponents calendar = new CalendarComponents();


    //locators

    SelenideElement
            stateButton = $("#state"),
            stateCityWrapper = $("#stateCity-wrapper");

    //actions

    public RegistrationFormPage openPage() {
        Selenide.open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    public RegistrationFormPage setFirstName(String value) {
        $("#firstName").setValue(value);

        return this;
    }

    public RegistrationFormPage setLastName(String value) {
        $("#lastName").setValue(value);

        return this;
    }

    public RegistrationFormPage setEmail(String value) {
        $("#userEmail").setValue(value);

        return this;
    }

    public RegistrationFormPage setGender(String value) {
        $("#genterWrapper").$(byText(value)).click();

        return this;
    }


    public RegistrationFormPage setUserNumber(String value) {
        $("#userNumber").setValue(value);

        return this;
    }

    public RegistrationFormPage setBirthDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendar.setDate(day, month, year);

        return this;
    }

    public RegistrationFormPage setSubjects(String value) {
        $("#subjectsInput").setValue(value).pressEnter();

        return this;
    }

    public RegistrationFormPage setHobbies(String value) {
        $("#hobbiesWrapper").$(byText(value)).click();

        return this;
    }

    public RegistrationFormPage uploadFile(String value) {
        $("#uploadPicture").uploadFromClasspath(value);

        return this;
    }

    public RegistrationFormPage setCurrentAddress(String value) {
        $("#currentAddress").setValue(value);

        return this;
    }

    public RegistrationFormPage setState(String value) {
        stateButton.scrollTo();
        stateButton.click();
        stateCityWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationFormPage setCity(String value) {
        $("#city").click();
        stateCityWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationFormPage clickSubmit() {
        $("#submit").click();

        return this;
    }

    public RegistrationFormPage checkResult(String key, String value) {
        $(".table-responsive").$(byText(key))
                .parent().shouldHave(text(value));

        return this;
    }

    public RegistrationFormPage clickCloseModal() {
        $("#closeLargeModal").click();

        return this;
    }
}
