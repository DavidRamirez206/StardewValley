package model;

public abstract class Crop {
    protected String name;
    protected Season season;
    protected int growthTime;
    
    public Crop(String name, int optioSeason, int growthTime) {
        this.name = name;
        setSeason(Season.values()[optioSeason - 1]);
        this.growthTime = growthTime;
    }
    public Crop() {
    }
    
    public String getName() {
        return name;
    }
    public Season getSeason() {
        return season;
    }
    public int getGrowthTime() {
        return growthTime;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setSeason(Season season) {
        this.season = season;
    }
    public void setGrowthTime(int growthTime) {
        this.growthTime = growthTime;
    }

    
}
