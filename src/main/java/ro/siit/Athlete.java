package ro.siit;

import java.util.Objects;

public class Athlete {

    private String athleteName;
    private String skiTimeResult;
    private int athleteNumber;
    private String countryCode;
    private String firstShootingRange;
    private String secondShootingRange;
    private String thirdShootingRange;

    public Athlete (String athleteName, String skiTimeResult){
        athleteName = this.athleteName;
        skiTimeResult = this.skiTimeResult;
    }

    public Athlete (int athleteNumber, String athleteName, String countryCode, String skiTimeResult,
                    String firstShootingRange, String secondShootingRange, String thirdShootingRange){
        athleteNumber = this.athleteNumber;
        athleteName = this.athleteName;
        countryCode = this.countryCode;
        skiTimeResult = this.skiTimeResult;
        firstShootingRange = this.firstShootingRange;
        secondShootingRange = this.secondShootingRange;
        thirdShootingRange = this.thirdShootingRange;

    }

    public void setAthleteNumber(int athleteNumber) {
        this.athleteNumber = athleteNumber;
    }

    public int getAthleteNumber() {
        return athleteNumber;
    }

    public void setAthleteName(String athleteName) {
        this.athleteName = athleteName;
    }

    public String getAthleteName() {
        return athleteName;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setSkiTimeResult(String skiTimeResult) {
        this.skiTimeResult = skiTimeResult;
    }

    public String getSkiTimeResult() {
        return skiTimeResult;
    }

    public void setFirstShootingRange(String firstShootingRange) {
        this.firstShootingRange = firstShootingRange;
    }

    public String getFirstShootingRange() {
        return firstShootingRange;
    }

    public void setSecondShootingRange(String secondShootingRange) {
        this.secondShootingRange = secondShootingRange;
    }

    public String getSecondShootingRange() {
        return secondShootingRange;
    }

    public void setThirdShootingRange(String thirdShootingRange) {
        this.thirdShootingRange = thirdShootingRange;
    }

    public String getThirdShootingRange() {
        return thirdShootingRange;
    }

    @Override
    public boolean equals(Object a){
        if (this == a) return true;
        if (a == null || getClass() != getClass()) return false;
        Athlete athlete = (Athlete) a;
        return athleteName.equals(athlete.athleteName) && skiTimeResult.equals(athlete.skiTimeResult);
    }

    @Override
    public int hashCode() {
        return Objects.hash(athleteName, skiTimeResult);
    }

    @Override
    public String toString(){
        return "Athlete " + athleteName + " with the number " + athleteNumber +
                        ", from country " + countryCode + " and has a ski time result of " + skiTimeResult;
    }

}
