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
    @Title("Проверка сообщения об ошибке при сохранении пользовательского вида при пустом названии")
    public void checkSaveCustomViewWithEmptyName(){
        steps.click_button(tabListAutoSearch);
        steps.click_button(buttonAutoSearchTestCustomView);
        steps.wait_a_bit(2000);
        steps.click_button(buttonCustomView);
        steps.check_clickable_button_delete_custom_view();
        steps.click_button(buttonSaveSettings);
        steps.check_error_message_save_custom_view_with_empty_name();
    }

    @Test
    @Title("Проверка окна пользовательского вида")
    public void checkWindowCustomView(){
        steps.click_button(buttonCustomView);
        steps.check_list_name_custom_view();
        steps.type_name_custom_view("Тестовый вид");
        steps.click_button(buttonSaveSettings);
        steps.wait_a_bit(1000);
        steps.check_number_element_of_list_selected_column();
        steps.check_name_saved_custom_field();
        steps.check_clickable_button_save_settings_custom_view();
        steps.click_button(buttonCloseWindowCustomView);
        steps.click_button(buttonExpandListCustomView);
        steps.check_number_element_of_expanded_list_custom_view_after_duplication();
        steps.check_name_added_element_of_expanded_list_custom_view();
        steps.click_button(buttonCustomView);
        steps.click_button(buttonAddNewCustomView);
        steps.type_name_custom_view("Тестовый вид");
        steps.click_button(buttonSaveSettings);
        steps.wait_a_bit(500);
        steps.check_error_message_save_custom_view_with_duplication_name();
        steps.check_number_element_of_list_custom_view_after_duplication();
        steps.click_button(buttonAddNewCustomView);
        steps.type_name_custom_view("Тестовый вид1");
        steps.click_button(buttonSaveSettings);
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
        steps.click_button(buttonCustomView);
        steps.check_list_name_custom_view();
        steps.click_button(buttonCloseWindowCustomView);
        steps.click_button(buttonCustomView);
        steps.click_button(buttonRemoveColumnFromListSelectedColumns);
        steps.click_button(buttonApplyCustomView);
        steps.check_not_contain_deleted_column();
    }

    @Test
    @Title("Проверка поиска в окне пользовательского вида")
    public void checkContainResultSearchColumnCustomView(){
        steps.click_button(buttonCustomView);
        steps.type_search_column_custom_view("рее");
        steps.check_contain_result_search_column_custom_view();
    }

    @Test
    @Title("Проверка добавления столбца пользовательского вида")
    public void checkContainSelectedColumnCustomView(){
        steps.click_button(buttonCustomView);
        steps.click_button(elementOfListColumns);
        steps.scroll_down_to(fieldSelectedColumnsCustomViewForScroll);
        steps.check_contain_selected_column();
    }

    @Test
    @Title("Проверка результата поиска столбца организатора")
    public void checkIncludeFoundColumnOrganizer(){
        steps.click_button(buttonCustomView);
        steps.click_button(elementOfListColumns);
        steps.type_search_column_custom_view("организатор");
        steps.check_include_found_column_organizer();
    }
}
