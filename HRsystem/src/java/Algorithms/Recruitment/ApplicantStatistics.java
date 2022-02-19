/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms.Recruitment;

import Entity.Recruitment.Applicant;
import static java.lang.Math.max;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author maria
 */
public class ApplicantStatistics {

    private List<Map<Object, Object>> genderCount = new ArrayList<Map<Object, Object>>();
    private List<Map<Object, Object>> genderScore = new ArrayList<Map<Object, Object>>();
    private List<Map<Object, Object>> skillsCount = new ArrayList<Map<Object, Object>>();
    private List<Map<Object, Object>> nAbove_nBelow = new ArrayList<Map<Object, Object>>();

    public ApplicantStatistics(ArrayList<Applicant> applicantsList,double threshold) {
        calculateGenderStat(applicantsList);
        calculateSkillsDistribution(applicantsList) ;
        calculateAboveBelow(applicantsList,  threshold);
        

    }

    private void calculateGenderStat(ArrayList<Applicant> applicants) {
        double nMen = 0, nWomen = 0;
        double menScore = 0, womenScore = 0;
        for (int i = 0; i < applicants.size(); i++) {

            if (applicants.get(i).getGender().equals("male")) {
                nMen++;
                menScore += applicants.get(i).getScore();

            } else if (applicants.get(i).getGender().equals("female")) {
                nWomen++;
                womenScore += applicants.get(i).getScore();

            }

        }
        nMen = nMen *100;
        nWomen = nWomen*100;
        Map<Object, Object> map = new HashMap<Object, Object>();
         Map<Object, Object> map2 = new HashMap<Object, Object>();
          Map<Object, Object> map3 = new HashMap<Object, Object>();
           Map<Object, Object> map4 = new HashMap<Object, Object>();
        map.put("label", "Men Count Ratio");
        map.put("y", nMen / max(1,applicants.size()));
        genderCount.add(map);
       

        map2.put("label", "Women Count Ratio");
        map2.put("y", nWomen / max(1,applicants.size()));
        genderCount.add(map2);
        

        map3.put("label", "Men Average Score ");
        map3.put("y", menScore / max(1,nMen));
        genderScore.add(map3);
        

        map4.put("label", "Women Average Score ");
        map4.put("y", womenScore / max(1,nWomen));
        genderScore.add(map4);

    }

    private void calculateSkillsDistribution(ArrayList<Applicant> applicants) {
        Map<String, Integer> skills = new HashMap();
        //Adding elements to map  

        for (int i = 0; i < applicants.size(); i++) {

            for (int j = 0; j < applicants.get(i).getSkills().length; j++) {
                if (skills.containsKey(applicants.get(i).getSkills()[j])) {
                    int newVal = skills.get(applicants.get(i).getSkills()[j]) + 1;
                    skills.replace(applicants.get(i).getSkills()[j], newVal);

                } else {
                    skills.put(applicants.get(i).getSkills()[j], 1);
                }
            }
        }

        for (Map.Entry m : skills.entrySet()) {
            Map<Object, Object> map = new HashMap<Object, Object>();
            map.put("label", m.getKey());
            map.put("y", m.getValue());
            skillsCount.add(map);

        }

    }

    private void calculateAboveBelow(ArrayList<Applicant> applicantsList, double threshold) {
        double nAbove = 0;
        double nBelow = 0;
        for (int i = 0; i < applicantsList.size(); i++) {
            if (applicantsList.get(i).getScore() >= threshold) {
                nAbove++;
            } else {
                nBelow++;
            }
        }
        nAbove = nAbove*100;
        nBelow = nBelow*100;
        Map<Object, Object> map2 = new HashMap<Object, Object>();
        Map<Object, Object> map1 = new HashMap<Object, Object>();
        map2.put("label", "Above Required Score");
        map2.put("y", nAbove/max(1,applicantsList.size()));
        nAbove_nBelow.add(map2);
      
        map1.put("label", "Below Required Score");
        map1.put("y", nBelow/max(1,applicantsList.size()));
        nAbove_nBelow.add(map1);

    }
    public List<Map<Object, Object>> getGenderCount()
    {
        return genderCount;
    }
    public List<Map<Object, Object>> getGenderScore()
    {
        return genderScore;
    }            
    public List<Map<Object, Object>> getSkillsCount()
    {
        return skillsCount;
    }
    public List<Map<Object, Object>> getNBelow_NAbove()
    {
        return nAbove_nBelow;
    }
   
    

}
