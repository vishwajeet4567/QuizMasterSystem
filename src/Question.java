// Question.java
import java.util.ArrayList;
import java.util.List;

public class Question {
    private String questionText;
    private List<String> options;
    private int correctAnswer;
    private int timeLimit; // in seconds
    
    public Question(String questionText, List<String> options, int correctAnswer, int timeLimit) {
        this.questionText = questionText;
        this.options = new ArrayList<>(options);
        this.correctAnswer = correctAnswer;
        this.timeLimit = timeLimit;
    }
    
    public String getQuestionText() {
        return questionText;
    }
    
    public List<String> getOptions() {
        return new ArrayList<>(options);
    }
    
    public int getCorrectAnswer() {
        return correctAnswer;
    }
    
    public int getTimeLimit() {
        return timeLimit;
    }
    
    public boolean isCorrect(int answer) {
        return answer == correctAnswer;
    }
    
    public void display() {
        System.out.println("\n" + questionText);
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ". " + options.get(i));
        }
    }
}