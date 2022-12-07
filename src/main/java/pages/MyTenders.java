package pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import java.util.ArrayList;
import java.util.List;

@DefaultUrl("https://test.v2.tenderland.ru/Home/Landing")
public class MyTenders extends PageObject {

    protected By openTabMenu = By.id("tl-main-nav"); // Кнопка открытия бокового меню
    protected By tabListAutoSearch = By.id("tab-list-autosearches"); // Вкладка "Автопоиски"
    protected By tabCards = By.xpath("//div[@id='favourite-select-tabs']//div[text()='Карточки']"); // Главная вкладка "Карточки"
    protected By tabTable = By.xpath("//div[@id='favourite-select-tabs']//div[text()='Таблица']"); // Главная вкладка "Таблица"
    protected By tabCalendar = By.xpath("//div[@id='favourite-select-tabs']//div[text()='Календарь']"); // Главная вкладка "Календарь"

    protected By contextMenuResultSearchForTestAddingAndDeleteTender = By.xpath("(//a[@class='dx-link dx-icon-overflow dx-link-icon'])[3]"); // Кнопка контекстного меню для строки результата поиска для добавления в мои тендеры
    protected By contextMenuColumn = By.xpath("//div[@class='favourite-kanban-list-title']/i"); // Кнопка контекстного меню столбца

    protected By fieldSecondColumnForDragAndDrop = By.xpath("(//div[@class='dx-treelist-content dx-sortable dx-sortable-without-handle'])[2]"); // Поле второго столбца для перетаскивания тендера
    protected By fieldFirstColumnForDragAndDrop = By.xpath("(//div[@class='dx-treelist-content dx-sortable dx-sortable-without-handle'])[1]"); // Поле первого столбца для перетаскивания тендера

    protected By fieldEntryNoticeInCardTender = By.xpath("//div[@id='favourite-card-notice']//input"); // Поле для ввода заметки в карточке тендера
    protected By firstFieldEntryNoticeInTabTable = By.xpath("(//div[@id='favourite-table']//input[@role='textbox'])[1]"); // Поле для первого тендера для ввода заметки во вкладке "Таблица"

    protected By openCardFirstTender = By.xpath("//div[@class='dx-treelist-text-content']/div[@class='favourite-kanban-card']"); // Открыть карточку первого тендера

    protected By userTestInListUsersTabTable = By.xpath("(//div[@class='dx-item-content dx-list-item-content'])[1]"); // Выбор тестового пользователя в качестве ответственного для первого тендера, вкладка "Таблица"
    protected By userAdminInListUsersTabTable = By.xpath("(//div[@class='dx-item-content dx-list-item-content'])[2]"); // Выбор пользователя "Админ" в качестве ответственного для первого тендера, вкладка "Таблица"
    protected By userTestInCardTender = By.xpath("(//div[@class='favourite-executor-fullname'])[1]"); // Выбор тестового пользователя в качестве ответственного для первого тендера в карточке тендера
    protected By userAdminInCardTender = By.xpath("(//div[@class='favourite-executor-fullname'])[2]"); // Выбор пользователя "Админ" в качестве ответственного для первого тендера в карточке тендера

    protected By buttonLogin = By.xpath("//span[text()='Войти']"); // Кнопка входа в систему
    protected By buttonSignIn = By.xpath("//span[text()='Войти в систему']"); // Кнопка "Войти в систему"
    protected By buttonSearch = By.id("search-button"); // Кнопка поиска
    protected By buttonTabMenuMyTenders = By.xpath("(//div[@class='tl-sidenav-item'])[2]//div"); // Кнопка в боковом меню "Мои тендеры"
    protected By buttonInAutoSearchListCheckMyTenders = By.xpath("//span[text()='Проверка моих тендеров']"); // Автопоиск "Проверка моих тендеров"
    protected By buttonCloseCardTender = By.xpath("//i[@class='dx-icon dx-icon-close']"); // Кнопка закрытия карточки тендера

    protected By buttonDeleteAddedTenderInListTenders = By.xpath("(//div[@class='favourite-kanban-delete-favourite'])[1]"); // Кнопка удаления добавленного тендера в списке тендеров
    protected By buttonDeleteTenderInListTenders = By.xpath("//div[@class='favourite-kanban-delete-favourite']"); // Кнопка удаления тендера в списке тендеров
    protected By buttonConfirmDelete = By.id("tl-popup-approve-button"); // Кнопка подтверждения удаления тендера
    protected By buttonDeleteContextMenuColumn = By.xpath("(//div[@class='dx-submenu']//div[@role='menuitem'])[3]"); // Кнопка "Удалить" контекстного меню столбца

    protected By buttonAddColumn = By.id("favourite-kanban-add-stage"); // Кнопка добавления столбца

    protected By buttonChangeTagInCardTender = By.xpath("//div[@class='favourite-card-control-icons']//i[@class='mdi mdi-24px mdi-tag-outline']"); // Кнопка смены метки в карточке тендера
    protected By buttonChangeResponsibleInCardTender = By.xpath("//div[@id='favourite-tender-select-responsible']//div[@class='dx-texteditor-container']//input"); // Ответственный за тендер в карточке тендера
    protected By buttonChangeResponsibleInTabTable = By.xpath("(//div[@class='dx-scrollable-wrapper']//div[@class='dx-texteditor-input-container']//input)[1]"); // Кнопка смены ответственного у первого элемента на вкладке "Таблица"

    private final By loginField = By.xpath("//input[@type='text']"); // Поле для ввода логина
    private final By passwordField = By.xpath("//input[@type='password']"); // Поле для ввода пароля

    private final By elementContextMenuColumn = By.xpath("//div[@class='favourite-kanban-context-menu-item']"); // Элемент контекстного меню столбца

    private final By buttonAddInMyTenders = By.xpath("//div[text()='Добавить в Мои тендеры']"); // Кнопка добавления в "Мои тендеры"
    private final By buttonSelectNameResponsibleToAddInMyTenders = By.xpath("//div[text()='Админ']"); // Выбор ответственного при добавлении тендера в "Мои тендеры"
    private final By buttonLoadDocumentationInListTenders = By.xpath("(//div[@class='favourite-kanban-load-documents'])[1]"); // Кнопка для скачивания документации тендера в списке тендеров
    private final By buttonLinkOfSourceInCard = By.id("favourites-card-link"); // Кнопка "Ссылка на источник"
    private final By buttonDeleteTenderInCard = By.xpath("//i[@class='mdi mdi-24px mdi-delete-outline']"); // Кнопка "Удалить тендер"

    private final By registerNumberAddedTenderInListTenders = By.xpath("(//div[@class='favourite-kanban-card-regnumber'])[1]"); // Регистрационный номер добавленного тендера в списке тендеров
    private final By registerNumberTenderInListTendersForFirstColumn = By.xpath("(//div[@class='favourite-kanban-list'])[1]//div[@class='favourite-kanban-card-regnumber']"); // Регистрационный номер тендера в списке тендеров в первом столбце
    private final By registerNumberTenderInListTendersForSecondColumn = By.xpath("(//div[@class='favourite-kanban-list'])[2]//div[@class='favourite-kanban-card-regnumber']"); // Регистрационный номер тендера в списке тендеров во втором столбце

    private final By nameAddedTenderInListTenders = By.xpath("(//div[@class='favourite-kanban-card-name'])[1]"); // Название добавленного тендера
    private final By nameSecondColumn = By.xpath("(//div[@class='favourite-kanban-list-title']/div)[2]"); // Название второго столбца

    private final By windowApproveDelete = By.xpath("//div[@class='tl-popup-wrapper tl-approve']"); // Окно подтверждения удаления
    private final By elementListColumns = By.xpath("//div[@class='favourite-kanban-list']"); // Столбец
    private final By fieldNameColumn = By.xpath("//div[@class='favourite-kanban-list']//input"); // Поле для ввода названия столбца
    private final By panelTenderInCardTender = By.id("tender-tab-panel"); // Панель тендера в карточке тендера
    private final By tabInCardTender = By.xpath("//div[@class='dx-popup-content']//div[contains(@class, 'dx-item dx-tab')]"); // Вкладка в карточке тендера





    public void waitFor(long number){
        waitABit(number);
    } // Ожидание

    public void clickButton(By button){
        find(button).click();
    } // Кликнуть по кнопке / выбрать radiobutton или checkbox

    public void clickButton(@NotNull WebElementFacade button){
        button.click();
    } // Кликнуть по кнопке / выбрать radiobutton или checkbox

    public void doubleClickButton(By button){
//        find(button).click();
        try {
            withAction().doubleClick(find(button)).build().perform();
        } catch (Exception e) {
            e.printStackTrace();
        }
    } // Двойной клик

    public void switchToTab(){

        for(String windowHandle : getDriver().getWindowHandles()) {
            getDriver().switchTo().window(windowHandle);
        }
    } // Переключиться на следующую вкладку

    public void dragAndDropTenderToSecondColumn(WebElementFacade tender, By field){
        withAction().dragAndDrop(tender, find(field)).build().perform();
    } // Перетащить фильтр в область построения дерева фильтров

    public void scrollDownTo(By scroll){
        ((JavascriptExecutor)getDriver()).executeScript(
                "arguments[0].scrollTop = -1 >>> 1", find(scroll));
    } // Прокрутить содержимое элемента вниз

    public void clearField(By field){find(field).clear();} // Очистить поле

    public void typeLogin(String login){
        find(loginField).sendKeys(login);
    } // Ввести логин для входа

    public void typePassword(String password){
        find(passwordField).sendKeys(password);
    } // Ввести пароль для входа

    public void typeNameColumn(String name){
        find(fieldNameColumn).sendKeys(name);
        find(fieldNameColumn).sendKeys(Keys.ENTER);
    } // Ввести название столбца

    public void typeNoticeInCardTender(String notice){
        find(fieldEntryNoticeInCardTender).sendKeys(notice);
        find(fieldEntryNoticeInCardTender).sendKeys(Keys.ENTER);
    } // Ввести заметку в карточке тендера

    public void typeNoticeInTabTable(String notice){
        find(firstFieldEntryNoticeInTabTable).sendKeys(notice);
        find(firstFieldEntryNoticeInTabTable).sendKeys(Keys.ENTER);
    } // Ввести заметку во вкладке "Таблица"

    public void moveToElement(By element){
        moveTo(element);
    } // Навести курсор на элемент

    public void addInMyTenders(){
        find(contextMenuResultSearchForTestAddingAndDeleteTender).click();
        moveToElement(buttonAddInMyTenders);
        find(buttonSelectNameResponsibleToAddInMyTenders).click();
    } // Добавить тендер в "Мои тендеры"

    public void deleteSecondColumn(){
        int sumColumn = findAll(contextMenuColumn).size();
        try {
            if(sumColumn==2){
                findAll(contextMenuColumn).get(1).click();
                find(buttonDeleteContextMenuColumn).click();
                find(buttonConfirmDelete).click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    } // Удалить столбец

    public Integer getNumberColumns(){
        return findAll(elementListColumns).size();
    } // Получить количество столбцов


    public String getNameSecondColumn(){
        return find(nameSecondColumn).getText();
    } // Получить название второго столбца

    public Integer getNumberTabInCardTender(){
        return findAll(tabInCardTender).size();
    } // Получить количество вкладок в карточке тендера

    public WebElementFacade getTenderByNumberInColumn(int number, int numberColumn){
        if (numberColumn==1) {

                List<WebElementFacade> listTendersInFirstColumn = findAll(registerNumberTenderInListTendersForFirstColumn);
                return listTendersInFirstColumn.get(number - 1);
        }

        return find(registerNumberTenderInListTendersForSecondColumn);

    } // Получить тендер по его порядковому номеру

    public String getResponsibleInCardTender(){
        return find(buttonChangeResponsibleInCardTender).getValue();
    } // Получение значение ответственного в карточке тендера

    public String getResponsibleInTabTable(){
        return find(buttonChangeResponsibleInTabTable).getValue();
    } // Получение значения ответственного у первого тендера во вкладке "Таблица"

    public String getRegisterNumberAddedTender(){
        return find(registerNumberAddedTenderInListTenders).getText();
    } // Проверка номера добавленного тендера

    public boolean isCheckNameAddedTender(){
        return find(nameAddedTenderInListTenders).getText().equals("Приобретение мешков для мусора");
    } // Проверка названия добавленного тендера

    public boolean isCheckDeleteAddedTender(){
        boolean check = true;
        List<String> elementForCheck = findAll(registerNumberTenderInListTendersForFirstColumn).texts();
        for(String element: elementForCheck){
            if(element.equals("0372200015221000002")){check = false; break;}
        }
        return check;
    } // Проверка удаления добавленного тендера

    public boolean isCheckClickableButtonDeleteTenderInListTenders(){
        return find(buttonDeleteTenderInListTenders).isClickable();
    } // Проверка кликабельности кнопки удаления тендера в списке тендеров

    public boolean isCheckClickableButtonLoadDocumentationTenderInListTenders(){
        return find(buttonLoadDocumentationInListTenders).isClickable();
    } // Проверка кликабельности кнопки скачивания документации тендера в списке тендеров

    public boolean isCheckClickableButtonChangeTag(){
        return find(buttonChangeTagInCardTender).isClickable();
    } // Проверка кликабельности кнопки смены метки в карточке тендера

    public boolean isCheckClickableButtonLinkSource(){
        return find(buttonLinkOfSourceInCard).isClickable();
    } // Проверка кликабельности кнопки ссылки на источник в карточке тендера

    public boolean isCheckClickableButtonDeleteTenderInCard(){
        return find(buttonDeleteTenderInCard).isClickable();
    } // Проверка кликабельности кнопки удаления тендера в карточке тендера

    public boolean isCheckClickableTabCards(){
        return find(tabCards).isClickable();
    } // Проверка кликабельности главной вкладки "Карточки"

    public boolean isCheckClickableTabTable(){
        return find(tabTable).isClickable();
    } // Проверка кликабельности главной вкладки "Таблица"

    public boolean isCheckClickableTabCalendar(){
        return find(tabCalendar).isClickable();
    } // Проверка кликабельности главной вкладки "Календарь"

    public boolean isCheckDisableButtonDeleteContextMenuColumn(){
        return find(buttonDeleteContextMenuColumn).getAttribute("class").contains("dx-state-disabled");
    } // Проверка некликабельности кнопки "Удалить" контекстного меню столбца

    public boolean isCheckButtonsContextMenuColumn(){
        List<String> elements = findAll(elementContextMenuColumn).texts();
        List<String> elementsForCheck = new ArrayList<>();
        elementsForCheck.add("Переместить все");
        elementsForCheck.add("Выгрузить");
        elementsForCheck.add("Удалить");
        return elements.equals(elementsForCheck);
    } // Проверка кнопок контекстного меню столбца

    public boolean isCheckVisibleWindowApproveDelete(){
        return find(windowApproveDelete).isVisible();
    } // Проверка появления окна подтверждения удаления

    public boolean isCheckVisibleCard(){
        return find(panelTenderInCardTender).isVisible();
    } // Проверка отображения карточки тендера

    public boolean isCheckDragAndDropTender(){
        boolean checkFirstColumn = false;
        boolean checkSecondColumn = false;
        List<String> firstColumn = findAll(registerNumberTenderInListTendersForFirstColumn).texts();
        List<String> secondColumn = findAll(registerNumberTenderInListTendersForSecondColumn).texts();

        if(!firstColumn.contains("100006854121100011")){
            checkFirstColumn = true;
        }

        if(secondColumn.contains("100006854121100011")){
            checkSecondColumn = true;
        }
        return checkFirstColumn && checkSecondColumn;
    } // Проверка на отсутствие или наличие перетаскиваемого тендера в столбцах

    public boolean isCheckMaxLengthNameColumn(){
        return find(nameSecondColumn).getText().length() == 25;
    } // Проверка максимальной длины названия столбца

    public boolean isCheckNoticeInTabTable(){
        return find(firstFieldEntryNoticeInTabTable).getValue().equals("тестовая заметка");
    } // Проверка заметки во вкладке "Таблица"

    public boolean isCheckNoticeInCardTender(){
        return find(fieldEntryNoticeInCardTender).getValue().equals("тестовая заметка");
    } // Проверка заметки в карточке тендера



}
