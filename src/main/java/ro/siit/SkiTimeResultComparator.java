package ro.siit;

import java.util.Comparator;

public class SkiTimeResultComparator implements Comparator<Athlete> {

    public int compare(Athlete a1, Athlete a2){
        return a1.getSkiTimeResult().compareTo(a2.getSkiTimeResult());
    }
}
