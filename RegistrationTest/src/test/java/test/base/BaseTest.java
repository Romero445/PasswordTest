package test.base;

import common.CommonAction;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.registrationPage.RegistrationPage;
import pages.base.BasePage;


import java.io.File;
import java.time.LocalTime;
import java.util.Objects;

import static common.Confing.*;


@ExtendWith(Listener.class)

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {
    protected WebDriver driver = CommonAction.createDriver();
    protected BasePage basePage = new BasePage(driver);
    protected RegistrationPage registrationPage = new RegistrationPage (driver);
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseTest.class);

    static {
        LOGGER.info("START TIME"+ LocalTime.now());
        LOGGER.info("Start clear reports dir: dir/reports...");
        File allureResults = new File("allure-results");
        if(allureResults.isDirectory()){
            for(File item: Objects.requireNonNull(allureResults.listFiles()))
                item.delete();
        }
        if(CLEAR_REPORTS){
            File allureScreen= new File("build/reports/test");
            for(File item: Objects.requireNonNull(allureScreen.listFiles()))
                item.delete();

        }
    }

    @AfterEach
    void ClearCookiesAndLocalStorage(){
        if (CLEAR_COOKIES){
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            driver.manage().deleteAllCookies();
            javascriptExecutor.executeScript("window.sessionStorage.clear()");
        }
    }
    @AfterAll
    void close (){
        if(!HOLD_BROWSER_OPEN){
            driver.close();
        }

    }

}

