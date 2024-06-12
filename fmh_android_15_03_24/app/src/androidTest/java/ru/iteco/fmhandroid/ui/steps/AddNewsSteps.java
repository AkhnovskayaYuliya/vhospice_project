package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.allOf;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.pages.AddNewsPage;

public class AddNewsSteps {
    AddNewsPage addNewsPage = new AddNewsPage();
    public void checkTitle() {
        Allure.step("Проверка заголовка страницы 'Создание новости'");
        addNewsPage.pageTitle.check(matches(isDisplayed()));
    }
    public void cancelAddNews() {
        Allure.step("Нажатие кнопку 'Отмена'");
        addNewsPage.cancelButton.perform(click());
        addNewsPage.okButton.perform(click());
    }
    public void clickCategoty() {
        Allure.step("Нажатие на категорию");
        addNewsPage.category.perform(click());
    }
    public void createTitle(String text) {
        Allure.step("Ввод заголовка");
        addNewsPage.newsTitle.perform(replaceText(text));
    }
    public void createDate() {
        Allure.step("Ввод даты");
        addNewsPage.publicationDate.perform(click());
        addNewsPage.okButton.perform(click());
    }
    public void createTime() {
        Allure.step("Ввод времени");
        addNewsPage.time.perform(click());
        addNewsPage.okButton.perform(click());
    }
    public void createDescription(String text) {
        Allure.step("Ввод описания");
        addNewsPage.description.perform(replaceText(text));
    }
    public void clickSave() {
        Allure.step("Нажатие на кнопку 'Сохранить'");
        addNewsPage.saveButton.perform(click());
    }
    public void checkNews(String text) {
        Allure.step("Проверка наличия новости");
        onView(allOf(withText(text), isDisplayed())).check(matches(isDisplayed()));
    }
    public void manualInputTime(String text1, String text2) {
        Allure.step("Ручной ввод времени");
        addNewsPage.time.perform(click());
        addNewsPage.toggle.perform(click());
        addNewsPage.manualInputHours.perform(replaceText(text1));
        addNewsPage.manualInputMinutes.perform(replaceText(text2));
        addNewsPage.okButton.perform(click());
    }
    public void checkTimeError() {
        Allure.step("Проверка отображения ошибки");
        addNewsPage.timeError.check(matches(isDisplayed()));
    }
    public void clickCancel() {
        Allure.step("Нажатие на кнопку 'Отмена'");
        addNewsPage.smallCancelButton.perform(click());
    }
    public void checkDoesNotExist(String text) {
        Allure.step("Проверка, что новость не создалась");
        onView(withText(text)).check(doesNotExist());
    }
}
