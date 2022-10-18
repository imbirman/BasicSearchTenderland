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
    protected By contextMenuResultSearchForTestAddingAndDeleteTender = By.xpath("(//a[@class='dx-link dx-icon-overflow dx-link-icon'])[3]"); // Кнопка контекстного меню для строки результата поиска для добавления в мои тендеры
    protected By contextMenuColumn = By.xpath("//div[@class='favourite-kanban-list-title']/i"); // Кнопка контекстного меню столбца





    protected By buttonLogin = By.xpath("//span[text()='Войти']"); // Кнопка входа в систему
    protected By buttonSignIn = By.xpath("//span[text()='Войти в систему']"); // Кнопка "Войти в систему"
    protected By buttonSearch = By.id("search-button"); // Кнопка поиска
    protected By buttonTabMenuMyTenders = By.xpath("(//div[@class='tl-sidenav-item'])[2]//div"); // Кнопка в боковом меню "Мои тендеры"
    protected By buttonInAutoSearchListCheckMyTenders = By.xpath("//span[text()='Проверка моих тендеров']"); // Автопоиск "Проверка моих тендеров"
    protected By buttonDeleteAddedTenderInListTenders = By.xpath("(//div[@class='favourite-kanban-delete-favourite'])[1]"); // Кнопка удаления добавленного тендера в списке тендеров
    protected By buttonDeleteTenderInListTenders = By.xpath("//div[@class='favourite-kanban-delete-favourite']"); // Кнопка удаления тендера в списке тендеров
    protected By buttonConfirmDelete = By.id("tl-popup-approve-button"); // Кнопка подтверждения удаления тендера
    protected By buttonDeleteContextMenuColumn = By.xpath("(//div[@class='dx-submenu']//div[@role='menuitem'])[3]"); // Кнопка "Удалить" контекстного меню столбца
    protected By buttonAddColumn = By.id("favourite-kanban-add-stage"); // Кнопка добавления столбца
    protected By buttonOpenListFilters = By.id("favourite-filter-switch-icon"); // Кнопка раскрытия списка фильтров

    private final By loginField = By.xpath("//input[@type='text']"); // Поле для ввода логина
    private final By passwordField = By.xpath("//input[@type='password']"); // Поле для ввода пароля

    private final By buttonAddInMyTenders = By.xpath("//div[text()='Добавить в Мои тендеры']"); // Кнопка добавления в "Мои тендеры"
    private final By buttonSelectNameResponsible = By.xpath("//div[text()='Админ']"); // Выбор ответственного при добавлении тендера в "Мои тендеры"
    private final By buttonLoadDocumentationInListTenders = By.xpath("(//div[@class='favourite-kanban-load-documents'])[1]"); // Кнопка для скачивания документации тендера в списке тендеров

    private final By registerNumberAddedTenderInListTenders = By.xpath("(//div[@class='favourite-kanban-card-regnumber'])[1]"); // Регистрационный номер добавленного тендера в списке тендеров
    private final By registerNumberTenderInListTenders = By.xpath("//div[@class='favourite-kanban-card-regnumber']"); // Регистрационный номер тендера в списке тендеров
    private final By nameAddedTenderInListTenders = By.xpath("(//div[@class='favourite-kanban-card-name'])[1]"); // Название добавленного тендера
    private final By windowApproveDelete = By.xpath("//div[@class='tl-popup-wrapper tl-approve']"); // Окно подтверждения удаления
    private final By elementListColumns = By.xpath("//div[@class='favourite-kanban-list']"); // Столбец
    private final By fieldNameColumn = By.xpath("//div[@class='favourite-kanban-list']//input"); // Поле для ввода названия столбца
    private final By nameSecondColumn = By.xpath("(//div[@class='favourite-kanban-list-title']/div)[2]"); // Название второго столбца
    private final By filterForCheckNumberFilters = By.xpath("//div[@class='dx-texteditor-container']"); // Общий фильтр




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
        find(buttonSelectNameResponsible).click();
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

    public boolean checkRegisterNumberAddedTender(){
        return find(registerNumberAddedTenderInListTenders).getText().equals("0372200015221000002");
    } // Проверка номера добавленного тендера

    public boolean checkNameAddedTender(){
        return find(nameAddedTenderInListTenders).getText().equals("Приобретение мешков для мусора");
    } // Проверка названия добавленного тендера

    public boolean checkDeleteAddedTender(){
        boolean check = true;
        List<String> elementForCheck = findAll(registerNumberTenderInListTenders).texts();
        for(String element: elementForCheck){
            if(element.equals("0372200015221000002")){check = false; break;}
        }
        return check;
    } // Проверка удаления добавленного тендера

    public boolean checkClickableButtonDeleteTenderInListTenders(){
        return find(buttonDeleteTenderInListTenders).isClickable();
    } // Проверка кликабельности кнопки удаления тендера в списке тендеров

    public boolean checkClickableButtonLoadDocumentationTenderInListTenders(){
        return find(buttonLoadDocumentationInListTenders).isClickable();
    } // Проверка кликабельности кнопки скачивания документации тендера в списке тендеров

    public boolean checkDisableButtonDeleteContextMenuColumn(){
        return find(buttonDeleteContextMenuColumn).getAttribute("class").contains("dx-state-disabled");
    } // Проверка некликабельности кнопки "Удалить" контекстного меню столбца

    public boolean checkVisibleWindowApproveDelete(){
        return find(windowApproveDelete).isVisible();
    } // Проверка появления окна подтверждения удаления


}
