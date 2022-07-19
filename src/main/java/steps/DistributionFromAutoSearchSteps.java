package steps;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import pages.DistributionFromAutoSearch;

import java.io.IOException;

public class DistributionFromAutoSearchSteps {

    DistributionFromAutoSearch page;

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

    @Step("Нажать кнопку")
    public void click_button(WebElementFacade button){
        page.clickButton(button);
    }

    @Step("Очистить поле")
    public void clear_field(By field){
        page.clearField(field);
    }

    @Step("Ввод логина")
    public void type_login(String mail){
        page.typeLogin(mail);
    }

    @Step("Ввод пароля")
    public void type_password(String password){
        page.typePassword(password);
    }

    @Step("Ввод почты рассылки")
    public void type_email_distribution(String email){
        page.typeEmailDistribution(email);
    }

    @Step("Ввод пинкода")
    public void type_pincode(String pincode){
        page.typePinCode(pincode);
    }

    @Step("Перетаскивание фильтра")
    public void drag_and_drop_filter(By filter){
        page.dragAndDropFilter(filter);
    }

    @Step("Ввод значения в поле поиска в фильтре 'Название тендера'")
    public void type_search_inside_filter_name_tender(String search){
        page.typeSearchInsideFilterNameTender(search);
    }

    @Step("Ввести название автопоиска")
    public void type_name_autosearch(String name){
        page.typeNameAutoSearch(name);
    }

    @Step("Проверка наличия тестового автопоиска и его удаление")
    public void check_test_autosearch(){
        page.checkTestAutoSearch();
    }

    @Step("Проверка отображения даты включения рассылки")
    public void check_visible_date_create_distribution(){
        Assertions.assertThat(page.isVisibleDateCreateDistribution())
                .as("дата включения рассылки не отобразилась").isTrue();
    }

    @Step("Проверка отображения даты включения рассылки")
    public void check_contain_correct_date_create_distribution(){
        Assertions.assertThat(page.isContainCorrectDateCreateDistribution())
                .as("дата включения рассылки некорректна").isTrue();
    }

    @Step("Проверка статуса рассылки при включенной рассылке")
    public void check_correct_status_enabled_distribution(){
        Assertions.assertThat(page.isCorrectStatusDistribution())
                .as("дата включения рассылки некорректна").isEqualTo("Рассылка включена");
    }

    @Step("Проверка статуса рассылки при выключенной рассылке")
    public void check_correct_status_disabled_distribution(){
        Assertions.assertThat(page.isCorrectStatusDistribution())
                .as("дата включения рассылки некорректна").isEqualTo("Включить рассылку");
    }

    @Step("Проверка ошибки при сохранении автопоиска без почты или телеграмма для рассылки")
    public void check_correct_error_message_with_empty_account_for_distribution(){
        Assertions.assertThat(page.isCorrectErrorMessageWithEmptyAccountForDistribution())
                .as("текст ошибки некорректен").isEqualTo("Укажите email или telegram аккаунт для получения рассылки");
    }

    @Step("Проверка ошибки при сохранении автопоиска при пустом поле 'Пинкод'")
    public void check_correct_error_message_with_empty_field_pincode(){
        Assertions.assertThat(page.isCorrectErrorMessageWithEmptyFieldPinCode())
                .as("текст ошибки некорректен").isEqualTo("Введите защитный пин-код");
    }

    @Step("Проверка ошибки при сохранении автопоиска при некорректном заполнении поля 'Пинкод'")
    public void check_correct_error_message_with_wrong_pincode(){
        Assertions.assertThat(page.isCorrectErrorMessageWithWrongPinCode())
                .as("текст ошибки некорректен").isEqualTo("Неверный пин-код");
    }

    @Step("Проверка отображения ошибки при пустом поле 'Пинкод'")
    public void check_visible_error_message_with_empty_field_pincode(){
        Assertions.assertThat(page.isVisibleErrorMessageWithEmptyFieldPinCode())
                .as("ошибка отсутствует").isTrue();
    }
    @Step("Проверка отображения ошибки при некорректном заполнении поля 'Пинкод'")
    public void check_visible_error_message_with_wrong_pincode(){
        Assertions.assertThat(page.isVisibleErrorMessageWithWrongPinCode())
                .as("ошибка отсутствует").isTrue();
    }


    @Step("Проверка отображения ошибки при сохранении автопоиска без почты или телеграмма для рассылки")
    public void check_visible_error_message_with_empty_account_for_distribution(){
        Assertions.assertThat(page.isVisibleErrorMessageWithEmptyAccountForDistribution())
                .as("ошибка отсутствует").isTrue();
    }

    @Step("Проверка отображения блока аккаунтов и адресов рассылки для дочернего пользователя")
    public void check_visible_account_and_address_distribution_for_child_user(){
        Assertions.assertThat(page.isVisibleAccountAndAddressDistributionForChildUser())
                .as("блок аккаунтов и адресов рассылки не отобразился").isTrue();
    }

    @Step("Проверка отображения полей рассылки для дочернего пользователя")
    public void check_visible_fields_distribution_for_child_user(){
        Assertions.assertThat(page.isVisibleFieldsDistributionForChildUser())
                .as("блок полей рассылки не отобразился").isTrue();
    }

    @Step("Проверка отображения дней рассылки для дочернего пользователя")
    public void check_visible_days_distribution_for_child_user(){
        Assertions.assertThat(page.isVisibleDaysDistributionForChildUser())
                .as("блок дней рассылки не отобразился").isTrue();
    }

    @Step("Проверка отображения времени рассылки для дочернего пользователя")
    public void check_visible_times_distribution_for_child_user(){
        Assertions.assertThat(page.isVisibleTimesDistributionForChildUser())
                .as("блок времени рассылки не отобразился").isTrue();
    }

    @Step("Проверка чекбокса 'Пятница'")
    public void check_checkbox_friday(){
        Assertions.assertThat(page.isNotSelectedCheckboxFriday())
                .as("чекбокс 'Пятница' проставлен").isTrue();
    }

    @Step("Проверка чекбокса 'Суббота'")
    public void check_checkbox_saturday(){
        Assertions.assertThat(page.isSelectedCheckboxSaturday())
                .as("чекбокс 'Суббота' не проставлен").isTrue();
    }

    @Step("Проверка списка полей для рассылки")
    public void check_contain_correct_fields_for_distribution(String filePath) throws IOException {
        Assertions.assertThat(page.isContainCorrectFieldsForDistribution(filePath))
                .as("либо порядок, либо наименование полей не соответствует заданному").isTrue();
    }

    @Step("Проверка соответствия списка полей для рассылки")
    public void check_correct_fields_for_distribution(){
        Assertions.assertThat(page.isCorrectDefaultFieldsInBlockForDistribution())
                .as("Поля в блоке для рассылки не соответствуют полям в списке либо порядок полей некорректен").isTrue();
    }

    @Step("Проверка списка форм рассылки")
    public void check_list_distribution_methods(){
        Assertions.assertThat(page.isCorrectListDistributionMethods())
                .as("Либо некорректен порядок в списке форм рассылки, либо сам список").isTrue();
    }

    @Step("Проверка наличия в списке отчетов отчета дочернего пользователя")
    public void check_list_distribution_reports_include_child_user_report(){
        Assertions.assertThat(page.isCorrectListDistributionReportsIncludeChildUserReport())
                .as("В списке отчетов отсутствует отчет дочернего пользователя").isTrue();
    }

    @Step("Проверка наличия в списке отчетов отчета дочернего пользователя")
    public void check_list_distribution_reports_include_main_user_report(){
        Assertions.assertThat(page.isCorrectListDistributionReportsIncludeMainUserReport())
                .as("В списке отчетов отсутствует отчет родительского пользователя").isTrue();
    }

}
