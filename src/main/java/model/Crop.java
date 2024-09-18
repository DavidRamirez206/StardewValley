package model;

public class Crop {
    private String name;
    private Season season;
    private int growthTime;
    private String type;
    
    public Crop(String name, int optionSeason, int growthTime) {
        this.name = name;
        setSeason(Season.values()[optionSeason - 1]);
        this.growthTime = growthTime;
        changeType();
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
    public String getType() {
        return type;
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

    public void setType(String type) {
        this.type = type;
    }

    private void changeType(){
        if (this.season.equals(Season.SPRING)) {
            this.type = "Spring";
        } else if (this.season.equals(Season.SUMMER)) {
            this.type = "Summer";
        } else if (this.season.equals(Season.WINTER)) {
            this.type = "Winter";
        } else if (this.season.equals(Season.FALL)) {
            this.type = "Fall";
        }
    }

    @Override
    public String toString() {
        return "\n_________________" +
                "\nName: " + name +
                "\nSeason: " + type +
                "\nGrowthTime: " + growthTime +
                "\nType: " + type;

    }


}