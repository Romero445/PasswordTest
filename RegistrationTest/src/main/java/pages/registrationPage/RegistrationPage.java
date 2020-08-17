package pages.registrationPage;


import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.base.BasePage;



public class RegistrationPage extends BasePage {
    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    private final By firstName = By.xpath("//input[@id='first_name']");
    private final By lastName = By.xpath("//input[@id='last_name']");
    private final By phoneNumber = By.xpath("//input[@id='phone']");
    private final By getEmail = By.xpath("//input[@id='email']");
    private final By checkPosition = By.xpath("//select[@name='position']");
    private final By selectPosition = By.xpath("//option[@value='head_of_recruitment']");
    private final By selectCompany = By.xpath("//input[@id='company']");
    private final By numberJobOpenings = By.xpath("//input[@id='job_openings']");
    private final By sendPassword = By.xpath("//input[@id='password']");
    private final By clickRegistration = By.xpath("//button[@type='submit']");
    private final By passwordError = By.xpath("//div[@class='Field-error___2SSkA']");



    public RegistrationPage inputFirstName(String name) {
        driver.findElement(firstName).sendKeys(name);
        return this;
    }
    public RegistrationPage inputLastName(String lastN) {
        driver.findElement(lastName).sendKeys(lastN);
        return this;
    }

    public RegistrationPage inputPhoneNumber(String Phone){
        driver.findElement(phoneNumber).sendKeys(Phone);
        return this;
    }

    public RegistrationPage inputEmail (String email){
        driver.findElement(getEmail).sendKeys(email);
        return this;
    }

    public RegistrationPage formPosition ( ){
        driver.findElement(checkPosition).click();
        return this;
    }

    public RegistrationPage clickPosition (){
        driver.findElement(selectPosition).click();
        return this;
    }

    public RegistrationPage inputCompany(String company){
        driver.findElement(selectCompany).sendKeys(company);
        return this;
    }

    public RegistrationPage inputNumberJobOpenings (String jobOpenings){
        driver.findElement(numberJobOpenings).sendKeys(jobOpenings);
        return this;
    }
    public RegistrationPage inputSendPassword (String password){
        driver.findElement(sendPassword).sendKeys(password);
        return this;
    }

    public RegistrationPage finishRegistration (){
        driver.findElement(clickRegistration).click();
        return this;
    }

    public RegistrationPage switchFrame(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,650)", "");
        return this;

    }


    public RegistrationPage passError(String text){
        waitElementIsVisible(driver.findElement(passwordError));
        WebElement details = driver.findElement(passwordError);
        Assertions.assertEquals(text, details.getText());
        return this;
    }









}
