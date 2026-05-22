import java.util.Scanner;
import java.util.*;

public class Student{
    private static final int GradeA = 90;
    private static final int GradeB = 80;
    private static final int GradeC = 70;
    private static final int GradeD = 60;
    private static final int MIN_Mark = 0;
    private static final int MAX_Mark = 100;

    private final Scanner scanner;


    public Student() {
        this.scanner = new Scanner(System.in);
    }
    public static void main(String[] args){
        displayWelcomeBanner();
        Student calculator = new Student();
        calculator.run();
        displayFarewellMessage();
    }
    public void run(){
        boolean calculateAgain;
        do {
            processStudentGrades();
            calculateAgain = askToCalculateAgain();
        }while(calculateAgain);
        scanner.close();
    }
    private void processStudentGrades(){
        int numSubjects = getNumberOfSubjects();
        int totalMarks = collectMarks(numSubjects);
        double averagePercentage = calculateAverage(totalMarks, numSubjects);
        char grade = determineGrade(averagePercentage);
        displayResult(totalMarks, numSubjects, averagePercentage, grade);

    }
    private int getNumberOfSubjects(){
        while(true){
            try{
                System.out.println("Enter subject number: ");
                int numSubjects = scanner.nextInt();
                if(numSubjects <= 0){
                    System.out.println("Invalid input. Please try again It must be greater than 0.");
                    continue;
                }
                return numSubjects;
            }catch(InputMismatchException e){
                System.out.println("Invalid input. Please try again It must be greater than 0.");
                scanner.next();
            }
        }
    }
    private int collectMarks(int numSubjects){
        int totalMarks = 0;
        System.out.println("Enter marks for subjects (0 : 100): ");

        for(int i = 1; i <= numSubjects; i++){
            int mark = getValidatedMark(i);
            totalMarks += mark;
        }
        return totalMarks;
    }
    private int getValidatedMark(int subjectNumber){
        while(true){
            try{
                System.out.println("Enter mark number for subject " + subjectNumber + ": ");
                int mark = scanner.nextInt();
                if(mark < MIN_Mark || mark > MAX_Mark){
                    System.out.printf("Mark must be between %d and %d.%n ", MIN_Mark, MAX_Mark);
                    continue;
                }
                return mark;
            }catch(InputMismatchException e){
                System.out.println("Invalid input. Please try again It must be between 0 and 100.");
                scanner.next();
            }
        }
    }
    private double calculateAverage(int totalMarks, int numSubjects){
        return ((double)totalMarks / numSubjects);
    }
    private char determineGrade(double percentage){
        if(percentage >= GradeA ){
            return 'A';
        }
        else if(percentage >= GradeB ){
            return 'B';
        }
        else if(percentage >= GradeC ){
            return 'C';
        }
        else if(percentage >= GradeD ){
            return 'D';
        }else{
            return 'F';
        }
    }
    private void displayResult(int totalMarks, int numSubjects, double averagePercentage, char grade) {
        System.out.println("Student Grade Report: ");
        System.out.printf("Total Subjects: %d%n", numSubjects);
        System.out.printf("Total Marks: %d / %d%n", totalMarks, numSubjects* MAX_Mark);
        System.out.printf("Average Percentage: %.2f%n", averagePercentage);
        System.out.print("Grade: ");
        displayGradeWithStyle(grade);
        displayPerformanceMessage(grade);

    }
    private void displayGradeWithStyle(char grade)
    {
        switch (grade) {
            case 'A':
                System.out.println("A");
                break;
            case 'B':
                System.out.println("B");
                break;
            case 'C':
                System.out.println("C");
                break;
            case 'D':
                System.out.println("D");
                break;
            case 'F':
                System.out.println("F");
                break;
        }
    }
    private void displayPerformanceMessage(char grade) {
        System.out.println();
        if(grade == 'A'){
            System.out.println("You are a TOP Performer!");
        }else if(grade == 'B'){
            System.out.println("YGreat Job ,Keep it up!");
        }else if(grade == 'C'){
            System.out.println("Good job! Aim for higher next time.");
        }else if(grade == 'D'){
            System.out.println("Satisfactory! More effort needed.");
        }else{
            System.out.println("Need Improvement!");
        }
    }
    private boolean askToCalculateAgain(){
        System.out.println("Are you sure you want to calculate again? (y/n)");
        String answer = scanner.next().toLowerCase();
        return answer.equals("y") || answer.equals("yes");
    }
    private static String repeatString(String string, int times){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < times; i++){
            sb.append(string);
        }
        return sb.toString();
    }
    private static void displayWelcomeBanner(){
        System.out.println("STUDENT GRADE CALCULATOR");
        System.out.println("Instructions:");
        System.out.println("• Enter the number of subjects");
        System.out.println("• Enter marks for each subject (0-100)");
        System.out.println("• Get total marks, average percentage, and grade");
        System.out.println("• Grades: A(90+), B(80-89), C(70-79), D(60-69), F(<60)");
    }
    private static void displayFarewellMessage(){

    }
}