package com.example.andrewmalygin.androiddp.MyCourseWindow;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.andrewmalygin.androiddp.R;

public class MyCoursesFragment extends Fragment {

    private View view;

    private void init(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = LayoutInflater.from(container.getContext()).inflate(R.layout.activity_mycourses, container, false);

        init();

        return view;
    }
}
