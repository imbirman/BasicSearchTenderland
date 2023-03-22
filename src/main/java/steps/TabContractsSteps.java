package steps;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import pages.TabContracts;

import java.text.ParseException;

public class TabContractsSteps {

    TabContracts page;

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

    @Step("Переключиться на следующую вкладку")
    public void switch_to_tab(){
        page.switchToTab();
    }

    @Step("Прокрутить элемент на заданное количество пикселей")
    public void scroll_element_on_pixels(String number, By scroll){
        page.scrollElementOnPixels(number, scroll);
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

    @Step("Ввести ключевое слово для поиска")
    public void type_name_tender(String name){
        page.typeNameTender(name);
    }

    @Step("Ввести ключевое слово для поиска фильтров")
    public void type_search_filters(String search){
        page.typeSearchFilters(search);
    }

    @Step("Ввести цену 'от'")
    public void type_price_from(String price){
        page.typePriceFrom(price);
    }

    @Step("Ввести цену 'до'")
    public void type_price_to(String price){
        page.typePriceTo(price);
    }

    @Step("Ввести дату 'от'")
    public void type_date_from(String date){ page.typeDateFrom(date); }

    @Step("Ввести дату 'до'")
    public void type_date_to(String date){
        page.typeDateTo(date);
    }

    @Step("Проверка результата поиска контракта по продуктам")
    public void check_search_contract_by_product() {
        Assertions.assertThat(page.isContainCardContractSearchWord())
                .as("В результатах поиска контракта по продуктам отсутствует заданное значение").isTrue();
    }

    @Step("Проверка цены")
    public void check_price(float priceFrom, float priceTo){
        Assertions.assertThat(page.checkPrice(priceFrom, priceTo))
                .as("Есть тендеры с ценой, не входящей в заданный промежуток: " + priceFrom + " - " + priceTo).isTrue();
    }

    @Step("Проверка поиска по статусу 'Исполнение'")
    public void check_search_by_being_executed(){
        Assertions.assertThat(page.isContainBeingExecuted())
                .as("В списке присутствует тендер, не имеющий статуса 'Исполнение'").isTrue();
    }

    @Step("Проверка поиска по статусу 'Исполнение прекращено'")
    public void check_search_by_execution_terminated(){
        Assertions.assertThat(page.isContainExecutionTerminated())
                .as("В списке присутствует тендер, не имеющий статуса 'Исполнение прекращено'").isTrue();
    }

    @Step("Проверка поиска по статусу 'Исполнение завершено'")
    public void check_search_by_execution_completed(){
        Assertions.assertThat(page.isContainExecutionCompleted())
                .as("В списке присутствует тендер, не имеющий статуса 'Исполнение завершено'").isTrue();
    }

    @Step("Проверка даты")
    public void check_date(String startDate, String endDate) throws ParseException {
        Assertions.assertThat(page.checkDate(startDate, endDate))
                .as("Есть тендеры с датой, не входящей в заданный промежуток").isTrue();
    }

    @Step("Проверка поиска по штрафу")
    public void check_search_delay_in_performance_by_supplier() {
        Assertions.assertThat(page.isContainCardContractSearchByDelayInPerformanceBySupplier())
                .as("В карточке тендера отсутствует штраф, по которому производился поиск").isTrue();
    }

    @Step("Проверка поиска по штрафу")
    public void check_search_delay_in_fulfillment_of_obligations_by_customer() {
        Assertions.assertThat(page.isContainCardContractSearchByDelayInFulfillmentOfObligationsByCustomer())
                .as("В карточке тендера отсутствует штраф, по которому производился поиск").isTrue();
    }

    @Step("Проверка поиска по штрафу")
    public void check_search_inadequate_execution_by_supplier() {
        Assertions.assertThat(page.isContainCardContractSearchByInadequateExecutionBySupplier())
                .as("В карточке тендера отсутствует штраф, по которому производился поиск").isTrue();
    }

    @Step("Проверка поиска по штрафу")
    public void check_search_inadequate_execution_by_customer() {
        Assertions.assertThat(page.isContainCardContractSearchByInadequateExecutionByCustomer())
                .as("В карточке тендера отсутствует штраф, по которому производился поиск").isTrue();
    }

    @Step("Проверка суммы штрафов")
    public void check_sum_mulct(float sumMulctFrom, float sumMulctTo){
        Assertions.assertThat(page.isSumMulct(sumMulctFrom, sumMulctTo))
                .as("Сумма штрафов в карточке контракту отсутствует либо есть контракты с суммой штрафов, не входящей в заданный промежуток: " + sumMulctFrom + " - " + sumMulctTo).isTrue();
    }

    @Step("Проверка наличия неоплаченных штрафов")
    public void check_unpaid_mulct(){
        Assertions.assertThat(page.isUnpaidMulct())
                .as("Есть контракты без неоплаченных штрафов").isTrue();
    }

    @Step("Проверка отсутствия неоплаченных штрафов")
    public void check_paid_mulct(){
        Assertions.assertThat(page.isPaidMulct())
                .as("Есть контракты с неоплаченными штрафами").isTrue();
    }
}
