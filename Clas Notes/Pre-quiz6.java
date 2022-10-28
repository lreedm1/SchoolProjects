
 import java.util.ArrayList;
 public class tester {
 public static ArrayList<Integer> generateSequence(int n, int diff){
    ArrayList<Integer> numbers = new ArrayList<Integer>();
    if(n <= 0)
      return numbers;
    numbers.addAll(generateSequence(n-diff, diff));
    numbers.add(n);
    return numbers;
  }

// Run the program and see what happens.

  ArrayList<Integer> sequence = generateSequence(20, 5);
  for(int i = 0; i < sequence.size(); i++) {
    System.out.print(sequence.get(i) + " ");
    }


