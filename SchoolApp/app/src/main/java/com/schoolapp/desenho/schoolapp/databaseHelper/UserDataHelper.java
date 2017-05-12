/* This class serves as a facade (Design Pattern) for handling student data and its complex
   database manipulation, if needed.

   @class UserDataHelper
 */

package com.schoolapp.desenho.schoolapp.databaseHelper;

import android.content.Context;
import android.support.annotation.RestrictTo;
import android.util.Log;

import com.schoolapp.desenho.schoolapp.dao.DisciplineDAO;
import com.schoolapp.desenho.schoolapp.dao.StudentDAO;
import com.schoolapp.desenho.schoolapp.models.Discipline;
import com.schoolapp.desenho.schoolapp.models.DisciplineClass;
import com.schoolapp.desenho.schoolapp.models.Exam;
import com.schoolapp.desenho.schoolapp.models.Monitory;
import com.schoolapp.desenho.schoolapp.models.SchoolClass;
import com.schoolapp.desenho.schoolapp.models.Student;
import com.schoolapp.desenho.schoolapp.models.StudentPresence;
import com.schoolapp.desenho.schoolapp.models.Task;

import java.util.ArrayList;

public class UserDataHelper {
    private StudentDAO userDB;
    private DisciplineDAO diciplineDB;

    public UserDataHelper(Context context){
        this.setUserDB(new StudentDAO(context));
        this.setDiciplineDB(new DisciplineDAO(context));
    }

    /* This method is used to check if the user is already in the database. If not, an empty student
     * is created and saved to DB.
     *
     * An example of usage is in the SplashScreen, to make sure that there's an user before any
     * data manipulation.
     */
    public void setStudent(){
        // Get student form DB and checks if there is any user(Student) already in the DB
        final Student studentFound = this.getUserInstance();
        final Boolean studentAvailable = studentFound != null;

        /* If the user is available in the DB, there's nothing to do. If not, a new empty student
         * must be created and saved to the DB.
         */
        if(studentAvailable){
            Log.d("User Check: ", "User is already in DB...");
        } else{
            Log.d("User Check: ", "FAILED. Creating empty User");

            final Student newStudent = this.createEmptyStudent();

            this.saveStudentInstance(newStudent);
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

        // If the DAO is ready, the condition will try to get the student available in the DB.
        if(isStudentDAOAvailable){
            foundStudent = this.getUserDB().getDefaultStudent();
        } else
        {
            Log.e("UserData: ", "NULLPOINTER found! Could not access StudentDAO in getUserInstance.");
        }

        return foundStudent;
    }

    /* This method saves/updates the student data available in the DB. If there isn't a student
     * in the DB, the DAO "save" method will be used for creating a new student.
     *
     * @parms Student user; Just pass the new student you want to push to the DB and the function
     *               will handle it.
     */
    public void saveStudentInstance(Student user){
        // Checks if a student is already available in DB
        final Student studentFound = this.getUserInstance();

        // If there's a student, the method should update the user
        if (studentFound != null){
            this.getUserDB().updateStudent(user);
            Log.d("saveStudentInstance: ", "Updated with success!");
        } else{
            this.getUserDB().saveStudent(user);
            Log.d("saveStudentInstance: ", "Saved with success!");
        }
    }

    /* This method parse the presence data from the student in the DB for a more clean representation
     *
     * @return ArrayList<StudentPresence> presenceList; An ArrayList with all the presence data from
     *              the student in DB.
     */
    public ArrayList<StudentPresence> getPresenceList(){
        final Student user = this.getUserInstance();
        final ArrayList<ArrayList<SchoolClass>> studentClasses = user.getStudentSchoolClasses();
        ArrayList<StudentPresence> presenceList = new ArrayList<>();

        // Get array sizes
        final int classesSize = studentClasses.size();

        // Interate over all student classes
        for(int counter = 0; counter < classesSize; counter++){
            final ArrayList<SchoolClass> classEventsList = studentClasses.get(counter);
            String disciplineName = "";
            Integer missedClassesCount = 0;

            // Get list size and interate over each event of classes
            final int eventsSize = classEventsList.size();

            for(int eventsCounter = 0; eventsCounter < eventsSize; eventsCounter++){
                final SchoolClass classEvent = classEventsList.get(eventsCounter);

                missedClassesCount += classEvent.getAbsentClass();
            }

            // Create a Student Presence object and add to the returning array
            final StudentPresence presenceInfo = new StudentPresence(disciplineName,
                    missedClassesCount);

            presenceList.add(presenceInfo);

        }

        return presenceList;
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
                1,
                emptyName,
                emptyDisciplines,
                emptyClasses,
                emptySchoolClasses,
                emptyMonitories,
                emptyTasks,
                emptyExams
        );
    }

    // add missed class
    public void changeMissedClass (Integer qntd, String diciplineName) {

        Student student = this.getUserInstance();

        ArrayList<ArrayList<SchoolClass>> studentClasses = student.getStudentSchoolClasses();

        // Get array sizes
        final int classesSize = studentClasses.size();

        // Interate over all student classes
        for (int counter = 0; counter < classesSize; counter++) {

            final ArrayList<SchoolClass> classEventList = studentClasses.get(counter);
            final SchoolClass classEvent = classEventList.get(0);
            final Integer studentDisciplineId = classEvent.getDisciplineClassId();

            // Tu vai ter que pegar a disciplina no banco agora
            final Discipline foundDiscipline = this.getDiciplineDB().getDiscipline(studentDisciplineId);

            // Verifica se é vazio, tá?
            if (diciplineName != null){
                final Integer actualMisses = classEvent.getAbsentClass();
                student.getStudentSchoolClasses().get(counter).get(0).setAbsentClass(actualMisses + qntd);
                this.getUserDB().saveStudent(student);

            } else {
             // Nothing to do
            }

        }
    }

    // Public Getters and Setters
    private StudentDAO getUserDB() {
        return userDB;
    }

    private void setUserDB(StudentDAO userDB) {
        this.userDB = userDB;
    }

    private DisciplineDAO getDiciplineDB() {
        return diciplineDB;
    }

    private void setDiciplineDB(DisciplineDAO diciplineDB) {
        this.diciplineDB = diciplineDB;
    }
}
