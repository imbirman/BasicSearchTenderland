package pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@DefaultUrl("https://test.v2.tenderland.ru/Home/Landing")
public class TabTenders extends PageObject {


    protected By openTabMenu = By.id("tl-main-nav"); // Кнопка открытия бокового меню
    protected By logInButton = By.xpath("//a[text()='Войти']"); // Кнопка входа в систему
    protected By signInButton = By.xpath("//span[text()='Войти в систему']"); // Кнопка "Войти в систему"
    protected By tabListAutoSearch = By.xpath("//div[@class='search-filters-tab list-autosearches']"); // Вкладка "Автопоиски"
    protected By listAutoSearchToScroll = By.xpath("//div[@id='list-autosearches']//div[@class='dx-scrollable-container']"); // Блок автопоисков для прокрутки
    protected By listFilters = By.xpath("//div[@id='list-tenders-filters-group']//div[@class='dx-scrollable-container']"); // Блок фильтров для прокрутки
    protected By excludedElementCustomer = By.xpath("//div[text()='Проверка результата поиска на исключенный элемент фильтр Заказчик']"); // Кнопка автопоиска "Проверка результата поиска на исключенный элемент фильтр Заказчик"

    protected By buttonAutoSearchRegistryNumberAndRegion = By.xpath("//div[text()='Проверка поиска по реестровому номеру и региону']"); // Кнопка автопоиска "Проверка поиска по реестровому номеру и региону"
    protected By buttonCheckTenderNameAndNameDeletion = By.xpath("//div[text()='Проверка поиска по названию тендера и исключению из названия']"); // Кнопка автопоиска "Проверка по названию тендера и исключению из названия"
    protected By buttonCheckPublicationDate = By.xpath("//div[text()='Проверка поиска по дате публикации']"); // Кнопка автопоиска "Проверка поиска по дате публикации"
    protected By buttonCheckPublicationDateWithOnlyStartDate = By.xpath("//div[text()='Проверка поиска по дате (только начало)']"); // Кнопка автопоиска "Проверка поиска по дате (только начало)"
    protected By buttonCheckPublicationDateWithOnlyEndDate = By.xpath("//div[text()='Проверка поиска по дате (только конец)']"); // Кнопка автопоиска "Проверка поиска по дате (только конец)"
    protected By buttonCheckStartSubmissionOfApplicationDate = By.xpath("//div[text()='Проверка поиска по дате начала подачи заявок']"); // Кнопка автопоиска "Проверка поиска по дате начала подачи заявок"
    protected By buttonCheckEndSubmissionOfApplicationDate = By.xpath("//div[text()='Проверка поиска по дате окончания подачи заявок']"); // Кнопка автопоиска "Проверка поиска по дате окончания подачи заявок"
    protected By buttonValidateSearchByTenderDate = By.xpath("//div[text()='Проверка поиска по дате проведения тендера']"); // Кнопка автопоиска "Проверка поиска по дате проведения тендера"
    protected By buttonValidateSearchByCategory = By.xpath("//div[text()='Проверка поиска по категории']"); // Кнопка автопоиска "Проверка поиска по категории"
    protected By buttonCheckSearchByPrice = By.xpath("//div[text()='Проверка поиска по цене']"); // Кнопка автопоиска "Проверка поиска по цене"
    protected By buttonCheckSearchByTenderType = By.xpath("//div[text()='Проверка поиска по типу тендера']"); // Кнопка автопоиска "Проверка поиска по типу тендера"
    protected By buttonCheckSearchByTenderStand = By.xpath("//div[text()='Проверка поиска по площадке']"); // Кнопка автопоиска "Проверка поиска по площадке"
    protected By buttonCheckSearchByTenderModule = By.xpath("//div[text()='Проверка поиска по модулю']"); // Кнопка автопоиска "Проверка поиска по модулю"
    protected By buttonCheckSearchByParticipant = By.xpath("//div[text()='Проверка поиска по участнику']"); // Кнопка автопоиска "Проверка поиска по участнику"
    protected By buttonCheckSearchByMineTenders = By.xpath("//div[text()='Проверка поиска по моим тендерам']"); // Кнопка автопоиска "Проверка поиска по моим тендерам"
    protected By buttonCheckSearchByDocumentation = By.xpath("//div[text()='Проверка поиска по документации']"); // Кнопка автопоиска "Проверка поиска по документации"
    protected By buttonCheckSearchByNotice = By.xpath("//div[text()='Проверка поиска по извещению']"); // Кнопка автопоиска "Проверка поиска по извещению"
    protected By buttonHideFilter = By.xpath("(//i[@class='material-icons-round icon-20px icon-grey icon-grey-hover md-filter_alt_off'])[2]"); // Кнопка скрытия фильтра
    protected By buttonOpenTreeList = By.xpath("(//div[@class='dx-treelist-icon-container'])[1]"); // Кнопка раскрытия подкатегории


    protected By filterRegionRoot = By.xpath("//div[text()='Санкт-Петербург Город']"); // Фильтр "Регион" в поле построения дерева фильтров для автопоиска "Проверка поиска по реестровому номеру и региону"
    protected By filterNameTender = By.xpath("//div[text()='мусор']"); // Фильтр "Название тендера" в поле построения дерева фильтров для автопоиска "Проверка поиска по названию тендера и исключению из названия"
    protected By filterValidateSearchByTenderPrice = By.xpath("//div[text()='10000 ₽ — 100000 ₽']"); // Фильтр "Цена" в автопоиске "Проверка поиска по цене"
    protected By filterSearchByTenderModule = By.xpath("//div[text()='Государственные тендеры']"); // Фильтр "Модуль" в автопоиске "Проверка поиска по модулю"
    protected By filterSearchByMineTendersOrContractsStatus = By.xpath("//div[@class='search-filters-tagbox-tag-content']"); // Фильтр "Мои Тендеры" в автопоиске "Проверка поиска по моим тендерам"
    protected By filterDatePublication = By.xpath("//span[text()='публикации']"); // Фильтр "Дата публикации" в блоке фильтров
    protected By filterInTreeFilters = By.xpath("//div[@class='tl-filter-description']"); // фильтр в дереве фильтров
    protected By filterCategory = By.xpath("//span[text()='Категория']"); // Фильтр "Категория" в блоке фильтров

    protected By checkbox = By.xpath("//tbody[@role='presentation']//div[@role='checkbox']"); // чекбокс в таблице результата поиска
    protected By checkBoxTransliteration = By.xpath("//div[@id='filter-editor-compact-1-transliteration']"); // чекбокс "Транслитерация"
    protected By checkBoxFilter = By.xpath("//div[@role='checkbox'][@class='dx-widget dx-checkbox dx-list-select-checkbox']"); // чекбокс в фильтре
    protected By checkboxSelectAllMyTenders = By.xpath("//div[@role='checkbox'][@class='dx-widget dx-checkbox dx-list-select-all-checkbox']"); // чекбокс "Выбрать всё" в фильтре "Мои тендеры"
    protected By checkboxFirstInFilter = By.xpath("(//div[@id='filter-editor-2']//span[@class='dx-checkbox-icon'])[1]"); // Чекбокс первого пункта фильтра
    protected By textCheckboxSelected = By.xpath("//div[@class='dx-widget dx-checkbox dx-state-hover dx-checkbox-checked']//following-sibling::div[@style='margin-left: 25px;']"); // Текст выбранного чекбокса внутри фильтра

    protected By buttonApply = By.id("filter-apply-button"); // Кнопка "Применить"
    protected By buttonSearch = By.id("search-filters-search-button"); // Кнопка поиска
    protected By fieldNameTender = By.xpath("//div[@id='filter-editor-compact-1-include']//textarea"); // Поле для ввода названия тендера для поиска
    protected By fieldPriceFrom = By.xpath("//div[@id='filter-editor-compact-4-from']//input[@role='spinbutton']"); // Поле для ввода цены "от"
    protected By fieldPriceTo = By.xpath("//div[@id='filter-editor-compact-4-to']//input[@role='spinbutton']"); // Поле для ввода цены "до"
    protected By fieldPublicationDateFrom = By.xpath("//div[@id='textbox-filter-editor-compact-5-from']//input[@role='textbox']"); // Поле для ввода даты публикации "от"
    protected By fieldPublicationDateTo = By.xpath("//div[@id='textbox-filter-editor-compact-5-to']//input[@role='textbox']"); // Поле для ввода даты публикации "до"

    protected By tableCellToCheck = By.xpath("//div[@class='dx-datagrid-content']//tbody[@role='presentation']//td[4]"); // Ячейка таблицы в результатах поиска для первого столбца для первой строки
    protected By cellTableToOpenDocumentationNotice = By.xpath("(//td//a)[2]"); // Ячейка таблицы для открытия документации извещения тендера
    protected By cellTableToOpenDocumentation = By.xpath("//div[@class='dx-datagrid-content']//tbody[@role='presentation']//a"); // Ячейка таблицы для открытия документации тендера
    protected By tableCellToCheckForCategory = By.xpath("//div[@class='dx-datagrid-content']//tbody[@role='presentation']//td[4]"); // Ячейка таблицы в результатах поиска тендеров для первого столбца для первой строки для фильтра "Категория"
    protected By cellTableForCheckRegion = By.xpath("//div[@class='dx-datagrid-content']/table[@role='presentation']//tr[@class='dx-row dx-data-row dx-row-lines']/td[5]"); // Ячейка таблицы результатов поиска для проверки региона

    protected By contextMenuResultSearch = By.xpath("//table[@class='dx-datagrid-table dx-pointer-events-none dx-datagrid-table-fixed']//a[@class='dx-link dx-icon-overflow dx-link-icon']"); // Кнопка контекстного меню для строки результата поиска
    protected By markContextMenu = By.xpath("//div[text()='Метка тендера']"); // пункт контекстного меню "Метка тендера"
    protected By redMarkContextMenu = By.xpath("//div[text()='Красный']"); // Метка "Красный" в контекстном меню
    protected By deleteMark = By.xpath("//div[@class='dx-submenu']//div[text()='Удалить']"); // Кнопка "Удалить метку"

    private final By loginField = By.xpath("//input[@type='text']"); // Поле для ввода логина
    private final By passwordField = By.xpath("//input[@type='password']"); // Поле для ввода пароля
    private final By rowResultSearch = By.xpath("//div[@class='dx-datagrid-content']//table[@role='presentation']//tr[@role='row']"); // Строка таблицы поиска
    private final By fieldSearchFilters = By.xpath("//div[@id='search-filters-search-textbox']//input"); // Поле поиска фильтров в блоке фильтров
    private final By resultSearchFilters = By.xpath("//div[@id='list-tenders']//div[not(@style='display: none;')]"); // Результат поиска в блоке фильтров
    private final By fieldSearchInFilterEditor = By.xpath("//div[(contains(@class,'dx-item dx-multiview-item dx-item-selected'))]//input[@class='dx-texteditor-input']"); // Поле поиска внутри фильтра
    private final By fieldNameTenderDeletion = By.xpath("//div[@id='filter-editor-compact-1-exclude']//textarea"); // Поле для ввода параметра, исключаемого из поиска
    private final By fieldDocumentation = By.id("gethtml_file_content"); // Содержимое документации
    private final By searchWordIntoNoticeDocumentation = By.xpath("//em"); // Поисковое слово в извещении (выделенное)
    private final By markTender = By.xpath("//div[@class='tl-tag-tender']"); // Метка тендера
    private final By filterRoot = By.xpath("//div[@class='dx-sortable tl-filter-content tl-filter-drop-area']"); // Поле дерева фильтров
    private final By cellTableForCheckCustomer = By.xpath("//div[@class='dx-datagrid-content']/table[@role='presentation']//tr[@class='dx-row dx-data-row dx-row-lines']/td[8]"); // Ячейка таблицы результатов поиска для проверки заказчика





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

    public void moveToElement(By element){
        moveTo(element);
    } // Навести курсор на элемент

    public void dragAndDropFilter(By filter){
        withAction().dragAndDrop(find(filter), find(filterRoot)).build().perform();
    } // Перетащить фильтр в область построения дерева фильтров

    public void scrollDownTo(By scroll){
        ((JavascriptExecutor)getDriver()).executeScript(
                "arguments[0].scrollTop = -1 >>> 1", find(scroll));
    } // Прокрутить содержимое элемента вниз

    public void scrollWindowOnPixels(String number){
        ((JavascriptExecutor)getDriver()).executeScript(
                "window.scrollBy(0," + number + ")");
    } // Прокрутить окно на заданное количество пикселей

    public void scrollElementOnPixels(String number, By scroll){
        ((JavascriptExecutor)getDriver()).executeScript(
                "arguments[0].scrollBy(0," + number + ")", find(scroll));
    } // Прокрутить на заданное количество пикселей

    public void clickButton(WebElementFacade button){
        button.click();
    } // Кликнуть по кнопке / выбрать radiobutton или checkbox

    public void typeLogin(String login){
        find(loginField).sendKeys(login);
    } // Ввести логин для входа

    public void typePassword(String password){
        find(passwordField).sendKeys(password);
    } // Ввести пароль для входа

    public void typeSearch(String search){
        find(fieldSearchInFilterEditor).sendKeys(search);
    } // Ввести значение в поле поиска фильтров

    public void typeSearchFilters(String search){
        find(fieldSearchFilters).sendKeys(search);
    } // Ввести значение в поле поиска

    public void typeDeletion(String name){
        find(fieldNameTenderDeletion).sendKeys(name);
    } // Ввести значение, исключаемое из поиска

    public void typeNameTender(String name){
        find(fieldNameTender).sendKeys(name);
    } // Ввести ключевое слово для поиска по названию тендера

    public void typePriceFrom(String price){
        find(fieldPriceFrom).sendKeys(price);
    } // Ввести цену "от"

    public void typePriceTo(String price){
        find(fieldPriceTo).sendKeys(price);
    } // Ввести цену "до"

    public void typeDateFrom(String date){
        find(fieldPublicationDateFrom).sendKeys(date);
    } // Ввести дату публикации "от"

    public void typeDateTo(String date){
        find(fieldPublicationDateTo).sendKeys(date);
    } // Ввести дату публикации "до"

    public String getTextRegistryNumber(){
        return find(tableCellToCheck).getText();
    } // Получение реестрового номера

    public boolean checkDate(String startDate, String endDate) throws ParseException {
        boolean check = false;
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
            if(currentDate.getTime() >= leftDate.getTime() && currentDate.getTime() <= rightDate.getTime()){
                check = true;
                break;
            }
//            System.out.println(date.getText());
        }
        return check;
    } // Проверка, что дата находится в заданном диапазоне

    public boolean checkDateWithOnlyStartDate(String startDate) throws ParseException {
        boolean check = false;
        List<WebElementFacade> dateForCheck = findAll(tableCellToCheck);
        dateForCheck.remove(dateForCheck.size()-1);
        for(WebElementFacade date : dateForCheck) {
            String dateStr = date.getText();
            dateStr = dateStr.replace("\n" + "(UTC+03:00)", "");
            dateStr = dateStr.replace("\n", " ");
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
            Date currentDate = dateFormat.parse(dateStr);
            Date leftDate = dateFormat.parse(startDate);
            if(currentDate.getTime() >= leftDate.getTime()){
                check = true;
                break;
            }
//            System.out.println(date.getText());
        }

        return check;
    } // Проверка, что дата находится в заданном диапазоне

    public boolean checkDateWithOnlyEndDate(String endDate) throws ParseException {
        boolean check = false;
        List<WebElementFacade> dateForCheck = findAll(tableCellToCheck);
        dateForCheck.remove(dateForCheck.size()-1);
        for(WebElementFacade date : dateForCheck) {
            String dateStr = date.getText();
            dateStr = dateStr.replace("\n" + "(UTC+03:00)", "");
            dateStr = dateStr.replace("\n", " ");
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
            Date currentDate = dateFormat.parse(dateStr);
            Date rightDate = dateFormat.parse(endDate);
            if(currentDate.getTime() <= rightDate.getTime()){
                check = true;
                break;
            }
//            System.out.println(date.getText());
        }
        return check;
    } // Проверка, что дата находится в заданном диапазоне

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
    } // Проверка цены

    public Integer getNumberOfRowResultSearch(){
        List<WebElementFacade> rowResult = findAll(rowResultSearch);
        return rowResult.size();
    } // Получение количества строк в таблице результата поиска

    public String getCheckboxByNumber(int number){
        List<WebElementFacade> checkBoxResult = findAll(checkbox);
        return checkBoxResult.get(number).getText();
    } // Получение названия чекбокса по его порядковому номеру

    public WebElementFacade getCheckboxInFilter(int numberCheckbox){
        List<WebElementFacade> checkboxMineTendersOrStatusContract = findAll(checkBoxFilter);
        return checkboxMineTendersOrStatusContract.get(numberCheckbox);
    } // Получить чекбокс по его порядковому номеру в фильтре "Мои тендеры" у тендера или "Статус" у контракта

    public WebElementFacade getCheckboxInFilterRegion(int numberCheckbox){
        List<WebElementFacade> checkboxRegion = findAll(checkbox);
        return checkboxRegion.get(numberCheckbox);
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
            if(!(type.getText().contains("ОБЩЕСТВО С ОГРАНИЧЕННОЙ ОТВЕТСТВЕННОСТЬЮ \"ТРАНСЭКОСЕРВИС\""))){
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

    public boolean isContainWithoutHideFilter(){
        List<WebElementFacade> checkRegion = findAll(cellTableForCheckRegion);
        boolean check = false;
        for(WebElementFacade type : checkRegion){
            if(!type.getText().contains("Санкт-Петербург город")){
//                System.out.println("Название: " + type.getText());
                check = true;
                break;
            }
        }
        return check;
    } // Проверка поиска со скрытым фильтром

    public boolean isMarkOfTender(){
        return find(markTender).getAttribute("style").contains("background: rgb(235, 9, 16); height: 100%;");
    } // Проверка, что метка красная

    public boolean isDeletionMarkOfTender(){
        return find(markTender).getAttribute("style").contains("height: 0%;");
    } // Проверка, что метки нет

    public boolean isEmptyFieldPublicationDateTo(){
        return find(fieldPublicationDateTo).getText().isEmpty();
    } // Проверка поля "Дата до" фильтра "Дата публикации"

    public Integer getNumberSelectedCategories(){
        List<String> textCheckbox = findAll(textCheckboxSelected).texts();
        return textCheckbox.size();
    } // Получить количество выбранных элементов фильтра "Категории"

    public boolean isContainSelectedCategory(){
        List<String> textCheckbox = findAll(textCheckboxSelected).texts();
        textCheckbox.remove(0);
        List<String> checkArray = new ArrayList<>();
        checkArray.add("Банковские услуги");
        checkArray.add("Бухгалтерский учет, аудит");
        checkArray.add("Кадровые услуги");
        checkArray.add("Консультационные услуги");
        checkArray.add("Медицинское страхование");
        checkArray.add("Оценка, экспертиза");
        checkArray.add("Реализация имущества");
        checkArray.add("Страхование");
        checkArray.add("Услуги по лицензированию, сертификации и аттестации");
        checkArray.add("Юридические услуги");

        return checkArray.equals(textCheckbox);
    } // Проверка на соответствие списка выбранных элементов фильтра "Категории"

    public boolean isNotIncludeExcludedElement(){
        List<String> textCheck = findAll(cellTableForCheckCustomer).texts();
        boolean check = true;
        for(String type : textCheck) {
            if(type.contains("КГКУ \"АЛТАЙАВТОДОР\"")){check = false; break;}
        }
        return check;
    } // Проверка результата поиска на исключенный элемент из фильтра "Заказчик"
}
