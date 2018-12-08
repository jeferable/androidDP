package com.example.andrewmalygin.androiddp.MainWindow;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.andrewmalygin.androiddp.R;
import com.example.andrewmalygin.androiddp.RESTApi.Course;

import java.util.List;

public class CoursesAdapter extends RecyclerView.Adapter<CoursesAdapter.ViewHolder>{

    private List<Course> courses;
    private MainFragment f;

    public CoursesAdapter(MainFragment f, List<Course> courses)
    {
        this.courses = courses;
        this.f = f;
    }

    @Override
    public CoursesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_courses, viewGroup, false);
        return new CoursesAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CoursesAdapter.ViewHolder holder, int i) {
        Course c = courses.get(i);
        holder.title.setText(c.getName());
        holder.description.setText(c.getDescription());
        Glide.with(f).load(c.getCourseimg()).into(holder.logo);
    }

    @Override
    public int getItemCount() {
        return courses.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView title, description;
        Button about;
        ImageView logo;
        View v;

        public ViewHolder(View view) {
            super(view);
            v = view;
            title = view.findViewById(R.id.title);
            description = view.findViewById(R.id.description);
            about = view.findViewById(R.id.about);
            logo = view.findViewById(R.id.logo);

            about.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            f.courseClick();
        }
    }
}
