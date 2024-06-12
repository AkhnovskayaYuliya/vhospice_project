package ru.iteco.fmhandroid.ui.tests;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.DataHelper.DataHelper;
import ru.iteco.fmhandroid.ui.pages.AboutApplicationPage;
import ru.iteco.fmhandroid.ui.pages.AddNewsPage;
import ru.iteco.fmhandroid.ui.pages.AuthPage;
import ru.iteco.fmhandroid.ui.pages.ControlPanelPage;
import ru.iteco.fmhandroid.ui.pages.EditNewsPage;
import ru.iteco.fmhandroid.ui.pages.FilterPage;
import ru.iteco.fmhandroid.ui.pages.MainPage;
import ru.iteco.fmhandroid.ui.pages.NewsPage;
import ru.iteco.fmhandroid.ui.pages.ToolbarPage;
import ru.iteco.fmhandroid.ui.steps.AddNewsSteps;
import ru.iteco.fmhandroid.ui.steps.AuthSteps;
import ru.iteco.fmhandroid.ui.steps.ControlPanelSteps;
import ru.iteco.fmhandroid.ui.steps.EditNewsSteps;
import ru.iteco.fmhandroid.ui.steps.FilterSteps;
import ru.iteco.fmhandroid.ui.steps.MainPageSteps;
import ru.iteco.fmhandroid.ui.steps.NewsPageSteps;
import ru.iteco.fmhandroid.ui.steps.ToolsSteps;

@RunWith(AndroidJUnit4.class)
public class ControlPanelTest {
    ControlPanelSteps controlPanelSteps = new ControlPanelSteps();
    AuthSteps authSteps = new AuthSteps();
    MainPageSteps mainPageSteps = new MainPageSteps();
    NewsPageSteps newsPageSteps = new NewsPageSteps();
    ToolsSteps toolsSteps = new ToolsSteps();
    FilterSteps filterSteps = new FilterSteps();
    EditNewsSteps editNewsSteps = new EditNewsSteps();
    AddNewsSteps addNewsSteps = new AddNewsSteps();

    @Rule
    public ActivityScenarioRule<AppActivity> activityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);
    @Before
    public void setUp() {
        try {
            mainPageSteps.loadMainPage();
            mainPageSteps.checkElements();
            mainPageSteps.clickAllNewsButton();
            newsPageSteps.clickPanelButton();
            controlPanelSteps.checkPanelTitle();
        } catch (Exception e) {
            authSteps.loadAuthPage();
            authSteps.validData();
            authSteps.clickEnterButton();
            mainPageSteps.checkElements();
            mainPageSteps.clickAllNewsButton();
            newsPageSteps.clickPanelButton();
            controlPanelSteps.checkPanelTitle();
        }
    }

//TC-40. "Отображение элементов на странице Панель управления"
    @Test
    public void tc_40() {
        controlPanelSteps.checkElements();
    }
//TC-41. Сортировка новостей
    @Test
    public void tc_41() {
        controlPanelSteps.sortNews();
        controlPanelSteps.checkSortedNews();
    }
//TC-42. Раскрытие/скрытие отдельной новости
    @Test
    public void tc_42() {
        controlPanelSteps.expandSeparateNews();
        controlPanelSteps.checkDescription();
    }
//TC-43. Нажатие на кнопку фильтрации
    @Test
    public void tc_43() {
        controlPanelSteps.clickFilterButton();
        filterSteps.checkFilterTitle();
        filterSteps.clickCancel();
    }
//TC-44. Переход во вкладку "Редактирование новости" путем нажатия на карандаш под новостью
    @Test
    public void tc_44() {
        controlPanelSteps.clickEditNews();
        editNewsSteps.cancelEdit();
    }
//TC-45. Переход во вкладку "Создание новости" путем нажатия на "+"
    @Test
    public void tc_45() {
        controlPanelSteps.clickAddNews();
        addNewsSteps.checkTitle();
        addNewsSteps.cancelAddNews();
    }
}
