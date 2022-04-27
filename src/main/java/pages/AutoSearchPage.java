package pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@DefaultUrl("https://test1.v2.tenderland.ru/Home/Landing")
public class AutoSearchPage extends PageObject {


    protected By openTabMenu = By.id("tl-main-nav"); // Кнопка открытия бокового меню
    protected By logInButton = By.xpath("//span[text()='Войти']"); // Кнопка входа в систему
    protected By signInButton = By.xpath("//span[text()='Войти в систему']"); // Кнопка "Войти в систему"
    protected By tabListAutoSearch = By.id("tab-list-autosearches"); // Вкладка "Автопоиски"
    protected By buttonAutoSearchRegistryNumberAndRegion = By.xpath("//span[text()='Проверка поиска по реестровому номеру и региону']"); // Кнопка автопоиска "Проверка поиска по реестровому номеру и региону"
    protected By buttonCheckTenderNameAndNameDeletion = By.xpath("//span[text()='Проверка поиска по названию тендера и исключению из названия']"); // Кнопка автопоиска "Проверка по названию тендера и исключению из названия"
    protected By buttonCheckPublicationDate = By.xpath("//span[text()='Проверка поиска по дате публикации']"); // Кнопка автопоиска "Проверка поиска по дате публикации"
    protected By buttonCheckStartSubmissionOfApplicationDate = By.xpath("//span[text()='Проверка поиска по дате начала подачи заявок']"); // Кнопка автопоиска "Проверка поиска по дате начала подачи заявок"
    protected By buttonCheckEndSubmissionOfApplicationDate = By.xpath("//span[text()='Проверка поиска по дате окончания подачи заявок']"); // Кнопка автопоиска "Проверка поиска по дате окончания подачи заявок"
    protected By buttonValidateSearchByTenderDate = By.xpath("//span[text()='Проверка поиска по дате проведения тендера']"); // Кнопка автопоиска "Проверка поиска по дате проведения тендера"
    protected By buttonValidateSearchByContractExecutionStartDate = By.xpath("//span[text()='Проверка поиска по дате начала исполнения']"); // Кнопка автопоиска "Проверка поиска по дате начала исполнения"
    protected By buttonValidateSearchByContractExecutionEndDate = By.xpath("//span[text()='Проверка поиска по дате окончания исполнения']"); // Кнопка автопоиска "Проверка поиска по дате окончания исполнения"
    protected By buttonValidateSearchByContractActualExecutionDate = By.xpath("//span[text()='Проверка поиска по фактической дате исполнения']"); // Кнопка автопоиска "Проверка поиска по фактической дате исполнения"
    protected By buttonValidateSearchByContractDateOfSigning = By.xpath("//span[text()='Проверка поиска по дате подписания']"); // Кнопка автопоиска "Проверка поиска по дате подписания"
    protected By buttonValidateSearchByCategory = By.xpath("//span[text()='Проверка поиска по категории']"); // Кнопка автопоиска "Проверка поиска по категории"
    protected By listAutoSearchToScroll = By.xpath("//div[@id='tl-scroll-tabs']//div[@class='dx-scrollable-container']"); // Блок автопоисков для прокрутки list-autosearches

    protected By buttonCheckSearchByPrice = By.xpath("//span[text()='Проверка поиска по цене']"); // Кнопка автопоиска "Проверка поиска по цене"
    protected By buttonCheckSearchByTenderType = By.xpath("//span[text()='Проверка поиска по типу тендера']"); // Кнопка автопоиска "Проверка поиска по типу тендера"
    protected By buttonCheckSearchByTenderStand = By.xpath("//span[text()='Проверка поиска по площадке']"); // Кнопка автопоиска "Проверка поиска по площадке"
    protected By buttonCheckSearchByTenderModule = By.xpath("//span[text()='Проверка поиска по модулю']"); // Кнопка автопоиска "Проверка поиска по модулю"
    protected By buttonCheckSearchByParticipant = By.xpath("//span[text()='Проверка поиска по участнику']"); // Кнопка автопоиска "Проверка поиска по участнику"
    protected By buttonCheckSearchByMineTenders = By.xpath("//span[text()='Проверка поиска по моим тендерам']"); // Кнопка автопоиска "Проверка поиска по моим тендерам"
    protected By buttonCheckSearchByStatusContracts = By.xpath("//span[text()='Проверка поиска по статусу']"); // Кнопка автопоиска "Проверка поиска по статусу"
    protected By buttonCheckSearchByDocumentation = By.xpath("//span[text()='Проверка поиска по документации']"); // Кнопка автопоиска "Проверка поиска по документации"
    protected By buttonCheckSearchByNotice = By.xpath("//span[text()='Проверка поиска по извещению']"); // Кнопка автопоиска "Проверка поиска по извещению"
    protected By buttonCheckSearchByProduct = By.xpath("//span[text()='Проверка поиска по продуктам']"); // Кнопка автопоиска "Проверка поиска по продуктам"
    protected By buttonCheckSearchByMulct = By.xpath("//span[text()='Проверка поиска по штрафу']"); // Кнопка автопоиска "Проверка поиска по штрафу"
    protected By buttonCheckSearchBySumMulct = By.xpath("//span[text()='Проверка поиска по сумме штрафов']"); // Кнопка автопоиска "Проверка поиска по сумме штрафов"
    protected By buttonCheckSearchByUnpaidMulct = By.xpath("//span[text()='Проверка поиска по наличию неоплаченных штрафов']"); // Кнопка автопоиска "Проверка поиска по наличию неоплаченных штрафов"
    protected By buttonCheckSearchByNamePlan = By.xpath("//span[text()='Проверка поиска по названию плана']"); // Кнопка автопоиска "Проверка поиска по названию плана"
    protected By buttonCheckSearchByTypePlan = By.xpath("//span[text()='Проверка поиска по типу плана']"); // Кнопка автопоиска "Проверка поиска по типу плана"



    protected By filterRegionRoot = By.xpath("//span[text()='Санкт-Петербург Город']"); // Фильтр "Регион" в поле построения дерева фильтров для автопоиска "Проверка поиска по реестровому номеру и региону"
    protected By filterNameTender = By.xpath("//span[text()='мусор | ']"); // Фильтр "Название тендера" в поле построения дерева фильтров для автопоиска "Проверка поиска по названию тендера и исключению из названия"
    protected By filterPublicationDate = By.xpath("//span[text()='09.01.2021 — 09.01.2021']"); // Фильтр "Дата публикации" в автопоиске "Проверка поиска по дате публикации"
    protected By filterStartSubmissionOfApplication = By.xpath("//span[text()='04.01.2021 — 04.01.2021']"); // Фильтр "Дата начала подачи заявок" в автопоиске "Проверка поиска по дате начала подачи заявок"
    protected By filterEndSubmissionOfApplication = By.xpath("//span[text()='03.01.2021 — 03.01.2021']"); // Фильтр "Дата окончания подачи заявок" в автопоиске "Проверка поиска по дате окончания подачи заявок"
    protected By filterValidateSearchByTenderDate = By.xpath("//span[text()='12.01.2021 — 12.01.2021']"); // Фильтр "Дата проведения тендера" в автопоиске "Проверка поиска по дате проведения тендера"
    protected By filterValidateSearchByTenderPrice = By.xpath("//span[text()='10000 ₽ — 100000 ₽']"); // Фильтр "Цена" в автопоиске "Проверка поиска по цене"
//    protected By filterCategoryName = By.xpath("//span[text()='Коммунальные услуги']"); // Фильтр "Категория" в поле построения дерева фильтров для автопоиска "Проверка поиска по категории"
    protected By filterSearchByTenderModule = By.xpath("//span[text()='Государственные тендеры']"); // Фильтр "Модуль" в автопоиске "Проверка поиска по модулю"
    protected By filterSearchByMineTendersOrContractsStatus = By.xpath("//div[@class='dx-tag-content dx-tag-contr']"); // Фильтр "Мои Тендеры" в автопоиске "Проверка поиска по моим тендерам"
    protected By filterSearchByMulct = By.xpath("//div[@class='dx-tag-content dx-tag-contr']"); // Фильтр "Штраф" в автопоиске "Проверка поиска по штрафу"
    protected By filterSearchByTypePlan = By.xpath("//div[@class='dx-tag-content dx-tag-contr']"); // Фильтр "Тип" в автопоиске "Проверка поиска по типу плана"
    protected By filterSearchByUnpaidMulct = By.xpath("//div[@class='dx-tag-content dx-tag-contr']"); // Фильтр "Наличие неоплаченных штраф" в автопоиске "Проверка поиска по наличию неоплаченных штрафов"
    protected By checkbox = By.xpath("//tbody[@role='presentation']//div[@role='checkbox']"); // чекбокс в таблице результата поиска
    protected By checkBoxTransliteration = By.xpath("//div[@id='filter-editor-compact-1-transliteration']"); // чекбокс "Транслитерация"
    protected By checkBoxFilter = By.xpath("//div[@role='checkbox'][@class='dx-widget dx-checkbox dx-list-select-checkbox']"); // чекбокс в фильтре "Модуль" у тендера или "Статус" у контракта или "Тип" у плана
    protected By buttonApply = By.id("filter-apply-button"); // Кнопка "Применить"

    protected By buttonSearch = By.id("search-button"); // Кнопка поиска
    protected By fieldNameTender = By.xpath("//div[@id='filter-editor-compact-1-include']//textarea"); // Поле для ввода названия тендера для поиска
    protected By fieldPublicationDateFrom = By.xpath("//div[@id='textbox-filter-editor-compact-5-from']//input[@role='textbox']"); // Поле для ввода даты публикации "от"
    protected By fieldPublicationDateTo = By.xpath("//div[@id='textbox-filter-editor-compact-5-to']//input[@role='textbox']"); // Поле для ввода даты публикации "до"
    protected By fieldPriceFrom = By.xpath("//div[@id='filter-editor-compact-4-from']//input[@role='spinbutton']"); // Поле для ввода цены "от"
    protected By fieldPriceTo = By.xpath("//div[@id='filter-editor-compact-4-to']//input[@role='spinbutton']"); // Поле для ввода цены "до"

    protected By buttonClearFieldDateFrom = By.xpath("//div[@id='textbox-filter-editor-compact-5-from']//span[@class='dx-icon dx-icon-clear']"); // Кнопка для очистки поля даты "от"
    protected By buttonClearFieldDateTo = By.xpath("//div[@id='textbox-filter-editor-compact-5-to']//span[@class='dx-icon dx-icon-clear']"); // Кнопка для очистки поля даты "до"
    protected By tableCellToCheck = By.xpath("//div[@class='dx-datagrid-content']//tbody[@role='presentation']//td[4]"); // Ячейка таблицы в результатах поиска для первого столбца для первой строки
    protected By cellTableToOpenDocumentationNotice = By.xpath("(//div[@class='dx-datagrid-content']//tbody[@role='presentation']//a)[2]"); // Ячейка таблицы для открытия документации извещения тендера
    protected By cellTableToOpenDocumentation = By.xpath("//div[@class='dx-datagrid-content']//tbody[@role='presentation']//a"); // Ячейка таблицы для открытия документации тендера
    protected By tableCellToCheckForCategory = By.xpath("//div[@class='dx-datagrid-content']//tbody[@role='presentation']//td[4]//td"); // Ячейка таблицы в результатах поиска тендеров для первого столбца для первой строки для фильтра "Категория"
//    protected By cellTableToCheckSearchContract = By.xpath("//div[@class='dx-datagrid-content']//tbody[@role='presentation']//td[3]"); //Ячейка таблицы в результатах поиска контрактов для первого столбца для первой строки
//    protected By CheckboxOKPD = By.xpath("//div[text()='Покупка ПО']/preceding-sibling::div[@role='checkbox']"); // чекбокс ОКПД при поиске по слову "семга"
//    protected By tabDocumentation = By.xpath("//div[@id='entity-card-menu-div']//div[text()='Документация']"); // вкладка "Документация" в карточке тендера
//    protected By buttonOpenDocumentation = By.xpath("//i[@class='mdi mdi-24px mdi-folder-search-outline tl-icon']"); // кнопка "Открыть документацию"
    protected By tabListProductsInCardContract = By.id("tl-card-2"); // Вкладка "Список продуктов" в карточке контракта
    protected By tabMulctContracts = By.id("tl-card-5"); // Вкладка "Штрафы" в карточке контракта
    protected By radiobuttonYesUnpaidMulct = By.xpath("(//div[@class='dx-radiobutton-icon'])[1]"); // чекбокс "Да" в фильтре "Наличие неоплаченных штрафов"
    protected By radiobuttonNoUnpaidMulct = By.xpath("(//div[@class='dx-radiobutton-icon'])[2]"); // чекбокс "Нет" в фильтре "Наличие неоплаченных штрафов"



    private By loginField = By.xpath("//input[@type='text']"); // Поле для ввода логина
    private By passwordField = By.xpath("//input[@type='password']"); // Поле для ввода пароля
    private By checkLogin = By.xpath("//ul[@class='navbar-nav']//a"); // объект для проверки логина после входа
    private By rowResultSearch = By.xpath("//div[@class='dx-datagrid-content']//table[@role='presentation']//tr[@role='row']"); // Строка таблицы поиска
    private By fieldSearchFilters = By.xpath("//div[@id='tl-search-filters-textbox']//input"); // Поле поиска фильтров в блоке фильтров
    private By resultSearchFilters = By.xpath("//div[@id='list-tenders']//div[not(@style='display: none;')]"); // Результат поиска в блоке фильтров

//    private By cellOfRegistryName = By.xpath("//div[@class='dx-datagrid-content']//tbody[@role='presentation']//td[5]"); // Ячейка таблицы в результатах поиска с названием тендера
// div[(contains(@class,'dx-item dx-multiview-item dx-item-selected'))][not(@hidden)]//input[@class='dx-texteditor-input'][not(@hidden)]
    private By fieldSearchInFilterEditor = By.xpath("//div[(contains(@class,'dx-item dx-multiview-item dx-item-selected'))]//input[@class='dx-texteditor-input']"); // Поле поиска внутри фильтра
    private By fieldNameTenderDeletion = By.xpath("//div[@id='filter-editor-compact-1-exclude']//textarea"); // Поле для ввода параметра, исключаемого из поиска
    private By fieldDocumentation = By.id("gethtml_file_content"); // Содержимое документации
    private By searchWordIntoNoticeDocumentation = By.xpath("//em"); // Поисковое слово в извещении (выделенное)
    private By listProductInCardContract = By.xpath("//div[@id='entity-card-items']//table//tr/following::td[1]"); // Название продукта в списке продуктов карточки контракта
    private By listMulctInCardContract = By.xpath("//div[@id='entity-card-items']//div[@class='tl-card-item'][5]//table//tr/following::td[4]"); // Причина штрафа в списке штрафов карточки контракта
    private By listSumMulctInCardContract = By.xpath("//div[@id='entity-card-items']//div[@class='tl-card-item'][5]//table//tr/following::td[5]"); // Сумма штрафа в списке штрафов карточки контракта
    private By listPaidMulctInCardContract = By.xpath("//div[@id='entity-card-items']//div[@class='tl-card-item'][5]//table//tr/following::td[6]"); // Оплата штрафа в списке штрафов карточки контракта





    public void waitFor(long number){
        waitABit(number);
    } // Ожидание

    public void clearField(By field){find(field).clear();} // Очистить поле

    public void clickButton(By button){
        find(button).click();
    } // Кликнуть по кнопке / выбрать radiobutton или checkbox

    public void doubleClickButton(By button){
//        find(button).click();
            withAction().doubleClick(find(button)).build().perform();
    } // Двойной клик

    public void switchToTab(){

        for(String windowHandle : getDriver().getWindowHandles()) {
            getDriver().switchTo().window(windowHandle);
        }
    } // Переключиться на следующую вкладку

    public AutoSearchPage scrollDownTo(By scroll){
        ((JavascriptExecutor)getDriver()).executeScript(
                "arguments[0].scrollTop = -1 >>> 1", find(scroll));
        return this;
    } // Прокрутить содержимое элемента вниз

    public void clickButton(WebElementFacade button){
        button.click();
    } // Кликнуть по кнопке / выбрать radiobutton или checkbox

    public AutoSearchPage typeLogin(String login){
        find(loginField).sendKeys(login);
        return this;
    } // Ввести логин для входа

    public AutoSearchPage typePassword(String password){
        find(passwordField).sendKeys(password);
        return this;
    } // Ввести пароль для входа

    public AutoSearchPage typeSearch(String search){
        find(fieldSearchInFilterEditor).sendKeys(search);
        return this;
    } // Ввести значение в поле поиска фильтров

    public AutoSearchPage typeSearchFilters(String search){
        find(fieldSearchFilters).sendKeys(search);
        return this;
    } // Ввести значение в поле поиска

    public AutoSearchPage typeDeletion(String name){
        find(fieldNameTenderDeletion).sendKeys(name);
        return this;
    } // Ввести значение, исключаемое из поиска

    public AutoSearchPage typeNameTender(String name){
        find(fieldNameTender).sendKeys(name);
        return this;
    } // Ввести ключевое слово для поиска по названию тендера

    public AutoSearchPage typeDateFrom(String date){
        find(fieldPublicationDateFrom).sendKeys(date);
        return this;
    } // Ввести дату публикации "от"

    public AutoSearchPage typeDateTo(String date){
        find(fieldPublicationDateTo).sendKeys(date);
        return this;
    } // Ввести дату публикации "до"

    public AutoSearchPage typePriceFrom(String price){
        find(fieldPriceFrom).sendKeys(price);
        return this;
    } // Ввести цену "от"

    public AutoSearchPage typePriceTo(String price){
        find(fieldPriceTo).sendKeys(price);
        return this;
    } // Ввести цену "до"

    public String getTextLogin(){
        return find(checkLogin).getText();
    } // Получение названия логина после входа

    public String getTextRegistryNumber(){
        return find(tableCellToCheck).getText();
    } // Получение реестрового номера

    public boolean checkDate(String startDate, String endDate) throws ParseException {
        boolean check = true;
        List<WebElementFacade> dateForCheck = findAll(tableCellToCheck);
        dateForCheck.remove(dateForCheck.size()-1);
        for(WebElementFacade date : dateForCheck) {
            String dateStr = date.getText();
            dateStr = dateStr.replace("\n" + "(UTC+03:00)", "");
            dateStr = dateStr.replace("\n", " ");
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
            Date currentDate = dateFormat.parse(dateStr);
            Date leftDate = dateFormat.parse(startDate);
            Date rightDate = dateFormat.parse(endDate);
            if(!(currentDate.getTime() >= leftDate.getTime() && currentDate.getTime() <= rightDate.getTime())){
                check = false;
                break;
            }
//            System.out.println(date.getText());
        }
        return check;
    } // Проверка, что дата публикации находится в заданном диапазоне

    public boolean checkPrice(float priceFrom, float priceTo){
        boolean check = true;
        List<WebElementFacade> priceForCheck = findAll(tableCellToCheck);
        priceForCheck.remove(priceForCheck.size()-1);
        for(WebElementFacade price : priceForCheck){
            String priceCheck = price.getText();
            priceCheck = priceCheck.replace(" ₽", "");
            priceCheck = priceCheck.replace(" ", "");
            float floatPriceForCheck = Float.parseFloat(priceCheck);
            if(floatPriceForCheck < priceFrom || floatPriceForCheck > priceTo){
                check = false;
                break;
            }
        }
        return check;
    } // Проверка цены тендера

    public Integer getNumberOfRowResultSearch(){
        List<WebElementFacade> rowResult = findAll(rowResultSearch);
        return rowResult.size();
    } // Получение количества строк в таблице результата поиска

    public WebElementFacade getCheckboxByNumber(int number){
        List<WebElementFacade> checkBoxResult = findAll(checkbox);
        return checkBoxResult.get(number);
    } // Получение чекбокса по его порядковому номеру

    public WebElementFacade getCheckboxInFilter(int numberCheckbox){
        List<WebElementFacade> checkboxMineTenders = findAll(checkBoxFilter);
        return checkboxMineTenders.get(numberCheckbox);
    } // Получить чекбокс по его порядковому номеру в фильтре "Мои тендеры" у тендера или "Статус" у контракта


    public boolean isEqualNumberOfRowResultSearch(int number){
        return getNumberOfRowResultSearch()==number;
    } // Проверка, соответствует ли количество строк в таблице результата поиска заданному

    public boolean isContainNameTender(){
        List<WebElementFacade> nameTender = findAll(tableCellToCheck);
        nameTender.remove(nameTender.size()-1);
        boolean check = false;
        for(WebElementFacade name : nameTender){
            if(name.getText().contains("мусор")||name.getText().contains("МУСОР")||name.getText().contains("муcор")||name.getText().contains("МУCОР")){
//                System.out.println(name.getText());
                check = true;
                break;
            }
        }
        return check;
    } // Проверка включения в название тендеров ключевого слова

    public boolean isContainDeletionNameTender(){
        List<WebElementFacade> nameTender = findAll(tableCellToCheck);
        nameTender.remove(nameTender.size()-1);
        boolean check = false;
        for(WebElementFacade name : nameTender){
            if(!(name.getText().contains("мусоровоз")||name.getText().contains("МУСОРОВОЗ"))){
//                System.out.println(name.getText());
                check = true;
                break;
            }
        }
        return check;
    } // Проверка включения в название тендеров ключевого слова

    public boolean isContainCategoryName(){
        List<WebElementFacade> nameCategory = findAll(tableCellToCheckForCategory);
        nameCategory.remove(nameCategory.size()-1);
        boolean check = true;
        for(WebElementFacade name : nameCategory){
            if(!(name.getText().contains("Коммунальные услуги"))){
//                System.out.println("Услуги: " + name.getText());
                check = false;
                break;
            }
        }
        return check;
    } // Проверка поиска по категории

    public boolean isContainTenderType(){
        List<WebElementFacade> tenderType = findAll(tableCellToCheck);
        tenderType.remove(tenderType.size()-1);
        boolean check = true;
        for(WebElementFacade type : tenderType){
            if(!(type.getText().contains("Закупка малого объема"))){
//                System.out.println("Услуги: " + name.getText());
                check = false;
                break;
            }
        }
        return check;
    } // Проверка поиска по типу тендера

    public boolean isContainTenderStand(){
        List<WebElementFacade> tenderStand = findAll(tableCellToCheck);
        tenderStand.remove(tenderStand.size()-1);
        boolean check = true;
        for(WebElementFacade type : tenderStand){
            if(!(type.getText().contains("ОБЩЕСТВО С ОГРАНИЧЕННОЙ ОТВЕТСТВЕННОСТЬЮ «РТС-ТЕНДЕР»"))){
//                System.out.println("Услуги: " + name.getText());
                check = false;
                break;
            }
        }
        return check;
    } // Проверка поиска по площадке

    public boolean isContainOnlyGovernmentTenders(){
        List<WebElementFacade> governmentTenders = findAll(tableCellToCheck);
        governmentTenders.remove(governmentTenders.size()-1);
        boolean check = true;
        for(WebElementFacade type : governmentTenders){
            if(!(type.getText().contains("Государственные тендеры"))){
//                System.out.println("Услуги: " + name.getText());
                check = false;
                break;
            }
        }
        return check;
    } // Проверка поиска по модулю "Государственные тендеры"

    public boolean isContainOnlyGovernmentAndCommercialTenders(){
        List<WebElementFacade> governmentTenders = findAll(tableCellToCheck);
        governmentTenders.remove(governmentTenders.size()-1);
        boolean check = true;
        for(WebElementFacade type : governmentTenders){
            if(!(type.getText().contains("Государственные тендеры")) && !(type.getText().contains("Коммерческие тендеры"))){
//                System.out.println("Услуги: " + name.getText());
                check = false;
                break;
            }
        }
        return check;
    } // Проверка поиска по модулю "Государственные тендеры" и "Коммерческие тендеры"

    public boolean isContainOnlyGovernmentAndCommercialAndCISTenders(){
        List<WebElementFacade> governmentTenders = findAll(tableCellToCheck);
        governmentTenders.remove(governmentTenders.size()-1);
        boolean check = true;
        for(WebElementFacade type : governmentTenders){
            if(!(type.getText().contains("Государственные тендеры")) && !(type.getText().contains("Коммерческие тендеры")) && !(type.getText().contains("СНГ"))){
//                System.out.println("Услуги: " + name.getText());
                check = false;
                break;
            }
        }
        return check;
    } // Проверка поиска по модулю "Государственные тендеры" и "Коммерческие тендеры" и "СНГ"

    public boolean isContainAllModulesTenders(){
        List<WebElementFacade> governmentTenders = findAll(tableCellToCheck);
        governmentTenders.remove(governmentTenders.size()-1);
        boolean check = true;
        for(WebElementFacade type : governmentTenders){
            if(!(type.getText().contains("Государственные тендеры")) && !(type.getText().contains("Коммерческие тендеры"))
                    && !(type.getText().contains("СНГ")) && !(type.getText().contains("Реализация имущества"))){
//                System.out.println("Услуги: " + name.getText());
                check = false;
                break;
            }
        }
        return check;
    } // Проверка поиска по всем модулям

    public boolean isContainParticipant(){
        List<WebElementFacade> participantType = findAll(tableCellToCheck);
        participantType.remove(participantType.size()-1);
        boolean check = true;
        for(WebElementFacade type : participantType){
            if(!(type.getText().contains("ООО \"ТРАНСЭКОСЕРВИС\""))){
//                System.out.println("Услуги: " + name.getText());
                check = false;
                break;
            }
        }
        return check;
    } // Проверка поиска по участнику

    public boolean isContainNewTenders(){
        List<WebElementFacade> checkboxMineTenders = findAll(tableCellToCheck);
        checkboxMineTenders.remove(checkboxMineTenders.size()-1);
        boolean check = false;
        for(WebElementFacade type : checkboxMineTenders){
            if(type.getText().contains("400022118701")){
//                System.out.println("Услуги: " + name.getText());
                check = true;
                break;
            }
        }
        return check;
    } // Проверка поиска по новым тендерам фильтра "Мои тендеры"

    public boolean isContainApplicationPreparation(){
        List<WebElementFacade> checkboxMineTenders = findAll(tableCellToCheck);
        checkboxMineTenders.remove(checkboxMineTenders.size()-1);
        boolean check = false;
        for(WebElementFacade type : checkboxMineTenders){
            if(type.getText().contains("0130300010421000001")){
//                System.out.println("Услуги: " + name.getText());
                check = true;
                break;
            }
        }
        return check;
    } // Проверка поиска по подготовке заявки фильтра "Мои тендеры"

    public boolean isContainDeterminationOfWinner(){
        List<WebElementFacade> checkboxMineTenders = findAll(tableCellToCheck);
        checkboxMineTenders.remove(checkboxMineTenders.size()-1);
        boolean check = false;
        for(WebElementFacade type : checkboxMineTenders){
            if(type.getText().contains("8976791")){
//                System.out.println("Услуги: " + name.getText());
                check = true;
                break;
            }
        }
        return check;
    } // Проверка поиска по определению победителя фильтра "Мои тендеры"

    public boolean isContainConclusionOfContract(){
        List<WebElementFacade> checkboxMineTenders = findAll(tableCellToCheck);
        checkboxMineTenders.remove(checkboxMineTenders.size()-1);
        boolean check = false;
        for(WebElementFacade type : checkboxMineTenders){
            if(type.getText().contains("0126200000421000268")){
//                System.out.println("Услуги: " + name.getText());
                check = true;
                break;
            }
        }
        return check;
    } // Проверка поиска по заключению контракта фильтра "Мои тендеры"

    public boolean isContainExecutionOfContract(){
        List<WebElementFacade> checkboxMineTenders = findAll(tableCellToCheck);
        checkboxMineTenders.remove(checkboxMineTenders.size()-1);
        boolean check = false;
        for(WebElementFacade type : checkboxMineTenders){
            if(type.getText().contains("0306200004521000009")){
//                System.out.println("Услуги: " + name.getText());
                check = true;
                break;
            }
        }
        return check;
    } // Проверка поиска по исполнению контракта фильтра "Мои тендеры"

    public boolean isContainArchiveTenders(){
        List<WebElementFacade> checkboxMineTenders = findAll(tableCellToCheck);
        checkboxMineTenders.remove(checkboxMineTenders.size()-1);
        boolean check = false;
        for(WebElementFacade type : checkboxMineTenders){
            if(type.getText().contains("0848300064121000009")){
//                System.out.println("Услуги: " + name.getText());
                check = true;
                break;
            }
        }
        return check;
    } // Проверка поиска по архиву фильтра "Мои тендеры"

    public boolean isContainAllMineTenders(){
        List<WebElementFacade> checkboxMineTenders = findAll(tableCellToCheck);
        checkboxMineTenders.remove(checkboxMineTenders.size()-1);
        boolean check = true;
        for(WebElementFacade type : checkboxMineTenders){
            if(!(type.getText().contains("0130300010421000001")) && !(type.getText().contains("0848300064121000009"))
                    && !(type.getText().contains("0126200000421000268")) && !(type.getText().contains("400022118701"))
                    && !(type.getText().contains("0306200004521000009")) && !(type.getText().contains("8976791"))){
//                System.out.println("Услуги: " + name.getText());
                check = false;
                break;
            }
        }
        return check;
    } // Проверка поиска по всем тендерам из "Мои тендеры"

    public boolean isContainSearchDocumentation(){
        String textDocumentation = find(fieldDocumentation).getText();
//        boolean check = false;
//
//            if(){
////                System.out.println("Услуги: " + name.getText());
//                check = true;
//            }

        return textDocumentation.contains("мусор") || textDocumentation.contains("Мусор") || textDocumentation.contains("МУСОР");
    } // Проверка поиска по архиву фильтра "Мои тендеры"

    public boolean isContainSearchWordIntoNoticeDocumentation(){
        List<WebElementFacade> notice = findAll(searchWordIntoNoticeDocumentation);
        boolean check = false;
        for(WebElementFacade type : notice){
            if(type.getText().contains("мусор") || type.getText().contains("Мусор") || type.getText().contains("МУСОР")){
//                System.out.println("Услуги: " + name.getText());
                check = true;
                break;
            }
        }
        return check;
    } // Проверка поиска по извещению

    public boolean isContainFiltersFromSearchField(){
        List<WebElementFacade> filters = findAll(resultSearchFilters);
        boolean check = false;
        for(WebElementFacade type : filters){
            if(type.getText().contains("Название тендера")){
//                System.out.println("Услуги: " + name.getText());
                check = true;
                break;
            }
        }
        return check;
    } // Проверка поиска в блоке фильтров

    public boolean isContainCardContractSearchWord(){
        List<WebElementFacade> listCheck = findAll(listProductInCardContract);
        boolean check = false;
        for(WebElementFacade type : listCheck){
            if(type.getText().contains("Мусор") || type.getText().contains("МУСОР") || type.getText().contains("мусор")){
//                System.out.println("Услуги: " + name.getText());
                check = true;
                break;
            }
        }
        return check;
    } // Проверка включает ли карточка контракта искомый продукт

    public boolean isContainBeingExecuted(){
        List<WebElementFacade> checkboxMineTenders = findAll(tableCellToCheck);
        checkboxMineTenders.remove(checkboxMineTenders.size()-1);
        boolean check = true;
        for(WebElementFacade type : checkboxMineTenders){
            if(!type.getText().contains("Исполнение")){
//                System.out.println("Услуги: " + name.getText());
                check = false;
                break;
            }
        }
        return check;
    } // Проверка поиска по статусу контракта "Исполнение"

    public boolean isContainExecutionTerminated(){
        List<WebElementFacade> checkboxMineTenders = findAll(tableCellToCheck);
        checkboxMineTenders.remove(checkboxMineTenders.size()-1);
        boolean check = true;
        for(WebElementFacade type : checkboxMineTenders){
            if(!type.getText().contains("Исполнение прекращено")){
//                System.out.println("Услуги: " + name.getText());
                check = false;
                break;
            }
        }
        return check;
    } // Проверка поиска по статусу контракта "Исполнение прекращено"

    public boolean isContainExecutionCompleted(){
        List<WebElementFacade> checkboxMineTenders = findAll(tableCellToCheck);
        checkboxMineTenders.remove(checkboxMineTenders.size()-1);
        boolean check = true;
        for(WebElementFacade type : checkboxMineTenders){
            if(!type.getText().contains("Исполнение завершено")){
//                System.out.println("Услуги: " + name.getText());
                check = false;
                break;
            }
        }
        return check;
    } // Проверка поиска по статусу контракта "Исполнение завершено"

    public boolean isContainCardContractSearchByDelayInPerformanceBySupplier(){
        List<WebElementFacade> listCheck = findAll(listMulctInCardContract);
        boolean check = false;
        for(WebElementFacade type : listCheck){
            if(type.getText().contains("Просрочка исполнения поставщиком (подрядчиком, исполнителем) обязательств, предусмотренных контрактом (в том числе гарантийного обязательства)")){
//                System.out.println("Услуги: " + name.getText());
                check = true;
                break;
            }
        }
        return check;
    } // Проверка включает ли карточка контракта искомый штраф

    public boolean isContainCardContractSearchByDelayInFulfillmentOfObligationsByCustomer(){
        List<WebElementFacade> listCheck = findAll(listMulctInCardContract);
        boolean check = false;
        for(WebElementFacade type : listCheck){
            if(type.getText().contains("Просрочка исполнения заказчиком обязательств")){
//                System.out.println("Услуги: " + name.getText());
                check = true;
                break;
            }
        }
        return check;
    } // Проверка включает ли карточка контракта искомый штраф

    public boolean isContainCardContractSearchByInadequateExecutionBySupplier(){
        List<WebElementFacade> listCheck = findAll(listMulctInCardContract);
        boolean check = false;
        for(WebElementFacade type : listCheck){
            if(type.getText().contains("Ненадлежащее исполнение поставщиком")){
//                System.out.println("Услуги: " + name.getText());
                check = true;
                break;
            }
        }
        return check;
    } // Проверка включает ли карточка контракта искомый штраф

    public boolean isContainCardContractSearchByInadequateExecutionByCustomer(){
        List<WebElementFacade> listCheck = findAll(listMulctInCardContract);
        boolean check = false;
        for(WebElementFacade type : listCheck){
            if(type.getText().contains("Ненадлежащее исполнение заказчиком обязательств")){
//                System.out.println("Услуги: " + name.getText());
                check = true;
                break;
            }
        }
        return check;
    } // Проверка включает ли карточка контракта искомый штраф

    public boolean isSumMulct(float sumMulctFrom, float sumMulctTo){
        boolean check = true;
        List<WebElementFacade> sumMulctForCheck = findAll(listSumMulctInCardContract);
        for(WebElementFacade sumMulct : sumMulctForCheck){
//            System.out.println("Сумма: " + sumMulct.getText());
            String sumMulctCheck = sumMulct.getText();
            sumMulctCheck = sumMulctCheck.replace(",", ".");
            float floatSumMulctCheckForCheck = Float.parseFloat(sumMulctCheck);
            if(floatSumMulctCheckForCheck < sumMulctFrom || floatSumMulctCheckForCheck > sumMulctTo){
                check = false;
                break;
            }
        }
        return check;
    } // Проверка суммы штрафов контракта

    public boolean isUnpaidMulct(){
        boolean check = false;
        List<WebElementFacade> paidMulctForCheck = findAll(listPaidMulctInCardContract);
        for(WebElementFacade paidMulct : paidMulctForCheck){
//            System.out.println("Сумма: " + sumMulct.getText());
            String sumMulctCheck = paidMulct.getText();
            sumMulctCheck = sumMulctCheck.replace(",", ".");
            float floatSumMulctCheckForCheck = Float.parseFloat(sumMulctCheck);
            if(floatSumMulctCheckForCheck == 0){
                check = true;
                break;
            }
        }
        return check;
    } // Проверка оплаты штрафов контракта

    public boolean isPaidMulct(){
        boolean check = true;
        List<WebElementFacade> paidMulctForCheck = findAll(listPaidMulctInCardContract);
        for(WebElementFacade paidMulct : paidMulctForCheck){
//            System.out.println("Сумма: " + sumMulct.getText());
            String sumMulctCheck = paidMulct.getText();

            float floatSumMulctCheckForCheck = Float.parseFloat(sumMulctCheck);
            if(floatSumMulctCheckForCheck == 0){
                check = false;
                break;
            }
        }
        return check;
    } // Проверка оплаты штрафов контракта

    public boolean isContainNamePlan(){
        boolean check = true;
        List<WebElementFacade> namePlanForCheck = findAll(tableCellToCheck);
        namePlanForCheck.remove(namePlanForCheck.size()-1);
        for(WebElementFacade namePlan : namePlanForCheck){
//            System.out.println("Сумма: " + sumMulct.getText());
            if(!(namePlan.getText().contains("мусор") || namePlan.getText().contains("Мусор") || namePlan.getText().contains("МУСОР"))){
                check = false;
                break;
            }
        }
        return check;
    } // Проверка результатов поиска по названию плана

    public boolean isContainTypePlan(){
        boolean check = true;
        List<WebElementFacade> typePlanForCheck = findAll(tableCellToCheck);
        typePlanForCheck.remove(typePlanForCheck.size()-1);
        for(WebElementFacade typePlan : typePlanForCheck){
//            System.out.println("Сумма: " + sumMulct.getText());
            if(!typePlan.getText().contains("План")){
                check = false;
                break;
            }
        }
        return check;
    } // Проверка поиска по типу плана

    public boolean isContainTypePlanSchedule(){
        boolean check = true;
        List<WebElementFacade> typePlanForCheck = findAll(tableCellToCheck);
        typePlanForCheck.remove(typePlanForCheck.size()-1);
        for(WebElementFacade typePlan : typePlanForCheck){
//            System.out.println("Сумма: " + sumMulct.getText());
            if(!typePlan.getText().contains("План-график")){
                check = false;
                break;
            }
        }
        return check;
    } // Проверка поиска по типу плана

    public boolean isContainTypePlanSchedule2017(){
        boolean check = true;
        List<WebElementFacade> typePlanForCheck = findAll(tableCellToCheck);
        typePlanForCheck.remove(typePlanForCheck.size()-1);
        for(WebElementFacade typePlan : typePlanForCheck){
//            System.out.println("Сумма: " + sumMulct.getText());
            if(!typePlan.getText().contains("План-график 2017")){
                check = false;
                break;
            }
        }
        return check;
    } // Проверка поиска по типу плана



}
