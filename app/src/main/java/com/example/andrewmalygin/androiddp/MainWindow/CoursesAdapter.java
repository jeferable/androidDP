package com.example.andrewmalygin.androiddp.MainWindow;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.andrewmalygin.androiddp.R;
import com.example.andrewmalygin.androiddp.RESTApi.Course;

import java.util.List;

public class CoursesAdapter extends RecyclerView.Adapter<CoursesAdapter.ViewHolder>{

    private List<Course> courses;

    public CoursesAdapter(List<Course> courses){
        this.courses = courses;
    }

    @Override
    public CoursesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_courses, viewGroup, false);
        return new CoursesAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CoursesAdapter.ViewHolder holder, int i) {
        holder.title.setText("Title " + i);
    }

    @Override
    public int getItemCount() {
        return courses.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView title;


        public ViewHolder(View view) {
            super(view);

            title = view.findViewById(R.id.title);
        }
    }
}
