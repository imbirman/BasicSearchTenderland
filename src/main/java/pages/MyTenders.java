package pages;

import com.ibm.icu.impl.UResource;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.webdriver.exceptions.ElementNotFoundAfterTimeoutError;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import java.util.ArrayList;
import java.util.List;

@DefaultUrl("https://test2.v2.tenderland.ru/Home/Landing")
public class MyTenders extends PageObject {

    protected By openTabMenu = By.id("tl-main-nav"); // Кнопка открытия бокового меню
    protected By tabListAutoSearch = By.id("tab-list-autosearches"); // Вкладка "Автопоиски"
    protected By contextMenuResultSearchForTestAddingAndDeleteTender = By.xpath("(//a[@class='dx-link dx-icon-overflow dx-link-icon'])[5]"); // Кнопка контекстного меню для строки результата поиска для добавления в мои тендеры

    protected By buttonLogin = By.xpath("//span[text()='Войти']"); // Кнопка входа в систему
    protected By buttonSignIn = By.xpath("//span[text()='Войти в систему']"); // Кнопка "Войти в систему"
    protected By buttonSearch = By.id("search-button"); // Кнопка поиска
    protected By buttonAutoSearchTestMyTenders = By.xpath("//span[text()='Проверка моих тендеров']"); // Кнопка автопоиска "Проверка моих тендеров"
    protected By buttonMyTenders = By.xpath("(//div[@class='tl-sidenav-item'])[2]//div"); // Кнопка в боковом меню "Мои тендеры"
    protected By buttonContextMenuAddInMyTenders = By.xpath("//div[text()='Добавить в Мои тендеры']"); // Кнопка контекстного меню "Добавить в Мои тендеры"
    protected By buttonSelectResponsible = By.xpath("//div[text()='Админ']"); // Выбор ответственного для тендера при добавлении в Мои тендеры
    protected By buttonOpenResponsibleInWindowTender = By.xpath("//div[@id='tl-tender-task-select-responsible']//input"); // Открыть список ответственных в карточке тендера
    protected By buttonDeleteNewAddingTenderInListMyTenders = By.xpath("//div[contains(text(),'0372200015221000002')]//following::i[@class='dx-icon-trash dx-link-icon'][1]"); // Кнопка удаления для нового добавленного тендера
    protected By buttonAddNewTaskInWindowTender = By.xpath("//i[@class='mdi mdi-18px mdi-plus']"); // Кнопка добавления новой задачи в окне тендера
    protected By buttonAddNewTaskInList = By.xpath("(//a[@class='dx-link dx-icon-add dx-link-icon'])[1]"); // Кнопка добавления новой задачи в списке тендеров для первого тендера
    protected By buttonDeleteTaskInList = By.xpath("//i[@class='dx-icon-minus dx-link-icon']"); // Кнопка удаления задачи в списке тендеров для первого тендера
    protected By buttonCloseWindowTender = By.xpath("//div[@class='dx-overlay-content dx-popup-normal dx-popup-draggable dx-resizable']//i[@class='mdi mdi-18px mdi-close']"); // Кнопка закрытия окна тендера
    protected By buttonOpenListStatusTender = By.xpath("//div[@id='tl-tender-task-select-status']//input[@class='dx-texteditor-input']"); // Кнопка открытия списка статусов тендера
    protected By buttonOpenListTypesSort = By.xpath("//div[@id='tl-gantt-sort-div']//i[@class='mdi mdi-18px mdi-menu-down']"); // Открыть список типов сортировки

    protected By tabAllTenders = By.id("my-tenders-1"); // Вкладка "Все тендеры"
    protected By tabAllTendersCounter = By.xpath("//div[@id='my-tenders-1']//div[@class='my-tenders-li-counter']"); // Счетчик вкладки "Все тендеры"
    protected By tabNewTenders = By.id("my-tenders-2"); // Вкладка "Новые тендеры"
    protected By tabNewTendersCounter = By.xpath("//div[@id='my-tenders-2']//div[@class='my-tenders-li-counter']"); // Счетчик вкладки "Новые тендеры"
    protected By tabApplicationPreparation = By.id("my-tenders-3"); // Вкладка "Подготовка заявки"
    protected By tabApplicationPreparationCounter = By.xpath("//div[@id='my-tenders-3']//div[@class='my-tenders-li-counter']"); // Счетчик вкладки "Подготовка заявки"
    protected By tabDeterminationWinner = By.id("my-tenders-4"); // Вкладка "Определение победителя"
    protected By tabDeterminationWinnerCounter = By.xpath("//div[@id='my-tenders-4']//div[@class='my-tenders-li-counter']"); // Счетчик вкладки "Определение победителя"
    protected By tabConclusionContract = By.id("my-tenders-5"); // Вкладка "Заключение контракта"
    protected By tabConclusionContractCounter = By.xpath("//div[@id='my-tenders-5']//div[@class='my-tenders-li-counter']"); // Счетчик вкладки "Заключение контракта"
    protected By tabExecutionContract = By.id("my-tenders-6"); // Вкладка "Исполнение контракта"
    protected By tabExecutionContractCounter = By.xpath("//div[@id='my-tenders-6']//div[@class='my-tenders-li-counter']"); // Счетчик вкладки "Исполнение контракта"
    protected By tabArchive = By.id("my-tenders-7"); // Вкладка "Архив"
    protected By tabArchiveCounter = By.xpath("//div[@id='my-tenders-7']//div[@class='my-tenders-li-counter']"); // Счетчик вкладки "Архив"

    protected By elementListMyTendersRegistryNumber = By.xpath("//div[@class='tl-gantt-task-click']//div[@class='tl-gantt-entity-number']"); // Элемент списка тендеров в Мои тендеры (реестровый номер)
    protected By elementSwitch = By.xpath("//tbody[@role='presentation']//div[@class='tl-gantt-entity-number']"); // Перенесенный в другую вкладку тендер
    protected By firstElementListResponsibleInWindowTender = By.xpath("(//div[@class='tl-tag-fullname'])[1]"); // Первый элемент списка ответственных в окне тендера
    protected By secondElementListResponsibleInWindowTender = By.xpath("(//div[@class='tl-tag-fullname'])[2]"); // Второй элемент списка ответственных в окне тендера
    protected By blockWindowTenderForScroll = By.xpath("//div[@id='tender-task-scroll']//div[@class='dx-scrollable-container']"); // Блок окна тендера для пролистывания

    protected By checkboxInWindowTenderTaskCompleted = By.xpath("//div[@id='tender-tasks']//span"); // Чекбокс в окне тендера "Задача выполнена"


    private final By loginField = By.xpath("//input[@type='text']"); // Поле для ввода логина
    private final By passwordField = By.xpath("//input[@type='password']"); // Поле для ввода пароля
    private final By elementListMyTendersName = By.xpath("//tr[@class='dx-row dx-data-row']//div[@class='tl-gantt-subtitle']"); // Элемент списка тендеров в Мои тендеры (название тендера)
    private final By nameTenderInWindow = By.xpath("//div[@class='tl-tender-task-title']//a"); // Реестровый номер тендера в его окне
    private final By fieldNameTaskInWindowTender = By.xpath("//div[@id='tender-tasks']//div[@class='dx-texteditor-container']//input"); // Поле ввода названия задачи в окне тендера
    private final By fieldNameTaskInList = By.xpath("//div[@id='tl-gantt-textbox-input']//input[@class='dx-texteditor-input']"); // Поле ввода названия задачи в списке тендеров
    private final By fieldNameTaskInWindowTask = By.xpath("//div[@id='tl-textbox-task-name']//input"); // Название задачи в окне задачи
    private final By fieldSearchTenders = By.xpath("//div[@id='tl-gantt-search-textbox']//input"); // Поле поиска в списке тендеров
    private final By elementListStatusTender = By.xpath("//div[@class='dx-item-content dx-list-item-content']"); // Элемент списка статусов тендера
    private final By elementNameTaskInList = By.xpath("//div[@class='main-text label-task']"); // Название задачи в списке тендеров
    private final By elementNameTaskInWindowTender = By.xpath("//div[@id='tender-tasks']//div[@class='main-text label-task']"); // Название задачи в окне тендера
    private final By elementListTypesSort = By.xpath("//div[@role='menu']/div/ul/li/div/div/div/div"); // Элемент списка способов сортировки тендеров
    private final By statusTaskInWindowTender = By.xpath("//div[@id='tender-tasks']//div[@class='tl-complete-status-task']"); // Статус задачи в окне тендера
    private final By statusTaskInListTenders = By.xpath("//tr[@class='dx-row dx-data-row dx-selection']//div[@class='tl-complete-status-task']"); // Статус задачи в списке тендеров


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

    public void typeNameTaskInList(String name){
        find(fieldNameTaskInList).sendKeys(name);
        find(fieldNameTaskInList).sendKeys(Keys.ENTER);
    } // Ввести название задачи в списке тендеров

    public void typeNameTaskInWindowTender(String name){
        find(fieldNameTaskInWindowTender).waitUntilClickable().sendKeys(name);
        find(fieldNameTaskInWindowTender).sendKeys(Keys.ENTER);
    } // Ввести название задачи в окне тендера

    public void typeSearchTenders(String search){
        find(fieldSearchTenders).sendKeys(search);
        find(fieldSearchTenders).sendKeys(Keys.ENTER);
    } // Ввести поисковое слово в поле поиска по списку тендеров

    public void moveToElement(By element){
        moveTo(element);
    } // Навести курсор на элемент

    public WebElementFacade getStatusTenderByNumber(int number){
        List<WebElementFacade> element = findAll(elementListStatusTender);
        return element.get(number);
    } // Получить статус тендера из списка в окне тендера по порядковому номеру статуса

    public String getNameResponsibleInWindowTender(){
        return find(buttonOpenResponsibleInWindowTender).getValue();
    } // Получить имя ответственного в карточке тендера

    public boolean isContainCorrectRegistryNumberAddingTender(){
        boolean checkIsContainRegistryNumber = false;
        List<String> checkRegistryNumber = findAll(elementListMyTendersRegistryNumber).texts();
        for(String type : checkRegistryNumber){
            if(type.equals("0372200015221000002")){
                checkIsContainRegistryNumber = true;
                break;
            }
        }
        return checkIsContainRegistryNumber;
    } // Проверка реестрового номера добавленного тендера

    public boolean isContainCorrectNameAddingTender(){
        boolean checkIsContainName = false;
        List<String> checkName = findAll(elementListMyTendersName).texts();
        for(String type : checkName){
            if(type.equals("Приобретение мешков для мусора")){
                checkIsContainName = true;
                break;
            }
        }
        return checkIsContainName;
    } // Проверка названия добавленного тендера

    public boolean isNotContainAddingTender(){
        boolean checkIsContain = true;
        List<String> checkContain = findAll(elementListMyTendersRegistryNumber).texts();
        for(String type : checkContain){
            if(type.equals("100006854121100012")){
                checkIsContain = false;
                break;
            }
        }
        return checkIsContain;
    } // Проверка что добавленный тендер есть в списке

    public boolean isCorrectRegistryNumberInWindow(){
        return find(nameTenderInWindow).getText().equals("8963370");
    } // Проверка реестрового номера в окне тендера

    public boolean isContainSwitchTender(){
        boolean checkIsContain = false;
        List<String> checkContain = findAll(elementSwitch).texts();
        for(String type : checkContain){
            if(type.contains("8963370")){
                checkIsContain = true;
                break;
            }
        }
        return checkIsContain;
    } // Проверка наличия тендера при переносе его в другую вкладку

    public boolean isNotContainTenderSwitchToArchive(){
        boolean checkIsContain = true;
        List<String> checkContain = findAll(elementSwitch).texts();
        for(String type : checkContain){
            if(type.equals("8963370")){
                checkIsContain = false;
                break;
            }
        }
        return checkIsContain;
    } // Проверка отсутствия в основной вкладке тендера при переносе его в архив

    public boolean isCorrectNumberCounter(By element){
        return find(element).getText().equals("1");
    } // Проверка счетчика вкладки

    public void checkTaskInListForDelete(){
        if(find(elementNameTaskInList).isPresent() && find(elementNameTaskInList).getText().equals("Тест")){
            clickButton(buttonDeleteTaskInList);
        }
    } // Проверка наличия задачи у тендера и её удаление

    public boolean isNotVisibleTaskByList(){
        return find(elementNameTaskInList).isVisible();
    } // Проверка отсутствия задачи в списке тендеров

    public boolean isVisibleAndContainNameTaskByList(){
        return find(elementNameTaskInList).isVisible() && find(elementNameTaskInList).getText().equals("Тест");
    } // Проверка добавления задачи в список тендеров и её названия

    public boolean isContainNameTaskByWindowTask(){
        return find(fieldNameTaskInWindowTask).getText().equals("Тест");
    } // Проверка названия задачи в окне задачи

    public boolean isNotVisibleTaskByWindowTender(){
        return find(elementNameTaskInWindowTender).isVisible();
    } // Проверка отсутствия задачи в окне тендера

    public boolean isVisibleAndContainNameTaskByWindowTender(){
        return find(elementNameTaskInWindowTender).isVisible() && find(elementNameTaskInWindowTender).getText().equals("Тест");
    } // Проверка добавления задачи в окне тендера и её названия

    public boolean isEmptyNameTaskByWindowTender(){
        boolean checkIsEmpty = true;
        List<String> checkEmpty = findAll(elementNameTaskInWindowTender).texts();
        for(String type : checkEmpty){
            if(type.isEmpty()){
                checkIsEmpty = false;
                break;
            }
        }
        return checkIsEmpty;
    } // Проверка наличия задач с пустым названием в окне тендера

    public boolean isCorrectListTypesSort(){
        List<String> listTypesSort = findAll(elementListTypesSort).texts();

        List<String> checkListTypesSort = new ArrayList<>();
        checkListTypesSort.add("По умолчанию");
        checkListTypesSort.add("По метке");
        checkListTypesSort.add("По дате публикации");
        checkListTypesSort.add("По дате начала");
        checkListTypesSort.add("По дате окончания");
        checkListTypesSort.add("Все БП");
        checkListTypesSort.add("Активные БП");
        checkListTypesSort.add("Завершенные БП");

        return listTypesSort.equals(checkListTypesSort);
    } // Проверка корректности типов сортировки списка тендеров

    public boolean isCorrectStatusTaskCompletedInWindowTender(){
        return find(statusTaskInWindowTender).getText().equals("Готово");
    } // Проверка статуса выполненной задачи в окне тендера

    public boolean isCorrectStatusTaskCompletedInLisTenders(){
        return find(statusTaskInListTenders).getText().equals("Готово");
    } // Проверка статуса выполненной задачи в списке тендеров

    public boolean isCorrectSortListTendersAfterSearch(){

        List<String> listTypesSort = findAll(elementListMyTendersRegistryNumber).texts();

        List<String> checkListTendersSort = new ArrayList<>();
        checkListTendersSort.add("8963370");
        checkListTendersSort.add("0332300365521000004");
        checkListTendersSort.add("0148300041821000004");
        checkListTendersSort.add("100173747121100001");
        checkListTendersSort.add("100006854121100011");

        return listTypesSort.equals(checkListTendersSort);
    }


}
