package steps;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import pages.GeneralChecks;

import static org.assertj.core.api.Assertions.assertThat;

public class GeneralChecksSteps {

    GeneralChecks page;

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

    @Step("Прокрутить элемент на заданное количество пикселей")
    public void scroll_element_on_pixels(String number, By scroll){
        page.scrollElementOnPixels(number, scroll);
    }

    @Step("Прокрутить окно на определенное количество пикселей")
    public void scroll_window_on_pixels(String number){
        page.scrollWindowOnPixels(number);
    }

    @Step("Нажать кнопку")
    public void click_button(WebElementFacade button){
        page.clickButton(button);
    }

    @Step("Навести курсор")
    public void move_to_element(By element){
        page.moveToElement(element);
    }

    @Step("Перетаскивание фильтра")
    public void drag_and_drop_filter(By filter){
        page.dragAndDropFilter(filter);
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

    @Step("Проверка логина после входа")
    public void check_text_login(){
        assertThat(page.getTextLogin()).as("Логин некорректен, вход ошибочен").isEqualTo("AdminTestitTender");
    }

    @Step("Проверка соответствия подсказки фильтру 'И'")
    public void check_correct_hint_area_and(){
        assertThat(page.isCorrectHintAreaAnd()).as("Текст подсказки не соответствует фильтру И").isTrue();
    }

    @Step("Проверка соответствия подсказки фильтру 'ИЛИ'")
    public void check_correct_hint_area_or(){
        assertThat(page.isCorrectHintAreaOr()).as("Текст подсказки не соответствует фильтру ИЛИ").isTrue();
    }

    @Step("Проверка контекстного меню на второй странице после выбора всех элементов на первой странице")
    public void check_name_elements_context_menu(){
        assertThat(page.isNameElementsContextMenu()).as("контекстное меню элемента таблицы результата поиска не соответствует правильному").isTrue();
    }

    @Step("Проверка не отображения в результатах поиска скрытого элемента")
    public void check_not_contain_hide_tender(){
        assertThat(page.isNotContainHideTender()).as("В результатах поиска есть скрытый тендер").isTrue();
    }

    @Step("Проверка отображения в результатах поиска скрытого элемента")
    public void check_contain_hide_tender(){
        assertThat(page.isContainHideTender()).as("В результатах поиска нет скрытого тендера").isTrue();
    }

    @Step("Проверка подписи кнопки переключения отображения скрытых тендеров")
    public void check_contain_number_hide_tender_description(){
        assertThat(page.isContainNumberHideTenderDescription()).as("Некорректно отображается количество скрытых тендеров в подписи").isTrue();
    }

    @Step("Проверка отображения в результатах поиска удаленного из скрытых элемента")
    public void check_contain_not_hide_tender(){
        assertThat(page.isContainNotHideTender()).as("В результатах поиска нет тендера, удаленного из скрытых").isTrue();
    }

    @Step("Проверка чекбокса 'Выбрать всё' для результатов поиска после нажатия на кнопку 'Очистить поле' в области построения фильтров")
    public void check_not_selected_checkbox_selected_all_for_result_search(){
        assertThat(page.isNotSelectedCheckBoxSelectedAllForResultSearch()).as("Чекбокс 'Выбрать всё' выбран").isFalse();
    }
}
