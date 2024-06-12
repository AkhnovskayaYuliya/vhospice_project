package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.DataHelper.DataHelper;
import ru.iteco.fmhandroid.ui.pages.FilterPage;

public class FilterSteps {
    FilterPage filter = new FilterPage();
    DataHelper dataHelper = new DataHelper();
    public void checkFilterTitle() {
        Allure.step("Проверка заголовка страницы 'Фильтровать новости'");
        filter.pageTitle.check(matches(allOf(isDisplayed(), withText("Фильтровать новости"))));
    }
    public void clickCancel() {
        Allure.step("Нажатие на кнопку 'Отмена'");
        filter.cancelButton.perform(click());
    }
    public void clickCategoty() {
        Allure.step("Нажатие на категорию");
        filter.categoryList.perform(click());
    }
    public void clickFilterButton() {
        Allure.step("Нажатие на кнопку 'Фильтровать'");
        filter.filterButton.perform(click());
    }
    public void inputCategory(String text) {
        Allure.step("Ручной ввод категории");
        filter.inputCategory.perform(replaceText(text));
    }

    public void selectDate() {
        Allure.step("Выбор даты");
        filter.dateFirst.perform(click());
        dataHelper.setDateInDatePicker();
        filter.okButton.perform(click());
        filter.dateSecond.perform(click());
        dataHelper.setDateInDatePicker();
        filter.okButton.perform(click());
    }

    public void clickInactiveCheckBox() {
        Allure.step("Нажатие на статус 'Неактивна'");
        filter.inactiveCheckBox.perform(click());
    }

    public void clickActiveCheckBox() {
        Allure.step("Нажатие на кнопку 'Активна'");
        filter.activeCheckBox.perform(click());
    }
}
