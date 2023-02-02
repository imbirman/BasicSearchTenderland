package pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

@DefaultUrl("https://test.v2.tenderland.ru/Home/Landing")
public class DistributionFromAutoSearch extends PageObject{

    protected By tabListAutoSearch = By.xpath("//div[@class='search-filters-tab list-autosearches']"); // Вкладка "Автопоиски"
    protected By buttonLogin = By.xpath("//a[text()='Войти']"); // Кнопка входа в систему
    protected By buttonSignIn = By.xpath("//span[text()='Войти в систему']"); // Кнопка "Войти в систему"
    protected By fieldSearchInFilter = By.xpath("//div[(contains(@class,'dx-item dx-multiview-item dx-item-selected'))]//input[@class='dx-texteditor-input']"); // Поле поиска внутри фильтра
    protected By filterNameTender = By.xpath("//span[text()='Название тендера']"); // Фильтр "Название тендера" в блоке фильтров
    protected By testAutoSearch = By.xpath("//span[text()='Тестовый автопоиск']"); // Тестовый автопоиск в списке автопоисков
    protected By buttonSaveAutoSearch = By.id("save-autosearch-button"); // Кнопка "Сохранить автопоиск"
    protected By buttonAcceptSaveAutoSearch = By.id("save-autosearch-apply"); // Кнопка "Применить" для сохранения автопоиска
    protected By buttonDeleteAutoSearchInListAutoSearch = By.xpath("//span[text()='Тестовый автопоиск']/following::div[@class='tl-tag-autosearch dx-tag-remove-button'][1]"); // Кнопка удаления автопоиска в списке автопоисков
    protected By buttonAcceptDeletedAutoSearch = By.id("tl-popup-approve-button"); // Кнопка подтверждения удаления автопоиска
    protected By buttonSwitchDistribution = By.id("tl-mailing-switch"); // Кнопка включения/выключения рассылки
    protected By buttonLogout = By.xpath("//form/button"); // Кнопка "Выйти"
    protected By buttonSwitchPinCode = By.id("tl-has-pin-code"); // Кнопка включения/выключения пинкода
    protected By buttonOpenFieldsSelector = By.id("open-field-selector"); // Кнопка для открытия окна выбора полей для рассылки
    protected By buttonOpenListDistributionMethods = By.id("tl-mailing-method");// Раскрыть список форм рассылки
    protected By buttonOpenListFormReports = By.xpath("//div[@id='tl-delivery-reports']//input[@class='dx-texteditor-input']"); // Раскрыть список отчетов

    protected By elementListDistributionMethodsReport = By.xpath("(//div[@class='dx-scrollview-content']//div[@class='dx-item dx-list-item']/div)[2]"); // Пункт "Отчет" списка форм рассылки


    protected By checkboxSaturday = By.id("check-6"); // Чекбокс "Суббота"
    protected By checkboxFriday = By.id("check-5"); // Чекбокс "Пятница"

    protected By tabDistributionInWindowAutoSearch = By.xpath("(//div[@role='tab'])[2]"); // Вкладка в окне автопоиска "Рассылка"

    private final By fieldSearchByNameTender = By.xpath("//textarea[@class='dx-texteditor-input dx-texteditor-input-auto-resize']"); // Поле поиска внутри фильтра "Название тендера"
    private final By loginField = By.xpath("//input[@type='text']"); // Поле для ввода логина
    private final By passwordField = By.xpath("//input[@type='password']"); // Поле для ввода пароля
    private final By filterRoot = By.xpath("//div[@class='dx-sortable tl-filter-content tl-filter-drop-area']"); // Поле дерева фильтров
    private final By fieldNameAutoSearch = By.xpath("//div[@id='tl-autosearch-name']//input"); // Поле ввода названия автопоиска
    private final By elementListAutoSearch = By.xpath("//div[@id='list-autosearches']//span[last()]"); // элемент списка автопоисков
    private final By errorMessageWithEmptyAccountForDistribution = By.xpath("//div[@class='dx-overlay-content dx-invalid-message-content']"); // Сообщение об ошибке при сохранении автопоиска без указания почты или телеграмма для рассылки
    private final By errorMessageWithFieldPinCode = By.xpath("//div[@id='tl-pin-code']//div[@class='dx-overlay-content dx-invalid-message-content']"); // Сообщение об ошибке при пустом поле "Пинкод"
    private final By statusDistribution = By.id("tl-autosearch-distribution-status"); // Статус рассылки
    private final By activationDateDistribution = By.id("tl-autosearch-distribution-activation-date"); // Дата и время включения рассылки
    private final By blockDistributionFields = By.id("tl-delivery-fields"); // Блок полей для рассылки
    private final By blockAccountAndAddressForDistribution = By.xpath("(//div[@id='tl-delivery-hiding']/div/div)[1]"); // Блок аккаунтов и адресов для рассылки
    private final By blockDaysDistribution = By.xpath("(//div[@id='tl-delivery-hiding']/div/div)[2]"); // Блок дней рассылки
    private final By blockTimeDistribution = By.xpath("(//div[@id='tl-delivery-hiding']/div/div)[3]"); // Блок времени рассылки
    private final By fieldEmailDistribution = By.xpath("//div[@id='tagbox-accounts']//input"); // Поле для ввода е-мейла рассылки
    private final By fieldPinCode = By.xpath("//div[@id='tl-pin-code']//input"); // Поле для ввода пинкода
    private final By elementOfListFieldsForDistribution = By.xpath("//div[@id='tl-delivery-fields-selector']//div[@class='dx-item-content dx-list-item-content']");
    private final By selectedElementOfListFieldsForDistribution = By.xpath("//div[@class='dx-item dx-list-item dx-list-item-selected']//div[@class='dx-item-content dx-list-item-content']"); // Выбранный элемент в окне списка всех полей
    private final By elementInBlockFieldsForDistribution = By.xpath("//div[@id='tl-delivery-fields']//div[@class='dx-item-content dx-list-item-content']"); // Элемент в блоке полей для рассылки
    private final By elementListDistributionMethods= By.xpath("//div[@class='dx-popup-content']//div[@class='dx-scrollview-content']//div[@class='dx-item-content dx-list-item-content']"); // Элемент списка форм рассылки
    private final By elementListDistributionReports = By.xpath("//div[@class='dx-scrollview-content']//div[@class='dx-item dx-list-item']/div"); // Элемент списка отчетов

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

    public void typePinCode(String pincode){
        find(fieldPinCode).sendKeys(pincode);
    } // Ввести пинкод

    public void typeEmailDistribution(String email){
        find(fieldEmailDistribution).sendKeys(email);
        find(fieldEmailDistribution).sendKeys(Keys.ENTER);
    } // Ввести почту рассылки

    public void dragAndDropFilter(By filter){
        withAction().dragAndDrop(find(filter), find(filterRoot)).build().perform();
    } // Перетащить фильтр в область построения дерева фильтров

    public void typeNameAutoSearch(String name){
        find(fieldNameAutoSearch).sendKeys(name);
    } // Ввести название автопоиска

    public void typeSearchInsideFilterNameTender(String search){
        find(fieldSearchByNameTender).sendKeys(search);
    } // Ввести значение в поле название тендера

    public void checkTestAutoSearch(){

        try {
            if (find(elementListAutoSearch).getText().equals("Тестовый автопоиск")) {
                clickButton(buttonDeleteAutoSearchInListAutoSearch);
                find(buttonAcceptDeletedAutoSearch).waitUntilClickable();
                clickButton(buttonAcceptDeletedAutoSearch);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    } // проверка наличия тестового автопоиска и его удаление

    public boolean isVisibleDateCreateDistribution(){
        return find(activationDateDistribution).isVisible();
    } // Проверка отображения даты включения рассылки

    public String isCorrectStatusDistribution(){
        return find(statusDistribution).getText();
    } // Получение статуса рассылки

    public boolean isContainCorrectDateCreateDistribution(){
        Date date = new Date();
        SimpleDateFormat formatterDate = new SimpleDateFormat("dd.MM.yyyy");
        SimpleDateFormat formatterTime = new SimpleDateFormat("HH:mm");

        return find(activationDateDistribution).getText().contains(formatterDate.format(date)) && find(activationDateDistribution).getText().contains(formatterTime.format(date));

    } // Проверка соответствия даты включения рассылки и текущей даты

    public String isCorrectErrorMessageWithEmptyAccountForDistribution(){
        return find(errorMessageWithEmptyAccountForDistribution).getText();
    } // Получение ошибки при сохранении автопоиска без почты или телеграмма для рассылки

    public String isCorrectErrorMessageWithEmptyFieldPinCode(){
        return find(errorMessageWithFieldPinCode).getText();
    } // Получение ошибки при пустом поле "Пинкод"

    public String isCorrectErrorMessageWithWrongPinCode(){
        return find(errorMessageWithFieldPinCode).getText();
    } // Получение ошибки при некорректном заполнении поля 'Пинкод'

    public boolean isVisibleErrorMessageWithEmptyAccountForDistribution(){
        return find(errorMessageWithEmptyAccountForDistribution).isVisible();
    } // Проверка отображения ошибки при сохранении автопоиска без почты или телеграмма для рассылки

    public boolean isVisibleErrorMessageWithEmptyFieldPinCode(){
        return find(errorMessageWithFieldPinCode).isVisible();
    } // Проверка отображения ошибки при пустом поле "Пинкод"

    public boolean isVisibleErrorMessageWithWrongPinCode(){
        return find(errorMessageWithFieldPinCode).isVisible();
    } // Проверка отображения ошибки при некорректном заполнении поля 'Пинкод'

    public boolean isVisibleAccountAndAddressDistributionForChildUser(){
        return find(blockAccountAndAddressForDistribution).isVisible();
    } // Проверка отображения блока аккаунтов и адресов рассылки для дочернего пользователя

    public boolean isVisibleFieldsDistributionForChildUser(){
        return find(blockDistributionFields).isVisible();
    } // Проверка отображения блока полей рассылки для дочернего пользователя

    public boolean isVisibleDaysDistributionForChildUser(){
        return find(blockDaysDistribution).isVisible();
    } // Проверка отображения блока дней рассылки для дочернего пользователя

    public boolean isVisibleTimesDistributionForChildUser(){
        return find(blockTimeDistribution).isVisible();
    } // Проверка отображения блока времени рассылки для дочернего пользователя

    public boolean isNotSelectedCheckboxFriday(){
        return find(checkboxFriday).getAttribute("aria-checked").equals("false");
    } // Проверка чекбокса "Пятница"

    public boolean isSelectedCheckboxSaturday(){
        return find(checkboxSaturday).getAttribute("aria-checked").equals("true");
    } // Проверка чекбокса "Суббота"

    public boolean isContainCorrectFieldsForDistribution(String filePath) throws IOException {

        List<String> fieldsForDistribution = findAll(elementOfListFieldsForDistribution).textContents();
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), StandardCharsets.UTF_8));

        String str;
        str = br.readLine();

        List<String> ar= List.of(str.split(Pattern.quote(". ")));

        return fieldsForDistribution.equals(ar);
    } // Проверка списка полей для рассылки

    public boolean isCorrectDefaultFieldsInBlockForDistribution(){

        List<String> defaultSelectedFieldsForDistribution = findAll(selectedElementOfListFieldsForDistribution).textContents();
        List<String> defaultFieldsInBlockForDistribution = findAll(elementInBlockFieldsForDistribution).textContents();

        Collections.sort(defaultSelectedFieldsForDistribution);
        Collections.sort(defaultFieldsInBlockForDistribution);

        return defaultSelectedFieldsForDistribution.equals(defaultFieldsInBlockForDistribution);
    } // Проверка соответствия списка полей для рассылки по умолчанию

    public boolean isCorrectListDistributionMethods(){

        List<String> distributionMethods = findAll(elementListDistributionMethods).texts();
        List<String> checkArray = new ArrayList<>();

        checkArray.add("Письмо - карточки");
        checkArray.add("Письмо - таблица");
        checkArray.add("Отчет");

        return distributionMethods.equals(checkArray);
    } // Проверка списка форм рассылки

    public boolean isCorrectListDistributionReportsIncludeChildUserReport(){

        List<String> distributionReports = findAll(elementListDistributionReports).texts();

        return distributionReports.contains("Тестовый отчет");
    } // Проверка наличия в списке отчетов отчета дочернего пользователя

    public boolean isCorrectListDistributionReportsIncludeMainUserReport(){

        List<String> distributionReports = findAll(elementListDistributionReports).texts();

        return distributionReports.contains("Тестовый отчет 2");
    } // Проверка наличия в списке отчетов отчета родительского пользователя

}
