package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.anyOf;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.DataHelper.DataHelper;


public class ControlPanelPage {
    DataHelper dataHelper = new DataHelper();
    public ViewInteraction pageTitle;
    public ViewInteraction sortNewsButton;
    public ViewInteraction filterNewsButton;
    public ViewInteraction addNewsButton;
    public ViewInteraction newsList;
    public ViewInteraction separateNews;
    public ViewInteraction editNewsButton;
    public ViewInteraction deleteNewsButton;
    public ViewInteraction newsDescription;
    public ViewInteraction publicationDate;
    public ViewInteraction creationDate;
    public ViewInteraction author;
    public ViewInteraction status;
    public ViewInteraction updateButton;

    public  ControlPanelPage() {
        pageTitle = onView(withText("Панель \n управления"));
        sortNewsButton = onView(withId(R.id.sort_news_material_button));
        filterNewsButton = onView(withId(R.id.filter_news_material_button));
        addNewsButton = onView(withId(R.id.add_news_image_view));
        newsList = onView(withId(R.id.news_list_recycler_view));
        separateNews = onView(withId(R.id.news_list_recycler_view));
        editNewsButton = onView(dataHelper.withIndex(withId(R.id.edit_news_item_image_view), 0));
        deleteNewsButton = onView(dataHelper.withIndex(withId(R.id.delete_news_item_image_view), 0));
        newsDescription = onView(dataHelper.withIndex(withId(R.id.news_item_description_text_view), 0));
        publicationDate = onView(dataHelper.withIndex(withId(R.id.news_item_publication_date_text_view), 0));
        creationDate = onView(dataHelper.withIndex(withId(R.id.news_item_creation_text_view), 0));
        author = onView(dataHelper.withIndex(withId(R.id.news_item_author_text_view), 0));
        status = onView(dataHelper.withIndex(withId(R.id.news_item_published_text_view), 0));
        updateButton = onView(withId(R.id.control_panel_news_retry_material_button));
    }
}
