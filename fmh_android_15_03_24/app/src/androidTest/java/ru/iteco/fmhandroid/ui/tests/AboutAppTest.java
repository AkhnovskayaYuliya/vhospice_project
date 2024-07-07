package ru.iteco.fmhandroid.ui.tests;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasData;
import androidx.test.espresso.intent.Intents;
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

import ru.iteco.fmhandroid.ui.pages.AboutApplicationPage;

import ru.iteco.fmhandroid.ui.steps.AboutAppSteps;

import ru.iteco.fmhandroid.ui.steps.AuthSteps;
import ru.iteco.fmhandroid.ui.steps.MainPageSteps;

import ru.iteco.fmhandroid.ui.steps.ToolsSteps;

@RunWith(AllureAndroidJUnit4.class)
@Epic("Тестирование вкладки 'О приложении'")
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
    @Story("TC-95, TC-91")
    @Description("Отображение всех элементов на странице, переход на вкладку 'О приложении' при нажатии на кнопку 'О приложении'")
    public void tc_95_91() {
        toolsSteps.clickNavigationButton();
        toolsSteps.clickAboutApp();
        aboutAppSteps.checkElements();
        aboutAppSteps.clickBack();
    }
//TC-96. Просмотр ссылки "Политика конфиденциальности"
    @Test
    @Story("TC-96")
    @Description("Просмотр ссылки 'Политика конфиденциальности'")
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
    @Story("TC-97")
    @Description("Просмотр ссылки 'Пользовательское соглашение'")
    public void tc_97() {
        toolsSteps.clickNavigationButton();
        toolsSteps.clickAboutApp();
        Intents.init();
        aboutApp.termOfUse.perform(click());
        intended(hasData("https://vhospice.org/#/terms-of-use"));
        Intents.release();
    }
}
