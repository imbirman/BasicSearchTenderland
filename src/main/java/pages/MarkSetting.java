package pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

@DefaultUrl("https://test2.v2.tenderland.ru/Home/Landing")
public class MarkSetting extends PageObject {

    protected By openTabMenu = By.id("tl-main-nav"); // Кнопка открытия бокового меню
    protected By logInButton = By.xpath("//span[text()='Войти']"); // Кнопка входа в систему
    protected By signInButton = By.xpath("//span[text()='Войти в систему']"); // Кнопка "Войти в систему"
    protected By tabListAutoSearch = By.id("tab-list-autosearches"); // Вкладка "Автопоиски"
    protected By listAutoSearchToScroll = By.xpath("//div[@id='tl-scroll-tabs']//div[@class='dx-scrollable-container']"); // Блок автопоисков для прокрутки list-autosearches

    protected By buttonAutoSearchRegistryNumberAndRegion = By.xpath("//span[text()='Проверка поиска по реестровому номеру и региону']"); // Кнопка автопоиска "Проверка поиска по реестровому номеру и региону"
    protected By contextMenuResultSearch = By.xpath("//a[@class='dx-link dx-icon-overflow dx-link-icon']"); // Кнопка контекстного меню для строки результата поиска
    protected By markContextMenu = By.xpath("//div[text()='Метка тендера']"); // пункт контекстного меню "Метка тендера"

    protected By buttonSettingMark = By.xpath("//div[text()='Настройка']"); // Кнопка "Настройки" в контекстном меню
    protected By buttonSaveMark = By.id("tl-save-user-tag-button"); // Кнопка сохранения метки
    protected By buttonDeleteMark = By.id("tl-delete-user-tag-button"); // Кнопка удаления метки
    protected By buttonAddMark = By.id("tl-add-new-user-tag-button"); // Кнопка добавления метки

    private final By loginField = By.xpath("//input[@type='text']"); // Поле для ввода логина
    private final By passwordField = By.xpath("//input[@type='password']"); // Поле для ввода пароля
    private final By fieldNameMark = By.xpath("//div[@id='tl-manage-user-tags-name']//input"); // Поле для ввода названия метки
    private final By errorMessageEmptyFieldNameMark = By.xpath("//div[@id='tl-manage-user-tags-name']//div[@class='dx-overlay-content dx-invalid-message-content dx-resizable']"); // Текст ошибки при сохранении метки без названия

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

    public void scrollDownTo(By scroll){
        ((JavascriptExecutor)getDriver()).executeScript(
                "arguments[0].scrollTop = -1 >>> 1", find(scroll));
    } // Прокрутить содержимое элемента вниз

    public boolean isDisabledButtonDeleteMark(){
        return find(buttonDeleteMark).getAttribute("aria-disabled").contains("true");
    } // Проверка заблокированности кнопки удаления метки

    public boolean isVisibleErrorMessageEmptyNameMark(){
        return find(errorMessageEmptyFieldNameMark).isVisible();
    } // Проверка появления текста ошибки при сохранении метки с пустым названием

    public boolean isCorrectErrorMessageEmptyNameMark(){
        return find(errorMessageEmptyFieldNameMark).getText().equals("Введите название метки.");
    } // Проверка текста ошибки при сохранении метки с пустым названием
}
