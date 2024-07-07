package ru.iteco.fmhandroid.ui.tests;

import androidx.test.ext.junit.rules.ActivityScenarioRule;


import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Epic;
import io.qameta.allure.kotlin.Story;
import ru.iteco.fmhandroid.ui.AppActivity;

import ru.iteco.fmhandroid.ui.steps.AddNewsSteps;
import ru.iteco.fmhandroid.ui.steps.AuthSteps;
import ru.iteco.fmhandroid.ui.steps.ControlPanelSteps;
import ru.iteco.fmhandroid.ui.steps.EditNewsSteps;
import ru.iteco.fmhandroid.ui.steps.FilterSteps;
import ru.iteco.fmhandroid.ui.steps.MainPageSteps;
import ru.iteco.fmhandroid.ui.steps.NewsPageSteps;

@RunWith(AllureAndroidJUnit4.class)
@Epic("Тестирование Панели управления")
public class ControlPanelTest {
    ControlPanelSteps controlPanelSteps = new ControlPanelSteps();
    AuthSteps authSteps = new AuthSteps();
    MainPageSteps mainPageSteps = new MainPageSteps();
    NewsPageSteps newsPageSteps = new NewsPageSteps();
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
    @Story("TC-40")
    @Description("Отображение элементов на странице Панель управления")
    public void tc_40() {
        controlPanelSteps.checkElements();
    }
//TC-41. Сортировка новостей
    @Test
    @Story("TC-41")
    @Description("Сортировка новостей")
    public void tc_41() {
        controlPanelSteps.sortNews();
        controlPanelSteps.checkSortedNews();
    }
//TC-42. Раскрытие/скрытие отдельной новости
    @Test
    @Story("TC-42")
    @Description("Раскрытие/скрытие отдельной новости")
    public void tc_42() {
        controlPanelSteps.expandSeparateNews();
        controlPanelSteps.checkDescription();
    }
//TC-43. Нажатие на кнопку фильтрации
    @Test
    @Story("TC-43")
    @Description("Нажатие на кнопку фильтрации")
    public void tc_43() {
        controlPanelSteps.clickFilterButton();
        filterSteps.checkFilterTitle();
        filterSteps.clickCancel();
    }
//TC-44. Переход во вкладку "Редактирование новости" путем нажатия на карандаш под новостью
    @Test
    @Story("TC-44")
    @Description("Переход во вкладку 'Редактирование новости' путем нажатия на карандаш под новостью")
    public void tc_44() {
        controlPanelSteps.clickEditNews();
        editNewsSteps.cancelEdit();
    }
//TC-45. Переход во вкладку "Создание новости" путем нажатия на "+"
    @Test
    @Story("TC-45")
    @Description("Переход во вкладку 'Создание новости' путем нажатия на '+'")
    public void tc_45() {
        controlPanelSteps.clickAddNews();
        addNewsSteps.checkTitle();
        addNewsSteps.cancelAddNews();
    }
}
