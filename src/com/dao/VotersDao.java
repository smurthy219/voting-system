package com.dao;
import com.model.Data;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.model.Region;
import com.model.Voter;
import java.util.ArrayList;
import java.util.List;
public class VotersDao {
	private Map<String,Set<Voter>> regionAndVoterInfo = new HashMap<String, Set<Voter>>();
	private Set<Region> regions = new HashSet<Region>();
        private Set<Voter> voter = new HashSet<Voter>();
        
        private List<String> regionNames = new ArrayList<String>();
	
	public Data readData() throws FileNotFoundException  {
            
		String temp;
		Data data = new Data();
                
		BufferedReader rd = new BufferedReader(new FileReader("C:\\Users\\Murthy Saladi\\Documents\\data.txt"));
		String regn = "";
		try {
			while((temp = rd.readLine()) != null) {
				if(temp.equals("&&")){
                                        System.out.println("end of file");	
                                
                                }
                                else if(temp.contains("//")) {
                                    voter.clear();
							
				}else if(temp.contains("/")) {   
					Region r = new Region();
                                        
                                        
                                        r.setRgnName(temp.substring(0, temp.indexOf("/")));
                                      	
                                        r.setContestants(temp.substring((temp.indexOf("/")+1)));
                                       
                                        regionNames.add(temp.substring(0, temp.indexOf("/")));
                                       
					regions.add(r);		
				}else if(regionNames.contains(temp)) {
					regn = temp;
				}else if(!temp.isEmpty()){
                                    Voter v = new Voter();
                                   
                                    v.setVid(Integer.parseInt(temp.substring(0, temp.indexOf(" "))));
                                    v.setvPreference(temp.substring(temp.indexOf(" ")+1));
                                    voter.add(v);
                                  
                                    regionAndVoterInfo.put(regn,new HashSet<Voter>(voter));
                                    
                                }
				
			}	
                        
                        data.setRegions(regions);
                        data.setRegionAndVoterInfo(regionAndVoterInfo);
                       
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return data;
		
	}
}
