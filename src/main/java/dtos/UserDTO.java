package dtos;

import entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserDTO {

    private String userName;
    private String userPass;
    private List<RoleDTO> roleList = new ArrayList<>();
    private String address;
    private String phone;
    private String email;
    private Integer birth_year;
    private String gender;

    public UserDTO() {
    }

    public UserDTO(String address, String phone, String email, Integer birth_year, String gender) {
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.birth_year = birth_year;
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getBirth_year() {
        return birth_year;
    }

    public void setBirth_year(Integer birth_year) {
        this.birth_year = birth_year;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public UserDTO(User user){
        this.userName = user.getUserName();
        this.userPass = user.getUserPass();
        this.roleList = user.getRoleList().stream().map(r -> new RoleDTO(r)).collect(Collectors.toList());

    }

    public static List<UserDTO> getDtos(List<User> persons) {
        return persons.stream().map(p -> new UserDTO(p)).collect(Collectors.toList());
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public List<RoleDTO> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<RoleDTO> roleList) {
        this.roleList = roleList;
    }

}
