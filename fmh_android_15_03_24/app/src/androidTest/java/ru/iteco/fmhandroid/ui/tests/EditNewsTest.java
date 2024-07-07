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

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Epic;
import io.qameta.allure.kotlin.Story;
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

@RunWith(AllureAndroidJUnit4.class)
@Epic("Тестирование вкладки 'Редактирование новости'")
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
    @Story("TC-64, TC-68")
    @Description("Ввод в поля 'Заголовок' и 'Описание' латиницы, изменение даты публикации")
    public void tc_64_68()  {
        editNewsSteps.changeDate();
        editNewsSteps.changeTitle(dataHelper.latinEdit().getTitle());
        editNewsSteps.changeDescription(dataHelper.latinEdit().getDescription());
        editNewsSteps.clickSave();
        editNewsSteps.checkChanges(dataHelper.latinEdit().getTitle());
    }
//TC-65. Ввод в поля "Заголовок" и "Описание" кириллицы
//TC-70. Изменение времени публикации с помощью циферблата
    @Test
    @Story("TC-65, TC-70")
    @Description("Ввод в поля 'Заголовок' и 'Описание' кириллицы, изменение времени публикации с помощью циферблата")
    public void tc_65_70() {
        editNewsSteps.changeTime();
        editNewsSteps.changeTitle(dataHelper.cyrillicEdit().getTitle());
        editNewsSteps.changeDescription(dataHelper.cyrillicEdit().getDescription());
        editNewsSteps.clickSave();
        editNewsSteps.checkChanges(dataHelper.cyrillicEdit().getTitle());
    }
//TC-66.Ввод в поля "Заголовок" и "Описание" чисел, спецсимволов, пробелов
//TC-74.Изменение статуса "Активна" с помощью ползунка
    @Test
    @Story("TC-66, TC-74")
    @Description("Ввод в поля 'Заголовок' и 'Описание' чисел, спецсимволов, пробелов, изменение статуса 'Активна' с помощью ползунка")
    public void tc_66_74() {
        editNewsSteps.changeTitle(dataHelper.specialSymbolsEdit().getTitle());
        editNewsSteps.changeDescription(dataHelper.specialSymbolsEdit().getDescription());
        editNewsSteps.changeStatus();
        editNewsSteps.clickSave();
        editNewsSteps.checkChanges(dataHelper.specialSymbolsEdit().getTitle());
    }
//TC-67. Поля "Заголовок" и "Описание" остаются пустыми
//TC-75. Отмена редактирования с помощью нажатия кнопки "Отмена"
    @Test
    @Story("TC-67, TC-75")
    @Description("Поля 'Заголовок' и 'Описание' остаются пустыми, отмена редактирования с помощью нажатия кнопки 'Отмена'")
    public void tc_67_75() {
        editNewsSteps.changeTitle("");
        editNewsSteps.changeDescription("");
        editNewsSteps.clickSave();
        dataHelper.checkToast("Заполните пустые поля");
        editNewsSteps.cancelEdit();
    }
}
