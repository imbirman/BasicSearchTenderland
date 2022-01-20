package steps;

import net.thucydides.core.annotations.Step;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import pages.AutoSearchPage;

import java.text.ParseException;

public class AutoSearchSteps extends AutoSearchPage {

    AutoSearchPage page;

    @Step("Ожидание")
    public void wait_a_bit(long number){
        waitFor(number);
    }

    @Step("Открытие страницы")
    public void open_login_main_page() {page.open();}

    @Step("Нажать кнопку")
    public void click_button(By button){
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

    @Step("Ввести ключевое слово для поиска")
    public void type_name_tender(String name){
        page.typeNameTender(name);
    }

    @Step("Ввести дату 'от'")
    public void type_date_from(String date){ page.typeDateFrom(date); }

    @Step("Ввести дату 'до'")
    public void type_date_to(String date){
        page.typeDateTo(date);
    }

    @Step("Ввести цену 'от'")
    public void type_price_from(String price){
        page.typePriceFrom(price);
    }

    @Step("Ввести цену 'до'")
    public void type_price_to(String price){
        page.typePriceTo(price);
    }

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

    @Step("Проверка даты")
    public void check_date(String startDate, String endDate) throws ParseException {
        Assertions.assertThat(page.checkDate(startDate, endDate))
                .as("Есть тендеры с датой, не входящей в заданный промежуток").isTrue();
    }

    @Step("Проверка поиска по категории")
    public void check_category_name(){
        Assertions.assertThat(page.isContainCategoryName()).as("Минимум у одного тендера указана неправильная категория").isTrue();
    }

    @Step("Проверка цены")
    public void check_price(float priceFrom, float priceTo){
        Assertions.assertThat(page.checkPrice(priceFrom, priceTo))
                .as("Есть тендеры с ценой, не входящей в заданный промежуток").isFalse();
    }
}
