/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms.Recruitment;

import Entity.Recruitment.Applicant;
import Entity.Recruitment.Job;

/**
 *
 * @author maria
 */
public interface Semantic_Similarity_Interface {
    public double getApplicantJobSimilarity(Applicant applicant, Job job);
    // compare a job with itsef
    public double getJobRequiredSimilarity(Job job);
    
    
}
