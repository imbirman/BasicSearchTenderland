package steps;

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
    public void scroll_down_to(By scroll){
        page.scrollDownTo(scroll);
    }

    @Step("Ввести название пользовательского вида")
    public void type_name_custom_view(String name){
        page.typeNameCustomView(name);
    }

    @Step("Ввести в поле поиска пользовательского вида")
    public void type_search_column_custom_view(String search){
        page.typeSearchColumnCustomView(search);
    }

    @Step("Проверка списка пользовательских видов")
    public void check_list_name_custom_view(){
        page.checkAndCleanListNameCustomView();
    }

    @Step("Проверка сообщения об ошибке при сохранении пользовательского вида при пустом названии")
    public void check_error_message_save_custom_view_with_empty_name(){
        Assertions.assertThat(page.isErrorMessageEmptyNameFieldCustomView())
                .as("Сообщение об ошибке при пустом названии пользовательского вида либо отсутствует, либо текст ошибки не соответствует заданному").isTrue();
    }

    @Step("Проверка сообщения об ошибке при сохранении пользовательского вида при дублировании названия")
    public void check_error_message_save_custom_view_with_duplication_name(){
        Assertions.assertThat(page.isErrorMessageDuplicationNameFieldCustomView())
                .as("Сообщение об ошибке при дублировании названия либо отсутствует, либо текст ошибки не соответствует заданному").isTrue();
    }

    @Step("Проверка сообщения об ошибке при сохранении пользовательского вида без выбранных столбцов")
    public void check_error_message_save_custom_view_without_selected_column(){
        Assertions.assertThat(page.isErrorMessageWithoutSelectedColumn())
                .as("Сообщение об ошибке при охранении пользовательского вида без выбранных столбцов либо отсутствует, либо текст ошибки не соответствует заданному").isTrue();
    }

    @Step("Проверка названия сохраненного пользовательского вида")
    public void check_name_saved_custom_field(){
        Assertions.assertThat(page.isContainNameSavedCustomView())
                .as("Название сохраненного пользовательского вида не соответствует введенному").isTrue();
    }

    @Step("Проверка кликабельности кнопки \"Удалить\" до сохранения пользовательского вида")
    public void check_clickable_button_delete_custom_view(){
        Assertions.assertThat(page.isClickableDeleteButton())
                .as("Кнопка 'Удалить' кликабельна").isFalse();
    }

    @Step("Проверка кликабельности кнопки \"Сохранить настройки\" после сохранения пользовательского вида")
    public void check_clickable_button_save_settings_custom_view(){
        Assertions.assertThat(page.isClickableButtonSaveSettings())
                .as("Кнопка 'Сохранить настройки' кликабельна").isFalse();
    }

    @Step("Проверка количества элементов в списке пользовательских видов")
    public void check_number_element_of_list_custom_view(){
        Assertions.assertThat(page.getNumberListOfCustomView())
                .as("Количество элементов в списке пользовательских видов неверно").isEqualTo(1);
    }

    @Step("Проверка количества элементов в списке выбранных столбцов")
    public void check_number_element_of_list_selected_column(){
        Assertions.assertThat(page.isContainListColumn())
                .as("Список выбранных столбцов по умолчанию пуст при создании нового пользовательского вида").isFalse();
    }

    @Step("Проверка количества элементов в раскрывающемся списке пользовательских видов")
    public void check_number_element_of_expanded_list_custom_view(){
        Assertions.assertThat(page.getNumberExpandedListOfCustomView())
                .as("Количество элементов в раскрывающемся списке пользовательских видов неверно").isEqualTo(2);
    }

    @Step("Проверка названия добавленного вида")
    public void check_name_added_element_of_expanded_list_custom_view(){
        Assertions.assertThat(page.isContainAddedCustomView())
                .as("В раскрывающемся списке пользовательских видов наименование добавленного вида неверно").isTrue();
    }

    @Step("Проверка столбцов в таблице результата поиска после удаления столбца из пользовательского вида")
    public void check_not_contain_deleted_column(){
        Assertions.assertThat(page.isNotContainDeletedColumn())
                .as("В таблице результата поиска присутствует удаленный столбец из пользовательского вида").isTrue();
    }

    @Step("Проверка поиска в окне пользовательского вида")
    public void check_contain_result_search_column_custom_view(){
        Assertions.assertThat(page.isContainResultSearchColumnCustomView())
                .as("В результатах поиска присутствуют лишние элементы").isTrue();
    }

    @Step("Проверка добавления столбца пользовательского вида")
    public void check_contain_selected_column(){
        Assertions.assertThat(page.isContainSelectedColumn())
                .as("выбранный столбец не был добавлен").isTrue();
    }

    @Step("Проверка результата поиска столбца организатора")
    public void check_include_found_column_organizer(){
        Assertions.assertThat(page.isIncludeFoundColumnOrganizer())
                .as("в списке отсутствует ").isTrue();
    }
}
