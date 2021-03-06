package model;

import java.util.ArrayList;
import java.util.Objects;

public class Question {
    final static public int DEFAULT_VRAAG = -1;

    private int questionId;
    private String question;
    private ArrayList<Answer> answers;
    private Quiz quiz;
    private Answer correctAnswer;

    public Question() {
        questionId = DEFAULT_VRAAG;
    }

    public Question(String question) {
        this.question = question;
        answers = new ArrayList<>();
    }

    public Question(String question, Quiz quiz) {
        this.question = question;
        this.quiz = quiz;
    }


    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question1 = (Question) o;
        return questionId == question1.questionId &&
                question.equals(question1.question);
    }

    @Override
    public int hashCode() {
        return Objects.hash(questionId, question, answers, quiz, correctAnswer);
    }

    public void setCorrectAnswer(Answer correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public Question(int questionId, String question) {
        this.questionId = questionId;
        this.question = question;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getQuestionId() {
        return questionId;
    }


    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }



    public String getQuestion() {
        return question;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void voegAntwoordAanVraag(Answer answer){
        answers.add(answer);
    }

    public ArrayList<Answer> getAnswers() {
        return answers;
    }

    @Override
    public String toString() {

      return question;
    }

    public Answer getCorrectAnswer() {
        return correctAnswer;
    }
}
