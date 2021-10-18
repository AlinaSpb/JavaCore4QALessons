package lesson5;

import java.io.IOException;
import java.util.Arrays;

public class Lesson5 {
    public static void main(String[] args) {
        CsvData csvData = new CsvData();
        csvData.setHeaders(new String[]{
                "header1", "header2", "header3"
        });
        csvData.setData(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        });

        try {
            csvData.saveToFile("file1.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }

        CsvData csvFromFile = new CsvData();
        try {
            csvFromFile.loadFromFile("file1.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(Arrays.toString(csvFromFile.getHeaders()));
        for(int[] row : csvFromFile.getData()){
            System.out.println(Arrays.toString(row));
        }

    }
}
