package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class AutomationPracticeFormTest {

    @BeforeAll
    static void setup() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.startMaximized = true;
    }

    @Test
    void formFillTest(){
        open("/automation-practice-form");

        // Filling the form
        $("#firstName").setValue("John");
        $("#lastName").setValue("Doe");
        $("#userEmail").setValue("john.doe@test.com");
        $(byText("Male")).click();
        $("#userNumber").setValue("1555985122");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("August");
        $(".react-datepicker__year-select").selectOption("1993");
        $(".react-datepicker__day--013").click();
        $("#subjectsInput").setValue("English").pressEnter();
        $(byText("Reading")).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/stock.jpeg"));
        $("#currentAddress").setValue("My Address");
        $("#react-select-3-input").setValue("Rajasthan").pressEnter();
        $("#react-select-4-input").setValue("Jaipur").pressEnter();
        $("#submit").click();

        // Form content verification
        $("tbody").$(byText("Student Name")).parent().shouldHave(text("John Doe"));
        $("tbody").$(byText("Student Email")).parent().shouldHave(text("john.doe@test.com"));
        $("tbody").$(byText("Gender")).parent().shouldHave(text("Male"));
        $("tbody").$(byText("Mobile")).parent().shouldHave(text("1555985122"));
        $("tbody").$(byText("Date of Birth")).parent().shouldHave(text("13 August,1993"));
        $("tbody").$(byText("Subjects")).parent().shouldHave(text("English"));
        $("tbody").$(byText("Hobbies")).parent().shouldHave(text("Reading"));
        $("tbody").$(byText("Picture")).parent().shouldHave(text("stock.jpeg"));
        $("tbody").$(byText("Address")).parent().shouldHave(text("My Address"));
        $("tbody").$(byText("State and City")).parent().shouldHave(text("Rajasthan Jaipur"));
    }
}

