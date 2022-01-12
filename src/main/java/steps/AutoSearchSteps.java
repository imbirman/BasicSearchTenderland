package steps;

import net.thucydides.core.annotations.Step;
import org.assertj.core.api.Assertions;
import pages.AutoSearchPage;

public class AutoSearchSteps extends AutoSearchPage {

    AutoSearchPage page;

    @Step("Открытие страницы")
    public void open_login_main_page() {page.open();}

    @Step("Ввод логина")
    public void type_login(String mail){
        page.typeLogin(mail);
    } // Ввести данные логина

    @Step("Ввод пароля")
    public void type_password(String password){
        page.typePassword(password);
    } // Ввести данные пароля

    @Step("Проверка логина после входа")
    public void check_text_login(){
        Assertions.assertThat(page.getTextLogin()).as("Логин некорректен, вход ошибочен").isEqualTo("AdminTestit");
    }
}
