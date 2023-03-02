package pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import java.util.List;

@DefaultUrl("https://test.v2.tenderland.ru/Home/Landing")
public class FilterSearch extends PageObject{

    protected By tabListAutoSearch = By.xpath("//div[@class='search-filters-tab list-autosearches']"); // Вкладка "Автопоиски"
    protected By buttonLogin = By.xpath("//a[text()='Войти']"); // Кнопка входа в систему
    protected By buttonSignIn = By.xpath("//span[text()='Войти в систему']"); // Кнопка "Войти в систему"
    protected By filterNameTender = By.xpath("//span[text()='Название тендера']"); // Фильтр "Название тендера" в блоке фильтров
    protected By testAutoSearch = By.xpath("//span[text()='Тестовый автопоиск']"); // Тестовый автопоиск в списке автопоисков
    protected By buttonSaveAutoSearch = By.id("search-filters-save-autosearch-button"); // Кнопка "Сохранить автопоиск"
    protected By buttonAcceptSaveAutoSearch = By.id("save-autosearch-apply"); // Кнопка "Применить" для сохранения автопоиска
    protected By buttonDeleteAutoSearchInListAutoSearch = By.xpath("(//div[text()='Тестовый автопоиск']/following::i)[1]"); // Кнопка удаления тестового автопоиска в списке автопоисков
    protected By buttonAcceptDeletedAutoSearch = By.xpath("//span[text()='Удалить']"); // Кнопка подтверждения удаления автопоиска
    protected By buttonCancelDeletedAutoSearch = By.xpath("//span[text()='Не удалять']"); // Кнопка отмены удаления автопоиска
    protected By buttonDeleteAutoSearchInBuildingSearch = By.xpath("//i[@id='search-autosearch-delete']"); // Кнопка удаления автопоиска в блоке дерева фильтров
    protected By buttonClearBuildingFieldSearch = By.xpath("//span[text()='Очистить поле']"); // Кнопка очистки поля построения фильтров
    protected By buttonCopyLinkAutoSearchInBuildingSearch = By.xpath("//i[@class='mdi mdi-24px mdi-share-variant']"); // Кнопка копирования ссылки автопоиска
    protected By buttonCopyAutoSearchInBuildingSearch = By.xpath("//i[@class='mdi mdi-24px mdi-content-copy']"); // Кнопка копирования автопоиска

    protected By buttonOpenListCustomView = By.xpath("//div[@id='change-custom-view-button']//i"); // Кнопка раскрытия списка пользовательских видов
    protected By buttonItemCustomView = By.xpath("//div[text()='Тестовый вид']"); // Пункт списка пользовательского вида "Тестовый вид"
    protected By buttonLogout = By.xpath("//form/button"); // Кнопка "Выйти"
    protected By buttonSwitchPinCode = By.id("tl-has-pin-code"); // Кнопка включения/выключения пинкода

    protected By tabListVersionInWindowAutoSearch = By.xpath("(//div[@role='tab'])[3]"); // Вкладка в окне автопоиска "Версия автопоиска"

    private final By fieldSearchByNameTender = By.xpath("//textarea[@class='dx-texteditor-input dx-texteditor-input-auto-resize']"); // Поле поиска внутри фильтра "Название тендера"
    private final By loginField = By.xpath("//input[@type='text']"); // Поле для ввода логина
    private final By passwordField = By.xpath("//input[@type='password']"); // Поле для ввода пароля
    private final By filterRoot = By.xpath("//div[@class='dx-sortable tl-filter-content tl-filter-drop-area']"); // Поле дерева фильтров
    private final By errorMessageEmptyNameFieldAutoSearch = By.xpath("//div[@id='tl-autosearch-name']//div[@class='dx-overlay-content dx-invalid-message-content']"); // Текст ошибки при сохранении автопоиска с пустым названием
    private final By fieldNameAutoSearch = By.xpath("//div[@id='tl-autosearch-name']//input"); // Поле ввода названия автопоиска
    private final By elementListAutoSearch = By.xpath("//div[@id='list-autosearches']//div[@class='search-autosearch-group-container']//div[not(@*)]"); // элемент списка автопоисков
    private final By autoSearchLabel = By.id("autosearch-label"); // Название автопоиска в древе построения фильтров
    private final By loginUserInVersionAutoSearch = By.xpath("//td[text()='AdminTestitAutoSearch']"); // логин пользователя в версии автопоиска
    private final By buttonCustomView = By.xpath("//div[@id='change-custom-view-button']//span"); // Кнопка "Пользовательский вид"
    private final By messageNoDataVersionAutoSearch = By.xpath("//span[@class='dx-datagrid-nodata']"); // Текст при отсутствии версий автопоиска

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

    public void dragAndDropFilter(By filter){
        withAction().dragAndDrop(find(filter), find(filterRoot)).build().perform();
    } // Перетащить фильтр в область построения дерева фильтров

    public void typeNameAutoSearch(String name){
        find(fieldNameAutoSearch).sendKeys(name);
    } // Ввести название автопоиска

    public void typeSearchInsideFilterNameTender(String search){
        find(fieldSearchByNameTender).sendKeys(search);
    } // Ввести значение в поле название тендера

    public void checkTestAutoSearchAndDelete(){
        try {
            if(find(elementListAutoSearch).getText().equals("Тестовый автопоиск")){
                clickButton(buttonDeleteAutoSearchInListAutoSearch);
                find(buttonAcceptDeletedAutoSearch).waitUntilClickable();
                clickButton(buttonAcceptDeletedAutoSearch);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    } // проверка наличия тестового автопоиска и его удаление

    public boolean isErrorMessageEmptyNameFieldAutoSearch(){
        WebElementFacade checkError = find(errorMessageEmptyNameFieldAutoSearch);
        return checkError.getText().contains("Заполните название автопоиска") && checkError.isVisible();
    } // Проверка сообщения об ошибке при отсутствии названия автопоиска

    public boolean isErrorMessageDuplicateNameFieldAutoSearch(){
        WebElementFacade checkError = find(errorMessageEmptyNameFieldAutoSearch);
        return checkError.getText().contains("Название должно быть уникальным.") && checkError.isVisible();
    } // Проверка сообщения об ошибке при дублировании названия автопоиска

    public boolean isCorrectNameAutoSearch(){
        return find(autoSearchLabel).getText().equals("Тестовый автопоиск");
    } // Проверка названия автопоиска в дереве построения фильтров

    public boolean isContainAutoSearch(){
        List<String> checkCreatedAutoSearch = findAll(elementListAutoSearch).texts();
        int counter = 0;
        boolean checkIsContainAutoSearch = false;
        for(String type : checkCreatedAutoSearch){
            if(type.equals("Тестовый автопоиск")){
                checkIsContainAutoSearch = true;
                counter++;
            }
        }
        return checkIsContainAutoSearch && counter == 1;
    } // Проверка наличия автопоиска с корректным названием и в единичном экземпляре

    public boolean isNotContainAutoSearch(){
        List<String> checkCreatedAutoSearch = findAll(elementListAutoSearch).texts();
        boolean checkIsContainAutoSearch = true;
        for(String type : checkCreatedAutoSearch){
            if(type.equals("Тестовый автопоиск")){
                checkIsContainAutoSearch = false;
                break;
            }
        }
        return checkIsContainAutoSearch;
    } // Проверка отсутствия автопоиска после удаления

    public boolean isClickableButtonCopyLinkAutoSearchInBuildingSearch(){
        return find(buttonCopyLinkAutoSearchInBuildingSearch).isClickable();
    } // Проверка кликабельности кнопки копирования ссылки автопоиска

    public boolean isClickableButtonCopyAutoSearchInBuildingSearch(){
        return find(buttonCopyAutoSearchInBuildingSearch).isClickable();
    } // Проверка кликабельности кнопки копирования автопоиска

    public boolean isClickableButtonDeleteAutoSearchInBuildingSearch(){
        return find(buttonDeleteAutoSearchInBuildingSearch).isClickable();
    } // Проверка кликабельности кнопки удаления автопоиска

    public boolean isClickableButtonCloseAutoSearchInBuildingSearch(){
        return find(buttonClearBuildingFieldSearch).isClickable();
    } // Проверка кликабельности кнопки закрытия автопоиска

    public boolean isClickableButtonSaveAutoSearch(){

        boolean result = false;

        try {
            String value = find(buttonSaveAutoSearch).getAttribute("aria-disabled");
            if(value != null){
                result = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    } // Проверка кликабельности кнопки сохранения автопоиска

    public boolean isClickableButtonSwitchPinCode(){

        boolean result = false;

        try {
            String value = find(buttonSwitchPinCode).getAttribute("aria-readonly");
            if(value != null){
                result = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    } // Проверка кликабельности кнопки включения/выключения пинкода

    public boolean isVisibleVersionAutoSearch(){
        return find(loginUserInVersionAutoSearch).isVisible();
    } // Проверка отображения версии автопоиска

    public String isCorrectLoginUserInVersionAutoSearch(){
        return find(loginUserInVersionAutoSearch).getText();
    } // Получение логина пользователя из версии автопоиска

    public String isCorrectNameCustomView(){
        return find(buttonCustomView).getText();
    } // Получение названия пользовательского вида

    public boolean isContainMessageNoDataVersionAutoSearch(){
        return find(messageNoDataVersionAutoSearch).isDisplayed();
    } // Проверка отображения сообщения при отсутствии версии автопоиска

    public boolean isContainCorrectNameAutoSearchAfterCopy(){
        return find(fieldNameAutoSearch).getValue().contentEquals("Тестовый автопоиск (копия)");
    } // Проверка названия автопоиска после копирования

}
