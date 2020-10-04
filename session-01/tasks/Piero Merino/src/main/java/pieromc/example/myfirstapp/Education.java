package pieromc.example.myfirstapp;

public class Education {

    private String university;
    private String career;

    public Education(String university, String career) {
        this.university = university;
        this.career = career;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

}
