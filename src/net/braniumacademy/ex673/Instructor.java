package net.braniumacademy.ex673;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Instructor {
    private String id;      // mã nhân viên
    private String fullName;// họ và tên
    private String major;   // chuyên môn
    private float salary;   // lương
    private float experience; // số năm kinh nghiệm

    public Instructor() {
    }

    public Instructor(String id) {
        this.id = id;
    }

    public Instructor(String id, String fullName,
                      String major, float salary, float experience)
            throws InvalidSalaryException {
        this.id = id;
        this.fullName = fullName;
        this.major = major;
        this.setSalary(salary);
        this.experience = experience;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) throws InvalidSalaryException {
        var regex = "(([0-7]\\d?).\\d{1,2})|(80.[0]{1,2})";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(salary + "");
        if (matcher.matches()) {
            this.salary = salary;
        } else {
            this.salary = 0;
            var msg = "Mức lương không hợp lệ: " + salary
                    + ", giá trị hợp lệ phải nằm trong đoạn [0.00, 80.00]";
            throw new InvalidSalaryException(msg, salary);
        }
    }

    public float getExperience() {
        return experience;
    }

    public void setExperience(float experience) {
        this.experience = experience;
    }
}
