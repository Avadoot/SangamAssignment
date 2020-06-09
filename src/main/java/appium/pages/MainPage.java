package appium.pages;

import appium.base.TestBase;
import org.openqa.selenium.By;

public class MainPage extends TestBase {

    public final By createProfileDropdown =
            By.xpath("//android.view.View[contains(@text,'Create Profile for')]");
    public final By date =
            By.xpath("//android.view.View[@resource-id='com.communityshaadi.android:id/dob-input']");
    public final By motherTongue =
            By.xpath("//android.widget.Button[contains(@text='Mother Tongue')]");
    public final By community =
            By.xpath("//android.widget.Button[contains(@text,'Community')]");
    public final By letsBegin =
            By.xpath("//android.widget.Button[contains(@text,'Lets Begin')]");
    public final By errorMessageDOB =
            By.xpath("//android.view.View[contains(@text,'Please specify Date of Birth')]");
    public final By self =
            By.xpath("//android.view.View[contains(@text,'Self')]");
    public final By male =
            By.xpath("//android.widget.RadioButton[contains(@text,'Male')]");
    public final By marathi =
            By.xpath("//android.widget.Button[@index='2']");
    public final By communityName =
            By.xpath("//android.widget.Button[contains(@text,'Hindu - Agri')]");
    public final By emailPage =
            By.xpath("//android.view.View[contains(@text='Where should we send you Profiles?')]");
}


