package com.example.myself;

/*
TANGGAL PENGERJAAN : 29/05/2023
NIM                : 10120778
NAMA               : SYUKUR ALI NURZAKY
KELAS              : IF-9
 */

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ActivityFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ActivityFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ArrayList<DailyActivity> activityArrayList;
    private String[] activityName;
    private int[] imageResourceID;
    private RecyclerView recylerView;
    private String[] activityTime;

    public ActivityFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ActivityFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ActivityFragment newInstance(String param1, String param2) {
        ActivityFragment fragment = new ActivityFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_activity, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        dataInitialize();

        recylerView = view.findViewById(R.id.recycler);
        recylerView.setLayoutManager(new LinearLayoutManager((getContext())));
        recylerView.setHasFixedSize(true);

        DailyActivityAdapter dailyActivityAdapter = new DailyActivityAdapter(getContext(), activityArrayList);
        recylerView.setAdapter(dailyActivityAdapter);

        dailyActivityAdapter.notifyDataSetChanged();
    }

    private void dataInitialize() {
        activityArrayList = new ArrayList<>();

        activityName = new String[]{
            getString(R.string.title_1),
            getString(R.string.title_2),
            getString(R.string.title_3),
            getString(R.string.title_4),
            getString(R.string.title_5),
            getString(R.string.title_6),
            getString(R.string.title_7)
        };

        activityTime= new String[]{
                getString(R.string.time_a),
                getString(R.string.time_b),
                getString(R.string.time_c),
                getString(R.string.time_d),
                getString(R.string.time_e),
                getString(R.string.time_f),
                getString(R.string.time_g)
        };

        imageResourceID = new int[]{
          R.drawable.a,
          R.drawable.b,
          R.drawable.c,
          R.drawable.d,
                R.drawable.e,
                R.drawable.f,
                R.drawable.g
        };

        for(int i = 0; i < activityName.length; i++) {
            DailyActivity dailyActivity = new DailyActivity(activityName[i], activityTime[i], imageResourceID[i]);
            activityArrayList.add(dailyActivity);
        };
    }
}