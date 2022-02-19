///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package Algorithms;
//import DataAccess.Employee_Job_DataAccess_Interface;
//import DataAccess.Applicant_Applicant_DataAccess_Interface;
//import DataAccess.Applicant_Job_DataAccess_Interface;
//import DataAccess.Employee_Applicant_DataAccess_Interface;
//import DataAccess.MySQL_Applicant_DataAccess;
//import DataAccess.MySQL_Job_DataAccess;
//import Entity.Applicant;
//import Entity.Job;
//import java.sql.SQLException;
//import java.util.ArrayList;
//
///**
// *
// * @author maria
// */
//public class generateData {
//    
//    
//    public void run() throws SQLException
//    {
//        String [] menNames = {"Ahmed","Mostafa","Samer","Sayed","Magdy","Ramy","Mohammed","Karim","Radwan","Samir","Saeed","Rady","Madeeh","Islam","Nabil","Ali","Essam","Salama","Kortom","Qandeel",
//                              "Kamel","Kamal","Amin","Hany","Seif","Khaled","Muhammad","Ismael","Ibrahim","Adam","Amr","Omar","Belal","Shennawy","Tarek","Hesham","Karam","Saleh","Salah","AbdulRahman",
//                              "Diaa","Dandarawy","Emad","Youssef","Hamza","Youssif","Hamzawy","Nady","AbdulHaleem","AbdulRaheem","AbdulSalam","AbdulAziz","Abdo","Haredy","Hady","Hashem","Mustafa","Hatem","Hazem","Seddiq",
//                              "Sohail","Mohannad","Yehia","Soliman","Adham","Samy","Ashraf","Bassem","Badr","Bakr","Akram","Amgad","Hossam","Diab","Galal","Ziad","Rafaat","Zedan","Hakim","Zahran",
//                              "Sameh","Seliem","Zain","Salman","Zakaria","Rashed","Shady","Shaker","Saad","Shawkey","AbdulHameed","Marwan","Rayyan","Tamer","Bassem","Essam","Othman","Omair","Hassan","Motaaz",
//                              "Mahmoud","Baher","Fekry","Farid","Farouk","Mourad","Atef","Taha","Hamdy","Mamdouh","Fathy","Ezzat","Mousa","Reda","Ahmed","Mostafa","Mohammed","Ahmed","Mahmoud","Ahmed"};
//       
//        String [] womenNames = {"Mariam","Rahma","Hanan","Hala","Rana","Salma","Esraa","Marwa","Sara","Samira","Nada","Nour","Abeer","Randa","Aisha","Menna","Laila","Aya","Shorouk","Amira",
//                                "Dalia","Doaa","Ruqayya","Nagwa","Doha","Lamya","Tasneem","Habeba","Hadeer","Miar","Ganna","Nourhan","Radwa","Eman","Dina","Alaa","Fatima","Farah","Sheren","Samar",
//                                "Zahraa","Leena","Heba","Neven","Shaimaa","Reham","Rowaida","Ahlam","Mona","Mayada","Mai","Naglaa","Samah","Hanaa","Raghad","Nayera","Roaa","Hagar","Toqa","Hend",
//                                "Azza","Asmaa","Manar","Rodaina","Wafaa","Yasmin","Rawan","Khadeja","Hafsa","Athar","Nehal","Nesreen","Rania","Noha","Noran","Nelly","Sherehan","Nancy","Bassant","Gody",
//                                "Gamila","Areej","Yousra","Retaj","Yara","Aseel","Farida","Amina","Sanaa","Reem","Kamar","Sara","Sara","Salma","Mariam","Rahma","Esraa","Aliaa","Aya","Aya","Aya","Esraa"};
//   
//        
//    
//    String [] skillsMachineLearning ={ "Python","Computer Vision","Natural Language Processing","Deep learning","Regression","Classification","Kaggle","Cluster Analysis","GitHub","C++","Java","Keras","PyTorch","Data Analysis","Machine Learning","ML","DL","NLP","CV","Models","research","Hadoop","Team work","Creative thinking","English","Leadership","Politeness","Commitment","C++","CUDA"};
//    String [] skillsDataScience ={ "Python","R","Kaggle","Data Analysis","Spark","Hadoop","Hive","SQL","MySQL","PostgreSQL","Data Visualization","Statistics","Machine Learning","Analytics","ML","Deep Learning","PyTorch","time series analysis","Team work","Creative thinking","English","Leadership","Politeness"};
//    String [] skillsManagement ={ "Management","lead","manager","planning","strategic planning","resources utilization","optimization","Team work","Creative thinking","English","Leadership","Politeness"};
//    String [] skillsComputerScience ={ "C++","Java","Software Engineering","Agile","Waterfall","Testing","Unix","Linux","Compilers","Data Structures","Problem solving","C#","GitHub","Git","Algorithms","Team work","Creative thinking","English","Leadership","Politeness"};
//    String [] skillsMarketing ={ "Digital Marketing","Advertising skills","Creative design","Graphic Desing","Market research","Team work","Creative thinking","English","Leadership","Politeness"};
//    String [] skillsSales ={ "Accounting","attached to details","market research","sales representative","persuasion","Team work","Creative thinking","English","Leadership","Politeness"};
//
//    Applicant_Applicant_DataAccess_Interface aai = new MySQL_Applicant_DataAccess();
//    Applicant_Job_DataAccess_Interface aji = new MySQL_Job_DataAccess();
//    Employee_Applicant_DataAccess_Interface eai = new MySQL_Applicant_DataAccess();
//    Employee_Job_DataAccess_Interface in = new MySQL_Job_DataAccess();
// 
//    // add jobs 
//    Job machineLearningJob;
//    Job ManagementJob;
//    Job SalesJob;
//    Job DataScience;
//    Job Marketing;
//    Job CPlusPlusDeveloper;
//    Job MarketingSpecialist;
//    Job HR;
//  
//    
//     
//     
//     
//            }
//    
//    
//}