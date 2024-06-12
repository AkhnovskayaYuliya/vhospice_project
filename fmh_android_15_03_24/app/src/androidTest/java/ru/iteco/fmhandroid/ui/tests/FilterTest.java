package ru.iteco.fmhandroid.ui.tests;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.anyOf;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.DataHelper.DataHelper;
import ru.iteco.fmhandroid.ui.pages.AuthPage;
import ru.iteco.fmhandroid.ui.pages.ControlPanelPage;
import ru.iteco.fmhandroid.ui.pages.FilterPage;
import ru.iteco.fmhandroid.ui.pages.MainPage;
import ru.iteco.fmhandroid.ui.pages.NewsPage;
import ru.iteco.fmhandroid.ui.pages.ToolbarPage;
import ru.iteco.fmhandroid.ui.steps.AuthSteps;
import ru.iteco.fmhandroid.ui.steps.ControlPanelSteps;
import ru.iteco.fmhandroid.ui.steps.FilterSteps;
import ru.iteco.fmhandroid.ui.steps.MainPageSteps;
import ru.iteco.fmhandroid.ui.steps.NewsPageSteps;
import ru.iteco.fmhandroid.ui.steps.ToolsSteps;

@RunWith(AndroidJUnit4.class)
public class FilterTest {
    DataHelper dataHelper = new DataHelper();
    FilterSteps filterSteps = new FilterSteps();
    AuthSteps authSteps = new AuthSteps();
    MainPageSteps mainPageSteps = new MainPageSteps();
    NewsPageSteps newsPageSteps = new NewsPageSteps();
    ControlPanelSteps controlPanelSteps = new ControlPanelSteps();
    ToolsSteps toolsSteps = new ToolsSteps();

    @Rule
    public ActivityScenarioRule<AppActivity> activityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void setUp() {
        try {
            mainPageSteps.loadMainPage();
            mainPageSteps.clickAllNewsButton();
            newsPageSteps.clickPanelButton();
            controlPanelSteps.clickFilterButton();
            filterSteps.checkFilterTitle();
        } catch (Exception e) {
            authSteps.loadAuthPage();
            authSteps.validData();
            authSteps.clickEnterButton();
            mainPageSteps.checkElements();
            mainPageSteps.clickAllNewsButton();
            newsPageSteps.clickPanelButton();
            controlPanelSteps.clickFilterButton();
            filterSteps.checkFilterTitle();
        }
    }


//TC-26. Фильтрация новостей по выбору категории "Объявление"
    @Test
    public void tc_26() {
        filterSteps.clickCategoty();
        dataHelper.selectCategory("Объявление");
        filterSteps.clickFilterButton();
        dataHelper.resultOfFilter();
    }
//TC-27.Фильтрация новостей по выбору категории "День рождения"
    @Test
    public void tc_27() {
        filterSteps.clickCategoty();
        dataHelper.selectCategory("День рождения");
        filterSteps.clickFilterButton();
        dataHelper.resultOfFilter();
    }
//TC-28. Фильтрация новостей по выбору категории "Зарплата"
    @Test
    public void tc_28() {
        filterSteps.clickCategoty();
        dataHelper.selectCategory("Зарплата");
        filterSteps.clickFilterButton();
        dataHelper.resultOfFilter();
    }
//TC-29. Фильтрация новостей по выбору категории "Профсоюз"
    @Test
    public void tc_29() {
        filterSteps.clickCategoty();
        dataHelper.selectCategory("Профсоюз");
        filterSteps.clickFilterButton();
        dataHelper.resultOfFilter();
    }
//TC-30. Фильтрация новостей по выбору категории "Праздник"
    @Test
    public void tc_30() {
        filterSteps.clickCategoty();
        dataHelper.selectCategory("Праздник");
        filterSteps.clickFilterButton();
        dataHelper.resultOfFilter();
    }
//TC-31. Фильтрация новостей по выбору категории "Массаж"
    @Test
    public void tc_31() {
        filterSteps.clickCategoty();
        dataHelper.selectCategory("Массаж");
        filterSteps.clickFilterButton();
        dataHelper.resultOfFilter();
    }
//TC-32. Фильтрация новостей по выбору категории "Благодарность"
    @Test
    public void tc_32() {
        filterSteps.clickCategoty();
        dataHelper.selectCategory("Благодарность");
        filterSteps.clickFilterButton();
        dataHelper.resultOfFilter();
    }
//TC-33. Фильтрация новостей по выбору категории "Нужна помощь"
    @Test
    public void tc_33() {
        filterSteps.clickCategoty();
        dataHelper.selectCategory("Нужна помощь");
        filterSteps.clickFilterButton();
        dataHelper.resultOfFilter();
    }
//TC-34. Ввод в поле Категория кириллицы
    @Test
    public void tc_34() {
        filterSteps.inputCategory("Объявления");
        filterSteps.clickFilterButton();
        dataHelper.resultOfFilter();
    }
//TC-35. Ввод в поле Категория латиницы, чисел, спецсимволов
    @Test
    public void tc_35() {
        filterSteps.inputCategory("sdf22%%");
        filterSteps.clickFilterButton();
        dataHelper.resultOfFilter();
    }
//TC-36. Фильтрация с вводом даты в оба окна
    @Test
    public void tc_36() {
        filterSteps.selectDate();
        filterSteps.clickFilterButton();
        dataHelper.resultOfFilter();
    }
//TC-59. Фильтрация по критерию "Активна"
    @Test
    public void tc_59() {
        filterSteps.clickInactiveCheckBox();
        filterSteps.clickFilterButton();
        dataHelper.resultOfFilter();
    }
//TC-60. Фильтрация по критерию "Неактивна"
    @Test
    public void tc_60(){
        filterSteps.clickActiveCheckBox();
        filterSteps.clickFilterButton();
        dataHelper.resultOfFilter();
    }
}

