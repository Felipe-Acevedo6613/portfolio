package com.example.cmaisonneuve;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cmaisonneuve.db.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;

public class ListCoursFragment extends Fragment {
    private RecyclerView recyclerView;
    private CourseAdapter courseAdapter;
    List<CourseItem> courseItemList;
    private DatabaseHelper db;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_cours, container, false);
        // initialiser notre recyclerview
        recyclerView = view.findViewById(R.id.recyclerview);
        // Initialiser la liste des cours
        courseItemList = new ArrayList<>();
       db = new DatabaseHelper(getActivity());

        // Configurer notre adapter
        courseAdapter = new CourseAdapter(courseItemList, course ->{
            // Demarrer l activite EditCourse
            Intent intent = new Intent(getActivity(), EditCourseActivity.class);
            intent.putExtra("course_id",course.getId());
            intent.putExtra("course_name",course.getCourseName());
            intent.putExtra("course_sigle",course.getSigle());
            intent.putExtra("course_teacher",course.getTeacherName());
            intent.putExtra("course_session",course.getSession());

            // Utiliser le ActivityResultLauncher de MainActivity
            ((MainActivity) getActivity()).getEditCourseLauncher().launch(intent);
        });

        // recuperer tous les cours de la base de donnees...
        loadCoursesFromDatabase();

        //Configurer notre LayoutManager
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        // Ajouter la barre de division entre les éléments pour les separer
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), linearLayoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
        // attacher l adapter a notre recyclerview
        recyclerView.setAdapter(courseAdapter);
        return view;
    }

    public void loadCoursesFromDatabase(){

        //vider la liste avant de recharger notre liste pour eviter des doublons
        courseItemList.clear();

        Cursor cursor = db.getAllCourses();

        if (cursor.getCount() ==0){
            Toast.makeText(getActivity(), "Aucun cours trouve..", Toast.LENGTH_LONG).show();
        } else{
            while (cursor.moveToNext()){
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                String sigle = cursor.getString(2);
                String teacher = cursor.getString(3);
                String session = cursor.getString(4);
                courseItemList.add(new CourseItem(id,name,sigle,teacher,session));
            }
            //Notifier l adapter que les donnees ont changes..
            courseAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        loadCoursesFromDatabase();
    }
}
