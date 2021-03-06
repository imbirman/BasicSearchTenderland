package pages;


import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import java.util.List;

@DefaultUrl("https://test2.v2.tenderland.ru/Home/Landing")
public class GeneralChecks extends PageObject {

    protected By openTabMenu = By.id("tl-main-nav"); // Кнопка открытия бокового меню
    protected By logInButton = By.xpath("//span[text()='Войти']"); // Кнопка входа в систему
    protected By signInButton = By.xpath("//span[text()='Войти в систему']"); // Кнопка "Войти в систему"
    protected By tabListAutoSearch = By.id("tab-list-autosearches"); // Вкладка "Автопоиски"
    protected By listAutoSearchToScroll = By.xpath("//div[@id='tl-scroll-tabs']//div[@class='dx-scrollable-container']"); // Блок автопоисков для прокрутки list-autosearches

    protected By buttonCheckTenderNameAndNameDeletion = By.xpath("//span[text()='Проверка поиска по названию тендера и исключению из названия']"); // Кнопка автопоиска "Проверка поиска по названию тендера и исключению из названия"
    protected By buttonCheckHideResultSearch = By.xpath("//span[text()='Проверка скрытия результатов поиска']"); // Кнопка автопоиска "Проверка скрытия результатов поиска"
    protected By buttonSearch = By.id("search-button"); // Кнопка "Поиск"
    protected By buttonOpenShowHideEntities = By.id("show-hide-entities-button"); // Кнопка открытия окна для отображения скрытых результатов поиска
    protected By buttonSwitchShowHideEntities = By.id("show-hide-entities-swith"); // Кнопка смены отображения скрытых результатов поиска
    protected By buttonOpenHiddenDataControl = By.xpath("//a[@class='tl-highlite-link']"); // Открыть "Управление скрытыми данными"
    protected By buttonDeleteHiddenTender = By.xpath("//a[@title='Удалить']"); // Кнопка "Удалить" в окне управления скрытыми данными
    protected By buttonAcceptDeleteHiddenTender = By.xpath("//span[text()='Да']"); // Кнопка подтверждения удаления тендера из скрытых
    protected By buttonCloseWindowHiddenDataControl = By.xpath("//i[@class='dx-icon dx-icon-close']"); // Кнопка закрытия окна управления скрытыми данными

    protected By filterAndOr = By.xpath("//span[@class='tl-filter-visual-group-name']"); // фильтр логики И/ИЛИ

    protected By checkboxSelectAllSearchResult = By.xpath("(//div[@id='search-result']//div[@class='dx-checkbox-container'])[1]"); // Чекбокс "Выбрать всё" в таблице результата поиска

    protected By secondPageSearch = By.xpath("//div[@class='dx-page']"); // Вторая страница таблицы результата поиска
    protected By contextMenuResultSearch = By.xpath("//a[@class='dx-link dx-icon-overflow dx-link-icon']"); // Кнопка контекстного меню для строки результата поиска
    protected By hideContextMenu = By.xpath("//div[text()='Скрыть тендер']"); // пункт контекстного меню "Скрыть тендер"
    protected By addInMineTendersContextMenu = By.xpath("//div[text()='Добавить в Мои тендеры']"); // пункт контекстного меню "Добавить в Мои тендеры"
    protected By markContextMenu = By.xpath("//div[text()='Метка тендера']"); // пункт контекстного меню "Метка тендера"
    protected By showTenderContextMenu = By.xpath("//div[text()='Показывать тендер']"); // Пункт контекстного меню "Показывать тендер"

    private final By checkLogin = By.xpath("//ul[@class='navbar-nav']//a"); // объект для проверки логина после входа
    private final By loginField = By.xpath("//input[@type='text']"); // Поле для ввода логина
    private final By passwordField = By.xpath("//input[@type='password']"); // Поле для ввода пароля
    private final By hintArea = By.xpath("//div[@class='dx-sortable tl-filter-content tl-filter-drop-area']"); // Область подсказки
    private final By filterRoot = By.xpath("//div[@class='dx-sortable tl-filter-content tl-filter-drop-area']"); // Поле дерева фильтров
    private final By cellTableForCheckRegistryNumber = By.xpath("//div[@class='dx-datagrid-content']/table[@role='presentation']//tr[@class='dx-row dx-data-row dx-row-lines']/td[4]"); // Ячейка таблицы результатов поиска для проверки реестрового номера
    private final By hiddenCellTableForCheckRegistryNumber = By.xpath("//div[@class='dx-datagrid-content']/table[@role='presentation']//tr[@class='dx-row dx-data-row dx-row-lines tl-hidden-row']/td[4]"); // Скрытая ячейка таблицы результатов поиска для проверки реестрового номера
    private final By fieldDescriptionHideTender = By.id("show-hide-entities-description"); // Подпись кнопки переключения показа скрытых тендеров

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
            if(type.contains("100154727119000142")){check = false; break;}
        }
        return check;
    } // Проверка не отображения в результатах поиска скрытого элемента

    public boolean isContainHideTender(){
        List<String> textCheck = findAll(hiddenCellTableForCheckRegistryNumber).texts();
        boolean check = false;
        for(String type : textCheck){
            if(type.contains("100154727119000142")){check = true; break;}
        }
        return check;
    } // Проверка отображения в результатах поиска скрытого элемента

    public boolean isContainNumberHideTenderDescription(){
        return find(fieldDescriptionHideTender).containsText("1");
    } // Проверка подписи кнопки переключения отображения скрытых тендеров

    public boolean isContainNotHideTender(){
        List<String> textCheck = findAll(cellTableForCheckRegistryNumber).texts();
        boolean check = false;
        for(String type : textCheck){
            if(type.contains("100154727119000142")){check = true; break;}
        }
        return check;
    } // Проверка отображения в результатах поиска удаленного из скрытых элемента

}
