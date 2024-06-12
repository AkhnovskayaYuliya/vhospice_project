package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.allOf;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.DataHelper.DataHelper;
import ru.iteco.fmhandroid.ui.pages.EditNewsPage;

public class EditNewsSteps {
    EditNewsPage editNewsPage = new EditNewsPage();
    DataHelper dataHelper = new DataHelper();

    public void checkTitle() {
        Allure.step("Проверка заголовка страницы 'Редактирование новости'");
        editNewsPage.pageTitle.check(matches(isDisplayed()));
    }
    public void cancelEdit() {
        Allure.step("Нажатие на кнопку 'Отмена'");
        editNewsPage.cancelButton.perform(click());
        editNewsPage.okButton.perform(click());
    }
    public void changeDate() {
        Allure.step("Изменение даты");
        editNewsPage.publicationDate.perform(click());
        dataHelper.setDateInDatePicker();
        editNewsPage.okButton.perform(click());
    }
    public void changeTitle(String text) {
        Allure.step("Изменение заголовка");
        editNewsPage.newsTitle.perform(replaceText(text));
    }
    public void changeDescription(String text) {
        Allure.step("Изменение описания");
        editNewsPage.description.perform(replaceText(text));
    }
    public void clickSave() {
        Allure.step("Нажатие на кнопку 'Отмена'");
        editNewsPage.saveButton.perform(click());
    }
    public void checkChanges(String text) {
        Allure.step("Проверка изменений");
        onView(allOf(withText(text), isDisplayed())).check(matches(isDisplayed()));
    }
    public void changeTime() {
        Allure.step("Изменение времени");
        editNewsPage.time.perform(click());
        editNewsPage.okButton.perform(click());
    }
    public void changeStatus() {
        Allure.step("Изменение статуса");
        editNewsPage.switcher.perform(click());
    }
}
