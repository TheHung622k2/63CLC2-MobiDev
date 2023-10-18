package com.phamthehung.customizedlistview;

// Bước 1: Xây dựng một lớp để đại diện cho Item nào đó trong ListView
public class Country {
    private String countryName;
    private String countryFlag; // Tên file
    private int population;

    // Constructors
    public Country(String countryName, String countryFlag, int population) {
        this.countryName = countryName;
        this.countryFlag = countryFlag;
        this.population = population;
    }

    // Getters, Setters
    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryFlag() {
        return countryFlag;
    }

    public void setCountryFlag(String countryFlag) {
        this.countryFlag = countryFlag;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
}
