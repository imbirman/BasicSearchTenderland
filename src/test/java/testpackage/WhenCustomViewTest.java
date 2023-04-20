package testpackage;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import pages.CustomView;
import steps.CustomViewSteps;

@RunWith(SerenityRunner.class)
public class WhenCustomViewTest extends CustomView {

    @Managed(driver = "chrome", uniqueSession=true)
    WebDriver driver;


    @Steps
    CustomViewSteps steps;

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
    @Title("Проверка количества выбранных элементов и элементов для выбора в блоке 'Поля таблицы' на вкладке 'Тендеры' по умолчанию")
    public void checkNumberElementsTableFieldsInTabTenderDefault(){
        steps.click_button(buttonOpenWindowCustomView);
        steps.click_button(buttonAddNewCustomView);
        steps.check_number_elements_table_fields_for_selection_on_tab_tender();
        steps.check_number_elements_table_fields_selected_tender();
    }

    @Test
    @Title("Проверка количества элементов для выбора в блоке 'Поля таблицы' на вкладке 'Контракты' по умолчанию")
    public void checkNumberElementsTableFieldsForSelectionInTabContractsDefault(){
        steps.click_button(buttonOpenWindowCustomView);
        steps.click_button(buttonAddNewCustomView);
        steps.click_button(buttonTabContracts);
        steps.check_number_elements_table_fields_for_selection_on_tab_contracts();
    }

    @Test
    @Title("Проверка количества элементов для выбора в блоке 'Поля таблицы' на вкладке 'Планы' по умолчанию")
    public void checkNumberElementsTableFieldsForSelectionInTabPlansDefault(){
        steps.click_button(buttonOpenWindowCustomView);
        steps.click_button(buttonAddNewCustomView);
        steps.click_button(buttonTabPlans);
        steps.check_number_elements_table_fields_for_selection_on_tab_plans();
    }

    @Test
    @Title("Проверка количества выбранных элементов и элементов для выбора в блоке 'Детализация' по умолчанию")
    public void checkNumberElementsDetailingFieldsDefault(){
        steps.click_button(buttonOpenWindowCustomView);
        steps.click_button(buttonAddNewCustomView);
        steps.click_button(buttonAccordionDetailing);
        steps.check_number_elements_detailing_fields_for_selection();
        steps.check_number_elements_detailing_fields_selected();
    }

    @Test
    @Title("Проверка значения поля 'Выбрать поле для сортировки' в блоке 'Настройки' по умолчанию")
    public void checkValueDefaultSortField(){
        steps.click_button(buttonOpenWindowCustomView);
        steps.click_button(buttonAddNewCustomView);
        steps.click_button(buttonAccordionSettings);
        steps.check_value_default_sort_field();
    }

    @Test
    @Title("Проверка значения сортировки 'По убыванию' в блоке 'Настройки' по умолчанию")
    public void checkSelectedRadiobuttonDescendingDefault(){
        steps.click_button(buttonOpenWindowCustomView);
        steps.click_button(buttonAddNewCustomView);
        steps.click_button(buttonAccordionSettings);
        steps.check_selected_radiobutton_descending_default();
    }

    @Test
    @Title("Проверка значения чекбокса 'Раскрывать детализации' в блоке 'Настройки' по умолчанию")
    public void checkCheckboxDiscloseDetailingDefault(){
        steps.click_button(buttonOpenWindowCustomView);
        steps.click_button(buttonAddNewCustomView);
        steps.click_button(buttonAccordionSettings);
        steps.check_checkbox_disclose_detailing_default();
    }

    @Test
    @Title("Проверка отображения количества выбранных полей по умолчанию")
    public void checkValueLabelSelectedFieldsDefault(){
        steps.click_button(buttonOpenWindowCustomView);
        steps.click_button(buttonAddNewCustomView);
        steps.check_value_label_selected_fields_default();
    }

    @Test
    @Title("Проверка отображения количества выбранных детализаций по умолчанию")
    public void checkValueLabelSelectedDelailingDefault(){
        steps.click_button(buttonOpenWindowCustomView);
        steps.click_button(buttonAddNewCustomView);
        steps.check_value_label_selected_detailing_default();
    }





    @Test
    @Title("Проверка сообщения об ошибке при сохранении пользовательского вида при пустом названии")
    public void checkSaveCustomViewWithEmptyName(){
        steps.click_button(tabListAutoSearch);
        steps.scroll_element_on_pixels("1050", listAutoSearchToScroll);
        steps.click_button(buttonAutoSearchTestCustomView);
        steps.wait_a_bit(2000);
        steps.click_button(buttonOpenWindowCustomView);
        steps.check_clickable_button_delete_custom_view();
        steps.click_button(buttonSaveCustomView);
        steps.check_error_message_save_custom_view_with_empty_name();
    }

    @Test
    @Title("Проверка окна пользовательского вида")
    public void checkWindowCustomView(){
        steps.click_button(buttonOpenWindowCustomView);
        steps.check_list_name_custom_view();
        steps.type_name_custom_view("Тестовый вид");
        steps.click_button(buttonSaveCustomView);
        steps.wait_a_bit(1000);
        steps.check_number_element_of_list_selected_column();
        steps.check_name_saved_custom_field();
        steps.check_clickable_button_save_settings_custom_view();
        steps.click_button(buttonCloseWindowCustomView);
        steps.click_button(buttonExpandListCustomView);
        steps.check_number_element_of_expanded_list_custom_view();
        steps.check_name_added_element_of_expanded_list_custom_view();
        steps.click_button(buttonOpenWindowCustomView);
        steps.click_button(buttonAddNewCustomView);
        steps.type_name_custom_view("Тестовый вид");
        steps.click_button(buttonSaveCustomView);
        steps.wait_a_bit(500);
        steps.check_error_message_save_custom_view_with_duplication_name();
        steps.check_number_element_of_list_custom_view();
        steps.click_button(buttonAddNewCustomView);
        steps.type_name_custom_view("Тестовый вид1");
        steps.click_button(buttonSaveCustomView);
//        steps.wait_a_bit(500);
        steps.check_error_message_save_custom_view_without_selected_column();
        steps.check_number_element_of_list_selected_column();

        steps.click_button(elementOfListCustomView);
        steps.click_button(buttonDeleteCustomView);
        steps.check_number_element_of_list_selected_column();
    }

    @Test
    @Title("Проверка столбцов таблицы результата поиска после удаления столбца из пользовательского вида")
    public void checkNotContainDeletedColumn(){
        steps.click_button(buttonOpenWindowCustomView);
        steps.check_list_name_custom_view();
        steps.click_button(buttonCloseWindowCustomView);
        steps.click_button(buttonOpenWindowCustomView);
        steps.click_button(buttonRemoveColumnFromListSelectedColumns);
        steps.click_button(buttonApplyCustomView);
        steps.check_not_contain_deleted_column();
    }

    @Test
    @Title("Проверка поиска в окне пользовательского вида")
    public void checkContainResultSearchColumnCustomView(){
        steps.click_button(buttonOpenWindowCustomView);
        steps.type_search_column_custom_view("рее");
        steps.check_contain_result_search_column_custom_view();
    }

    @Test
    @Title("Проверка добавления столбца пользовательского вида")
    public void checkContainSelectedColumnCustomView(){
        steps.click_button(buttonOpenWindowCustomView);
        steps.click_button(elementOfListColumns);
        steps.scroll_element_on_pixels("200", fieldSelectedColumnsCustomViewForScroll);
        steps.check_contain_selected_column();
    }
}
