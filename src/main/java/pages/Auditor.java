package pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@DefaultUrl("https://test.v2.tenderland.ru/Home/Landing")
public class Auditor extends PageObject {

    protected By tabListAutoSearch = By.xpath("//div[@class='search-filters-tab list-autosearches']"); // Вкладка "Автопоиски"
    protected By openTabMenu = By.xpath("//i[@class='material-icons-round icon-28px icon-grey md-menu icon-grey-hover common-header-icon']"); // Кнопка открытия бокового меню

    protected By buttonLogin = By.xpath("//a[text()='Войти']"); // Кнопка входа в систему
    protected By buttonSignIn = By.xpath("//span[text()='Войти в систему']"); // Кнопка "Войти в систему"
    protected By buttonApply = By.id("filter-apply-button"); // Кнопка "Применить"
    protected By buttonReset = By.id("filter-cancel-button"); // Кнопка "Сбросить"
    protected By buttonSearch = By.id("search-filters-search-button"); // Кнопка "Поиск"
    protected By buttonTabMenuAuditor = By.xpath("//div[text()='Ревизор']"); // Кнопка открытия ревизора
    protected By buttonAutoSearchDateRegistration = By.xpath("//div[text()='Проверка поиска по дате регистрации']"); // Кнопка автопоиска "Проверка поиска по дате регистрации"
    protected By buttonAutoSearchDateClosing = By.xpath("//div[text()='Проверка поиска по дате закрытия']"); // Кнопка автопоиска "Проверка поиска по дате закрытия"
    protected By buttonOpenListFounders = By.id("entity-persons-popover"); // Кнопка для открытия списка учредителей
    protected By buttonOpenListAllTenders = By.id("entity-all-tenders"); // Кнопка для открытия списка тендеров
    protected By buttonOpenListFASClaim  =By.id("entity-all-fas-organizations"); // Кнопка для открытия списка жалоб ФАС
    protected By buttonOpenListEnforcementProceedings = By.id("entity-all-enforcement-proceedings"); // Кнопка для открытия списка исполнительных производств
    protected By buttonOpenListContracts = By.id("entity-all-contracts-organizations"); // Кнопка для открытия списка контрактов
    protected By buttonOpenListArbitrationCases = By.id("entity-cases-organizations"); // Кнопка для открытия списка арбитражных дел
    protected By buttonOpenListArbitrationCasesOnAffiliates = By.id("entity-affilated-cases-organizations"); // Кнопка для открытия списка арбитражных дел по аффилированным лицам

    protected By filterOrganizationDetails = By.xpath("//span[text()='Реквизиты организации']"); // Фильтр "Реквизиты организации" в блоке фильтров
    protected By filterSearchByFounders = By.xpath("//span[text()='Поиск по учредителям']"); // Фильтр "Поиск по учредителям" в блоке фильтров
    protected By filterSearchByLegalStatus = By.xpath("//span[text()='Юридический статус']"); // Фильтр "Юридический статус" в блоке фильтров
    protected By filterSearchByStatusOfBeingInRNP = By.xpath("//span[text()='Статус нахождения в РНП']"); // Фильтр "Статус нахождения в РНП" в блоке фильтров

    protected By tabMenuAuditorFounders = By.xpath("//div[@id='main-tabs']//div[text()='Учредители']"); // Вкладка в карточке организации "Учредители"
    protected By tabLeftMenuRNP = By.xpath("//div[@id='entity-card-menu']//div[text()='Реестр недобросовестных поставщиков']"); // Вкладка в карточке организации "Реестр недобросовестных поставщиков"
    protected By cellTableInResultSearch = By.xpath("(//div[@class='dx-datagrid-content']//tbody[@role='presentation']/tr)[1]"); // Строка таблицы результатов поиска для открытия карточки организации

    protected By radioButtonCurrentLegalStatus = By.xpath("(//div[@class='dx-radiobutton-icon'])[1]"); // пункт "Действующая" фильтра "Юридический статус"
    protected By radioButtonInactiveLegalStatus = By.xpath("(//div[@class='dx-radiobutton-icon'])[2]"); // пункт "Недействующая" фильтра "Юридический статус"
    protected By radioButtonNeverBeenInRNP = By.xpath("(//div[@class='dx-radiobutton-icon'])[1]"); // Никогда не находился в РНП
    protected By radioButtonFormerlyInRNP = By.xpath("(//div[@class='dx-radiobutton-icon'])[2]"); // Ранее находился в РНП
    protected By radioButtonLocatedInRNP = By.xpath("(//div[@class='dx-radiobutton-icon'])[3]"); // Находится в РНП

    protected By contextMenu = By.xpath("//td[@class='dx-command-edit dx-command-edit-with-icons']//a[@class='dx-link dx-icon-overflow dx-link-icon']"); // Контекстное меню в таблице результатов поиска
    protected By elementContextMenu = By.xpath("//div[@class='dx-submenu']//div[@class='dx-item dx-menu-item']/div/div"); // Элемент контекстного меню
    protected By fieldMainDataForScroll = By.xpath("//div[@class='tl-page']"); // Блок с основной информацией для прокрутки
    protected By headerBlockMainInfo = By.xpath("//div[@id='main-info-blocks']//div[@class='tl-entity-blocks-header']"); // Заголовок блока с основной информацией
    protected By headerBlockTendersInfo = By.xpath("(//div[@id='entity-menu']//div[@class='dx-item dx-list-item'])[2]"); // Заголовок блока с тендерной информацией
    protected By headerBlockArbitrationInfo = By.xpath("(//div[@id='entity-menu']//div[@class='dx-item dx-list-item'])[3]"); // Заголовок блока с арбитражной информацией

    private final By loginField = By.xpath("//input[@type='text']"); // Поле для ввода логина
    private final By passwordField = By.xpath("//input[@type='password']"); // Поле для ввода пароля
    private final By filterRoot = By.xpath("//div[@class='dx-sortable tl-filter-content tl-filter-drop-area']"); // Поле дерева фильтров
    private final By fieldSearchInclude = By.xpath("//textarea[@class='dx-texteditor-input dx-texteditor-input-auto-resize']"); // Поле поиска "Включаем в поиск"
    private final By nameFounders = By.xpath("//div[@class='entity-organization-person']//div[@class='main-bold-text'][1]"); // ФИО учредителя
    private final By organizationStatus = By.xpath("(//span[@class='header-info-block-value'])[1]"); // Статус организации
    private final By parameterLocatedInRNP = By.xpath("//div[contains(text(), 'РНП')]//div[1]"); // Пометка находится ли организация в настоящий момент в РНП
    private final By parameterTotalEntriesInRegistry = By.xpath("//div[text()='Всего записей в реестре']/following::div[1]"); // В разделе РНП поле "Всего записей в реестре"
    private final By nameWindowBlock = By.xpath("//div[@class='entity-block']//div[@class='entity-block-header']"); // Название окна блока с учредителями


    public void waitFor(long number){
        waitABit(number);
    } // Ожидание

    public void clickButton(By button){
        find(button).click();
    } // Кликнуть по кнопке / выбрать radiobutton или checkbox

    public void clickButton(WebElementFacade button){
        button.click();
    } // Кликнуть по кнопке / выбрать radiobutton или checkbox

    public void clearField(By field){find(field).clear();} // Очистить поле

    public void typeLogin(String login){
        find(loginField).sendKeys(login);
    } // Ввести логин для входа

    public void typePassword(String password){
        find(passwordField).sendKeys(password);
    } // Ввести пароль для входа

    public void typeSearchInclude(String search){
        find(fieldSearchInclude).sendKeys(search);
    }

    public void dragAndDropFilter(By filter){
        withAction().dragAndDrop(find(filter), find(filterRoot)).build().perform();
    } // Перетащить фильтр в область построения дерева фильтров

    public void doubleClickButton(By button){
//        find(button).click();
        withAction().doubleClick(find(button)).build().perform();
    } // Двойной клик

    public void switchToTab(){

        for(String windowHandle : getDriver().getWindowHandles()) {
            getDriver().switchTo().window(windowHandle);
        }
    } // Переключиться на следующую вкладку

    public void scrollDownTo(By scroll){
        ((JavascriptExecutor)getDriver()).executeScript(
                "arguments[0].scrollTop = -1 >>> 1", find(scroll));
    } // Прокрутить содержимое элемента вниз

    public Auditor scrollWindowOnPixels(String number){
        ((JavascriptExecutor)getDriver()).executeScript(
                "window.scrollBy(0," + number + ")");
        return this;
    } // Прокрутить окно на заданное количество пикселей

    public String getNameWindowBlock(){
        return find(nameWindowBlock).getText();
    } // Получить название окна блока

    public boolean isContainOrganizationDetail(){
        List<String> checkOrganizationDetail = findAll(cellTableInResultSearch).texts();
        checkOrganizationDetail.remove(checkOrganizationDetail.size()-1);
        boolean checkIsContainOrganizationDetail = true;
        for(String type : checkOrganizationDetail){
            if(!type.equals("234703774440")){
                checkIsContainOrganizationDetail = false;
                break;
            }
        }
        return checkIsContainOrganizationDetail;
    } // Проверка, что ИНН организации соответствует поисковому запросу

    public boolean isContainNameFounders(){
        List<String> checkNameFounders = findAll(nameFounders).texts();
        boolean checkIsContainNameFounders = false;
        for(String type : checkNameFounders){
            if(type.contains("иванов") || type.contains("Иванов") || type.contains("ИВАНОВ")){
                checkIsContainNameFounders = true;
                break;
            }
        }
        return checkIsContainNameFounders;
    } // Проверка, что наименование учредителя включает ключевое слово

    public boolean isContainCurrentLegalData(){
        return find(organizationStatus).getText().equals("Действующая");
    } // Проверка, что организация действующая

    public boolean isContainInactiveLegalData(){
        return find(organizationStatus).getText().equals("Недействующая");
    } // Проверка, что организация недействующая

    public boolean isNeverBeenInRNP(){
        int checkTotalEntriesInRegistry;
        String parameterToCheck = find(parameterTotalEntriesInRegistry).getText();
        if(parameterToCheck.equals("-")){ checkTotalEntriesInRegistry = 0;}else{
        checkTotalEntriesInRegistry = Integer.parseInt(find(parameterTotalEntriesInRegistry).getText());}
        return checkTotalEntriesInRegistry == 0 && find(parameterLocatedInRNP).getText().equals("Не находится в реестре недобросовестных поставщиков");
    } // Проверка, что организация никогда не была в РНП

    public boolean isFormerlyBeenInRNP(){
        int checkTotalEntriesInRegistry;
        String parameterToCheck = find(parameterTotalEntriesInRegistry).getText();
        if(parameterToCheck.equals("-")){ checkTotalEntriesInRegistry = 0;}else{
        checkTotalEntriesInRegistry = Integer.parseInt(parameterToCheck);}
        return checkTotalEntriesInRegistry != 0 && find(parameterLocatedInRNP).getText().equals("Не находится в реестре недобросовестных поставщиков");
    } // Проверка, что организация была раньше в РНП

    public boolean isLocatedInRNP(){
        int checkTotalEntriesInRegistry;
        checkTotalEntriesInRegistry = Integer.parseInt(find(parameterTotalEntriesInRegistry).getText());
        return checkTotalEntriesInRegistry != 0 && find(parameterLocatedInRNP).getText().equals("Находится в реестре недобросовестных поставщиков");
    } // Проверка, что организация находится в РНП

    public boolean isCorrectNumberElementsContextMenu(){
        return findAll(elementContextMenu).size() >= 2;
    } // Проверка количества элементов контекстного меню

    public boolean isCorrectNameElementsContextMenu(){
        List<String> listElementsContextMenu = findAll(elementContextMenu).texts();

        List <String> checkElementsContextMenu = new ArrayList<>();
        checkElementsContextMenu.add("Скрыть организацию");
        checkElementsContextMenu.add("Назначить метку");
        checkElementsContextMenu.add("Отметить просмотренным");

        return listElementsContextMenu.equals(checkElementsContextMenu);
    } // Проверка списка элементов контекстного меню

    public boolean isCorrectDate(String startDate, String endDate) throws ParseException {
        boolean check = true;
        List<WebElementFacade> dateForCheck = findAll(cellTableInResultSearch);
        dateForCheck.remove(dateForCheck.size()-1);
        for(WebElementFacade date : dateForCheck) {
            String dateStr = date.getText();
//            dateStr = dateStr.replace("0:00", "");
//            dateStr = dateStr.replace("\n", " ");
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
            Date currentDate = dateFormat.parse(dateStr);
            Date leftDate = dateFormat.parse(startDate);
            Date rightDate = dateFormat.parse(endDate);
            if(!(currentDate.getTime() >= leftDate.getTime() && currentDate.getTime() <= rightDate.getTime())){
                check = false;
                break;
            }
//            System.out.println(date.getText());
        }
        return check;
    } // Проверка, что дата публикации находится в заданном диапазоне

    public boolean isClickableButtons(){
        boolean check = true;
        List<Boolean> listClickable = new ArrayList<>();
        listClickable.add(find(buttonOpenListFounders).isClickable());
        scrollWindowOnPixels("600");
        listClickable.add(find(buttonOpenListAllTenders).isClickable());
        scrollWindowOnPixels("600");
        listClickable.add(find(buttonOpenListContracts).isClickable());
        listClickable.add(find(buttonOpenListFASClaim).isClickable());
        listClickable.add(find(buttonOpenListEnforcementProceedings).isClickable());
        listClickable.add(find(buttonOpenListArbitrationCases).isClickable());
        listClickable.add(find(buttonOpenListArbitrationCasesOnAffiliates).isClickable());
        System.out.println(listClickable);
        for(boolean type:listClickable){
            if(!type){check = false; break;}
        }
        return  check;
    } // Проверка кликабельности кнопок блоков



    public boolean isCorrectNameFounders(){
        List<String> listFounders = findAll(nameFounders).texts();
//        listFounders.remove(listFounders.size()-1);
        List<String> checkFounders = new ArrayList<>();
        checkFounders.add("ДЕГОДЬЕВА ВЕРА ВАСИЛЬЕВНА");
        checkFounders.add("ПЕРЕВАЛОВ ВЛАДИМИР ВИКТОРОВИЧ");

        return listFounders.equals(checkFounders);
    }

}
