package steps;

import net.serenitybdd.core.pages.WebElementFacade;
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

    @Step("Двойной клик")
    public void double_click_button(By button){
        page.doubleClickButton(button);
    }

    @Step("Переключиться на следующую вкладку")
    public void switch_to_tab(){
        page.switchToTab();
    }

    @Step("Прокрутить содержимое элемента вниз")
    public void scroll_down_to(By scroll){
        page.scrollDownTo(scroll);
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
                .as("Есть тендеры с ценой, не входящей в заданный промежуток: " + priceFrom + " - " + priceTo).isTrue();
    }

    @Step("Проверка поиска по типу тендера")
    public void check_search_by_tender_type(){
        Assertions.assertThat(page.isContainTenderType()).as("Минимум у одного тендера указан неправильный тип").isTrue();
    }

    @Step("Проверка поиска по типу тендера")
    public void check_search_by_tender_stand(){
        Assertions.assertThat(page.isContainTenderStand()).as("Минимум у одного тендера указана неправильная площадка").isTrue();
    }

    @Step("Проверка поиска по модулю 'Государственные тендеры'")
    public void check_search_by_only_government_tenders(){
        Assertions.assertThat(page.isContainOnlyGovernmentTenders()).as("Минимум у одного тендера указан модуль не 'Государственные тендеры'").isTrue();
    }

    @Step("Проверка поиска по модулям 'Государственные тендеры' и 'Коммерческие тендеры'")
    public void check_search_by_only_government_and_commercial_tenders(){
        Assertions.assertThat(page.isContainOnlyGovernmentAndCommercialTenders())
                .as("Минимум у одного тендера указан модуль не 'Государственные тендеры' и не 'Коммерческие тендеры'").isTrue();
    }

    @Step("Проверка поиска по модулям 'Государственные тендеры' и 'Коммерческие тендеры' и 'СНГ'")
    public void check_search_by_only_government_and_commercial_and_cis_tenders(){
        Assertions.assertThat(page.isContainOnlyGovernmentAndCommercialAndCISTenders())
                .as("Минимум у одного тендера указан модуль не 'Государственные тендеры' и не 'Коммерческие тендеры' и не 'СНГ'").isTrue();
    }

    @Step("Проверка поиска по всем модулям")
    public void check_search_by_all_modules_tender(){
        Assertions.assertThat(page.isContainAllModulesTenders())
                .as("Минимум у одного тендера указан модуль не входящий в список модулей").isTrue();
    }

    @Step("Проверка поиска по участнику")
    public void check_search_by_participant(){
        Assertions.assertThat(page.isContainParticipant())
                .as("Минимум у одного тендера отсутствует выбранный участник").isTrue();
    }

    @Step("Проверка поиска по новым тендерам")
    public void check_search_by_new_tenders(){
        Assertions.assertThat(page.isContainNewTenders())
                .as("В списке отсутствует тендер 400022118701, находящийся во вкладке 'Новые тендеры'").isTrue();
    }

    @Step("Проверка поиска по подготовке заявки")
    public void check_search_by_application_preparation(){
        Assertions.assertThat(page.isContainApplicationPreparation())
                .as("В списке отсутствует тендер 0130300010421000001, находящийся во вкладке 'Подготовка заявки'").isTrue();
    }

    @Step("Проверка поиска по определению победителя")
    public void check_search_by_determination_winner(){
        Assertions.assertThat(page.isContainDeterminationOfWinner())
                .as("В списке отсутствует тендер 8976791, находящийся во вкладке 'Определения победителя'").isTrue();
    }

    @Step("Проверка поиска по заключению контракта")
    public void check_search_by_conclusion_contract(){
        Assertions.assertThat(page.isContainConclusionOfContract())
                .as("В списке отсутствует тендер 0126200000421000268, находящийся во вкладке 'Заключение контракта'").isTrue();
    }

    @Step("Проверка поиска по исполнению контракта")
    public void check_search_by_execution_contract(){
        Assertions.assertThat(page.isContainExecutionOfContract())
                .as("В списке отсутствует тендер 0306200004521000009, находящийся во вкладке 'Исполнение контракта'").isTrue();
    }

    @Step("Проверка поиска по архиву")
    public void check_search_by_archive_tenders(){
        Assertions.assertThat(page.isContainArchiveTenders())
                .as("В списке отсутствует тендер 0848300064121000009, находящийся во вкладке 'Архив'").isTrue();
    }

    @Step("Проверка поиска по архиву")
    public void check_search_by_all_mine_tenders(){
        Assertions.assertThat(page.isContainAllMineTenders())
                .as("В списке присутствует тендер, не входящий в мои тендеры").isTrue();
    }

    @Step("Проверка поиска по документации")
    public void check_text_documentation() {
        Assertions.assertThat(page.isContainSearchDocumentation())
                .as("В документации отсутствует поисковое слово").isTrue();
    }

    @Step("Проверка поиска по извещению")
    public void check_text_notice() {
        Assertions.assertThat(page.isContainSearchWordIntoNoticeDocumentation())
                .as("В извещении отсутствует поисковое слово").isTrue();
    }

    @Step("Проверка поиска в блоке фильтров")
    public void check_search_in_list_tenders() {
        Assertions.assertThat(page.isContainFiltersFromSearchField())
                .as("В результатах поиска фильтров отсутствует заданное значение").isTrue();
    }

    @Step("Проверка результата поиска контракта по продуктам")
    public void check_search_contract_by_product() {
        Assertions.assertThat(page.isContainCardContractSearchWord())
                .as("В результатах поиска контракта по продуктам отсутствует заданное значение").isTrue();
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
                .as("Есть контракты с суммой штрафов, не входящей в заданный промежуток: " + sumMulctFrom + " - " + sumMulctTo).isTrue();
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
        Assertions.assertThat(page.isContainTypePlanSchedule())
                .as("В результатах поиска есть тип плана отличный от 'План-график 2017'").isTrue();
    }


}
