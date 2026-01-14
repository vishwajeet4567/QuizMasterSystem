// QuizApplication.java
import java.util.*;

public class QuizApplication {
    private static Map<String, QuizManager> quizCategories = new HashMap<>();
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        initializeQuizzes();
        
        System.out.println("╔════════════════════════════════════╗");
        System.out.println("║   WELCOME TO QUIZ MASTER SYSTEM    ║");
        System.out.println("╚════════════════════════════════════╝");
        
        while (true) {
            displayMenu();
            System.out.print("\nEnter your choice: ");
            
            int choice = getValidChoice(scanner);
            
            switch (choice) {
                case 1:
                    selectAndStartQuiz(scanner);
                    break;
                case 2:
                    viewCategories();
                    break;
                case 3:
                    System.out.println("\nThank you for using Quiz Master! Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
    
    private static void displayMenu() {
        System.out.println("\n======== MAIN MENU ========");
        System.out.println("1. Start Quiz");
        System.out.println("2. View Categories");
        System.out.println("3. Exit");
        System.out.println("===========================");
    }
    
    private static int getValidChoice(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.print("Invalid input! Enter a number: ");
        }
        return scanner.nextInt();
    }
    
    private static void selectAndStartQuiz(Scanner scanner) {
        System.out.println("\n===== SELECT CATEGORY =====");
        List<String> categories = new ArrayList<>(quizCategories.keySet());
        
        for (int i = 0; i < categories.size(); i++) {
            System.out.println((i + 1) + ". " + categories.get(i));
        }
        
        System.out.print("\nSelect category (1-" + categories.size() + "): ");
        int choice = getValidChoice(scanner);
        
        if (choice > 0 && choice <= categories.size()) {
            String selectedCategory = categories.get(choice - 1);
            QuizManager quiz = quizCategories.get(selectedCategory);
            quiz.reset();
            quiz.startQuiz();
        } else {
            System.out.println("Invalid category selection!");
        }
    }
    
    private static void viewCategories() {
        System.out.println("\n===== AVAILABLE CATEGORIES =====");
        for (String category : quizCategories.keySet()) {
            System.out.println("• " + category);
        }
        System.out.println("================================");
    }
    
    private static void initializeQuizzes() {
        // Java Quiz
        QuizManager javaQuiz = new QuizManager();
        javaQuiz.addQuestion(new Question(
            "What is the size of int in Java?",
            Arrays.asList("16 bits", "32 bits", "64 bits", "8 bits"),
            2, 15
        ));
        javaQuiz.addQuestion(new Question(
            "Which keyword is used for inheritance in Java?",
            Arrays.asList("implements", "extends", "inherits", "super"),
            2, 15
        ));
        javaQuiz.addQuestion(new Question(
            "Which collection allows duplicate elements?",
            Arrays.asList("Set", "Map", "List", "None"),
            3, 20
        ));
        javaQuiz.addQuestion(new Question(
            "What is the parent class of all classes in Java?",
            Arrays.asList("System", "Object", "Class", "Parent"),
            2, 15
        ));
        quizCategories.put("Java Programming", javaQuiz);
        
        // OOP Quiz
        QuizManager oopQuiz = new QuizManager();
        oopQuiz.addQuestion(new Question(
            "Which OOP principle hides implementation details?",
            Arrays.asList("Inheritance", "Polymorphism", "Encapsulation", "Abstraction"),
            3, 20
        ));
        oopQuiz.addQuestion(new Question(
            "What is method overriding?",
            Arrays.asList("Same name, different class", "Same name, same parameters", 
                          "Different name, same class", "None"),
            1, 20
        ));
        oopQuiz.addQuestion(new Question(
            "Which allows multiple forms of a method?",
            Arrays.asList("Abstraction", "Polymorphism", "Encapsulation", "Inheritance"),
            2, 15
        ));
        quizCategories.put("Object-Oriented Programming", oopQuiz);
        
        // Data Structures Quiz
        QuizManager dsQuiz = new QuizManager();
        dsQuiz.addQuestion(new Question(
            "What is the time complexity of ArrayList get() operation?",
            Arrays.asList("O(n)", "O(1)", "O(log n)", "O(n²)"),
            2, 20
        ));
        dsQuiz.addQuestion(new Question(
            "Which data structure uses LIFO principle?",
            Arrays.asList("Queue", "Stack", "List", "Tree"),
            2, 15
        ));
        dsQuiz.addQuestion(new Question(
            "HashMap allows how many null keys?",
            Arrays.asList("Zero", "One", "Multiple", "Unlimited"),
            2, 20
        ));
        quizCategories.put("Data Structures", dsQuiz);
    }
}