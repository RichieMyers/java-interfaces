package exam;

import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;

public class MathQuiz {

    public static void main(String[] args) throws IOException {

        // Open the binary file for reading
        RandomAccessFile file = new RandomAccessFile("math.dat", "r");

        // Create an ArrayList to hold all types of math problems
        ArrayList<MathProblem> problems = new ArrayList<>();

        try {
            // Keep reading until we hit end of file
            while (true) {
                // Read how many numbers to expect
                int opCount = file.readInt();

                // Read the operands
                ArrayList<Integer> operands = new ArrayList<>();
                for (int i = 0; i < opCount; i++) {
                    operands.add(file.readInt());
                }

                // Read the operation type (e.g., "sum", "-", "*", etc.)
                String operation = file.readUTF();

                // Based on the operator, create the right MathProblem object
                if (operation.equals("sum")) {
                    problems.add(new SumProblem(operands));
                } else if (operation.equals("-")) {
                    // Use only the first two operands for subtraction
                    problems.add(new SubtractionProblem(operands.get(0), operands.get(1)));
                }
                // Optional placeholders for future types
                else if (operation.equals("*")) {
                    // problems.add(new MultiplicationProblem(operands));
                } else if (operation.equals("/")) {
                    // problems.add(new DivisionProblem(operands));
                }
            }
        } catch (EOFException e) {
            // End of file reached, nothing more to read
        }

        // Close the file
        file.close();

        // Scanner for student input
        Scanner kb = new Scanner(System.in);

        // Quiz the student
        for (MathProblem prob : problems) {
            System.out.println(prob.showProblem()); // Show the problem

            // Get user input
            int userAnswer = kb.nextInt();

            // Check and print result
            if (prob.checkAnswer(userAnswer)) {
                System.out.println("Correct!");
            } else {
                System.out.println("Incorrect, the answer is: " + prob.getAnswer());
            }
        }

        // Close the scanner
        kb.close();
    }
}
