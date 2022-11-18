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
public class MyTendersTasks extends PageObject {

    protected By openTabMenu = By.id("tl-main-nav"); // Кнопка открытия бокового меню
    protected By tabListAutoSearch = By.id("tab-list-autosearches"); // Вкладка "Автопоиски"

    protected By buttonLogin = By.xpath("//span[text()='Войти']"); // Кнопка входа в систему
    protected By buttonSignIn = By.xpath("//span[text()='Войти в систему']"); // Кнопка "Войти в систему"
    protected By buttonTabMenuMyTenders = By.xpath("(//div[@class='tl-sidenav-item'])[2]//div"); // Кнопка в боковом меню "Мои тендеры"

    protected By buttonAddTask = By.xpath("//div[@id='tasks-multiview']//div[@style='cursor: pointer;']"); // Кнопка добавления задачи //div[@id='tasks-multiview']//i[@class='mdi mdi-18px mdi-plus']
    protected By buttonDeleteTask = By.xpath("//div[@id='tasks-multiview']//i[contains(@class, 'favourite-task-delete-button')]"); // Кнопка удаления последней задачи в списке
    protected By buttonBackToTask = By.xpath("//div[@id='tasks-multiview']//div[@class='favourite-card-back-tasks']"); // Кнопка, возвращающая к задаче

    protected By switchToCompleteTask = By.id("favourite-card-task-is-complete"); // Кнопка переключения метки выполнения задачи


    protected By checkboxCompleteTask = By.xpath("//div[@id='tasks-multiview']//span[@class='dx-checkbox-icon']"); // Чекбокс выполнения задачи

    protected By openCardFirstTender = By.xpath("//div[@class='dx-treelist-text-content']/div[@class='favourite-kanban-card']"); // Открыть карточку первого тендера
    protected By nameLastTask = By.xpath("(//div[@id='tasks-multiview']//div[@class='favourite-card-name-task'])[last()]"); // Название последней задачи

    private final By loginField = By.xpath("//input[@type='text']"); // Поле для ввода логина
    private final By passwordField = By.xpath("//input[@type='password']"); // Поле для ввода пароля

    private final By nameTask = By.xpath("//div[@id='tasks-multiview']//div[@class='favourite-card-name-task']"); // Название задачи
    private final By fieldEntryNameTask = By.xpath("//div[@id='tasks-multiview']//input[@class='dx-texteditor-input']"); // Поле ввода названия задача
    private final By statusTaskInListTasks = By.xpath("//div[@id='favourite-tender-tasks']/div/div[2]/div"); // Статус задачи
    private final By statusTaskInWindowTask = By.id("favourite-card-task-status"); // Статус задачи в окне задачи

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

    public void typeNameTask(String name) {
        find(fieldEntryNameTask).sendKeys(name);
        find(fieldEntryNameTask).sendKeys(Keys.ENTER);
    } // Ввод названия задачи

    public String getNameLastTask(){
        return find(nameLastTask).getText();
    } // Получение названия последней задачи

    public WebElementFacade getButtonDeleteTaskByNumberByNumber(int number){
        return findAll(buttonDeleteTask).get(number);
    } // Получить кнопку удаления задачи по её порядковому номеру

    public WebElementFacade getTaskByNumber(int number){
        return findAll(nameTask).get(number);
    } // Получение задачи по ее порядковому номеру

    public WebElementFacade getStatusTaskInListTasksByNumber(int number){
        return findAll(statusTaskInListTasks).get(number);
    } // Получение статуса задачи в списке задач по её порядковому номеру

    public WebElementFacade getCheckboxInListTasksByNumber(int number){
        return findAll(checkboxCompleteTask).get(number);
    } // Получение чекбокса задачи в списке задач по его порядковому номеру

    public boolean isCheckDeleteTask(){
        boolean check = true;
        List<String> namesTasks = findAll(nameTask).texts();
        for(String type:namesTasks){
            if(type.contains("тестовая задача 4")){check = false; break;}
        }
        return check;
    } // Проверка удаления задачи

    public boolean isCheckStatusAddedTask(){
        List<WebElementFacade> type = findAll(statusTaskInListTasks);
       return type.get(type.size()-1).getText().equals("ВЫПОЛНЯЕТСЯ");
    } // Проверка статуса созданной задачи

    public boolean isCheckStatusTaskAfterClickSwitchBoxCompleteInWindowTask(){
        return find(statusTaskInWindowTask).getText().equals("ГОТОВО");
    } // Проверка статуса задачи в окне задачи после нажатия переключателя "Выполнено"

    public boolean isCheckStatusTaskAfterClickSwitchBoxCompleteInListTask(int number){
        return getStatusTaskInListTasksByNumber(number).getText().equals("ГОТОВО");
    } // Проверка статуса задачи в списке задач после нажатия переключателя "Выполнено"


}
