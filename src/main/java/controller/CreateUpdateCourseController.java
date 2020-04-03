package controller;

import database.mysql.CourseDAO;
import database.mysql.DBAccess;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.Course;
import view.Main;

import java.util.ArrayList;


public class CreateUpdateCourseController {

    private Course course; //Een cursusobject
    private ArrayList<Course> courseList = new ArrayList<>(); //Lijst met dummy-cursussen

    //Verwijzingen naar de invulvelden en knoppen in de View
    @FXML
    private TextField CursusnummerTextField;

    @FXML
    private TextField CursusnaamTextField;

    @FXML
    private TextField CoordinatornummerTextField;

    //maakt de cursus aan met doCreateCourse-methode
    @FXML
    private Button CursusAanmakenKnop;

    //gaat terug naar cursusbeheer
    @FXML
    private Button NaarCursusbeheerKnop;

    //gaat naar groepenbeheer
    @FXML
    private Button NaarGroepenbeheerKnop;


    //Testgegevens met verzonnen cursussen om aan te maken in de db
    /*public void createCourseList(){
        courseList.add(new Course(1, "BasisCursus", 5));
        courseList.add(new Course(2, "GevorderdenCursus", 5));
        courseList.add(new Course(3, "ExpertCursus", 5));
    }*/

    //Methode voor het prepareren van de pagina en het checken van de user-gegevens en velden
    public void setup(Course course) {

    }

    //Gaat terug naar het keuzemenu van de administrator
    public void doMenu() {
        Main.getSceneManager().showWelcomeScene();
    }

    //Gaat naar het Cursusbeheerscherm
    public void manageCourses(){
            Main.getSceneManager().showManageCoursesScene();
        }

    //Maak een cursus aan in de db, en later, pas een cursus aan in de db
    @FXML
    public void doCreateUpdateCourse(ActionEvent actionEvent) {
        String cursusNaam = CursusnaamTextField.getText();
        int coordinatorId = Integer.parseInt(CoordinatornummerTextField.getText());
        Course course = new Course(cursusNaam, coordinatorId);
        DBAccess dbAccess = new DBAccess(DBAccess.getDatabaseName(), DBAccess.getMainUser(), DBAccess.getMainUserPassword()); //toegang tot db
        dbAccess.openConnection(); //connectie openen
        CourseDAO courseDAO = new CourseDAO(dbAccess); //CursusDAO instantieren
        if (course != null){
            courseDAO.storeOne(course);
        } else
            System.out.println("Geen cursus aangemaakt");
        dbAccess.closeConnection(); //connectie sluiten
    }

}
