package pieromc.example.myfirstapp;

public class Person{

    private String name;
    private String lastname;
    private Education education;
    private String[] interests;

    public Person(String name, String lastname, Education education, String[] interests){
        this.name = name;
        this.lastname = lastname;
        this.education = education;
        this.interests = interests;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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
