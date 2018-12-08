package com.example.andrewmalygin.androiddp.MainWindow;

import com.example.andrewmalygin.androiddp.Main;
import com.example.andrewmalygin.androiddp.RESTApi.Category;
import com.example.andrewmalygin.androiddp.RESTApi.CategoryRepository;
import com.example.andrewmalygin.androiddp.RESTApi.Course;
import com.example.andrewmalygin.androiddp.RESTApi.OnCategoryRepositoryChange;

import java.util.ArrayList;
import java.util.List;

public class MainPresenter {

    private List<Course> courses;
    private List<Category> categories;
    private MainFragment activity;
    private CategoryRepository categoryRepository;

    public MainPresenter(final MainFragment activity){
        this.activity = activity;

        courses = new ArrayList<>();

        for(int i = 0; i < 10; i++){
            courses.add(new Course());
        }

        categories = new ArrayList<>();

        /*for(int i = 0; i < 10; i++){
            categories.add(new Category());
        }*/

        categoryRepository = new CategoryRepository(Main.getApi());

        categoryRepository.setOnCategoryRepositoryChange(new OnCategoryRepositoryChange() {
            @Override
            public void categotyLoaded(List<Category> list) {
                categories.clear();
                categories.addAll(list);
                activity.updateCategotyList();
            }
        });

        categoryRepository.loadCategory();
    }

    public List<Course> getCourses(){
        return courses;
    }

    public List<Category> getCategories(){
        return categories;
    }

    public void loadCategoty(){ categoryRepository.loadCategory();}
}
