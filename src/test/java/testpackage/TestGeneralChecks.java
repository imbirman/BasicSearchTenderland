package testpackage;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import pages.GeneralChecks;
import steps.GeneralChecksSteps;

@RunWith(SerenityRunner.class)
public class TestGeneralChecks extends GeneralChecks {

    @Managed(driver = "chrome", uniqueSession=true)
    WebDriver driver;

    @Steps
    GeneralChecksSteps steps;

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
    @Title("Проверка входа")
    public void checkSignIn(){

        steps.check_text_login();
    }

    @Test
    @Title("Проверка соответствия области подсказки фильтру И")
    public void checkCorrectHintAreaAnd(){

        steps.check_correct_hint_area_and();
    }

    @Test
    @Title("Проверка соответствия области подсказки фильтру ИЛИ")
    public void checkCorrectHintAreaOr(){
        steps.click_button(filterAndOr);
        steps.check_correct_hint_area_or();
    }

    @Test
    @Title("Проверка контекстного меню на второй странице после выбора всех элементов на первой странице в результатах поиска")
    public void checkNameElementsContextMenu(){
        steps.click_button(tabListAutoSearch);
        steps.click_button(buttonCheckTenderNameAndNameDeletion);
        steps.wait_a_bit(1000);
        steps.click_button(checkBoxSelectedAllForTableResultSearch);
        steps.click_button(secondPageSearch);
        steps.wait_a_bit(2000);
        steps.click_button(contextMenuResultSearch);
        steps.check_name_elements_context_menu();
    }

    @Test
    @Title("Проверка отображения в результатах поиска скрытого элемента и количества скрытых элементов")
    public void checkContainHideTender(){
        steps.click_button(tabListAutoSearch);
        steps.scroll_element_on_pixels("1000", listAutoSearchToScroll);
        steps.click_button(buttonCheckHideResultSearch);
        steps.wait_a_bit(500);
        steps.click_button(contextMenuResultSearch);
        steps.click_button(hideContextMenu);
        steps.scroll_window_on_pixels("-100");
        steps.wait_a_bit(2000);
        steps.click_button(buttonSearch);
        steps.check_not_contain_hide_tender();
        steps.click_button(buttonOpenShowHideEntities);
        steps.click_button(buttonSwitchShowHideEntities);
        steps.wait_a_bit(1000);
        steps.check_contain_hide_tender();
        steps.click_button(buttonOpenShowHideEntities);
        steps.click_button(contextMenuResultSearch);
        steps.click_button(showTenderContextMenu);
    }

    @Test
    @Title("Проверка отображения удаленного из скрытых элемента")
    public void checkContainRemoveFromHidden(){
        steps.click_button(tabListAutoSearch);
        steps.scroll_element_on_pixels("1000", listAutoSearchToScroll);
        steps.click_button(buttonCheckHideResultSearch);
        steps.wait_a_bit(500);
        steps.click_button(contextMenuResultSearch);
        steps.click_button(hideContextMenu);
        steps.click_button(buttonOpenShowHideEntities);
        steps.click_button(buttonOpenHiddenDataControl);
        steps.click_button(buttonDeleteHiddenTender);
        steps.click_button(buttonAcceptDeleteHiddenTender);
        steps.click_button(buttonCloseWindowHiddenDataControl);
        steps.wait_a_bit(1000);
        steps.scroll_window_on_pixels("-300");
        steps.click_button(buttonSearch);
        steps.wait_a_bit(1000);
        steps.check_contain_not_hide_tender();
    }

    @Test
    @Title("Проверка чекбокса 'Выбрать всё' для результатов поиска")
    public void checkNotSelectedCheckBoxSelectedAllForResultSearch(){
        steps.click_button(tabListAutoSearch);
        steps.click_button(buttonCheckTenderNameAndNameDeletion);
        steps.wait_a_bit(1000);
        steps.click_button(checkBoxSelectedAllForTableResultSearch);
        steps.scroll_window_on_pixels("-800");
        steps.click_button(buttonClearBuildingFieldSearch);
        steps.check_not_selected_checkbox_selected_all_for_result_search();
    }

    @Test
    @Title("Проверка отображения счетчика выбранных тендеров в результате поиска")
    public void checkDisplayedSelectionCounter(){
        steps.click_button(tabListAutoSearch);
        steps.scroll_element_on_pixels("1000", listAutoSearchToScroll);
        steps.click_button(buttonCheckHideResultSearch);
        steps.wait_a_bit(500);
        steps.click_button(checkBoxSelectedAllForTableResultSearch);
        steps.check_displayed_selection_counter();
    }

    @Test
    @Title("Проверка значения счетчика выбранных тендеров в результате поиска")
    public void checkCorrectSelectionCounter(){
        steps.click_button(tabListAutoSearch);
        steps.click_button(buttonCheckTenderNameAndNameDeletion);
        steps.wait_a_bit(500);
        steps.click_button(checkBoxSelectedAllForTableResultSearch);
        steps.check_correct_selection_counter();
    }

}
