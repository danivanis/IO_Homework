package ro.siit;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class CSVReaderApp {

    public static void main(String[] args) {
        String csvFile = "C:\\Users\\f6af91\\IdeaProjects\\IO_Homework\\csv_test.csv";
        BufferedReader bufferedReader = null;
        String line = "";
        String cvsSplitBy = ",";
        String timeSplit = ":";
        int lineNumber = 0;

        try {
            bufferedReader = new BufferedReader(new FileReader(csvFile));

            while ((line = bufferedReader.readLine()) != null) {
                if (lineNumber == 0) {
                    lineNumber++;
                    continue;
                }
                lineNumber++;
                String[] athleteData = line.split(cvsSplitBy);

                System.out.println("*******************************************");

                System.out.println("Athlete " + athleteData[1] + " with the number " + athleteData[0] +
                        ", from country " + athleteData[2] + " and has a ski time result of " + athleteData[3]);
                System.out.println("After shooting tryouts the results are as following:");


                String[] time = athleteData[3].split(timeSplit);

                System.out.println("Athlete " + athleteData[1] + " with the number " + athleteData[0] +
                        ", from country " + athleteData[2] + " has now a ski time result of " +
                        formatDuration(time[0], Integer.parseInt(time[1]) +
                                calculatePenaltyTime(athleteData[4] + athleteData[5] + athleteData[6])));
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

    public static Integer calculatePenaltyTime(String shootingResults) {
        char ch = 'o';
        Integer penalties = (int) (shootingResults.chars().filter(c -> c == ch).count());
        Integer totalPenaltyTime = penalties * 10;
        return totalPenaltyTime;
    }

    public static String formatDuration(String minValue, int secValue) {
        return String.format("%02d:%02d", (Integer.parseInt(minValue) + secValue / 60), secValue % 60);
    }
}
