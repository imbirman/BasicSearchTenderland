package testpackage;


import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import pages.MyTendersTasks;
import steps.MyTendersSteps;
import steps.MyTendersTasksSteps;

@RunWith(SerenityRunner.class)
public class WhenMyTendersTasksTest extends MyTendersTasks {

    @Managed(driver = "chrome", uniqueSession=true)
    WebDriver driver;

    @Steps
    MyTendersTasksSteps steps;

    @Before
    public void beforeMethod(){
        driver.manage().window().maximize();
        steps.open_login_main_page();
        steps.click_button(buttonLogin);
        steps.type_login("AdminTestitMyTenders");
        steps.type_password("Hyqpmaz0/");
        steps.click_button(buttonSignIn);
    }

    public void openMyTenders(){
        steps.click_button(openTabMenu);
        steps.click_button(buttonTabMenuMyTenders);
    }

    @Test
    @Title("Проверка добавления новой задачи")
    public void checkAddingTask(){
        openMyTenders();
        steps.click_button(openCardFirstTender);
        steps.wait_a_bit(2000);
        steps.click_button(buttonAddTask);
        steps.type_name_task("тестовая задача");
        steps.wait_a_bit(2000);
        steps.check_add_task();
    }

    @Test
    @Title("Проверка добавления задачи с дублирующим названием")
    public void checkAddingTaskWithDuplicateName(){
        openMyTenders();
        steps.click_button(openCardFirstTender);
        steps.wait_a_bit(2000);
        steps.click_button(buttonAddTask);
        steps.type_name_task("тестовая задача 1");
        steps.wait_a_bit(2000);
        steps.check_add_task_with_duplicate_name();
    }

    @Test
    @Title("Проверка удаления задачи")
    public void checkDeleteTask(){
        openMyTenders();
        steps.click_button(openCardFirstTender);
        steps.wait_a_bit(2000);
        steps.click_button(getButtonDeleteTaskByNumberByNumber(3));
        steps.wait_a_bit(2000);
        steps.check_delete_task();
    }

    @Test
    @Title("Проверка статуса добавленной задачи")
    public void checkStatusAddedTask(){
        openMyTenders();
        steps.click_button(openCardFirstTender);
        steps.wait_a_bit(2000);
        steps.click_button(buttonAddTask);
        steps.type_name_task("тест статуса");
        steps.wait_a_bit(1000);
        steps.check_status_added_task();
    }

    @Test
    @Title("Проверка статуса задачи в окне задачи после нажатия переключателя \"Выполнено\"")
    public void checkStatusTaskAfterClickSwitchBoxCompleteInWindowTask(){
        openMyTenders();
        steps.click_button(openCardFirstTender);
        steps.wait_a_bit(2000);
        steps.click_button(getTaskByNumber(0));
        steps.click_button(switchToCompleteTask);
        steps.check_status_task_after_click_switchbox_complete_in_window_task();
    }

    @Test
    @Title("Проверка статуса задачи в списке задач после нажатия переключателя \"Выполнено\"")
    public void checkStatusTaskAfterClickSwitchBoxCompleteInListTask(){
        openMyTenders();
        steps.click_button(openCardFirstTender);
        steps.wait_a_bit(2000);
        steps.click_button(getTaskByNumber(1));
        steps.click_button(switchToCompleteTask);
        steps.click_button(buttonBackToTask);
        steps.check_status_task_after_click_switchbox_complete_in_list_task(1);
    }
}
