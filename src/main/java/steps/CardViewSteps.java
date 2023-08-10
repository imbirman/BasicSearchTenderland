package steps;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import pages.CardView;

public class CardViewSteps {

    CardView page;

    @Step("Открытие страницы")
    public void open_login_main_page() {page.open();}

    @Step("Нажать кнопку")
    public void click_button(By button){
        page.clickButton(button);
    }

    @Step("Нажать кнопку")
    public void click_button(WebElementFacade button){
        page.clickButton(button);
    }

    @Step("Ввод логина")
    public void type_login(String mail){
        page.typeLogin(mail);
    }

    @Step("Ввод пароля")
    public void type_password(String password){
        page.typePassword(password);
    }

    @Step("Ожидание")
    public void wait_a_bit(long number){
        page.waitFor(number);
    }

    @Step("Проверка отображения блока для раскрытия карточки")
    public void is_displayed_block_open_cards(){
        assertThat(page.isDisplayedBlockOpenCards()).as("Блок для раскрытия карточки отсутствует").isTrue();
    }

    @Step("Проверка, что по умолчанию выбран табличный вид")
    public void is_default_selected_table_view(){
        assertThat(page.isSelectedTableView()).as("по умолчанию НЕ выбран табличный вид").isTrue();
    }

    @Step("Проверка, что выбран табличный вид")
    public void is_selected_table_view(){
        assertThat(page.isSelectedTableView()).as("Табличный вид НЕ выбран").isTrue();
    }

    @Step("Проверка, что карточный вид выбран")
    public void is_selected_card_view(){
        assertThat(page.isSelectedCardView()).as("Карточный вид НЕ выбран").isTrue();
    }

    @Step("Проверка, что чекбокс 'Раскрывать карточки' выбран")
    public void is_selected_checkbox_open_cards(){
        assertThat(page.isSelectedCheckboxOpenCards()).as("Чекбокс 'Раскрывать карточки' НЕ выбран").isTrue();
    }
}
