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

public class ProfessorActivity extends AppCompatActivity {

    private EditText firstNameText;
    private EditText lastNameText;
    private EditText email;
    private EditText department;
    private Button addCourseButton;
    private DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_professor);

        firstNameText = findViewById(R.id.firstnametext);
        lastNameText = findViewById(R.id.lastname);
        email = findViewById(R.id.email);
        department = findViewById(R.id.department);
        addCourseButton = findViewById(R.id.addcourse);
        db = new DatabaseHelper(this);

        addCourseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = firstNameText.getText().toString();
                String sigle = lastNameText.getText().toString();
                String teacher = email.getText().toString();
                String session = department.getText().toString();
                if(name.isEmpty() || sigle.isEmpty() || teacher.isEmpty() || session.isEmpty()){
                    Toast.makeText(getApplicationContext(), "SVP remplissez tous les champs", Toast.LENGTH_LONG).show();
                } else {
                    boolean success = db.insertCourses(new CourseItem(name,sigle,teacher,session));
                    if(success){
                        Toast.makeText(getApplicationContext(), "Professor ajoute avec success", Toast.LENGTH_LONG).show();
                        finish();
                    }else {
                        Toast.makeText(getApplicationContext(), "Erreur lors de l'insertion du professor...", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });


    }
}