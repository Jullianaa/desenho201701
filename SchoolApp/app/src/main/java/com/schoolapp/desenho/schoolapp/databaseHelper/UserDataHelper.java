/** This class serves as a facade (Design Pattern) for handling complex database manipulation,
 *  focusing on the user data.
 *
 *  @class UserDataHelper
 */

package com.schoolapp.desenho.schoolapp.databaseHelper;

import android.content.Context;

import com.schoolapp.desenho.schoolapp.R;
import com.schoolapp.desenho.schoolapp.dao.StudentDAO;
import com.schoolapp.desenho.schoolapp.models.Discipline;
import com.schoolapp.desenho.schoolapp.models.DisciplineClass;
import com.schoolapp.desenho.schoolapp.models.Exam;
import com.schoolapp.desenho.schoolapp.models.Monitory;
import com.schoolapp.desenho.schoolapp.models.SchoolClass;
import com.schoolapp.desenho.schoolapp.models.Student;
import com.schoolapp.desenho.schoolapp.models.Task;

import java.util.ArrayList;

public class UserDataHelper {
    // Keep in mind that there is no way to get user id yet
    private Integer actualUserId;
    private StudentDAO userDB;

    public UserDataHelper(Context context){
        this.setUserDB(new StudentDAO(context));
        this.setActualUserId(new Integer(0));
    }

    public void checkStudent(Context context){
        // Checks if there is any user(Student) already in the DB
        Student user = this.getUserDB().getFirstStudent();
        Boolean userAvailable = user != null;

        if(userAvailable){
            // Nothing to do
        } else{
            user = this.createEmptyStudent();
            this.getUserDB().saveStudent(user);
        }
    }

    public Student getUser(Context context){
        Student foundStudent = null;

        return foundStudent;
    }

    private Student createEmptyStudent(){
        // Creating all needed parameters - Final because they won't change in this function
        final String emptyName = "Sem Nome";
        final ArrayList<Discipline> emptyDisciplines = new ArrayList<Discipline>();
        final ArrayList<DisciplineClass> emptyClasses = new ArrayList<DisciplineClass>();
        final ArrayList<ArrayList<SchoolClass>> emptySchoolClasses =
                new  ArrayList<ArrayList<SchoolClass>>();
        final ArrayList<ArrayList<Monitory>> emptyMonitories = new ArrayList<ArrayList<Monitory>>();
        final ArrayList<ArrayList<Task>> emptyTasks= new ArrayList<ArrayList<Task>>();
        final ArrayList<ArrayList<Exam>> emptyExams= new ArrayList<ArrayList<Exam>>();

        // Creating the new student
        final Student newStudent = new Student(
                emptyName,
                emptyDisciplines,
                emptyClasses,
                emptySchoolClasses,
                emptyMonitories,
                emptyTasks,
                emptyExams
        );

        return newStudent;
    }

    // Public Getters and Setters
    public Integer getActualUserId() {
        return actualUserId;
    }

    public void setActualUserId(Integer actualUserId) {
        this.actualUserId = actualUserId;
    }

    public StudentDAO getUserDB() {
        return userDB;
    }

    public void setUserDB(StudentDAO userDB) {
        this.userDB = userDB;
    }
}
