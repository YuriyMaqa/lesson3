package pages;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxPage {


    SelenideElement
            inputUserName = $("#userName"),
            inputUserEmail = $("#userEmail"),
            inputUserCurrentAddress = $("#currentAddress"),
            inputUserPermanentAddress = $("#permanentAddress"),
            inputUserFormTitle = $(".main-header"),
            submitClick = $("#submit"),
            formResult = $(".border");


    public TextBoxPage openPage() {
        open("/text-box");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }

    public TextBoxPage setFirstName(String firstName) {
        inputUserName .setValue(firstName);
        return this;
    }

    public TextBoxPage setUserEmail(String userMainEmail) {
        inputUserEmail.setValue(userMainEmail);
        return this;
    }

    public TextBoxPage setCurrentAddress(String currentAddress) {
        inputUserCurrentAddress.setValue(currentAddress);
        return this;
    }
    public TextBoxPage setPermanentAddress(String PermanentAddress) {
        inputUserPermanentAddress.setValue(PermanentAddress);
        return this;
    }


    public TextBoxPage submitClick() {
        submitClick.click();
        return this;
    }


    public TextBoxPage checkResult(String value) {
        formResult.shouldHave(text(value));
        return this;
    }

    public TextBoxPage userFormTitle(String value) {
        inputUserFormTitle.shouldHave(text(value));
        return this;
    }
}
