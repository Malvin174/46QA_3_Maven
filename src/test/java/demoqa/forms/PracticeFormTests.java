package demoqa.forms;

import demoqa.core.TestBase;
import demoqa.pages.HomePage;
import demoqa.pages.PracticeFormPage;
import demoqa.pages.SidePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PracticeFormTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(app.driver).getForms().hideAds();
        new SidePage(app.driver).selectPracticeForm().hideAds();

    }

    @Test
    public void practiceFormTest() {
        new PracticeFormPage(app.driver)
                .enterPersonalData("Samanta", "Fox", "sam_sam@gmail.com", "1234567890")
                .selectGender("Female")
                .chooseDateAsString("21 October 1968")
                //.chooseDate("21", "October", "1968")
                .enterSubject(new String[]{"Maths", "English"})
                .chooseHobbies(new String[]{"Sports", "Music"})
                .uploadPicture("C:/Users/user/Downloads/beautiful-blooming-flowers-spring-season_23-2150790288.jpeg")
                .enterCurrentAddress("Portishead, Bristol, UK")
                .enterState("NCR")
                .enterCity("Delhi")
                .submitForm()
                .veryfySuccessRegistration("Thanks for submitting the form")
        ;
    }
    //"Samanta", "Fox", "sam_sam@gmail.com", "1234567890"
    @Test
    @Parameters({"firstName", "lastName", "email", "phone"})
    public void practiceFormParametersTest(String firstName, String lastName, String email, String phone) {
        String newName = "fgghj";//esli nado dobavit randomno imja
          //System.currentTimeMillis() = esli nado dobavit randomno email
        new PracticeFormPage(app.driver)
                .enterPersonalData(firstName+newName,lastName, System.currentTimeMillis()+email, phone )
                .selectGender("Female")
                .chooseDateAsString("21 October 1968")
                //.chooseDate("21", "October", "1968")
                .enterSubject(new String[]{"Maths", "English"})
                .chooseHobbies(new String[]{"Sports", "Music"})
                .uploadPicture("C:/Users/user/Downloads/beautiful-blooming-flowers-spring-season_23-2150790288.jpeg")
                .enterCurrentAddress("Portishead, Bristol, UK")
                .enterState("NCR")
                .enterCity("Delhi")
                .submitForm()
                .veryfySuccessRegistration("Thanks for submitting the form")
        ;
    }
}
