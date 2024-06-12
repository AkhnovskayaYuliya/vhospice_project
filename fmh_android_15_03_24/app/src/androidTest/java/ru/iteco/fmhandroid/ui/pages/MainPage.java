package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import androidx.test.espresso.ViewInteraction;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.DataHelper.DataHelper;

public class MainPage {
    DataHelper dataHelper = new DataHelper();
    public ViewInteraction pageTitle;
    public ViewInteraction expandListButton;
    public ViewInteraction allNewsButton;
    public ViewInteraction separateNews;
    public ViewInteraction newsDescription;
    public ViewInteraction newsList;


public MainPage() {
    pageTitle = onView(withText("Новости"));
    expandListButton = onView(withId(R.id.expand_material_button));
    allNewsButton = onView(withId(R.id.all_news_text_view));
    newsDescription = onView(dataHelper.withIndex(withId(R.id.news_item_description_text_view), 0));
    newsList = onView(withId(R.id.news_list_recycler_view));
    separateNews = onView(allOf(withId(R.id.news_list_recycler_view),
                    dataHelper.childAtPosition(withId(R.id.all_news_cards_block_constraint_layout), 0)));

  }
}
