package testpackage;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import pages.MyTenders;
import steps.MyTendersSteps;

@RunWith(SerenityRunner.class)
public class WhenMyTendersTest extends MyTenders {

    @Managed(driver = "chrome", uniqueSession=true)
    WebDriver driver;

    @Steps
    MyTendersSteps steps;

    @Before
    public void beforeMethod(){
        driver.manage().window().maximize();
        steps.open_login_main_page();
        steps.click_button(buttonLogin);
        steps.type_login("AdminTestitMyTenders");
        steps.type_password("Hyqpmaz0/");
        steps.click_button(buttonSignIn);
    }

    public void openMyTenders(){
        steps.click_button(openTabMenu);
        steps.click_button(buttonTabMenuMyTenders);
    }

    @Test
    @Title("Проверка добавления и удаления тендера")
    public void checkAddAndDeleteTender(){

        steps.click_button(tabListAutoSearch);
        steps.click_button(buttonInAutoSearchListCheckMyTenders);
        steps.wait_a_bit(1000);
        steps.add_in_my_tenders();
        openMyTenders();
        steps.wait_a_bit(1000);
        steps.check_register_number_added_tender();
        steps.check_name_added_tender();
        steps.click_button(buttonDeleteAddedTenderInListTenders);
        steps.click_button(buttonConfirmDelete);
        steps.wait_a_bit(1000);
        steps.check_delete_added_tender();
    }

    @Test
    @Title("Проверка кликабельности кнопок тендера в списке тендеров")
    public void checkClickableButtonTenderInListTenders(){

        openMyTenders();
        steps.wait_a_bit(1000);
        steps.check_clickable_button_delete_tender_in_list_tenders();
        steps.check_clickable_button_load_documentation_tender_in_list_tenders();
    }



}
