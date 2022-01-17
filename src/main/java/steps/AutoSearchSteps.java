package steps;

import net.thucydides.core.annotations.Step;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import pages.AutoSearchPage;

import java.text.ParseException;

public class AutoSearchSteps extends AutoSearchPage {

    AutoSearchPage page;

    @Step("Ожидание")
    public void wait_a_bit(){
        waitFor();
    }

    @Step("Открытие страницы")
    public void open_login_main_page() {page.open();}

    @Step("Нажать кнопку")
    public void click_button(By button){
        page.clickButton(button);
    } // Нажать на кнопку

    @Step("Очистить поле")
    public void click_field(By field){
        page.clearField(field);
    } // Нажать на кнопку

    @Step("Ввод логина")
    public void type_login(String mail){
        page.typeLogin(mail);
    } // Ввести данные логина

    @Step("Ввод пароля")
    public void type_password(String password){
        page.typePassword(password);
    } // Ввести данные пароля

    @Step("Ввести ключевое слово для поиска")
    public void type_name_tender(String name){
        page.typeNameTender(name);
    } // Ввести данные пароля

    @Step("Проверка логина после входа")
    public void check_text_login(){
        Assertions.assertThat(page.getTextLogin()).as("Логин некорректен, вход ошибочен").isEqualTo("AdminTestit");
    }

    @Step("Проверка количества результата поиска")
    public void check_number_result_search(){
        Assertions.assertThat(page.getNumberOfRowResultSearch()).as("Количество строк в результатах поиска не соответствует значению 1").isEqualTo(1);
    }

    @Step("Проверка реестрового номера для автопоиска 'Проверка поиска по реестровому номеру и региону'")
    public void check_registry_number(){
        Assertions.assertThat(page.getTextRegistryNumber()).as("").isEqualTo("200741742119000018");
    }

    @Step("Проверка количества результата поиска после добавления значения региона")
    public void check_registry_number_after_adding_region_value(){
        Assertions.assertThat(page.isEqualNumberOfRowResultSearch(1)).as("Результат поиска некорректен").isFalse();
    }

    @Step("Проверка названия тендера на включение в него ключевого слова")
    public void check_name_tender_to_include_keyword(){
        Assertions.assertThat(page.isContainNameTender()).as("Не во всех названиях тендеров есть ключевое слово").isTrue();
    }

    @Step("Проверка исключения тендеров с ключевым словом")
    public void check_deletion_name_tender_to_include_keyword(){
        Assertions.assertThat(page.isContainDeletionNameTender()).as("Минимум у одного тендера в названии есть исключенное слово").isTrue();
    }

    @Step()
    public void check_publication_date_of_tender(String startDate, String endDate) throws ParseException {
        Assertions.assertThat(page.getTextPublicationDate(startDate, endDate))
                .as("Есть тендеры с датой публикации не входящей в заданный промежуток").isTrue();
    }
}
