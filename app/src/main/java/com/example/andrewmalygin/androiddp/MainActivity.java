package com.example.andrewmalygin.androiddp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView courses, category;
    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainPresenter(this);

        courses = findViewById(R.id.courses);
        category = findViewById(R.id.category);

        CoursesAdapter adapter = new CoursesAdapter(presenter.getCourses());

        courses.setAdapter(adapter);
    }



}
