package testpackage;


import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import pages.AutoSearchPage;
import steps.AutoSearchSteps;

@RunWith(SerenityRunner.class)
public class WhenAutoSearch extends AutoSearchPage {

    @Managed(driver = "chrome", uniqueSession=true)
    WebDriver driver;


    @Steps
    AutoSearchSteps steps;

    @Test
    @Title("Проверка входа")
    public void checkSignIn(){

        steps.open_login_main_page();
        steps.clickButton(logInButton);
        steps.type_login("AdminTestit");
        steps.type_password("Hyqpmaz0");
        steps.clickButton(signInButton);
        steps.check_text_login();
    }
}
