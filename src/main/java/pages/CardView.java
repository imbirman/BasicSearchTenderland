package pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;

@DefaultUrl("https://test.v2.tenderland.ru/Home/Landing")
public class CardView  extends PageObject {

    protected By tabListAutoSearch = By.xpath("//div[@class='search-filters-tab list-autosearches']"); // Вкладка "Автопоиски"
    protected By tabCustomView = By.xpath("//div[@id='search-view-tabs']//div[@class='dx-tabs-wrapper']/div"); // Вкладка пользовательского вида
    protected By openTabMenu = By.xpath("//i[@class='material-icons-round icon-28px icon-grey md-menu icon-grey-hover common-header-icon']"); // Кнопка открытия бокового меню
    protected By buttonLogin = By.xpath("//a[text()='Войти']"); // Кнопка входа в систему
    protected By buttonSignIn = By.xpath("//span[text()='Войти в систему']"); // Кнопка "Войти в систему"
    protected By buttonCheckTenderNameAndNameDeletion = By.xpath("//div[text()='Проверка поиска по названию тендера и исключению из названия']"); // Кнопка автопоиска "Проверка поиска по названию тендера и исключению из названия"
    protected By buttonOpenListCustomView = By.xpath("//div[@id='search-panel-change-custom-view']"); // Кнопка раскрытия списка пользовательских видов
    protected By buttonItemCustomViewTestView = By.xpath("//div[text()='Тестовый вид']"); // Пункт списка пользовательского вида "Тестовый вид"

    protected By buttonOpenWindowCustomView = By.xpath("//i[@class='material-icons-outline icon-24px icon-grey icon-grey-hover md-settings']"); // Кнопка открытия настроек пользовательского вида
    protected By buttonCloseWindowCustomView = By.xpath("//div[@role='toolbar']//i"); // Кнопка закрытия окна пользовательского вида
    protected By buttonAccordionSettings = By.xpath("(//div[contains(@class,'dx-item dx-accordion-item')])[3]"); // Пункт "Настройки"
    protected By buttonTableView = By.id("search-panel-table-view"); // Кнопка "Табличный вид"
    protected By buttonCardView = By.id("search-panel-card-view"); // Кнопка "Карточный вид"
    protected By buttonSaveCustomView = By.id("search-view-save-button"); // Кнопка "Сохранить вид"
    protected By buttonUnloadProducts = By.xpath("(//div[@id='search-result-wrapper']//div[@class='dx-item-content dx-multiview-item-content']/div)[2]"); // Кнопка "Выгрузить продукты" в детализации тендера
    protected By buttonOpenDetailing = By.xpath("//i[@class='material-icons-outline icon-20px icon-grey md-expand_more']"); // Кнопка открытия детализации тендера

    protected By radiobuttonTableView = By.xpath("(//div[@id='search-view-type']//div[@class='dx-radio-value-container']/div)[1]"); // пункт "Табличный вид" в настройках пользовательского вида
    protected By radiobuttonCardView = By.xpath("(//div[@id='search-view-type']//div[@class='dx-radio-value-container']/div)[2]"); // пункт "Карточный вид" в настройках пользовательского вида

    protected By checkboxOpenCards = By.id("search-view-autoexpand-cards"); // Чекбокс "Раскрывать карточки"

    private final By loginField = By.xpath("//input[@type='text']"); // Поле для ввода логина
    private final By passwordField = By.xpath("//input[@type='password']"); // Поле для ввода пароля

    private final By blockOpenCards = By.id("search-view-autoexpand-cards-checkbox"); // Блок с пунктом "Раскрывать карточки"

    public void waitFor(long number){
        waitABit(number);
    } // Ожидание

    public void clickButton(By button){
        find(button).click();
    } // Кликнуть по кнопке / выбрать radiobutton или checkbox

    public void clickButton(@NotNull WebElementFacade button){
        button.click();
    } // Кликнуть по кнопке / выбрать radiobutton или checkbox

    public void typeLogin(String login){
        find(loginField).sendKeys(login);
    } // Ввести логин для входа

    public void typePassword(String password){
        find(passwordField).sendKeys(password);
    } // Ввести пароль для входа

    public boolean isDisplayedBlockOpenCards(){
        return find(blockOpenCards).isDisplayed();
    } // Проверка отображения при выборе карточного вида блока с чекбоксом "Раскрывать карточки"

    public boolean isSelectedTableView(){
        return find(radiobuttonTableView).getAttribute("class").contains("dx-radiobutton-icon-checked");
    } // Проверка, что по умолчанию выбран табличный вид

    public boolean isSelectedCardView(){
        return find(radiobuttonCardView).getAttribute("class").contains("dx-radiobutton-icon-checked");
    } // Проверка, что карточный вид выбран

    public boolean isSelectedCheckboxOpenCards(){
        return find(checkboxOpenCards).getAttribute("class").contains("dx-checkbox-checked");
    } // Проверка работы чекбокса "Раскрывать карточки"

    public boolean isDisplayedButtonUnloadProducts(){
        return find(buttonUnloadProducts).isDisplayed();
    } // Проверка, что кнопка "Выгрузить продукты" отображается

}
