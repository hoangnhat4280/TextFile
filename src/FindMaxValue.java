
import java.util.List;

public class FindMaxValue {
    public static int findMax(List<Integer> numbers) {
        if (numbers.isEmpty()) {
            throw new IllegalArgumentException("Danh sách không có số nào.");
        }

        int max = numbers.getFirst();
        for (int i = 1; i < numbers.size(); i++) {
            if (max < numbers.get(i)) {
                max = numbers.get(i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
        List<Integer> numbers = readAndWriteFile.readFile("numbers.txt");

        if (!numbers.isEmpty()) {
            int maxValue = findMax(numbers);
            readAndWriteFile.writeFile("result.txt", maxValue);
        } else {
            System.err.println("Không có số nào để tìm giá trị lớn nhất.");
        }
    }
}
