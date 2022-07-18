package steps;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.assertj.core.api.Assertions;
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

    @Step("Ввод логина")
    public void type_login(String mail){
        page.typeLogin(mail);
    }

    @Step("Ввод пароля")
    public void type_password(String password){
        page.typePassword(password);
    }

    @Step("Ввод поисковой фразы")
    public void type_search_tenders(String search){
        page.typeSearchTenders(search);
    }

    @Step("Ввод названия задачи в списке тендеров")
    public void type_name_task_in_list(String name){
        page.typeNameTaskInList(name);
    }

    @Step("Ввод названия задачи в окне тендеров")
    public void type_name_task_in_window_tender(String name){
        page.typeNameTaskInWindowTender(name);
    }

    @Step("Навести курсор")
    public void move_to_element(By element){
        page.moveToElement(element);
    }

    @Step("Проверка наличия задачи у тендера и её удаление")
    public void check_task_for_delete(){
        page.checkTaskInListForDelete();
    }

    @Step("Проверка реестрового номера добавленного тендера")
    public void check_contain_correct_registry_number_adding_tender(){
        Assertions.assertThat(page.isContainCorrectRegistryNumberAddingTender()).as("Либо тендер не добавился, либо неверный реестровый номер").isTrue();
    }

    @Step("Проверка названия добавленного тендера")
    public void check_contain_correct_name_adding_tender(){
        Assertions.assertThat(page.isContainCorrectNameAddingTender()).as("Либо тендер не добавился, либо неверное название тендера").isTrue();
    }

    @Step("Проверка отсутствия удаленного тендера")
    public void check_not_contain_adding_tender(){
        Assertions.assertThat(page.isNotContainAddingTender()).as("Удаленный тендер остался").isTrue();
    }

    @Step("Проверка реестрового номера в окне тендера")
    public void check_correct_registry_number_in_window(){
        Assertions.assertThat(page.isCorrectRegistryNumberInWindow()).as("Реестровый номер в окне тендера отличается от номера в списке тендеров").isTrue();
    }

    @Step("Проверка наличия тендера в соответствующей вкладке")
    public void check_contain_switch_tender(String number){
        Assertions.assertThat(page.isContainSwitchTender()).as("Тендер не находится во вкладке " + number).isTrue();
    }

    @Step("Проверка отсутствия тендера в основной вкладке")
    public void check_not_contain_tender_switch_to_archive(String number){
        Assertions.assertThat(page.isNotContainTenderSwitchToArchive()).as("Тендер находится во вкладке " + number).isTrue();
    }

    @Step("Проверка счетчика вкладки")
    public void check_correct_number_counter(By element, String counter){
        Assertions.assertThat(page.isCorrectNumberCounter(element)).as("Счетчик вкладки " + counter +" неверный").isTrue();
    }

    @Step("Проверка отсутствия задачи в списке тендеров")
    public void check_not_visible_task_by_list(){
        Assertions.assertThat(page.isNotVisibleTaskByList()).as("После удаления задача есть в списке тендеров").isFalse();
    }

    @Step("Проверка добавления задачи в список тендеров и её названия")
    public void check_visible_and_contain_name_task_by_list(){
        Assertions.assertThat(page.isVisibleAndContainNameTaskByList()).as("Либо задача не добавилась в список тендеров, либо неверное название задачи").isTrue();
    }
    @Step("Проверка отсутствия задачи в окне тендера")
    public void check_not_visible_task_by_window_tender(){
        Assertions.assertThat(page.isNotVisibleTaskByWindowTender()).as("После удаления задача есть в окне тендера").isFalse();
    }


    @Step("Проверка добавления задачи в окне тендера и её названия")
    public void check_visible_and_contain_name_task_by_window_tender(){
        Assertions.assertThat(page.isVisibleAndContainNameTaskByWindowTender()).as("Либо задача не добавилась в список в окне тендера, либо неверное название задачи").isTrue();
    }

    @Step("Проверка наличия задач с пустым названием в окне тендера")
    public void check_empty_name_task_by_window_tender(){
        Assertions.assertThat(page.isEmptyNameTaskByWindowTender()).as("В списке задач в окне тендера есть задача или задачи с пустым названием").isTrue();
    }

    @Step("Проверка корректности типов сортировки списка тендеров")
    public void check_correct_list_types_sort(){
        Assertions.assertThat(page.isCorrectListTypesSort()).as("Список типов сортировки не соответствует заданному").isTrue();
    }

    @Step("Проверка статуса выполненной задачи в окне тендера")
    public void check_correct_task_completed_in_window_tender(){
        Assertions.assertThat(page.isCorrectStatusTaskCompletedInWindowTender()).as("Некорректный статус задачи").isTrue();
    }

    @Step("Проверка статуса выполненной задачи в окне тендера")
    public void check_correct_task_completed_in_list_tenders(){
        Assertions.assertThat(page.isCorrectStatusTaskCompletedInLisTenders()).as("Некорректный статус задачи").isTrue();
    }

    @Step("Проверка названия добавленного тендера")
    public void check_name_responsible_in_window_tender(){
        Assertions.assertThat(page.getNameResponsibleInWindowTender()).as("Либо тендер не добавился, либо неверное название тендера").isEqualTo("Тестовый Тест Тестович");
    }

    @Step("Проверка сортировки после поиска")
    public void check_correct_sort_list_tenders_after_search(){
        Assertions.assertThat(page.isCorrectSortListTendersAfterSearch()).as("Некорректная сортировка тендеров").isTrue();
    }

}
