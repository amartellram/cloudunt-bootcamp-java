package io.gustavopimol.myfirstapp;


import java.io.Serializable;

public class Personalinformation implements Serializable {
    private String name;
    private String education;
    private String technologies;

    public Personalinformation(String name, String education, String technologies) {
        this.name = name;
        this.education = education;
        this.technologies = technologies;
    }

    public String getName() {
        return name;
    }

    public String getEducation() {
        return education;
    }

    public String getTechnologies() {
        return technologies;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTechnologies(String technologies) {
        this.technologies = technologies;
    }
}
