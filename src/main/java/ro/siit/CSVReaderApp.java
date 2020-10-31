package ro.siit;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;


public class CSVReaderApp {

    public static void main(String[] args) {
        List<Athlete> athleteList = readDataFromCSVWithoutSorting("C:\\Users\\f6af91\\IdeaProjects\\IO_Homework\\csv_test.csv");

        // print all athletes found in the csv file without sorting
        for (Athlete athlete: athleteList){
            System.out.println(athlete);
        }

        athleteList = readDataFromCSVWithSorting("C:\\Users\\f6af91\\IdeaProjects\\IO_Homework\\csv_test.csv");

        // print all athletes found in the csv file with sorting
        for (Athlete athlete: athleteList){
            System.out.println(athlete);
        }
    }

    private static List<Athlete> readDataFromCSVWithoutSorting(String csvFileIn){
        List<Athlete> athleteList = new ArrayList<>();
        BufferedReader bufferedReader = null;
        String line;
        String cvsSplitBy = ",";

        // create an instance of BufferedReader using try with resource
        try { bufferedReader = new BufferedReader(new FileReader(csvFileIn));

            // loop until all lines are read
            while ((line = bufferedReader.readLine()) != null) {
                // skipping csv header row
                int lineNumber = 0;
                if (lineNumber == 0) {
                    lineNumber++;
                    continue;
                }
                lineNumber++;

                // load strings with values from each line of the csv file by using string.split
                // and a line delimiter (was declared outside of the loop to have more flexibility)
                String[] athleteData = line.split(cvsSplitBy);

                Athlete athlete = createAthlete(athleteData);

                // adding athlete into the ArrayList
                athleteList.add(athlete);
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
        return athleteList;
    }

    private static List<Athlete> readDataFromCSVWithSorting(String csvFileIn){
        List<Athlete> athleteList = new ArrayList<>();
        BufferedReader bufferedReader = null;
        String line;
        String cvsSplitBy = ",";

        // create an instance of BufferedReader using try with resource
        try { bufferedReader = new BufferedReader(new FileReader(csvFileIn));

            // loop until all lines are read
            while ((line = bufferedReader.readLine()) != null) {
                // skipping csv header row
                int lineNumber = 0;
                if (lineNumber == 0) {
                    lineNumber++;
                    continue;
                }
                lineNumber++;

                // load strings with values from each line of the csv file by using string.split
                // and a line delimiter (was declared outside of the loop to have more flexibility)
                String[] athleteData = line.split(cvsSplitBy);

                Athlete athleteSorted = createNewAthlete(athleteData);

                // adding athlete into the ArrayList
                athleteList.add(athleteSorted);
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
        return athleteList;
    }

    private static Athlete createNewAthlete(String[] athleteData){
        String athleteName = athleteData[1];
        String skiTimeResult = athleteData[3];

        // calculating the time penalty
        String[] time = athleteData[3].split(":");
        String minutes = time[0];
        String seconds = time[1];
        athleteData[3] = formatDuration(minutes, Integer.parseInt(seconds) +
                calculatePenaltyTime(athleteData[4]+athleteData[5]+athleteData[6]));

        // using the comparator to initiate the sorting
        Set<Athlete> newSkiTimeResult = new TreeSet<>(new SkiTimeResultComparator());
        newSkiTimeResult.add(new Athlete(athleteName, skiTimeResult));

        // create and return the athlete information
        for (Athlete athlete: newSkiTimeResult){
            System.out.println("Athlete " + athlete.getAthleteName() + " achieved a ski time result" +
                    " of :" + athlete.getSkiTimeResult());
        }

        return new Athlete(athleteName, skiTimeResult);
    }

    private static Athlete createAthlete(String[] athleteData){
        int athleteNumber = Integer.parseInt(athleteData[0]);
        String athleteName = athleteData[1];
        String countryCode = athleteData[2];
        String skiTimeResult = athleteData[3];
        String firstShootingRange = athleteData[4];
        String secondShootingRange = athleteData[5];
        String thirdShootingRange = athleteData[6];

        // create and return the athlete information
        return new Athlete(athleteNumber, athleteName, countryCode, skiTimeResult,
                firstShootingRange, secondShootingRange, thirdShootingRange);
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
