package com.example.andrewmalygin.androiddp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.andrewmalygin.androiddp.RESTApi.Course;

import java.util.List;

public class CoursesAdapter extends RecyclerView.Adapter<CoursesAdapter.ViewHandler>{

    private List<Course> courses;

    public CoursesAdapter(List<Course> courses){
        this.courses = courses;
    }

    @Override
    public ViewHandler onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_courses, viewGroup, false);

        return new CoursesAdapter.ViewHandler(view);
    }

    @Override
    public void onBindViewHolder(ViewHandler handler, int i) {
        //Course c = courses.get(i);
        handler.text.setText("kek" + i);
    }

    @Override
    public int getItemCount() {
        return courses.size();
    }

    public class ViewHandler extends RecyclerView.ViewHolder{

        TextView text;
        public ViewHandler(View view) {

            super(view);
            text = view.findViewById(R.id.text);
        }
    }
}
