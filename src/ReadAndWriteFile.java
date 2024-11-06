import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteFile {

    public List<Integer> readFile(String filePath) {
        List<Integer> numbers = new ArrayList<>();
        try {
            File file = new File(filePath);

            if (!file.exists()) {
                throw new FileNotFoundException("File không tồn tại: " + filePath);
            }

            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                try {
                    numbers.add(Integer.parseInt(line.trim()));
                } catch (NumberFormatException e) {
                    System.err.println("Dòng không hợp lệ: " + line);
                }
            }
            br.close();
        } catch (IOException e) {
            System.err.println("Lỗi khi đọc file: " + e.getMessage());
        }
        return numbers;
    }

    public void writeFile(String filePath, int max) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath, true))) {
            bufferedWriter.write("Giá trị lớn nhất là: " + max);
            bufferedWriter.newLine();
        } catch (IOException e) {
            System.err.println("Lỗi khi ghi file: " + e.getMessage());
        }
    }
}
