package testpackage;


import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import pages.AutoSearchPage;
import steps.AutoSearchSteps;

import java.text.ParseException;

@RunWith(SerenityRunner.class)
public class WhenAutoSearchTest extends AutoSearchPage {

//    WebDriver driver;

    @Managed(driver = "chrome", uniqueSession=true)
    WebDriver driver;



    @Steps
    AutoSearchSteps steps;

    @Before
    public void beforeMethod(){
        driver.manage().window().maximize();
    }

    public void signInAdminTestitTender(){
        steps.open_login_main_page();
        steps.click_button(logInButton);
        steps.type_login("AdminTestitTender");
        steps.type_password("Hyqpmaz0");
        steps.click_button(signInButton);
    }

    public void signInAdminTestitContract(){
        steps.open_login_main_page();
        steps.click_button(logInButton);
        steps.type_login("AdminTestitContract");
        steps.type_password("Hyqpmaz0");
        steps.click_button(signInButton);
    }

    public void signInAdminTestitPlan(){
        steps.open_login_main_page();
        steps.click_button(logInButton);
        steps.type_login("AdminTestitPlan");
        steps.type_password("Hyqpmaz0/");
        steps.click_button(signInButton);
    }


    @Test
    @Title("Проверка входа")
    public void checkSignIn(){

        signInAdminTestitTender();
        steps.check_text_login();
    }

    @Test
    @Title("Проверка результатов поиска для автопоиска 'Проверка поиска по реестровому номеру и региону'")
    public void checkRegistryNumber(){

        signInAdminTestitTender();
        steps.click_button(tabListAutoSearch);
        steps.scrollDownTo(listAutoSearchToScroll);
        steps.click_button(buttonAutoSearchRegistryNumberAndRegion);
        steps.wait_a_bit(2000);
        steps.check_number_result_search();
        steps.check_registry_number();
    }

    @Test
    @Title("Проверка увеличения количества результатов поиска при добавлении значения региона")
    public void checkNumberResultSearchAfterAddingRegionValue(){

        signInAdminTestitTender();
        steps.click_button(tabListAutoSearch);
        steps.wait_a_bit(500);
        steps.scroll_down_to(listAutoSearchToScroll);
        steps.click_button(buttonAutoSearchRegistryNumberAndRegion);
        steps.click_button(filterRegionRoot);
        steps.wait_a_bit(2000);
        steps.typeSearch("Москва");
        steps.wait_a_bit(2000);
        steps.clickButton(getCheckboxByNumber(3));
        steps.click_button(buttonApply);
        steps.click_button(buttonSearch);
        steps.wait_a_bit(2000);
        steps.check_registry_number_after_adding_region_value();
    }

    @Test
    @Title("Проверка названия тендера на включение в него ключевого слова")
    public void checkNameTenderToIncludeKeyword(){

        signInAdminTestitTender();
        steps.click_button(tabListAutoSearch);
        steps.scrollDownTo(listAutoSearchToScroll);
        steps.click_button(buttonCheckTenderNameAndNameDeletion);
        steps.wait_a_bit(2000);
        steps.check_name_tender_to_include_keyword();
    }

    @Test
    @Title("Проверка исключения из названия тендера ключевого слова")
    public void checkDeletionNameTenderToIncludeKeyword(){

        signInAdminTestitTender();
        steps.click_button(tabListAutoSearch);
        steps.scrollDownTo(listAutoSearchToScroll);
        steps.click_button(buttonCheckTenderNameAndNameDeletion);
        steps.wait_a_bit(2000);
        steps.click_button(filterNameTender);
        steps.typeDeletion("Мусоровоз");
        steps.click_button(openTabMenu);
        steps.click_button(buttonSearch);
        steps.wait_a_bit(2000);
        steps.check_deletion_name_tender_to_include_keyword();
    }

    @Test
    @Title("Проверка транслитерации при поиске по названию тендера")
    public void checkTransliterationNameTender(){

        signInAdminTestitTender();
        steps.click_button(tabListAutoSearch);
        steps.scrollDownTo(listAutoSearchToScroll);
        steps.click_button(buttonCheckTenderNameAndNameDeletion);
        steps.wait_a_bit(2000);
        steps.click_button(filterNameTender);
        steps.clear_field(fieldNameTender);
        steps.type_name_tender("Муcор");
        steps.click_button(checkBoxTransliteration);
        steps.click_button(openTabMenu);
        steps.click_button(buttonSearch);
        steps.wait_a_bit(2000);
        steps.check_name_tender_to_include_keyword();
    }

    @Test
    @Title("Проверка даты публикации тендера")
    public void checkPublicationDateOfTender() throws ParseException {

        signInAdminTestitTender();
        steps.click_button(tabListAutoSearch);
        steps.click_button(buttonCheckPublicationDate);
        steps.wait_a_bit(2000);
        steps.check_date("09.01.2021 00:00","09.01.2021 23:59");
    }

    @Test
    @Title("Проверка даты начала подачи заявок")
    public void checkStartSubmissionOfApplication() throws ParseException {

        signInAdminTestitTender();
        steps.click_button(tabListAutoSearch);
        steps.click_button(buttonCheckStartSubmissionOfApplicationDate);
        steps.wait_a_bit(2000);
        steps.check_date("04.01.2021 00:00","04.01.2021 23:59");
    }

    @Test
    @Title("Проверка даты окончания подачи заявок")
    public void checkEndSubmissionOfApplication() throws ParseException {

        signInAdminTestitTender();
        steps.click_button(tabListAutoSearch);
        steps.click_button(buttonCheckEndSubmissionOfApplicationDate);
//        steps.wait_a_bit(2000);
//        steps.click_button(filterEndSubmissionOfApplication);
//        steps.click_button(buttonClearFieldDateFrom);
//        steps.type_date_from("03.01.2021");
//        steps.click_button(buttonClearFieldDateTo);
//        steps.type_date_to("03.01.2021");
//        steps.click_button(openTabMenu);
//        steps.click_button(buttonSearch);
        steps.wait_a_bit(2000);
        steps.check_date("03.01.2021 00:00","03.01.2021 23:59");
    }

    @Test
    @Title("Проверка даты проведения тендера")
    public void checkValidateSearchByTenderDate() throws ParseException {

        signInAdminTestitTender();
        steps.click_button(tabListAutoSearch);
        steps.click_button(buttonValidateSearchByTenderDate);
        steps.wait_a_bit(2000);
        steps.check_date("12.01.2021 00:00","12.01.2021 23:59");
    }

    @Test
    @Title("Проверка поиска по категории")
    public void checkSearchByCategoryName(){

        signInAdminTestitTender();
        steps.click_button(tabListAutoSearch);
        steps.click_button(buttonValidateSearchByCategory);
        steps.wait_a_bit(2000);
        steps.check_category_name();
    }

    @Test
    @Title("Проверка цены тендера")
    public void checkPriceTender(){

        signInAdminTestitTender();
        steps.click_button(tabListAutoSearch);
        steps.click_button(buttonCheckSearchByPrice);
        steps.wait_a_bit(2000);
        steps.click_button(filterValidateSearchByTenderPrice);
        steps.clear_field(fieldPriceFrom);
        steps.type_price_from("10000");
        steps.clear_field(fieldPriceTo);
        steps.type_price_to("100000");
        steps.click_button(openTabMenu);
        steps.click_button(buttonSearch);
        steps.wait_a_bit(2000);
        steps.check_price(10000,100000);
    }

    @Test
    @Title("Проверка поиска по типу тендера")
    public void checkSearchByTenderType(){

        signInAdminTestitTender();
        steps.click_button(tabListAutoSearch);
        steps.click_button(buttonCheckSearchByTenderType);
        steps.wait_a_bit(2000);
        steps.check_search_by_tender_type();
    }

    @Test
    @Title("Проверка поиска по площадке")
    public void checkSearchByTenderStand(){

        signInAdminTestitTender();
        steps.click_button(tabListAutoSearch);
        steps.click_button(buttonCheckSearchByTenderStand);
        steps.wait_a_bit(2000);
        steps.check_search_by_tender_stand();
    }

    @Test
    @Title("Проверка поиска по модулю 'Государственные тендеры'")
    public void checkSearchOnlyGovernmentTenders(){

        signInAdminTestitTender();
        steps.click_button(tabListAutoSearch);
        steps.click_button(buttonCheckSearchByTenderModule);
        steps.wait_a_bit(2000);
        steps.check_search_by_only_government_tenders();
    }

    @Test
    @Title("Проверка поиска по модулям 'Государственные тендеры' и 'Коммерческие тендеры'")
    public void checkSearchOnlyGovernmentAndCommercialTenders(){

        signInAdminTestitTender();
        steps.click_button(tabListAutoSearch);
        steps.click_button(buttonCheckSearchByTenderModule);
        steps.click_button(filterSearchByTenderModule);
        steps.click_button(checkBoxFilter);
        steps.click_button(openTabMenu);
        steps.click_button(buttonSearch);
        steps.wait_a_bit(2000);
        steps.check_search_by_only_government_and_commercial_tenders();
    }

    @Test
    @Title("Проверка поиска по модулям 'Государственные тендеры' и 'Коммерческие тендеры' и 'СНГ'")
    public void checkSearchOnlyGovernmentAndCommercialAndCISTenders(){

        signInAdminTestitTender();
        steps.click_button(tabListAutoSearch);
        steps.click_button(buttonCheckSearchByTenderModule);
        steps.click_button(filterSearchByTenderModule);
        steps.click_button(checkBoxFilter);
        steps.click_button(checkBoxFilter);
        steps.click_button(openTabMenu);
        steps.click_button(buttonSearch);
        steps.wait_a_bit(2000);
        steps.check_search_by_only_government_and_commercial_and_cis_tenders();
    }

    @Test
    @Title("Проверка поиска по всем модулям")
    public void checkSearchAllModulesTender(){

        signInAdminTestitTender();
        steps.click_button(tabListAutoSearch);
        steps.click_button(buttonCheckSearchByTenderModule);
        steps.click_button(filterSearchByTenderModule);
        steps.click_button(checkBoxFilter);
        steps.click_button(checkBoxFilter);
        steps.click_button(checkBoxFilter);
        steps.click_button(openTabMenu);
        steps.click_button(buttonSearch);
        steps.wait_a_bit(2000);
        steps.check_search_by_all_modules_tender();
    }

    @Test
    @Title("Проверка поиска по участнику")
    public void checkSearchParticipant(){

        signInAdminTestitTender();
        steps.click_button(tabListAutoSearch);
        steps.click_button(buttonCheckSearchByParticipant);
        steps.wait_a_bit(2000);
        steps.check_search_by_participant();
    }

    @Test
    @Title("Проверка поиска по новым тендерам")
    public void checkSearchByNewTenders(){

        signInAdminTestitTender();
        steps.click_button(tabListAutoSearch);
        steps.click_button(buttonCheckSearchByMineTenders);
        steps.click_button(filterSearchByMineTendersOrContractsStatus);
        steps.click_button(getCheckboxInFilter(1));
        steps.click_button(openTabMenu);
        steps.click_button(buttonSearch);
        steps.wait_a_bit(3000);
        steps.check_search_by_new_tenders();
    }

    @Test
    @Title("Проверка поиска по подготовке заявки")
    public void checkSearchByApplicationPreparation(){

        signInAdminTestitTender();
        steps.click_button(tabListAutoSearch);
        steps.click_button(buttonCheckSearchByMineTenders);
        steps.click_button(filterSearchByMineTendersOrContractsStatus);
        steps.click_button(getCheckboxInFilter(2));
        steps.click_button(openTabMenu);
        steps.click_button(buttonSearch);
        steps.wait_a_bit(3000);
        steps.check_search_by_application_preparation();
    }

    @Test
    @Title("Проверка поиска по определению победителя")
    public void checkSearchByDeterminationWinner(){

        signInAdminTestitTender();
        steps.click_button(tabListAutoSearch);
        steps.click_button(buttonCheckSearchByMineTenders);
        steps.click_button(filterSearchByMineTendersOrContractsStatus);
        steps.click_button(getCheckboxInFilter(3));
        steps.click_button(openTabMenu);
        steps.click_button(buttonSearch);
        steps.wait_a_bit(3000);
        steps.check_search_by_determination_winner();
    }

    @Test
    @Title("Проверка поиска по заключению контракта")
    public void checkSearchByConclusionContract(){

        signInAdminTestitTender();
        steps.click_button(tabListAutoSearch);
        steps.click_button(buttonCheckSearchByMineTenders);
        steps.click_button(filterSearchByMineTendersOrContractsStatus);
        steps.click_button(getCheckboxInFilter(4));
        steps.click_button(openTabMenu);
        steps.click_button(buttonSearch);
        steps.wait_a_bit(3000);
        steps.check_search_by_conclusion_contract();
    }

    @Test
    @Title("Проверка поиска по исполнению контракта")
    public void checkSearchByExecutionContract(){

        signInAdminTestitTender();
        steps.click_button(tabListAutoSearch);
        steps.click_button(buttonCheckSearchByMineTenders);
        steps.click_button(filterSearchByMineTendersOrContractsStatus);
        steps.click_button(getCheckboxInFilter(5));
        steps.click_button(openTabMenu);
        steps.click_button(buttonSearch);
        steps.wait_a_bit(3000);
        steps.check_search_by_execution_contract();
    }

    @Test
    @Title("Проверка поиска по архиву")
    public void checkSearchByArchiveTenders(){

        signInAdminTestitTender();
        steps.click_button(tabListAutoSearch);
        steps.click_button(buttonCheckSearchByMineTenders);
        steps.click_button(filterSearchByMineTendersOrContractsStatus);
        steps.click_button(getCheckboxInFilter(6));
        steps.click_button(openTabMenu);
        steps.click_button(buttonSearch);
        steps.wait_a_bit(3000);
        steps.check_search_by_archive_tenders();
    }

    @Test
    @Title("Проверка поиска по всем тендерам фильтра 'Мои тендеры'")
    public void checkSearchByAllMineTenders(){

        signInAdminTestitTender();
        steps.click_button(tabListAutoSearch);
        steps.click_button(buttonCheckSearchByMineTenders);
        steps.click_button(filterSearchByMineTendersOrContractsStatus);
        steps.click_button(getCheckboxInFilter(0));
        steps.click_button(openTabMenu);
        steps.click_button(buttonSearch);
        steps.wait_a_bit(3000);
        steps.check_search_by_all_mine_tenders();
    }

    @Test
    @Title("Проверка поиска по документации")
    public void checkSearchByTextDocumentation(){

        signInAdminTestitTender();
        steps.click_button(tabListAutoSearch);
        steps.click_button(buttonCheckSearchByDocumentation);
        steps.wait_a_bit(1000);
        steps.click_button(buttonSearch);
        steps.wait_a_bit(1000);
        steps.click_button(cellTableToOpenDocumentation);
        steps.wait_a_bit(1000);
        steps.switch_to_tab();
        steps.check_text_documentation();
    }

    @Test
    @Title("Проверка поиска по извещению")
    public void checkSearchByTextNotice(){

        signInAdminTestitTender();
        steps.click_button(tabListAutoSearch);
        steps.click_button(buttonCheckSearchByNotice);
        steps.wait_a_bit(2000);
        steps.click_button(cellTableToOpenDocumentationNotice);
        steps.wait_a_bit(1000);
        steps.switch_to_tab();
        steps.check_text_notice();
    }

    @Test
    @Title("Проверка поиска в блоке списка фильтров")
    public void checkSearchInListTenders(){

        signInAdminTestitTender();
        steps.type_search_filters("Название тендера");
        steps.check_search_in_list_tenders();
    }

    @Test
    @Title("Проверка результата поиска контракта по продуктам")
    public void checkSearchContractByProduct(){

        signInAdminTestitContract();
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

        signInAdminTestitContract();
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

        signInAdminTestitContract();
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

        signInAdminTestitContract();
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

        signInAdminTestitContract();
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

        signInAdminTestitContract();
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

        signInAdminTestitContract();
        steps.click_button(tabListAutoSearch);
        steps.click_button(buttonValidateSearchByContractExecutionStartDate);
        steps.wait_a_bit(2000);
        steps.check_date("13.01.2021 00:00","14.01.2021 23:59");
    }

    @Test
    @Title("Проверка даты окончания исполнения контракта")
    public void checkContractExecutionEndDate() throws ParseException {

        signInAdminTestitContract();
        steps.click_button(tabListAutoSearch);
        steps.click_button(buttonValidateSearchByContractExecutionEndDate);
        steps.wait_a_bit(2000);
        steps.check_date("13.01.2021 00:00","14.01.2021 23:59");
    }

    @Test
    @Title("Проверка фактической даты исполнения контракта")
    public void checkContractActualExecutionDate() throws ParseException {

        signInAdminTestitContract();
        steps.click_button(tabListAutoSearch);
        steps.click_button(buttonValidateSearchByContractActualExecutionDate);
        steps.wait_a_bit(2000);
        steps.check_date("13.01.2021 00:00","14.01.2021 23:59");
    }

    @Test
    @Title("Проверка даты подписания контракта")
    public void checkContractDateOfSigning() throws ParseException {

        signInAdminTestitContract();
        steps.click_button(tabListAutoSearch);
        steps.click_button(buttonValidateSearchByContractDateOfSigning);
        steps.wait_a_bit(2000);
        steps.check_date("13.01.2021 00:00","14.01.2021 23:59");
    }

    @Test
    @Title("Проверка поиска по штрафу 'Просрочка исполнения поставщиком'")
    public void checkSearchByDelayInPerformanceBySupplier(){

        signInAdminTestitContract();
        steps.click_button(tabListAutoSearch);
        steps.click_button(buttonCheckSearchByMulct);
        steps.wait_a_bit(2000);
        steps.click_button(filterSearchByMulct);
        steps.click_button(getCheckboxInFilter(0));
        steps.click_button(openTabMenu);
        steps.click_button(buttonSearch);
        steps.wait_a_bit(1000);
        steps.double_click_button(tableCellToCheck);
        steps.wait_a_bit(1000);
        steps.switch_to_tab();
        steps.click_button(tabMulctContracts);
        steps.check_search_delay_in_performance_by_supplier();
    }

    @Test
    @Title("Проверка поиска по штрафу 'Просрочка исполнения заказчиком обязательств'")
    public void checkSearchByDelayInFulfillmentOfObligationsByCustomer(){

        signInAdminTestitContract();
        steps.click_button(tabListAutoSearch);
        steps.click_button(buttonCheckSearchByMulct);
        steps.wait_a_bit(2000);
        steps.click_button(filterSearchByMulct);
        steps.click_button(getCheckboxInFilter(1));
        steps.click_button(openTabMenu);
        steps.click_button(buttonSearch);
        steps.wait_a_bit(1000);
        steps.double_click_button(tableCellToCheck);
        steps.wait_a_bit(1000);
        steps.switch_to_tab();
        steps.click_button(tabMulctContracts);
        steps.check_search_delay_in_fulfillment_of_obligations_by_customer();
    }

    @Test
    @Title("Проверка поиска по штрафу 'Ненадлежащее исполнение поставщиком'")
    public void checkSearchByInadequateExecutionBySupplier(){

        signInAdminTestitContract();
        steps.click_button(tabListAutoSearch);
        steps.click_button(buttonCheckSearchByMulct);
        steps.wait_a_bit(2000);
        steps.click_button(filterSearchByMulct);
        steps.click_button(getCheckboxInFilter(2));
        steps.click_button(openTabMenu);
        steps.click_button(buttonSearch);
        steps.wait_a_bit(1000);
        steps.double_click_button(tableCellToCheck);
        steps.wait_a_bit(1000);
        steps.switch_to_tab();
        steps.click_button(tabMulctContracts);
        steps.check_search_inadequate_execution_by_supplier();
    }

    @Test
    @Title("Проверка поиска по штрафу 'Ненадлежащее исполнение заказчиком обязательств'")
    public void checkSearchByInadequateExecutionByCustomer(){

        signInAdminTestitContract();
        steps.click_button(tabListAutoSearch);
        steps.click_button(buttonCheckSearchByMulct);
        steps.wait_a_bit(2000);
        steps.click_button(filterSearchByMulct);
        steps.click_button(getCheckboxInFilter(3));
        steps.click_button(openTabMenu);
        steps.click_button(buttonSearch);
        steps.wait_a_bit(1000);
        steps.double_click_button(tableCellToCheck);
        steps.wait_a_bit(1000);
        steps.switch_to_tab();
        steps.click_button(tabMulctContracts);
        steps.check_search_inadequate_execution_by_customer();
    }

    @Test
    @Title("Проверка суммы штрафов контракта")
    public void checkSumMulctContract(){

        signInAdminTestitContract();
        steps.click_button(tabListAutoSearch);
        steps.click_button(buttonCheckSearchBySumMulct);
        steps.click_button(buttonSearch);
        steps.wait_a_bit(2000);
        steps.double_click_button(tableCellToCheck);
        steps.switchToTab();
        steps.click_button(tabMulctContracts);
        steps.check_sum_mulct(10000,100000);
    }

    @Test
    @Title("Проверка наличия неоплаченных  штрафов контракта")
    public void checkUnpaidMulctContract(){

        signInAdminTestitContract();
        steps.click_button(tabListAutoSearch);
        steps.click_button(buttonCheckSearchByUnpaidMulct);
        steps.wait_a_bit(2000);
        steps.click_button(filterSearchByUnpaidMulct);
        steps.click_button(radiobuttonYesUnpaidMulct);
        steps.click_button(openTabMenu);
        steps.click_button(buttonSearch);
        steps.wait_a_bit(1000);
        steps.double_click_button(tableCellToCheck);
        steps.switchToTab();
        steps.click_button(tabMulctContracts);
        steps.check_unpaid_mulct();
    }

    @Test
    @Title("Проверка отсутствия неоплаченных штрафов контракта")
    public void checkPaidMulctContract(){

        signInAdminTestitContract();
        steps.click_button(tabListAutoSearch);
        steps.click_button(buttonCheckSearchByUnpaidMulct);
        steps.wait_a_bit(2000);
        steps.click_button(filterSearchByUnpaidMulct);
        steps.click_button(radiobuttonNoUnpaidMulct);
        steps.click_button(openTabMenu);
        steps.click_button(buttonSearch);
        steps.wait_a_bit(1000);
        steps.double_click_button(tableCellToCheck);
        steps.switchToTab();
        steps.click_button(tabMulctContracts);
        steps.check_paid_mulct();
    }

    @Test
    @Title("Проверка результатов поиска планов по названию")
    public void checkSearchByNamePlan(){

        signInAdminTestitPlan();
        steps.click_button(tabListAutoSearch);
        steps.click_button(buttonCheckSearchByNamePlan);
        steps.wait_a_bit(1000);
        steps.check_search_by_name_plan();
    }

    @Test
    @Title("Проверка поиска по типу плана")
    public void checkSearchByTypePlan(){

        signInAdminTestitPlan();
        steps.click_button(tabListAutoSearch);
        steps.click_button(buttonCheckSearchByTypePlan);
        steps.wait_a_bit(2000);
        steps.click_button(filterSearchByTypePlan);
        steps.click_button(getCheckboxInFilter(0));
        steps.click_button(openTabMenu);
        steps.click_button(buttonSearch);
        steps.check_search_by_type_plan();
    }

    @Test
    @Title("Проверка поиска по типу плана")
    public void checkSearchByTypePlanSchedule(){

        signInAdminTestitPlan();
        steps.click_button(tabListAutoSearch);
        steps.click_button(buttonCheckSearchByTypePlan);
        steps.wait_a_bit(2000);
        steps.click_button(filterSearchByTypePlan);
        steps.click_button(getCheckboxInFilter(1));
        steps.click_button(openTabMenu);
        steps.click_button(buttonSearch);
        steps.check_search_by_type_plan_schedule();
    }

    @Test
    @Title("Проверка поиска по типу плана")
    public void checkSearchByTypePlanSchedule2017(){

        signInAdminTestitPlan();
        steps.click_button(tabListAutoSearch);
        steps.click_button(buttonCheckSearchByTypePlan);
        steps.wait_a_bit(2000);
        steps.click_button(filterSearchByTypePlan);
        steps.click_button(getCheckboxInFilter(1));
        steps.click_button(openTabMenu);
        steps.click_button(buttonSearch);
        steps.check_search_by_type_plan_schedule_2017();
    }



}
