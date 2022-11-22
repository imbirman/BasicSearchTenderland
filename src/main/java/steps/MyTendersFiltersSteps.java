package steps;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import pages.MyTendersFilters;

import static org.assertj.core.api.Assertions.assertThat;

public class MyTendersFiltersSteps {

    MyTendersFilters page;

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

    @Step("Ввод ключевого слова для поиска по тендеру")
    public void type_search_by_tender(String search){
        page.typeSearchByTender(search);
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

    @Step("Проверка сброса фильтра \"Наличие задач\"")
    public void check_reset_filter_availability_task(){
        assertThat(page.isCheckResetFilterAvailabilityTask()).as("Значение фильтра \"Наличие задач\" не сбросилось").isTrue();
    }
}
