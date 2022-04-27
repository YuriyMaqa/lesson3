package tests;

import com.github.javafaker.Faker;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationFormPage;

import static java.lang.String.format;

@Tag("demoqa")
@Owner("YuriyMaqa")
@Feature("Учебные тесты")
@Story("Тест формы регистрации")
public class TextBoxTests extends TestBase {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    Faker faker = new Faker();

    String firstname = faker.name().firstName(),
            lastname = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            gender = "Female",
            subject = "English",
            day = "30",
            month = "December",
            year = "1990",
            hobbies = "Music",
            file = "1.jpg",
            currentAddress = faker.address().fullAddress(),
            state = "Haryana",
            city = "Karnal",
            phoneNumber = faker.numerify("##########");

    String expectedFullName = format("%s %s", firstname, lastname),
            dateOfBirth = format("%s %s,%s", day, month, year),
            stateCity = format("%s %s", state, city);



    @Test
    @DisplayName("Тест формы регистрации")
    void fillFormTest() {


        registrationFormPage.openPage()

                .setFirstName(firstname)
                .setLastName(lastname)
                .setEmail(email)
                .setGender(gender)
                .setUserNumber(phoneNumber)
                .setBirthDate(day, month, year)
                .setSubjects(subject)
                .setHobbies(hobbies)
                .uploadFile(file)
                .setCurrentAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .clickSubmit();


        registrationFormPage
                .checkResult("Student Name", expectedFullName)
                .checkResult("Student Email", email)
                .checkResult("Gender", gender)
                .checkResult("Mobile", phoneNumber)
                .checkResult("Date of Birth", dateOfBirth)
                .checkResult("Hobbies", hobbies)
                .checkResult("Picture", file)
                .checkResult("Address", currentAddress)
                .checkResult("State and City", stateCity)
                .checkResult("Subjects", subject)
                .clickCloseModal();
    }
}