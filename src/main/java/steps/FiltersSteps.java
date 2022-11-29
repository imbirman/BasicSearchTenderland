package steps;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import pages.Filters;

public class FiltersSteps {

    Filters page;

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

    @Step("Ввод значения в поле поиска в фильтре")
    public void type_search(String search){
        page.typeSearch(search);
    }

    @Step("Ввод значения в поле поиска по тексту в фильтре 'Заказчик'")
    public void type_search_inside_filter_customer_text_search(String search){
        page.typeSearchInsideFilterCustomerTextSearch(search);
    }

    @Step("Ввод значения в поле поиска в фильтре 'Название тендера'")
    public void type_search_inside_filter_name_tender(String search){
        page.typeSearchInsideFilterNameTender(search);
    }

    @Step("Ввод значения в поле поиска по тексту в фильтре 'Заказчик'")
    public void type_search_inside_filter_customer(String search){
        page.typeSearchInsideFilterCustomer(search);
    }

    @Step("Ввод значения в поле исключения из поиска по тексту в фильтре 'Заказчик'")
    public void type_search_exclude_from_search_filter_customer(String search){
        page.typeExcludeFromSearchInsideFilterCustomer(search);
    }

    @Step("Ввод значения в поле цены от")
    public void type_price_from(String price){
        page.typePriceFrom(price);
    }

    @Step("Ввод значения в поле цены до")
    public void type_price_to(String price){
        page.typePriceTo(price);
    }

    @Step("Ввести название автопоиска")
    public void type_name_autosearch(String name){
        page.typeNameAutoSearch(name);
    }

    @Step("Перетаскивание фильтра")
    public void drag_and_drop_filter(By filter){
        page.dragAndDropFilter(filter);
    }

    @Step("Прокрутить содержимое элемента вниз")
    public void scroll_down_to(By scroll){
        page.scrollDownTo(scroll);
    }

    @Step("Проверка соответствия найденного значения по поиску ОКПД")
    public void check_result_search_by_okpd(){
        Assertions.assertThat(page.getResultSearchByFilter()).as("Найденный элемент не соответствует значению поиска")
                .isEqualTo("(85.11.10.000) Услуги в области дошкольного образования");
    }

    @Step("Проверка отсутствия в окне фильтра выбранного значения при очистке поля поиска")
    public void check_switch_show_only_selected_no(){
        Assertions.assertThat(page.isNotContainKeyWordByOKPDNo()).as("В окне фильтра 'ОКПД' отображается поисковый элемент").isTrue();
    }

    @Step("Проверка работы переключателя 'Показывать только выбранное' в фильтре ОКПД")
    public void check_switch_show_only_selected_yes(){
        Assertions.assertThat(page.isNotContainKeyWordByOKPDYes()).as("В окне фильтра 'ОКПД' не отображается поисковый элемент").isTrue();
    }

    @Step("Проверка сброса выделения найденного элемента")
    public void check_reset_result_search_by_okpd(){
        Assertions.assertThat(page.isResetResultSearchByFilterOKPD()).as("Найденный элемент не соответствует значению поиска")
                .isFalse();
    }

    @Step("Проверка соответствия найденного значения по поиску по категории")
    public void check_result_search_by_category(){
        Assertions.assertThat(page.getResultSearchByFilter()).as("Найденный элемент не соответствует значению поиска")
                .isEqualTo("Коммунальные услуги");
    }

    @Step("Проверка результата поиска без категории")
    public void check_result_search_by_without_category(){
        Assertions.assertThat(page.isContainEmptyCategory()).as("В поиске отсутствуют тендеры без категории")
                .isTrue();
    }

    @Step("Проверка ввода некорректной цены от")
    public void check_enter_incorrect_price_from(){
        Assertions.assertThat(page.getTextFieldPriceFrom()).as("Некорректное значение введено").isEqualTo("");
    }

    @Step("Проверка ввода некорректной цены до")
    public void check_enter_incorrect_price_to(){
        Assertions.assertThat(page.getTextFieldPriceTo()).as("Некорректное значение введено").isEqualTo("");
    }

    @Step("Проверка результата поиска с нулевой ценой")
    public void check_result_search_by_with_zero_price(){
        Assertions.assertThat(page.isContainZeroPrice()).as("В поиске отсутствуют тендеры с нулевой ценой")
                .isTrue();
    }

    @Step("Проверка результата поиска по тексту внутри фильтра 'Заказчик'")
    public void check_result_text_search_inside_filter_customer(){
        Assertions.assertThat(page.isContainKeyWordByTextSearchInsideFilterCustomer()).as("В поиске есть результаты без ключевого слова")
                .isTrue();
    }

    @Step("Проверка результата поиска по реквизитам внутри фильтра 'Заказчик'")
    public void check_result_search_inside_filter_customer(){
        Assertions.assertThat(page.isContainKeyWordBySearchInsideFilterCustomer()).as("В поиске есть результаты без ключевого слова")
                .isTrue();
    }

    @Step("Проверка результата поиска по региону внутри фильтра 'Заказчик'")
    public void check_result_search_region_inside_filter_customer(){
        Assertions.assertThat(page.isContainKeyWordByRegionSearchInsideFilterCustomer()).as("В поиске отсутствует необходимый результат (ИНДИВИДУАЛЬНЫЙ ПРЕДПРИНИМАТЕЛЬ КРАСНОГИР МАРИНА ВАСИЛЬЕВНА)")
                .isTrue();
    }

    @Step("Проверка результата поиска при исключении из поиска внутри фильтра 'Заказчик'")
    public void check_result_exclude_from_search_inside_filter_customer(){
        Assertions.assertThat(page.isNotContainKeyWordBySearchInsideFilterCustomer()).as("В поиске есть результаты с исключенным ключевым словом")
                .isTrue();
    }

    @Step("Проверка выделения чекбокса 'Выбрать всё' при переключении страницы в фильтре 'Заказчик'")
    public void check_selected_button_all_select(){
        Assertions.assertThat(page.isNotSelectedButtonAllSelect()).as("При переключении на вторую страницу чекбокс 'Выбрать всё' остается выделенным").isFalse();
    }

    @Step("Проверка несохранения выбранного значения при закрытии окна фильтра 'Заказчик'")
    public void check_save_after_close_filter(){
        Assertions.assertThat(page.getTextFilterInTreeCustomer()).as("После закрытия окна фильтра без сохранения выбранных элементов, элементы всё равно считаются выбранными").isEqualTo("Установить значение");
    }

    @Step("Проверка списка элементов комбобокса 'Направление' в фильтре 'Дата публикации'")
    public void check_list_elements_combobox_direction(){
        Assertions.assertThat(page.isContainTypesDirection()).as("В списке элементов есть несоответствия")
                .isTrue();
    }

    @Step("Проверка списка элементов комбобокса 'Единицы измерения' в фильтре 'Дата публикации'")
    public void check_list_elements_combobox_units(){
        Assertions.assertThat(page.isContainTypesUnits()).as("В списке элементов есть несоответствия")
                .isTrue();
    }

    @Step("Проверка списка элементов комбобокса 'Единицы измерения' в фильтре 'Дата публикации'")
    public void check_list_elements_of_filter_module(){
        Assertions.assertThat(page.isContainTypesModule()).as("В списке элементов есть несоответствия")
                .isTrue();
    }

    @Step("Проверка количества элементов комбобокса 'Направление' в фильтре 'Дата публикации'")
    public void check_number_list_elements_combobox_direction(){
        Assertions.assertThat(page.getNumberListCombobox()).as("Количество элементов не равно 2")
                .isEqualTo(2);
    }

    @Step("Проверка количества элементов комбобокса 'Единицы измерения' в фильтре 'Дата публикации'")
    public void check_number_list_elements_combobox_units(){
        Assertions.assertThat(page.getNumberListCombobox()).as("Количество элементов не равно 4")
                .isEqualTo(4);
    }

    @Step("Проверка количества элементов списка в фильтре 'Модуль'")
    public void check_number_list_elements_of_filter_module(){
        Assertions.assertThat(page.getNumberListModule()).as("Количество элементов не равно 4")
                .isEqualTo(4);
    }

    @Step("Проверка списка выбранных меток")
    public void check_list_elements_of_select_mark(){
        Assertions.assertThat(page.isContainSelectMark()).as("В списке меток есть несоответствия")
                .isTrue();
    }



}
