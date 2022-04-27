package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
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

    @Step("Открываем страницу формы регистрации")
    public RegistrationFormPage openPage() {
        Selenide.open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    @Step("Заполняем поле имени")
    public RegistrationFormPage setFirstName(String value) {
        $("#firstName").setValue(value);

        return this;
    }

    @Step("Заполняем поле фамилии")
    public RegistrationFormPage setLastName(String value) {
        $("#lastName").setValue(value);

        return this;
    }

    @Step("Заполняем поле email")
    public RegistrationFormPage setEmail(String value) {
        $("#userEmail").setValue(value);

        return this;
    }

    @Step("Выбираем пол")
    public RegistrationFormPage setGender(String value) {
        $("#genterWrapper").$(byText(value)).click();

        return this;
    }

    @Step("Заполняем поле номера телефона")
    public RegistrationFormPage setUserNumber(String value) {
        $("#userNumber").setValue(value);

        return this;
    }

    @Step("Выбираем дату рождения")
    public RegistrationFormPage setBirthDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendar.setDate(day, month, year);

        return this;
    }

    @Step("заполняем поле предмета")
    public RegistrationFormPage setSubjects(String value) {
        $("#subjectsInput").setValue(value).pressEnter();

        return this;
    }

    @Step("Выбираем хобби")
    public RegistrationFormPage setHobbies(String value) {
        $("#hobbiesWrapper").$(byText(value)).click();

        return this;
    }

    @Step("Загружаем файл")
    public RegistrationFormPage uploadFile(String value) {
        $("#uploadPicture").uploadFromClasspath(value);

        return this;
    }

    @Step("Заполняем поле адреса")
    public RegistrationFormPage setCurrentAddress(String value) {
        $("#currentAddress").setValue(value);

        return this;
    }

    @Step("Выбираем штат")
    public RegistrationFormPage setState(String value) {
        stateButton.scrollTo();
        stateButton.click();
        stateCityWrapper.$(byText(value)).click();

        return this;
    }

    @Step("Выбираем город")
    public RegistrationFormPage setCity(String value) {
        $("#city").click();
        stateCityWrapper.$(byText(value)).click();

        return this;
    }

    @Step("Нажимаем кнопку submit")
    public RegistrationFormPage clickSubmit() {
        $("#submit").click();

        return this;
    }

    @Step("Проверка значений в таблице")
    public RegistrationFormPage checkResult(String key, String value) {
        $(".table-responsive").$(byText(key))
                .parent().shouldHave(text(value));

        return this;
    }

    @Step("Закрываем проверочную таблицу")
    public RegistrationFormPage clickCloseModal() {
        $("#closeLargeModal").click();

        return this;
    }
}
