/* This class serves as a facade (Design Pattern) for handling complex database manipulation,
   focusing on the user data.

   @class UserDataHelper
 */

package com.schoolapp.desenho.schoolapp.databaseHelper;

import android.content.Context;
import android.util.Log;

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
    private StudentDAO userDB;

    public UserDataHelper(Context context){
        this.setUserDB(new StudentDAO(context));
    }

    public void setStudent(Context context){
        // Get student form DB and checks if there is any user(Student) already in the DB
        Student user = this.getUserInstance();
        final Boolean userAvailable = user != null;

        if(userAvailable){
            Log.d("User Check: ", "User is ready.");
        } else{
            Log.d("User Check: ", "FAILED. Creating empty User");

            user = this.createEmptyStudent();
            this.getUserDB().saveStudent(user);
        }
    }

    /* This method can be used to get an instance of a user from the database. It also validates
     *  if the student can be found in a DAO.
     *
     * @return Student object found
     */
    public Student getUserInstance(){
        Student foundStudent = null;
        final StudentDAO studentDAO= this.getUserDB();

        final Boolean isStudentDAOAvailable = studentDAO != null;

        if(isStudentDAOAvailable){
            foundStudent = this.getUserDB().getDefaultStudent();
        } else
        {
            Log.e("UserData: ", "Can't resolve user data in DB.");
        }

        return foundStudent;
    }

    /* This function is responsible for creating an empty student if needed
     *
     * @return Student object. All its data is empty
     */
    private Student createEmptyStudent(){
        // Creating all needed parameters - Final because they won't change in this function
        final String emptyName = "Sem Nome";
        final ArrayList<Discipline> emptyDisciplines = new ArrayList<>();
        final ArrayList<DisciplineClass> emptyClasses = new ArrayList<>();
        final ArrayList<ArrayList<SchoolClass>> emptySchoolClasses =
                new ArrayList<>();
        final ArrayList<ArrayList<Monitory>> emptyMonitories = new ArrayList<>();
        final ArrayList<ArrayList<Task>> emptyTasks= new ArrayList<>();
        final ArrayList<ArrayList<Exam>> emptyExams= new ArrayList<>();

        // Returns the new student
        return new Student(
                emptyName,
                emptyDisciplines,
                emptyClasses,
                emptySchoolClasses,
                emptyMonitories,
                emptyTasks,
                emptyExams
        );
    }

    // Public Getters and Setters
    private StudentDAO getUserDB() {
        return userDB;
    }

    private void setUserDB(StudentDAO userDB) {
        this.userDB = userDB;
    }
}
