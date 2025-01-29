package com.demoprojectgit;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/*An HR application needs to calculate employees' exact ages (in years, months, and days) based on their date of birth. The system should handle edge cases like leap years and varying month lengths. 
*@author Sreejitha S
*@version 1.0
*@since 05/01/2025
*/

public class EmployeeAge {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the employee's date of birth (yyyy-MM-dd): ");
        String dobInput = scanner.nextLine();

        try {
            LocalDate birthDate = LocalDate.parse(dobInput, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

            LocalDate currentDate = LocalDate.now();

            if (birthDate.isAfter(currentDate)) {
                System.out.println("Error: The date of birth cannot be in the future.");
                return;
            }

            Period age = Period.between(birthDate, currentDate);

            System.out.println("Employee's Exact Age:");
            System.out.println(age.getYears() + " years, " + age.getMonths() + " months, and " + age.getDays() + " days");

        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Please enter the date in yyyy-MM-dd format.");
        } finally {
            scanner.close();
        }
    }
}
