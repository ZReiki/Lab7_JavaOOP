package main.io;

import main.logic.Patient;

import java.util.Scanner;

public class Input {
    private final Scanner scanner = new Scanner(System.in);
    private final View view = new View();

    public Patient newPatient(){
        int id, medicalRecordNumber, currentYearVisitCount;
        String fullName, address, phoneNumber, medicalDiagnosis, lastDateVisit;
        view.printer("Id: ");
        id = scanner.nextInt();
        view.printer("Full name: ");
        scanner.nextLine();
        fullName = scanner.nextLine();
        view.printer("Address: ");
        address = scanner.nextLine();
        view.printer("Phone number: ");
        phoneNumber = scanner.nextLine();
        view.printer("Medical record number: ");
        medicalRecordNumber = scanner.nextInt();
        view.printer("Medical diagnosis: ");
        scanner.nextLine();
        medicalDiagnosis = scanner.nextLine();
        view.printer("Last date visit: ");
        lastDateVisit = scanner.nextLine();
        view.printer("Current year visit count: ");
        currentYearVisitCount = scanner.nextInt();
        return new Patient(
                id, fullName, address, phoneNumber, medicalRecordNumber, medicalDiagnosis, lastDateVisit, currentYearVisitCount
        );
    }
}
