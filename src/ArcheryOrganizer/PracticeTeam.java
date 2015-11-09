package ArcheryOrganizer;

/**
 * Created by Zheryu on 11/7/2015.
 */
public class PracticeTeam implements Team {
   /*private int size;
    protected Set<Competitor> members;

    public Team(double multiplierFactor, Set<Competitor> members){
        this.multiplierFactor = multiplierFactor;
        this.size = 0;
        rawTotalScore = 0;
        this.members = new HashSet<>(members);
    }

    public Team(double multiplierFactor){
        this(multiplierFactor, null);
    }

    public Team(){
        this(1, null);
    }

    public void addMember(Competitor member){
        if(!isFull())members.add(member);
    }

    public Set<Competitor> getMembers(){
        return members;
    }

    public double getNetScore(){
        return rawTotalScore*multiplierFactor;
    }

    public boolean isFull(){
        return members.size() == size;
    }

    public String toString(){
        String retString = "{ ";
        for(Competitor t : members){
            retString += t.toString() + "; ";
        }
        return retString + "|| Weighted Score: " + Double.toString(getNetScore()) + " }";
    }

    public double calculateRelativeScore(Competitor c){
        return c.getScore();
    }*/



}
