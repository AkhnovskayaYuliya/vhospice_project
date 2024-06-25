package ru.iteco.fmhandroid.ui.DataHelper;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.equalTo;

import android.os.IBinder;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.NoMatchingViewException;
import androidx.test.espresso.PerformException;
import androidx.test.espresso.Root;
import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.contrib.PickerActions;
import androidx.test.espresso.matcher.RootMatchers;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.espresso.util.HumanReadables;
import androidx.test.espresso.util.TreeIterables;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeoutException;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;

public class DataHelper {
    public class User {
        private String login;
        private String password;

        public User(String login, String password) {
            this.login = login;
            this.password = password;
        }

        public String getLogin() {
            return login;
        }

        public String getPassword() {
            return password;
        }
    }

    public User validUser() {
        return new User("login2", "password2");
    }

    public User invalidUser() {
        return new User("example1", "example2");
    }

    public class ToastMatcher extends TypeSafeMatcher<Root> {
        @Override
        public void describeTo(Description description) {
            description.appendText("is toast");
        }

        @Override
        public boolean matchesSafely(Root root) {
            int type = root.getWindowLayoutParams().get().type;
            if (type == WindowManager.LayoutParams.TYPE_TOAST) {
                IBinder windowToken = root.getDecorView().getWindowToken();
                IBinder appToken = root.getDecorView().getApplicationWindowToken();
                return windowToken == appToken;
            }
            return false;
        }
    }

    public void checkToast(String text) {
        Allure.step("Проверка Toast");
        onView(withText(text))
                .inRoot(new ToastMatcher())
                .check(matches(isDisplayed()));
    }

    public Matcher<View> withIndex(final Matcher<View> matcher, final int index) {
        return new TypeSafeMatcher<View>() {
            private int currentIndex = 0;

            @Override
            public void describeTo(Description description) {
                description.appendText("with index: ");
                description.appendValue(index);
                matcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                return matcher.matches(view) && currentIndex++ == index;
            }
        };
    }

    public List<Date> getDisplayedDates(int recyclerViewId, int textViewId) {
        final List<Date> dates = new ArrayList<>();
        Espresso.onView(ViewMatchers.withId(recyclerViewId)).check(ViewAssertions.matches(new TypeSafeMatcher<View>() {

            @Override
            public void describeTo(Description description) {
                description.appendText("Get all dates from RecyclerView");
            }

            @Override
            public boolean matchesSafely(View view) {
                RecyclerView recyclerView = (RecyclerView) view;
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                for (int i = 0; i < recyclerView.getChildCount(); i++) {
                    TextView dateView = recyclerView.getChildAt(i).findViewById(textViewId);
                    try {
                        dates.add(dateFormat.parse(dateView.getText().toString()));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
                return true;
            }
        }));
        return dates;
    }

    public Matcher<View> childAtPosition(final Matcher<View> parentMatcher, final int position) {
        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewGroup parent = (ViewGroup) view.getParent();
                return parent != null && parentMatcher.matches(parent)
                        && view.equals(parent.getChildAt(position));
            }
        };
    }

    public void selectCategory(String category) {
        Allure.step("Выбор категории");
        onView(ViewMatchers.withText(category))
                .inRoot(RootMatchers.isPlatformPopup())
                .perform(click());
    }

    public boolean isViewDisplayed(int viewId) {
        try {
            onView(withId(viewId)).check(matches(isDisplayed()));
            return true;
        } catch (NoMatchingViewException e) {
            return false;
        }
    }

    public class News {
        private String title;
        private String description;

        public News(String title, String description) {
            this.title = title;
            this.description = description;
        }

        public String getTitle() {
            return title;
        }

        public String getDescription() {
            return description;
        }
    }

    public News cyrillic() {
        return new News("какое-то название", "какое-то описание");
    }

    public News latin() {
        return new News("some title", "some description");
    }

    public News specialSymbols() {
        return new News("123   &&&", "1224   *%$");
    }

    public void setDateInDatePicker() {
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        int year = tomorrow.getYear();
        int month = tomorrow.getMonthValue();
        int day = tomorrow.getDayOfMonth();
        onView(withClassName(equalTo(DatePicker.class.getName())))
                .perform(PickerActions.setDate(year, month, day));
    }

    public void resultOfFilter() {
        onView(withId(R.id.news_list_recycler_view))
                .check(matches(isDisplayed()));
        if (!isViewDisplayed(R.id.news_list_recycler_view)) {
            onView(withId(R.id.control_panel_news_retry_material_button))
                    .check(matches(isDisplayed()));
        }
    }

    public static ViewAction waitForElement(final Matcher matcher, final long millis) {
        return new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return isRoot();
            }

            @Override
            public String getDescription() {
                return "wait for a specific view with attribute <" + matcher + "> during " + millis + " millis.";
            }

            @Override
            public void perform(final UiController uiController, final View view) {
                uiController.loopMainThreadUntilIdle();
                final long startTime = System.currentTimeMillis();
                final long endTime = startTime + millis;
                final Matcher<View> viewMatcher = matcher;

                do {
                    for (View child : TreeIterables.breadthFirstViewTraversal(view)) {
                        try {
                            if (viewMatcher.matches(child)) {
                                return;
                            }
                        } catch (NoMatchingViewException ignored) {
                        }

                        uiController.loopMainThreadForAtLeast(100);
                    }
                }
                while (System.currentTimeMillis() < endTime);

                throw new PerformException.Builder()
                        .withActionDescription(this.getDescription())
                        .withViewDescription(HumanReadables.describe(view))
                        .withCause(new TimeoutException())
                        .build();
            }
        };
    }

    public static void waitingElement(Matcher matcher, int millis) {
        onView(isRoot()).perform(waitForElement(matcher, millis));
    }
}

