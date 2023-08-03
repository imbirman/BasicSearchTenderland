package pages;


import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import java.util.List;

@DefaultUrl("https://test.v2.tenderland.ru/Home/Landing")
public class GeneralChecks extends PageObject {

    protected By openTabMenu = By.xpath("//i[@class='material-icons-round icon-28px icon-grey md-menu icon-grey-hover common-header-icon']"); // Кнопка открытия бокового меню
    protected By logInButton = By.xpath("//a[text()='Войти']"); // Кнопка входа в систему
    protected By signInButton = By.xpath("//span[text()='Войти в систему']"); // Кнопка "Войти в систему"
    protected By tabListAutoSearch = By.xpath("//div[@class='search-filters-tab list-autosearches']"); // Вкладка "Автопоиски"
    protected By listAutoSearchToScroll = By.xpath("//div[@id='list-autosearches']//div[@class='dx-scrollable-container']"); // Блок автопоисков для прокрутки

    protected By buttonCheckTenderNameAndNameDeletion = By.xpath("//div[text()='Проверка поиска по названию тендера и исключению из названия']"); // Кнопка автопоиска "Проверка поиска по названию тендера и исключению из названия"
    protected By buttonCheckHideResultSearch = By.xpath("//div[text()='Проверка скрытия результатов поиска']"); // Кнопка автопоиска "Проверка скрытия результатов поиска"
    protected By buttonSearch = By.id("search-filters-search-button"); // Кнопка "Поиск"
    protected By buttonOpenShowHideEntities = By.id("search-panel-hidden-entities"); // Кнопка открытия окна для отображения скрытых результатов поиска
    protected By buttonSwitchShowHideEntities = By.id("show-hide-entities-swith"); // Кнопка смены отображения скрытых результатов поиска
    protected By buttonOpenHiddenDataControl = By.xpath("//a[@class='tl-highlite-link']"); // Открыть "Управление скрытыми данными"
    protected By buttonDeleteHiddenTender = By.xpath("//a[@title='Удалить']"); // Кнопка "Удалить" в окне управления скрытыми данными
    protected By buttonAcceptDeleteHiddenTender = By.xpath("//span[text()='Да']"); // Кнопка подтверждения удаления тендера из скрытых
    protected By buttonCloseWindowHiddenDataControl = By.xpath("//i[@class='dx-icon dx-icon-close']"); // Кнопка закрытия окна управления скрытыми данными
    protected By buttonClearBuildingFieldSearch = By.xpath("//span[text()='Очистить поле']"); // Кнопка очистки поля построения фильтров

    protected By filterAndOr = By.xpath("//div[@id='tl-filter-root']//span"); // фильтр логики И/ИЛИ

    protected By secondPageSearch = By.xpath("//div[@class='dx-page']"); // Вторая страница таблицы результата поиска
    protected By contextMenuResultSearch = By.xpath("//table[@class='dx-datagrid-table dx-pointer-events-none dx-datagrid-table-fixed']//a[@class='dx-link dx-icon-overflow dx-link-icon']"); // Кнопка контекстного меню для строки результата поиска
    protected By hideContextMenu = By.xpath("//div[text()='Скрыть тендер']"); // пункт контекстного меню "Скрыть тендер"
    protected By addInMineTendersContextMenu = By.xpath("//div[text()='Добавить в Мои тендеры']"); // пункт контекстного меню "Добавить в Мои тендеры"
    protected By markContextMenu = By.xpath("//div[text()='Метка тендера']"); // пункт контекстного меню "Метка тендера"
    protected By showTenderContextMenu = By.xpath("//div[text()='Показать тендер']"); // Пункт контекстного меню "Показывать тендер"
    protected By checkBoxSelectedAllForTableResultSearch = By.xpath("//div[@id='search-result-checkbox']/div"); // Чекбокс "Выбрать всё" для таблицы результата поиска

    private final By checkLogin = By.xpath("//ul[@class='navbar-nav']//a"); // объект для проверки логина после входа
    private final By loginField = By.xpath("//input[@type='text']"); // Поле для ввода логина
    private final By passwordField = By.xpath("//input[@type='password']"); // Поле для ввода пароля
    private final By hintArea = By.xpath("//div[@class='dx-sortable tl-filter-content tl-filter-drop-area']"); // Область подсказки
    private final By filterRoot = By.xpath("//div[@class='dx-sortable tl-filter-content tl-filter-drop-area']"); // Поле дерева фильтров
    private final By cellTableForCheckRegistryNumber = By.xpath("//div[@class='dx-datagrid-content']/table[@role='presentation']//tr[@class='dx-row dx-data-row dx-row-lines']/td[4]/div"); // Ячейка таблицы результатов поиска для проверки реестрового номера
    private final By hiddenCellTableForCheckRegistryNumber = By.xpath("//div[@class='dx-datagrid-content']/table[@role='presentation']//tr[@class='dx-row dx-data-row dx-row-lines search-result-hidden-row']/td[4]"); // Скрытая ячейка таблицы результатов поиска для проверки реестрового номера
    private final By selectionCounter = By.id("search-panel-selection-counter"); // Пометка количества выбранных тендеров


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

    public GeneralChecks scrollElementOnPixels(String number, By scroll){
        ((JavascriptExecutor)getDriver()).executeScript(
                "arguments[0].scrollBy(0," + number + ")", find(scroll));
        return this;
    } // Прокрутить на заданное количество пикселей

    public GeneralChecks scrollWindowOnPixels(String number){
        ((JavascriptExecutor)getDriver()).executeScript(
                "window.scrollBy(0," + number + ")");
        return this;
    } // Прокрутить окно на заданное количество пикселей

    public void clickButton(WebElementFacade button){
        button.click();
    } // Кликнуть по кнопке / выбрать radiobutton или checkbox

    public void typeLogin(String login){
        find(loginField).sendKeys(login);
    } // Ввести логин для входа

    public void typePassword(String password){
        find(passwordField).sendKeys(password);
    } // Ввести пароль для входа

    public String getTextLogin(){
        return find(checkLogin).getText();
    } // Получение названия логина после входа

    public boolean isCorrectHintAreaAnd(){
        String checkWord = find(hintArea).getText();

        return checkWord.contains("Перенесите в область фильтры\n" +
                "которые должны работать\n" +
                "по логике \"И\"");
    } // Проверка области подсказки для фильтра И

    public boolean isCorrectHintAreaOr(){
        String checkWord = find(hintArea).getText();

        return checkWord.contains("Перенесите в область фильтры\n" +
                "которые должны работать\n" +
                "по логике \"ИЛИ\"");
    } // Проверка области подсказки для фильтра ИЛИ при смене с фильтра И

    public boolean isNameElementsContextMenu(){
        return find(hideContextMenu).isPresent() && find(addInMineTendersContextMenu).isPresent() && find(markContextMenu).isPresent();
    } // Проверка контекстного меню на второй странице после выбора всех элементов на первой странице

    public boolean isNotContainHideTender(){
        List<String> textCheck = findAll(cellTableForCheckRegistryNumber).texts();
        boolean check = true;
        for(String type : textCheck){
            if(type.contains("32008750757")){check = false; break;}
        }
        return check;
    } // Проверка не отображения в результатах поиска скрытого элемента

    public boolean isContainHideTender(){
        List<String> textCheck = findAll(hiddenCellTableForCheckRegistryNumber).texts();
        boolean check = false;
        for(String type : textCheck){
            if(type.contains("32008750757")){check = true; break;}
        }
        return check;
    } // Проверка отображения в результатах поиска скрытого элемента

    public boolean isContainNotHideTender(){
        List<String> textCheck = findAll(cellTableForCheckRegistryNumber).texts();
        boolean check = false;
        for(String type : textCheck){
            if(type.contains("32008750757")){check = true; break;}
        }
        return check;
    } // Проверка отображения в результатах поиска удаленного из скрытых элемента

    public boolean isNotSelectedCheckBoxSelectedAllForResultSearch(){
        return find(checkBoxSelectedAllForTableResultSearch).isSelected();
    }// Проверка чекбокса 'Выбрать всё' для результатов поиска после нажатия на кнопку 'Очистить поле'

    public boolean isDisplayedSelectionCounter(){
        return find(selectionCounter).isDisplayed();
    } // Проверка отображения счетчика выбранных тендеров в поиске

}
