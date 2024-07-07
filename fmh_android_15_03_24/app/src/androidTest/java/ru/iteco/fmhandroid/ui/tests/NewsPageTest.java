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
import ru.iteco.fmhandroid.ui.steps.AuthSteps;
import ru.iteco.fmhandroid.ui.steps.ControlPanelSteps;
import ru.iteco.fmhandroid.ui.steps.FilterSteps;
import ru.iteco.fmhandroid.ui.steps.MainPageSteps;
import ru.iteco.fmhandroid.ui.steps.NewsPageSteps;
import ru.iteco.fmhandroid.ui.steps.ToolsSteps;


@RunWith(AllureAndroidJUnit4.class)
@Epic("Тестирование страницы 'Новости'")
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
    @Story("TC-21")
    @Description("Отображение элементов на странице Новости")
    public void tc_21() {
        newsPageSteps.checkElements();
    }
//TC-22. Раскрытие/скрытие каждой новости
    @Test
    @Story("TC-22")
    @Description("Раскрытие/скрытие каждой новости")
    public void tc_22() {
        newsPageSteps.expandSeparateNews();
        newsPageSteps.checkDescription();
    }
//TC-23. Сортировка новостей путем нажатия на ↑↓
    @Test
    @Story("TC-23")
    @Description("Сортировка новостей путем нажатия на ↑↓")
    public void tc_23() {
        newsPageSteps.sortNews();
        newsPageSteps.checkSortedNews();
    }
//TC-24. Нажатие на кнопку фильтрации (3 ползунка)
    @Test
    @Story("TC-24")
    @Description("Нажатие на кнопку фильтрации (3 ползунка)")
    public void tc_24() {
        newsPageSteps.clickFilter();
        filterSteps.checkFilterTitle();
        filterSteps.clickCancel();
    }
//TC-25. Переход к панели управления путем нажатия на карандаш
    @Test
    @Story("TC-25")
    @Description("Переход к панели управления путем нажатия на карандаш")
    public void tc_25() {
        newsPageSteps.clickPanelButton();
        controlPanelSteps.checkPanelTitle();
    }
}

