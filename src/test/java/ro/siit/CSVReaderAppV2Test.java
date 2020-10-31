package ro.siit;

import junit.framework.TestCase;
import org.junit.Test;

import java.io.*;

public class CSVReaderAppV2Test extends TestCase {

    @Test
    public void testGetFile(){
        String csvFile = "file location goes here";
        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(new FileReader(csvFile));

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

    @Test
    public void testCommaSplit() {
        String line = "11,Umar Jorgson,SK,30:27,xxxox,xxxxx,xxoxo";
        String[] athleteData = line.split(",");
        assertEquals(athleteData[0], "11");
        assertEquals(athleteData[1], "Umar Jorgson");
        assertEquals(athleteData[2], "SK");
        assertEquals(athleteData[3], "30:27");
        assertEquals(athleteData[4], "xxxox");
        assertEquals(athleteData[5], "xxxxx");
        assertEquals(athleteData[6], "xxoxo");
    }

    public void testCalculatePenaltyTime() {
        String shootingResults = "xxoox,xooxo,xxxxo";
        char ch = 'o';
        Integer penalties = (int) (shootingResults.chars().filter(c -> c == ch).count());
        Integer totalPenaltyTime = penalties * 10;
        assertTrue(totalPenaltyTime == 60);
    }

    @Test
    public void testFormatDuration() {

        String minValue = "29";
        int secValue = 80;
        assertEquals(String.format("%02d:%02d", (Integer.parseInt(minValue) + secValue / 60), secValue % 60),"30:20");
    }

}