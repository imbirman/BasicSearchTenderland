package pages;


import net.thucydides.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import java.util.ArrayList;
import java.util.List;

@DefaultUrl("https://test2.v2.tenderland.ru/Home/Landing")
public class AutoFilters extends PageObject {

    protected By tabListAutoSearch = By.id("tab-list-autosearches"); // Вкладка "Автопоиски"
    protected By openTabMenu = By.id("tl-main-nav"); // Кнопка открытия бокового меню
    protected By filterNameTender = By.xpath("//span[text()='Название тендера']"); // Фильтр "Название тендера" в блоке фильтров
    protected By filterOKPD = By.xpath("//span[text()='ОКПД 2']"); // Фильтр "ОКПД 2" в блоке фильтров
    protected By filterCategory = By.xpath("//span[text()='Категория']"); // Фильтр "Категория" в блоке фильтров
    protected By filterPrice = By.xpath("//span[text()='Цена']"); // Фильтр "Цена" в блоке фильтров
    protected By filterCustomer = By.xpath("//span[text()='Заказчик']"); // Фильтр "Заказчик" в блоке фильтров
    protected By filterDatePublication = By.xpath("//span[text()='Дата публикации']"); // Фильтр "Дата публикации" в блоке фильтров
    protected By filterModule = By.xpath("//span[text()='Модуль']"); // Фильтр "Модуль" в блоке фильтров
    protected By filterMark = By.xpath("//span[text()='Метка']"); // Фильтр "Метка" в блоке фильтров
    protected By filterInTreeCustomer = By.xpath("//span[@class='tl-filter-description']"); // Текст фильтра "Заказчик" в дереве фильтров
    protected By checkboxOKPD = By.xpath("(//div[@class='dx-checkbox-container'])[last()]"); // чекбокс фильтра ОКПД
    protected By checkboxSelectAll = By.xpath("(//div[@id='filter-editor-5']//div[@class='dx-datagrid-text-content']/div)[1]"); // Чекбокс в окне фильтра "Выбрать всё"  (//div[@id='filter-editor-5']//div[@class='dx-datagrid-text-content']/div)[1]
    protected By secondPage = By.xpath("//div[@class='dx-page']"); // Вторая страница списка в окне фильтра
    protected By checkboxShowOnlySelected = By.xpath("//div[@class='dx-switch-container']"); // Переключатель "Показывать только выбранное"
    protected By checkboxShowWithoutCategory = By.xpath("//div[@id='filter-editor-2-undefined_category']//span[@class='dx-checkbox-icon']"); // Чекбокс "Показывать без категории"
    protected By checkboxShowWithZeroPrice = By.xpath("//div[@id='filter-editor-compact-4-undefined_values']//span[@class='dx-checkbox-icon']"); // Чекбокс "Показывать с нулевой ценой"
    protected By comboboxDirection = By.xpath("//div[@id='selectbox-filter-editor-compact-5-type']//input[@class='dx-texteditor-input'][@role='combobox']"); // Комбобокс "Направление" во вкладке Диапазон фильтра "Дата публикации"
    protected By comboboxUnits = By.xpath("//div[@id='selectbox-filter-editor-compact-5-period']//input[@class='dx-texteditor-input'][@role='combobox']"); // Комбобокс "Единицы измерения" во вкладке Диапазон фильтра "Дата публикации"
    protected By comboboxRegionCustomer = By.xpath("//div[@id='filter-editor-5-region']//input[@class='dx-texteditor-input'][@role='combobox']"); // Комбобокс "Регион" фильтра "Заказчик"
    protected By buttonLogin = By.xpath("//span[text()='Войти']"); // Кнопка входа в систему
    protected By buttonSignIn = By.xpath("//span[text()='Войти в систему']"); // Кнопка "Войти в систему"
    protected By buttonApply = By.id("filter-apply-button"); // Кнопка "Применить"
    protected By buttonReset = By.id("filter-cancel-button"); // Кнопка "Сбросить"
    protected By buttonSearch = By.id("search-button"); // Кнопка "Поиск"
    protected By buttonCloseFilter = By.xpath("//i[@class='dx-icon dx-icon-close']"); // Крестик закрыть окно фильтра
    protected By fieldSearchInFilter = By.xpath("//div[(contains(@class,'dx-item dx-multiview-item dx-item-selected'))]//input[@class='dx-texteditor-input']"); // Поле поиска внутри фильтра
    protected By tabRangeInFilterDatePublication = By.id("nav-tab-tl-date-compact-filter"); // Вкладка "Диапазон" в фильтре "Дата публикации"
    protected By tabTextSearchInFilterCustomer = By.xpath("//div[@id='filter-editor-5-organizations-filter-tabs']//span[text()='ПОИСК ПО ТЕКСТУ']"); // Вкладка "Поиск по тексту" в фильтре "Заказчик"
    protected By elementOfComboboxCustomer = By.xpath("//div[@class='dx-item-content dx-list-item-content']"); // Элемент комбобокса фильтра "Заказчик"
    protected By redColorMark = By.xpath("(//div[@id='filter-editor-compact-26-values']//div[@role='option']/div/div)[1]"); // Метка "Красный"
    protected By blueColorMark = By.xpath("(//div[@id='filter-editor-compact-26-values']//div[@role='option']/div/div)[2]"); // Метка "Синий"
    protected By greenColorMark = By.xpath("(//div[@id='filter-editor-compact-26-values']//div[@role='option']/div/div)[3]"); // Метка "Зеленый"


    private By loginField = By.xpath("//input[@type='text']"); // Поле для ввода логина
    private By passwordField = By.xpath("//input[@type='password']"); // Поле для ввода пароля
    private By filterRoot = By.xpath("//div[@class='dx-sortable tl-filter-content tl-filter-drop-area']"); // Поле дерева фильтров
    private By resultSearchInFilter = By.xpath("//span[@class='dx-treelist-search-text']"); // результат поиска внутри фильтра
    private By fieldPriceFrom = By.xpath("//div[@id='filter-editor-compact-4-from']//input[@role='spinbutton']"); // Поле для ввода цены "от"
    private By fieldPriceTo = By.xpath("//div[@id='filter-editor-compact-4-to']//input[@role='spinbutton']"); // Поле для ввода цены "до"  (//div[@id='filter-editor-5']//tbody//td[@role='gridcell'])[last()]
    private By fieldSearchByCustomerTextSearch = By.xpath("//textarea[@class='dx-texteditor-input dx-texteditor-input-auto-resize']"); // Поле поиска внутри фильтра "Заказчик"
    private By fieldSearchByCustomer = By.xpath("//div[@id='filter-editor-5-search']//input[@role='textbox']"); // Поле поиска во вкладке "Выбор из справочника" внутри фильтра "Заказчик"
    private By fieldExcludeFromSearchByCustomer = By.xpath("//div[@id='exclude_block']//textarea[@class='dx-texteditor-input dx-texteditor-input-auto-resize']"); // Поле исключения из поиска внутри фильтра "Заказчик"
    private By fieldResultSelectMark = By.id("filter-editor-compact-26-result"); // Поле с выбранными метками
    private By resultShowOnlySelected = By.xpath("//div[@class='dx-treelist-text-content']"); // результат работы чекбокса "Показывать только выбранное"
    private By cellTableCategory = By.xpath("//div[@class='dx-datagrid-content']//tbody[@role='presentation']//td[7]//td"); // Ячейка таблицы в результатах поиска для столбца "Категория"
    private By cellTablePrice = By.xpath("//div[@class='dx-datagrid-content']//tbody[@role='presentation']//td[6]"); // Ячейка таблицы в результатах поиска для столбца "Цена"
    private By cellTableInsideFilterCustomerFullTitle = By.xpath("//div[@class='dx-datagrid-content']/table[@role='presentation']//tr[@class='dx-row dx-data-row dx-row-lines']/td[5]"); // Ячейка таблицы в результатах поиска для столбца "Полное название" внутри фильтра "Заказчик"
    private By cellTableInsideFilterCustomerFullTitleTextSearch = By.xpath("//div[@id='filter-editor-5search-block']//tbody[@role='presentation']//tr[@class='dx-row dx-data-row dx-row-lines']/td[4]"); //Ячейка таблицы в результатах поиска для столбца "Полное название" внутри фильтра "Заказчик" во вкладке "Поиск по тексту"
    private By elementOfCombobox = By.xpath("//div[@class='dx-item-content dx-list-item-content']"); // Элемент комбобокса во вкладке "Диапазон" фильтра "Дата публикации"
    private By elementOfFilterModule = By.xpath("//div[@class='dx-item-content dx-list-item-content']"); // Элемент списка фильтра "Модуль"
    private By elementOfSelectMark = By.xpath("(//div[@id='filter-editor-compact-26-result']//div[@role='option']/div[@class='dx-item-content dx-list-item-content']/div)"); // Выбранная метка
    private By fieldNameAutoSearch = By.xpath("//div[@id='tl-autosearch-name']//input"); // Поле ввода названия автопоиска

    public void waitFor(long number){
        waitABit(number);
    } // Ожидание

    public void clickButton(By button){
        find(button).click();
    } // Кликнуть по кнопке / выбрать radiobutton или checkbox

    public void clickButton(@NotNull WebElementFacade button){
        button.click();
    } // Кликнуть по кнопке / выбрать radiobutton или checkbox

    public void clearField(By field){find(field).clear();} // Очистить поле

    public void typeLogin(String login){
        find(loginField).sendKeys(login);
    } // Ввести логин для входа

    public void typePassword(String password){
        find(passwordField).sendKeys(password);
    } // Ввести пароль для входа

    public void typeSearch(String search){
        find(fieldSearchInFilter).sendKeys(search);
    } // Ввести значение в поле поиска

    public void typeSearchInsideFilterCustomerTextSearch(String search){
        find(fieldSearchByCustomerTextSearch).sendKeys(search);
        find(fieldSearchByCustomerTextSearch).sendKeys(Keys.ENTER);
    } // Ввести значение в поле поиска по тексту фильтра "Заказчик"

    public void typeSearchInsideFilterNameTender(String search){
        find(fieldSearchByCustomerTextSearch).sendKeys(search);
    } // Ввести значение в поле поиска по тексту фильтра "Заказчик"

    public void typeSearchInsideFilterCustomer(String search){
        find(fieldSearchByCustomer).sendKeys(search);
        find(fieldSearchByCustomer).sendKeys(Keys.ENTER);
    } // Ввести значение в поле поиска по реквизитам фильтра "Заказчик"

    public void typeExcludeFromSearchInsideFilterCustomer(String search){
        find(fieldExcludeFromSearchByCustomer).sendKeys(search);
        find(fieldExcludeFromSearchByCustomer).sendKeys(Keys.ENTER);
    } // Ввести значение в поле исключения из поиска по тексту фильтра "Заказчик"

    public void typePriceFrom(String price){
        find(fieldPriceFrom).sendKeys(price);
    } // Ввести значение в поле цены от

    public void typePriceTo(String price){
        find(fieldPriceTo).sendKeys(price);
    } // Ввести значение в поле цены до

    public void typeNameAutoSearch(String name){
        find(fieldNameAutoSearch).sendKeys(name);
    } // Ввести название автопоиска

    public void dragAndDropFilter(By filter){
        withAction().dragAndDrop(find(filter), find(filterRoot)).build().perform();
    } // Перетащить фильтр в область построения дерева фильтров

    public String getResultSearchByFilter(){
        return find(resultSearchInFilter).getText();
    } // Получить текст найденного значения в фильтре "ОКПД"

    public String getTextFieldPriceFrom(){
        return find(fieldPriceFrom).getValue();
    }// Получить текст поля "Цена от"

    public String getTextFieldPriceTo(){
        return find(fieldPriceTo).getValue();
    }// Получить текст поля "Цена до"

    public Integer getNumberListCombobox(){
        List<WebElementFacade> key = findAll(elementOfCombobox);
        return key.size();
    } // Количество элементов в списке комбобокса фильтра "Дата публикации"

    public Integer getNumberListModule(){
        List<WebElementFacade> key = findAll(elementOfFilterModule);
        return key.size();
    } // Количество элементов в списке фильтра "Модуль"

    public String getTextFilterInTreeCustomer(){
        return find(filterInTreeCustomer).getText();
    }// Получить текст фильтра "Заказчик" в дереве фильтров

    public AutoFilters scrollDownTo(By scroll){
        ((JavascriptExecutor)getDriver()).executeScript(
                "arguments[0].scrollTop = -1 >>> 1", find(scroll));
        return this;
    } // Прокрутить содержимое элемента вниз

    public boolean isResetResultSearchByFilterOKPD(){
        return find(resultSearchInFilter).isSelected();
    } // Получить текст найденного значения в фильтре "ОКПД"

    public boolean isNotContainKeyWordByOKPDNo(){
        List<WebElementFacade> keyWord = findAll(resultSearchInFilter);
//        keyWord.remove(keyWord.size()-1);
        boolean check = true;
        for(WebElementFacade type : keyWord){
            if(type.getText().contains("(85.11.10.000) Услуги в области дошкольного образования")){
//                System.out.println("Услуги: " + type.getText());
                check = false;
                break;
            }
        }
        return check;
    } // Проверка отображения поискового элемента при пустом поле поиска в фильтре ОКПД

    public boolean isNotContainKeyWordByOKPDYes(){
        List<WebElementFacade> keyWord = findAll(resultShowOnlySelected);
//        keyWord.remove(keyWord.size()-1);
        boolean check = false;
        for(WebElementFacade type : keyWord){
            if(type.getText().contains("(85.11.10.000) Услуги в области дошкольного образования")){
//                System.out.println("Услуги: " + type.getText());
                check = true;
                break;
            }
        }
        return check;
    } // Проверка отображения поискового элемента при выключенном чекбоксе "Показывать только выбранное" в фильтре ОКПД

    public boolean isContainEmptyCategory(){
        List<WebElementFacade> cellCategory = findAll(cellTableCategory);
        boolean check = false;
        for(WebElementFacade type : cellCategory){
            if(type.getText().contains("-")){
//                System.out.println("Услуги: " + type.getText());
                check = true;
                break;
            }
        }
        return check;
    } // Проверка результата поиска без категории в фильтре "Категория"

    public boolean isContainZeroPrice(){
        List<WebElementFacade> cellPrice = findAll(cellTablePrice);
        boolean check = false;
        for(WebElementFacade type : cellPrice){
            if(type.getText().contains("0.00")){
//                System.out.println("Услуги: " + type.getText());
                check = true;
                break;
            }
        }
        return check;
    } // Проверка отображения поискового элемента при включенном чекбоксе "Показывать с нулевой ценой"

    public boolean isContainKeyWordByTextSearchInsideFilterCustomer(){
        List<WebElementFacade> keyWord = findAll(cellTableInsideFilterCustomerFullTitleTextSearch);
//        keyWord.remove(keyWord.size()-1);
        boolean check = true;
        for(WebElementFacade type : keyWord){
            if(!(type.getText().contains("ЗАКУПАЙ"))){
//                System.out.println("Название: " + type.getText());
                check = false;
                break;
            }
        }
        return check;
    } // Проверка поиска по тексту внутри фильтра "Заказчик"

    public boolean isContainKeyWordBySearchInsideFilterCustomer(){
        List<WebElementFacade> keyWord = findAll(cellTableInsideFilterCustomerFullTitle);
//        keyWord.remove(keyWord.size()-1);
        boolean check = true;
        for(WebElementFacade type : keyWord){
            if(!(type.getText().contains("ИНДИВИДУАЛЬНЫЙ ПРЕДПРИНИМАТЕЛЬ МАЛОВА НАТАЛЬЯ БОРИСОВНА"))){
//                System.out.println("Название: " + type.getText());
                check = false;
                break;
            }
        }
        return check;
    } // Проверка поиска по тексту внутри фильтра "Заказчик"

    public boolean isContainKeyWordByRegionSearchInsideFilterCustomer(){
//        List<WebElementFacade> keyWord = findAll(cellTableInsideFilterCustomerFullTitle);
//        keyWord.remove(keyWord.size()-1);
        boolean check = true;
        String checkWord = find(cellTableInsideFilterCustomerFullTitle).getText();

        if(!(checkWord.contains("ИНДИВИДУАЛЬНЫЙ ПРЕДПРИНИМАТЕЛЬ КРАСНОГИР МАРИНА ВАСИЛЬЕВНА"))){
            System.out.println("Название: " + checkWord);
            check = false;
//                break;
        }

        return check;
    } // Проверка поиска по региону внутри фильтра "Заказчик"

    public boolean isNotContainKeyWordBySearchInsideFilterCustomer(){
        List<WebElementFacade> keyWord = findAll(cellTableInsideFilterCustomerFullTitleTextSearch);
        boolean check = true;
        for(WebElementFacade type : keyWord){
            if(type.getText().contains("58")){
//                System.out.println("Название: " + type.getText());
                check = false;
                break;
            }
        }
        return check;
    } // Проверка поиска по тексту внутри фильтра "Заказчик" при исключении из поиска

    public boolean isNotSelectedButtonAllSelect(){
        return find(checkboxSelectAll).getAttribute("class").contains("dx-widget dx-checkbox dx-state-hover dx-checkbox-checked");
    } // Проверка выделения чекбокса "Выбрать всё" в фильтре "Заказчик"

    public boolean isContainTypesDirection(){
        List<String> keyRange = findAll(elementOfCombobox).texts();
        List<String> checkArray = new ArrayList<>();
        checkArray.add("Предыдущий");
        checkArray.add("Следующий");
        return keyRange.equals(checkArray);
    } // Проверка на соответствие списка направлений в фильтре "Дата публикации"

    public boolean isContainTypesUnits(){
        List<String> keyUnits = findAll(elementOfCombobox).texts();
        List<String> checkArray = new ArrayList<>();
        checkArray.add("День");
        checkArray.add("Неделя");
        checkArray.add("Месяц");
        checkArray.add("Год");
        return keyUnits.equals(checkArray);
    } // Проверка на соответствие списка единиц измерений в фильтре "Дата публикации"

    public boolean isContainTypesModule(){
        List<String> keyModule = findAll(elementOfFilterModule).texts();
        List<String> checkArray = new ArrayList<>();
        checkArray.add("Государственные тендеры");
        checkArray.add("Коммерческие тендеры");
        checkArray.add("СНГ");
        checkArray.add("Реализация имущества");
        return keyModule.equals(checkArray);
    } // Проверка на соответствие списка модулей в фильтре "Модуль"

    public boolean isContainSelectMark(){
        List<String> keyMark = findAll(elementOfSelectMark).texts();
        List<String> checkArray = new ArrayList<>();
        checkArray.add("Красный");
        checkArray.add("Синий");
        checkArray.add("Зеленый");
        return keyMark.equals(checkArray);
    } // Проверка на соответствие выбранных меток

}
