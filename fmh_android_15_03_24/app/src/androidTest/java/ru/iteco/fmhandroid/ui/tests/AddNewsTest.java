package ru.iteco.fmhandroid.ui.tests;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.allOf;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.DataHelper.DataHelper;
import ru.iteco.fmhandroid.ui.pages.AddNewsPage;
import ru.iteco.fmhandroid.ui.pages.AuthPage;
import ru.iteco.fmhandroid.ui.pages.ControlPanelPage;
import ru.iteco.fmhandroid.ui.pages.MainPage;
import ru.iteco.fmhandroid.ui.pages.NewsPage;
import ru.iteco.fmhandroid.ui.steps.AddNewsSteps;
import ru.iteco.fmhandroid.ui.steps.AuthSteps;
import ru.iteco.fmhandroid.ui.steps.ControlPanelSteps;
import ru.iteco.fmhandroid.ui.steps.EditNewsSteps;
import ru.iteco.fmhandroid.ui.steps.MainPageSteps;
import ru.iteco.fmhandroid.ui.steps.NewsPageSteps;
import ru.iteco.fmhandroid.ui.steps.ToolsSteps;


@RunWith(AndroidJUnit4.class)
public class AddNewsTest {
    AuthPage authPage = new AuthPage();
    DataHelper dataHelper = new DataHelper();

    AddNewsPage addNews = new AddNewsPage();
    ControlPanelSteps controlPanelSteps = new ControlPanelSteps();
    AuthSteps authSteps = new AuthSteps();
    MainPageSteps mainPageSteps = new MainPageSteps();
    NewsPageSteps newsPageSteps = new NewsPageSteps();

    AddNewsSteps addNewsSteps = new AddNewsSteps();
    @Rule
    public ActivityScenarioRule<AppActivity> activityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);
    @Before
    public void setUp() {
        try {
            mainPageSteps.loadMainPage();
            mainPageSteps.checkElements();
            mainPageSteps.clickAllNewsButton();
            newsPageSteps.clickPanelButton();
            controlPanelSteps.clickAddNews();
            addNewsSteps.checkTitle();
        } catch (Exception e) {
            authSteps.loadAuthPage();
            authSteps.validData();
            authSteps.clickEnterButton();
            mainPageSteps.checkElements();
            mainPageSteps.clickAllNewsButton();
            newsPageSteps.clickPanelButton();
            controlPanelSteps.clickAddNews();
            addNewsSteps.checkTitle();
        }
    }

//TC-76. Создание новости
    @Test
    public void tc_76() {
        addNewsSteps.clickCategoty();
        dataHelper.selectCategory("Объявление");
        addNewsSteps.createTitle(dataHelper.cyrillic().getTitle());
        addNewsSteps.createDate();
        addNewsSteps.createTime();
        addNewsSteps.createDescription(dataHelper.cyrillic().getDescription());
        addNewsSteps.clickSave();
        addNewsSteps.checkNews(dataHelper.cyrillic().getTitle());
    }
//TC-77.Поля остаются пустыми
    @Test
    public void tc_77() {
        addNewsSteps.clickSave();
        dataHelper.checkToast("Заполните пустые поля");
        addNewsSteps.cancelAddNews();
    }
//TC-78. Ввод в поля для ввода "Заголовок" и "Описание" латиницы
    @Test
    public void tc_78() {
        addNewsSteps.clickCategoty();
        dataHelper.selectCategory("Объявление");
        addNewsSteps.createTitle(dataHelper.latin().getTitle());
        addNewsSteps.createDate();
        addNewsSteps.createTime();
        addNewsSteps.createDescription(dataHelper.latin().getDescription());
        addNewsSteps.clickSave();
        addNewsSteps.checkNews(dataHelper.latin().getTitle());
    }
//TC-79. Ввод в поля для ввода "Заголовок" и "Описание" чисел, спецсимволов, пробелов
    @Test
    public void tc_79() {
        addNewsSteps.clickCategoty();
        dataHelper.selectCategory("Объявление");
        addNewsSteps.createTitle(dataHelper.specialSymbols().getTitle());
        addNewsSteps.createDate();
        addNewsSteps.createTime();
        addNewsSteps.createDescription(dataHelper.specialSymbols().getDescription());
        addNewsSteps.clickSave();
        addNewsSteps.checkNews(dataHelper.specialSymbols().getTitle());
    }
//TC-81.Изменение времени публикации с помощью ручного ввода (валидные данные)
//TC-85. При создании новости нажатие кнопки отмена
    @Test
    public void tc_81_85() {
        addNewsSteps.manualInputTime("23", "59");
        addNews.time.check(matches(withText("23:59")));
        addNewsSteps.cancelAddNews();
    }
//TC-82.Изменение времени публикации с помощью ручного ввода (невалидные данные)
//TC-83.При изменении времени публикации нажатие кнопки "отмена"
    @Test
    public void tc_82_83() {
        addNewsSteps.manualInputTime("24", "60");
        addNewsSteps.checkTimeError();
        addNewsSteps.clickCancel();
        addNewsSteps.cancelAddNews();
    }
//TC-85. Изменение статуса "активный" с помощью ползунка
    @Test
    public void tc_85() {
        addNewsSteps.clickCategoty();
        addNewsSteps.createTitle("ляля");
        dataHelper.selectCategory("Объявление");
        addNewsSteps.createDate();
        addNewsSteps.createTime();
        addNewsSteps.createDescription(dataHelper.cyrillic().getDescription());
        addNews.description.perform(replaceText(dataHelper.cyrillic().getDescription()));
        addNewsSteps.cancelAddNews();
        addNewsSteps.checkDoesNotExist("ляля");
    }
}

