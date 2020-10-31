package ro.siit;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;

public class CSVReaderAppTest extends TestCase {

    @Test
    public void testCommaSplit(){
        String line = "11,Umar Jorgson,SK,30:27,xxxox,xxxxx,xxoxo";
        int seconds = 0;
        String[] athleteData = line.split(",");
//        assertEquals(athleteData[1], "Umar Jorgson");
        assertEquals(athleteData[3].format("%02d:%02d", (seconds % 60)),27 );


    }


}