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
import ru.iteco.fmhandroid.ui.steps.MainPageSteps;
import ru.iteco.fmhandroid.ui.steps.NewsPageSteps;
import ru.iteco.fmhandroid.ui.steps.ToolsSteps;

@RunWith(AllureAndroidJUnit4.class)
@Epic("Тестирование навигации")

public class NavigationTest {

    AuthSteps authSteps = new AuthSteps();
    MainPageSteps mainPageSteps = new MainPageSteps();
    NewsPageSteps newsPageSteps = new NewsPageSteps();
    ToolsSteps toolsSteps = new ToolsSteps();


    @Rule
    public ActivityScenarioRule<AppActivity> activityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void auth() {
        try {
            mainPageSteps.loadMainPage();
            mainPageSteps.checkElements();
        } catch (Exception e) {
            authSteps.loadAuthPage();
            authSteps.validData();
            authSteps.clickEnterButton();
            mainPageSteps.checkElements();
        }
    }


//TC-89. Переход на вкладку "Главная" с помощью нажатия кнопки "Главная"
    @Test
    @Story("TC-89")
    @Description("Переход на вкладку 'Главная' с помощью нажатия кнопки 'Главная'")
    public void tc_89() {
        mainPageSteps.clickAllNewsButton();
        toolsSteps.clickNavigationButton();
        toolsSteps.clickMain();
        mainPageSteps.checkElements();
    }
//TC-90. Переход на вкладку "Новости" при нажатии на кнопку "Новости"
    @Test
    @Story("TC-90")
    @Description("Переход на вкладку 'Новости' при нажатии на кнопку 'Новости'")
    public void tc_90() {
        toolsSteps.clickNavigationButton();
        toolsSteps.clickNews();
        newsPageSteps.checkElements();
    }
}

