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

    public void openMyTenders(){
        steps.click_button(openTabMenu);
        steps.click_button(buttonTabMenuMyTenders);
    }

    @Test
    @Title("Проверка добавления и удаления тендера во вкладке \"Карточки\"")
    public void checkAddAndDeleteTenderInTabCards(){

        steps.click_button(tabListAutoSearch);
        steps.click_button(buttonInAutoSearchListCheckMyTenders);
        steps.wait_a_bit(1000);
        steps.add_in_my_tenders();
        openMyTenders();
        steps.wait_a_bit(1000);
        steps.check_register_number_added_tender();
        steps.check_name_added_tender();
        steps.click_button(buttonDeleteAddedTenderInListTenders);
        steps.check_visible_window_approve_delete();
        steps.click_button(buttonConfirmDelete);
        steps.wait_a_bit(1000);
        steps.check_delete_added_tender();
    }

    @Test
    @Title("Проверка кликабельности кнопок тендера в списке тендеров")
    public void checkClickableButtonTenderInListTenders(){

        openMyTenders();
        steps.wait_a_bit(1000);
        steps.check_clickable_button_delete_tender_in_list_tenders();
        steps.check_clickable_button_load_documentation_tender_in_list_tenders();
    }

    @Test
    @Title("Проверка отключения кнопки 'Удалить' контекстного меню столбца при единственном столбце")
    public void checkNotClickableButtonDeleteContextMenuColumn(){

        openMyTenders();
        steps.wait_a_bit(1000);
        steps.delete_second_column();
        steps.wait_a_bit(1000);
        steps.click_button(contextMenuColumn);
        steps.check_disable_button_delete_context_menu_column();
    }

    @Test
    @Title("Проверка добавления и удаления нового столбца")
    public void checkAddingAndDeleteNewColumn(){

        openMyTenders();
        steps.delete_second_column();
        steps.click_button(buttonAddColumn);
        steps.type_name_column("Тестовый столбец");
        steps.check_number_columns_after_adding_column();
        steps.check_name_added_column();
        steps.delete_second_column();
        steps.check_number_columns_after_delete_column();
    }

    @Test
    @Title("Проверка отображения карточки тендера")
    public void checkVisibleCard(){

        openMyTenders();
        steps.click_button(openCardFirstTender);
        steps.wait_a_bit(2000);
        steps.check_visible_cards();
    }

    @Test
    @Title("Проверка кликабельности кнопки смены метки тендера в карточке тендера")
    public void checkClickableButtonChangeTag(){

        openMyTenders();
        steps.click_button(openCardFirstTender);
        steps.wait_a_bit(2000);
        steps.check_clickable_button_change_tag();
    }

    @Test
    @Title("Проверка кликабельности кнопки ссылки на источник")
    public void checkClickableButtonLinkSource(){

        openMyTenders();
        steps.click_button(openCardFirstTender);
        steps.wait_a_bit(2000);
        steps.check_clickable_button_link_source();
    }

    @Test
    @Title("Проверка кликабельности кнопки удаления тендера в карточке тендера")
    public void checkClickableButtonDeleteTenderInCard(){

        openMyTenders();
        steps.click_button(openCardFirstTender);
        steps.wait_a_bit(2000);
        steps.check_clickable_button_delete_tender_in_card();
    }

    @Test
    @Title("Проверка количества вкладок в карточке тендера")
    public void checkNumberTabInCardTender(){

        openMyTenders();
        steps.click_button(openCardFirstTender);
        steps.wait_a_bit(2000);
        steps.check_number_tab_in_card_tender();
    }

    @Test
    @Title("Проверка кликабельности главной вкладки \"Карточки\"")
    public void checkClickableTabCards(){

        openMyTenders();
        steps.check_clickable_tab_cards();
    }

    @Test
    @Title("Проверка кликабельности главной вкладки \"Таблица\"")
    public void checkClickableTabTable(){

        openMyTenders();
        steps.check_clickable_tab_table();
    }

    @Test
    @Title("Проверка кликабельности главной вкладки \"Календарь\"")
    public void checkClickableTabCalendar(){

        openMyTenders();
        steps.check_clickable_tab_calendar();
    }

    @Test
    @Title("Проверка ответственного во вкладке \"Таблица\" после его смены во вкладке \"Карточки\"")
    public void checkResponsibleInTabTableAfterChangeResponsibleInTabCards(){

        openMyTenders();
        steps.click_button(openCardFirstTender);
        steps.click_button(buttonChangeResponsibleInCardTender);
        steps.click_button(userTestInCardTender);
        steps.click_button(buttonCloseCardTender);
        steps.click_button(tabTable);
        steps.check_change_responsible_in_tab_table();
        steps.click_button(tabCards);
        steps.click_button(openCardFirstTender);
        steps.click_button(buttonChangeResponsibleInCardTender);
        steps.click_button(userAdminInCardTender);
    }

    @Test
    @Title("Проверка ответственного во вкладке \"Карточки\" после его смены во вкладке \"Таблица\"")
    public void checkResponsibleInTabCardsAfterChangeResponsibleInTabTable(){

        openMyTenders();
        steps.click_button(tabTable);
        steps.click_button(buttonChangeResponsibleInTabTable);
        steps.click_button(userTestInListUsersTabTable);
        steps.click_button(tabCards);
        steps.click_button(openCardFirstTender);
        steps.check_change_responsible_in_tab_cards();
        steps.click_button(buttonCloseCardTender);
        steps.click_button(tabTable);
        steps.click_button(buttonChangeResponsibleInTabTable);
        steps.click_button(userAdminInListUsersTabTable);
    }

    @Test
    @Title("Проверка на сброс значения фильтра \"Наличие задач\"")
    public void checkResetFilterAvailabilityTask(){

        openMyTenders();
        steps.click_button(buttonOpenListFilters);
        steps.click_button(filterAvailabilityTask);
        steps.click_button(firstElementInListFilter);
        steps.click_button(buttonOpenListFilters);
        steps.click_button(buttonClearFieldAvailabilityTask);
        steps.check_reset_filter_availability_task();
    }

    @Test
    @Title("Проверка максимальной длины названия столбца")
    public void checkMaxLengthNameColumn(){

        openMyTenders();
        steps.delete_second_column();
        steps.click_button(buttonAddColumn);
        steps.type_name_column("12345678910111213141516171819202122232425");
        steps.check_max_length_name_column();
        steps.delete_second_column();
    }

//    @Test
//    @Title("Проверка смены столбца тендера с помощью перетаскивания")
//    public void checkDragAndDropTender(){
//
//        openMyTenders();
//        steps.drag_and_drop_tender(steps.get_tender_by_number_in_first_column(2, 1), fieldSecondColumnForDragAndDrop);
//        steps.wait_a_bit(2000);
//        steps.check_drag_and_drop_tender();
//        steps.drag_and_drop_tender(steps.get_tender_by_number_in_first_column(2, 2), fieldFirstColumnForDragAndDrop);
//    }

}
