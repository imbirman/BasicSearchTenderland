package testpackage;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import pages.FilterSearch;
import steps.FilterSearchSteps;

@RunWith(SerenityRunner.class)
public class WhenFilterSearchTest extends FilterSearch {

    @Managed(driver = "chrome", uniqueSession=true)
    WebDriver driver;


    @Steps
    FilterSearchSteps steps;

    @Before
    public void beforeMethod(){
        driver.manage().window().maximize();
        steps.open_login_main_page();
        steps.click_button(buttonLogin);
        steps.type_login("AdminTestitAutoSearch");
        steps.type_password("Hyqpmaz0/");
        steps.click_button(buttonSignIn);
    }

    @Test
    @Title("Проверка ошибок сохранения автопоиска при некорректном названии автопоиска")
    public void checkEmptyAndDuplicationNameAutoSearch(){
        steps.drag_and_drop_filter(filterNameTender);
        steps.type_search_inside_filter_name_tender("мусор");
        steps.wait_a_bit(1000);
        steps.click_button(buttonSaveAutoSearch);
        steps.click_button(buttonAcceptSaveAutoSearch);
        steps.check_error_message_save_autosearch_without_name();
        steps.type_name_autosearch("Проверка поиска по дате подписания");
        steps.click_button(buttonAcceptSaveAutoSearch);
        steps.wait_a_bit(1000);
        steps.check_error_message_save_autosearch_with_duplicate_name();
    }

    @Test
    @Title("Проверка создания и удаления автопоиска")
    public void checkCreatedAndDeletedAutoSearch(){
        steps.drag_and_drop_filter(filterNameTender);
        steps.type_search_inside_filter_name_tender("мусор");
        steps.wait_a_bit(1000);
        steps.click_button(tabListAutoSearch);
        steps.wait_a_bit(3000);
        steps.check_test_autosearch_and_delete();
        steps.click_button(buttonSaveAutoSearch);
        steps.type_name_autosearch("Тестовый автопоиск");
        steps.click_button(buttonAcceptSaveAutoSearch);
        steps.check_correct_name_autosearch();
        steps.click_button(tabListAutoSearch);
        steps.check_contain_autosearch();
        steps.wait_a_bit(1000);
        steps.check_test_autosearch_and_delete();
        steps.wait_a_bit(1500);
        steps.check_not_contain_autosearch();
    }

    @Test
    @Title("Проверка отмены удаления автопоиска")
    public void checkCancelDeletedAutoSearch(){
        steps.drag_and_drop_filter(filterNameTender);
        steps.type_search_inside_filter_name_tender("мусор");
        steps.wait_a_bit(1000);
        steps.click_button(tabListAutoSearch);
        steps.wait_a_bit(1000);
        steps.check_test_autosearch_and_delete();
        steps.wait_a_bit(1000);
        steps.click_button(buttonSaveAutoSearch);
        steps.type_name_autosearch("Тестовый автопоиск");
        steps.click_button(buttonAcceptSaveAutoSearch);
        steps.click_button(buttonDeleteAutoSearchInListAutoSearch);
        steps.click_button(buttonCancelDeletedAutoSearch);
        steps.check_contain_autosearch();
        steps.click_button(buttonDeleteAutoSearchInBuildingSearch);
        steps.click_button(buttonCancelDeletedAutoSearch);
        steps.check_contain_autosearch();
        steps.click_button(buttonDeleteAutoSearchInListAutoSearch);
        steps.click_button(buttonCloseWindowAcceptOrCancelDeletedAutoSearch);
        steps.check_contain_autosearch();
        steps.click_button(buttonCloseAutoSearchInBuildingSearch);
        steps.check_contain_autosearch();
        steps.check_test_autosearch_and_delete();
    }

    @Test
    @Title("Проверка кликабельности кнопок автопоиска в древе построения фильтров")
    public void checkButtonsAutoSearchInBuildingSearch(){
        steps.drag_and_drop_filter(filterNameTender);
        steps.type_search_inside_filter_name_tender("мусор");
        steps.wait_a_bit(1000);
        steps.click_button(tabListAutoSearch);
        steps.wait_a_bit(3000);
        steps.check_test_autosearch_and_delete();
        steps.click_button(buttonSaveAutoSearch);
        steps.type_name_autosearch("Тестовый автопоиск");
        steps.click_button(buttonAcceptSaveAutoSearch);
        steps.check_clickable_button_copy_link_autosearch_in_building_search();
        steps.check_clickable_button_copy_autosearch_in_building_search();
        steps.check_clickable_button_delete_autosearch_in_building_search();
        steps.check_clickable_button_close_autosearch_in_building_search();
    }

    @Test
    @Title("Проверка отображения версии автопоиска")
    public void checkVisibleVersionAutoSearch(){
        steps.drag_and_drop_filter(filterNameTender);
        steps.type_search_inside_filter_name_tender("мусор");
        steps.wait_a_bit(1000);
        steps.click_button(tabListAutoSearch);
        steps.wait_a_bit(3000);
        steps.check_test_autosearch_and_delete();
        steps.click_button(buttonSaveAutoSearch);
        steps.type_name_autosearch("Тестовый автопоиск");
        steps.click_button(buttonAcceptSaveAutoSearch);
        steps.wait_a_bit(1000);
        steps.click_button(buttonSaveAutoSearch);
        steps.wait_a_bit(1000);
        steps.click_button(tabListVersionInWindowAutoSearch);
        steps.check_visible_version_autosearch();
        steps.check_correct_login_user_in_version_autosearch();
    }

    @Test
    @Title("Проверка названия пользовательского вида при сохранении изменений автопоиска")
    public void checkCorrectNameCustomView(){
        steps.drag_and_drop_filter(filterNameTender);
        steps.type_search_inside_filter_name_tender("мусор");
        steps.wait_a_bit(1000);
        steps.click_button(tabListAutoSearch);
        steps.wait_a_bit(3000);
        steps.check_test_autosearch_and_delete();
        steps.click_button(buttonSaveAutoSearch);
        steps.type_name_autosearch("Тестовый автопоиск");
        steps.click_button(buttonAcceptSaveAutoSearch);
        steps.wait_a_bit(1000);
        steps.click_button(buttonOpenListCustomView);
        steps.wait_a_bit(1000);
        steps.click_button(buttonItemCustomView);
        steps.wait_a_bit(1000);
        steps.click_button(buttonSaveAutoSearch);
        steps.wait_a_bit(1000);
        steps.click_button(buttonAcceptSaveAutoSearch);
        steps.check_correct_name_custom_view();
    }

    @Test
    @Title("Проверка кликабельности кнопки сохранения автопоиска при разных условиях")
    public void checkClickableButtonSaveAutSearch(){
        steps.wait_a_bit(1000);
        steps.check_not_clickable_button_save_autosearch();
        steps.drag_and_drop_filter(filterNameTender);
        steps.type_search_inside_filter_name_tender("мусор");
        steps.wait_a_bit(1000);
        steps.click_button(tabListAutoSearch);
        steps.wait_a_bit(3000);
        steps.check_test_autosearch_and_delete();
        steps.click_button(buttonSaveAutoSearch);
        steps.type_name_autosearch("Тестовый автопоиск");
        steps.click_button(buttonAcceptSaveAutoSearch);
        steps.wait_a_bit(1000);
        steps.click_button(buttonCloseAutoSearchInBuildingSearch);
        steps.wait_a_bit(1000);
        steps.click_button(testAutoSearch);
        steps.check_clickable_button_save_autosearch();
    }

    @Test
    @Title("Проверка окна редактирования автопоиска после копирования")
    public void checkWindowEditingAutoSearchAfterCopy(){
        steps.wait_a_bit(1000);
        steps.check_not_clickable_button_save_autosearch();
        steps.drag_and_drop_filter(filterNameTender);
        steps.type_search_inside_filter_name_tender("мусор");
        steps.wait_a_bit(1000);
        steps.click_button(tabListAutoSearch);
        steps.wait_a_bit(3000);
        steps.check_test_autosearch_and_delete();
        steps.click_button(buttonSaveAutoSearch);
        steps.type_name_autosearch("Тестовый автопоиск");
        steps.click_button(buttonAcceptSaveAutoSearch);
        steps.wait_a_bit(1000);
        steps.click_button(buttonCopyAutoSearchInBuildingSearch);
        steps.wait_a_bit(1000);
        steps.check_contain_correct_name_autosearch_after_copy();
        steps.click_button(tabListVersionInWindowAutoSearch);
        steps.wait_a_bit(1000);
        steps.check_contain_message_no_data_version_autosearch();
    }

    @Test
    @Title("Проверка кликабельности кнопки включения/выключения пинкода для основного и дочернего пользователя")
    public void checkClickableForButtonSwitchPinCode(){
        steps.wait_a_bit(1000);
        steps.check_not_clickable_button_save_autosearch();
        steps.drag_and_drop_filter(filterNameTender);
        steps.type_search_inside_filter_name_tender("мусор");
        steps.wait_a_bit(1000);
        steps.click_button(tabListAutoSearch);
        steps.wait_a_bit(3000);
        steps.check_test_autosearch_and_delete();
        steps.click_button(buttonSaveAutoSearch);
        steps.wait_a_bit(1000);
        steps.type_name_autosearch("Тестовый автопоиск");
        steps.check_clickable_button_switch_pin_code();
        steps.click_button(buttonAcceptSaveAutoSearch);
        steps.wait_a_bit(1000);
        steps.click_button(buttonLogout);
        steps.wait_a_bit(1000);
        steps.click_button(buttonLogin);
        steps.type_login("ChildAdminTestitAutoSearch");
        steps.type_password("Hyqpmaz0/");
        steps.click_button(buttonSignIn);
        steps.click_button(tabListAutoSearch);
        steps.wait_a_bit(1000);
        steps.click_button(testAutoSearch);
        steps.wait_a_bit(1000);
        steps.click_button(buttonSaveAutoSearch);
        steps.check_not_clickable_button_switch_pin_code();
    }

    @Test
    @Title("Проверка кликабельности кнопок автопоиска в древе построения фильтров для дочернего пользователя")
    public void checkButtonsAutoSearchInBuildingSearchForChildUser(){
        steps.drag_and_drop_filter(filterNameTender);
        steps.type_search_inside_filter_name_tender("мусор");
        steps.wait_a_bit(1000);
        steps.click_button(tabListAutoSearch);
        steps.wait_a_bit(3000);
        steps.check_test_autosearch_and_delete();
        steps.click_button(buttonSaveAutoSearch);
        steps.type_name_autosearch("Тестовый автопоиск");
        steps.click_button(buttonAcceptSaveAutoSearch);
        steps.wait_a_bit(1000);
        steps.click_button(buttonLogout);
        steps.wait_a_bit(1000);
        steps.click_button(buttonLogin);
        steps.type_login("ChildAdminTestitAutoSearch");
        steps.type_password("Hyqpmaz0/");
        steps.click_button(buttonSignIn);
        steps.click_button(tabListAutoSearch);
        steps.wait_a_bit(1000);
        steps.click_button(testAutoSearch);
        steps.wait_a_bit(1000);
        steps.check_clickable_button_copy_link_autosearch_in_building_search();
        steps.check_clickable_button_copy_autosearch_in_building_search();
        steps.check_clickable_button_delete_autosearch_in_building_search();
        steps.check_clickable_button_close_autosearch_in_building_search();
    }
}
