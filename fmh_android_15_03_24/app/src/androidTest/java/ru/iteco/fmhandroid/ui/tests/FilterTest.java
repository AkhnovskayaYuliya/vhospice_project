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
import ru.iteco.fmhandroid.ui.DataHelper.DataHelper;
import ru.iteco.fmhandroid.ui.steps.AuthSteps;
import ru.iteco.fmhandroid.ui.steps.ControlPanelSteps;
import ru.iteco.fmhandroid.ui.steps.FilterSteps;
import ru.iteco.fmhandroid.ui.steps.MainPageSteps;
import ru.iteco.fmhandroid.ui.steps.NewsPageSteps;
import ru.iteco.fmhandroid.ui.steps.ToolsSteps;

@RunWith(AllureAndroidJUnit4.class)
@Epic("Тестирование вкладки 'Фильтровать новости'")
public class FilterTest {
    DataHelper dataHelper = new DataHelper();
    FilterSteps filterSteps = new FilterSteps();
    AuthSteps authSteps = new AuthSteps();
    MainPageSteps mainPageSteps = new MainPageSteps();
    NewsPageSteps newsPageSteps = new NewsPageSteps();
    ControlPanelSteps controlPanelSteps = new ControlPanelSteps();

    @Rule
    public ActivityScenarioRule<AppActivity> activityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void setUp() {
        try {
            mainPageSteps.loadMainPage();
            mainPageSteps.clickAllNewsButton();
            newsPageSteps.clickPanelButton();
            controlPanelSteps.clickFilterButton();
            filterSteps.checkFilterTitle();
        } catch (Exception e) {
            authSteps.loadAuthPage();
            authSteps.validData();
            authSteps.clickEnterButton();
            mainPageSteps.checkElements();
            mainPageSteps.clickAllNewsButton();
            newsPageSteps.clickPanelButton();
            controlPanelSteps.clickFilterButton();
            filterSteps.checkFilterTitle();
        }
    }

//TC-26. Фильтрация новостей по выбору категории "Объявление"
    @Test
    @Story("TC-26")
    @Description("Фильтрация новостей по выбору категории 'Объявление'")
    public void tc_26() {
        filterSteps.clickCategoty();
        dataHelper.selectCategory("Объявление");
        filterSteps.clickFilterButton();
        dataHelper.resultOfFilter();
    }
//TC-27.Фильтрация новостей по выбору категории "День рождения"
    @Test
    @Story("TC-27")
    @Description("Фильтрация новостей по выбору категории 'День рождения'")
    public void tc_27() {
        filterSteps.clickCategoty();
        dataHelper.selectCategory("День рождения");
        filterSteps.clickFilterButton();
        dataHelper.resultOfFilter();
    }
//TC-28. Фильтрация новостей по выбору категории "Зарплата"
    @Test
    @Story("TC-28")
    @Description("Фильтрация новостей по выбору категории 'Зарплата'")
    public void tc_28() {
        filterSteps.clickCategoty();
        dataHelper.selectCategory("Зарплата");
        filterSteps.clickFilterButton();
        dataHelper.resultOfFilter();
    }
//TC-29. Фильтрация новостей по выбору категории "Профсоюз"
    @Test
    @Story("TC-29")
    @Description("Фильтрация новостей по выбору категории 'Профсоюз'")
    public void tc_29() {
        filterSteps.clickCategoty();
        dataHelper.selectCategory("Профсоюз");
        filterSteps.clickFilterButton();
        dataHelper.resultOfFilter();
    }
//TC-30. Фильтрация новостей по выбору категории "Праздник"
    @Test
    @Story("TC-30")
    @Description("Фильтрация новостей по выбору категории 'Праздник'")
    public void tc_30() {
        filterSteps.clickCategoty();
        dataHelper.selectCategory("Праздник");
        filterSteps.clickFilterButton();
        dataHelper.resultOfFilter();
    }
//TC-31. Фильтрация новостей по выбору категории "Массаж"
    @Test
    @Story("TC-31")
    @Description("Фильтрация новостей по выбору категории 'Массаж'")
    public void tc_31() {
        filterSteps.clickCategoty();
        dataHelper.selectCategory("Массаж");
        filterSteps.clickFilterButton();
        dataHelper.resultOfFilter();
    }
//TC-32. Фильтрация новостей по выбору категории "Благодарность"
    @Test
    @Story("TC-32")
    @Description("Фильтрация новостей по выбору категории 'Благодарность'")
    public void tc_32() {
        filterSteps.clickCategoty();
        dataHelper.selectCategory("Благодарность");
        filterSteps.clickFilterButton();
        dataHelper.resultOfFilter();
    }
//TC-33. Фильтрация новостей по выбору категории "Нужна помощь"
    @Test
    @Story("TC-33")
    @Description("Фильтрация новостей по выбору категории 'Нужна помощь'")
    public void tc_33() {
        filterSteps.clickCategoty();
        dataHelper.selectCategory("Нужна помощь");
        filterSteps.clickFilterButton();
        dataHelper.resultOfFilter();
    }
//TC-34. Ввод в поле Категория кириллицы
    @Test
    @Story("TC-34")
    @Description("Ввод в поле Категория кириллицы")
    public void tc_34() {
        filterSteps.inputCategory("Объявления");
        filterSteps.clickFilterButton();
        dataHelper.resultOfFilter();
    }
//TC-35. Ввод в поле Категория латиницы, чисел, спецсимволов
    @Test
    @Story("TC-35")
    @Description("Ввод в поле Категория латиницы, чисел, спецсимволов")
    public void tc_35() {
        filterSteps.inputCategory("sdf22%%");
        filterSteps.clickFilterButton();
        dataHelper.resultOfFilter();
    }
//TC-36. Фильтрация с вводом даты в оба окна
    @Test
    @Story("TC-36")
    @Description("Фильтрация с вводом даты в оба окна")
    public void tc_36() {
        filterSteps.selectDate();
        filterSteps.clickFilterButton();
        dataHelper.resultOfFilter();
    }
//TC-59. Фильтрация по критерию "Активна"
    @Test
    @Story("TC-59")
    @Description("Фильтрация по критерию 'Активна'")
    public void tc_59() {
        filterSteps.clickInactiveCheckBox();
        filterSteps.clickFilterButton();
        dataHelper.resultOfFilter();
    }
//TC-60. Фильтрация по критерию "Неактивна"
    @Test
    @Story("TC-60")
    @Description("Фильтрация по критерию 'Неактивна'")
    public void tc_60(){
        filterSteps.clickActiveCheckBox();
        filterSteps.clickFilterButton();
        dataHelper.resultOfFilter();
    }
}

