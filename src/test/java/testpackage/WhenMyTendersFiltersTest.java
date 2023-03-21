package testpackage;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import pages.MyTendersFilters;
import steps.MyTendersFiltersSteps;
import steps.MyTendersSteps;

@RunWith(SerenityRunner.class)
public class WhenMyTendersFiltersTest extends MyTendersFilters {

    @Managed(driver = "chrome", uniqueSession=true)
    WebDriver driver;

    @Steps
    MyTendersFiltersSteps steps;

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
    @Title("Проверка количества фильтров")
    public void checkNumberFilters(){

        openMyTenders();
        steps.click_button(buttonOpenListFilters);
        steps.check_number_filters();
    }

    @Test
    @Title("Проверка поиска по реестровому номеру тендера")
    public void checkSearchByRegisterNumberTenderInTabCard(){

        openMyTenders();
        steps.type_search_by_tender("01");
        steps.wait_a_bit(2000);
        steps.check_search_by_register_number_tender_in_tab_cards();
    }

    @Test
    @Title("Проверка поиска по названию тендера")
    public void checkSearchByNameTenderInTabCard(){

        openMyTenders();
        steps.type_search_by_tender("усл");
        steps.wait_a_bit(2000);
        steps.check_search_by_name_tender_in_tab_cards();
    }

    @Test
    @Title("Проверка поиска по ответственному")
    public void checkSearchByUser(){

        openMyTenders();
        steps.click_button(filterResponsible);
        steps.click_button(firstElementInListFilter);
        steps.wait_a_bit(1000);
        steps.click_button(openCardFirstTender);
        steps.wait_a_bit(1000);
        steps.check_search_by_user_in_tab_cards();
    }

    @Test
    @Title("Проверка поиска по метке тендера")
    public void checkSearchByTags(){

        openMyTenders();
        steps.click_button(buttonOpenListFilters);
        steps.click_button(filterTags);
        steps.click_button(selectRedTagInList);
        steps.click_button(openCardFirstTender);
        steps.wait_a_bit(2000);
        steps.check_search_by_tags_in_tab_cards();
    }

    @Test
    @Title("Проверка на сброс значения фильтра \"Наличие задач\"")
    public void checkResetFilterAvailabilityTask(){

        openMyTenders();
        steps.click_button(buttonOpenListFilters);
        steps.click_button(filterAvailabilityTask);
        steps.click_button(firstElementInListFilter);
        steps.click_button(buttonClearFieldAvailabilityTask);
        steps.check_reset_filter_availability_task();
    }

    @Test
    @Title("Проверка наличия фильтра \"Поиск по этапам\"")
    public void checkVisibleFilterSearchByStages(){

        openMyTenders();
        steps.click_button(buttonOpenListFilters);
        steps.check_filter_search_by_stages();
    }
}
