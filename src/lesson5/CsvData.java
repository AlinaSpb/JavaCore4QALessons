package lesson5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

public class CsvData {
    private String[] headers;
    private int[][] data;

    /**
     * Реализовать сохранение данных в csv файл;
     *
     * @param fileName - имя файла
     * @throws IOException
     */
    public void saveToFile(String fileName) throws IOException {
        String head = "";
        for (String h : headers) {
            head = head + ";" + h;
        }
        head = head.replaceFirst(";", "") + "\n";

        String dataString = "";
        for (int row = 0; row < data.length; row++) {
            String line = "";
            for (int col = 0; col < data[row].length; col++) {
                line = line + ";" + data[row][col];
            }
            line = line.replaceFirst(";", "") + "\n";
            dataString = dataString + line;
        }

        Path path = Paths.get(fileName);
        String allData = head + dataString;
        Files.write(path, allData.getBytes());
    }

    /**
     * Реализовать загрузку данных из csv файла. Файл читается целиком
     *
     * @param fileName - имя файла
     */
    public void loadFromFile(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        List<String> allData = Files.readAllLines(path);

        Iterator<String> str = allData.iterator();
        headers = str.next().split(";");
        data = new int[allData.size() - 1][headers.length];
        int row = 0;
        while (str.hasNext()) {
            String[] line = str.next().split(";");
            int[] v = new int[line.length];
            for (int i = 0; i < line.length; i++) {
                v[i] = Integer.valueOf(line[i]);
            }
            data[row] = v;
            row++;
        }
    }

    public String[] getHeaders() {
        return headers;
    }

    public void setHeaders(String[] headers) {
        this.headers = headers;
    }

    public int[][] getData() {
        return data;
    }

    public void setData(int[][] data) {
        this.data = data;
    }
}
