package steps;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import pages.MarkSetting;

public class MarkSettingSteps {

    MarkSetting page;

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

    @Step("Переключиться на следующую вкладку")
    public void switch_to_tab(){
        page.switchToTab();
    }

    @Step("Нажать кнопку")
    public void click_button(WebElementFacade button){
        page.clickButton(button);
    }

    @Step("Навести курсор")
    public void move_to_element(By element){
        page.moveToElement(element);
    }

    @Step("Ввод логина")
    public void type_login(String mail){
        page.typeLogin(mail);
    }

    @Step("Ввод пароля")
    public void type_password(String password){
        page.typePassword(password);
    }

    @Step("Ввод названия метки")
    public void type_name_mark(String name){
        page.typeNameMark(name);
    }

    @Step("Прокрутить содержимое элемента вниз")
    public void scroll_down_to(By scroll){
        page.scrollDownTo(scroll);
    }

    @Step("Удалить новую метку")
    public void delete_new_mark(){
        page.deleteNewMark();
    }

    @Step("Проверка заблокированности кнопки удаления метки")
    public void check_disabled_button_delete_mark(){
        Assertions.assertThat(page.isDisabledButtonDeleteMark()).as("Кнопка удаления метки не заблокирована").isTrue();
    }

    @Step("Проверка появления текста ошибки при сохранении метки с пустым названием")
    public void check_visible_error_message_empty_name_mark(){
        Assertions.assertThat(page.isVisibleErrorMessageEmptyNameMark()).as("Ошибка при сохранении метки с пустым названием не отобразилась").isTrue();
    }

    @Step("Проверка текста ошибки при сохранении метки с пустым названием")
    public void check_correct_error_message_empty_name_mark(){
        Assertions.assertThat(page.isCorrectErrorMessageEmptyNameMark()).as("Текст ошибки при сохранении метки с пустым названием некорректен").isTrue();
    }

    @Step("Проверка текста ошибки при сохранении метки с пустым названием")
    public void check_correct_base_list_mark(){
        Assertions.assertThat(page.isCorrectBaseListMark()).as("Базовый список меток некорректен (либо состав, либо порядок)").isTrue();
    }

    @Step("Проверка списка меток после добавления новой метки")
    public void check_correct_list_mark_after_add_new_mark(){
        Assertions.assertThat(page.isCorrectListMarkAfterAddNewMark()).as("Список меток некорректен").isTrue();
    }

    @Step("Проверка названия новой метки")
    public void check_correct_name_new_mark(){
        Assertions.assertThat(page.isCorrectNameNewMark()).as("Название добавленной метки некорректно").isTrue();
    }

    @Step("Проверка появления новой метки")
    public void check_visible_new_mark(){
        Assertions.assertThat(page.isVisibleNewMark()).as("Метка не добавилась").isTrue();
    }

    @Step("Проверка отсутствия новой метки после удаления")
    public void check_not_visible_new_mark(){
        Assertions.assertThat(page.isNotVisibleNewMark()).as("Метка не удалилась").isTrue();
    }
}
