package io.tgelias.myfirstapp;

import java.util.ArrayList;

public class Person{
    private String firstName;
    private String lastName;
    private Education education;
    private String[] interests;

    public Person(String firstName, String lastName, Education education, String[] interests) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.education = education;
        this.interests = interests;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public String[] getInterests() {
        return interests;
    }

    public void setInterests(String[] interests) {
        this.interests = interests;
    }
}
