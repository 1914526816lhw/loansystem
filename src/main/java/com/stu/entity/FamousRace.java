package com.stu.entity;

public class FamousRace {
    private Integer famousRaceId;

    private String famousRaceName;

    public Integer getFamousRaceId() {
        return famousRaceId;
    }

    public void setFamousRaceId(Integer famousRaceId) {
        this.famousRaceId = famousRaceId;
    }

    public String getFamousRaceName() {
        return famousRaceName;
    }

    public void setFamousRaceName(String famousRaceName) {
        this.famousRaceName = famousRaceName == null ? null : famousRaceName.trim();
    }
}