package testpackage;


import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import pages.TabTenders;
import steps.TabTendersSteps;

import java.text.ParseException;

@RunWith(SerenityRunner.class)
public class WhenTabTendersTest extends TabTenders {

    @Managed(driver = "chrome", uniqueSession=true)
    WebDriver driver;

    @Steps
    TabTendersSteps steps;

    @Before
    public void beforeMethod(){
        driver.manage().window().maximize();
        steps.open_login_main_page();
        steps.click_button(logInButton);
        steps.type_login("AdminTestitTender");
        steps.type_password("Hyqpmaz0");
        steps.click_button(signInButton);
    }



    @Test
    @Title("Проверка результатов поиска для автопоиска 'Проверка поиска по реестровому номеру и региону'")
    public void checkRegistryNumber(){

        steps.click_button(tabListAutoSearch);
        steps.click_button(buttonAutoSearchRegistryNumberAndRegion);
        steps.wait_a_bit(2000);
        steps.check_number_result_search();
        steps.check_registry_number();
    }

    @Test
    @Title("Проверка увеличения количества результатов поиска при добавлении значения региона")
    public void checkNumberResultSearchAfterAddingRegionValue(){

        steps.click_button(tabListAutoSearch);
        steps.wait_a_bit(500);
        steps.click_button(buttonAutoSearchRegistryNumberAndRegion);
        steps.click_button(filterRegionRoot);
        steps.wait_a_bit(2000);
        steps.type_search("Москва");
        steps.wait_a_bit(2000);
        //steps.type_deletion(getCheckboxByNumber(3));
        steps.click_button(getCheckboxInFilterRegion(3));
        steps.click_button(buttonApply);
        steps.click_button(buttonSearch);
        steps.wait_a_bit(2000);
        steps.check_registry_number_after_adding_region_value();
    }

    @Test
    @Title("Проверка названия тендера на включение в него ключевого слова")
    public void checkNameTenderToIncludeKeyword(){

        steps.click_button(tabListAutoSearch);
        steps.click_button(buttonCheckTenderNameAndNameDeletion);
        steps.wait_a_bit(2000);
        steps.check_name_tender_to_include_keyword();
    }

    @Test
    @Title("Проверка исключения из названия тендера ключевого слова")
    public void checkDeletionNameTenderToIncludeKeyword(){

        steps.click_button(tabListAutoSearch);
        steps.click_button(buttonCheckTenderNameAndNameDeletion);
        steps.wait_a_bit(2000);
        steps.scroll_window_on_pixels("-500");
        steps.click_button(filterNameTender);
        steps.type_deletion("Мусоровоз");
        steps.click_button(buttonSearch);
        steps.wait_a_bit(2000);
        steps.check_deletion_name_tender_to_include_keyword();
    }

    @Test
    @Title("Проверка транслитерации при поиске по названию тендера")
    public void checkTransliterationNameTender(){

        steps.click_button(tabListAutoSearch);
        steps.click_button(buttonCheckTenderNameAndNameDeletion);
        steps.wait_a_bit(2000);
        steps.scroll_window_on_pixels("-500");
        steps.click_button(filterNameTender);
        steps.clear_field(fieldNameTender);
        steps.type_name_tender("Муcор");
        steps.click_button(checkBoxTransliteration);
        steps.click_button(buttonSearch);
        steps.wait_a_bit(2000);
        steps.check_name_tender_to_include_keyword();
    }

    @Test
    @Title("Проверка даты публикации тендера")
    public void checkPublicationDateOfTender() throws ParseException {

        steps.click_button(tabListAutoSearch);
        steps.click_button(buttonCheckPublicationDate);
        steps.wait_a_bit(2000);
        steps.check_date("09.01.2021 00:00","09.01.2021 23:59");
    }

    @Test
    @Title("Проверка даты публикации тендера только с начальной датой")
    public void checkPublicationDateOfTenderWithOnlyStartDate() throws ParseException {

        steps.click_button(tabListAutoSearch);
        steps.scroll_element_on_pixels("500", listAutoSearchToScroll);
        steps.click_button(buttonCheckPublicationDateWithOnlyStartDate);
        steps.wait_a_bit(2000);
        steps.check_date_with_only_start_date("09.01.2021 00:00");
    }

    @Test
    @Title("Проверка даты публикации тендера только с конечной датой")
    public void checkPublicationDateOfTenderWithOnlyEndDate() throws ParseException {

        steps.click_button(tabListAutoSearch);
        steps.scroll_element_on_pixels("500", listAutoSearchToScroll);
        steps.click_button(buttonCheckPublicationDateWithOnlyEndDate);
        steps.wait_a_bit(2000);
        steps.check_date_with_only_end_date("09.01.2021 00:00");
    }

    @Test
    @Title("Проверка поиска по дате начала подачи заявок")
    public void checkDateStartSubmissionOfApplication() throws ParseException {

        steps.click_button(tabListAutoSearch);
        steps.click_button(buttonCheckStartSubmissionOfApplicationDate);
        steps.wait_a_bit(2000);
        steps.check_date("04.01.2021 00:00","04.01.2021 23:59");
    }

    @Test
    @Title("Проверка поиска по дате окончания подачи заявок")
    public void checkDateEndSubmissionOfApplication() throws ParseException {

        steps.click_button(tabListAutoSearch);
        steps.click_button(buttonCheckEndSubmissionOfApplicationDate);
        steps.wait_a_bit(2000);
        steps.check_date("03.01.2021 00:00","03.01.2021 23:59");
    }

    @Test
    @Title("Проверка поиска по дате проведения тендера")
    public void checkDateValidateSearchByTenderDate() throws ParseException {

        steps.click_button(tabListAutoSearch);
        steps.click_button(buttonValidateSearchByTenderDate);
        steps.wait_a_bit(2000);
        steps.check_date("12.01.2021 00:00","12.01.2021 23:59");
    }

    @Test
    @Title("Проверка поиска по категории")
    public void checkSearchByCategoryName(){

        steps.click_button(tabListAutoSearch);
        steps.click_button(buttonValidateSearchByCategory);
        steps.wait_a_bit(2000);
        steps.check_category_name();
    }

    @Test
    @Title("Проверка цены тендера")
    public void checkPriceTender(){

        steps.click_button(tabListAutoSearch);
        steps.click_button(buttonCheckSearchByPrice);
        steps.wait_a_bit(2000);
        steps.scroll_element_on_pixels("-500", listAutoSearchToScroll);
        steps.click_button(filterValidateSearchByTenderPrice);
        steps.clear_field(fieldPriceFrom);
        steps.type_price_from("10000");
        steps.clear_field(fieldPriceTo);
        steps.type_price_to("100000");
        steps.click_button(buttonSearch);
        steps.wait_a_bit(2000);
        steps.check_price(10000,100000);
    }

    @Test
    @Title("Проверка поиска по типу тендера")
    public void checkSearchByTenderType(){

        steps.click_button(tabListAutoSearch);
        steps.scroll_element_on_pixels("100", listAutoSearchToScroll);
        steps.click_button(buttonCheckSearchByTenderType);
        steps.wait_a_bit(2000);
        steps.check_search_by_tender_type();
    }

    @Test
    @Title("Проверка поиска по площадке")
    public void checkSearchByTenderStand(){

        steps.click_button(tabListAutoSearch);
        steps.scroll_element_on_pixels("200", listAutoSearchToScroll);
        steps.click_button(buttonCheckSearchByTenderStand);
        steps.wait_a_bit(2000);
        steps.check_search_by_tender_stand();
    }

    @Test
    @Title("Проверка поиска по модулю 'Государственные тендеры'")
    public void checkSearchOnlyGovernmentTenders(){

        steps.click_button(tabListAutoSearch);
        steps.scroll_element_on_pixels("200", listAutoSearchToScroll);
        steps.click_button(buttonCheckSearchByTenderModule);
        steps.wait_a_bit(2000);
        steps.check_search_by_only_government_tenders();
    }

    @Test
    @Title("Проверка поиска по модулям 'Государственные тендеры' и 'Коммерческие тендеры'")
    public void checkSearchOnlyGovernmentAndCommercialTenders(){

        steps.click_button(tabListAutoSearch);
        steps.scroll_element_on_pixels("200", listAutoSearchToScroll);
        steps.click_button(buttonCheckSearchByTenderModule);
        steps.click_button(filterSearchByTenderModule);
        steps.click_button(checkBoxFilter);
        steps.click_button(buttonSearch);
        steps.wait_a_bit(2000);
        steps.check_search_by_only_government_and_commercial_tenders();
    }

    @Test
    @Title("Проверка поиска по модулям 'Государственные тендеры' и 'Коммерческие тендеры' и 'СНГ'")
    public void checkSearchOnlyGovernmentAndCommercialAndCISTenders(){

        steps.click_button(tabListAutoSearch);
        steps.scroll_element_on_pixels("200", listAutoSearchToScroll);
        steps.click_button(buttonCheckSearchByTenderModule);
        steps.click_button(filterSearchByTenderModule);
        steps.click_button(checkBoxFilter);
        steps.click_button(checkBoxFilter);
        steps.click_button(buttonSearch);
        steps.wait_a_bit(2000);
        steps.check_search_by_only_government_and_commercial_and_cis_tenders();
    }

    @Test
    @Title("Проверка поиска по всем модулям")
    public void checkSearchAllModulesTender(){

        steps.click_button(tabListAutoSearch);
        steps.scroll_element_on_pixels("200", listAutoSearchToScroll);
        steps.click_button(buttonCheckSearchByTenderModule);
        steps.click_button(filterSearchByTenderModule);
        steps.click_button(checkBoxFilter);
        steps.click_button(checkBoxFilter);
        steps.click_button(checkBoxFilter);
        steps.click_button(buttonSearch);
        steps.wait_a_bit(2000);
        steps.check_search_by_all_modules_tender();
    }

    @Test
    @Title("Проверка поиска по участнику")
    public void checkSearchParticipant(){

        steps.click_button(tabListAutoSearch);
        steps.scroll_element_on_pixels("250", listAutoSearchToScroll);
        steps.click_button(buttonCheckSearchByParticipant);
        steps.wait_a_bit(2000);
        steps.check_search_by_participant();
    }

    @Test
    @Title("Проверка поиска по новым тендерам")
    public void checkSearchByNewTenders(){

        steps.click_button(tabListAutoSearch);
        steps.scroll_element_on_pixels("250", listAutoSearchToScroll);
        steps.click_button(buttonCheckSearchByMineTenders);
        steps.click_button(filterSearchByMineTendersOrContractsStatus);
        steps.click_button(getCheckboxInFilter(0));
        steps.click_button(buttonSearch);
        steps.wait_a_bit(3000);
        steps.check_search_by_new_tenders();
    }

    @Test
    @Title("Проверка поиска по подготовке заявки")
    public void checkSearchByApplicationPreparation(){

        steps.click_button(tabListAutoSearch);
        steps.scroll_element_on_pixels("250", listAutoSearchToScroll);
        steps.click_button(buttonCheckSearchByMineTenders);
        steps.click_button(filterSearchByMineTendersOrContractsStatus);
        steps.click_button(getCheckboxInFilter(1));
        steps.click_button(buttonSearch);
        steps.wait_a_bit(3000);
        steps.check_search_by_application_preparation();
    }

    @Test
    @Title("Проверка поиска по определению победителя")
    public void checkSearchByDeterminationWinner(){

        steps.click_button(tabListAutoSearch);
        steps.scroll_element_on_pixels("250", listAutoSearchToScroll);
        steps.click_button(buttonCheckSearchByMineTenders);
        steps.click_button(filterSearchByMineTendersOrContractsStatus);
        steps.click_button(getCheckboxInFilter(2));
        steps.click_button(buttonSearch);
        steps.wait_a_bit(3000);
        steps.check_search_by_determination_winner();
    }

    @Test
    @Title("Проверка поиска по заключению контракта")
    public void checkSearchByConclusionContract(){

        steps.click_button(tabListAutoSearch);
        steps.scroll_element_on_pixels("250", listAutoSearchToScroll);
        steps.click_button(buttonCheckSearchByMineTenders);
        steps.click_button(filterSearchByMineTendersOrContractsStatus);
        steps.click_button(getCheckboxInFilter(3));
        steps.click_button(buttonSearch);
        steps.wait_a_bit(3000);
        steps.check_search_by_conclusion_contract();
    }

    @Test
    @Title("Проверка поиска по исполнению контракта")
    public void checkSearchByExecutionContract(){

        steps.click_button(tabListAutoSearch);
        steps.scroll_element_on_pixels("250", listAutoSearchToScroll);
        steps.click_button(buttonCheckSearchByMineTenders);
        steps.click_button(filterSearchByMineTendersOrContractsStatus);
        steps.click_button(getCheckboxInFilter(4));
        steps.click_button(buttonSearch);
        steps.wait_a_bit(3000);
        steps.check_search_by_execution_contract();
    }

    @Test
    @Title("Проверка поиска по архиву")
    public void checkSearchByArchiveTenders(){

        steps.click_button(tabListAutoSearch);
        steps.scroll_element_on_pixels("250", listAutoSearchToScroll);
        steps.click_button(buttonCheckSearchByMineTenders);
        steps.click_button(filterSearchByMineTendersOrContractsStatus);
        steps.click_button(getCheckboxInFilter(5));
        steps.click_button(buttonSearch);
        steps.wait_a_bit(3000);
        steps.check_search_by_archive_tenders();
    }

    @Test
    @Title("Проверка поиска по всем тендерам фильтра 'Мои тендеры'")
    public void checkSearchByAllMineTenders(){

        steps.click_button(tabListAutoSearch);
        steps.scroll_element_on_pixels("250", listAutoSearchToScroll);
        steps.click_button(buttonCheckSearchByMineTenders);
        steps.click_button(filterSearchByMineTendersOrContractsStatus);
        steps.click_button(checkboxSelectAllMyTenders);
        steps.click_button(buttonSearch);
        steps.wait_a_bit(3000);
        steps.check_search_by_all_mine_tenders();
    }

    @Test
    @Title("Проверка поиска по документации")
    public void checkSearchByTextDocumentation(){

        steps.click_button(tabListAutoSearch);
        steps.scroll_element_on_pixels("250", listAutoSearchToScroll);
        steps.click_button(buttonCheckSearchByDocumentation);
        steps.wait_a_bit(1000);
        steps.click_button(cellTableToOpenDocumentation);
        steps.wait_a_bit(1000);
        steps.switch_to_tab();
        steps.check_text_documentation();
    }

    @Test
    @Title("Проверка поиска по извещению")
    public void checkSearchByTextNotice(){

        steps.click_button(tabListAutoSearch);
        steps.scroll_element_on_pixels("300", listAutoSearchToScroll);
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

        steps.type_search_filters("Название тендера");
        steps.check_search_in_list_tenders();
    }




    @Test
    @Title("Проверка результата поиска после скрытия фильтра 'Регион'")
    public void checkSearchWithHideFilter(){
        steps.click_button(tabListAutoSearch);
        steps.click_button(buttonAutoSearchRegistryNumberAndRegion);
        steps.click_button(buttonHideFilter);
        steps.click_button(buttonSearch);
        steps.check_search_with_hide_filter();
    }

    @Test
    @Title("Проверка метки тендера")
    public void checkMarkOfTender(){
        steps.click_button(tabListAutoSearch);
        steps.click_button(buttonAutoSearchRegistryNumberAndRegion);
        steps.click_button(contextMenuResultSearch);
        steps.move_to_element(markContextMenu);
        steps.click_button(redMarkContextMenu);
        steps.check_mark_of_tender();
    }

    @Test
    @Title("Проверка удаления метки тендера")
    public void checkDeletionMarkOfTender(){
        steps.click_button(tabListAutoSearch);
        steps.click_button(buttonAutoSearchRegistryNumberAndRegion);
        steps.click_button(contextMenuResultSearch);
        steps.move_to_element(markContextMenu);
        steps.click_button(redMarkContextMenu);
        steps.click_button(contextMenuResultSearch);
        steps.move_to_element(markContextMenu);
        steps.click_button(deleteMark);
        steps.check_deletion_mark_of_tender();
    }

    @Test
    @Title("Проверка на пустое поле даты публикации до")
    public void checkEmptyFieldPublicationDateTo(){
        steps.scroll_element_on_pixels("150", listFilters);
        steps.drag_and_drop_filter(filterDatePublication);
        steps.type_date_from("01.01.2021");
        steps.type_date_to("31.12.2020");
        steps.click_button(filterInTreeFilters);
        steps.check_empty_publication_date_to();
    }

    @Test
    @Title("Проверка количества выбранных подкатегорий фильтра 'Категория' с закрытой главной категорией")
    public void checkNumberSelectedCategoriesWithCloseMainCategory(){
        steps.drag_and_drop_filter(filterCategory);
        steps.click_button(checkboxFirstInFilter);
        steps.click_button(buttonOpenTreeList);
        steps.check_number_selected_categories_with_close_main_category();
    }

    @Test
    @Title("Проверка количества выбранных подкатегорий фильтра 'Категория' с открытой главной категорией")
    public void checkNumberSelectedCategoriesWithOpenMainCategory(){
        steps.drag_and_drop_filter(filterCategory);
        steps.click_button(buttonOpenTreeList);
        steps.click_button(checkboxFirstInFilter);
        steps.check_number_selected_categories_with_open_main_category();
    }

    @Test
    @Title("Проверка выбранных подкатегорий фильтра 'Категория'")
    public void checkContainSelectedCategory(){
        steps.drag_and_drop_filter(filterCategory);
        steps.click_button(checkboxFirstInFilter);
        steps.click_button(buttonOpenTreeList);
        steps.check_contain_selected_category();
    }

    @Test
    @Title("Проверка исключения из фильтра Заказчик")
    public void checkExcludedFromFilterCustomer(){
        steps.click_button(tabListAutoSearch);
        steps.click_button(excludedElementCustomer);
        steps.check_excluded_from_filter_customer();
    }
}
