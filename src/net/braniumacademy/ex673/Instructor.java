package net.braniumacademy.ex673;

import net.braniumacademy.ex673.exceptions.*;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Instructor {
    private String instructorId; // mã giảng viên
    private String fullName;
    private String major;   // chuyên môn
    private float salary;   // lương
    private float experience; // số năm kinh nghiệm

    public Instructor() {
    }

    public Instructor(String instructorId) {
        this.instructorId = instructorId;
    }

    public Instructor(String instructorId, String fullName, String major, float salary, float experience) {
        this.instructorId = instructorId;
        this.fullName = fullName;
        this.major = major;
        this.salary = salary;
        this.experience = experience;
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

    public String getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(String instructorId) {
        this.instructorId = instructorId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public float getExperience() {
        return experience;
    }

    public void setExperience(float experience) {
        this.experience = experience;
    }
}
