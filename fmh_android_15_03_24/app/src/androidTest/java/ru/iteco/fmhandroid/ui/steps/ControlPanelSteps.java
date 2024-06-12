package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.DataHelper.DataHelper;
import ru.iteco.fmhandroid.ui.pages.ControlPanelPage;
import ru.iteco.fmhandroid.ui.pages.ToolbarPage;

public class ControlPanelSteps {
    ControlPanelPage controlPanel = new ControlPanelPage();
    ToolbarPage tools = new ToolbarPage();
    DataHelper dataHelper = new DataHelper();
    public void checkPanelTitle() {
        Allure.step("Проверка заголовка страницы 'Панель управления'");
        controlPanel.pageTitle.check(matches(allOf(isDisplayed(), withText("Панель \n управления"))));
    }
    public void clickFilterButton() {
        Allure.step("Нажатие на кнопку 'Фильтровать новости'");
        controlPanel.filterNewsButton.perform(click());
    }
    public void checkElements() {
        Allure.step("Проверка наличия элементов страницы 'Панель управления'");
        controlPanel.pageTitle.check(matches(isDisplayed()));
        tools.navigationButton.check(matches(isDisplayed()));
        tools.appTrademark.check(matches(isDisplayed()));
        tools.butterflyButton.check(matches(isDisplayed()));
        tools.personButton.check(matches(isDisplayed()));
        controlPanel.sortNewsButton.check(matches(isDisplayed()));
        controlPanel.filterNewsButton.check(matches(isDisplayed()));
        controlPanel.addNewsButton.check(matches(isDisplayed()));
        controlPanel.newsList.check(matches(isDisplayed()));
        controlPanel.editNewsButton.check(matches(isDisplayed()));
        controlPanel.deleteNewsButton.check(matches(isDisplayed()));
    }
    public void sortNews() {
        Allure.step("Нажатие на кнопку 'Сортировка новостей'");
        controlPanel.sortNewsButton.perform(click());
    }
    public void checkSortedNews() {
        Allure.step("Проверка сортировки новостей");
        List<Date> dates = dataHelper.getDisplayedDates(R.id.news_list_recycler_view, R.id.news_item_publication_date_text_view);
        List<Date> sortedDates = new ArrayList<>(dates);
        sortedDates.sort(Collections.reverseOrder());
        assert dates.equals(sortedDates);
    }
    public void expandSeparateNews() {
        Allure.step("Раскрытие/скрытие отдельной новости");
        controlPanel.separateNews.perform(actionOnItemAtPosition(0, click()));
    }
    public void checkDescription() {
        Allure.step("Проверка наличия описания");
        controlPanel.newsDescription.check(matches(isDisplayed()));
    }
    public void clickEditNews() {
        Allure.step("Нажатие на кнопку 'Редактировать новость'");
        controlPanel.editNewsButton.perform(click());
    }
    public void clickAddNews() {
        Allure.step("Нажатие на кнопку 'Создать новость'");
        controlPanel.addNewsButton.perform(click());
    }
}
