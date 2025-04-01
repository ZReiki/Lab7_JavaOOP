package main.controller;

import main.io.*;
import java.util.*;
import main.logic.*;
import main.service.*;

public class PatientController {
    private final PatientService service = new PatientService();
    private final View view = new View();
    private final Scanner scanner = new Scanner(System.in);
    private final Printer menuOptions = new Printer();
    private final PatientRepositoryTextImpl txtFileService = new PatientRepositoryTextImpl();
    private final PatientRepositoryBinaryImpl binaryFileService = new PatientRepositoryBinaryImpl();
    private final PatientRepositoryJSONImpl jsonFileService = new PatientRepositoryJSONImpl();

    public void chooseListOperations(List<Patient> patients){
        exitLabel:
        while (true) {
            // write menu options
            menuOptions.menuOptions();

            // enter menu option
            int menu = scanner.nextInt();
            scanner.nextLine();

            switch (menu) {
                case 1 -> {
                    if (patients != null) {
                        view.printer("Enter the diagnosis: ");
                        String diagnosis = scanner.nextLine();
                        view.showPatient(service.listOfPatientsWithTheSpecifiedDiagnosis(patients, diagnosis));
                    }
                }
                case 2 -> {
                    if (patients != null) {
                        view.printer("Enter the first interval number: ");
                        int first = scanner.nextInt();
                        view.printer("Enter the last interval number: ");
                        int last = scanner.nextInt();
                        view.showPatient(service.listOfPatientsWhoseMedicalRecordNumberIsWithinTheSpecifiedInterval(patients, first, last));
                    }
                }
                case 3 -> {
                    if (patients != null) {
                        view.printer("Enter the first phone number: ");
                        String firstPhoneNumber = scanner.nextLine();
                        view.showPatient(service.quantityAndListOfPatientsWhosePhoneNumberBeginsWithTheSpecifiedDigit(patients, firstPhoneNumber));
                    }
                }
                case 4 ->{
                    if (patients != null) {
                        view.showPatient(service.listOfPatientsByCurrentYearVisitCount(patients));
                    }
                }
                case 5 ->{
                    if (patients != null) {
                        view.printer("Enter the id of the patient: ");
                        view.printerIndividualInfo("The medical record number of the person is: ",
                                service.findPatientById(patients, scanner.nextInt()));
                    }
                }
                case 6 -> view.mapPrinter("Diagnose", service.mapOfPatientsByDiagnosisWithMedicalRecordNumber(patients));
                case 7 ->{
                    if (patients != null) {
                        view.mapPrinter(service.mapOfPatientsByDiagnosisWithMaxVisitCount(patients));
                    }
                }
                case 8 ->{
                    view.printer("Adding the new patient to the list:\n");
                    if (patients != null) {
                        service.addNewPatient(patients);
                    }
                }
                case 9 -> {
                    view.printer("Deleting the patient from the list:\nEnter the id of the patient: ");
                    if (patients != null) {
                        service.deletePatientFromList(patients, scanner.nextInt());
                    }
                }
                case 10 ->{
                    if (patients != null) {
                        view.showPatient(patients);
                    }
                }
                case 11 -> {
                    break exitLabel;
                }
                case 0 -> {
                    return;
                }
                default -> view.printer("Invalid menu option");
            }
        }
        fileManagement(patients);
    }

    public void fileManagement(List<Patient> patients){
        exitLabel:
        while(true) {
            menuOptions.menuFileManagement();

            int menu = scanner.nextInt();
            scanner.nextLine();

            switch (menu) {
                case 1, 2, 3, 4, 5, 6 -> {
                    view.printer("Enter the name of the file without its type:");
                    String fName = scanner.nextLine();

                    switch (menu) {
                        case 1 -> txtFileService.outputList(patients, fName + ".txt");
                        case 2 -> {
                            patients.clear();
                            patients.addAll(txtFileService.readList(fName + ".txt"));
                        }
                        case 3 -> binaryFileService.outputList(patients, fName + ".bin");
                        case 4 -> {
                            patients.clear();
                            patients.addAll(binaryFileService.readList(fName + ".bin"));
                        }
                        case 5 -> jsonFileService.outputList(patients, fName + ".json");
                        case 6 -> {
                            patients.clear();
                            patients.addAll(jsonFileService.readList(fName + ".json"));
                        }
                    }
                }
                case 7 -> {
                    break exitLabel;
                }
                default -> view.printer("Invalid menu option");
            }
        }
        chooseListOperations(patients);
    }

    public void controller(List<Patient> patients) {
        chooseListOperations(patients);
    }
}