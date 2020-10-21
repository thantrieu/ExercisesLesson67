package net.braniumacademy.ex673;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        System.out.println("Nhập họ và tên giảng viên: ");
        var fullName = input.nextLine();
        System.out.println("Nhập mức lương: ");
        // nhập vào mức lương và loại bỏ khoảng trắng đầu cuối nếu có
        var salaryStr = input.nextLine().trim();
        Instructor instructor = new Instructor();
        instructor.setFullName(fullName);
        // kiểm tra xem mức lương có phải là số thực hay không
        if (salaryStr.matches("\\d+.\\d+")) {
            var salary = Float.parseFloat(salaryStr);
            // làm tròn lương đến 2 chữ số sau dấu phẩy
            salary = Math.round(salary * 100) * 1.0f / 100;
            try {
                instructor.setSalary(salary);
                System.out.println("Thiết lập mức lương thành công!");
            } catch (InvalidSalaryException e) {
                e.printStackTrace();
                System.out.println("Thiết lập mức lương thất bại!");
            }
        } else {
            System.out.println("Mức lương phải là số thực!");
        }

        showInfo(instructor);
    }

    private static void showInfo(Instructor instructor) {
        System.out.println("==================================");
        System.out.println("Tên giảng viên: " + instructor.getFullName());
        System.out.println("Mức lương: " + instructor.getSalary());
    }
}
