package pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;

import java.util.List;

@DefaultUrl("https://test.v2.tenderland.ru/Home/Landing")
public class UserManagement extends PageObject {

    protected By openTabMenu = By.xpath("//i[@class='material-icons-round icon-28px icon-grey md-menu icon-grey-hover common-header-icon']"); // Кнопка открытия бокового меню
    protected By buttonMyTenders = By.xpath("//div[text()='Мои тендеры']"); // Кнопка в боковом меню "Мои тендеры"

    protected By buttonLogin = By.xpath("//a[text()='Войти']"); // Кнопка входа в систему
    protected By buttonSignIn = By.xpath("//span[text()='Войти в систему']"); // Кнопка "Войти в систему"

    protected By buttonUserManagement = By.xpath("//div[@id='manage-users']//span"); // Кнопка "Управление пользователями"
    protected By buttonAddUser = By.xpath("//div[@id='tl-popup-add-new-user-button']//span"); // Кнопка "Добавить пользователя"
    protected By buttonDeleteUser = By.id("tl-popup-delete-user-button"); // Кнопка "Удалить" в окне "Управление пользователями"
    protected By buttonSaveUser = By.id("tl-popup-save-user-button"); // Кнопка "Сохранить" в окне "Управление пользователями"
    protected By buttonCloseUserManagement = By.xpath("//div[@class='dx-toolbar-after']//i"); // Кнопка закрытия окна управления пользователями
    protected By buttonCloseWindowAcceptDeleteUser = By.xpath("//span[@class='mdi mdi-close']"); // Крестик для закрытия окна подтверждения удаления пользователя
    protected By buttonAcceptDeleted = By.id("tl-popup-approve-button"); // Кнопка подтверждения удаления
    protected By buttonCancelDeleted = By.id("tl-popup-close-button"); // Кнопка отмены удаления

    protected By fieldUserRole = By.xpath("//div[@id='tl-manage-user-role']//div[@class='dx-texteditor-input-container']//input"); // Поле роли пользователя
    protected By fieldSelectUserRole = By.xpath("//div[@id='tl-manage-user-role']"); // Поле выбора роли пользователя

    protected By elementUser = By.xpath("//div[@id='tl-popup-main-list']//div[@class='dx-item-content dx-list-item-content']"); // Элемент списка пользователей
    protected By elementUserRole = By.xpath("//div[@class='dx-overlay-content dx-popup-normal dx-resizable']//div[@class='dx-item-content dx-list-item-content']"); // Элемент списка ролей пользователя

    private final By loginField = By.xpath("//input[@type='text']"); // Поле для ввода логина
    private final By passwordField = By.xpath("//input[@type='password']"); // Поле для ввода пароля
    private final By fieldLastNameUser = By.xpath("//div[@id='tl-manage-user-surname']//input"); // Поле для ввода фамилии пользователя
    private final By lastNameUserEmptyError = By.xpath("//div[@id='tl-manage-user-surname']//div[@class='dx-overlay-content dx-invalid-message-content']"); // Текст ошибки при пустом поле "Фамилия" при сохранении пользователя
    private final By fieldNameUser = By.xpath("//div[@id='tl-manage-user-name']//input"); // Поле для ввода имени пользователя
    private final By fieldPatronymicUser = By.xpath("//div[@id='tl-manage-user-patronymic']//input"); // Поле для ввода отчества пользователя
    private final By fieldLoginUser = By.xpath("//div[@id='tl-manage-user-login']//input"); // Поле для ввода логина пользователя
    private final By emptyLoginUserError = By.xpath("//div[@id='tl-manage-user-login']//div[@class='dx-overlay-content dx-invalid-message-content']"); // Текст ошибки при некорректном поле "Логин" при сохранении пользователя
    private final By fieldPasswordUser = By.xpath("//div[@id='tl-manage-user-password']//input"); // Поле для ввода пароля пользователя
    private final By emptyPasswordUserError = By.xpath("//div[@id='tl-manage-user-password']//div[@class='dx-overlay-content dx-invalid-message-content']"); // Текст ошибки при пустом поле "Пароль" при сохранении пользователя
    private final By fieldRetryPasswordUser = By.xpath("//div[@id='tl-manage-user-password-retry']//input"); // Поле для ввода подтверждения пароля
    private final By notMatchPasswordUserError = By.xpath("//div[@id='tl-manage-user-password-retry']//div[@class='dx-overlay-content dx-invalid-message-content']"); // Текст ошибки при некорректном поле "Повторите пароль" при сохранении пользователя
    private final By fieldEmailUser = By.xpath("//div[@id='tl-manage-user-email']//input"); // Поле для ввода электронной почты пользователя
    private final By emptyUserRoleError = By.xpath("//div[@id='tl-manage-user-role']//div[@class='dx-overlay-content dx-invalid-message-content']"); // Текст ошибки если не выбрана роль пользователя при сохранении пользователя
    private final By windowAcceptDeleteUser = By.xpath("//div[@class='tl-popup-wrapper tl-approve']"); // Окно подтверждения удаления пользователя
    private final By textInWindowAcceptDeleteUser = By.xpath("//span[@class='approve-text']"); // Текст в окне подтверждения удаления пользователя



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

    public void clearField(By field){find(field).clear();} // Очистить поле

    public UserManagement typeLogin(String login){
        find(loginField).sendKeys(login);
        return this;
    } // Ввести логин для входа

    public UserManagement typePassword(String password){
        find(passwordField).sendKeys(password);
        return this;
    } // Ввести пароль для входа

    public UserManagement typeLastNameUser(String lastName){
        find(fieldLastNameUser).sendKeys(lastName);
        return this;
    } // Ввести фамилию пользователя

    public UserManagement typeNameUser(String name){
        find(fieldNameUser).sendKeys(name);
        return this;
    } // Ввести имя пользователя

    public UserManagement typePatronymicUser(String patronymic){
        find(fieldPatronymicUser).sendKeys(patronymic);
        return this;
    } // Ввести отчество пользователя

    public UserManagement typeLoginUser(String login){
        find(fieldLoginUser).sendKeys(login);
        return this;
    } // Ввести логин пользователя

    public UserManagement typePasswordUser(String password){
        find(fieldPasswordUser).sendKeys(password);
        return this;
    } // Ввести пароль пользователя

    public UserManagement typeRetryPasswordUser(String retryPassword){
        find(fieldRetryPasswordUser).sendKeys(retryPassword);
        return this;
    } // Ввести подтверждение пароля пользователя

    public UserManagement typeEmailUser(String email){
        find(fieldEmailUser).sendKeys(email);
        return this;
    } // Ввести электронную почту пользователя

    public WebElementFacade getRoleUser(int number){
        List<WebElementFacade> elementResult = findAll(elementUserRole);
        return elementResult.get(number);
    } // Получить роль пользователя по порядковому номеру

    public WebElementFacade getUser(int number){
        List<WebElementFacade> elementResult = findAll(elementUser);
        return elementResult.get(number);
    } // Получить пользователя по порядковому номеру

    public void checkTestUserForDelete(){
        List<String> elementResult = findAll(elementUser).texts();

        for(String type : elementResult){
            if(type.equals("Тестовый2 Тест2 Тестович2")){
                clickButton(getUser(0));

                clickButton(buttonDeleteUser);
                find(buttonAcceptDeleted).waitUntilClickable();
                clickButton(buttonAcceptDeleted);
                break;
            }
        }
    } // Проверка наличия тестового пользователя и его удаление

    public boolean isNotClickableFieldRetryPassword(){
        return find(fieldRetryPasswordUser).isClickable();
    } // Проверка кликабельности поля "Повторите пароль"

    public boolean isNotClickableButtonDeleteUser(){
        return find(buttonDeleteUser).getAttribute("aria-disabled").equals("true");
    } // Проверка кликабельности кнопки "Удалить" в окне управления пользователями

    public boolean isNotClickableButtonAddUser(){
        return find(buttonAddUser).getAttribute("aria-disabled").equals("true");
    } // Проверка кликабельности кнопки "Добавить пользователя" в окне управления пользователями


    public boolean isPresentErrorEmptyLastNameUser(){
        return find(lastNameUserEmptyError).isPresent() && find(lastNameUserEmptyError).getText().equals("Необходимо ввести фамилию.");
    } // Проверка ошибки при пустом поле "Фамилия" в окне управления пользователями

    public boolean isPresentErrorEmptyLoginUser(){
        return find(emptyLoginUserError).isPresent() && find(emptyLoginUserError).getText().equals("Необходимо ввести логин.");
    } // Проверка ошибки при пустом поле "Логин" в окне управления пользователями

    public boolean isPresentErrorRepeatedLoginUser(){
        return find(emptyLoginUserError).isPresent() && find(emptyLoginUserError).getText().equals("Данный логин уже используется.");
    } // Проверка ошибки при дублирующем поле "Логин" в окне управления пользователями

    public boolean isPresentErrorEmptyPasswordUser(){
        return find(emptyPasswordUserError).isPresent() && find(emptyPasswordUserError).getText().equals("Необходимо ввести пароль.");
    } // Проверка ошибки при пустом поле "Пароль" в окне управления пользователями

    public boolean isPresentErrorShortPasswordUser(){
        return find(emptyPasswordUserError).isPresent() && find(emptyPasswordUserError).getText().equals("Минимальная длина - 6 символов");
    } // Проверка ошибки при коротком пароле в окне управления пользователями

    public boolean isPresentErrorNotMatchPasswordUser(){
        return find(notMatchPasswordUserError).isPresent() && find(notMatchPasswordUserError).getText().equals("Пароли не совпадают");
    } // Проверка ошибки при несовпадении пароля в окне управления пользователями

    public boolean isPresentErrorEmptyRoleUser(){
        return find(emptyUserRoleError).isPresent() && find(emptyUserRoleError).getText().equals("Необходимо выбрать роль.");
    } // Проверка ошибки при отсутствии выбора роли пользователя в окне управления пользователями

    public boolean isPresentAddingUser(){
        List<String> elementResult = findAll(elementUser).texts();
        boolean check = false;
        for(String type : elementResult){
            if(type.equals("Тестовый2 Тест2 Тестович2")){
                check = true;
                break;
            }
        }
        return check;
    } // Проверка наличия добавленного пользователя в списке пользователей

    public boolean isVisibleWindowAcceptDeleteUser(){
        return find(windowAcceptDeleteUser).isDisplayed();
    } // Проверка видимости окна подтверждения

    public String getLastNameUser(){
        return find(fieldLastNameUser).getValue();
    } // Получение фамилии сохраненного пользователя

    public String getNameUser(){
        return find(fieldNameUser).getValue();
    } // Получение имени сохраненного пользователя

    public String getPatronymicUser(){
        return find(fieldPatronymicUser).getValue();
    } // Получение отчества сохраненного пользователя

    public String getRoleUser(){
        return find(fieldUserRole).getValue();
    } // Получение роли сохраненного пользователя

    public String getLoginUser(){
        return find(fieldLoginUser).getValue();
    } // Получение логина сохраненного пользователя

    public String getEmailUser(){
        return find(fieldEmailUser).getValue();
    } // Получение электронной почты сохраненного пользователя

    public String getTextWindowAcceptDeleteUser(){
        return find(textInWindowAcceptDeleteUser).getText();
    } // Получение текста в окне подтверждения удаления пользователя



}
