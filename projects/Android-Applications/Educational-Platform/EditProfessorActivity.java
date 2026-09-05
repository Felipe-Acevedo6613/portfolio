package com.example.cmaisonneuve;

import android.content.Intent;
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

import com.example.cmaisonneuve.db.DatabaseHelper;

public class EditProfessorActivity extends AppCompatActivity {

    private EditText firstNameText;
    private EditText lastNameText;
    private EditText email;
    private EditText department;
    private Button updateProfessorButton;
    private DatabaseHelper db;
    private int idProfessor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_professor);
        firstNameText = findViewById(R.id.updatefirstnametext);
        lastNameText = findViewById(R.id.updatelastname);
        email = findViewById(R.id.updateemail);
        department = findViewById(R.id.updatedepartment);
        updateProfessorButton = findViewById(R.id.updateProfessor);
        db = new DatabaseHelper(this);
        //Recevoir les donnees a partir de l intent
        Intent intent = getIntent();
        idProfessor = intent.getIntExtra("professor_id", -1);
        String firstName = intent.getStringExtra("professor_first_name");
        String lastName = intent.getStringExtra("course_Lart_name");
        String Semail = intent.getStringExtra("course_email");
        String Sdepartment = intent.getStringExtra("course_department");

        // Afficher les donnees dans les champs de texte
        firstNameText.setText(firstName);
        lastNameText.setText(lastName);
        email.setText(Semail);
        department.setText(Sdepartment);

        updateProfessorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String updatedProfessorFirstName = firstNameText.getText().toString();
                String updatedProfessorLastName =lastNameText.getText().toString();
                String updatedProfessorEmail = email.getText().toString();
                String updatedProfessorDepartment = department.getText().toString();
                if(updatedProfessorFirstName.isEmpty() || updatedProfessorLastName.isEmpty() || updatedProfessorEmail.isEmpty() || updatedProfessorDepartment.isEmpty() ){
                    Toast.makeText(EditProfessorActivity.this, "Remplisser tous les champs",Toast.LENGTH_LONG).show();
                } else {
                    boolean isUpdated = db.updateProfessor(new ProfessorItem(idProfessor, updatedProfessorFirstName, updatedProfessorLastName, updatedProfessorEmail, updatedProfessorDepartment));
                    if(isUpdated){
                        Toast.makeText(EditProfessorActivity.this, "Mise a jour success",Toast.LENGTH_LONG).show();
                        setResult(RESULT_OK);
                        finish();
                    } else {
                        Toast.makeText(EditProfessorActivity.this, "Erreur lors de la mise a jour",Toast.LENGTH_LONG).show();

                    }

                }
            }

        });


    }
}