package testpackage;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import pages.CardView;
import steps.CardViewSteps;

@RunWith(SerenityRunner.class)
public class TestCardView extends CardView {

    @Managed(driver = "chrome", uniqueSession=true)
    WebDriver driver;


    @Steps
    CardViewSteps steps;

    @Before
    public void beforeMethod(){
        driver.manage().window().maximize();
        steps.open_login_main_page();
        steps.click_button(buttonLogin);
        steps.type_login("AdminTestitTender");
        steps.type_password("Hyqpmaz0");
        steps.click_button(buttonSignIn);
    }

    @Test
    @Title("Проверка отображения блока для раскрытия карточки")
    public void checkDisplayedBlockOpenCards(){
        steps.click_button(buttonOpenWindowCustomView);
        steps.click_button(buttonAccordionSettings);
        steps.click_button(radiobuttonCardView);
        steps.is_displayed_block_open_cards();
    }

    @Test
    @Title("Проверка выбранного табличного вида по умолчанию")
    public void checkDefaultTableView(){
        steps.click_button(buttonOpenWindowCustomView);
        steps.click_button(buttonAccordionSettings);
        steps.is_default_table_view();
    }

    @Test
    @Title("Проверка, что выбор карточного вида сохранился после переоткрытия окна настроек пользовательского вида")
    public void checkSelectedCardView(){
        steps.click_button(buttonOpenWindowCustomView);
        steps.click_button(buttonAccordionSettings);
        steps.click_button(radiobuttonCardView);
        steps.click_button(buttonCloseWindowCustomView);
        steps.click_button(buttonOpenWindowCustomView);
        steps.click_button(buttonAccordionSettings);
        steps.is_selected_card_view();
    }

}
