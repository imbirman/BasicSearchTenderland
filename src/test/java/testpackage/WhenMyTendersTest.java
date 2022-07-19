package testpackage;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import pages.MyTenders;
import steps.MyTendersSteps;

@RunWith(SerenityRunner.class)
public class WhenMyTendersTest extends MyTenders {

    @Managed(driver = "chrome", uniqueSession=true)
    WebDriver driver;

    @Steps
    MyTendersSteps steps;

    @Before
    public void beforeMethod(){
        driver.manage().window().maximize();
        steps.open_login_main_page();
        steps.click_button(buttonLogin);
        steps.type_login("AdminTestitMyTenders");
        steps.type_password("Hyqpmaz0/");
        steps.click_button(buttonSignIn);
    }

    public void switchTenderInTabAllTenders(){
        steps.click_button(elementSwitch);
        steps.wait_a_bit(1000);
        steps.click_button(buttonOpenListStatusTender);
        steps.click_button(getStatusTenderByNumber(0));
    }

    @Test
    @Title("Проверка добавления и удаления тендера")
    public void checkAddingAndDeleteTender(){

        steps.click_button(tabListAutoSearch);
        steps.click_button(buttonAutoSearchTestMyTenders);
        steps.click_button(buttonSearch);
        steps.wait_a_bit(1000);
        steps.click_button(contextMenuResultSearchForTestAddingAndDeleteTender);
        steps.move_to_element(buttonContextMenuAddInMyTenders);
        steps.click_button(buttonSelectResponsible);
        steps.click_button(openTabMenu);
        steps.click_button(buttonMyTenders);
        steps.check_contain_correct_registry_number_adding_tender();
        steps.check_contain_correct_name_adding_tender();
        steps.click_button(buttonDeleteNewAddingTenderInListMyTenders);
        steps.wait_a_bit(1000);
        steps.check_not_contain_adding_tender();
    }

    @Test
    @Title("Проверка реестрового номера в окне тендера")
    public void checkCorrectRegistryNumberInWindow(){
        steps.click_button(openTabMenu);
        steps.click_button(buttonMyTenders);
        steps.click_button(elementListMyTendersRegistryNumber);
        steps.wait_a_bit(1000);
        steps.check_correct_registry_number_in_window();
    }

    @Test
    @Title("Проверка переноса тендера в статус Подготовка заявки")
    public void checkContainSwitchTenderToApplicationPreparation() {
        steps.click_button(openTabMenu);
        steps.click_button(buttonMyTenders);

        steps.click_button(elementListMyTendersRegistryNumber);
        steps.wait_a_bit(1000);
        steps.click_button(buttonOpenListStatusTender);
        steps.click_button(getStatusTenderByNumber(1));
        steps.click_button(buttonCloseWindowTender);
        steps.check_correct_number_counter(tabApplicationPreparationCounter, "Подготовка заявки");
        steps.click_button(tabApplicationPreparation);
        steps.check_contain_switch_tender("Подготовка заявки");

        switchTenderInTabAllTenders();
    }

    @Test
    @Title("Проверка переноса тендера в статус Определение победителя")
    public void checkContainSwitchTenderToDeterminationWinner() {
        steps.click_button(openTabMenu);
        steps.click_button(buttonMyTenders);

        steps.click_button(elementListMyTendersRegistryNumber);
        steps.wait_a_bit(1000);
        steps.click_button(buttonOpenListStatusTender);
        steps.click_button(getStatusTenderByNumber(2));
        steps.click_button(buttonCloseWindowTender);
        steps.check_correct_number_counter(tabDeterminationWinnerCounter, "Определение победителя");
        steps.click_button(tabDeterminationWinner);
        steps.check_contain_switch_tender("Определение победителя");

        switchTenderInTabAllTenders();
    }

    @Test
    @Title("Проверка переноса тендера в статус Заключение контракта")
    public void checkContainSwitchTenderToConclusionContract() {
        steps.click_button(openTabMenu);
        steps.click_button(buttonMyTenders);

        steps.click_button(elementListMyTendersRegistryNumber);
        steps.wait_a_bit(1000);
        steps.click_button(buttonOpenListStatusTender);
        steps.click_button(getStatusTenderByNumber(3));
        steps.click_button(buttonCloseWindowTender);
        steps.check_correct_number_counter(tabConclusionContractCounter, "Заключение контракта");
        steps.click_button(tabConclusionContract);
        steps.check_contain_switch_tender("Заключение контракта");

        switchTenderInTabAllTenders();
    }

    @Test
    @Title("Проверка переноса тендера в статус Исполнение контракта")
    public void checkContainSwitchTenderToExecutionContract() {
        steps.click_button(openTabMenu);
        steps.click_button(buttonMyTenders);

        steps.click_button(elementListMyTendersRegistryNumber);
        steps.wait_a_bit(1000);
        steps.click_button(buttonOpenListStatusTender);
        steps.click_button(getStatusTenderByNumber(4));
        steps.click_button(buttonCloseWindowTender);
        steps.check_correct_number_counter(tabExecutionContractCounter, "Исполнение контракта");
        steps.click_button(tabExecutionContract);
        steps.check_contain_switch_tender("Исполнение контракта");

        switchTenderInTabAllTenders();
    }

    @Test
    @Title("Проверка переноса тендера в статус Архив")
    public void checkContainSwitchTenderToArchive() {
        steps.click_button(openTabMenu);
        steps.click_button(buttonMyTenders);

        steps.click_button(elementListMyTendersRegistryNumber);
        steps.wait_a_bit(1000);
        steps.click_button(buttonOpenListStatusTender);
        steps.click_button(getStatusTenderByNumber(5));
        steps.click_button(buttonCloseWindowTender);
        steps.check_correct_number_counter(tabArchiveCounter, "Архив");
        steps.click_button(tabArchive);
        steps.check_contain_switch_tender("Архив");

        steps.click_button(tabAllTenders);
        steps.check_not_contain_tender_switch_to_archive("Все тендеры");

        steps.click_button(tabNewTenders);
        steps.check_not_contain_tender_switch_to_archive("Новые тендеры");

        steps.click_button(tabArchive);
        switchTenderInTabAllTenders();
    }

    @Test
    @Title("Проверка отсутствия пустой задачи в окне тендера в процессе её добавления")
    public void checkEmptyNameTaskInWindowTender(){
        steps.click_button(openTabMenu);
        steps.click_button(buttonMyTenders);

        steps.check_task_for_delete();
        steps.wait_a_bit(1000);
        steps.click_button(buttonAddNewTaskInList);
        steps.click_button(elementListMyTendersRegistryNumber);
        steps.check_empty_name_task_by_window_tender();
    }

    @Test
    @Title("Проверка добавления и удаления задачи в списке тендеров")
    public void checkAddingAndDeleteTaskInListTenders() {
        steps.click_button(openTabMenu);
        steps.click_button(buttonMyTenders);

        steps.check_task_for_delete();
        steps.wait_a_bit(1000);
        steps.click_button(buttonAddNewTaskInList);
        steps.wait_a_bit(1000);
        steps.type_name_task_in_list("Тест");
        steps.wait_a_bit(2000);
        steps.check_visible_and_contain_name_task_by_list();

        steps.click_button(elementListMyTendersRegistryNumber);
        steps.wait_a_bit(1000);
        steps.check_visible_and_contain_name_task_by_window_tender();
        steps.click_button(buttonCloseWindowTender);
        steps.wait_a_bit(2000);
        steps.click_button(buttonDeleteTaskInList);
        steps.wait_a_bit(1000);
        steps.check_not_visible_task_by_list();

        steps.click_button(elementListMyTendersRegistryNumber);
        steps.wait_a_bit(1000);
        steps.check_not_visible_task_by_window_tender();
    }

    @Test
    @Title("Проверка корректности типов сортировки списка тендеров")
    public void checkCorrectListTypesSort(){
        steps.click_button(openTabMenu);
        steps.click_button(buttonMyTenders);
        steps.click_button(buttonOpenListTypesSort);
        steps.wait_a_bit(1000);
        steps.check_correct_list_types_sort();
    }

    @Test
    @Title("Проверка статуса задачи после проставления чекбокса в окне тендера")
    public void checkCorrectStatusTaskCompleted(){
        steps.click_button(openTabMenu);
        steps.click_button(buttonMyTenders);

        steps.check_task_for_delete();
        steps.wait_a_bit(1000);
        steps.click_button(buttonAddNewTaskInList);
        steps.wait_a_bit(1000);
        steps.type_name_task_in_list("Тест");
        steps.wait_a_bit(2000);
        steps.click_button(elementListMyTendersRegistryNumber);
        steps.wait_a_bit(1000);
        steps.click_button(checkboxInWindowTenderTaskCompleted);
        steps.check_correct_task_completed_in_window_tender();
        steps.check_correct_task_completed_in_list_tenders();
        steps.click_button(buttonCloseWindowTender);
        steps.wait_a_bit(2000);
        steps.click_button(buttonDeleteTaskInList);
    }

    @Test
    @Title("Проверка добавления задачи в окне тендера")
    public void checkAddingAndDeleteTaskInWindowTender() {
        steps.click_button(openTabMenu);
        steps.click_button(buttonMyTenders);
        steps.check_task_for_delete();
        steps.wait_a_bit(1000);
        steps.click_button(elementListMyTendersRegistryNumber);
        steps.wait_a_bit(1000);
        steps.click_button(buttonAddNewTaskInWindowTender);
        steps.wait_a_bit(1000);
        steps.scroll_down_to(blockWindowTenderForScroll);
        steps.type_name_task_in_window_tender("Тест");
        steps.check_visible_and_contain_name_task_by_window_tender();
        steps.click_button(buttonCloseWindowTender);
        steps.check_visible_and_contain_name_task_by_list();
        steps.check_task_for_delete();
    }

    @Test
    @Title("Проверка смены ответственного")
    public void checkNameResponsibleInWindowTender() {
        steps.click_button(openTabMenu);
        steps.click_button(buttonMyTenders);
        steps.check_task_for_delete();
        steps.wait_a_bit(1000);
        steps.click_button(elementListMyTendersRegistryNumber);
        steps.wait_a_bit(1000);
        steps.click_button(buttonOpenResponsibleInWindowTender);
        steps.click_button(secondElementListResponsibleInWindowTender);
        steps.click_button(buttonCloseWindowTender);
        steps.click_button(elementListMyTendersRegistryNumber);
        steps.check_name_responsible_in_window_tender();
        steps.click_button(buttonOpenResponsibleInWindowTender);
        steps.click_button(firstElementListResponsibleInWindowTender);
        steps.click_button(buttonCloseWindowTender);
    }

    @Test
    @Title("Проверка сортировки тендеров после поиска")
    public void checkCorrectSortListTendersAfterSearch(){
        steps.click_button(openTabMenu);
        steps.click_button(buttonMyTenders);
        steps.type_search_tenders("мус");
        steps.wait_a_bit(5000);
        steps.check_correct_sort_list_tenders_after_search();
    }

}
