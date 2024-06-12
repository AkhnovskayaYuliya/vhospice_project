package ru.iteco.fmhandroid.ui.tests;

import static androidx.test.espresso.action.ViewActions.click;

import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasData;


import androidx.test.espresso.intent.Intents;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;


import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ru.iteco.fmhandroid.ui.AppActivity;

import ru.iteco.fmhandroid.ui.pages.AboutApplicationPage;

import ru.iteco.fmhandroid.ui.steps.AboutAppSteps;

import ru.iteco.fmhandroid.ui.steps.AuthSteps;
import ru.iteco.fmhandroid.ui.steps.MainPageSteps;

import ru.iteco.fmhandroid.ui.steps.ToolsSteps;

@RunWith(AndroidJUnit4.class)
public class AboutAppTest {
    AboutApplicationPage aboutApp = new AboutApplicationPage();
    AuthSteps authSteps = new AuthSteps();
    MainPageSteps mainPageSteps = new MainPageSteps();

    ToolsSteps toolsSteps = new ToolsSteps();
    AboutAppSteps aboutAppSteps = new AboutAppSteps();

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

//TC-95. Отображение всех элементов на странице
//TC-91. Переход на вкладку "О приложении" при нажатии на кнопку "О приложении"
    @Test
    public void tc_95_91() {
        toolsSteps.clickNavigationButton();
        toolsSteps.clickAboutApp();
        aboutAppSteps.checkElements();
        aboutAppSteps.clickBack();
    }
//TC-96. Просмотр ссылки "Политика конфиденциальности"
    @Test
    public void tc_96() {
        toolsSteps.clickNavigationButton();
        toolsSteps.clickAboutApp();
        Intents.init();
        aboutApp.privacyPolicy.perform(click());
        intended(hasData("https://vhospice.org/#/privacy-policy"));
        Intents.release();
    }
//TC-97. Просмотр ссылки "Пользовательское соглашение"
    @Test
    public void tc_97() {
        toolsSteps.clickNavigationButton();
        toolsSteps.clickAboutApp();
        Intents.init();
        aboutApp.termOfUse.perform(click());
        intended(hasData("https://vhospice.org/#/terms-of-use"));
        Intents.release();
    }
}
