package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.github.javafaker.Faker;
import pages.PracticeFormPage;

public class AutomationPracticeFormTestWithPageObject {

    PracticeFormPage practiceFormPage = new PracticeFormPage();
    Faker faker = new Faker();

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = faker.internet().emailAddress();
    String gender = "Male";
    String phoneNumber = faker.number().digits(10);
    String birthYear = "1992";
    String birthMonth = "May";
    String birthDay = "19";
    String subject = "Math";
    String filePath = "src/test/resources/stock.jpeg";
    String fileName = "stock.jpeg";
    String address = faker.address().fullAddress();
    String state = "Rajasthan";
    String city = "Jaipur";

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void formFillTest(){
        practiceFormPage
                .openPracticeFormPage()
                .inputFirstName(firstName)
                .inputLastName(lastName)
                .inputEmail(email)
                .selectGender(gender)
                .inputPhoneNumber(phoneNumber)
                .setBirthDate(birthYear, birthMonth, birthDay)
                .inputSubject(subject)
                .uploadPicture(filePath)
                .inputAddress(address)
                .inputState(state)
                .inputCity(city)
                .submitForm();

        practiceFormPage
                .checkStudentName(firstName + " " + lastName)
                .checkStudentEmail(email)
                .checkGenderValue(gender)
                .checkPhoneNumber(phoneNumber)
                .checkBirthDate(birthDay + " " + birthMonth + "," + birthYear)
                .checkSubjectValue(subject)
                .checkUploadedPicture(fileName)
                .checkAddressValue(address)
                .checkStateAndCityValues(state + " " + city);
    }
}

