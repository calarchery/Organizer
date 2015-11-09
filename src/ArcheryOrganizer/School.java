package ArcheryOrganizer;

import java.util.HashMap;

/**
 * Created by Zheryu on 11/4/2015.
 */
public class School {
    private String school;

    private static HashMap<String, School> schoolHashMap = new HashMap<>();

    private School(String school){
        this.school = school;
    }

    public static School getSchool(String schoolName){
        schoolName = schoolName.toLowerCase();
        School returnSchool = schoolHashMap.get(schoolName);
        if (returnSchool == null) {
            returnSchool = new School(schoolName);
            schoolHashMap.put(schoolName, returnSchool);
        }
        return returnSchool;
    }

    public String toString() {
        return school;
    }
}
