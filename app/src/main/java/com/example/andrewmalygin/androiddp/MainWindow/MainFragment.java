package com.example.andrewmalygin.androiddp.MainWindow;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.andrewmalygin.androiddp.R;

public class MainFragment extends Fragment {

    private RecyclerView courses, category;
    private MainPresenter presenter;
    private View view;

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

        courses = view.findViewById(R.id.courses);
        category = view.findViewById(R.id.category);

        CategoryAdapter categoryAdapter = new CategoryAdapter(presenter.getCategories());
        CoursesAdapter coursesAdapter = new CoursesAdapter(presenter.getCourses());

        LinearLayoutManager categoryManager = new LinearLayoutManager(view.getContext());
        LinearLayoutManager coursesManager = new LinearLayoutManager(view.getContext());

        categoryManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        courses.setAdapter(coursesAdapter);
        category.setAdapter(categoryAdapter);

        courses.setLayoutManager(coursesManager);
        category.setLayoutManager(categoryManager);
    }

}
