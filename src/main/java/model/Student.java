package model;

import javafx.scene.control.MenuItem;
import view.Main;

import java.util.ArrayList;

public class Student extends User {
    public Student(int userId, String userName, String password, String role) {
        super(userId, userName, password, role);
    }

    public Student(){
        this(DEFAULT_USER_ID, DEFAULT_USERNAME, DEFAULT_PASSWORD, DEFAULT_ROLE);
    }

    //De dingen die een student kan doen komen hier
    @Override
    public ArrayList<MenuItem> getMenuItems() {
        ArrayList<MenuItem> menuItems = new ArrayList<>();

        MenuItem menuItem1 = new MenuItem("Inschrijven/uitschrijven cursus");
        menuItem1.setOnAction(actionEvent -> Main.getSceneManager().showStudentSignInOutScene());
        menuItems.add(menuItem1);

        MenuItem menuItem2 = new MenuItem("Selecteer quiz");
        menuItem2.setOnAction(actionEvent -> Main.getSceneManager().showSelectQuizForStudent());
        menuItems.add(menuItem2);

        return menuItems;
    }
}
