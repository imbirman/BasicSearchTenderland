package testpackage;


import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import pages.AutoSearchPage;
import steps.AutoSearchSteps;

import java.text.ParseException;

@RunWith(SerenityRunner.class)
public class WhenAutoSearch extends AutoSearchPage {

    @Managed(driver = "chrome", uniqueSession=true)
    WebDriver driver;


    @Steps
    AutoSearchSteps steps;

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
        steps.click_field(fieldNameTender);
        steps.type_name_tender("Муcор");
        steps.click_button(checkBoxTransliteration);
        steps.click_button(buttonSearch);
        steps.waitFor();
        steps.check_name_tender_to_include_keyword();
    }

//    @Test
//    @Title("Проверка даты публикации тендера")
//    public void checkPublicationDateOfTender() throws ParseException {
//
//        steps.open_login_main_page();
//        steps.click_button(logInButton);
//        steps.type_login("AdminTestit");
//        steps.type_password("Hyqpmaz0");
//        steps.click_button(signInButton);
//        steps.click_button(tabListAutoSearch);
//        steps.click_button(buttonCheckPublicationDate);
//        steps.waitFor();
//        steps.click_button(filterPublicationDate);
//        steps.click_field(fieldPublicationDateFrom);
//        steps.click_field(fieldPublicationDateTo);
////        steps.typePublicationDateFrom("09.01.2021");
////        steps.typePublicationDateTo("09.01.2021");
////        steps.clickButton(buttonSearch);
////        steps.waitFor();
////        steps.check_publication_date_of_tender("09.01.2021 00:00","09.01.2021 23:59");
//
//    }
}
