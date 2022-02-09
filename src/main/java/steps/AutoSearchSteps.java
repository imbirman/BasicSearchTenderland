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
}
