/**
 * Created by Zheryu on 11/4/2015.
 */
import ArcheryOrganizer.CalStanfordCompetitor;
import ArcheryOrganizer.CalStanfordTeam;
import ArcheryOrganizer.School;
import ArcheryOrganizer.TeamBuilder;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;


public class Main {
    public static void main(String[] args) {
        run();

    }

    public static void run() {

        String csvFile = "C://Users/Zheryu/Desktop/Cal Stanford Results 2015 - Sheet1 (1).csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        Set<CalStanfordCompetitor> competitors = new HashSet<>();
        try {

            br = new BufferedReader(new FileReader(csvFile));

            while ((line = br.readLine()) != null) {
                String[] archer = line.split(cvsSplitBy);
                competitors.add(new CalStanfordCompetitor(archer[0], archer[1], Double.parseDouble(archer[2]), School.getSchool(archer[3].toLowerCase()), (archer[4].toLowerCase().equals("advanced"))));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        TeamBuilder tb = new TeamBuilder();
        Set<CalStanfordTeam> teams = tb.buildBalancedCalStanfordTeams(competitors);
        for(CalStanfordTeam team : teams){
            System.out.println(team);
        }
    }

}
