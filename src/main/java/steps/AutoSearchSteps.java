package steps;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import pages.AutoSearch;

public class AutoSearchSteps {

    AutoSearch page;

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
    public void check_test_autosearch_and_delete(){
        page.checkTestAutoSearchAndDelete();
    }

    @Step("Проверка сообщения об ошибке при сохранении автопоиска без названия")
    public void check_error_message_save_autosearch_without_name(){
        Assertions.assertThat(page.isErrorMessageEmptyNameFieldAutoSearch())
                .as("Сообщение об ошибке при пустом названии автопоиска либо отсутствует, либо текст ошибки не соответствует заданному").isTrue();
    }

    @Step("Проверка сообщения об ошибке при сохранении автопоиска без названия")
    public void check_error_message_save_autosearch_with_duplicate_name(){
        Assertions.assertThat(page.isErrorMessageDuplicateNameFieldAutoSearch())
                .as("Сообщение об ошибке при дублировании названия автопоиска либо отсутствует, либо текст ошибки не соответствует заданному").isTrue();
    }

    @Step("Проверка названия автопоиска в древе построения фильтров")
    public void check_correct_name_autosearch(){
        Assertions.assertThat(page.isCorrectNameAutoSearch())
                .as("Название автопоиска в дереве построения фильтров некорректно").isTrue();
    }

    @Step("Проверка корректного названия созданного автопоиска и одноразовость создания")
    public void check_contain_autosearch(){
        Assertions.assertThat(page.isContainAutoSearch())
                .as("В списке автопоисков отсутствует автопоиск с корректным названием или не в единичном экземпляре").isTrue();
    }

    @Step("Проверка отсутствия автопоиска после удаления")
    public void check_not_contain_autosearch(){
        Assertions.assertThat(page.isNotContainAutoSearch())
                .as("В списке автопоисков присутствует удаленный автопоиск").isTrue();
    }

    @Step("Проверка кликабельности кнопки копирования ссылки автопоиска")
    public void check_clickable_button_copy_link_autosearch_in_building_search(){
        Assertions.assertThat(page.isClickableButtonCopyLinkAutoSearchInBuildingSearch())
                .as("Кнопка копирования ссылки автопоиска не кликабельна").isTrue();
    }

    @Step("Проверка кликабельности кнопки копирования автопоиска")
    public void check_clickable_button_copy_autosearch_in_building_search(){
        Assertions.assertThat(page.isClickableButtonCopyAutoSearchInBuildingSearch())
                .as("Кнопка копирования автопоиска не кликабельна").isTrue();
    }

    @Step("Проверка кликабельности кнопки удаления автопоиска")
    public void check_clickable_button_delete_autosearch_in_building_search(){
        Assertions.assertThat(page.isClickableButtonDeleteAutoSearchInBuildingSearch())
                .as("Кнопка удаления автопоиска не кликабельна").isTrue();
    }

    @Step("Проверка кликабельности кнопки закрытия автопоиска")
    public void check_clickable_button_close_autosearch_in_building_search(){
        Assertions.assertThat(page.isClickableButtonCloseAutoSearchInBuildingSearch())
                .as("Кнопка закрытия автопоиска не кликабельна").isTrue();
    }

    @Step("Проверка кликабельности кнопки сохранения автопоиска")
    public void check_clickable_button_save_autosearch(){
        Assertions.assertThat(page.isClickableButtonSaveAutoSearch())
                .as("Кнопка сохранения автопоиска не кликабельна").isFalse();
    }

    @Step("Проверка некликабельности кнопки сохранения автопоиска")
    public void check_not_clickable_button_save_autosearch(){
        Assertions.assertThat(page.isClickableButtonSaveAutoSearch())
                .as("Кнопка сохранения автопоиска кликабельна").isTrue();
    }

    @Step("Проверка некликабельности кнопки включения/выключения пинкода")
    public void check_not_clickable_button_switch_pin_code(){
        Assertions.assertThat(page.isClickableButtonSwitchPinCode())
                .as("Кнопка включения/выключения пинкода кликабельна").isTrue();
    }

    @Step("Проверка кликабельности кнопки включения/выключения пинкода")
    public void check_clickable_button_switch_pin_code(){
        Assertions.assertThat(page.isClickableButtonSwitchPinCode())
                .as("Кнопка включения/выключения пинкода некликабельна").isFalse();
    }

    @Step("Проверка отображения версии автопоиска")
    public void check_visible_version_autosearch(){
        Assertions.assertThat(page.isVisibleVersionAutoSearch())
                .as("Во вкладке 'Версия автопоиска' отсутствует версия автопоиска").isTrue();
    }

    @Step("Проверка логина во вкладке 'версия автопоиска'")
    public void check_correct_login_user_in_version_autosearch(){
        Assertions.assertThat(page.isCorrectLoginUserInVersionAutoSearch())
                .as("Во вкладке 'Версия автопоиска' некорректный логин").isEqualTo("AdminTestitAutoSearch");
    }

    @Step("Проверка названия пользовательского вида")
    public void check_correct_name_custom_view(){
        Assertions.assertThat(page.isCorrectNameCustomView())
                .as("Название пользовательского вида некорректно").isEqualTo("Тестовый вид");
    }

    @Step("Проверка отсутствия версии автопоиска")
    public void check_contain_message_no_data_version_autosearch(){
        Assertions.assertThat(page.isContainMessageNoDataVersionAutoSearch())
                .as("Либо отсутствует сообщение об отсутствии версий автопоиска, либо есть версии автопоиска.").isTrue();
    }

    @Step("Проверка названия автопоиска после копирования")
    public void check_contain_correct_name_autosearch_after_copy(){
        Assertions.assertThat(page.isContainCorrectNameAutoSearchAfterCopy())
                .as("Название автопоиска некорректно").isTrue();
    }

}
