package testpackage;


import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import pages.AutoSearchPage;
import steps.AutoSearchSteps;

import java.text.ParseException;

@RunWith(SerenityRunner.class)
public class WhenAutoSearch extends AutoSearchPage {

//    WebDriver driver;

    @Managed(driver = "chrome", uniqueSession=true)
    WebDriver driver;



    @Steps
    AutoSearchSteps steps;

    @Before
    public void beforeMethod(){
        driver.manage().window().maximize();
    }


    @Test
    @Title("Проверка входа")
    public void checkSignIn(){

        steps.open_login_main_page();
        steps.click_button(logInButton);
        steps.type_login("AdminTestit");
        steps.type_password("Hyqpmaz0");
        steps.click_button(signInButton);
        steps.check_text_login();
    }

    @Test
    @Title("Проверка результатов поиска для автопоиска 'Проверка поиска по реестровому номеру и региону'")
    public void checkRegistryNumber(){

        steps.open_login_main_page();
        steps.click_button(logInButton);
        steps.type_login("AdminTestit");
        steps.type_password("Hyqpmaz0");
        steps.click_button(signInButton);
        steps.click_button(tabListAutoSearch);
        steps.click_button(buttonAutoSearchRegistryNumberAndRegion);
        steps.check_number_result_search();
        steps.check_registry_number();
    }

    @Test
    @Title("Проверка увеличения количества результатов поиска при добавлении значения региона")
    public void checkNumberResultSearchAfterAddingRegionValue(){

        steps.open_login_main_page();
        steps.click_button(logInButton);
        steps.type_login("AdminTestit");
        steps.type_password("Hyqpmaz0");
        steps.click_button(signInButton);
        steps.click_button(tabListAutoSearch);
        steps.click_button(buttonAutoSearchRegistryNumberAndRegion);
        steps.click_button(filterRegionRoot);
        steps.waitFor();
        steps.typeSearch("Москва");
        steps.waitFor();
        steps.clickButton(getCheckboxByNumber(3));
        steps.click_button(buttonApply);
        steps.click_button(buttonSearch);
        steps.check_registry_number_after_adding_region_value();
    }

    @Test
    @Title("Проверка названия тендера на включение в него ключевого слова")
    public void checkNameTenderToIncludeKeyword(){

        steps.open_login_main_page();
        steps.click_button(logInButton);
        steps.type_login("AdminTestit");
        steps.type_password("Hyqpmaz0");
        steps.click_button(signInButton);
        steps.click_button(tabListAutoSearch);
        steps.click_button(buttonCheckTenderNameAndNameDeletion);
        steps.waitFor();
        steps.check_name_tender_to_include_keyword();
    }

    @Test
    @Title("Проверка исключения из названия тендера ключевого слова")
    public void checkDeletionNameTenderToIncludeKeyword(){

        steps.open_login_main_page();
        steps.click_button(logInButton);
        steps.type_login("AdminTestit");
        steps.type_password("Hyqpmaz0");
        steps.click_button(signInButton);
        steps.click_button(tabListAutoSearch);
        steps.click_button(buttonCheckTenderNameAndNameDeletion);
        steps.waitFor();
        steps.click_button(filterNameTender);
        steps.typeDeletion("Мусоровоз");
        steps.click_button(buttonSearch);
        steps.waitFor();
        steps.check_deletion_name_tender_to_include_keyword();
    }

    @Test
    @Title("Проверка транслитерации при поиске по названию тендера")
    public void checkTransliterationNameTender(){

        steps.open_login_main_page();
        steps.click_button(logInButton);
        steps.type_login("AdminTestit");
        steps.type_password("Hyqpmaz0");
        steps.click_button(signInButton);
        steps.click_button(tabListAutoSearch);
        steps.click_button(buttonCheckTenderNameAndNameDeletion);
        steps.waitFor();
        steps.click_button(filterNameTender);
        steps.clear_field(fieldNameTender);
        steps.type_name_tender("Муcор");
        steps.click_button(checkBoxTransliteration);
        steps.click_button(buttonSearch);
        steps.waitFor();
        steps.check_name_tender_to_include_keyword();
    }

    @Test
    @Title("Проверка даты публикации тендера")
    public void checkPublicationDateOfTender() throws ParseException {

        steps.open_login_main_page();
        steps.click_button(logInButton);
        steps.type_login("AdminTestit");
        steps.type_password("Hyqpmaz0");
        steps.click_button(signInButton);
        steps.click_button(tabListAutoSearch);
        steps.click_button(buttonCheckPublicationDate);
        steps.waitFor();
        steps.click_button(filterPublicationDate);
        steps.click_button(buttonClearFieldDateFrom);
        steps.type_date_from("09.01.2021");
        steps.click_button(buttonClearFieldDateTo);
        steps.type_date_to("09.01.2021");
        steps.click_button(tableCellToCheck);
        steps.click_button(buttonSearch);
        steps.waitFor();
        steps.check_date("09.01.2021 00:00","09.01.2021 23:59");
    }

    @Test
    @Title("Проверка даты начала подачи заявок")
    public void checkStartSubmissionOfApplication() throws ParseException {

        steps.open_login_main_page();
        steps.click_button(logInButton);
        steps.type_login("AdminTestit");
        steps.type_password("Hyqpmaz0");
        steps.click_button(signInButton);
        steps.click_button(tabListAutoSearch);
        steps.click_button(buttonCheckStartSubmissionOfApplicationDate);
        steps.waitFor();
        steps.click_button(filterStartSubmissionOfApplication);
        steps.click_button(buttonClearFieldDateFrom);
        steps.type_date_from("04.01.2021");
        steps.click_button(buttonClearFieldDateTo);
        steps.type_date_to("04.01.2021");
        steps.click_button(tableCellToCheck);
        steps.click_button(buttonSearch);
        steps.waitFor();
        steps.check_date("04.01.2021 00:00","04.01.2021 23:59");
    }

    @Test
    @Title("Проверка даты окончания подачи заявок")
    public void checkEndSubmissionOfApplication() throws ParseException {

        steps.open_login_main_page();
        steps.click_button(logInButton);
        steps.type_login("AdminTestit");
        steps.type_password("Hyqpmaz0");
        steps.click_button(signInButton);
        steps.click_button(tabListAutoSearch);
        steps.click_button(buttonCheckEndSubmissionOfApplicationDate);
        steps.waitFor();
        steps.click_button(filterEndSubmissionOfApplication);
        steps.click_button(buttonClearFieldDateFrom);
        steps.type_date_from("03.01.2021");
        steps.click_button(buttonClearFieldDateTo);
        steps.type_date_to("03.01.2021");
        steps.click_button(tableCellToCheck);
        steps.click_button(buttonSearch);
        steps.waitFor();
        steps.check_date("03.01.2021 00:00","03.01.2021 23:59");
    }

    @Test
    @Title("Проверка даты проведения тендера")
    public void checkValidateSearchByTenderDate() throws ParseException {

        steps.open_login_main_page();
        steps.click_button(logInButton);
        steps.type_login("AdminTestit");
        steps.type_password("Hyqpmaz0");
        steps.click_button(signInButton);
        steps.click_button(tabListAutoSearch);
        steps.click_button(buttonValidateSearchByTenderDate);
        steps.waitFor();
        steps.click_button(filterValidateSearchByTenderDate);
        steps.click_button(buttonClearFieldDateFrom);
        steps.type_date_from("12.01.2021");
        steps.click_button(buttonClearFieldDateTo);
        steps.type_date_to("12.01.2021");
        steps.click_button(tableCellToCheck);
        steps.click_button(buttonSearch);
        steps.waitFor();
        steps.check_date("12.01.2021 00:00","12.01.2021 23:59");
    }
}
