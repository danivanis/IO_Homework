package ro.siit;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

public class CSVReaderApp {

    public static void main(String[] args) {
        String csvFile = "C:\\Users\\f6af91\\IdeaProjects\\IO_Homework\\csv_test.csv";
        BufferedReader bufferedReader = null;
        String line = "";
        String cvsSplitBy = ",";
        String timeSplit = ":";
        int lineNumber = 0;
        int seconds = 0;

        try {
            bufferedReader = new BufferedReader(new FileReader(csvFile));

            while ((line = bufferedReader.readLine()) != null) {
                if (lineNumber == 0) {
                    lineNumber++;
                    continue;
                }
                lineNumber++;
                String[] athleteData = line.split(cvsSplitBy);
//                System.out.println("Athlete " + athleteData[1] + " with the number " + athleteData[0] +
//                        " from country " + athleteData[2] + " and has a ski time result of " + athleteData[3]);

                String[] time = athleteData[3].split(timeSplit);

                System.out.println(time[0]);
            }

        } catch (FileNotFoundException e) {
            System.out.println("CSV not found");
        } catch (IOException e) {
            System.out.println("CSV is not accessible");
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    System.out.println("Something is wrong with the CSV");
                }
            }
        }
    }

}
