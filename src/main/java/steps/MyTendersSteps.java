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

//    @Step("Проверка номера и места добавленного тендера")
//    public void check_register_number_added_tender(){
//        Assertions.assertThat(page.checkRegisterNumberAddedTender()).as("Добавленный тендер отсутствует, либо находится не на первом месте").isTrue();
//    }
//
//    @Step("Проверка номера и места добавленного тендера")
//    public void check_name_added_tender(){
//        Assertions.assertThat(page.checkNameAddedTender()).as("Наименование добавленного тендера некорректно").isTrue();
//    }
//
//    @Step("Проверка номера и места добавленного тендера")
//    public void check_delete_added_tender(){
//        Assertions.assertThat(page.checkDeleteAddedTender()).as("Добавленный тендер не удален").isTrue();
//    }
//
//    @Step("Проверка кликабельности кнопки удаления тендера в списке тендеров")
//    public void check_clickable_button_delete_tender_in_list_tenders(){
//        Assertions.assertThat(page.checkClickableButtonDeleteTenderInListTenders()).as("Кнопка удаления тендера в списке тендеров не активна").isTrue();
//    }
//
//    @Step("Проверка кликабельности кнопки скачивания документации тендера в списке тендеров")
//    public void check_clickable_button_load_documentation_tender_in_list_tenders(){
//        Assertions.assertThat(page.checkClickableButtonLoadDocumentationTenderInListTenders()).as("Кнопка скачивания документации тендера в списке тендеров не активна").isTrue();
//    }
//
//    @Step("Проверка некликабельности кнопки \"Удалить\" контекстного меню столбца")
//    public void check_disable_button_delete_context_menu_column(){
//        Assertions.assertThat(page.checkDisableButtonDeleteContextMenuColumn()).as("Кнопка 'Удалить' контекстного меню столбца активна при единственном столбце").isTrue();
//    }
//
//    @Step("Удаление второго столбца")
//    public void delete_second_column(){page.deleteSecondColumn();}
//
//    @Step("Проверка появления окна подтверждения удаления")
//    public void check_visible_window_approve_delete(){
//        Assertions.assertThat(page.checkVisibleWindowApproveDelete()).as("Окно подтверждения удаления не появилось").isTrue();
//    }
//
//    @Step("Проверка количества столбцов после добавления нового столбца")
//    public void check_number_columns_after_adding_column(){
//        Assertions.assertThat(page.getNumberColumns()).as("Новый столбец не добавился").isEqualTo("2");
//    }
//
//    @Step("Проверка количества столбцов после удаления столбца")
//    public void check_number_columns_after_delete_column(){
//        Assertions.assertThat(page.getNumberColumns()).as("Новый столбец не удален").isEqualTo("1");
//    }
//
//    @Step("Проверить название добавленного столбца")
//    public void check_name_added_column(){
//        Assertions.assertThat(page.getNameSecondColumn()).as("Название добавленного столбца некорректно").isEqualTo("Тестовый столбец");
//    }
}
