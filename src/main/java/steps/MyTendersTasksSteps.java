package steps;

import static org.assertj.core.api.Assertions.assertThat;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import pages.MyTendersTasks;

public class MyTendersTasksSteps {

    MyTendersTasks page;

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

    @Step("Ввод названия задачи при добавлении новой")
    public void type_name_task(String name){
        page.typeNameTask("тестовая задача");
    }

    @Step("Проверка названия последней задачи в списке при добавлении задачи с дублирующим названием")
    public void  check_add_task_with_duplicate_name(){
        assertThat(page.getNameLastTask()).as("Задача с дублирующим названием добавилась").isNotEqualTo("тестовая задача 1");
    }

    @Step("Проверка добавления новой задачи")
    public void check_add_task(){
        assertThat(page.getNameLastTask()).as("Новая задача не добавилась или добавилась с некорректным названием").isEqualTo("тестовая задача");
    }
}
