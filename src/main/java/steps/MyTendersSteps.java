package steps;

import static org.assertj.core.api.Assertions.assertThat;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import pages.MyTenders;

public class MyTendersSteps {

    MyTenders page;

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

    @Step("Перетаскивание фильтра")
    public void drag_and_drop_tender(WebElementFacade tender, By field){
        page.dragAndDropTenderToSecondColumn(tender, field);
    }

    @Step("Ввод логина")
    public void type_login(String mail){
        page.typeLogin(mail);
    }

    @Step("Ввод пароля")
    public void type_password(String password){
        page.typePassword(password);
    }

    @Step("Ввод ключевого слова для поиска по тендеру")
    public void type_search_by_tender(String search){
        page.typeSearchByTender(search);
    }

    @Step("Ввод названия столбца")
    public void type_name_column(String name){
        page.typeNameColumn(name);
    }

    @Step("Навести курсор")
    public void move_to_element(By element){
        page.moveToElement(element);
    }

    @Step("Прокрутить содержимое элемента вниз")
    public void scroll_down_to(By scroll){
        page.scrollDownTo(scroll);
    }

    @Step("Добавить в мои тендеры")
    public void add_in_my_tenders(){page.addInMyTenders();}

    @Step("Получить тендер по его порядковому номеру в первом столбце")
    public WebElementFacade get_tender_by_number_in_first_column(int number, int numberColumn){
        return  page.getTenderByNumberInFirstColumn(number, numberColumn);
    }

    @Step("Проверка реестрового номера добавленного тендера")
    public void check_register_number_added_tender(){
        assertThat(page.getRegisterNumberAddedTender()).as("Добавленный тендер отсутствует, либо находится не на первом месте").isEqualTo("0372200015221000002");
    }

    @Step("Проверка наименования добавленного тендера")
    public void check_name_added_tender(){
        assertThat(page.isCheckNameAddedTender()).as("Наименование добавленного тендера некорректно").isTrue();
    }

    @Step("Проверка удаления тендера")
    public void check_delete_added_tender(){
        assertThat(page.isCheckDeleteAddedTender()).as("Добавленный тендер не удален").isTrue();
    }

    @Step("Проверка кликабельности кнопки удаления тендера в списке тендеров")
    public void check_clickable_button_delete_tender_in_list_tenders(){
        assertThat(page.isCheckClickableButtonDeleteTenderInListTenders()).as("Кнопка удаления тендера в списке тендеров не активна").isTrue();
    }

    @Step("Проверка кликабельности кнопки скачивания документации тендера в списке тендеров")
    public void check_clickable_button_load_documentation_tender_in_list_tenders(){
        assertThat(page.isCheckClickableButtonLoadDocumentationTenderInListTenders()).as("Кнопка скачивания документации тендера в списке тендеров не активна").isTrue();
    }

    @Step("Проверка кликабельности кнопки смены метки тендера в карточке тендера")
    public void check_clickable_button_change_tag(){
        assertThat(page.isCheckClickableButtonChangeTag()).as("Кнопка смены метки тендера не активна").isTrue();
    }

    @Step("Проверка кликабельности кнопки смены метки тендера в карточке тендера")
    public void check_clickable_button_link_source(){
        assertThat(page.isCheckClickableButtonLinkSource()).as("Кнопка ссылки на источник не активна").isTrue();
    }

    @Step("Проверка кликабельности кнопки смены метки тендера в карточке тендера")
    public void check_clickable_button_delete_tender_in_card(){
        assertThat(page.isCheckClickableButtonDeleteTenderInCard()).as("Кнопка удаления тендера не активна").isTrue();
    }

    @Step("Проверка кликабельности главной вкладки \"Карточки\"")
    public void check_clickable_tab_cards(){
        assertThat(page.isCheckClickableTabCards()).as("Вкладка Карточки не активна").isTrue();
    }

    @Step("Проверка кликабельности главной вкладки \"Таблица\"")
    public void check_clickable_tab_table(){
        assertThat(page.isCheckClickableTabTable()).as("Вкладка Таблица не активна").isTrue();
    }

    @Step("Проверка кликабельности главной вкладки \"Календарь\"")
    public void check_clickable_tab_calendar(){
        assertThat(page.isCheckClickableTabCalendar()).as("Вкладка Календарь не активна").isTrue();
    }

    @Step("Проверка некликабельности кнопки \"Удалить\" контекстного меню столбца")
    public void check_disable_button_delete_context_menu_column(){
        assertThat(page.isCheckDisableButtonDeleteContextMenuColumn()).as("Кнопка 'Удалить' контекстного меню столбца активна при единственном столбце").isTrue();
    }

    @Step("Удаление второго столбца")
    public void delete_second_column(){page.deleteSecondColumn();}

    @Step("Проверка появления окна подтверждения удаления")
    public void check_visible_window_approve_delete(){
        assertThat(page.isCheckVisibleWindowApproveDelete()).as("Окно подтверждения удаления не появилось").isTrue();
    }

    @Step("Проверка количества столбцов после добавления нового столбца")
    public void check_number_columns_after_adding_column(){
        assertThat(page.getNumberColumns()).as("Новый столбец не добавился").isEqualTo(2);
    }

    @Step("Проверка количества столбцов после удаления столбца")
    public void check_number_columns_after_delete_column(){
        assertThat(page.getNumberColumns()).as("Новый столбец не удален").isEqualTo(1);
    }

    @Step("Проверить название добавленного столбца")
    public void check_name_added_column(){
        assertThat(page.getNameSecondColumn()).as("Название добавленного столбца некорректно").isEqualTo("Тестовый столбец");
    }

    @Step("Проверка количества фильтров")
    public void check_number_filters(){
        assertThat(page.getNumberFilters()).as("Количество фильтров некорректно").isEqualTo(9);
    }

    @Step("Проверка поиска по реестровому номеру тендера")
    public void check_search_by_register_number_tender_in_tab_cards(){
        assertThat(page.isCheckSearchByRegisterNumberTender()).as("В списке тендеров нет тендера, в чей реестровый номер входит ключевое слово").isTrue();
    }

    @Step("Проверка поиска по названию тендера")
    public void check_search_by_name_tender_in_tab_cards(){
        assertThat(page.isCheckSearchByNameTender()).as("В списке тендеров нет тендера, в чьё название входит ключевое слово").isTrue();
    }

    @Step("Проверка поиска по названию тендера")
    public void check_search_by_user_in_tab_cards(){
        assertThat(page.getResponsibleInCardTender()).as("В списке тендеров нет тендера, в чьё название входит ключевое слово").isEqualTo("Админ");
    }

    @Step("Проверка поиска по метке тендера")
    public void check_search_by_tags_in_tab_cards(){
        assertThat(page.isCheckSearchByTags()).as("В списке тендеров нет тендера, в чьё название входит ключевое слово").isTrue();
    }

    @Step("Проверка отображения карточки тендера")
    public void check_visible_cards(){
        assertThat(page.isCheckVisibleCard()).as("Карточка тендера не открылась").isTrue();
    }

    @Step("Проверка количества вкладок в карточке тендера")
    public void check_number_tab_in_card_tender(){
        assertThat(page.getNumberTabInCardTender()).as("Кнопка удаления тендера не активна").isEqualTo(5);
    }

    @Step("Проверка на отсутствие или наличие перетаскиваемого тендера в столбцах")
    public void check_drag_and_drop_tender(){
        assertThat(page.isCheckDragAndDropTender()).as("Тендер перенесен в другой столбец некорректно").isTrue();
    }

    @Step("Проверка смены ответственного во вкладке \"Таблица\"")
    public void check_change_responsible_in_tab_table(){
        assertThat(page.getResponsibleInTabTable()).as("При смене ответственного в карточке тендера, во вкладке таблица он не изменился")
                .isEqualTo("Тестовый Тест Тестович");
    }

    @Step("Проверка смены ответственного во вкладке \"Карточки\"")
    public void check_change_responsible_in_tab_cards(){
        assertThat(page.getResponsibleInCardTender()).as("При смене ответственного во вкладке таблица, в карточке тендера он не изменился")
                .isEqualTo("Тестовый Тест Тестович");
    }

    @Step("Проверка отображения карточки тендера")
    public void check_reset_filter_availability_task(){
        assertThat(page.isCheckResetFilterAvailabilityTask()).as("Значение фильтра \"Наличие задач\" не сбросилось").isTrue();
    }

    @Step("Проверка максимальной длины названия столбца")
    public void check_max_length_name_column(){
        assertThat(page.isCheckMaxLengthNameColumn()).as("Максимальная длина названия столбца больше 25").isTrue();
    }

}
