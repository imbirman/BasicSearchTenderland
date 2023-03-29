package testpackage;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import pages.UserManagement;
import steps.UserManagementSteps;

@RunWith(SerenityRunner.class)
public class WhenUserManagementTest extends UserManagement {

    @Managed(driver = "chrome", uniqueSession=true)
    WebDriver driver;

    @Steps
    UserManagementSteps steps;

    @Before
    public void beforeMethod(){
        driver.manage().window().maximize();
        steps.open_login_main_page();
        steps.click_button(buttonLogin);
        steps.type_login("AdminTestitMyTenders");
        steps.type_password("Hyqpmaz0/");
        steps.click_button(buttonSignIn);
        steps.click_button(openTabMenu);
        steps.click_button(buttonMyTenders);
    }

    @Test
    @Title("Проверка ошибок в окне управления пользователями при пустых полях")
    public void checkErrorsEmptyFieldsInWindowUserManagement() {
        steps.wait_a_bit(1000);
        steps.click_button(buttonUserManagement);
        steps.wait_a_bit(1000);
        steps.click_button(buttonSaveUser);
        steps.wait_a_bit(1000);
        steps.check_present_error_empty_last_name_user();
        steps.check_present_error_empty_login_user();
        steps.check_present_error_empty_password_user();
        steps.check_present_error_empty_role_user();
    }

    @Test
    @Title("Проверка неактивности поля 'Повторите пароль', кнопки 'Удалить' и кнопки 'Добавить пользователя' по умолчанию")
    public void checkInactiveRetryPasswordAndDeleteUserAndAddUser() {
        steps.click_button(buttonUserManagement);
        steps.wait_a_bit(500);
        steps.check_not_clickable_field_retry_password();
        steps.check_not_clickable_button_delete_user();
        steps.check_not_clickable_button_add_user();
    }

    @Test
    @Title("Проверка ошибки при коротком пароле пользователя")
    public void checkErrorWithWrongPassword() {
        steps.wait_a_bit(1000);
        steps.click_button(buttonUserManagement);
        steps.wait_a_bit(500);
        steps.type_password_user("123");
        steps.check_present_error_short_password_user();
    }

    @Test
    @Title("Проверка ошибки при некорректном пароле пользователя")
    public void checkErrorWithWrongLogin() {
        steps.wait_a_bit(1000);
        steps.click_button(buttonUserManagement);
        steps.wait_a_bit(500);
        steps.type_login_user("testmytenders");
        steps.click_button(buttonSaveUser);
        steps.check_present_error_repeated_login_user();
    }

    @Test
    @Title("Проверка ошибки при несовпадении пароля пользователя")
    public void checkErrorNotMatchPassword() {
        steps.wait_a_bit(1000);
        steps.click_button(buttonUserManagement);
        steps.wait_a_bit(500);
        steps.type_password_user("123123");
        steps.type_retry_password_user("123");
        steps.type_login_user("789456123");
        steps.wait_a_bit(500);
        steps.check_present_error_not_match_password_user();
    }

    @Test
    @Title("Проверка добавленного пользователя")
    public void checkFieldAddingUser(){
        steps.wait_a_bit(1000);
        steps.click_button(buttonUserManagement);
        steps.wait_a_bit(500);
        steps.check_test_user_for_delete();
        steps.type_last_name_user("Тестовый2");
        steps.wait_a_bit(1000);
        steps.type_name_user("Тест2");
        steps.wait_a_bit(1000);
        steps.type_patronymic_user("Тестович2");
        steps.wait_a_bit(1000);
        steps.click_button(fieldSelectUserRole);
        steps.click_button(steps.get_role_user(0));
        steps.wait_a_bit(1000);
        steps.type_login_user("testmytenders2");
        steps.wait_a_bit(1000);
        steps.type_password_user("123123");
        steps.wait_a_bit(1000);
        steps.type_retry_password_user("123123");
        steps.wait_a_bit(1000);
        steps.type_email_user("test@test2.ru");
        steps.wait_a_bit(1000);
        steps.click_button(buttonSaveUser);
        steps.wait_a_bit(2000);
        steps.check_present_adding_user();

        steps.click_button(steps.get_user(1));
        steps.wait_a_bit(500);

        steps.check_correct_last_name_user();
        steps.check_correct_name_user();
        steps.check_correct_patronymic_user();
        steps.check_correct_role_user();
        steps.check_correct_login_user();
        steps.check_correct_email_user();
        steps.check_test_user_for_delete();
    }

    @Test
    @Title("Проверка окна подтверждения удаления пользователя")
    public void checkWindowAcceptedDeleteUserUser(){
        steps.wait_a_bit(1000);
        steps.click_button(buttonUserManagement);
        steps.wait_a_bit(500);
        steps.type_last_name_user("Тестовый2");
        steps.wait_a_bit(1000);
        steps.type_name_user("Тест2");
        steps.wait_a_bit(1000);
        steps.type_patronymic_user("Тестович2");
        steps.wait_a_bit(1000);
        steps.click_button(fieldSelectUserRole);
        steps.click_button(steps.get_role_user(0));
        steps.wait_a_bit(1000);
        steps.type_login_user("testmytenders2");
        steps.wait_a_bit(1000);
        steps.type_password_user("123123");
        steps.wait_a_bit(1000);
        steps.type_retry_password_user("123123");
        steps.wait_a_bit(1000);
        steps.type_email_user("test@test2.ru");
        steps.wait_a_bit(1000);
        steps.click_button(buttonSaveUser);
        steps.wait_a_bit(2000);
        steps.click_button(getUser(0));
        steps.click_button(buttonDeleteUser);
        steps.check_visible_window_accepted_delete_user();
        steps.check_text_window_accepted_delete_user();
        steps.click_button(buttonCloseWindowAcceptDeleteUser);
        steps.check_test_user_for_delete();
    }
}
