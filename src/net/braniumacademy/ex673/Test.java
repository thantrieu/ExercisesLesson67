package net.braniumacademy.ex673;

import net.braniumacademy.ex673.exceptions.InvalidSalaryException;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        System.out.println("Mã giảng viên: ");
        String id = input.nextLine();
        System.out.println("Họ và tên: ");
        String fullName = input.nextLine();
        System.out.println("Mức lương(0.00-80.00): ");
        float salary = input.nextFloat();
        Instructor instructor = new Instructor();
        instructor.setInstructorId(id);
        instructor.setFullName(fullName);
        try {
            instructor.setSalary(salary);
        } catch (InvalidSalaryException e) {
            e.printStackTrace();
        }
        showInfo(instructor);
    }

    private static void showInfo(Instructor instructor) {
        System.out.println("==================================");
        System.out.println("Tên giảng viên: " + instructor.getFullName());
        System.out.println("Mức lương: " + instructor.getSalary() + "tr(vnđ)");
    }
}
