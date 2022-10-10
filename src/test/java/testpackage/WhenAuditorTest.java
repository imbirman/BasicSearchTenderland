package testpackage;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import pages.Auditor;
import steps.AuditorSteps;

import java.text.ParseException;

@RunWith(SerenityRunner.class)
public class WhenAuditorTest extends Auditor {

    @Managed(driver = "chrome", uniqueSession=true)
    WebDriver driver;

    @Steps
    AuditorSteps steps;

    @Before
    public void beforeMethod(){
        driver.manage().window().maximize();
        steps.open_login_main_page();
        steps.click_button(buttonLogin);
        steps.type_login("AdminTestitAuditor");
        steps.type_password("Hyqpmaz0/");
        steps.click_button(buttonSignIn);
        steps.click_button(openTabMenu);
        steps.click_button(buttonTabMenuAuditor);
        steps.wait_a_bit(500);
    }

    @Test
    @Title("Проверка результатов поиска по реквизитам организации")
    public void checkResultSearchByOrganizationDetails(){
        steps.drag_and_drop_filter(filterOrganizationDetails);
        steps.wait_a_bit(500);
        steps.type_search_include("234703774440");
//        steps.wait_a_bit(500);
        steps.click_button(openTabMenu);
        steps.click_button(buttonSearch);
        steps.wait_a_bit(1000);
        steps.check_search_by_organization_details();
//        steps.wait_a_bit(5000);
    }

    @Test
    @Title("Проверка результатов поиска по учредителям")
    public void checkResultSearchByFounders(){
        steps.drag_and_drop_filter(filterSearchByFounders);
        steps.wait_a_bit(500);
        steps.type_search_include("иванов");
//        steps.wait_a_bit(500);
        steps.click_button(openTabMenu);
        steps.click_button(buttonSearch);
        steps.click_button(cellTableInResultSearch);
        steps.switch_to_tab();
        steps.click_button(buttonOpenListFounders);
        steps.wait_a_bit(1000);
        steps.check_search_by_founders();
//        steps.wait_a_bit(5000);
    }

    @Test
    @Title("Проверка результатов поиска по юридическому статусу 'Действующая'")
    public void checkResultSearchByCurrentLegalStatus(){
        steps.drag_and_drop_filter(filterSearchByLegalStatus);
        steps.wait_a_bit(500);
        steps.click_button(radioButtonCurrentLegalStatus);
//        steps.wait_a_bit(500);
        steps.click_button(openTabMenu);
        steps.click_button(buttonSearch);
        steps.click_button(cellTableInResultSearch);
        steps.switch_to_tab();
        steps.check_search_by_current_legal_status();
//        steps.wait_a_bit(5000);
    }

    @Test
    @Title("Проверка результатов поиска по юридическому статусу 'Недействующая'")
    public void checkResultSearchByInactiveLegalStatus(){
        steps.drag_and_drop_filter(filterSearchByLegalStatus);
        steps.wait_a_bit(500);
        steps.click_button(radioButtonInactiveLegalStatus);
//        steps.wait_a_bit(500);
        steps.click_button(openTabMenu);
        steps.click_button(buttonSearch);
        steps.click_button(cellTableInResultSearch);
        steps.switch_to_tab();
        steps.check_search_by_inactive_legal_status();
//        steps.wait_a_bit(5000);
    }

    @Test
    @Title("Проверка результатов поиска по дате регистрации")
    public void checkResultSearchByDateRegistration() throws ParseException {
        steps.click_button(tabListAutoSearch);
        steps.click_button(buttonAutoSearchDateRegistration);
        steps.check_date("01.01.2022 00:00","08.01.2022 23:59");
//        steps.wait_a_bit(5000);
    }

    @Test
    @Title("Проверка результатов поиска по дате закрытия")
    public void checkResultSearchByDateClosing() throws ParseException {
        steps.click_button(tabListAutoSearch);
        steps.click_button(buttonAutoSearchDateClosing);
        steps.check_date("01.01.2022 00:00","08.01.2022 23:59");
//        steps.wait_a_bit(5000);
    }

    @Test
    @Title("Проверка, что организация никогда не была в РНП")
    public void checkOrganizationNeverBeenInRNP(){
        steps.drag_and_drop_filter(filterSearchByStatusOfBeingInRNP);
        steps.wait_a_bit(500);
        steps.click_button(radioButtonNeverBeenInRNP);

        steps.click_button(openTabMenu);
        steps.click_button(buttonSearch);
        steps.wait_a_bit(1000);
        steps.click_button(cellTableInResultSearch);
        steps.switch_to_tab();
        steps.wait_a_bit(500);
        steps.scroll_down_to(fieldMainDataForScroll);
        steps.check_organization_never_been_in_rnp();
//        steps.wait_a_bit(5000);
    }

    @Test
    @Title("Проверка, что организация была раньше в РНП")
    public void checkOrganizationFormerlyBeenInRNP(){
        steps.drag_and_drop_filter(filterSearchByStatusOfBeingInRNP);
        steps.click_button(radioButtonFormerlyInRNP);
        steps.click_button(openTabMenu);
        steps.click_button(buttonSearch);
        steps.wait_a_bit(1000);
        steps.click_button(cellTableInResultSearch);
        steps.switch_to_tab();
        steps.wait_a_bit(500);
        steps.scroll_down_to(fieldMainDataForScroll);
        steps.check_organization_formerly_been_in_rnp();
//        steps.wait_a_bit(5000);
    }

    @Test
    @Title("Проверка, что организация находится в РНП")
    public void checkOrganizationLocatedInRNP(){
        steps.drag_and_drop_filter(filterSearchByStatusOfBeingInRNP);
        steps.click_button(radioButtonLocatedInRNP);
        steps.click_button(openTabMenu);
        steps.wait_a_bit(1000);
        steps.click_button(cellTableInResultSearch);
        steps.switch_to_tab();
        steps.wait_a_bit(500);
        steps.scroll_down_to(fieldMainDataForScroll);
        steps.check_organization_located_in_rnp();
//        steps.wait_a_bit(5000);
    }

    @Test
    @Title("Проверка количества элементов контекстного меню")
    public void checkCorrectNumberElementsContextMenu(){
        steps.drag_and_drop_filter(filterOrganizationDetails);
        steps.wait_a_bit(500);
        steps.type_search_include("234703774440");
        steps.click_button(openTabMenu);
        steps.click_button(buttonSearch);
        steps.click_button(contextMenu);
        steps.check_correct_number_elements_context_menu();
    }
}
