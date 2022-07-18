package steps;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import pages.UserManagement;

public class UserManagementSteps {

    UserManagement page;

    @Step("Ожидание")
    public void wait_a_bit(long number){
        page.waitFor(number);
    }

    @Step("Открытие страницы")
    public void open_login_main_page() {page.open();}

    @Step("Нажать кнопку")
    public void click_button(By button){
        page.clickButton(button);
    }

    @Step("Двойной клик")
    public void double_click_button(By button){
        page.doubleClickButton(button);
    }

    @Step("Нажать кнопку")
    public void click_button(WebElementFacade button){
        page.clickButton(button);
    }

    @Step("Очистить поле")
    public void clear_field(By field){
        page.clearField(field);
    }

    @Step("Переключиться на следующую вкладку")
    public void switch_to_tab(){
        page.switchToTab();
    }

    @Step("Ввод логина")
    public void type_login(String mail){
        page.typeLogin(mail);
    }

    @Step("Ввод пароля")
    public void type_password(String password){
        page.typePassword(password);
    }

    @Step("Ввод фамилии пользователя")
    public void type_last_name_user(String lastName){
        page.typeLastNameUser(lastName);
    }

    @Step("Ввод имени пользователя")
    public void type_name_user(String name){
        page.typeNameUser(name);
    }

    @Step("Ввод отчества пользователя")
    public void type_patronymic_user(String patronymic){
        page.typePatronymicUser(patronymic);
    }

    @Step("Ввод логина пользователя")
    public void type_login_user(String login){
        page.typeLoginUser(login);
    }

    @Step("Ввод пароля пользователя")
    public void type_password_user(String password){
        page.typePasswordUser(password);
    }

    @Step("Ввод подтверждения пароля пользователя")
    public void type_retry_password_user(String retryPassword){
        page.typeRetryPasswordUser(retryPassword);
    }

    @Step("Ввод электронной почты пользователя")
    public void type_email_user(String email){
        page.typeEmailUser(email);
    }

    @Step("Получить роль пользователя по порядковому номеру")
    public WebElementFacade get_role_user(int number){
        return page.getRoleUser(number);
    }

    @Step("Получить пользователя по порядковому номеру")
    public WebElementFacade get_user(int number){
        return  page.getUser(number);
    }

    @Step("Проверка наличия тестового пользователя и его удаление")
    public void check_test_user_for_delete(){
        page.checkTestUserForDelete();
    }

    @Step("Проверка ошибки при пустом поле \"Фамилия\" в окне управления пользователями")
    public void check_present_error_empty_last_name_user(){
        Assertions.assertThat(page.isPresentErrorEmptyLastNameUser()).as("При сохранении пустого поля \"Фамилия\" либо не появился текст ошибки, либо он некорректен").isTrue();
    }

    @Step("Проверка ошибки при пустом поле \"Логин\" в окне управления пользователями")
    public void check_present_error_empty_login_user(){
        Assertions.assertThat(page.isPresentErrorEmptyLoginUser()).as("При сохранении пустого поля \"Логин\" либо не появился текст ошибки, либо он некорректен").isTrue();
    }

    @Step("Проверка ошибки при дублирующем поле \"Логин\" в окне управления пользователями")
    public void check_present_error_repeated_login_user(){
        Assertions.assertThat(page.isPresentErrorRepeatedLoginUser()).as("При сохранении дублирующего поля \"Логин\" либо не появился текст ошибки, либо он некорректен").isTrue();
    }

    @Step("Проверка ошибки при пустом поле \"Пароль\" в окне управления пользователями")
    public void check_present_error_empty_password_user(){
        Assertions.assertThat(page.isPresentErrorEmptyPasswordUser()).as("При сохранении пустого поля \"Пароль\" либо не появился текст ошибки, либо он некорректен").isTrue();
    }

    @Step("Проверка ошибки при коротком пароле в окне управления пользователями")
    public void check_present_error_short_password_user(){
        Assertions.assertThat(page.isPresentErrorShortPasswordUser()).as("При вводе короткого пароля либо не появился текст ошибки, либо он некорректен").isTrue();
    }

    @Step("Проверка ошибки при несовпадении пароля в окне управления пользователями")
    public void check_present_error_not_match_password_user(){
        Assertions.assertThat(page.isPresentErrorNotMatchPasswordUser()).as("При несовпадении пароля либо не появился текст ошибки, либо он некорректен").isTrue();
    }

    @Step("Проверка ошибки при отсутствии выбора роли пользователя в окне управления пользователями")
    public void check_present_error_empty_role_user(){
        Assertions.assertThat(page.isPresentErrorEmptyRoleUser()).as("При сохранении пустого поля \"Роль пользователя\" либо не появился текст ошибки, либо он некорректен").isTrue();
    }

    @Step("Проверка кликабельности поля \"Повторите пароль\"")
    public void check_not_clickable_field_retry_password(){
        Assertions.assertThat(page.isNotClickableFieldRetryPassword()).as("По умолчанию поле \"Повторите пароль\" активно").isFalse();
    }

    @Step("Проверка кликабельности кнопки \"Удалить\"")
    public void check_not_clickable_button_delete_user(){
        Assertions.assertThat(page.isNotClickableButtonDeleteUser()).as("По умолчанию кнопка \"Удалить\" активна").isTrue();
    }
    @Step("Проверка кликабельности кнопки \"Добавить пользователя\"")
    public void check_not_clickable_button_add_user(){
        Assertions.assertThat(page.isNotClickableButtonDeleteUser()).as("По умолчанию кнопка \"Пользователя\" активна").isTrue();
    }


    @Step("Проверка фамилии сохраненного пользователя")
    public void check_correct_last_name_user(){
        Assertions.assertThat(page.getLastNameUser()).as("Фамилия сохраненного пользователя некорректна").isEqualTo("Тестовый2");
    }

    @Step("Проверка имени сохраненного пользователя")
    public void check_correct_name_user(){
        Assertions.assertThat(page.getNameUser()).as("Имя сохраненного пользователя некорректно").isEqualTo("Тест2");
    }

    @Step("Проверка отчества сохраненного пользователя")
    public void check_correct_patronymic_user(){
        Assertions.assertThat(page.getPatronymicUser()).as("Отчество сохраненного пользователя некорректно").isEqualTo("Тестович2");
    }

    @Step("Проверка роли сохраненного пользователя")
    public void check_correct_role_user(){
        Assertions.assertThat(page.getRoleUser()).as("Роль сохраненного пользователя некорректна").isEqualTo("Администратор");
    }

    @Step("Проверка логина сохраненного пользователя")
    public void check_correct_login_user(){
        Assertions.assertThat(page.getLoginUser()).as("Логин сохраненного пользователя некорректен").isEqualTo("testmytenders2");
    }

    @Step("Проверка электронной почты сохраненного пользователя")
    public void check_correct_email_user(){
        Assertions.assertThat(page.getEmailUser()).as("Электронная почта сохраненного пользователя некорректна").isEqualTo("test@test2.ru");
    }

    @Step("Проверка добавленного пользователя в списке пользователей")
    public void check_present_adding_user(){
        Assertions.assertThat(page.isPresentAddingUser()).as("Добавленного пользователя нет в списке или название пользователя некорректно").isTrue();
    }

    @Step("Проверка наличия окна подтверждения удаления пользователя")
    public void check_visible_window_accepted_delete_user(){
        Assertions.assertThat(page.isVisibleWindowAcceptDeleteUser()).as("Окно подтверждения удаления пользователя не появилось").isTrue();
    }

    @Step("Проверка текста окна подтверждения удаления пользователя")
    public void check_text_window_accepted_delete_user(){
        Assertions.assertThat(page.getTextWindowAcceptDeleteUser()).as("Текст некорректен").isEqualTo("Вы действительно хотите удалить пользователя c логином testmytenders2?");
    }

}
