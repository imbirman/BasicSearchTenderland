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
    protected By buttonCheckTenderNameAndNameDeletion = By.xpath("//span[text()='Проверка по названию тендера и исключению из названия']"); // Кнопка автопоиска "Проверка по названию тендера и исключению из названия"
    protected By filterRegionRoot = By.xpath("//span[text()='Санкт-Петербург Город']"); // Фильтр "Регион" в поле построения дерева фильтров для автопоиска "Проверка поиска по реестровому номеру и региону"
    protected By filterNameTender = By.xpath("//span[text()='мусор | ']"); // Фильтр "Название тендера" в поле построения дерева фильтров для автопоиска "Проверка по названию тендера и исключению из названия"
    protected By checkbox = By.xpath("//tbody[@role='presentation']//div[@role='checkbox']"); // чекбокс
    protected By checkBoxTransliteration = By.xpath("//div[@id='filter-editor-compact-1-transliteration']"); // чекбокс "Транслитерация"
    protected By buttonApply = By.id("filter-apply-button"); // Кнопка "Применить"
    protected By buttonSearch = By.id("search-button"); // Кнопка поиска
    protected By fieldNameTender = By.xpath("//div[@id='filter-editor-compact-1-include']//textarea"); // Поле для ввода названия тендера для поиска

    private By loginField = By.xpath("//input[@type='text']"); // Поле для ввода логина
    private By passwordField = By.xpath("//input[@type='password']"); // Поле для ввода пароля
    private By checkLogin = By.xpath("//ul[@class='navbar-nav']//a"); // объект для проверки логина после входа
    private By rowResultSearch = By.xpath("//div[@class='dx-datagrid-content']//table[@role='presentation']//tr[@role='row']"); // Строка таблицы поиска
    private By tableCellToCheck = By.xpath("//div[@class='dx-datagrid-content']//tbody[@role='presentation']//td[4]"); // Ячейка таблицы в результатах поиска с реестровым номером для первой строки
//    private By cellOfRegistryName = By.xpath("//div[@class='dx-datagrid-content']//tbody[@role='presentation']//td[5]"); // Ячейка таблицы в результатах поиска с названием тендера
    private By fieldSearchInFilterEditor = By.xpath("//div[@id='filter-editor-3-search-panel']//input[@class='dx-texteditor-input']"); // Поле поиска внутри фильтра
    private By fieldNameTenderDeletion = By.xpath("//div[@id='filter-editor-compact-1-exclude']//textarea"); // Поле для ввода параметра, исключаемого из поиска



    public void waitFor(){
        waitABit(2000);
    } // Ожидание

    public void clearField(By field){find(field).clear();} // Очистить поле

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

    public AutoSearchPage typeDeletion(String name){
        find(fieldNameTenderDeletion).sendKeys(name);
        return this;
    } // Ввести значение, исключаемое из поиска

    public AutoSearchPage typeNameTender(String name){ // Поиск поля логина и ввод значения
        find(fieldNameTender).sendKeys(name);
        return this;
    } // Ввести ключевое слово для поиска по названию тендера

    public String getTextLogin(){
        return find(checkLogin).getText();
    } // Получение названия логина после входа

    public String getTextRegistryNumber(){
        return find(tableCellToCheck).getText();
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

    public boolean isContainNameTender(){
        List<WebElementFacade> nameTender = findAll(tableCellToCheck);
        nameTender.remove(nameTender.size()-1);
        boolean check = true;
        for(WebElementFacade name : nameTender){
            if(!(name.getText().contains("мусор")||name.getText().contains("МУСОР"))){
//                System.out.println(name.getText());
                check = false;
                break;
            }
        }
        return check;
    } // Проверка включения в название тендеров ключевого слова

    public boolean isContainDeletionNameTender(){
        List<WebElementFacade> nameTender = findAll(tableCellToCheck);
        nameTender.remove(nameTender.size()-1);
        boolean check = false;
        for(WebElementFacade name : nameTender){
            if(!(name.getText().contains("мусоровоз")||name.getText().contains("МУСОРОВОЗ"))){
//                System.out.println(name.getText());
                check = true;
                break;
            }
        }
        return check;
    } // Проверка включения в название тендеров ключевого слова



}
