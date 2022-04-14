package tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import pages.TextBoxPage;
import java.util.stream.Stream;

@DisplayName("Демонстрация параметризованных тестов")
public class ParameterizedTextBoxTest {

    TextBoxPage textBoxPage = new TextBoxPage();
    Faker faker = new Faker();
    String  email = faker.internet().emailAddress(),
            currentAddress = faker.address().fullAddress(),
            permanentAddress = faker.address().fullAddress();

    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @ValueSource(strings = {
            "Petr",
            "Ivan"
    })

    @ParameterizedTest(name = "Проверка регистрации TextBox {0}")
     void textBoxParamTest(String testData) {
        textBoxPage.openPage()
                .setFirstName(testData)
                .setUserEmail(email)
                .setCurrentAddress(currentAddress)
                .setPermanentAddress(permanentAddress)
                .submitClick();

        textBoxPage
                .checkResult(testData)
                .checkResult(email)
                .checkResult(currentAddress)
                .checkResult(permanentAddress);
    }

    @CsvSource(value = {
            "Petr | petr@mail.ru | Street 1 | Street 3",
            "Ivan | ivan@mail.ru | Street 2 | Street 4"
    },
            delimiter = '|'
    )


    @ParameterizedTest(name = "Проверка регистрации TextBox CsvSource {1}")
    void csvSourceForm(String name, String email, String currentAddress, String permanentAddress) {
        textBoxPage.openPage().
                setFirstName(name)
                .setUserEmail(email)
                .setCurrentAddress(currentAddress)
                .setPermanentAddress(permanentAddress)
                .submitClick();
        textBoxPage.checkResult(name)
                .checkResult(email)
                .checkResult(currentAddress)
                .checkResult(permanentAddress);
    }

    static Stream<Arguments> methodSourceExampleTest() {
        return Stream.of(
                Arguments.of("Petr", "petr@mail.ru", "Street 1", "Street 3"),
                Arguments.of("Ivan", "ivan@mail.ru", "Street 2", "Street 4")
        );
    }

    @MethodSource("methodSourceExampleTest")
    @ParameterizedTest(name = "Проверка регистрации TextBox MethodSource {2}")
    void methodSourceExampleTest(String name, String email, String currentAddress, String permanentAddress) {
        textBoxPage.openPage().
                setFirstName(name)
                .setUserEmail(email)
                .setCurrentAddress(currentAddress)
                .setPermanentAddress(permanentAddress)
                .submitClick();
        textBoxPage.checkResult(name)
                .checkResult(email)
                .checkResult(currentAddress)
                .checkResult(permanentAddress);
    }
}
