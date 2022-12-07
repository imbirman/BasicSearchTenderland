package pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

import java.util.List;

@DefaultUrl("https://test.v2.tenderland.ru/Home/Landing")
public class TabPlans extends PageObject {

    protected By openTabMenu = By.id("tl-main-nav"); // Кнопка открытия бокового меню
    protected By logInButton = By.xpath("//span[text()='Войти']"); // Кнопка входа в систему
    protected By signInButton = By.xpath("//span[text()='Войти в систему']"); // Кнопка "Войти в систему"
    protected By tabListAutoSearch = By.id("tab-list-autosearches"); // Вкладка "Автопоиски"

    protected By buttonCheckSearchByNamePlan = By.xpath("//span[text()='Проверка поиска по названию плана']"); // Кнопка автопоиска "Проверка поиска по названию плана"
    protected By buttonCheckSearchByTypePlan = By.xpath("//span[text()='Проверка поиска по типу плана']"); // Кнопка автопоиска "Проверка поиска по типу плана"
    protected By buttonSearch = By.id("search-button"); // Кнопка поиска

    protected By tableCellToCheck = By.xpath("//div[@class='dx-datagrid-content']//tbody[@role='presentation']//td[4]"); // Ячейка таблицы в результатах поиска для первого столбца для первой строки

    protected By filterSearchByTypePlan = By.xpath("//div[@class='dx-tag-content dx-tag-contr']"); // Фильтр "Тип" в автопоиске "Проверка поиска по типу плана"

    protected By checkBoxFilter = By.xpath("//div[@role='checkbox'][@class='dx-widget dx-checkbox dx-list-select-checkbox']"); // чекбокс в фильтре "Модуль" у тендера или "Статус" у контракта или "Тип" у плана

    private final By loginField = By.xpath("//input[@type='text']"); // Поле для ввода логина
    private final By passwordField = By.xpath("//input[@type='password']"); // Поле для ввода пароля

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

    public void clickButton(WebElementFacade button){
        button.click();
    } // Кликнуть по кнопке / выбрать radiobutton или checkbox

    public void typeLogin(String login){
        find(loginField).sendKeys(login);
    } // Ввести логин для входа

    public void typePassword(String password){
        find(passwordField).sendKeys(password);
    } // Ввести пароль для входа

    public WebElementFacade getCheckboxInFilter(int numberCheckbox){
        List<WebElementFacade> checkboxMineTenders = findAll(checkBoxFilter);
        return checkboxMineTenders.get(numberCheckbox);
    } // Получить чекбокс по его порядковому номеру в фильтре "Мои тендеры" у тендера или "Статус" у контракта
    public boolean isContainNamePlan(){
        boolean check = true;
        List<WebElementFacade> namePlanForCheck = findAll(tableCellToCheck);
        namePlanForCheck.remove(namePlanForCheck.size()-1);
        for(WebElementFacade namePlan : namePlanForCheck){
//            System.out.println("Сумма: " + sumMulct.getText());
            if(!(namePlan.getText().contains("мусор") || namePlan.getText().contains("Мусор") || namePlan.getText().contains("МУСОР"))){
                check = false;
                break;
            }
        }
        return check;
    } // Проверка результатов поиска по названию плана

    public boolean isContainTypePlan(){
        boolean check = true;
        List<WebElementFacade> typePlanForCheck = findAll(tableCellToCheck);
        typePlanForCheck.remove(typePlanForCheck.size()-1);
        for(WebElementFacade typePlan : typePlanForCheck){
//            System.out.println("Сумма: " + sumMulct.getText());
            if(!typePlan.getText().contains("План")){
                check = false;
                break;
            }
        }
        return check;
    } // Проверка поиска по типу плана

    public boolean isContainTypePlanSchedule(){
        boolean check = true;
        List<WebElementFacade> typePlanForCheck = findAll(tableCellToCheck);
        typePlanForCheck.remove(typePlanForCheck.size()-1);
        for(WebElementFacade typePlan : typePlanForCheck){
//            System.out.println("Сумма: " + sumMulct.getText());
            if(!typePlan.getText().contains("План-график")){
                check = false;
                break;
            }
        }
        return check;
    } // Проверка поиска по типу плана

    public boolean isContainTypePlanSchedule2017(){
        boolean check = true;
        List<WebElementFacade> typePlanForCheck = findAll(tableCellToCheck);
        typePlanForCheck.remove(typePlanForCheck.size()-1);
        for(WebElementFacade typePlan : typePlanForCheck){
//            System.out.println("Сумма: " + sumMulct.getText());
            if(!typePlan.getText().contains("План-график 2017")){
                check = false;
                break;
            }
        }
        return check;
    } // Проверка поиска по типу плана

}
