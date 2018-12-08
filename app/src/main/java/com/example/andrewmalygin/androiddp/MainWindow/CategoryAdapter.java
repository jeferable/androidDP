package com.example.andrewmalygin.androiddp.MainWindow;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.andrewmalygin.androiddp.R;
import com.example.andrewmalygin.androiddp.RESTApi.Category;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHandler>{

    private List<Category> categories;

    public CategoryAdapter(List<Category> categories){
        this.categories = categories;
    }

    @Override
    public CategoryAdapter.ViewHandler onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_category, viewGroup, false);

        return new CategoryAdapter.ViewHandler(view);
    }

    @Override
    public void onBindViewHolder(CategoryAdapter.ViewHandler handler, int i) {
        Category c = categories.get(i);
        handler.text.setText(c.getName());

    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public class ViewHandler extends RecyclerView.ViewHolder{

        TextView text;
        public ViewHandler(View view) {

            super(view);
            text = view.findViewById(R.id.text);
        }
    }
}
