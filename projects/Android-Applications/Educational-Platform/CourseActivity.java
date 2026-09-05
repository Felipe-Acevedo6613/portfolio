package com.example.cmaisonneuve;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentTransaction;

import com.example.cmaisonneuve.db.DatabaseHelper;

public class CourseActivity extends AppCompatActivity {

    private EditText courseNameText;
    private EditText sigleCourseText;
    private EditText teacherName;
    private EditText sessionText;
    private Button addCourseButton;
    private DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);

        courseNameText = findViewById(R.id.nomcourstext);
        sigleCourseText = findViewById(R.id.siglecourstext);
        teacherName = findViewById(R.id.enseignanttext);
        sessionText = findViewById(R.id.sessioncours);
        addCourseButton = findViewById(R.id.addcourse);
        db = new DatabaseHelper(this);

        addCourseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = courseNameText.getText().toString();
                String sigle = sigleCourseText.getText().toString();
                String teacher = teacherName.getText().toString();
                String session = sessionText.getText().toString();
                if(name.isEmpty() || sigle.isEmpty() || teacher.isEmpty() || session.isEmpty()){
                    Toast.makeText(getApplicationContext(), "SVP remplissez tous les champs", Toast.LENGTH_LONG).show();
                } else {
                    boolean success = db.insertCourses(new CourseItem(name,sigle,teacher,session));
                    if(success){
                        Toast.makeText(getApplicationContext(), "Cours ajoute avec success", Toast.LENGTH_LONG).show();
                        finish();
                    }else {
                        Toast.makeText(getApplicationContext(), "Erreur lors de l'insertion du cours...", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });


    }
}