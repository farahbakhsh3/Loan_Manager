package ir.farahbakhsh3.LoanManager.ui.Taghvim;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.snackbar.Snackbar;

import ir.farahbakhsh3.LoanManager.R;
import ir.farahbakhsh3.LoanManager.databinding.FragmentTaghvimBinding;
import ir.mirrajabi.persiancalendar.PersianCalendarView;
import ir.mirrajabi.persiancalendar.core.PersianCalendarHandler;
import ir.mirrajabi.persiancalendar.core.interfaces.OnDayClickedListener;
import ir.mirrajabi.persiancalendar.core.interfaces.OnDayLongClickedListener;
import ir.mirrajabi.persiancalendar.core.interfaces.OnEventUpdateListener;
import ir.mirrajabi.persiancalendar.core.interfaces.OnMonthChangedListener;
import ir.mirrajabi.persiancalendar.core.models.CalendarEvent;
import ir.mirrajabi.persiancalendar.core.models.PersianDate;

public class TaghvimFragment extends Fragment {

    private FragmentTaghvimBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        TaghvimViewModel taghvimViewModel =
                new ViewModelProvider(this).get(TaghvimViewModel.class);

        binding = FragmentTaghvimBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final PersianCalendarView persianCalendarView = (PersianCalendarView) root.findViewById(R.id.persian_calendar);
        //final PersianCalendarView persianCalendarView  = binding.persianCalendar;
        final PersianCalendarHandler calendar = persianCalendarView.getCalendar();
        final PersianDate today = calendar.getToday();

        calendar.addLocalEvent(new CalendarEvent(
                today, "Custom event", false
        ));
        calendar.addLocalEvent(new CalendarEvent(
                today.clone().rollDay(2, true), "Custom event 2", true
        ));


        persianCalendarView.setOnDayClickedListener(new OnDayClickedListener() {
            @Override
            public void onClick(PersianDate date) {
                TextView txtpDate = binding.textPersiandate;

                String pDate = calendar.getWeekDayName(date) + " " +
                        calendar.formatNumber(date.getDayOfMonth()) + " " +
                        calendar.getMonthName(date) + " " +
                        calendar.formatNumber(date.getYear());
                txtpDate.setText(pDate);

                for (CalendarEvent e : calendar.getLocalEventsForDay(date)) {
                    //Toast.makeText(TaghvimFragment.this.getContext(), e.getTitle(), Toast.LENGTH_LONG).show();
                    Snackbar.make(TaghvimFragment.this.requireView(), e.getTitle(), Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });

        persianCalendarView.setOnDayLongClickedListener(new OnDayLongClickedListener() {
            @Override
            public void onLongClick(PersianDate date) {
                String pDate = calendar.getWeekDayName(date) + " " +
                        calendar.formatNumber(date.getDayOfMonth()) + " " +
                        calendar.getMonthName(date) + " " +
                        calendar.formatNumber(date.getYear());

                calendar.addLocalEvent(new CalendarEvent(
                        date, "Custom " + pDate + " event", true)
                );
                calendar.addLocalEvent(new CalendarEvent(
                        date.clone().rollDay(1, false),
                        "Custom " + pDate + " event", false)
                );
                //persianCalendarView.update();
            }
        });

        persianCalendarView.setOnMonthChangedListener(new OnMonthChangedListener() {
            @Override
            public void onChanged(PersianDate date) {
                String pDate = "<    " + calendar.getMonthName(date) + "  " +
                        calendar.formatNumber(date.getYear()) + "    >";
                binding.textMonthYear.setText(pDate);
            }
        });

        TextView txtpDate = binding.textPersiandate;
        String pDate = calendar.getWeekDayName(today) + "  " +
                calendar.formatNumber(today.getDayOfMonth()) + "  " +
                calendar.getMonthName(today) + "  " +
                calendar.formatNumber(today.getYear());
        txtpDate.setText(pDate);
        pDate = "<    " + calendar.getMonthName(today) + "  " +
                calendar.formatNumber(today.getYear()) + "    >";
        binding.textMonthYear.setText(pDate);

        calendar.setHighlightOfficialEvents(false);
//        calendar.setColorBackground(getResources().getColor(android.R.color.holo_blue_dark));
        persianCalendarView.update();


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}