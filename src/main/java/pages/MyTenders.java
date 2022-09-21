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
    protected By buttonMyTenders = By.xpath("(//div[@class='tl-sidenav-item'])[2]//div"); // Кнопка в боковом меню "Мои тендеры"

    protected By buttonOpenResponsibleInWindowTender = By.xpath("//div[@id='tl-tender-task-select-responsible']//input"); // Открыть список ответственных в карточке тендера
    protected By buttonDeleteTaskInList = By.xpath("//i[@class='dx-icon-minus dx-link-icon']"); // Кнопка удаления задачи в списке тендеров для первого тендера

    protected By elementListMyTendersRegistryNumber = By.xpath("//div[@class='tl-gantt-task-click']//div[@class='tl-gantt-entity-number']"); // Элемент списка тендеров в Мои тендеры (реестровый номер)
    protected By elementSwitch = By.xpath("//tbody[@role='presentation']//div[@class='tl-gantt-entity-number']"); // Перенесенный в другую вкладку тендер


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

    public void moveToElement(By element){
        moveTo(element);
    } // Навести курсор на элемент




}
