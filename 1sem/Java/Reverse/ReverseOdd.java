import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReverseOdd {
	public static void main(String[] args) {
		Scanner lineScanner = new Scanner(System.in);
		List<int[]> lines = new ArrayList<>();
		while(lineScanner.hasNextLine()) {
			String intLine = lineScanner.nextLine();
			Scanner intScanner = new Scanner(intLine);
			int count = 0;
			int[] numbers = new int[0];
            while (intScanner.hasNextInt()) {
                int nextNumber = intScanner.nextInt();
                numbers = Arrays.copyOf(numbers, count + 1);
                numbers[count] = nextNumber;
                count++;
            }
			
			lines.add(numbers);
		}
		
		for (int i = lines.size() - 1; i >= 0; i--) {
            int[] line = lines.get(i);
            for (int j = line.length - 1; j >= 0; j--) {
                if (line[j] % 2 != 0) {
                    System.out.print(line[j] + " ");
                }
            }
            System.out.println();
        }
		lineScanner.close();
	}
}