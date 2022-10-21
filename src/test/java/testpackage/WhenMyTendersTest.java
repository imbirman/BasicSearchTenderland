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
    @Title("Проверка добавления и удаления тендера")
    public void checkAddAndDeleteTender(){

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
    @Title("Проверка количества фильтров")
    public void checkNumberFilters(){

        openMyTenders();
        steps.click_button(buttonOpenListFilters);
        steps.check_number_filters();
    }

    @Test
    @Title("Проверка поиска по реестровому номеру тендера")
    public void checkSearchByRegisterNumberTenderInTabCard(){

        openMyTenders();
        steps.type_search_by_tender("01");
        steps.wait_a_bit(2000);
        steps.check_search_by_register_number_tender_in_tab_cards();
    }

    @Test
    @Title("Проверка поиска по названию тендера")
    public void checkSearchByNameTenderInTabCard(){

        openMyTenders();
        steps.type_search_by_tender("усл");
        steps.wait_a_bit(2000);
        steps.check_search_by_name_tender_in_tab_cards();
    }

    @Test
    @Title("Проверка поиска по пользователю")
    public void checkSearchByUser(){

        openMyTenders();
        steps.click_button(filterUsers);
        steps.click_button(selectUserAdmin);
        steps.click_button(openCardTender);
        steps.wait_a_bit(2000);
        steps.check_search_by_user_in_tab_cards();
    }

    @Test
    @Title("Проверка поиска по метке тендера")
    public void checkSearchByTags(){

        openMyTenders();
        steps.click_button(buttonOpenListFilters);
        steps.click_button(filterTags);
        steps.click_button(selectRedTagInList);
        steps.click_button(openCardTender);
        steps.wait_a_bit(2000);
        steps.check_search_by_tags_in_tab_cards();
    }

    @Test
    @Title("Проверка отображения карточки тендера")
    public void checkVisibleCard(){

        openMyTenders();
        steps.click_button(openCardTender);
        steps.wait_a_bit(2000);
        steps.check_visible_cards();
    }

    @Test
    @Title("Проверка кликабельности кнопки смены метки тендера в карточке тендера")
    public void checkClickableButtonChangeTag(){

        openMyTenders();
        steps.click_button(openCardTender);
        steps.wait_a_bit(2000);
        steps.check_clickable_button_change_tag();
    }

    @Test
    @Title("Проверка кликабельности кнопки смены метки тендера в карточке тендера")
    public void checkClickableButtonLinkSource(){

        openMyTenders();
        steps.click_button(openCardTender);
        steps.wait_a_bit(2000);
        steps.check_clickable_button_link_source();
    }

    @Test
    @Title("Проверка кликабельности кнопки удаления тендера в карточке тендера")
    public void checkClickableButtonDeleteTenderInCard(){

        openMyTenders();
        steps.click_button(openCardTender);
        steps.wait_a_bit(2000);
        steps.check_clickable_button_delete_tender_in_card();
    }

    @Test
    @Title("Проверка количества вкладок в карточке тендера")
    public void checkNumberTabInCardTender(){

        openMyTenders();
        steps.click_button(openCardTender);
        steps.wait_a_bit(2000);
        steps.check_number_tab_in_card_tender();
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
