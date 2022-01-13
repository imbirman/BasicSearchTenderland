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
        steps.clickButton(logInButton);
        steps.type_login("AdminTestit");
        steps.type_password("Hyqpmaz0");
        steps.clickButton(signInButton);
        steps.check_text_login();
    }

    @Test
    @Title("Проверка результатов поиска для автопоиска 'Проверка поиска по реестровому номеру и региону'")
    public void checkRegistryNumber(){

        steps.open_login_main_page();
        steps.clickButton(logInButton);
        steps.type_login("AdminTestit");
        steps.type_password("Hyqpmaz0");
        steps.clickButton(signInButton);
        steps.clickButton(tabListAutoSearch);
        steps.clickButton(buttonAutoSearchRegistryNumberAndRegion);
        steps.check_number_result_search();
        steps.check_registry_number();
    }

    @Test
    @Title("Проверка увеличения количества результатов поиска при добавлении значения региона")
    public void checkNumberResultSearchAfterAddingRegionValue(){

        steps.open_login_main_page();
        steps.clickButton(logInButton);
        steps.type_login("AdminTestit");
        steps.type_password("Hyqpmaz0");
        steps.clickButton(signInButton);
        steps.clickButton(tabListAutoSearch);
        steps.clickButton(buttonAutoSearchRegistryNumberAndRegion);
        steps.clickButton(filterRegionRoot);
        steps.typeSearch("Москва");
        steps.waitFor();
        steps.clickButton(getCheckboxByNumber(3));
        steps.clickButton(buttonApply);
        steps.clickButton(buttonSearch);
        steps.check_registry_number_after_adding_region_value();
    }

    @Test
    @Title("Проверка названия тендера на включение в него ключевого слова")
    public void checkNameTenderToIncludeKeyword(){

        steps.open_login_main_page();
        steps.clickButton(logInButton);
        steps.type_login("AdminTestit");
        steps.type_password("Hyqpmaz0");
        steps.clickButton(signInButton);
        steps.clickButton(tabListAutoSearch);
        steps.clickButton(buttonCheckTenderNameAndNameDeletion);
        steps.waitFor();
        steps.check_name_tender_to_include_keyword();
    }

    @Test
    @Title("Проверка исключения из названия тендера ключевого слова")
    public void checkDeletionNameTenderToIncludeKeyword(){

        steps.open_login_main_page();
        steps.clickButton(logInButton);
        steps.type_login("AdminTestit");
        steps.type_password("Hyqpmaz0");
        steps.clickButton(signInButton);
        steps.clickButton(tabListAutoSearch);
        steps.clickButton(buttonCheckTenderNameAndNameDeletion);
        steps.waitFor();
        steps.clickButton(filterNameTender);
        steps.typeDeletion("Мусоровоз");
        steps.clickButton(buttonSearch);
        steps.waitFor();
        steps.check_deletion_name_tender_to_include_keyword();
    }

    @Test
    @Title("Проверка транслитерации при поиске по названию тендера")
    public void checkTransliterationNameTender(){

        steps.open_login_main_page();
        steps.clickButton(logInButton);
        steps.type_login("AdminTestit");
        steps.type_password("Hyqpmaz0");
        steps.clickButton(signInButton);
        steps.clickButton(tabListAutoSearch);
        steps.clickButton(buttonCheckTenderNameAndNameDeletion);
        steps.waitFor();
        steps.clickButton(filterNameTender);
        steps.clearField(fieldNameTender);
        steps.typeNameTender("Муcор");
        steps.clickButton(checkBoxTransliteration);
        steps.clickButton(buttonSearch);
        steps.waitFor();
        steps.check_name_tender_to_include_keyword();
    }
}
