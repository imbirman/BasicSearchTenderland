package testpackage;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import pages.TabPlans;
import steps.TabPlansSteps;

@RunWith(SerenityRunner.class)
public class WhenTabPlansTest extends TabPlans {

    @Managed(driver = "chrome", uniqueSession=true)
    WebDriver driver;

    @Steps
    TabPlansSteps steps;

    @Before
    public void beforeMethod(){
        driver.manage().window().maximize();
        steps.open_login_main_page();
        steps.click_button(logInButton);
        steps.type_login("AdminTestitPlan");
        steps.type_password("Hyqpmaz0/");
        steps.click_button(signInButton);
    }

    @Test
    @Title("Проверка результатов поиска планов по названию")
    public void checkSearchByNamePlan(){

        steps.click_button(tabListAutoSearch);
        steps.click_button(buttonCheckSearchByNamePlan);
        steps.wait_a_bit(1000);
        steps.check_search_by_name_plan();
    }

    @Test
    @Title("Проверка поиска по типу плана")
    public void checkSearchByTypePlan(){

        steps.click_button(tabListAutoSearch);
        steps.click_button(buttonCheckSearchByTypePlan);
        steps.wait_a_bit(2000);
        steps.click_button(filterSearchByTypePlan);
        steps.click_button(getCheckboxInFilter(0));
        steps.click_button(buttonSearch);
        steps.check_search_by_type_plan();
    }

    @Test
    @Title("Проверка поиска по типу плана план-график")
    public void checkSearchByTypePlanSchedule(){

        steps.click_button(tabListAutoSearch);
        steps.click_button(buttonCheckSearchByTypePlan);
        steps.wait_a_bit(2000);
        steps.click_button(filterSearchByTypePlan);
        steps.click_button(getCheckboxInFilter(1));
        steps.click_button(buttonSearch);
        steps.check_search_by_type_plan_schedule();
    }

    @Test
    @Title("Проверка поиска по типу плана план2017")
    public void checkSearchByTypePlanSchedule2017(){

        steps.click_button(tabListAutoSearch);
        steps.click_button(buttonCheckSearchByTypePlan);
        steps.wait_a_bit(2000);
        steps.click_button(filterSearchByTypePlan);
        steps.click_button(getCheckboxInFilter(1));
        steps.click_button(openTabMenu);
        steps.click_button(buttonSearch);
        steps.check_search_by_type_plan_schedule_2017();
    }
}
