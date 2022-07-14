package steps;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import pages.TabPlans;

public class TabPlansSteps {

    TabPlans page;
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

    @Step("Проверка поиска по названию плана")
    public void check_search_by_name_plan(){
        Assertions.assertThat(page.isContainNamePlan())
                .as("Есть план без ключевого слова").isTrue();
    }

    @Step("Проверка поиска по типу плана плана")
    public void check_search_by_type_plan(){
        Assertions.assertThat(page.isContainTypePlan())
                .as("В результатах поиска есть тип плана отличный от 'План'").isTrue();
    }

    @Step("Проверка поиска по типу плана плана план-график")
    public void check_search_by_type_plan_schedule(){
        Assertions.assertThat(page.isContainTypePlanSchedule())
                .as("В результатах поиска есть тип плана отличный от 'План-график'").isTrue();
    }

    @Step("Проверка поиска по типу плана плана план-график 2017")
    public void check_search_by_type_plan_schedule_2017(){
        Assertions.assertThat(page.isContainTypePlanSchedule2017())
                .as("В результатах поиска есть тип плана отличный от 'План-график 2017'").isTrue();
    }
}
