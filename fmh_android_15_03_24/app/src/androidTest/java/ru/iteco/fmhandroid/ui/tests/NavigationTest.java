package ru.iteco.fmhandroid.ui.tests;


import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ru.iteco.fmhandroid.ui.AppActivity;

import ru.iteco.fmhandroid.ui.steps.AuthSteps;
import ru.iteco.fmhandroid.ui.steps.MainPageSteps;
import ru.iteco.fmhandroid.ui.steps.NewsPageSteps;
import ru.iteco.fmhandroid.ui.steps.ToolsSteps;

@RunWith(AndroidJUnit4.class)

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
    public void tc_89() {
        mainPageSteps.clickAllNewsButton();
        toolsSteps.clickNavigationButton();
        toolsSteps.clickMain();
        mainPageSteps.checkElements();
    }
//TC-90. Переход на вкладку "Новости" при нажатии на кнопку "Новости"
    @Test
    public void tc_90() {
        toolsSteps.clickNavigationButton();
        toolsSteps.clickNews();
        newsPageSteps.checkElements();
    }
}

