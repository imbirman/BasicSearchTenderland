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
        steps.is_default_selected_table_view();
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

    @Test
    @Title("Проверка, что выбран чекбокс 'Раскрывать карточки'")
    public void checkSelectedCheckboxOpenCards(){
        steps.click_button(buttonOpenWindowCustomView);
        steps.click_button(buttonAccordionSettings);
        steps.click_button(radiobuttonCardView);
        steps.click_button(checkboxOpenCards);
        steps.is_selected_checkbox_open_cards();
    }

    @Test
    @Title("Проверка сохранения изменений в настройках пользовательского вида")
    public void checkSaveChangesInCustomViewSettings(){
        steps.click_button(buttonOpenWindowCustomView);
        steps.click_button(buttonAccordionSettings);
        steps.click_button(radiobuttonCardView);
        steps.click_button(buttonSaveCustomView);
        steps.click_button(buttonCloseWindowCustomView);
        steps.click_button(buttonOpenWindowCustomView);
        steps.click_button(buttonAccordionSettings);
        steps.is_selected_card_view();
        steps.click_button(radiobuttonTableView);
        steps.click_button(buttonSaveCustomView);
    }

    @Test
    @Title("Проверка сохранения выбранного табличного/карточного вида в настройке примененного пользовательского вида после смены вида не в настройке пользовательского вида")
    public void checkSaveSelectedTableViewAfterChangeViewResultSearch(){
        steps.click_button(tabListAutoSearch);
        steps.click_button(buttonCheckTenderNameAndNameDeletion);
        steps.wait_a_bit(500);
        steps.click_button(buttonOpenListCustomView);
        steps.click_button(buttonItemCustomViewTestView);
        steps.wait_a_bit(1000);
        steps.click_button(buttonCardView);
        steps.click_button(buttonOpenWindowCustomView);
        steps.click_button(buttonAccordionSettings);
        steps.is_selected_table_view();
    }

    @Test
    @Title("Проверка отображение кнопки выгрузки продуктов из детализации")
    public void checkDisplayedButtonUnloadProducts(){
        steps.click_button(tabListAutoSearch);
        steps.click_button(buttonCheckTenderNameAndNameDeletion);
        steps.wait_a_bit(500);
        steps.click_button(buttonCardView);
        steps.click_button(buttonOpenDetailing);
        steps.is_displayed_button_unload_products();
    }

}
