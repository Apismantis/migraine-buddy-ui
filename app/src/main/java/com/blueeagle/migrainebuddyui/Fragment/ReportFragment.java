package com.blueeagle.migrainebuddyui.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.blueeagle.migrainebuddyui.Adapter.EmptyReportAdapter;
import com.blueeagle.migrainebuddyui.Adapter.EmptyReportItem;
import com.blueeagle.migrainebuddyui.R;

import java.util.ArrayList;
import java.util.List;

public class ReportFragment extends Fragment {
    private Context mContext;
    private View rootLayout;
    private RecyclerView rcvReports;

    public ReportFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mContext = getActivity();
        rootLayout = inflater.inflate(R.layout.fragment_report, container, false);

        // Init rcvReports
        rcvReports = (RecyclerView) rootLayout.findViewById(R.id.rcvReports);
        rcvReports.setHasFixedSize(true);
        rcvReports.setLayoutManager(new LinearLayoutManager(mContext));
        rcvReports.setAdapter(new EmptyReportAdapter(getReportItems()));

        return rootLayout;
    }

    private List<EmptyReportItem> getReportItems() {
        List<EmptyReportItem> reportItems = new ArrayList<>();

        reportItems.add(new EmptyReportItem("When happened?",
                "Let's discover this very simple pattern. Click on the (?) sign. This will unlock in 3 more migraine records.",
                R.drawable.when_section_bar,
                R.drawable.img_locked_time));

        reportItems.add(new EmptyReportItem("Paint Intensity",
                "How much pain are you feeling? This will unlock in 2 more migraine records.",
                R.drawable.pain_intensity_section_bar,
                R.drawable.img_locked_pain_intensity));

        reportItems.add(new EmptyReportItem("Sleep",
                "Could your sleep be contributing to your migraine? This will unlock in 2 more migraine records.",
                R.drawable.sleep_section_bar,
                R.drawable.img_locked_sleep));

        reportItems.add(new EmptyReportItem("Triggers",
                "What triggers did you suspect most at the time of the migraine? This will unlock in 4 more migraine records.",
                R.drawable.triggers_section_bar,
                R.drawable.img_locked_triggers));

        reportItems.add(new EmptyReportItem("Likely Triggers",
                "What triggers could be causing your migraine? This will reveal after 10 days of use of &quot;DAILY TRACKER&quot; associated to 3 records Track more days in &quot;Daily Tracker&quot; to generate this report.",
                R.drawable.triggers_section_bar,
                R.drawable.img_locked_likely_triggers));

        reportItems.add(new EmptyReportItem("Unlikely Triggers",
                "Maybe you will discover other triggers? This will reveal after 10 days of use of &quot;DAILY TRACKER&quot; associated to 3 records Track more days in &quot;Daily Tracker&quot; to generate this report.",
                R.drawable.triggers_section_bar,
                R.drawable.img_locked_unlikely_triggers));

        reportItems.add(new EmptyReportItem("Symptoms",
                "Your symptoms help in describing your migraine pattern. This will unlock in 4 migraine records.",
                R.drawable.symptoms_section_bar,
                R.drawable.img_locked_symptoms));

        reportItems.add(new EmptyReportItem("Frequent Start Positions",
                "Where the pain starts is key in diagnosing a migraine. This will unlock in 6 migraine records.",
                R.drawable.when_section_bar,
                R.drawable.img_locked_frequent_start));

        reportItems.add(new EmptyReportItem("Menstruation",
                "Let's see if your hormonal cycles are one of your key triggers. This will unlock in 2 migraine records.",
                R.drawable.menstrual_section_bar,
                R.drawable.img_locked_menstruation));

        reportItems.add(new EmptyReportItem("Compare Relief Methods",
                "Not all relief combinations are made equal. This will unlock in 9 migraine records.",
                R.drawable.compare_section_bar,
                R.drawable.img_locked_relief_methods_report));

        return reportItems;
    }


}
