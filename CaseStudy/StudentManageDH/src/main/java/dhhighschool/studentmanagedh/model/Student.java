package dhhighschool.studentmanagedh.model;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.sql.Timestamp;

public class Student {
    private String code;
    private String firstName;
    private String lastName;
    private String dayBirth;
    private String email;
    private String phoneNum;
    private String address;
    private String avatar;
    private int class_id;
    private Timestamp createDate;
    private Timestamp updateDate;
    private int role_id;
    private int testScore_id;
    private int classification_id;
    private int remove;

    public Student(String code,
                   String firstName,
                   String lastName,
                   String dayBirth,
                   String email,
                   String phoneNum,
                   String address,
                   String avatar,
                   int class_id,
                   Timestamp createDate,
                   Timestamp updateDate,
                   int role_id,
                   int testScore_id,
                   int classification_id,
                   int remove) {
        this.code = code;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dayBirth = dayBirth;
        this.email = email;
        this.phoneNum = phoneNum;
        this.address = address;
        this.avatar = avatar;
        this.class_id = class_id;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.role_id = role_id;
        this.testScore_id = testScore_id;
        this.classification_id = classification_id;
        this.remove = remove;
    }

    public Student(String code,
                   String firstName,
                   String lastName,
                   String dayBirth,
                   String email,
                   String phoneNum,
                   String address,
                   String avatar,
                   int class_id,
                   int role_id) {
        this.code = code;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dayBirth = dayBirth;
        this.email = email;
        this.phoneNum = phoneNum;
        this.address = address;
        this.avatar = avatar;
        this.class_id = class_id;
        this.role_id = role_id;
    }

    public Student(String code, String firstName, String lastName, String dayBirth, String email, String phoneNum, String address, String avatar) {
        this.code = code;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dayBirth = dayBirth;
        this.email = email;
        this.phoneNum = phoneNum;
        this.address = address;
        this.avatar = avatar;
    }

    public Student(String code, String firstName, String lastName, String dayBirth, String email, String phoneNum, String address, String avatar, int class_id, Timestamp updateDate) {
        this.code = code;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dayBirth = dayBirth;
        this.email = email;
        this.phoneNum = phoneNum;
        this.address = address;
        this.avatar = avatar;
        this.class_id = class_id;
        this.updateDate = updateDate;
    }

    public Student() {

    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @NotEmpty(message = "Firstname not empty!")
    @Length(min = 3, max = 45, message = "Length of Firstname form 3 - 45 character ")
    @Pattern(regexp = "([A-Z])([a-z]){2,45}", message = "Format firstname not right! Ex. John")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @NotEmpty(message = "Lastname not empty!")
    @Length(min = 3, max = 45, message = "Length of Lastname form 3 - 45 character ")
    @Pattern(regexp = "(([A-Z])([a-z]){2,45} ?)+", message = "Format lastname not right! Ex. Nathans")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDayBirth() {
        return dayBirth;
    }

    public void setDayBirth(String dayBirth) {
        this.dayBirth = dayBirth;
    }

    @NotEmpty
    @Email(message = "Email format not right!")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @NotEmpty
    @Pattern(regexp = "([0][1-9][0-9]{8})", message = "Format Phone number not right!")
    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public Timestamp getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public int getTestScore_id() {
        return testScore_id;
    }

    public void setTestScore_id(int testScore_id) {
        this.testScore_id = testScore_id;
    }

    public int getClassification_id() {
        return classification_id;
    }

    public void setClassification_id(int classification_id) {
        this.classification_id = classification_id;
    }

    public int getRemove() {
        return remove;
    }

    public void setRemove(int remove) {
        this.remove = remove;
    }

    @Override
    public String toString() {
        return "People{" +
                "code='" + code + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dayBirth='" + dayBirth + '\'' +
                ", email='" + email + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", address='" + address + '\'' +
                ", avatar='" + avatar + '\'' +
                ", class_id=" + class_id +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", role_id=" + role_id +
                ", testScore_id=" + testScore_id +
                ", classification_id=" + classification_id +
                '}';
    }
}
