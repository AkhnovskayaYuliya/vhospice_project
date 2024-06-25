package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;

import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;


import static org.hamcrest.Matchers.allOf;


import androidx.test.espresso.ViewInteraction;


import ru.iteco.fmhandroid.R;

public class AuthPage {

    public ViewInteraction login;
    public ViewInteraction password;
    public ViewInteraction loginButton;

    public AuthPage() {
        login =  onView(allOf(withHint("Логин"), withParent(withParent(withId(R.id.login_text_input_layout)))));
        password = onView(allOf(withHint("Пароль"), withParent(withParent(withId(R.id.password_text_input_layout)))));
        loginButton = onView(withId(R.id.enter_button));
        }
}



