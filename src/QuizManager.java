// QuizManager.java
import java.util.*;
import java.util.concurrent.*;

public class QuizManager {
    private List<Question> questions;
    private int score;
    private int totalQuestions;
    private Map<Integer, Boolean> results;
    
    public QuizManager() {
        questions = new ArrayList<>();
        score = 0;
        totalQuestions = 0;
        results = new LinkedHashMap<>();
    }
    
    public void addQuestion(Question question) {
        questions.add(question);
        totalQuestions++;
    }
    
    public void addQuestions(List<Question> questionList) {
        questions.addAll(questionList);
        totalQuestions += questionList.size();
    }
    
    public void startQuiz() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("\n========== QUIZ STARTED ==========");
        System.out.println("Total Questions: " + totalQuestions);
        System.out.println("==================================\n");
        
        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            System.out.println("Question " + (i + 1) + "/" + totalQuestions);
            q.display();
            
            int answer = getTimedAnswer(scanner, q.getTimeLimit());
            
            if (answer == -1) {
                System.out.println("⏰ Time's up! Moving to next question...");
                results.put(i + 1, false);
            } else if (q.isCorrect(answer)) {
                System.out.println("✓ Correct!");
                score++;
                results.put(i + 1, true);
            } else {
                System.out.println("✗ Wrong! Correct answer: " + q.getCorrectAnswer());
                results.put(i + 1, false);
            }
            
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        displayResults();
    }
    
    private int getTimedAnswer(Scanner scanner, int timeLimit) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> future = executor.submit(() -> {
            System.out.print("\nYour answer (1-4) [" + timeLimit + "s]: ");
            while (!scanner.hasNextInt()) {
                scanner.next();
                System.out.print("Invalid input. Enter number (1-4): ");
            }
            return scanner.nextInt();
        });
        
        try {
            return future.get(timeLimit, TimeUnit.SECONDS);
        } catch (TimeoutException e) {
            future.cancel(true);
            return -1;
        } catch (Exception e) {
            return -1;
        } finally {
            executor.shutdownNow();
        }
    }
    
    private void displayResults() {
        System.out.println("\n========== QUIZ COMPLETED ==========");
        System.out.println("Your Score: " + score + "/" + totalQuestions);
        System.out.println("Percentage: " + String.format("%.2f", (score * 100.0 / totalQuestions)) + "%");
        
        System.out.println("\nQuestion-wise Results:");
        for (Map.Entry<Integer, Boolean> entry : results.entrySet()) {
            String status = entry.getValue() ? "✓ Correct" : "✗ Wrong";
            System.out.println("Q" + entry.getKey() + ": " + status);
        }
        
        System.out.println("\nGrade: " + calculateGrade());
        System.out.println("====================================\n");
    }
    
    private String calculateGrade() {
        double percentage = (score * 100.0 / totalQuestions);
        if (percentage >= 90) return "A+ Excellent!";
        else if (percentage >= 80) return "A Good Job!";
        else if (percentage >= 70) return "B Well Done!";
        else if (percentage >= 60) return "C Pass";
        else return "F Failed - Try Again!";
    }
    
    public void reset() {
        score = 0;
        results.clear();
    }
}