package ru.iteco.fmhandroid.ui.tests;

import androidx.test.ext.junit.rules.ActivityScenarioRule;


import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Epic;
import io.qameta.allure.kotlin.Issue;
import io.qameta.allure.kotlin.Story;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.DataHelper.DataHelper;

import ru.iteco.fmhandroid.ui.steps.AuthSteps;
import ru.iteco.fmhandroid.ui.steps.MainPageSteps;
import ru.iteco.fmhandroid.ui.steps.ToolsSteps;

@RunWith(AllureAndroidJUnit4.class)
@Epic("Тестирование авторизации")

public class AuthTest {
    @Rule
    public ActivityScenarioRule<AppActivity> activityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);
    AuthSteps authSteps = new AuthSteps();
    DataHelper dataHelper = new DataHelper();
    MainPageSteps mainPageSteps = new MainPageSteps();
    ToolsSteps toolsSteps = new ToolsSteps();

    @Before
    public void setUp()  {
        try {
            authSteps.loadAuthPage();
        } catch (Exception e) {
            toolsSteps.exit();
            authSteps.loadAuthPage();
        }
    }

//TC-1. Отображение элементов на странице авторизации
    @Test
    @Story("TC-1")
    @Description("Отображение элементов на странице авторизации")
    public void tc_1()  {
        authSteps.checkElementsAuth();
    }

//TC-2. Авторизация зарегистрированного пользователя
    @Test
    @Story("TC-2")
    @Description("Авторизация зарегистрированного пользователя")
    public void tc_2() {
        authSteps.validData();
        authSteps.clickEnterButton();
        mainPageSteps.checkElements();
    }

//TC_3. Поле "Логин" остается пустым при заполнении полей авторизации
//TC-10. Поле "Пароль" остается пустым при заполнении полей авторизации
    @Test
    @Story("TC-3, TC-10")
    @Description("Поле 'Логин' остается пустым при заполнении полей авторизации, поле 'Пароль' остается пустым при заполнении полей авторизации")
    public  void tc_3_10()  {
        authSteps.clickEnterButton();
        dataHelper.checkToast("Логин и пароль не могут быть пустыми");
        authSteps.checkElementsAuth();
    }
//TC-4. Ввод в поле "Логин" невалидных данных
//TC-11. Ввод в поле "Пароль" невалидных данных
    @Test //bug
    @Story("TC-4, TC-11")
    @Description("Ввод в поле 'Логин' невалидных данных, ввод в поле 'Пароль' невалидных данных")
    public void tc_4_11() {
        authSteps.invalidData();
        authSteps.clickEnterButton();
        dataHelper.checkToast("Неверный логин или пароль"); //Actual "Что-то пошло не так. Попробуйте позже"
        authSteps.checkElementsAuth();
    }

//TC-98. Нажатие на кнопку "Выйти" приводит к выходу из учетной записи пользователя
    @Test
    @Story("TC-98")
    @Description("Нажатие на кнопку 'Выйти' приводит к выходу из учетной записи пользователя")
    public void tc_98()  {
        authSteps.validData();
        authSteps.clickEnterButton();
        toolsSteps.exit();
        authSteps.checkElementsAuth();
    }
}

