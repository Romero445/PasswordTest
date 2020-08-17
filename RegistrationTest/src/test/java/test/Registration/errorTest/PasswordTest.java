package test.Registration.errorTest;

import org.junit.jupiter.api.Test;
import test.base.BaseTest;

import static constants.Constants.TestData.*;
import static constants.Constants.Urls.LOGIN_URL;


public class PasswordTest extends BaseTest {

    @Test
    public  void checkRegistration() {
        basePage.goToUrl(LOGIN_URL);
        registrationPage
                .inputFirstName(NAME)
                .inputLastName(LAST_NAME)
                .inputPhoneNumber(PHONE_NUMBER)
                .inputEmail(EMAIL)
                .formPosition()
                .clickPosition()
                .inputCompany(COMPANY)
                .inputNumberJobOpenings(JOB_OPENINGS)
                .inputSendPassword(PASSWORD)
                .finishRegistration()
                .switchFrame()
                .passError("Неправильная длина: должна составлять 12 символов или более");



    }
}
