package exam;

// This class implements the MathProblem interface
// It represents a simple subtraction problem: num1 - num2
public class SubtractionProblem implements MathProblem {

    // Two integer operands
    private int num1, num2;

    // Constructor: accepts two integers and assigns them
    public SubtractionProblem(int n1, int n2) {
        num1 = n1;
        num2 = n2;
    }

    // Returns the subtraction problem as a string, like "9 - 4"
    @Override
    public String showProblem() {
        return num1 + " - " + num2;
    }

    // Returns the correct answer (num1 minus num2)
    @Override
    public int getAnswer() {
        return num1 - num2;
    }

    // Checks if the provided answer is correct
    @Override
    public boolean checkAnswer(int answer) {
        return answer == getAnswer();
    }
}
