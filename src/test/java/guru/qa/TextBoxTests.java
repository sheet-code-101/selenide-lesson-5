package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @BeforeAll
    static void setup(){
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.startMaximized = true;
    }

    @Test
    void positiveFillTest(){
        open("/text-box");
        $("#userName").setValue("Aleh");
        $("#userEmail").setValue("123@123.ru");
        $("#currentAddress").setValue("street1");
        $("#permanentAddress").setValue("street 2");
        $("#submit").click();

        $("#name").shouldHave(text("Aleh"));
        $("#email").shouldHave(text("123@123.ru"));
        $("#currentAddress", 1).shouldHave(text("street1"));
        $("#permanentAddress", 1).shouldHave(text("street 2"));
    }
}
