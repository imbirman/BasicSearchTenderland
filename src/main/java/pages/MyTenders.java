package pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import java.util.List;

@DefaultUrl("https://test2.v2.tenderland.ru/Home/Landing")
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

    protected By filterUsers = By.xpath("//div[@id='favourite-search-select-child-user']//input"); // Поле выбора пользователя в фильтре "Пользователи"
    protected By firstElementInListFilter = By.xpath("(//div[@class='dx-item dx-list-item'])[1]"); // Первый пункт в списке фильтра
    protected By openCardFirstTender = By.xpath("//div[@class='dx-treelist-text-content']/div[@class='favourite-kanban-card']"); // Открыть карточку первого тендера

    protected By userTestInListUsersTabTable = By.xpath("(//div[@class='dx-item-content dx-list-item-content'])[1]"); // Выбор тестового пользователя в качестве ответственного для первого тендера, вкладка "Таблица"
    protected By userAdminInListUsersTabTable = By.xpath("(//div[@class='dx-item-content dx-list-item-content'])[2]"); // Выбор пользователя "Админ" в качестве ответственного для первого тендера, вкладка "Таблица"
    protected By userTestInCardTender = By.xpath("(//div[@class='favourite-executor-fullname'])[1]"); // Выбор тестового пользователя в качестве ответственного для первого тендера в карточке тендера
    protected By userAdminInCardTender = By.xpath("(//div[@class='favourite-executor-fullname'])[2]"); // Выбор пользователя "Админ" в качестве ответственного для первого тендера в карточке тендера


    protected By filterTags = By.xpath("//div[@id='favourite-search-select-tags']//div[@class='dx-texteditor-container']//input"); // Поле фильтра "Поиск по меткам"
    protected By selectRedTagInList = By.xpath("(//div[@class='dx-item dx-list-item'])[1]"); // Выбрать красную метку
    protected By registerNumberTenderInListTendersTabTable = By.xpath("//tr[@class='dx-row dx-data-row dx-row-lines']//td[4]//div[@class='favourite-table-td-name']"); // Реестровый номер тендера во вкладке "Таблица"
    protected By filterAvailabilityTask = By.xpath("(//div[@id='favourite-search-select-with-tasks']//input)[2]"); // Поле "Наличие задач"

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
    protected By buttonOpenListFilters = By.id("favourite-filter-switch-icon"); // Кнопка раскрытия списка фильтров
    protected By buttonClearFieldAvailabilityTask = By.xpath("//div[@id='favourite-search-select-with-tasks']//span[@class='dx-icon dx-icon-clear']"); // Очистить поле "Наличие задач"

    protected By buttonChangeTagInCardTender = By.xpath("//div[@class='favourite-card-control-icons']//i[@class='mdi mdi-24px mdi-tag-outline']"); // Кнопка смены метки в карточке тендера
    protected By buttonChangeResponsibleInCardTender = By.xpath("//div[@id='favourite-tender-select-responsible']//div[@class='dx-texteditor-container']//input"); // Ответственный за тендер в карточке тендера
    protected By buttonChangeResponsibleInTabTable = By.xpath("(//div[@class='dx-scrollable-wrapper']//div[@class='dx-texteditor-input-container']//input)[1]"); // Кнопка смены ответственного у первого элемента на вкладке "Таблица"

    private final By loginField = By.xpath("//input[@type='text']"); // Поле для ввода логина
    private final By passwordField = By.xpath("//input[@type='password']"); // Поле для ввода пароля
    private final By searchTenderField = By.xpath("//div[@id='favourite-search-name']//input"); // Поле для ввода поиска по тендеру

    private final By buttonAddInMyTenders = By.xpath("//div[text()='Добавить в Мои тендеры']"); // Кнопка добавления в "Мои тендеры"
    private final By buttonSelectNameResponsibleToAddInMyTenders = By.xpath("//div[text()='Админ']"); // Выбор ответственного при добавлении тендера в "Мои тендеры"
    private final By buttonLoadDocumentationInListTenders = By.xpath("(//div[@class='favourite-kanban-load-documents'])[1]"); // Кнопка для скачивания документации тендера в списке тендеров
    private final By buttonLinkOfSourceInCard = By.id("favourites-card-link"); // Кнопка "Ссылка на источник"
    private final By buttonDeleteTenderInCard = By.xpath("//i[@class='mdi mdi-24px mdi-delete-outline']"); // Кнопка "Удалить тендер"

    private final By registerNumberAddedTenderInListTenders = By.xpath("(//div[@class='favourite-kanban-card-regnumber'])[1]"); // Регистрационный номер добавленного тендера в списке тендеров
    private final By registerNumberTenderInListTendersForFirstColumn = By.xpath("(//div[@class='favourite-kanban-list'])[1]//div[@class='favourite-kanban-card-regnumber']"); // Регистрационный номер тендера в списке тендеров в первом столбце
    private final By registerNumberTenderInListTendersForSecondColumn = By.xpath("(//div[@class='favourite-kanban-list'])[2]//div[@class='favourite-kanban-card-regnumber']"); // Регистрационный номер тендера в списке тендеров во втором столбце

    private final By nameAddedTenderInListTenders = By.xpath("(//div[@class='favourite-kanban-card-name'])[1]"); // Название добавленного тендера
    private final By nameTenderInListTenders = By.xpath("//div[@class='favourite-kanban-card-name']"); // Название тендера в списке тендеров
    private final By nameSecondColumn = By.xpath("(//div[@class='favourite-kanban-list-title']/div)[2]"); // Название второго столбца

    private final By windowApproveDelete = By.xpath("//div[@class='tl-popup-wrapper tl-approve']"); // Окно подтверждения удаления
    private final By elementListColumns = By.xpath("//div[@class='favourite-kanban-list']"); // Столбец
    private final By fieldNameColumn = By.xpath("//div[@class='favourite-kanban-list']//input"); // Поле для ввода названия столбца
    private final By filterForCheckNumberFilters = By.xpath("//div[@class='dx-texteditor-container']"); // Общий фильтр
    private final By tagInCardTender = By.id("favourite-card-tag"); // Метка в карточке тендера
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

    public void typeSearchByTender(String search){
        find(searchTenderField).sendKeys(search);
    } // Ввести данные для поиска по тендеру

    public void typeNameColumn(String name){
        find(fieldNameColumn).sendKeys(name);
        find(fieldNameColumn).sendKeys(Keys.ENTER);
    } // Ввести название столбца

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
    }

    public Integer getNumberColumns(){
        return findAll(elementListColumns).size();
    } // Получить количество столбцов

    public Integer getNumberFilters(){
        return findAll(filterForCheckNumberFilters).size();
    } // Получить количество фильтров

    public String getNameSecondColumn(){
        return find(nameSecondColumn).getText();
    } // Получить название второго столбца

    public Integer getNumberTabInCardTender(){
        return findAll(tabInCardTender).size();
    } // Получить количество вкладок в карточке тендера

    public WebElementFacade getTenderByNumberInFirstColumn(int number, int numberColumn){
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

    public boolean isCheckVisibleWindowApproveDelete(){
        return find(windowApproveDelete).isVisible();
    } // Проверка появления окна подтверждения удаления

    public boolean isCheckSearchByRegisterNumberTender(){

        boolean check = false;

        List<String> checkRegisterNumber = findAll(registerNumberTenderInListTendersForFirstColumn).texts();

        for(String type : checkRegisterNumber){
            if(type.contains("01")){check = true; break;}
        }

        return check;
    } // Проверка результата поиска по реестровому номеру тендера

    public boolean isCheckSearchByNameTender(){

        boolean check = false;

        List<String> checkRegisterNumber = findAll(nameTenderInListTenders).texts();

        for(String type : checkRegisterNumber){
            if(type.contains("усл")){check = true; break;}
        }

        return check;
    } // Проверка результата поиска по названию тендера

    public boolean isCheckSearchByTags(){
        return find(tagInCardTender).getAttribute("style").contains("background-color: rgb(235, 9, 16)");
    } // Проверка поиска по метке

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

    public boolean isCheckResetFilterAvailabilityTask(){
        return find(filterAvailabilityTask).getValue().isEmpty();
    } // Проверка на сброс значения фильтра "Наличие задач"

    public boolean isCheckMaxLengthNameColumn(){
        return find(nameSecondColumn).getText().length() == 25;
    } // Проверка максимальной длины названия столбца



}
