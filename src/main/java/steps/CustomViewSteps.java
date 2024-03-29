package steps;

import static org.assertj.core.api.Assertions.assertThat;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import pages.CustomView;

public class CustomViewSteps {

    CustomView page;

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

    @Step("Прокрутить содержимое элемента вниз")
    public void scroll_element_on_pixels(String number, By scroll){
        page.scrollElementOnPixels(number, scroll);
    }

    @Step("Ввести название пользовательского вида")
    public void type_name_custom_view(String name){
        page.typeNameCustomView(name);
    }

    @Step("Ввести в поле поиска пользовательского вида")
    public void type_search_column_custom_view(String search){
        page.typeSearchColumnCustomView(search);
    }

    @Step("Проверка количества элементов для выбора в блоке 'Поля таблицы' на вкладке 'Тендеры'")
    public void check_number_elements_table_fields_for_selection_on_tab_tender(){
        assertThat(page.getNumberElementsTableFieldsForSelection()).as("Количество элементов для выбора в блоке 'Поля таблицы' на вкладке 'Тендеры' некорректно. Должно быть 12.").isEqualTo(12);
    }

    @Step("Проверка количества элементов для выбора в блоке 'Поля таблицы' на вкладке 'Контракты'")
    public void check_number_elements_table_fields_for_selection_on_tab_contracts(){
        assertThat(page.getNumberElementsTableFieldsForSelection()).as("Количество элементов для выбора в блоке 'Поля таблицы' на вкладке 'Контракты' некорректно. Должно быть 12.").isEqualTo(13);
    }

    @Step("Проверка количества элементов для выбора в блоке 'Поля таблицы' на вкладке 'Контракты'")
    public void check_number_elements_table_fields_for_selection_on_tab_plans(){
        assertThat(page.getNumberElementsTableFieldsForSelection()).as("Количество элементов для выбора в блоке 'Поля таблицы' на вкладке 'Планы' некорректно. Должно быть 12.").isEqualTo(15);
    }

    @Step("Проверка количества элементов для выбора в блоке 'Детализация'")
    public void check_number_elements_detailing_fields_for_selection(){
        assertThat(page.getNumberElementsDetailingFieldsForSelection()).as("Количество элементов для выбора в блоке 'Детализация'. Должно быть 1.").isEqualTo(1);
    }

    @Step("Проверка количества выбранных элементов в блоке Поля таблицы")
    public void check_number_elements_table_fields_selected_tender(){
        assertThat(page.getNumberElementsTableFieldsSelected()).as("Количество выбранных элементов в блоке 'Поля таблицы' для тендеров некорректно. Должно быть 12.").isEqualTo(12);
    }

    @Step("Проверка количества выбранных элементов в блоке Детализация")
    public void check_number_elements_detailing_fields_selected(){
        assertThat(page.getNumberElementsDetailingFieldsSelected()).as("Количество выбранных элементов в блоке 'Детализация' некорректно. Должно быть 4.").isEqualTo(4);
    }

    @Step("Проверка значения поля 'Выбрать поле для сортировки' по умолчанию")
    public void check_value_default_sort_field(){
        assertThat(page.getValueDefaultSortField()).as("По умолчанию для сортировки стоит НЕ поле 'Дата публикации'").isEqualTo("Дата публикации");
    }

    @Step("Проверка значения сортировки 'По убыванию' по умолчанию")
    public void check_selected_radiobutton_descending_default(){
        assertThat(page.checkSelectedRadiobuttonDescending()).as("По значение сортировки 'По убыванию' НЕ выбрано").isTrue();
    }

    @Step("Проверка значения чекбокса 'Раскрывать детализации' по умолчанию")
    public void check_checkbox_disclose_detailing_default(){
        assertThat(page.checkCheckboxDiscloseDetailing()).as("По умолчанию чекбокс 'По убыванию' НЕ выбран").isTrue();
    }

    @Step("Проверка отображения количества выбранных полей по умолчанию")
    public void check_value_label_selected_fields_default(){
        assertThat(page.getValueLabelSelectedFields()).as("по умолчанию отображается некорректное количество выбранных полей").isEqualTo("Выбрано полей - 12");
    }

    @Step("Проверка отображения количества выбранных детализаций по умолчанию")
    public void check_value_label_selected_detailing_default(){
        assertThat(page.getValueLabelSelectedDetailing()).as("по умолчанию отображается некорректное количество выбранных детализаций").isEqualTo("Выбрано детализаций - 4");
    }

    @Step("Проверка количества вкладок пользовательских видов после нажатия на кнопку 'Добавить вид'")
    public void check_number_tab_custom_view_after_adding_new_view(){
        assertThat(page.getNumberTabCustomView()).as("Новый вид не добавился").isEqualTo(3);
    }

    @Step("Проверка количества вкладок пользовательских видов после закрытия окна настроек и несохранении нового пользовательского вида")
    public void check_number_tab_custom_view_without_save_new_view(){
        assertThat(page.getNumberTabCustomView()).as("Добавление нового вида сохранилось после закрытия окна настроек").isEqualTo(2);
    }

    @Step("Проверка количества вкладок пользовательских видов после сохранения пользовательского вида без названия")
    public void check_number_tab_custom_view_after_save_new_view_without_name(){
        assertThat(page.getNumberTabCustomView()).as("Добавился новый пользовательский вид без названия").isEqualTo(2);
    }

    @Step("Проверка кликабельности кнопки контекстного меню пользовательского вида \"Переименовать\"")
    public void check_clickable_button_rename_context_menu_custom_view(){
        assertThat(page.checkClickableButtonRenameContextMenuCustomView()).as("Кнопка 'Переименовать' контекстного меню пользовательского вида не кликабельна").isTrue();
    }

    @Step("Проверка кликабельности кнопки контекстного меню пользовательского вида \"Удалить\"")
    public void check_clickable_button_delete_context_menu_custom_view(){
        assertThat(page.checkClickableButtonDeleteContextMenuCustomView()).as("Кнопка 'Удалить' контекстного меню пользовательского вида не кликабельна").isTrue();
    }

    @Step("Проверка отображения сообщение об ошибке при сохранении пользовательского вида без выбранных полей")
    public void check_visible_label_error_save_custom_view_without_selected_fields(){
        assertThat(page.checkVisibleLabelErrorSaveCustomViewWithoutSelectedFields()).as("Сообщение об ошибке сохранения пользовательского вида без выбранных полей не отображается").isTrue();
    }

    @Step("Проверка текста сообщения об ошибке при сохранении пользовательского вида без выбранных полей")
    public void check_text_error_save_custom_view_without_selected_fields(){
        assertThat(page.getTextErrorSaveCustomViewWithoutSelectedFields()).as("Сообщение об ошибке сохранения пользовательского вида без выбранных полей некорректно").isEqualTo("Необходимо выбрать хотя бы 1 поле");
    }

    @Step("Проверка отображения названия пользовательского вида")
    public void check_displayed_name_tab_custom_view_by_number(int number){
        assertThat(page.checkDisplayedNameTabCustomViewByNumber(number)).as("Название пользовательского вида не сохранилось").isTrue();
    }

    @Step("Проверка сообщения об ошибке при сохранении пользовательского вида при пустом названии")
    public void check_error_message_save_custom_view_with_empty_name(){
        assertThat(page.isErrorMessageEmptyNameFieldCustomView())
                .as("Сообщение об ошибке при пустом названии пользовательского вида либо отсутствует, либо текст ошибки не соответствует заданному").isTrue();
    }

    @Step("Проверка поиска в окне пользовательского вида")
    public void check_contain_result_search_column_custom_view(){
        assertThat(page.isContainResultSearchColumnCustomView())
                .as("В результатах поиска присутствуют лишние элементы или отсутствуют нужные").isTrue();
    }

    @Step("Проверка добавления столбца пользовательского вида")
    public void check_contain_selected_column(){
        assertThat(page.isContainSelectedColumn())
                .as("выбранный столбец не был добавлен").isTrue();
    }

    @Step("Проверка заблокированности элемента детализации для контрактов")
    public void check_disabled_element_contract_detailing_to_select(){
        assertThat(page.isDisabledElementContractDetailingToSelect()).as("Элемент детализации для контрактов НЕ заблокирован для выбора").isTrue();
    }

    @Step("Проверка заблокированности элемента детализации для тендеров")
    public void check_disabled_element_tender_detailing_to_select(){
        assertThat(page.isDisabledElementTenderDetailingToSelect()).as("Элемент детализации для тендеров НЕ заблокирован для выбора").isTrue();
    }
}
