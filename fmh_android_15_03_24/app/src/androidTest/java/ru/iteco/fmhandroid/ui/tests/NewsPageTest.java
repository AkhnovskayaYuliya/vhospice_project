package ru.iteco.fmhandroid.ui.tests;

import static androidx.test.espresso.action.ViewActions.click;

import static androidx.test.espresso.assertion.ViewAssertions.matches;

import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.allOf;


import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ru.iteco.fmhandroid.ui.AppActivity;

import ru.iteco.fmhandroid.ui.pages.ControlPanelPage;
import ru.iteco.fmhandroid.ui.pages.FilterPage;

import ru.iteco.fmhandroid.ui.steps.AuthSteps;
import ru.iteco.fmhandroid.ui.steps.ControlPanelSteps;
import ru.iteco.fmhandroid.ui.steps.FilterSteps;
import ru.iteco.fmhandroid.ui.steps.MainPageSteps;
import ru.iteco.fmhandroid.ui.steps.NewsPageSteps;
import ru.iteco.fmhandroid.ui.steps.ToolsSteps;


@RunWith(AndroidJUnit4.class)
public class NewsPageTest {

    AuthSteps authSteps = new AuthSteps();
    MainPageSteps mainPageSteps = new MainPageSteps();
    NewsPageSteps newsPageSteps = new NewsPageSteps();
    ToolsSteps toolsSteps = new ToolsSteps();
    FilterSteps filterSteps = new FilterSteps();
    ControlPanelSteps controlPanelSteps = new ControlPanelSteps();


    @Rule
    public ActivityScenarioRule<AppActivity> activityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);
    @Before
    public void setUp() {
        try {
            mainPageSteps.loadMainPage();
            mainPageSteps.clickAllNewsButton();
            newsPageSteps.checkElements();
        } catch (Exception e) {
            authSteps.loadAuthPage();
            authSteps.validData();
            authSteps.clickEnterButton();
            mainPageSteps.checkElements();
            mainPageSteps.clickAllNewsButton();
        }
    }


////TC-21. Отображение элементов на странице Новости
    @Test
    public void tc_21() {
        newsPageSteps.checkElements();
    }
//TC-22. Раскрытие/скрытие каждой новости
    @Test
    public void tc_22() {
        newsPageSteps.expandSeparateNews();
        newsPageSteps.checkDescription();
    }
//TC-23. Сортировка новостей путем нажатия на ↑↓
    @Test
    public void tc_23() {
        newsPageSteps.sortNews();
        newsPageSteps.checkSortedNews();
    }
//TC-24. Нажатие на кнопку фильтрации (3 ползунка)
    @Test
    public void tc_24() {
        newsPageSteps.clickFilter();
        filterSteps.checkFilterTitle();
        filterSteps.clickCancel();
    }
//TC-25. Переход к панели управления путем нажатия на карандаш
    @Test
    public void tc_25() {
        newsPageSteps.clickPanelButton();
        controlPanelSteps.checkPanelTitle();
    }
}

