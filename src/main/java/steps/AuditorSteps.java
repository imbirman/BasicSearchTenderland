package steps;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import pages.Auditor;

import java.text.ParseException;

public class AuditorSteps {

    Auditor page;

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

    @Step("Перетаскивание фильтра")
    public void drag_and_drop_filter(By filter){
        page.dragAndDropFilter(filter);
    }

    @Step("Двойной клик")
    public void double_click_button(By button){
        page.doubleClickButton(button);
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

    @Step("Ввод ключевого слова в поле 'включаем в поиск'")
    public void type_search_include(String search){
        page.typeSearchInclude(search);
    }

    @Step("Проверка результата поиска по реквизитам организации")
    public void check_search_by_organization_details(){
        Assertions.assertThat(page.isContainOrganizationDetail())
                .as("В результатах поиска присутствует организация с другим ИНН").isTrue();
    }

    @Step("Проверка результата поиска по учредителям")
    public void check_search_by_founders(){
        Assertions.assertThat(page.isContainNameFounders())
                .as("В результатах поиска отсутствует учредитель с ключевым словом").isTrue();
    }

    @Step("Проверка результата поиска по юридическому статусу")
    public void check_search_by_current_legal_status(){
        Assertions.assertThat(page.isContainCurrentLegalData())
                .as("В результатах поиска отсутствует юридический статус 'Действующая'").isTrue();
    }

    @Step("Проверка результата поиска по юридическому статусу")
    public void check_search_by_inactive_legal_status(){
        Assertions.assertThat(page.isContainInactiveLegalData())
                .as("В результатах поиска отсутствует юридический статус 'Недействующая'").isTrue();
    }

    @Step("Проверка даты регистрации")
    public void check_date(String startDate, String endDate) throws ParseException {
        Assertions.assertThat(page.checkDate(startDate, endDate))
                .as("Есть организации с датой регистрацией, не входящей в заданный промежуток").isTrue();
    }

    @Step("Проверка, что организация никогда не была в РНП")
    public void check_organization_never_been_in_rnp(){
        Assertions.assertThat(page.isNeverBeenInRNP())
                .as("организация либо была в РНП, либо находится в текущее время").isTrue();
    }

    @Step("Проверка, что организация была раньше в РНП")
    public void check_organization_formerly_been_in_rnp(){
        Assertions.assertThat(page.isFormerlyBeenInRNP())
                .as("организация либо была никогда не была в РНП, либо находится в текущее время").isTrue();
    }

    @Step("Проверка, что организация находится в РНП")
    public void check_organization_located_in_rnp(){
        Assertions.assertThat(page.isLocatedInRNP())
                .as("организация либо никогда не была в РНП, либо сейчас не находится в РНП").isTrue();
    }

    @Step("Проверка количества элементов контекстного меню")
    public void check_correct_number_elements_context_menu(){
        Assertions.assertThat(page.isCorrectNumberElementsContextMenu())
                .as("Количество элементов контекстного меню не равно 2").isTrue();
    }

    @Step("Проверка списка элементов контекстного меню")
    public void check_correct_name_elements_context_menu(){
        Assertions.assertThat(page.isCorrectNameElementsContextMenu())
                .as("Список элементов контекстного меню некорректен").isTrue();
    }

}
