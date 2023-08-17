package pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import java.util.ArrayList;
import java.util.List;

@DefaultUrl("https://test.v2.tenderland.ru/Home/Landing")
public class MarkSetting extends PageObject {

    protected By openTabMenu = By.xpath("//i[@class='material-icons-round icon-28px icon-grey md-menu icon-grey-hover common-header-icon']"); // Кнопка открытия бокового меню
    protected By logInButton = By.xpath("//a[text()='Войти']"); // Кнопка входа в систему
    protected By signInButton = By.xpath("//span[text()='Войти в систему']"); // Кнопка "Войти в систему"
    protected By tabListAutoSearch = By.xpath("//div[@class='search-filters-tab list-autosearches']"); // Вкладка "Автопоиски"
    protected By listAutoSearchToScroll = By.xpath("//div[@id='tl-scroll-tabs']//div[@class='dx-scrollable-container']"); // Блок автопоисков для прокрутки list-autosearches

    protected By buttonAutoSearchRegistryNumberAndRegion = By.xpath("//div[text()='Проверка поиска по реестровому номеру и региону']"); // Кнопка автопоиска "Проверка поиска по реестровому номеру и региону"
    protected By buttonCheckTenderNameAndNameDeletion = By.xpath("//div[text()='Проверка поиска по названию тендера и исключению из названия']"); // Кнопка автопоиска "Проверка по названию тендера и исключению из названия"
    protected By contextMenuResultSearch = By.xpath("//table[@class='dx-datagrid-table dx-pointer-events-none dx-datagrid-table-fixed']//a[@class='dx-link dx-icon-overflow dx-link-icon']"); // Кнопка контекстного меню для строки результата поиска
    protected By newElementListMark = By.xpath("//div[text()='Тестовая метка']"); // Новая метка
    protected By elementListMark = By.xpath("//div[@id='tl-user-tag-list']//div[@class='dx-item dx-list-item']//div[not(@*)]"); // Элемент списка меток

    protected By buttonSettingMark = By.xpath("//div[text()='Настройка']"); // Кнопка "Настройки" в контекстном меню
    protected By buttonSaveMark = By.id("tl-save-user-tag-button"); // Кнопка сохранения метки
    protected By buttonAddMark = By.id("tl-add-new-user-tag-button"); // Кнопка добавления метки
    protected By buttonApproveDeleteMark = By.xpath("//div[@class='common-popup-confirm-footer']//span[text()='Удалить']"); // Кнопка подтверждения удаления метки
    protected By buttonCardView = By.id("search-panel-card-view"); // Кнопка "Карточный вид"
    protected By buttonDeleteMark = By.xpath("//div[@class='dx-submenu']//div[text()='Удалить']"); // Кнопка "Удалить метку"
    protected By buttonSetMarkCardView = By.xpath("(//div[@class='search-result-card-header']//i)[3]"); // Кнопка "Выбрать цвет метки" для карточного вида
    protected By buttonSelectAllTenders = By.xpath("//div[@id='search-result-checkbox']//span"); // Кнопка выбора всех тендеров на странице
    protected By buttonContextMenuForSelectedTenders = By.id("search-panel-selection-entities"); // Кнопка раскрытия контекстного меню для выбранных тендеров


    protected By markContextMenu = By.xpath("//div[text()='Назначить метку']"); // пункт контекстного меню "Назначить метку"
    protected By redMarkContextMenu = By.xpath("//div[text()='Красный']"); // Метка "Красный" в контекстном меню


    private final By markTender = By.xpath("//div[@class='tl-tag-tender']"); // Метка тендера
    private final By markTenderCardView = By.xpath("//div[@class='search-result-card-tag-line']"); // Метка тендера в карточном виде
    private final By loginField = By.xpath("//input[@type='text']"); // Поле для ввода логина
    private final By passwordField = By.xpath("//input[@type='password']"); // Поле для ввода пароля
    private final By fieldNameMark = By.xpath("//div[@id='tl-manage-user-tags-name']//input"); // Поле для ввода названия метки
    private final By errorMessageEmptyFieldNameMark = By.xpath("//div[@id='tl-manage-user-tags-name']//div[@class='dx-overlay-content dx-invalid-message-content']"); // Текст ошибки при сохранении метки без названия



    public void waitFor(long number){
        waitABit(number);
    } // Ожидание

    public void clearField(By field){find(field).clear();} // Очистить поле

    public void clickButton(By button){
        find(button).click();
    } // Кликнуть по кнопке / выбрать radiobutton или checkbox

    public void clickButton(WebElementFacade button){
        button.click();
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

    public void typeLogin(String login){
        find(loginField).sendKeys(login);
    } // Ввести логин для входа

    public void typePassword(String password){
        find(passwordField).sendKeys(password);
    } // Ввести пароль для входа

    public void typeNameMark(String name){
        find(fieldNameMark).sendKeys(name);
    } // Ввести название метки

    public void scrollDownTo(By scroll){
        ((JavascriptExecutor)getDriver()).executeScript(
                "arguments[0].scrollTop = -1 >>> 1", find(scroll));
    } // Прокрутить содержимое элемента вниз

    public boolean isMarkOfTender(){
        return find(markTender).getAttribute("style").contains("background: rgb(235, 9, 16);");
    } // Проверка, что метка красная

    public boolean isMarkAllSelectedTender(){
        boolean check = true;
       List <WebElementFacade> checkMark = findAll(markTender);
        for(WebElementFacade type:checkMark){
            if(!type.getAttribute("style").contains("background: rgb(235, 9, 16);")){
                check = false;
                break;
            }
        }
        return check;
    } // Проверка установки метки для всех тендеров на странице для табличного вида

    public boolean isMarkAllSelectedTenderCardView(){
        boolean check = true;
        List <WebElementFacade> checkMark = findAll(markTenderCardView);
        for(WebElementFacade type:checkMark){
            if(!type.getAttribute("style").contains("background: rgb(235, 9, 16);")){
                check = false;
                break;
            }
        }
        return check;
    } // Проверка установки метки для всех тендеров на странице для карточного вида

    public boolean isMarkOfTenderCardView(){
        return find(markTenderCardView).getAttribute("style").contains("background-color: rgb(235, 9, 16);");
    } // Проверка, что метка красная в карточном виде

    public boolean isDeletionMarkOfTender(){
        return find(markTender).getAttribute("style").contains("height: 0%;");
    } // Проверка, что метки нет

    public void deleteNewMark(){
        try {
            clickButton(newElementListMark);
            clickButton(buttonDeleteMark);
            clickButton(buttonApproveDeleteMark);
        } catch (Exception e) {
            e.printStackTrace();
        }
    } // Удаление новой метки

    public boolean isDisabledButtonDeleteMark(){
        return find(buttonDeleteMark).getAttribute("aria-disabled").contains("true");
    } // Проверка заблокированности кнопки удаления метки

    public boolean isVisibleErrorMessage(){
        return find(errorMessageEmptyFieldNameMark).isVisible();
    } // Проверка появления текста ошибки при сохранении метки с пустым названием

    public boolean isCorrectErrorMessageEmptyNameMark(){
        return find(errorMessageEmptyFieldNameMark).getText().equals("Введите название метки.");
    } // Проверка текста ошибки при сохранении метки с пустым названием

    public boolean isCorrectErrorMessageDuplicateNameMark(){
        return find(errorMessageEmptyFieldNameMark).getText().equals("Такая метка уже существует.");
    } // Проверка текста ошибки при сохранении метки с дублированным названием

    public boolean isCorrectBaseListMark(){
        List<String> baseListMark = findAll(elementListMark).texts();

        List<String> checkBaseListMark = new ArrayList<>();
        checkBaseListMark.add("Красный");
        checkBaseListMark.add("Сиреневый");
        checkBaseListMark.add("Голубой");
        checkBaseListMark.add("Оранжевый");
        checkBaseListMark.add("Зеленый");
        checkBaseListMark.add("Синий");

        return baseListMark.equals(checkBaseListMark);
    } // Проверка базового списка меток

    public boolean isCorrectListMarkAfterAddNewMark(){
        List<String> listMark = findAll(elementListMark).texts();

        List<String> checkListMark = new ArrayList<>();
        checkListMark.add("Красный");
        checkListMark.add("Сиреневый");
        checkListMark.add("Голубой");
        checkListMark.add("Оранжевый");
        checkListMark.add("Зеленый");
        checkListMark.add("Синий");
        checkListMark.add("Тестовая метка");

        return listMark.equals(checkListMark);
    } // Проверка списка меток после добавления новой метки

    public boolean isCorrectNameNewMark(){
        return find(newElementListMark).getText().equals("Тестовая метка");
    } // Проверка названия новой метки

    public boolean isVisibleNewMark(){
        List<String> listMark = findAll(elementListMark).texts();
        for(String type:listMark){
            if(type.equals("Тестовая метка")){return  true;}
        }
        return false;
    } // Проверка появления новой метки

    public boolean isNotVisibleNewMark(){
        List<String> listMark = findAll(elementListMark).texts();
        for(String type:listMark){
            if(type.equals("Тестовая метка")){return  false;}
        }
        return true;
    } // Проверка отсутствия новой метки после удаления
}
