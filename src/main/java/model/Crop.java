package model;

public abstract class Crop {
    protected String name;
    protected Season season;
    protected State state;
    protected int growthTime;
    
    public Crop(String name, Season season, State state, int growthTime) {
        this.name = name;
        this.season = season;
        this.state = state;
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
    public State getState() {
        return state;
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
    public void setState(State state) {
        this.state = state;
    }
    public void setGrowthTime(int growthTime) {
        this.growthTime = growthTime;
    }

    
}
