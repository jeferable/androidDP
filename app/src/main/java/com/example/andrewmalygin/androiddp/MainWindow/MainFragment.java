package com.example.andrewmalygin.androiddp.MainWindow;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.andrewmalygin.androiddp.R;

public class MainFragment extends Fragment {

    private RecyclerView courses;
    private MainPresenter presenter;
    private View view;

    private CoursesAdapter coursesAdapter;
    private OnMainFragmentChanged onMainFragmentChanged;
    private ProgressBar progressBar;

    public void setOnMainFragmentChanged(OnMainFragmentChanged onMainFragmentChanged) {
        this.onMainFragmentChanged = onMainFragmentChanged;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = LayoutInflater.from(container.getContext()).inflate(R.layout.activity_main, container, false);
        view = v;
        init();

        return view;
    }

    private void init(){

        presenter = new MainPresenter(this);

        progressBar = view.findViewById(R.id.progressBar);

        courses = view.findViewById(R.id.courses);

        coursesAdapter = new CoursesAdapter(this, presenter.getCourses());

        LinearLayoutManager coursesManager = new LinearLayoutManager(view.getContext());


        courses.setAdapter(coursesAdapter);

        courses.setLayoutManager(coursesManager);
        showProgress();
    }

    public void showProgress(){
        progressBar.setVisibility(View.VISIBLE);
        courses.setVisibility(View.INVISIBLE);
    }

    public void hideProgress(){
        progressBar.setVisibility(View.INVISIBLE);
        courses.setVisibility(View.VISIBLE);
    }

    public void courseClick(){ onMainFragmentChanged.onCourseClick(); }

    public void updateCourseList(){
        coursesAdapter.notifyDataSetChanged();
    }

}
