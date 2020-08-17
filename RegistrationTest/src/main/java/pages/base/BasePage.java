package pages.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static constants.Constants.TimeoutsVariables.EXPLICIT_WAIT;

public class BasePage {
    public WebDriver driver;
    public BasePage (WebDriver driver){
        this.driver = driver;
    }

    /**
    *the method for navigating to a specific url
    * */
    public void goToUrl(String url){
        driver.get(url);
    }

    /**
     *
     * Wait element Is visible in DOM
     */

    public WebElement waitElementIsVisible(WebElement element){
        new WebDriverWait(driver, EXPLICIT_WAIT).until(ExpectedConditions.visibilityOf(element));
        return element;

    }


}
