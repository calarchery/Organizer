package ArcheryOrganizer;

/**
 * Created by Zheryu on 11/7/2015.
 */
public class CalStanfordCompetitor extends Archer {
    private School school;
    private boolean isAdvanced;

    public CalStanfordCompetitor(String firstName, String lastName, double score, School school, boolean isAdvanced) {
        super(firstName, lastName, score);
        this.school = school;
        this.isAdvanced = isAdvanced;

    }

    public CalStanfordCompetitor(Archer archer, School school, boolean isAdvanced){
        this(archer.firstName, archer.lastName, archer.score, school, isAdvanced);
    }

    public boolean isAdvanced(){
        return isAdvanced;
    }

    public School getSchool(){
        return school;
    }

    public String toString() {
        return firstName + " " + lastName +  " (" + school.toString() + ")"+" [" + Double.toString(score) + "]";
    }
}
