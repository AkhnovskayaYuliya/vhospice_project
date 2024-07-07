package ru.iteco.fmhandroid.ui.tests;

import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
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
import ru.iteco.fmhandroid.ui.DataHelper.DataHelper;
import ru.iteco.fmhandroid.ui.pages.AddNewsPage;
import ru.iteco.fmhandroid.ui.steps.AddNewsSteps;
import ru.iteco.fmhandroid.ui.steps.AuthSteps;
import ru.iteco.fmhandroid.ui.steps.ControlPanelSteps;
import ru.iteco.fmhandroid.ui.steps.MainPageSteps;
import ru.iteco.fmhandroid.ui.steps.NewsPageSteps;


@RunWith(AllureAndroidJUnit4.class)
@Epic("Тестирование вкладки 'Создание новости'")
public class AddNewsTest {
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
    @Story("TC-76")
    @Description("Создание новости")
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
    @Story("TC-77")
    @Description("Поля остаются пустыми")
    public void tc_77() {
        addNewsSteps.clickSave();
        dataHelper.checkToast("Заполните пустые поля");
        addNewsSteps.cancelAddNews();
    }
//TC-78. Ввод в поля для ввода "Заголовок" и "Описание" латиницы
    @Test
    @Story("TC-78")
    @Description("Ввод в поля для ввода 'Заголовок' и 'Описание' латиницы")
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
    @Story("TC-79")
    @Description("Ввод в поля для ввода 'Заголовок' и 'Описание' чисел, спецсимволов, пробелов")
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
    @Story("TC-81, TC-85")
    @Description("Изменение времени публикации с помощью ручного ввода (валидные данные), При создании новости нажатие кнопки отмена")
    public void tc_81_85() {
        addNewsSteps.manualInputTime("23", "59");
        addNews.time.check(matches(withText("23:59")));
        addNewsSteps.cancelAddNews();
    }
//TC-82.Изменение времени публикации с помощью ручного ввода (невалидные данные)
//TC-83.При изменении времени публикации нажатие кнопки "отмена"
    @Test
    @Story("TC-82, TC-83")
    @Description("Изменение времени публикации с помощью ручного ввода (невалидные данные), При изменении времени публикации нажатие кнопки отмена")
    public void tc_82_83() {
        addNewsSteps.manualInputTime("24", "60");
        addNewsSteps.checkTimeError();
        addNewsSteps.clickCancel();
        addNewsSteps.cancelAddNews();
    }
}

