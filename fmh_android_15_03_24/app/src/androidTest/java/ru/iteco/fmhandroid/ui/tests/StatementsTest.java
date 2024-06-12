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

import ru.iteco.fmhandroid.ui.steps.StatementSteps;
import ru.iteco.fmhandroid.ui.steps.ToolsSteps;

@RunWith(AndroidJUnit4.class)
public class StatementsTest {
    AuthSteps authSteps = new AuthSteps();
    MainPageSteps mainPageSteps = new MainPageSteps();
    ToolsSteps toolsSteps = new ToolsSteps();
    StatementSteps statementSteps = new StatementSteps();

    @Rule
    public ActivityScenarioRule<AppActivity> activityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);


    @Before
    public void setUp() {
        try {
            mainPageSteps.loadMainPage();
            mainPageSteps.checkElements();
        } catch (Exception e) {
            authSteps.loadAuthPage();
            authSteps.validData();
            authSteps.clickEnterButton();
            mainPageSteps.checkElements();
            toolsSteps.clickButterfly();
        }
    }

//TC-86. Отображение элементов на странице
    @Test
    public void tc_86()  {
        statementSteps.checkElement();
    }
//TC-87. Возможность развернуть/свернуть каждую отдельную цитату
    @Test
    public void tc_87()  {
        statementSteps.expandStatement();
        statementSteps.checkDescription();
    }
}
