package pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

import java.util.List;

@DefaultUrl("https://v2.tenderland.ru/Home/Landing")
public class AutoSearchPage extends PageObject {



    protected By logInButton = By.xpath("//span[text()='Войти']"); // Кнопка входа в систему
    protected By signInButton = By.xpath("//span[text()='Войти в систему']"); // Кнопка "Войти в систему"
    protected By tabListAutoSearch = By.id("tab-list-autosearches"); // Вкладка "Автопоиски"
    protected By buttonAutoSearchRegistryNumberAndRegion = By.xpath("//span[text()='Проверка поиска по реестровому номеру и региону']"); // Кнопка автопоиска "Проверка поиска по реестровому номеру и региону"
    protected By filterRegionRoot = By.xpath("//span[text()='Санкт-Петербург Город']"); // Фильтр "Регион" в поле построения дерева фильтров
    protected By checkbox = By.xpath("//tbody[@role='presentation']//div[@role='checkbox']"); // чекбокс
    protected By buttonApply = By.id("filter-apply-button"); // Кнопка "Применить"
    protected By buttonSearch = By.id("search-button"); // Кнопка поиска

    private By loginField = By.xpath("//input[@type='text']"); // Поле для ввода логина
    private By passwordField = By.xpath("//input[@type='password']"); // Поле для ввода пароля
    private By checkLogin = By.xpath("//ul[@class='navbar-nav']//a"); // объект для проверки логина после входа
    private By rowResultSearch = By.xpath("//div[@class='dx-datagrid-content']//table[@role='presentation']//tr[@role='row']"); // Строка таблицы поиска
    private By cellOfRegistryNumber = By.xpath("//div[@class='dx-datagrid-content']//tbody[@role='presentation']//td[4]"); // Ячейка таблицы в результатах поиска с реестровым номером для первой строки
    private By fieldSearchInFilterEditor = By.xpath("//div[@id='filter-editor-3-search-panel']//input[@class='dx-texteditor-input']"); // Поле поиска внутри фильтра


    public void waitFor(){
        waitABit(2000);
    } // Ожидание

    public void clickButton(By button){ // Клик по кнопке
        find(button).click();
    } // Кликнуть по кнопке / выбрать radiobutton или checkbox

    public void clickButton(WebElementFacade button){ // Клик по кнопке
        button.click();
    } // Кликнуть по кнопке / выбрать radiobutton или checkbox

    public AutoSearchPage typeLogin(String login){ // Поиск поля логина и ввод значения
        find(loginField).sendKeys(login);
        return this;
    } // Ввести логин для входа

    public AutoSearchPage typePassword(String password){ // Поиск поля пароля и ввод значения
        find(passwordField).sendKeys(password);
        return this;
    } // Ввести пароль для входа

    public AutoSearchPage typeSearch(String search){ // Поиск поля поиска и ввод значения
        find(fieldSearchInFilterEditor).sendKeys(search);
        return this;
    } // Ввести значение в поле поиска

    public String getTextLogin(){
        return find(checkLogin).getText();
    } // Получение названия логина после входа

    public String getTextRegistryNumber(){
        return find(cellOfRegistryNumber).getText();
    }

    public Integer getNumberOfRowResultSearch(){
        List<WebElementFacade> rowResult = findAll(rowResultSearch);
        return rowResult.size();
    } // Получение количества строк в таблице результата поиска

    public WebElementFacade getCheckboxByNumber(int number){
        List<WebElementFacade> checkBoxResult = findAll(checkbox);
        return checkBoxResult.get(number);
    } // Получение чекбокса по его порядковому номеру

    public boolean isEqualNumberOfRowResultSearch(int number){
        return getNumberOfRowResultSearch()==number;
    } // Проверка, соответствует ли количество строк в таблице результата поиска заданному



}
