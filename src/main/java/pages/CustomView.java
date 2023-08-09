package pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import java.util.List;

@DefaultUrl("https://test.v2.tenderland.ru/Home/Landing")
public class CustomView extends PageObject {

    protected By tabListAutoSearch = By.xpath("//div[@class='search-filters-tab list-autosearches']"); // Вкладка "Автопоиски"
    protected By tabCustomView = By.xpath("//div[@id='search-view-tabs']//div[@class='dx-tabs-wrapper']/div"); // Вкладка пользовательского вида
    protected By openTabMenu = By.xpath("//i[@class='material-icons-round icon-28px icon-grey md-menu icon-grey-hover common-header-icon']"); // Кнопка открытия бокового меню
    protected By buttonLogin = By.xpath("//a[text()='Войти']"); // Кнопка входа в систему
    protected By buttonSignIn = By.xpath("//span[text()='Войти в систему']"); // Кнопка "Войти в систему"
    protected By listAutoSearchToScroll = By.xpath("//div[@id='list-autosearches']//div[@class='dx-scrollable-container']"); // Блок автопоисков для прокрутки

    protected By buttonAutoSearchTestCustomView = By.xpath("//div[text()='Тестирование пользовательского вида']"); // Кнопка автопоиска "Тестирование пользовательского вида"
    protected By buttonOpenWindowCustomView = By.xpath("//i[@class='material-icons-outline icon-24px icon-grey icon-grey-hover md-settings']"); // Кнопка открытия настроек пользовательского вида
    protected By buttonAddNewCustomView = By.id("search-view-create-button"); // Кнопка добавления нового пользовательского вида
    protected By buttonTabContracts = By.xpath("(//div[@id='search-view-tabs-fields']/div/div)[2]"); // Вкладка "Контракты"
    protected By buttonTabPlans = By.xpath("(//div[@id='search-view-tabs-fields']/div/div)[3]"); // Вкладка "Планы"
    protected By buttonAccordionDetailing = By.xpath("(//div[contains(@class,'dx-item dx-accordion-item')])[2]"); // Пункт "Детализация"
    protected By buttonAccordionSettings = By.xpath("(//div[contains(@class,'dx-item dx-accordion-item')])[3]"); // Пункт "Настройки"
    protected By buttonSaveCustomView = By.id("search-view-save-button"); // Кнопка "Сохранить настройки"
    protected By buttonOpenContextMenuCustomView = By.xpath("//div[@id='search-view-tabs']//i"); // Кнопка открытия контекстного меню последнего в списке пользовательского вида
    protected By buttonContextMenuRename = By.xpath("(//div[@class='common-context-menu-item'])[1]"); // Кнопка контекстного меню "Переименовать"
    protected By buttonContextMenuDelete = By.xpath("(//div[@class='common-context-menu-item'])[2]"); // Кнопка контекстного меню "Удалить"
    protected By buttonDeleteAllSelectedFields = By.xpath("(//div[@class='search-view-result-header']//i)[2]"); // Кнопка удаления всех выбранных полей пользовательского вида


    protected By buttonCloseWindowCustomView = By.xpath("//div[@role='toolbar']//i"); // Кнопка закрытия окна пользовательского вида

    protected By elementOfListColumns = By.xpath("//div[@id='search-view-tenders-fields']//span"); // Элемент списка столбцов
    protected By elementOfListSelectedColumns = By.xpath("//div[@id='search-view-result-fields']//span"); // Элемент списка выбранных столбцов
    protected By elementUnitTableFieldsForSelection = By.xpath("//div[@id='search-view-multiview']//div[@class='dx-item dx-multiview-item dx-item-selected']//span"); // Элемент для выбора в блоке "Поля таблицы"
    protected By elementUnitDetailingFieldsSelection = By.xpath("//div[@id='search-view-details']//div"); // Элемент для выбора в блоке "Детализация"

    protected By fieldForSorting = By.xpath("//div[@id='search-view-sorting-field']//div[@class='dx-texteditor-input-container']//input"); // Выбрать поле для сортировки
    protected By fieldNameCustomView = By.xpath("//div[@id='search-view-tabs']//input"); // Поле для ввода названия пользовательского вида

    protected By fieldSearchColumnCustomView = By.xpath("//div[@id='search-view-textbox-fields']//input"); // Поле поиска столбцов в пользовательском виде

    protected By checkboxDiscloseDetailing = By.id("search-view-autoexpand-details"); // Чекбокс "Раскрывать детализации"
    protected By radiobuttonDescending = By.xpath("(//div[@class='dx-widget dx-collection']/div[contains(@class,'dx-radiobutton')])[2]"); //


    private final By labelErrorSaveCustomViewWithoutSelectedFields = By.xpath("//div[@class='search-view-result-error-label']"); // Ошибка при сохранении пользовательского вида без выбранных полей
    private final By elementUnitTableFieldsSelected = By.xpath("//div[@id='search-view-result-fields-scroll']//span"); // Выбранный элемент в блоке "Поля таблицы"
    private final By elementUnitDetailingFieldsSelected = By.xpath("//div[@id='search-view-result-details']//span"); // Выбранный элемент в блоке "Детализация"
    private final By labelSelectedFields = By.id("search-view-fields-label"); // Пометка "Выбрано полей"
    private final By labelSelectedDetailing = By.id("search-view-details-label"); // Пометка "Выбрано детализаций"
    private final By labelNameCustomView = By.xpath("//div[@id='search-view-tabs']//div[@class='dx-tabs-wrapper']//div[@class='common-small-tab-name']"); // Название пользовательского вида

    private final By loginField = By.xpath("//input[@type='text']"); // Поле для ввода логина
    private final By passwordField = By.xpath("//input[@type='password']"); // Поле для ввода пароля
    private final By errorMessageEmptyFieldNameCustomView = By.xpath("//div[@class='dx-overlay-content dx-invalid-message-content']"); // Сообщение об ошибке поля "Название" пользовательского вида

    public void waitFor(long number){
        waitABit(number);
    } // Ожидание

    public void clickButton(By button){
        find(button).click();
    } // Кликнуть по кнопке / выбрать radiobutton или checkbox

    public void clickButton(@NotNull WebElementFacade button){
        button.click();
    } // Кликнуть по кнопке / выбрать radiobutton или checkbox

    public void clearField(By field){find(field).clear();} // Очистить поле

    public void typeLogin(String login){
        find(loginField).sendKeys(login);
    } // Ввести логин для входа

    public void typePassword(String password){
        find(passwordField).sendKeys(password);
    } // Ввести пароль для входа

    public CustomView scrollElementOnPixels(String number, By scroll){
        ((JavascriptExecutor)getDriver()).executeScript(
                "arguments[0].scrollBy(0," + number + ")", find(scroll));
        return this;
    } // Прокрутить на заданное количество пикселей

    public void typeNameCustomView(String name){
        find(fieldNameCustomView).sendKeys(name);
        find(fieldNameCustomView).sendKeys(Keys.ENTER);
    } // Ввести название пользовательского вида

    public void typeSearchColumnCustomView(String search){
        find(fieldSearchColumnCustomView).sendKeys(search);
    } // Ввести значение поиска столбца для пользовательского вида

    public WebElementFacade getTabCustomViewByOriginalNumber(int number){
        return findAll(tabCustomView).get(number);
    } // Получить вкладку пользовательского вида по его порядковому номеру

    public WebElementFacade getButtonContextMenuCustomViewByOriginalNumber(int number){
        return findAll(buttonOpenContextMenuCustomView).get(number);
    } // Получить кнопку контекстного меню пользовательского вида по его порядковому номеру

    public WebElementFacade getContextMenuCustomViewByNumber(int number){
        return findAll(buttonOpenContextMenuCustomView).get(number);
    } // Получить кнопку контекстного меню пользовательского вида по порядковому номеру этого вида

    public Integer getNumberElementsTableFieldsForSelection(){
        return findAll(elementUnitTableFieldsForSelection).size();
    } // Получение количества элементов для выбора в блоке "Поля таблицы"

    public Integer getNumberElementsDetailingFieldsForSelection(){
        return findAll(elementUnitDetailingFieldsSelection).size();
    } // Получение количества элементов для выбора в блоке "Детализация"

    public Integer getNumberElementsTableFieldsSelected(){
        return findAll(elementUnitTableFieldsSelected).size();
    } // Получение количества выбранных элементов в блоке "Поля таблицы"

    public Integer getNumberElementsDetailingFieldsSelected(){
        return findAll(elementUnitDetailingFieldsSelected).size();
    } // Получение количества выбранных элементов в блоке "Детализация"

    public String getValueDefaultSortField(){
        return find(fieldForSorting).getValue();
    } // Получение значения поля для сортировки

    public String getValueLabelSelectedFields(){
        return find(labelSelectedFields).getText();
    } // Получение значения пометки "Выбрано полей"

    public String getValueLabelSelectedDetailing(){
        return find(labelSelectedDetailing).getText();
    } // Получение значения пометки "Выбрано детализаций"

    public Integer getNumberTabCustomView(){
        return findAll(tabCustomView).size();
    } // Получить количество вкладок пользовательских видов

    public String getTextErrorSaveCustomViewWithoutSelectedFields(){
        return find(labelErrorSaveCustomViewWithoutSelectedFields).getText();
    } // Получить текст ошибки при сохранении пользовательского вида без выбранных полей

    public boolean checkDisplayedNameTabCustomViewByNumber(int number){
        return findAll(labelNameCustomView).get(number).isDisplayed();
    } // Проверить отображение элемента, в котором хранится название пользовательского вида

    public boolean checkClickableButtonRenameContextMenuCustomView(){
        return find(buttonContextMenuRename).isClickable();
    } // Проверка кликабельности кнопки контекстного меню пользовательского вида "Переименовать"

    public boolean checkClickableButtonDeleteContextMenuCustomView(){
        return find(buttonContextMenuDelete).isClickable();
    } // Проверка кликабельности кнопки контекстного меню пользовательского вида "Удалить"

    public boolean checkVisibleLabelErrorSaveCustomViewWithoutSelectedFields(){
        return find(labelErrorSaveCustomViewWithoutSelectedFields).isVisible();
    } // Проверка отображения сообщение об ошибке при сохранении пользовательского вида без выбранных полей

    public boolean checkSelectedRadiobuttonDescending(){
        return find(radiobuttonDescending).getAttribute("aria-checked").contains("true");
    } // Проверка, что значение сортировки "По убыванию" выставлено по умолчанию

    public boolean checkCheckboxDiscloseDetailing(){
        return find(checkboxDiscloseDetailing).getAttribute("aria-checked").contains("false");
    } // Проверка, что чекбокс "Раскрывать детализации" не выставлен по умолчанию

    public boolean isErrorMessageEmptyNameFieldCustomView(){
        WebElementFacade checkError = find(errorMessageEmptyFieldNameCustomView);
        return checkError.getText().contains("Введите название") && checkError.isVisible();
    } // Проверка сообщения об ошибке при сохранении пользовательского вида при пустом названии

    public boolean isContainResultSearchColumnCustomView(){
        List<String> checkColumn = findAll(elementOfListColumns).texts();
        List<String> checkSelectedColumn = findAll(elementOfListSelectedColumns).texts();
        boolean checkIsContainColumn = false;
        boolean checkISContainSelectedColumn = false;

        for(String type : checkColumn){
            if(type.contains("Реестровый номер")){
                checkIsContainColumn = true;
                break;
            }
        }
        for(String type : checkSelectedColumn){
            if(type.contains("Реестровый номер")){
                checkISContainSelectedColumn = true;
                break;
            }
        }

        return checkIsContainColumn || checkISContainSelectedColumn;
    } // Проверка поиска в окне пользовательского вида

    public boolean isContainSelectedColumn(){
        List<String> checkSelectedColumn = findAll(elementOfListSelectedColumns).texts();
//        System.out.println("sdfsdfsfs " + checkSelectedColumn);
        boolean checkIsContainSelectedColumn = false;
        for(String type : checkSelectedColumn){
            if(type.contains("Идентификатор")){
                checkIsContainSelectedColumn = true;
                break;
            }
        }

        return checkIsContainSelectedColumn;
    } // Проверка добавления столбца пользовательского вида

    public boolean isDisabledElementContractDetailingToSelect(){
        return find(elementUnitDetailingFieldsSelection).getAttribute("style").contains("opacity: 0.3;");
    } // Проверка, заблокирован ли для выбора элемент детализации контрактов, если не выбраны соответствующие поля таблицы
}
