package appium.steps;

import appium.base.TestBase;
import appium.pages.MainPage;
import appium.util.ReusableFunctions;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CucumberStepDefs extends TestBase {

    public static AppiumDriver driver;
    public static MainPage _mainPage;

    public static SoftAssert _softAssert;
    public static ReusableFunctions _reusableFunc;
    Scenario _scenario;

    @Before
    public void initializeScenario(Scenario scenarioInstance) {
        this._scenario = scenarioInstance;
    }

    @Before
    public void setUp() {
        _mainPage = new MainPage();
        _softAssert = new SoftAssert();
        _reusableFunc = new ReusableFunctions();
    }


    @Given("^Clean install and launch demo app$")
    public void clean_install_and_launch_demo_app() throws Throwable {
        logger.info("Running Step: clean_install_and_launch_demo_app()");
        driver = initialization();
    }

    @After
    public void closeAllAppInstances() {
        if (_scenario.isFailed()) {
            _scenario.embed(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES), "image/png");
            _scenario.write("Scenario Failed: " + _scenario.getClass().getName());
            logger.info("Scenario Failed: " + _scenario.getClass().getName());

        } else {
            _scenario.write("Scenario Passed: " + _scenario.getClass().getName());
            logger.info("Scenario Passed: " + _scenario.getClass().getName());
        }
        if (driver != null) {
            driver.resetApp();
        }
    }

    @And("^I click on Let's begin$")
    public void iClickOnLetSBegin() {
        _reusableFunc.waitForElementPresent(driver, _mainPage.letsBegin);
        driver.findElement(_mainPage.letsBegin).click();
    }

    @Then("^I verify the error messages for DOB and community$")
    public void iVerifyTheErrorMessagesForDOBAndCommunity() {
        assertEquals(_reusableFunc.getTextByInnerText(driver, _mainPage.errorMessageDOB),
                "Please specify Date of Birth");
        assertTrue(_reusableFunc.getTextByInnerText(driver, _mainPage.community).
                contains("Please specify Caste / Community"));
    }

    @And("^I enter valid data for profile creator, DOB, mother tongue and community$")
    public void iEnterValidDataForProfileCreatorDOBMotherTongueAndCommunity() {
        _reusableFunc.click(driver, _mainPage.createProfileDropdown);
        _reusableFunc.click(driver, _mainPage.self);
        _reusableFunc.click(driver, _mainPage.male);
        List<WebElement> pick = driver.findElements(By.className("android.widget.EditText"));
        pick.get(2).sendKeys("2");
        pick.get(3).sendKeys("3");
        pick.get(4).sendKeys("0");
        pick.get(5).sendKeys("6");
        pick.get(6).sendKeys("1");
        pick.get(7).sendKeys("9");
        pick.get(0).sendKeys("9");
        pick.get(1).sendKeys("5");
        _reusableFunc.click(driver, _mainPage.motherTongue);
        _reusableFunc.click(driver, _mainPage.marathi);
        _reusableFunc.click(driver, _mainPage.community);
        _reusableFunc.click(driver, _mainPage.communityName);

    }

    @Then("^I verify on the next page an Email view is present\\.$")
    public void iVerifyOnTheNextPageAnEmailViewIsPresent() throws InterruptedException {
        Thread.sleep(2000);
        _reusableFunc.waitForElementPresent(driver, _mainPage.emailPage);
    }
}
