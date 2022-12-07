package testpackage;


import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import pages.Filters;
import steps.FiltersSteps;

@RunWith(SerenityRunner.class)
public class WhenFiltersTest extends Filters {

    @Managed(driver = "chrome", uniqueSession=true)
    WebDriver driver;


    @Steps
    FiltersSteps steps;

    @Before
    public void beforeMethod(){
        driver.manage().window().maximize();
        steps.open_login_main_page();
        steps.click_button(buttonLogin);
        steps.type_login("AdminTestitTender");
        steps.type_password("Hyqpmaz0");
        steps.click_button(buttonSignIn);
    }

    @Test
    @Title("Проверка соответствия найденного значения по поиску в фильтре ОКПД")
    public void checkResultSearchFilterOKPD(){
        steps.drag_and_drop_filter(filterOKPD);
        steps.wait_a_bit(2000);
        steps.type_search("(85.11.10.000) Услуги в области дошкольного образования");
        steps.check_result_search_by_okpd();
//        steps.wait_a_bit(5000);
    }

    @Test
    @Title("Проверка отсутствия в окне фильтра выбранного значения при очистке поля поиска")
    public void checkSwitchShowOnlySelectedOKPDNo(){
        steps.drag_and_drop_filter(filterOKPD);
        steps.wait_a_bit(2000);
        steps.type_search("(85.11.10.000) Услуги в области дошкольного образования");
        steps.wait_a_bit(2000);
        steps.click_button(checkboxOKPD);
        steps.clear_field(fieldSearchInFilter);
        steps.wait_a_bit(2000);
        steps.check_switch_show_only_selected_no();
    }

    @Test
    @Title("Проверка отсутствия в окне фильтра выбранного значения при очистке поля поиска")
    public void checkSwitchShowOnlySelectedOKPDYes(){
        steps.drag_and_drop_filter(filterOKPD);
        steps.wait_a_bit(2000);
        steps.type_search("(85.11.10.000) Услуги в области дошкольного образования");
        steps.wait_a_bit(2000);
        steps.click_button(checkboxOKPD);
        steps.clear_field(fieldSearchInFilter);
        steps.wait_a_bit(2000);
        steps.click_button(checkboxShowOnlySelected);
        steps.check_switch_show_only_selected_yes();
    }

    @Test
    @Title("Проверка сброса выделения найденного элемента")
    public void checkResetSelectFilterOKPD(){
        steps.drag_and_drop_filter(filterOKPD);
        steps.wait_a_bit(2000);
        steps.type_search("(85.11.10.000) Услуги в области дошкольного образования");
        steps.wait_a_bit(2000);
        steps.click_button(checkboxOKPD);
        steps.wait_a_bit(2000);
        steps.click_button(buttonReset);
        steps.type_search("(85.11.10.000) Услуги в области дошкольного образования");
        steps.wait_a_bit(1000);
        steps.check_reset_result_search_by_okpd();
    }

    @Test
    @Title("Проверка соответствия найденного значения по поиску в фильтре Категория")
    public void checkResultSearchFilterCategory(){
        steps.drag_and_drop_filter(filterCategory);
        steps.wait_a_bit(2000);
        steps.type_search("Коммунальные услуги");
        steps.check_result_search_by_category();
    }

    @Test
    @Title("Проверка результата поиска без категории")
    public void checkResultSearchFilterWithoutCategory(){
        steps.drag_and_drop_filter(filterCategory);
        steps.click_button(checkboxShowWithoutCategory);
        steps.click_button(buttonApply);
        steps.click_button(buttonSearch);
        steps.wait_a_bit(2000);
        steps.check_result_search_by_without_category();
    }

    @Test
    @Title("Проверка ввода некорректной цены от")
    public void checkIncorrectPriceFrom(){
        steps.drag_and_drop_filter(filterPrice);
        steps.type_price_from("-12ds ddвава+*");
        steps.wait_a_bit(2000);
        steps.check_enter_incorrect_price_from();
    }

    @Test
    @Title("Проверка ввода некорректной цены до")
    public void checkIncorrectPriceTo(){
        steps.drag_and_drop_filter(filterPrice);
        steps.type_price_to("-12ds ddвава+*");
        steps.wait_a_bit(2000);
        steps.check_enter_incorrect_price_to();
    }

    @Test
    @Title("Проверка результата поиска с нулевой ценой")
    public void checkResultSearchWithZeroPrice(){
        steps.drag_and_drop_filter(filterPrice);
        steps.type_price_from("1000");
        steps.type_price_to("10000");
        steps.click_button(checkboxShowWithZeroPrice);
        steps.click_button(openTabMenu);
        steps.click_button(buttonSearch);
        steps.wait_a_bit(2000);
        steps.check_result_search_by_with_zero_price();
    }

    @Test
    @Title("Проверка результата поиска по реквизитам внутри фильтра 'Заказчик'")
    public void checkSearchInsideFilterCustomer(){
        steps.drag_and_drop_filter(filterCustomer);
        steps.wait_a_bit(1000);
        steps.type_search_inside_filter_customer_by_details("305780214002814");
        steps.wait_a_bit(1000);
        steps.check_result_search_inside_filter_customer_by_details();
    }

    @Test
    @Title("Проверка результата поиска по тексту внутри фильтра 'Заказчик'")
    public void checkTextSearchInsideFilterCustomer(){
        steps.drag_and_drop_filter(filterCustomer);
        steps.wait_a_bit(1000);
        steps.click_button(tabTextSearchInFilterCustomer);
        steps.type_search_inside_filter_customer_text_search("ЗАКУПАЙ");
        steps.wait_a_bit(1000);
        steps.check_result_text_search_inside_filter_customer();
    }

    @Test
    @Title("Проверка результата поиска по региону внутри фильтра 'Заказчик'")
    public void checkSearchRegionInsideFilterCustomer(){
        steps.drag_and_drop_filter(filterCustomer);
        steps.wait_a_bit(1000);
        steps.click_button(comboboxRegionCustomer);
        steps.click_button(elementOfComboboxCustomer);
        steps.wait_a_bit(5000);
        steps.check_result_search_region_inside_filter_customer();
    }

    @Test
    @Title("Проверка результата исключения из поиска по тексту внутри фильтра 'Заказчик'")
    public void checkExcludeFromSearchInsideFilterCustomer(){
        steps.drag_and_drop_filter(filterCustomer);
        steps.wait_a_bit(1000);
        steps.click_button(tabTextSearchInFilterCustomer);
        steps.type_search_inside_filter_customer_text_search("сош");
//        steps.click_button(buttonAdditionalFilters);
        steps.type_search_exclude_from_search_filter_customer("58");
        steps.wait_a_bit(1000);
        steps.check_result_exclude_from_search_inside_filter_customer();
    }

    @Test
    @Title("Проверка выделения чекбокса 'Выбрать всё' при переключении страницы в фильтре 'Заказчик'")
    public void checkSelectedButtonAllSelect(){
        steps.drag_and_drop_filter(filterCustomer);
        steps.wait_a_bit(1000);
        steps.click_button(checkboxSelectAll);
        steps.click_button(secondPage);
        steps.wait_a_bit(1000);
        steps.check_selected_button_all_select();
    }

    @Test
    @Title("Проверка выделения элементов при закрытии окна фильтра 'Заказчик' без сохранения")
    public void checkSaveAfterCloseFilter(){
        steps.drag_and_drop_filter(filterCustomer);
        steps.wait_a_bit(1000);
        steps.click_button(checkboxSelectAll);
        steps.click_button(buttonCloseFilter);
        steps.wait_a_bit(1000);
        steps.check_save_after_close_filter();
    }

    @Test
    @Title("Проверка списка элементов комбобокса 'Направление' в фильтре 'Дата публикации''")
    public void checkListElementsComboboxDirection(){
        steps.drag_and_drop_filter(filterDatePublication);
        steps.wait_a_bit(1000);
        steps.click_button(tabRangeInFilterDatePublication);
        steps.click_button(comboboxDirection);
        steps.check_list_elements_combobox_direction();
    }

    @Test
    @Title("Проверка списка элементов комбобокса 'Единицы измерения' в фильтре 'Дата публикации''")
    public void checkListElementsComboboxUnits(){
        steps.drag_and_drop_filter(filterDatePublication);
        steps.wait_a_bit(1000);
        steps.click_button(tabRangeInFilterDatePublication);
        steps.click_button(comboboxUnits);
        steps.check_list_elements_combobox_units();
    }

    @Test
    @Title("Проверка списка элементов в фильтре 'Модуль''")
    public void checkListElementsOfFilterModule(){
        steps.drag_and_drop_filter(filterModule);
        steps.wait_a_bit(1000);
        steps.check_list_elements_of_filter_module();
    }

    @Test
    @Title("Проверка количества элементов комбобокса 'Направление' в фильтре 'Дата публикации''")
    public void checkNumberListElementsComboboxDirection(){
        steps.drag_and_drop_filter(filterDatePublication);
        steps.wait_a_bit(1000);
        steps.click_button(tabRangeInFilterDatePublication);
        steps.click_button(comboboxDirection);
        steps.check_number_list_elements_combobox_direction();
    }

    @Test
    @Title("Проверка количества элементов комбобокса 'Единицы измерения' в фильтре 'Дата публикации''")
    public void checkNumberListElementsComboboxUnits(){
        steps.drag_and_drop_filter(filterDatePublication);
        steps.wait_a_bit(1000);
        steps.click_button(tabRangeInFilterDatePublication);
        steps.click_button(comboboxUnits);
        steps.check_number_list_elements_combobox_units();
    }

    @Test
    @Title("Проверка количества элементов в фильтре 'Модуль''")
    public void checkNumberListElementsOfFilterModule(){
        steps.drag_and_drop_filter(filterModule);
        steps.wait_a_bit(1000);
        steps.check_number_list_elements_of_filter_module();
    }

    @Test
    @Title("Проверка выбранных элементов в фильтре 'Метка'")
    public void checkListElementsOfSelectMark(){
        steps.drag_and_drop_filter(filterMark);
        steps.wait_a_bit(1000);
        steps.click_button(redColorMark);
        steps.click_button(blueColorMark);
        steps.click_button(greenColorMark);
        steps.wait_a_bit(1000);
        steps.check_list_elements_of_select_mark();
    }

    @Test
    @Title("Проверка сброса чекбоксов \"Исключено из поиска\"")
    public void checkResetUnSelectedCheckboxElements(){
        steps.drag_and_drop_filter(filterStand);
        steps.wait_a_bit(1000);
        steps.click_button(checkboxSelectedAllElements);
        steps.click_button(checkboxSelectedAllElements);
        steps.click_button(buttonReset);
        steps.wait_a_bit(1000);
        steps.check_reset_unselected_checkbox_elements();
    }

    @Test
    @Title("Проверка выделения чекбоксов при просмотре только выбранных элементов")
    public void checkSelectedCheckboxShowOnlySelectedElements(){
        steps.drag_and_drop_filter(filterCustomer);
        steps.wait_a_bit(1000);
        steps.type_search_inside_filter_customer_by_details("305780214002814");
        steps.wait_a_bit(1000);
        steps.click_button(checkboxSelectedAllElements);
        steps.click_button(buttonApply);
        steps.click_button(filterInTree);
        steps.click_button(checkboxShowOnlySelected);
        steps.check_selected_checkbox_show_only_selected_elements();
    }

}
