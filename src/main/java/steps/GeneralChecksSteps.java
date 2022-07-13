package steps;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import pages.GeneralChecksPage;

public class GeneralChecksSteps {

    GeneralChecksPage page;

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

    @Step("Прокрутить содержимое элемента вниз")
    public void scroll_down_to(By scroll){
        page.scrollDownTo(scroll);
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
        Assertions.assertThat(page.getTextLogin()).as("Логин некорректен, вход ошибочен").isEqualTo("AdminTestitTender");
    }

    @Step("Проверка соответствия подсказки фильтру 'И'")
    public void check_correct_hint_area_and(){
        Assertions.assertThat(page.isCorrectHintAreaAnd()).as("Текст подсказки не соответствует фильтру И").isTrue();
    }

    @Step("Проверка соответствия подсказки фильтру 'ИЛИ'")
    public void check_correct_hint_area_or(){
        Assertions.assertThat(page.isCorrectHintAreaOr()).as("Текст подсказки не соответствует фильтру ИЛИ").isTrue();
    }

    @Step("Проверка контекстного меню на второй странице после выбора всех элементов на первой странице")
    public void check_name_elements_context_menu(){
        Assertions.assertThat(page.isNameElementsContextMenu()).as("контекстное меню элемента таблицы результата поиска не соответствует правильному").isTrue();
    }

    @Step("Проверка не отображения в результатах поиска скрытого элемента")
    public void check_not_contain_hide_tender(){
        Assertions.assertThat(page.isNotContainHideTender()).as("В результатах поиска есть скрытый тендер").isTrue();
    }

    @Step("Проверка отображения в результатах поиска скрытого элемента")
    public void check_contain_hide_tender(){
        Assertions.assertThat(page.isContainHideTender()).as("В результатах поиска нет скрытого тендера").isTrue();
    }

    @Step("Проверка подписи кнопки переключения отображения скрытых тендеров")
    public void check_contain_number_hide_tender_description(){
        Assertions.assertThat(page.isContainNumberHideTenderDescription()).as("Некорректно отображается количество скрытых тендеров в подписи").isTrue();
    }

    @Step("Проверка отображения в результатах поиска удаленного из скрытых элемента")
    public void check_contain_not_hide_tender(){
        Assertions.assertThat(page.isContainNotHideTender()).as("В результатах поиска нет тендера, удаленного из скрытых").isTrue();
    }
}
