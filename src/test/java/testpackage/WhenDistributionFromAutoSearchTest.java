package testpackage;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import pages.DistributionFromAutoSearch;
import steps.DistributionFromAutoSearchSteps;

import java.io.IOException;


@RunWith(SerenityRunner.class)
public class WhenDistributionFromAutoSearchTest extends DistributionFromAutoSearch {

    @Managed(driver = "chrome", uniqueSession=true)
    WebDriver driver;


    @Steps
    DistributionFromAutoSearchSteps steps;

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
    @Title("Проверка даты включения рассылки автопоиска")
    public void checkDateCreateDistribution(){
        steps.drag_and_drop_filter(filterNameTender);
        steps.type_search_inside_filter_name_tender("мусор");
        steps.wait_a_bit(1000);
        steps.click_button(tabListAutoSearch);
        steps.wait_a_bit(3000);
        steps.check_test_autosearch();
        steps.click_button(buttonSaveAutoSearch);
        steps.type_name_autosearch("Тестовый автопоиск");
        steps.click_button(buttonAcceptSaveAutoSearch);
        steps.wait_a_bit(1000);
        steps.click_button(testAutoSearch);
        steps.wait_a_bit(1000);
        steps.click_button(buttonSaveAutoSearch);
        steps.click_button(tabDistributionInWindowAutoSearch);
        steps.check_correct_status_disabled_distribution();
        steps.click_button(buttonSwitchDistribution);
        steps.check_visible_date_create_distribution();
        steps.check_contain_correct_date_create_distribution();
        steps.check_correct_status_enabled_distribution();
    }

    @Test
    @Title("Проверка ошибки при сохранении автопоиска без почты или телеграмма для рассылки")
    public void checkCorrectErrorMessageWithEmptyAccountForDistribution(){
        steps.drag_and_drop_filter(filterNameTender);
        steps.type_search_inside_filter_name_tender("мусор");
        steps.wait_a_bit(1000);
        steps.click_button(tabListAutoSearch);
        steps.wait_a_bit(3000);
        steps.check_test_autosearch();
        steps.click_button(buttonSaveAutoSearch);
        steps.type_name_autosearch("Тестовый автопоиск");
        steps.click_button(tabDistributionInWindowAutoSearch);
        steps.click_button(buttonSwitchDistribution);
        steps.click_button(buttonAcceptSaveAutoSearch);
        steps.check_visible_error_message_with_empty_account_for_distribution();
        steps.check_correct_error_message_with_empty_account_for_distribution();
    }

    @Test
    @Title("Проверка отображения блоков данных во вкладке 'Рассылка' для дочернего пользователя")
    public void checkVisibleBlockDataInTabDistributionForChildUser(){
        steps.drag_and_drop_filter(filterNameTender);
        steps.type_search_inside_filter_name_tender("мусор");
        steps.wait_a_bit(1000);
        steps.click_button(tabListAutoSearch);
        steps.wait_a_bit(3000);
        steps.check_test_autosearch();
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
        steps.click_button(buttonSaveAutoSearch);
        steps.type_name_autosearch("Тестовый автопоиск");
        steps.click_button(tabDistributionInWindowAutoSearch);
        steps.click_button(buttonSwitchDistribution);
        steps.check_visible_account_and_address_distribution_for_child_user();
        steps.check_visible_fields_distribution_for_child_user();
        steps.check_visible_days_distribution_for_child_user();
        steps.check_visible_times_distribution_for_child_user();
    }

    @Test
    @Title("Проверка сохранения изменений дней рассылки")
    public void checkSavedChangesDaysDistribution(){
        steps.drag_and_drop_filter(filterNameTender);
        steps.type_search_inside_filter_name_tender("мусор");
        steps.wait_a_bit(1000);
        steps.click_button(tabListAutoSearch);
        steps.wait_a_bit(3000);
        steps.check_test_autosearch();
        steps.click_button(buttonSaveAutoSearch);
        steps.type_name_autosearch("Тестовый автопоиск");
        steps.click_button(tabDistributionInWindowAutoSearch);
        steps.click_button(buttonSwitchDistribution);
        steps.type_email_distribution("test@test.ru");
        steps.click_button(checkboxFriday);
        steps.click_button(checkboxSaturday);
        steps.click_button(buttonAcceptSaveAutoSearch);
        steps.click_button(buttonSaveAutoSearch);
        steps.click_button(tabDistributionInWindowAutoSearch);
        steps.check_checkbox_friday();
        steps.check_checkbox_saturday();
    }

    @Test
    @Title("Проверка ошибки при сохранении автопоиска при пустом поле 'Пинкод'")
    public void checkCorrectErrorMessageWithEmptyFieldPincode(){
        steps.drag_and_drop_filter(filterNameTender);
        steps.type_search_inside_filter_name_tender("мусор");
        steps.wait_a_bit(1000);
        steps.click_button(tabListAutoSearch);
        steps.wait_a_bit(3000);
        steps.check_test_autosearch();
        steps.click_button(buttonSaveAutoSearch);
        steps.type_name_autosearch("Тестовый автопоиск");
        steps.click_button(buttonSwitchPinCode);
        steps.check_visible_error_message_with_empty_field_pincode();
        steps.check_correct_error_message_with_empty_field_pincode();
        steps.click_button(buttonAcceptSaveAutoSearch);
        steps.check_visible_error_message_with_empty_field_pincode();
        steps.check_correct_error_message_with_empty_field_pincode();
    }

    @Test
    @Title("Проверка отображения ошибки при некорректном вводе пинкода")
    public void checkVisibleErrorWithWrongPinCode(){
        steps.drag_and_drop_filter(filterNameTender);
        steps.type_search_inside_filter_name_tender("мусор");
        steps.wait_a_bit(1000);
        steps.click_button(tabListAutoSearch);
        steps.wait_a_bit(3000);
        steps.check_test_autosearch();
        steps.click_button(buttonSaveAutoSearch);
        steps.type_name_autosearch("Тестовый автопоиск");
        steps.click_button(buttonSwitchPinCode);
        steps.wait_a_bit(1000);
        steps.type_pincode("123");
        steps.wait_a_bit(1000);
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
        steps.type_pincode("1");
        steps.click_button(buttonAcceptSaveAutoSearch);
        steps.check_visible_error_message_with_wrong_pincode();
        steps.check_correct_error_message_with_wrong_pincode();
    }

    @Test
    @Title("Проверка соответствия списка полей для рассылки")
    public void checkContainCorrectFieldsForDistribution() throws IOException {
        steps.drag_and_drop_filter(filterNameTender);
        steps.type_search_inside_filter_name_tender("мусор");
        steps.wait_a_bit(1000);
        steps.click_button(tabListAutoSearch);
        steps.wait_a_bit(3000);
        steps.check_test_autosearch();
        steps.click_button(buttonSaveAutoSearch);
        steps.type_name_autosearch("Тестовый автопоиск");
        steps.wait_a_bit(1000);
        steps.click_button(tabDistributionInWindowAutoSearch);
        steps.click_button(buttonSwitchDistribution);
        steps.click_button(buttonOpenFieldsSelector);
        steps.check_contain_correct_fields_for_distribution("C:\\FilesForTenderland\\ListSelectedFieldsForDistribution.txt");
    }

    @Test
    @Title("Проверка соответствия списка полей для рассылки по умолчанию")
    public void checkCorrectDefaultFieldsForDistribution(){
        steps.drag_and_drop_filter(filterNameTender);
        steps.type_search_inside_filter_name_tender("мусор");
        steps.wait_a_bit(1000);
        steps.click_button(tabListAutoSearch);
        steps.wait_a_bit(3000);
        steps.check_test_autosearch();
        steps.click_button(buttonSaveAutoSearch);
        steps.type_name_autosearch("Тестовый автопоиск");
        steps.wait_a_bit(1000);
        steps.click_button(tabDistributionInWindowAutoSearch);
        steps.click_button(buttonSwitchDistribution);
        steps.click_button(buttonOpenFieldsSelector);
        steps.check_correct_fields_for_distribution();
    }

    @Test
    @Title("Проверка списка форм рассылки")
    public void checkCorrectListDistributionMethods(){
        steps.drag_and_drop_filter(filterNameTender);
        steps.type_search_inside_filter_name_tender("мусор");
        steps.wait_a_bit(1000);
        steps.click_button(tabListAutoSearch);
        steps.wait_a_bit(3000);
        steps.check_test_autosearch();
        steps.click_button(buttonSaveAutoSearch);
        steps.type_name_autosearch("Тестовый автопоиск");
        steps.wait_a_bit(1000);
        steps.click_button(tabDistributionInWindowAutoSearch);
        steps.click_button(buttonSwitchDistribution);
        steps.click_button(buttonOpenListDistributionMethods);
        steps.check_list_distribution_methods();
    }

    @Test
    @Title("Проверка наличия в списке отчетов отчета дочернего пользователя")
    public void checkIncludeChildUserReportInListReports(){
        steps.drag_and_drop_filter(filterNameTender);
        steps.type_search_inside_filter_name_tender("мусор");
        steps.wait_a_bit(3000);
        steps.check_test_autosearch();
        steps.click_button(buttonSaveAutoSearch);
        steps.type_name_autosearch("Тестовый автопоиск");
        steps.wait_a_bit(1000);
        steps.click_button(tabDistributionInWindowAutoSearch);
        steps.click_button(buttonSwitchDistribution);
        steps.click_button(buttonOpenListDistributionMethods);
        steps.click_button(elementListDistributionMethodsReport);
        steps.click_button(buttonOpenListFormReports);
        steps.check_list_distribution_reports_include_child_user_report();
    }

    @Test
    @Title("Проверка наличия в списке отчетов отчета родительского пользователя")
    public void checkIncludeMainUserReportInListReports(){
        steps.click_button(buttonLogout);
        steps.wait_a_bit(1000);
        steps.click_button(buttonLogin);
        steps.type_login("ChildAdminTestitAutoSearch");
        steps.type_password("Hyqpmaz0/");
        steps.click_button(buttonSignIn);
        steps.drag_and_drop_filter(filterNameTender);
        steps.type_search_inside_filter_name_tender("мусор");
        steps.wait_a_bit(3000);
        steps.check_test_autosearch();
        steps.click_button(buttonSaveAutoSearch);
        steps.type_name_autosearch("Тестовый автопоиск");
        steps.wait_a_bit(1000);
        steps.click_button(tabDistributionInWindowAutoSearch);
        steps.click_button(buttonSwitchDistribution);
        steps.click_button(buttonOpenListDistributionMethods);
        steps.click_button(elementListDistributionMethodsReport);
        steps.click_button(buttonOpenListFormReports);
        steps.check_list_distribution_reports_include_main_user_report();
    }
}
