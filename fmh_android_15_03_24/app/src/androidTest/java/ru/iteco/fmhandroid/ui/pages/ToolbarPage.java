package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class ToolbarPage {
    public ViewInteraction navigationButton;
    public ViewInteraction appTrademark;
    public ViewInteraction butterflyButton;
    public ViewInteraction personButton;
    public ViewInteraction exitButton;
    public ViewInteraction mainButton;
    public ViewInteraction newsButton;
    public ViewInteraction aboutAppButton;


    public ToolbarPage() {
        navigationButton = onView(withId(R.id.main_menu_image_button));
        appTrademark = onView(withId(R.id.trademark_image_view));
        butterflyButton = onView(withId(R.id.our_mission_image_button));
        personButton = onView(withId(R.id.authorization_image_button));
        exitButton = onView(withId(android.R.id.title));
        mainButton =  onView(allOf(withId(android.R.id.title), withText("Главная")));
        newsButton = onView(allOf(withId(android.R.id.title), withText("Новости")));
        aboutAppButton = onView(allOf(withId(android.R.id.title), withText("О приложении")));
    }
}
