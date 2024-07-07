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
@Epic("Тестирование главной страницы")
public class MainPageTest {
    AuthSteps authSteps = new AuthSteps();
    MainPageSteps mainPageSteps = new MainPageSteps();
    NewsPageSteps newsPageSteps = new NewsPageSteps();
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
    @Story("TC-17")
    @Description("Проверка элементов главной страницы")
    public void tc_17() {
        mainPageSteps.checkElements();
    }

//TC-18 Раскрытие/скрытие списка новостей путем нажатия на стрелочку вниз/вверх
    @Test
    @Story("TC-18")
    @Description("Раскрытие/скрытие списка новостей путем нажатия на стрелочку вниз/вверх")
    public void tc_18() {
        mainPageSteps.expandList();
        mainPageSteps.checkListIsNotDisplayed();
    }
//TC-19. Раскрытие/скрытие каждой новости
    @Test
    @Story("TC-19")
    @Description("Раскрытие/скрытие каждой новости")
    public void tc_19(){
        mainPageSteps.expandSeparateNews();
        mainPageSteps.checkNewsDescription();
    }
//TC-20. Переход в раздел Новости путем нажатия на "Все новости"
    @Test
    @Story("TC-20")
    @Description("Переход в раздел Новости путем нажатия на 'Все новости'")
    public void tc_20(){
        mainPageSteps.clickAllNewsButton();
        newsPageSteps.checkElements();
    }
}
