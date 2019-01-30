package com.model;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
public class Data {
	private Map<String,Set<Voter>> regionAndVoterInfo = new HashMap<String, Set<Voter>>();
	private Set<Region> regions = new HashSet<Region>();

    public Map<String, Set<Voter>> getRegionAndVoterInfo() {
        return regionAndVoterInfo;
    }

    public void setRegionAndVoterInfo(Map<String, Set<Voter>> regionAndVoterInfo) {
        this.regionAndVoterInfo = regionAndVoterInfo;
    }

    public Set<Region> getRegions() {
        return regions;
    }

    public void setRegions(Set<Region>regions) {
        this.regions = regions;
    }
        
        
}
