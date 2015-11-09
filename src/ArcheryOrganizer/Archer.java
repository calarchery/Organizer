package ArcheryOrganizer;

/**
 * Created by Zheryu on 11/7/2015.
 */
public class Archer implements Comparable{
    protected double score;
    protected String firstName;
    protected String lastName;

    public Archer(String firstName, String lastName) {
        this(firstName, lastName, 0);
    }

    public Archer(String firstName, String lastName, double score) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.score = score;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }


    /**
     * adds the input score to the total score.
     * @param score the score to be added. Useful for updating archers after secondary scoring round of smt
     */
    public void addScore(double score){
        this.score += score;
    }

    public String toString() {
        return firstName + " " + lastName + " [" + Double.toString(score) + "]";
    }

    /**
     * @param o the compare to object
     * @return
     */
    @Override
    public int compareTo(Object o) {
        if(o instanceof Archer){
            Archer c = (Archer) o;
            return new Double(this.score).compareTo(new Double(c.score));
        }else{
            return 0;
        }
    }
}
