package dtos;

public class GuideDTO {

    private String name;
    private String gender;
    private int birth_year;
    private String profile;
    private String image_url;

    public GuideDTO() {
    }

    public GuideDTO(String name, String gender, int birth_year, String profile, String image_url) {
        this.name = name;
        this.gender = gender;
        this.birth_year = birth_year;
        this.profile = profile;
        this.image_url = image_url;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getBirth_year() {
        return birth_year;
    }

    public void setBirth_year(int birth_year) {
        this.birth_year = birth_year;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    @Override
    public String toString() {
        return "GuideDTO{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", birth_year=" + birth_year +
                ", profile='" + profile + '\'' +
                ", image_url='" + image_url + '\'' +
                '}';
    }
}
