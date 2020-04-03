package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import model.Quiz;
import model.QuizResult;
import view.Main;

public class StudentFeedbackController {

    @FXML
    private Label feedbackLabel;
    @FXML
    private ListView<QuizResult> feedbackList;

    public void setup(Quiz quiz) {}

    public void doMenu() {
        // Ga naar welkomscherm
        Main.getSceneManager().showManageUserScene();
    }
}

