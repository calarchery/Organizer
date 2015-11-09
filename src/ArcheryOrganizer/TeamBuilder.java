package ArcheryOrganizer;

import java.util.*;

/**
 * Created by Zheryu on 11/4/2015.
 */
public class TeamBuilder {
    private Set<Archer> competitors;

    public TeamBuilder(){
        competitors = new HashSet<>();
    }

    private double getAverageScore(){
        double totalScore = 0;
        for(Archer competitor : competitors){
            totalScore += competitor.getScore();
        }
        return totalScore/competitors.size();
    }

    private double getAverageScore(Set<Archer> archers){
        double totalScore = 0;
        for(Archer archer : archers){
            totalScore += archer.getScore();
        }
        return totalScore/archers.size();
    }

    public void addArcher(Archer c){
        competitors.add(c);
    }

    public Set<CalStanfordTeam> buildBalancedCalStanfordTeams(Set<CalStanfordCompetitor> calStanfordCompetitors) {
        int numTeams = (int)Math.ceil(((double)calStanfordCompetitors.size())/CalStanfordTeam.MAX_MEMBERS);
        int numFullTeams = (calStanfordCompetitors.size() - calStanfordCompetitors.size()%numTeams)/CalStanfordTeam.MAX_MEMBERS;
        int numPartialTeams = numTeams - numFullTeams;
        Set<Archer> archerSet = new HashSet<Archer>(calStanfordCompetitors);
        double averageScore = getAverageScore(archerSet);
        Set<CalStanfordTeam> teams = new HashSet<CalStanfordTeam>();
        Map<CalStanfordTeam, Double> idealTotalScoreMap = new HashMap<CalStanfordTeam, Double>();
        for (int i = 0; i < numFullTeams; i++){
            CalStanfordTeam newTeam = new CalStanfordTeam();
            teams.add(newTeam);
            idealTotalScoreMap.put(newTeam, averageScore*CalStanfordTeam.MAX_MEMBERS);
        }
        for (int i = 0; i < numPartialTeams; i++){
            CalStanfordTeam newTeam = new CalStanfordTeam();
            teams.add(newTeam);
            idealTotalScoreMap.put(newTeam, averageScore * (CalStanfordTeam.MAX_MEMBERS - 1));
        }
        return greedyBuildCalStanfordTeams(teams, calStanfordCompetitors);

    }

    private Set<CalStanfordTeam> greedyBuildCalStanfordTeams(Set<CalStanfordTeam> teams, Set<CalStanfordCompetitor> competitors){
        ArrayList<CalStanfordTeam> teamList = new ArrayList<>();
        teamList.addAll(teams);
        while(!competitors.isEmpty()){
            for(CalStanfordTeam team : teamList){
                if(competitors.isEmpty())continue;
                CalStanfordCompetitor competitorToAdd = null;
                double highest = -1;
                for(CalStanfordCompetitor csc : competitors){
                    if(team.canAdd(csc) && csc.getScore() > highest){
                        highest = csc.getScore();
                        competitorToAdd = csc;
                    }
                }
                if(competitorToAdd == null){
                    for(CalStanfordCompetitor csc : competitors){
                        if(csc.getScore() > highest){
                            highest = csc.getScore();
                            competitorToAdd = csc;
                        }
                    }
                    if(competitorToAdd != null)                    team.forceAddMember(competitorToAdd);
                }else{
                    team.addMember(competitorToAdd);
                }
                competitors.remove(competitorToAdd);
            }
            Collections.reverse(teamList);
        }
        return new HashSet<CalStanfordTeam>(teamList);
    }
/*  this was supposed to improve the results but I got lazy and went to bed.
    private Set<CalStanfordTeam> hillClimbImproveCalStanfordTeams(Set<CalStanfordTeam> teams, Map<CalStanfordTeam, Double> idealTotalScoreMap){
        for(CalStanfordTeam team : teams){
            for(CalStanfordTeam otherTeam : teams){
                if(team == otherTeam)continue;

            }
        }

    }*/
/*
    public Set<Team> buildBalancedTeams(int teamSize) {
        int numTeams = (int)Math.ceil(((double)competitors.size())/teamSize);
        int numFullTeams = (competitors.size() - competitors.size()%numTeams)/teamSize;
        int numPartialTeams = numTeams - numFullTeams;
        double averageScore = getAverageScore();
        Set<Team<Archer>> teams = new HashSet<Team<Archer>>();
        Map<Team, Double> idealTotalScoreMap = new HashMap<Team, Double>();
        for (int i = 0; i < numFullTeams; i++){
            Team newTeam = new Team(1);
            teams.add(newTeam);
            idealTotalScoreMap.put(newTeam, averageScore*teamSize);
        }
        for (int i = 0; i < numPartialTeams; i++){
            Team newTeam = new Team(((double)teamSize)/(teamSize - 1));
            teams.add(newTeam);
            idealTotalScoreMap.put(newTeam, averageScore*teamSize);
        }
    }

    public Set<Team<Archer>> greedyBuildBalancedTeams(Set<Team<Archer>> teams, Map<Team, Integer> idealTotalScores){



        List<Team<Archer>> teams = new ArrayList<Team<Archer>>();

        for(int i = 0; i < numFullTeams; i++) teams.add(new Team<Archer>(teamSize));
        double partialTeamMultiplier = ((double)teamSize) / (teamSize - 1);
        for(int i = 0; i < numTeams - numFullTeams; i++) teams.add(new Team<Archer>(teamSize - 1, partialTeamMultiplier));

        boolean reverse = false;
        Set<Archer> competitorsClone = new HashSet<>(competitors);
        while(!competitorsClone.isEmpty()){
            if(reverse){

            }else{

            }
        }

    }

    private Set<Team<Archer>> hillClimbImproveTeams(Set<Team> teams){


    }*/

}
