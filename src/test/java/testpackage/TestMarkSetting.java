package testpackage;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import pages.MarkSetting;
import steps.MarkSettingSteps;

@RunWith(SerenityRunner.class)
public class TestMarkSetting extends MarkSetting{

    @Managed(driver = "chrome", uniqueSession=true)
    WebDriver driver;

    @Steps
    MarkSettingSteps steps;

    @Before
    public void beforeMethod(){
        driver.manage().window().maximize();
        steps.open_login_main_page();
        steps.click_button(logInButton);
        steps.type_login("AdminTestitTender");
        steps.type_password("Hyqpmaz0");
        steps.click_button(signInButton);
    }

    @Test
    @Title("Проверка метки тендера")
    public void checkMarkOfTender(){
        steps.click_button(tabListAutoSearch);
        steps.click_button(buttonAutoSearchRegistryNumberAndRegion);
        steps.click_button(contextMenuResultSearch);
        steps.move_to_element(markContextMenu);
        steps.click_button(redMarkContextMenu);
        steps.check_mark_of_tender();
    }

    @Test
    @Title("Проверка метки тендера в карточном виде")
    public void checkMarkOfTenderCardView(){
        steps.click_button(tabListAutoSearch);
        steps.click_button(buttonAutoSearchRegistryNumberAndRegion);
        steps.wait_a_bit(1000);
        steps.click_button(buttonCardView);
        steps.click_button(buttonSetMarkCardView);
        steps.click_button(redMarkContextMenu);
        steps.check_mark_of_tender_card_view();
    }

    @Test
    @Title("Проверка удаления метки тендера")
    public void checkDeletionMarkOfTender(){
        steps.click_button(tabListAutoSearch);
        steps.click_button(buttonAutoSearchRegistryNumberAndRegion);
        steps.click_button(contextMenuResultSearch);
        steps.move_to_element(markContextMenu);
        steps.click_button(redMarkContextMenu);
        steps.click_button(contextMenuResultSearch);
        steps.move_to_element(markContextMenu);
        steps.click_button(buttonDeleteMark);
        steps.check_deletion_mark_of_tender();
    }

    @Test
    @Title("Проверка установки метки для всех выбранных тендеров")
    public void checkSetMarkAllSelectedTenders(){
        steps.click_button(tabListAutoSearch);
        steps.click_button(buttonCheckTenderNameAndNameDeletion);
        steps.wait_a_bit(1000);
        steps.click_button(buttonSelectAllTenders);
        steps.click_button(buttonContextMenuForSelectedTenders);
        steps.move_to_element(markContextMenu);
        steps.click_button(redMarkContextMenu);
        steps.wait_a_bit(1000);
        steps.check_mark_all_selected_tender();
        steps.click_button(buttonSelectAllTenders);
        steps.click_button(buttonContextMenuForSelectedTenders);
        steps.move_to_element(markContextMenu);
        steps.click_button(buttonDeleteMark);
    }

    @Test
    @Title("Проверка установки метки для всех выбранных тендеров карточного вида")
    public void checkSetMarkAllSelectedTendersCardView(){
        steps.click_button(tabListAutoSearch);
        steps.click_button(buttonCheckTenderNameAndNameDeletion);
        steps.wait_a_bit(1000);
        steps.click_button(buttonCardView);
        steps.wait_a_bit(500);
        steps.click_button(buttonSelectAllTenders);
        steps.click_button(buttonContextMenuForSelectedTenders);
        steps.move_to_element(markContextMenu);
        steps.click_button(redMarkContextMenu);
        steps.wait_a_bit(1000);
        steps.check_mark_all_selected_tender_card_view();
        steps.click_button(buttonSelectAllTenders);
        steps.click_button(buttonContextMenuForSelectedTenders);
        steps.move_to_element(markContextMenu);
        steps.click_button(buttonDeleteMark);
    }

    @Test
    @Title("Проверка заблокированности кнопки удаления метки")
    public void checkDisableButtonDeleteMark(){
        steps.click_button(tabListAutoSearch);
        steps.click_button(buttonAutoSearchRegistryNumberAndRegion);
        steps.click_button(contextMenuResultSearch);
        steps.move_to_element(markContextMenu);
        steps.click_button(buttonSettingMark);
        steps.check_disabled_button_delete_mark();
    }

    @Test
    @Title("Проверка видимости ошибки при сохранении метки с пустым названием")
    public void checkVisibleErrorMessageEmptyNameMark(){
        steps.click_button(tabListAutoSearch);
        steps.click_button(buttonAutoSearchRegistryNumberAndRegion);
        steps.click_button(contextMenuResultSearch);
        steps.move_to_element(markContextMenu);
        steps.click_button(buttonSettingMark);
        steps.click_button(buttonSaveMark);
        steps.check_visible_error_message();
    }

    @Test
    @Title("Проверка видимости ошибки при сохранении метки с дублирующим названием")
    public void checkVisibleErrorMessageDuplicateNameMark(){
        steps.click_button(tabListAutoSearch);
        steps.click_button(buttonAutoSearchRegistryNumberAndRegion);
        steps.click_button(contextMenuResultSearch);
        steps.move_to_element(markContextMenu);
        steps.click_button(buttonSettingMark);
        steps.type_name_mark("красный");
        steps.click_button(buttonSaveMark);
        steps.check_visible_error_message();
    }

    @Test
    @Title("Проверка текста ошибки при сохранении метки с пустым названием")
    public void checkCorrectErrorMessageEmptyNameMark(){
        steps.click_button(tabListAutoSearch);
        steps.click_button(buttonAutoSearchRegistryNumberAndRegion);
        steps.click_button(contextMenuResultSearch);
        steps.move_to_element(markContextMenu);
        steps.click_button(buttonSettingMark);
        steps.click_button(buttonSaveMark);
        steps.check_correct_error_message_empty_name_mark();
    }

    @Test
    @Title("Проверка текста ошибки при сохранении метки с дублирующим названием")
    public void checkCorrectErrorMessageDuplicateNameMark(){
        steps.click_button(tabListAutoSearch);
        steps.click_button(buttonAutoSearchRegistryNumberAndRegion);
        steps.click_button(contextMenuResultSearch);
        steps.move_to_element(markContextMenu);
        steps.click_button(buttonSettingMark);
        steps.type_name_mark("красный");
        steps.click_button(buttonSaveMark);
        steps.check_correct_error_message_duplicate_name_mark();
    }

    @Test
    @Title("Проверка базового списка меток")
    public void checkCorrectBaseListMarks(){
        steps.click_button(tabListAutoSearch);
        steps.click_button(buttonAutoSearchRegistryNumberAndRegion);
        steps.click_button(contextMenuResultSearch);
        steps.move_to_element(markContextMenu);
        steps.click_button(buttonSettingMark);
        steps.check_correct_base_list_mark();
    }

    @Test
    @Title("Проверка добавления и удаления новой метки")
    public void checkAddAndDeleteNewMark(){
        steps.click_button(tabListAutoSearch);
        steps.click_button(buttonAutoSearchRegistryNumberAndRegion);
        steps.click_button(contextMenuResultSearch);
        steps.move_to_element(markContextMenu);
        steps.click_button(buttonSettingMark);
        steps.delete_new_mark();
        steps.type_name_mark("Тестовая метка");
        steps.click_button(buttonSaveMark);
        steps.check_visible_new_mark();
        steps.check_correct_name_new_mark();
        steps.check_correct_list_mark_after_add_new_mark();
        steps.click_button(newElementListMark);
        steps.click_button(buttonDeleteMark);
        steps.click_button(buttonApproveDeleteMark);
        steps.check_not_visible_new_mark();
    }

    @Test
    @Title("Проверка базового списка меток после обновления метки")
    public void checkCorrectBaseListMarksAfterUpdateMark(){
        steps.click_button(tabListAutoSearch);
        steps.click_button(buttonAutoSearchRegistryNumberAndRegion);
        steps.click_button(contextMenuResultSearch);
        steps.move_to_element(markContextMenu);
        steps.click_button(buttonSettingMark);
        steps.click_button(elementListMark);
        steps.click_button(buttonSaveMark);
        steps.check_correct_base_list_mark();
    }
}
