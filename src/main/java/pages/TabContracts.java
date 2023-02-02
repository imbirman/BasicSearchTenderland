package pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@DefaultUrl("https://test.v2.tenderland.ru/Home/Landing")
public class TabContracts extends PageObject {

    protected By openTabMenu = By.id("tl-main-nav"); // Кнопка открытия бокового меню
    protected By logInButton = By.xpath("//a[text()='Войти']"); // Кнопка входа в систему
    protected By signInButton = By.xpath("//span[text()='Войти в систему']"); // Кнопка "Войти в систему"

    protected By tabListAutoSearch = By.xpath("//div[@class='search-filters-tab list-autosearches']"); // Вкладка "Автопоиски"
    protected By tabListProductsInCardContract = By.id("tl-card-2"); // Вкладка "Список продуктов" в карточке контракта
    protected By tabMulctContracts = By.id("tl-card-5"); // Вкладка "Штрафы" в карточке контракта

    protected By buttonSearch = By.id("search-button"); // Кнопка поиска
    protected By buttonCheckSearchByProduct = By.xpath("//span[text()='Проверка поиска по продуктам']"); // Кнопка автопоиска "Проверка поиска по продуктам"
    protected By buttonCheckSearchByPrice = By.xpath("//span[text()='Проверка поиска по цене']"); // Кнопка автопоиска "Проверка поиска по цене"
    protected By buttonCheckSearchByStatusContracts = By.xpath("//span[text()='Проверка поиска по статусу']"); // Кнопка автопоиска "Проверка поиска по статусу"
    protected By buttonCheckPublicationDate = By.xpath("//span[text()='Проверка поиска по дате публикации']"); // Кнопка автопоиска "Проверка поиска по дате публикации"
    protected By buttonClearFieldDateFrom = By.xpath("//div[@id='textbox-filter-editor-compact-5-from']//span[@class='dx-icon dx-icon-clear']"); // Кнопка для очистки поля даты "от"
    protected By buttonValidateSearchByContractExecutionStartDate = By.xpath("//span[text()='Проверка поиска по дате начала исполнения']"); // Кнопка автопоиска "Проверка поиска по дате начала исполнения"
    protected By buttonValidateSearchByContractExecutionEndDate = By.xpath("//span[text()='Проверка поиска по дате окончания исполнения']"); // Кнопка автопоиска "Проверка поиска по дате окончания исполнения"
    protected By buttonValidateSearchByContractActualExecutionDate = By.xpath("//span[text()='Проверка поиска по фактической дате исполнения']"); // Кнопка автопоиска "Проверка поиска по фактической дате исполнения"
    protected By buttonValidateSearchByContractDateOfSigning = By.xpath("//span[text()='Проверка поиска по дате подписания']"); // Кнопка автопоиска "Проверка поиска по дате подписания"
    protected By buttonCheckSearchByMulct = By.xpath("//span[text()='Проверка поиска по штрафу']"); // Кнопка автопоиска "Проверка поиска по штрафу"
    protected By buttonCheckSearchBySumMulct = By.xpath("//span[text()='Проверка поиска по сумме штрафов']"); // Кнопка автопоиска "Проверка поиска по сумме штрафов"
    protected By buttonCheckSearchByUnpaidMulct = By.xpath("//span[text()='Проверка поиска по наличию неоплаченных штрафов']"); // Кнопка автопоиска "Проверка поиска по наличию неоплаченных штрафов"

    protected By filterValidateSearchByTenderPrice = By.xpath("//span[text()='10000 ₽ — 100000 ₽']"); // Фильтр "Цена" в автопоиске "Проверка поиска по цене"
    protected By filterSearchByMineTendersOrContractsStatus = By.xpath("//div[@class='dx-tag-content dx-tag-contr']"); // Фильтр "Мои Тендеры" в автопоиске "Проверка поиска по моим тендерам"
    protected By filterPublicationDate = By.xpath("//span[text()='09.01.2021 — 09.01.2021']"); // Фильтр "Дата публикации" в автопоиске "Проверка поиска по дате публикации"
    protected By filterSearchByMulct = By.xpath("//div[@class='dx-tag-content dx-tag-contr']"); // Фильтр "Штраф" в автопоиске "Проверка поиска по штрафу"
    protected By filterSearchByUnpaidMulct = By.xpath("//div[@class='dx-tag-content dx-tag-contr']"); // Фильтр "Наличие неоплаченных штраф" в автопоиске "Проверка поиска по наличию неоплаченных штрафов"

    protected By tableCellToCheck = By.xpath("//div[@class='dx-datagrid-content']//tbody[@role='presentation']//td[4]"); // Ячейка таблицы в результатах поиска для первого столбца для первой строки
    protected By tableCellToCheckForSwitchToNextTab = By.xpath("(//div[@class='dx-datagrid-content']//tbody[@role='presentation']/tr)[1]"); // Ячейка таблицы в результатах поиска для первого столбца для первой строки для тестов по штрафам

    //div[@class='dx-datagrid-content']//tbody[@role='presentation']//td[5]
    protected By checkBoxFilter = By.xpath("//div[@role='checkbox'][@class='dx-widget dx-checkbox dx-list-select-checkbox']"); // чекбокс в фильтре "Модуль" у тендера или "Статус" у контракта или "Тип" у плана

    protected By fieldPriceFrom = By.xpath("//div[@id='filter-editor-compact-4-from']//input[@role='spinbutton']"); // Поле для ввода цены "от"
    protected By fieldPriceTo = By.xpath("//div[@id='filter-editor-compact-4-to']//input[@role='spinbutton']"); // Поле для ввода цены "до"
    protected By fieldNameTender = By.xpath("//div[@id='filter-editor-compact-1-include']//textarea"); // Поле для ввода названия тендера для поиска
    protected By fieldPublicationDateFrom = By.xpath("//div[@id='textbox-filter-editor-compact-5-from']//input[@role='textbox']"); // Поле для ввода даты публикации "от"
    protected By fieldPublicationDateTo = By.xpath("//div[@id='textbox-filter-editor-compact-5-to']//input[@role='textbox']"); // Поле для ввода даты публикации "до"

    protected By radiobuttonYesUnpaidMulct = By.xpath("(//div[@class='dx-radiobutton-icon'])[1]"); // чекбокс "Да" в фильтре "Наличие неоплаченных штрафов"
    protected By radiobuttonNoUnpaidMulct = By.xpath("(//div[@class='dx-radiobutton-icon'])[2]"); // чекбокс "Нет" в фильтре "Наличие неоплаченных штрафов"

    private final By loginField = By.xpath("//input[@type='text']"); // Поле для ввода логина
    private final By passwordField = By.xpath("//input[@type='password']"); // Поле для ввода пароля
    private final By fieldSearchInFilterEditor = By.xpath("//div[(contains(@class,'dx-item dx-multiview-item dx-item-selected'))]//input[@class='dx-texteditor-input']"); // Поле поиска внутри фильтра
    private final By fieldSearchFilters = By.xpath("//div[@id='tl-search-filters-textbox']//input"); // Поле поиска фильтров в блоке фильтров
    private final By listProductInCardContract = By.xpath("//div[@id='entity-card-items']//table//tr/following::td[1]"); // Название продукта в списке продуктов карточки контракта
    private final By listMulctInCardContract = By.xpath("//div[@id='entity-card-items']//div[@class='tl-card-item'][5]//table//tr/following::td[4]"); // Причина штрафа в списке штрафов карточки контракта
    private final By listSumMulctInCardContract = By.xpath("//div[@id='entity-card-items']//div[@class='tl-card-item'][5]//table//tr/following::td[5]"); // Сумма штрафа в списке штрафов карточки контракта
    private final By listPaidMulctInCardContract = By.xpath("//div[@id='entity-card-items']//div[@class='tl-card-item'][5]//table//tr/following::td[6]"); // Оплата штрафа в списке штрафов карточки контракта
    private final By noMulctInCardContract = By.xpath("(//div[@id='entity-card-items']//div[@class='tl-card-item'][5]//table//tr/following::td)[1]"); // Поле с подписью об отсутствии штрафов


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

    public void scrollDownTo(By scroll){
        ((JavascriptExecutor)getDriver()).executeScript(
                "arguments[0].scrollTop = -1 >>> 1", find(scroll));
    } // Прокрутить содержимое элемента вниз

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

    public void typeNameTender(String name){
        find(fieldNameTender).sendKeys(name);
    } // Ввести ключевое слово для поиска по названию тендера

    public void typeSearchFilters(String search){
        find(fieldSearchFilters).sendKeys(search);
    } // Ввести значение в поле поиска

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

    public WebElementFacade getCheckboxInFilter(int numberCheckbox){
        List<WebElementFacade> checkboxMineTenders = findAll(checkBoxFilter);
        return checkboxMineTenders.get(numberCheckbox);
    } // Получить чекбокс по его порядковому номеру в фильтре "Мои тендеры" у тендера или "Статус" у контракта

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
    } // Проверка наличия неоплаченных штрафов контракта

    public boolean isPaidMulct(){
        List<WebElementFacade> paidMulctForCheck = findAll(listPaidMulctInCardContract);
        for(WebElementFacade paidMulct : paidMulctForCheck){
//            System.out.println("Сумма: " + sumMulct.getText());
            String sumMulctCheck = paidMulct.getText();

            try {
                String checkNoMulctInCardContract = find(noMulctInCardContract).getText();
                if(checkNoMulctInCardContract.equals("Нет данных")){
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            float floatSumMulctCheckForCheck = Float.parseFloat(sumMulctCheck);
            if(floatSumMulctCheckForCheck == 0){
                return false;
            }
        }
        return true;
    } // Проверка отсутствия неоплаченных штрафов контракта

}
