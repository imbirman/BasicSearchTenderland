package pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;

import java.util.List;

@DefaultUrl("https://test2.v2.tenderland.ru/Home/Landing")
public class MyTendersFilters extends PageObject {

    protected By openTabMenu = By.id("tl-main-nav"); // Кнопка открытия бокового меню
    protected By tabListAutoSearch = By.id("tab-list-autosearches"); // Вкладка "Автопоиски"
    protected By buttonLogin = By.xpath("//span[text()='Войти']"); // Кнопка входа в систему
    protected By buttonSignIn = By.xpath("//span[text()='Войти в систему']"); // Кнопка "Войти в систему"
    protected By buttonTabMenuMyTenders = By.xpath("(//div[@class='tl-sidenav-item'])[2]//div"); // Кнопка в боковом меню "Мои тендеры"

    protected By buttonOpenListFilters = By.id("favourite-filter-switch-icon"); // Кнопка раскрытия списка фильтров
    protected By buttonClearFieldAvailabilityTask = By.xpath("//div[@id='favourite-search-select-with-tasks']//span[@class='dx-icon dx-icon-clear']"); // Очистить поле "Наличие задач"
    protected By buttonChangeResponsibleInCardTender = By.xpath("//div[@id='favourite-tender-select-responsible']//div[@class='dx-texteditor-container']//input"); // Ответственный за тендер в карточке тендера

    protected By filterUsers = By.xpath("//div[@id='favourite-search-select-child-user']//input"); // Поле выбора пользователя в фильтре "Пользователи"
    protected By filterTags = By.xpath("//div[@id='favourite-search-select-tags']//div[@class='dx-texteditor-container']//input"); // Поле фильтра "Поиск по меткам"
    protected By filterAvailabilityTask = By.xpath("(//div[@id='favourite-search-select-with-tasks']//input)[2]"); // Поле "Наличие задач"

    protected By selectRedTagInList = By.xpath("(//div[@class='dx-item dx-list-item'])[1]"); // Выбрать красную метку
    protected By firstElementInListFilter = By.xpath("(//div[@class='dx-item dx-list-item'])[1]"); // Первый пункт в списке фильтра
    protected By openCardFirstTender = By.xpath("//div[@class='dx-treelist-text-content']/div[@class='favourite-kanban-card']"); // Открыть карточку первого тендера

    private final By registerNumberTenderInListTendersForFirstColumn = By.xpath("(//div[@class='favourite-kanban-list'])[1]//div[@class='favourite-kanban-card-regnumber']"); // Регистрационный номер тендера в списке тендеров в первом столбце
    private final By nameTenderInListTenders = By.xpath("//div[@class='favourite-kanban-card-name']"); // Название тендера в списке тендеров

    private final By loginField = By.xpath("//input[@type='text']"); // Поле для ввода логина
    private final By passwordField = By.xpath("//input[@type='password']"); // Поле для ввода пароля
    private final By searchTenderField = By.xpath("//div[@id='favourite-search-name']//input"); // Поле для ввода поиска по тендеру
    private final By filterForCheckNumberFilters = By.xpath("//div[@class='dx-texteditor-container']"); // Общий фильтр
    private final By tagInCardTender = By.id("favourite-card-tag"); // Метка в карточке тендера

    public void waitFor(long number){
        waitABit(number);
    } // Ожидание

    public void clickButton(By button){
        find(button).click();
    } // Кликнуть по кнопке / выбрать radiobutton или checkbox

    public void clickButton(@NotNull WebElementFacade button){
        button.click();
    } // Кликнуть по кнопке / выбрать radiobutton или checkbox

    public void switchToTab(){

        for(String windowHandle : getDriver().getWindowHandles()) {
            getDriver().switchTo().window(windowHandle);
        }
    } // Переключиться на следующую вкладку

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

    public Integer getNumberFilters(){
        return findAll(filterForCheckNumberFilters).size();
    } // Получить количество фильтров

    public String getResponsibleInCardTender(){
        return find(buttonChangeResponsibleInCardTender).getValue();
    } // Получение значение ответственного в карточке тендера

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

    public boolean isCheckResetFilterAvailabilityTask(){
        return find(filterAvailabilityTask).getValue().isEmpty();
    } // Проверка на сброс значения фильтра "Наличие задач"
}
