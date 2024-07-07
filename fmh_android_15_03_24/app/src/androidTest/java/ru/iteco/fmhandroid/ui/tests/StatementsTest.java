package ru.iteco.fmhandroid.ui.tests;


import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Epic;
import io.qameta.allure.kotlin.Story;
import ru.iteco.fmhandroid.ui.AppActivity;

import ru.iteco.fmhandroid.ui.pages.StatementsPage;
import ru.iteco.fmhandroid.ui.steps.AuthSteps;
import ru.iteco.fmhandroid.ui.steps.MainPageSteps;

import ru.iteco.fmhandroid.ui.steps.StatementSteps;
import ru.iteco.fmhandroid.ui.steps.ToolsSteps;

@RunWith(AllureAndroidJUnit4.class)
@Epic("Тестирование вкладки 'Главное - жить любя'")
public class StatementsTest {
    AuthSteps authSteps = new AuthSteps();
    MainPageSteps mainPageSteps = new MainPageSteps();
    ToolsSteps toolsSteps = new ToolsSteps();
    StatementSteps statementSteps = new StatementSteps();
    StatementsPage page = new StatementsPage();

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
        }
    }

//TC-86. Отображение элементов на странице
    @Test
    @Story("TC-86")
    @Description("Отображение элементов на странице")
    public void tc_86()  {
        toolsSteps.clickButterfly();
        statementSteps.checkElement();
    }
//TC-87. Возможность развернуть/свернуть каждую отдельную цитату
    @Test
    @Story("TC-87")
    @Description("Возможность развернуть/свернуть каждую отдельную цитату")
    public void tc_87()  {
        toolsSteps.clickButterfly();
        statementSteps.expandStatement();
        statementSteps.checkDescription();
    }
}
