package ru.iteco.fmhandroid.ui.tests;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.equalTo;

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
import ru.iteco.fmhandroid.ui.pages.EditNewsPage;
import ru.iteco.fmhandroid.ui.pages.MainPage;
import ru.iteco.fmhandroid.ui.pages.NewsPage;
import ru.iteco.fmhandroid.ui.steps.AuthSteps;
import ru.iteco.fmhandroid.ui.steps.ControlPanelSteps;
import ru.iteco.fmhandroid.ui.steps.EditNewsSteps;
import ru.iteco.fmhandroid.ui.steps.MainPageSteps;
import ru.iteco.fmhandroid.ui.steps.NewsPageSteps;
import ru.iteco.fmhandroid.ui.steps.ToolsSteps;

@RunWith(AndroidJUnit4.class)
public class EditNewsTest {
    DataHelper dataHelper = new DataHelper();
    ControlPanelSteps controlPanelSteps = new ControlPanelSteps();
    AuthSteps authSteps = new AuthSteps();
    MainPageSteps mainPageSteps = new MainPageSteps();
    NewsPageSteps newsPageSteps = new NewsPageSteps();
    ToolsSteps toolsSteps = new ToolsSteps();
    EditNewsSteps editNewsSteps = new EditNewsSteps();
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
            controlPanelSteps.clickEditNews();
            editNewsSteps.checkTitle();
        } catch (Exception e) {
            authSteps.loadAuthPage();
            authSteps.validData();
            authSteps.clickEnterButton();
            mainPageSteps.checkElements();
            mainPageSteps.clickAllNewsButton();
            newsPageSteps.clickPanelButton();
            controlPanelSteps.clickEditNews();
            editNewsSteps.checkTitle();
        }
    }


//TC-64.Ввод в поля "Заголовок" и "Описание" латиницы
//TC-68. Изменение даты публикации
    @Test
    public void tc_64_68()  {
        editNewsSteps.changeDate();
        editNewsSteps.changeTitle(dataHelper.latin().getTitle());
        editNewsSteps.changeDescription(dataHelper.latin().getDescription());
        editNewsSteps.clickSave();
        editNewsSteps.checkChanges(dataHelper.latin().getTitle());
    }
//TC-65. Ввод в поля "Заголовок" и "Описание" кириллицы
//TC-70. Изменение времени публикации с помощью циферблата
    @Test
    public void tc_65_70() {
        editNewsSteps.changeTime();
        editNewsSteps.changeTitle(dataHelper.cyrillic().getTitle());
        editNewsSteps.changeDescription(dataHelper.cyrillic().getDescription());
        editNewsSteps.clickSave();
        editNewsSteps.checkChanges(dataHelper.cyrillic().getTitle());
    }
//TC-66.Ввод в поля "Заголовок" и "Описание" чисел, спецсимволов, пробелов
//TC-74.Изменение статуса "Активна" с помощью ползунка
    @Test
    public void tc_66_74() {
        editNewsSteps.changeTitle(dataHelper.specialSymbols().getTitle());
        editNewsSteps.changeDescription(dataHelper.specialSymbols().getDescription());
        editNewsSteps.changeStatus();
        editNewsSteps.clickSave();
        editNewsSteps.checkChanges(dataHelper.specialSymbols().getTitle());
    }
//TC-67. Поля "Заголовок" и "Описание" остаются пустыми
//TC-75. Отмена редактирования с помощью нажатия кнопки "Отмена"
    @Test
    public void tc_67_75() {
        editNewsSteps.changeTitle("");
        editNewsSteps.changeDescription("");
        editNewsSteps.clickSave();
        dataHelper.checkToast("Заполните пустые поля");
        editNewsSteps.cancelEdit();
    }
}
