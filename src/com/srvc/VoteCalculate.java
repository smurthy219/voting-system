package com.srvc;
import com.model.Data;
import com.model.Region;
import com.model.Voter;
import java.util.Map;
import java.util.Set;
public class VoteCalculate {
	 private Map<String,Set<Voter>> regionAndVoterInfo;
	    private Set<Region> regions;
	    
	    
	    public void winners(Data d){
	    
	        regionAndVoterInfo = d.getRegionAndVoterInfo();
	        regions = d.getRegions();
	        int CHIEF_SCORE = 0;
	        char CHIEF = ' ';
	        
	        
	        for (Region rgn : regions){
	            
	        Set<Voter> allVoter = regionAndVoterInfo.get(rgn.getRgnName());   
	        
	        if(allVoter != null){
	        int regionOfficerScore = 0;
	        char regionOfficer = ' ';
	        int invalidVote =0;
	        
	            
	           System.out.println("\n\n*******All voter for region : "+ rgn.getRgnName() +" " + allVoter + "********");
	           char[] contestnts = rgn.getContestants().toCharArray();
	           
	           for(char contestant : contestnts){
	               int score = 0;
	                    for(Voter voter : allVoter){
	                        
	                        
	                        if(voter.getvPreference().length() >  3 || voter.getvPreference().length() < 0 ){
	                            
	                            invalidVote++;
	                            
	                        }else if(voter.getvPreference().indexOf(contestant) <= 2){
	                          
	                                 score = score + (3- (voter.getvPreference().indexOf(contestant)));
	                
	                        }
	                    }
	                    System.out.println("contestant : " + contestant + "score : " + score);
	                if(score > regionOfficerScore){    
	                   regionOfficerScore = score;
	                   regionOfficer = contestant;
	                }
	               
	           }
	           
	           System.out.println("\n Regional Officer of the region : " + rgn.getRgnName() + " is " + regionOfficer );
	        
	           System.out.println("invalid votes for region " + rgn.getRgnName() +" : " + invalidVote);
	           
	           if(CHIEF_SCORE < regionOfficerScore){
	               CHIEF_SCORE = regionOfficerScore;
	               CHIEF = regionOfficer;
	           }
	        }else{
	            System.out.println("\n No voters for region : " + rgn.getRgnName());
	        }
	        }
	        System.out.println("Chief of all the contestant including all regions is : " + CHIEF + " with having score " + CHIEF_SCORE ); 
	    }
}
