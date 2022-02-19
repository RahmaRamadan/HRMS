/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms.TimeTracking;

import Entity.TimeTracking.Project;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author maria
 */
public class TimeTrackingStatistics {

    private List<Map<Object, Object>> employeesScoreInProject =new ArrayList<Map<Object, Object>>();
    private List<Map<Object, Object>> projectsScoreDistribution =new ArrayList<Map<Object, Object>>();
    private List<Map<Object, Object>> milestonesScoreDistrubution =new ArrayList<Map<Object, Object>>();
    private List<Map<Object, Object>> projectStateRates =new ArrayList<Map<Object, Object>>();
    private List<Map<Object, Object>> projectsNeededSkillsCount=new ArrayList<Map<Object, Object>>();

    public TimeTrackingStatistics() throws Exception {
         calculateProjectsScoreDistribution() ;
        

    }

    private void calculateEmployeesScoreInProject(Project project) {
        Map<Object, Object> temp = new HashMap();
        for (int i = 0; i < project.getMilestones().size(); i++) {
            if (temp.containsKey(project.getMilestones().get(i).getEmployeeID())) {
                int oldScore = (int) temp.get(project.getMilestones().get(i).getEmployeeID());
                oldScore += project.getMilestones().get(i).getScore().ordinal();
            } else {
                temp.put(project.getMilestones().get(i).getEmployeeID(), project.getMilestones().get(i).getScore().ordinal());

            }

        }            for (Map.Entry m : temp.entrySet()) {
                Map<Object, Object> map = new HashMap<Object, Object>();
                map.put("label", m.getKey());
                map.put("y", m.getValue());
                employeesScoreInProject.add(map);

            }
    }

    public List<Map<Object, Object>> getEmployeesScoreInProject(Project project) {
        calculateEmployeesScoreInProject(project);
        return employeesScoreInProject;
    }

    private void calculateProjectsScoreDistribution() throws Exception {
        ProjectManager pm = new ProjectManager();
        ArrayList<Project> projects = pm.getProjects();
        double score = 0;
        for (int i = 0; i < projects.size(); i++) {
            score += projects.get(i).getTotalScore();
        }
        if(score==0) score=1;
        for (int i = 0; i < projects.size(); i++) {
            Map<Object, Object> map = new HashMap<Object, Object>();
            map.put("label", projects.get(i).getTitle());
            map.put("y", projects.get(i).getTotalScore() / score);
            projectsScoreDistribution.add(map);
        }

    }

    public List<Map<Object, Object>> getProjectsScoreDistribution() {
        return projectsScoreDistribution;

    }

    private void calculateMilestonesScoreDistrubution(Project project) {
         Map<Object, Object> temp = new HashMap();
        for (int i = 0; i < project.getMilestones().size(); i++) {
            if (temp.containsKey(project.getMilestones().get(i).getScore())) {
                int newScore = ((int) temp.get(project.getMilestones().get(i).getScore()))+1;
              
                temp.put(project.getMilestones().get(i).getScore(),newScore );
            } else {
                temp.put(project.getMilestones().get(i).getScore(), 1);

            }
           
        } for (Map.Entry m : temp.entrySet()) {
                Map<Object, Object> map = new HashMap<Object, Object>();
                map.put("label", m.getKey());
                map.put("y", m.getValue());
                milestonesScoreDistrubution.add(map);

            }

    }

    public List<Map<Object, Object>> getMilestonesScoreDistrubution(Project project) {
            calculateMilestonesScoreDistrubution( project);
        return milestonesScoreDistrubution;

    }

    private void calculateProjectStateRates(Project project) {
       
       Map<Object, Object> temp = new HashMap();
       temp.clear();
        for (int i = 0; i < project.getMilestones().size(); i++) {
            
            if (temp.containsKey(project.getMilestones().get(i).getState().toString())) {
                int newScore = ((int) temp.get(project.getMilestones().get(i).getState().toString()))+1;
                
                   temp.replace(project.getMilestones().get(i).getState().toString(),newScore );
            } else {
                temp.put(project.getMilestones().get(i).getState().toString(), 1);
               // System.out.println("mmmmmmmmmmmmmmm");

            }
            
        }for (Map.Entry m : temp.entrySet()) {
                System.out.println(m.getKey()+":"+m.getValue());
                Map<Object, Object> map = new HashMap<Object, Object>();
                map.put("label", m.getKey());
                map.put("y", m.getValue());
                projectStateRates.add(map);

            }
    }

    public List<Map<Object, Object>> getProjectStateRates(Project project) {
 calculateProjectStateRates( project);
        return projectStateRates;
    }

    private void calculateProjectsNeededSkillsCount(Project project) {
      Map<String, Integer> skills = new HashMap();
        //Adding elements to map  

        for (int i = 0; i < project.getMilestones().size(); i++) {

            for (int j = 0; j < project.getMilestones().get(i).getSkills().size(); j++) {
                if (skills.containsKey(project.getMilestones().get(i).getSkills().get(j))) {
                    int newVal = skills.get(project.getMilestones().get(i).getSkills().get(j)) + 1;
                    skills.replace(project.getMilestones().get(i).getSkills().get(j), newVal);

                } else {
                    skills.put(project.getMilestones().get(i).getSkills().get(j), 1);
                }
            }
        }

        for (Map.Entry m : skills.entrySet()) {
            Map<Object, Object> map = new HashMap<Object, Object>();
            map.put("label", m.getKey());
            map.put("y", m.getValue());
            projectsNeededSkillsCount.add(map);

        }

    }

    public List<Map<Object, Object>> getProjectsNeededSkillsCount(Project project) {
calculateProjectsNeededSkillsCount(project);
        return projectsNeededSkillsCount;
    }

}
