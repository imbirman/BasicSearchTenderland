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
public class TestCustomView extends CustomView {

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
    public void checkValueLabelSelectedDetailingDefault(){
        steps.click_button(buttonOpenWindowCustomView);
        steps.click_button(buttonAddNewCustomView);
        steps.check_value_label_selected_detailing_default();
    }

    @Test
    @Title("Проверка количества вкладок пользовательских видов после нажатия на кнопку 'Добавить вид'")
    public void checkNumberTabCustomViewAfterAddingNewView(){
        steps.click_button(buttonOpenWindowCustomView);
        steps.click_button(buttonAddNewCustomView);
        steps.check_number_tab_custom_view_after_adding_new_view();
    }

    @Test
    @Title("Проверка количества вкладок пользовательских видов после закрытия окна настроек и несохранении нового пользовательского вида")
    public void checkNumberTabCustomViewWithoutSaveNewView(){
        steps.click_button(buttonOpenWindowCustomView);
        steps.click_button(buttonAddNewCustomView);
        steps.click_button(buttonCloseWindowCustomView);
        steps.click_button(buttonOpenWindowCustomView);
        steps.check_number_tab_custom_view_without_save_new_view();
    }

    @Test
    @Title("Проверка кликабельности кнопок контекстного меню пользовательского вида")
    public void checkClickableButtonsContextMenuCustomView(){
        steps.click_button(buttonOpenWindowCustomView);
        steps.click_button(getTabCustomViewByOriginalNumber(1));
        steps.click_button(getButtonContextMenuCustomViewByOriginalNumber(1));
        steps.check_clickable_button_rename_context_menu_custom_view();
        steps.check_clickable_button_delete_context_menu_custom_view();
    }

    @Test
    @Title("Проверка сообщения об ошибке сохранения пользовательского вида без выбранных полей")
    public void checkLabelErrorSaveCustomViewWithoutSelectedFields(){
        steps.click_button(buttonOpenWindowCustomView);
        steps.click_button(buttonAddNewCustomView);
        steps.type_name_custom_view("123");
        steps.click_button(buttonDeleteAllSelectedFields);
        steps.click_button(buttonSaveCustomView);
        steps.check_visible_label_error_save_custom_view_without_selected_fields();
        steps.check_text_error_save_custom_view_without_selected_fields();
    }

    @Test
    @Title("Проверка сохранения нового пользовательского вида без названия")
    public void checkNumberCustomViewAfterSaveNewViewWithoutName(){
        steps.click_button(buttonOpenWindowCustomView);
        steps.click_button(buttonAddNewCustomView);
        steps.click_button(buttonSaveCustomView);
        steps.click_button(buttonCloseWindowCustomView);
        steps.click_button(buttonOpenWindowCustomView);
        steps.check_number_tab_custom_view_after_save_new_view_without_name();
    }

    @Test
    @Title("Проверка отображение названия пользовательского вида после отмены переименования")
    public void check_displayed_name_custom_view_after_cancel_renaming(){
        steps.click_button(buttonOpenWindowCustomView);
        steps.click_button(getTabCustomViewByOriginalNumber(1));
        steps.click_button(getContextMenuCustomViewByNumber(1));
        steps.click_button(buttonContextMenuRename);
        steps.click_button(buttonAccordionDetailing);
        steps.check_displayed_name_tab_custom_view_by_number(1);
    }

    @Test
    @Title("Проверка сообщения об ошибке при сохранении пользовательского вида при пустом названии")
    public void checkSaveCustomViewWithEmptyName(){
        steps.click_button(tabListAutoSearch);
        steps.scroll_element_on_pixels("1050", listAutoSearchToScroll);
        steps.click_button(buttonAutoSearchTestCustomView);
        steps.wait_a_bit(2000);
        steps.click_button(buttonOpenWindowCustomView);
        steps.click_button(buttonAddNewCustomView);
        steps.click_button(buttonSaveCustomView);
        steps.check_error_message_save_custom_view_with_empty_name();
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
        steps.check_contain_selected_column();
    }

    @Test
    @Title("Проверка заблокирован ли элемент детализации для контрактов, если не выбраны соответствующие поля таблицы")
    public void checkDisabledElementContractDetailingToSelect(){
        steps.click_button(buttonOpenWindowCustomView);
        steps.click_button(buttonAccordionDetailing);
        steps.check_disabled_element_contract_detailing_to_select();
    }
}
