package com.example.cmaisonneuve;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseViewHolder> {
   private List<CourseItem> courseList;
   private OnItemClickListener listener;


   public  interface  OnItemClickListener{
       void onItemClick(CourseItem courseItem);
   }
   public CourseAdapter(List<CourseItem> courseList, OnItemClickListener listener){
       this.courseList = courseList;
       this.listener = listener;
   }
     @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext())
               .inflate(R.layout.item_course, parent, false);
       return new CourseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseViewHolder holder, int position) {
       CourseItem courseItem = courseList.get(position);
      holder.textViewCourseName.setText(courseItem.getCourseName());
      holder.textViewSigle.setText(courseItem.getSigle());
      holder.textViewTeacherName.setText(courseItem.getTeacherName());

      // comment afficher un toast quand l utilisateur clique sur un element de la liste
      holder.bind(courseItem, listener);
    }

    @Override
    public int getItemCount() {
        return courseList.size();
    }
    public static class CourseViewHolder extends RecyclerView.ViewHolder {
        TextView textViewCourseName;
        TextView textViewSigle;
        TextView textViewTeacherName;
       public CourseViewHolder(@NonNull View itemView){
           super(itemView);
           textViewCourseName = itemView.findViewById(R.id.textView_course_name);
           textViewSigle = itemView.findViewById(R.id.sigleCourse);
           textViewTeacherName = itemView.findViewById(R.id.teacherText);

       }

       // Lier les donnees du cours au clic
       public void bind(final CourseItem courseItem, final  OnItemClickListener listener){
           textViewCourseName.setText(courseItem.getCourseName());
           textViewSigle.setText(courseItem.getSigle());
           textViewTeacherName.setText(courseItem.getTeacherName());

           // gerer le click sur un element
           itemView.setOnClickListener(v->listener.onItemClick(courseItem));


       }
    }
}
