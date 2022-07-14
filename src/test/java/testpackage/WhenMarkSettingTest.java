package testpackage;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import pages.MarkSetting;
import steps.MarkSettingSteps;

@RunWith(SerenityRunner.class)
public class WhenMarkSettingTest extends MarkSetting{

    @Managed(driver = "chrome", uniqueSession=true)
    WebDriver driver;

    @Steps
    MarkSettingSteps steps;

    @Before
    public void beforeMethod(){
        driver.manage().window().maximize();
        steps.open_login_main_page();
        steps.click_button(logInButton);
        steps.type_login("AdminTestitTender");
        steps.type_password("Hyqpmaz0");
        steps.click_button(signInButton);
    }

    @Test
    @Title("Проверка заблокированности кнопки удаления метки")
    public void checkMarkOfTender(){
        steps.click_button(tabListAutoSearch);
        steps.scroll_down_to(listAutoSearchToScroll);
        steps.click_button(buttonAutoSearchRegistryNumberAndRegion);
        steps.click_button(contextMenuResultSearch);
        steps.move_to_element(markContextMenu);
        steps.click_button(buttonSettingMark);
        steps.check_disabled_button_delete_mark();
    }
}
