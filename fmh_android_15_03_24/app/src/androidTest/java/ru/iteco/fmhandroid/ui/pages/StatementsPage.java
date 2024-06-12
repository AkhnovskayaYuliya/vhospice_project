package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.allOf;

import android.view.View;
import android.view.ViewGroup;

import androidx.test.espresso.ViewInteraction;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.DataHelper.DataHelper;

public class StatementsPage {
    DataHelper dataHelper = new DataHelper();
    public ViewInteraction pageTitle;
    public ViewInteraction statementDescription;
    public ViewInteraction statementList;
    public ViewInteraction statement;

    public StatementsPage() {
        pageTitle = onView(withText("Главное - жить любя"));
        statementDescription = onView(dataHelper.withIndex(withId(R.id.our_mission_item_description_text_view), 0));
        statementList = onView(withId(R.id.our_mission_item_list_recycler_view));
        statement = onView(withId(R.id.our_mission_item_list_recycler_view));
    }
}

