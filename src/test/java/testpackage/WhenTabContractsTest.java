package testpackage;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import pages.TabContracts;
import steps.TabContractsSteps;

import java.text.ParseException;

@RunWith(SerenityRunner.class)
public class WhenTabContractsTest extends TabContracts {

    @Managed(driver = "chrome", uniqueSession=true)
    WebDriver driver;

    @Steps
    TabContractsSteps steps;

    @Before
    public void beforeMethod(){
        driver.manage().window().maximize();
        steps.open_login_main_page();
        steps.click_button(logInButton);
        steps.type_login("AdminTestitContract");
        steps.type_password("Hyqpmaz0");
        steps.click_button(signInButton);
    }

    @Test
    @Title("Проверка результата поиска контракта по продуктам")
    public void checkSearchContractByProduct(){

        steps.click_button(tabListAutoSearch);
        steps.wait_a_bit(500);
        steps.click_button(buttonCheckSearchByProduct);
        steps.wait_a_bit(500);
        steps.click_button(buttonSearch);
        steps.wait_a_bit(1000);
        steps.double_click_button(tableCellToCheck);
        steps.wait_a_bit(2000);
        steps.switch_to_tab();
        steps.click_button(tabListProductsInCardContract);
        steps.check_search_contract_by_product();
    }

    @Test
    @Title("Проверка поиска по цене контракта")
    public void checkPriceContract(){

        steps.click_button(tabListAutoSearch);
        steps.click_button(buttonCheckSearchByPrice);
        steps.wait_a_bit(2000);
        steps.click_button(filterValidateSearchByTenderPrice);
        steps.clear_field(fieldPriceFrom);
        steps.type_price_from("10000");
        steps.clear_field(fieldPriceTo);
        steps.type_price_to("50000");
        steps.click_button(openTabMenu);
        steps.click_button(buttonSearch);
        steps.wait_a_bit(2000);
        steps.check_price(10000,50000);
    }

    @Test
    @Title("Проверка поиска по статусу контракта 'Исполнение'")
    public void checkSearchByBeingExecuted(){

        steps.click_button(tabListAutoSearch);
        steps.click_button(buttonCheckSearchByStatusContracts);
        steps.click_button(filterSearchByMineTendersOrContractsStatus);
        steps.click_button(getCheckboxInFilter(0));
        steps.click_button(openTabMenu);
        steps.click_button(buttonSearch);
        steps.wait_a_bit(3000);
        steps.check_search_by_being_executed();
    }

    @Test
    @Title("Проверка поиска по статусу контракта 'Исполнение прекращено'")
    public void checkSearchByExecutionTerminated(){

        steps.click_button(tabListAutoSearch);
        steps.click_button(buttonCheckSearchByStatusContracts);
        steps.click_button(filterSearchByMineTendersOrContractsStatus);
        steps.click_button(getCheckboxInFilter(1));
        steps.click_button(openTabMenu);
        steps.click_button(buttonSearch);
        steps.wait_a_bit(1000);
        steps.check_search_by_execution_terminated();
    }
    @Test
    @Title("Проверка поиска по статусу контракта 'Исполнение завершено'")
    public void checkSearchByExecutionCompleted(){

        steps.click_button(tabListAutoSearch);
        steps.click_button(buttonCheckSearchByStatusContracts);
        steps.click_button(filterSearchByMineTendersOrContractsStatus);
        steps.click_button(getCheckboxInFilter(2));
        steps.click_button(openTabMenu);
        steps.click_button(buttonSearch);
        steps.wait_a_bit(1000);
        steps.check_search_by_execution_completed();
    }

    @Test
    @Title("Проверка даты публикации контракта")
    public void checkPublicationDateOfContract() throws ParseException {

        steps.click_button(tabListAutoSearch);
        steps.click_button(buttonCheckPublicationDate);
        steps.wait_a_bit(2000);
        steps.click_button(filterPublicationDate);
        steps.click_button(buttonClearFieldDateFrom);
        steps.type_date_from("01.01.2021");
        steps.click_button(openTabMenu);
        steps.click_button(buttonSearch);
        steps.wait_a_bit(2000);
        steps.check_date("01.01.2021 00:00","09.01.2021 23:59");
    }

    @Test
    @Title("Проверка даты начала исполнения контракта")
    public void checkContractExecutionStartDate() throws ParseException {

        steps.click_button(tabListAutoSearch);
        steps.click_button(buttonValidateSearchByContractExecutionStartDate);
        steps.wait_a_bit(2000);
        steps.check_date("13.01.2021 00:00","14.01.2021 23:59");
    }

    @Test
    @Title("Проверка даты окончания исполнения контракта")
    public void checkContractExecutionEndDate() throws ParseException {

        steps.click_button(tabListAutoSearch);
        steps.click_button(buttonValidateSearchByContractExecutionEndDate);
        steps.wait_a_bit(2000);
        steps.check_date("13.01.2021 00:00","14.01.2021 23:59");
    }

    @Test
    @Title("Проверка фактической даты исполнения контракта")
    public void checkContractActualExecutionDate() throws ParseException {

        steps.click_button(tabListAutoSearch);
        steps.click_button(buttonValidateSearchByContractActualExecutionDate);
        steps.wait_a_bit(2000);
        steps.check_date("13.01.2021 00:00","14.01.2021 23:59");
    }

    @Test
    @Title("Проверка даты подписания контракта")
    public void checkContractDateOfSigning() throws ParseException {

        steps.click_button(tabListAutoSearch);
        steps.click_button(buttonValidateSearchByContractDateOfSigning);
        steps.wait_a_bit(2000);
        steps.check_date("13.01.2021 00:00","14.01.2021 23:59");
    }

    @Test
    @Title("Проверка поиска по штрафу 'Просрочка исполнения поставщиком'")
    public void checkSearchByDelayInPerformanceBySupplier(){

        steps.click_button(tabListAutoSearch);
        steps.click_button(buttonCheckSearchByMulct);
        steps.wait_a_bit(2000);
        steps.click_button(filterSearchByMulct);
        steps.click_button(getCheckboxInFilter(0));
        steps.click_button(openTabMenu);
        steps.click_button(buttonSearch);
        steps.wait_a_bit(2000);
        steps.double_click_button(tableCellToCheck);
        steps.wait_a_bit(1000);
        steps.switch_to_tab();
        steps.click_button(tabMulctContracts);
        steps.check_search_delay_in_performance_by_supplier();
    }

    @Test
    @Title("Проверка поиска по штрафу 'Просрочка исполнения заказчиком обязательств'")
    public void checkSearchByDelayInFulfillmentOfObligationsByCustomer(){

        steps.click_button(tabListAutoSearch);
        steps.click_button(buttonCheckSearchByMulct);
        steps.wait_a_bit(2000);
        steps.click_button(filterSearchByMulct);
        steps.click_button(getCheckboxInFilter(1));
        steps.click_button(openTabMenu);
        steps.click_button(buttonSearch);
        steps.wait_a_bit(2000);
        steps.double_click_button(tableCellToCheck);
        steps.wait_a_bit(1000);
        steps.switch_to_tab();
        steps.click_button(tabMulctContracts);
        steps.check_search_delay_in_fulfillment_of_obligations_by_customer();
    }

    @Test
    @Title("Проверка поиска по штрафу 'Ненадлежащее исполнение поставщиком'")
    public void checkSearchByInadequateExecutionBySupplier(){

        steps.click_button(tabListAutoSearch);
        steps.click_button(buttonCheckSearchByMulct);
        steps.wait_a_bit(2000);
        steps.click_button(filterSearchByMulct);
        steps.click_button(getCheckboxInFilter(2));
        steps.click_button(openTabMenu);
        steps.click_button(buttonSearch);
        steps.wait_a_bit(2000);
        steps.double_click_button(tableCellToCheck);
        steps.wait_a_bit(1000);
        steps.switch_to_tab();
        steps.click_button(tabMulctContracts);
        steps.check_search_inadequate_execution_by_supplier();
    }

    @Test
    @Title("Проверка поиска по штрафу 'Ненадлежащее исполнение заказчиком обязательств'")
    public void checkSearchByInadequateExecutionByCustomer(){

        steps.click_button(tabListAutoSearch);
        steps.click_button(buttonCheckSearchByMulct);
        steps.wait_a_bit(2000);
        steps.click_button(filterSearchByMulct);
        steps.click_button(getCheckboxInFilter(3));
        steps.click_button(openTabMenu);
        steps.click_button(buttonSearch);
        steps.wait_a_bit(2000);
        steps.double_click_button(tableCellToCheck);
        steps.wait_a_bit(1000);
        steps.switch_to_tab();
        steps.click_button(tabMulctContracts);
        steps.check_search_inadequate_execution_by_customer();
    }

    @Test
    @Title("Проверка суммы штрафов контракта")
    public void checkSumMulctContract(){

        steps.click_button(tabListAutoSearch);
        steps.click_button(buttonCheckSearchBySumMulct);
        steps.click_button(buttonSearch);
        steps.wait_a_bit(2000);
        steps.double_click_button(tableCellToCheck);
        steps.switch_to_tab();
        steps.click_button(tabMulctContracts);
        steps.check_sum_mulct(10000,100000);
    }

    @Test
    @Title("Проверка наличия неоплаченных штрафов контракта")
    public void checkUnpaidMulctContract(){

        steps.click_button(tabListAutoSearch);
        steps.click_button(buttonCheckSearchByUnpaidMulct);
        steps.wait_a_bit(2000);
        steps.click_button(filterSearchByUnpaidMulct);
        steps.click_button(radiobuttonYesUnpaidMulct);
        steps.click_button(openTabMenu);
        steps.click_button(buttonSearch);
        steps.wait_a_bit(2000);
        steps.double_click_button(tableCellToCheck);
        steps.switch_to_tab();
        steps.click_button(tabMulctContracts);
        steps.check_unpaid_mulct();
    }

    @Test
    @Title("Проверка отсутствия неоплаченных штрафов контракта")
    public void checkPaidMulctContract(){

        steps.click_button(tabListAutoSearch);
        steps.click_button(buttonCheckSearchByUnpaidMulct);
        steps.wait_a_bit(2000);
        steps.click_button(filterSearchByUnpaidMulct);
        steps.click_button(radiobuttonNoUnpaidMulct);
        steps.click_button(openTabMenu);
        steps.click_button(buttonSearch);
        steps.wait_a_bit(2000);
        steps.double_click_button(tableCellToCheck);
        steps.switch_to_tab();
        steps.click_button(tabMulctContracts);
        steps.check_paid_mulct();
    }
}
