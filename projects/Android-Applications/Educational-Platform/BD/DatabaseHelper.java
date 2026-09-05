package com.example.cmaisonneuve.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.cmaisonneuve.CourseItem;
import com.example.cmaisonneuve.ProfessorItem;
import com.example.cmaisonneuve.User;

public class DatabaseHelper  extends SQLiteOpenHelper {

    // nom et version de la base de donnees
    private static final String DATABASE_NAME = "school.db";
    private static final int DATABASE_VERSION = 1;

    // tables
    private static final String TABLE_USERS = "users";
    private static final String TABLE_COURSES = "courses";
    private static final String TABLE_PROFESSORS = "courses";

    //colonne utilisateur
    private static final String COLUMN_USER_ID = "id";
    private static final String COLUMN_USER_FULL_NAME = "fullname";
    private static final String COLUMN_USERNAME = "username";
    private static final String COLUMN_USER_PASSWORD = "password";

    // colonne cours
    private static final String COLUMN_COURSES_ID= "id";
    private static final String COLUMN_COURSES_NAME= "name";
    private static final String COLUMN_COURSES_SIGLE= "sigle";
    private static final String COLUMN_COURSES_TEACHER= "teacher";
    private static final String COLUMN_COURSES_SESSION= "session";

    // colonne professor
    private static final String COLUMN_PROFESSOR_ID = "id";
    private static final String COLUMN_PROFFESOR_FIRST_NAME = "firs name";
    private static final String COLUMN_PROFFESOR_LAST_NAME = "last name";
    private static final String COLUMN_PROFESSOR_EMAIL = "email";
    private static final String COLUMN_PROFFESOR_DEPARTMENT = "departament";



    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USERS + "("
                + COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_USER_FULL_NAME + " TEXT,"
                + COLUMN_USERNAME + " TEXT,"
                + COLUMN_USER_PASSWORD + " TEXT" +")";

        String CREATE_TABLE_PROFESSORS = "CREATE TABLE " + TABLE_PROFESSORS + "("
                + COLUMN_PROFESSOR_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_PROFFESOR_FIRST_NAME + " TEXT,"
                + COLUMN_PROFFESOR_LAST_NAME + " TEXT,"
                + COLUMN_PROFESSOR_EMAIL + " TEXT,"
                + COLUMN_PROFFESOR_DEPARTMENT + " TEXT" + ")";

        String CREATE_USER_COURSES = "CREATE TABLE " + TABLE_COURSES + "("
                + COLUMN_COURSES_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_COURSES_NAME + " TEXT,"
                + COLUMN_COURSES_SIGLE + " TEXT,"
                + COLUMN_COURSES_TEACHER + " TEXT,"
                + COLUMN_COURSES_SESSION + " TEXT" +")";

        sqLiteDatabase.execSQL(CREATE_USER_TABLE);
        sqLiteDatabase.execSQL(CREATE_TABLE_PROFESSORS);
        sqLiteDatabase.execSQL(CREATE_USER_COURSES);
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_COURSES);
        onCreate(sqLiteDatabase);
    }


    public boolean insertUser(User user){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_USER_FULL_NAME, user.getFullname());
        contentValues.put(COLUMN_USERNAME, user.getUsername());
        contentValues.put(COLUMN_USER_PASSWORD, user.getPassword());
        long result =  db.insert(TABLE_USERS, null, contentValues);
        return  result !=-1;  // retourne true si l'enregistrement a ete fait avec sucess
    }

    public  boolean checkUser(User user){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_USERS + " WHERE " + COLUMN_USERNAME + "=? AND " + COLUMN_USER_PASSWORD + "=?",new String[]{user.getUsername(), user.getPassword()});
       return cursor.getCount() > 0;
    }

    public boolean insertCourses(CourseItem courseItem){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_COURSES_NAME, courseItem.getCourseName());
        contentValues.put(COLUMN_COURSES_SIGLE, courseItem.getSigle());
        contentValues.put(COLUMN_COURSES_TEACHER, courseItem.getTeacherName());
        contentValues.put(COLUMN_COURSES_SESSION, courseItem.getSession());
        long result =  db.insert(TABLE_COURSES, null, contentValues);
        return  result !=-1;  // retourne true si l'enregistrement a ete fait avec sucess
    }

    public Cursor getAllCourses(){
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM "+ TABLE_COURSES, null);
    }

    public boolean updateCourse(CourseItem courseItem){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_COURSES_NAME, courseItem.getCourseName());
        contentValues.put(COLUMN_COURSES_SIGLE, courseItem.getSigle());
        contentValues.put(COLUMN_COURSES_TEACHER, courseItem.getTeacherName());
        contentValues.put(COLUMN_COURSES_SESSION, courseItem.getSession());
        long result =  db.update(TABLE_COURSES, contentValues, "id=?", new String[]{String.valueOf(courseItem.getId())});
        return  result > 0;  // retourne true si la mise a jour a ete fait
    }

    public boolean updateProfessor(ProfessorItem professorItem){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_PROFFESOR_FIRST_NAME, professorItem.getFirstName());
        contentValues.put(COLUMN_PROFFESOR_LAST_NAME, professorItem.getLastName());
        contentValues.put(COLUMN_PROFESSOR_EMAIL, professorItem.getEmail());
        contentValues.put(COLUMN_PROFFESOR_DEPARTMENT, professorItem.getDepartment());
        long result =  db.update(TABLE_PROFESSORS, contentValues, "id=?", new String[]{String.valueOf(professorItem.getId())});
        return  result > 0;  // retourne true si la mise a jour a ete fait
    }
}
