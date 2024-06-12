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
public class MainPageTest {
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


    @Test
    public void tc_17() {
        mainPageSteps.checkElements();
    }

//TC-18 Раскрытие/скрытие списка новостей путем нажатия на стрелочку вниз/вверх
    @Test
    public void tc_18() {
        mainPageSteps.expandList();
        mainPageSteps.checkListIsNotDisplayed();
    }
//TC-19. Раскрытие/скрытие каждой новости
    @Test
    public void tc_19(){
        mainPageSteps.expandSeparateNews();
        mainPageSteps.checkNewsDescription();
    }
//TC-20. Переход в раздел Новости путем нажатия на "Все новости"
    @Test
    public void tc_20(){
        mainPageSteps.clickAllNewsButton();
        newsPageSteps.checkElements();
    }
}
