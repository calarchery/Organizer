package ArcheryOrganizer;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Zheryu on 11/7/2015.
 */
public class CalStanfordTeam implements Team {
    public static int MAX_MEMBERS = 3;
    private int numCal;
    private int numStanford;
    private double totalScore;
    private Set<CalStanfordCompetitor> members;
    private CalStanfordCompetitor advancedMember;

    public CalStanfordTeam(){
        this.members = new HashSet<CalStanfordCompetitor>();
        numCal = 0;
        numStanford = 0;
        advancedMember = null;
    }

    public CalStanfordTeam(Set<CalStanfordCompetitor> members){
        this.members = members;
        numCal = 0;
        numStanford = 0;
        advancedMember = null;
        for(CalStanfordCompetitor csc : members){
            if(csc.isAdvanced())advancedMember = csc; //TODO: throw exception if there is already an advanced member
        }
    }

    public boolean canAdd(CalStanfordCompetitor member){
        if(members.size() < MAX_MEMBERS){
            if(     (numCal == 2 && member.getSchool().equals(School.getSchool("Berkeley"))) ||
                    (numStanford == 2 && member.getSchool().equals(School.getSchool("Stanford"))) ||
                    (member.isAdvanced() && advancedMember != null)){
                return false;
            }else{
                return true;
            }
        }else{
            return false;
        }
    }

    public void addMember(CalStanfordCompetitor member){
        if(canAdd(member)){
            forceAddMember(member);
        }
    }

    public void forceAddMember(CalStanfordCompetitor member){
        members.add(member);
        if(advancedMember == null && member.isAdvanced()){
            advancedMember = member;
        }
        if(member.getSchool().equals(School.getSchool("stanford"))){
            numStanford++;
        }else if( member.getSchool().equals(School.getSchool("berkeley"))){
            numCal++;
        }
    }

    public double getNetScore(){
        double totalScore = 0;
        for(CalStanfordCompetitor csc : members){
            totalScore += csc.getScore();
        }
        return totalScore;
    }

    public void removeMember(CalStanfordCompetitor csc){
        members.remove(csc);
    }

    public String toString(){
        String retString = "{ ";
        for(CalStanfordCompetitor c : members){
            retString += c.toString() + "; ";
        }
        return retString + "|| Total Score: " + Double.toString(getNetScore()) + " }";
    }
}
