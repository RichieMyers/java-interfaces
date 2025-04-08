package exam;

import java.util.ArrayList;

// This class implements the MathProblem interface.
// That means it must include the methods: showProblem(), getAnswer(), and checkAnswer().
public class SumProblem implements MathProblem {

    // An ArrayList to hold the numbers we want to add together.
    // ArrayList<Integer> uses generics — it can only hold Integer objects.
    private ArrayList<Integer> nums;

    // Constructor: accepts a list of numbers when creating the object.
    public SumProblem(ArrayList<Integer> nums) {
        this.nums = nums;
    }

    // Returns a string version of the math problem, like "3 + 5 + 2"
    @Override
    public String showProblem() {
        StringBuilder sb = new StringBuilder(); // Used to build the problem string

        for (int i = 0; i < nums.size(); i++) {
            sb.append(nums.get(i)); // Add the number to the string

            // If it's not the last number, add a plus sign
            if (i < nums.size() - 1) {
                sb.append(" + ");
            }
        }

        return sb.toString();
    }

    // Calculates and returns the correct answer (the sum of all numbers)
    @Override
    public int getAnswer() {
        int sum = 0;

        // Add each number in the list to the sum
        for (int num : nums) {
            sum += num;
        }

        return sum;
    }

    // Checks if the given answer is correct
    @Override
    public boolean checkAnswer(int answer) {
        // Just compare the given answer to the actual answer
        return answer == getAnswer();
    }
}
