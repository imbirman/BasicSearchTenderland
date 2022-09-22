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

    @Step("Проверка номера и места добавленного тендера")
    public void check_register_number_added_tender(){
        Assertions.assertThat(page.checkRegisterNumberAddedTender()).as("Добавленный тендер отсутствует, либо находится не на первом месте").isTrue();
    }

    @Step("Проверка номера и места добавленного тендера")
    public void check_name_added_tender(){
        Assertions.assertThat(page.checkNameAddedTender()).as("Наименование добавленного тендера некорректно").isTrue();
    }

    @Step("Проверка номера и места добавленного тендера")
    public void check_delete_added_tender(){
        Assertions.assertThat(page.checkDeleteAddedTender()).as("Добавленный тендер не удален").isTrue();
    }

    @Step("Проверка кликабельности кнопки удаления тендера в списке тендеров")
    public void check_clickable_button_delete_tender_in_list_tenders(){
        Assertions.assertThat(page.checkClickableButtonDeleteTenderInListTenders()).as("Кнопка удаления тендера в списке тендеров не активна").isTrue();
    }

    @Step("Проверка кликабельности кнопки скачивания документации тендера в списке тендеров")
    public void check_clickable_button_load_documentation_tender_in_list_tenders(){
        Assertions.assertThat(page.checkClickableButtonLoadDocumentationTenderInListTenders()).as("Кнопка скачивания документации тендера в списке тендеров не активна").isTrue();
    }

}
