# QuizMasterSystem
 features:
Project Structure
3 Main Classes:

Question.java - Encapsulates question data
QuizManager.java - Manages quiz flow and scoring
QuizApplication.java - Main entry point with menu system

Key Features Implemented
✅ Java Collections Used:

ArrayList for dynamic question storage
HashMap for category management
LinkedHashMap for maintaining result order
List interface for flexibility

✅ OOP Concepts:

Encapsulation - Private fields with getters
Abstraction - Clean interfaces between classes
Modularity - Separated concerns (Question, Manager, App)
Scalability - Easy to add new categories/questions

✅ Timer-based Quiz:

Configurable time limit per question
Auto-submission on timeout
Uses ExecutorService and Future for non-blocking input

✅ Features:

Multiple quiz categories
Score tracking and percentage calculation
Grade assignment (A+, A, B, C, F)
Question-wise result display
Reset functionality for retaking quizzes

How to Run

Save all three files in the same directory
Compile: javac *.java
Run: java QuizApplication
# Quiz Master System

A console-based quiz application built with Java featuring timer-based questions, multiple categories, and automatic score evaluation.

## Features

- ⏱️ Timer-based questions with auto-submission
- 📚 Multiple quiz categories (Java, OOP, Data Structures)
- 📊 Automatic score calculation and grading
- 🎯 Question-wise result tracking
- 🔄 Reusable quiz framework

## Technologies Used

- Java
- Java Collections Framework (ArrayList, HashMap, LinkedHashMap)
- Object-Oriented Programming principles
- Concurrent programming (ExecutorService, Future)

## How to Run

1. Clone the repository:
```bash
   git clone https://github.com/yourusername/QuizMasterSystem.git
```

2. Navigate to project directory:
```bash
   cd QuizMasterSystem
```

3. Compile the Java files:
```bash
   javac src/*.java
```

4. Run the application:
```bash
   java -cp src QuizApplication
```

## Project Structure
```
QuizMasterSystem/
├── src/
│   ├── Question.java          # Question model class
│   ├── QuizManager.java       # Quiz management and logic
│   └── QuizApplication.java   # Main application entry point
├── .gitignore
└── README.md
```

## OOP Concepts Demonstrated

- **Encapsulation**: Private fields with public getters
- **Modularity**: Separated concerns across classes
- **Abstraction**: Clean interfaces for quiz operations
- **Scalability**: Easy to extend with new categories

## Adding New Questions
```java
quiz.addQuestion(new Question(
    "Your question text?",
    Arrays.asList("Option1", "Option2", "Option3", "Option4"),
    correctAnswerIndex, // 1-4
    timeInSeconds
));
```

## Future Enhancements

- [ ] Database integration for question storage
- [ ] User authentication and profiles
- [ ] Leaderboard system
- [ ] Difficulty levels
- [ ] Random question ordering

## Author

Your Name

## License

MIT License
