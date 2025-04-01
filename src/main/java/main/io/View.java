package main.io;

import main.logic.Patient;
import java.util.*;

public class View {
    public void showPatient(List<Patient> patients) {
        TableStringBuilder<Patient> t = new TableStringBuilder<>();
        t.addColumn(" Id ", Patient::getId);
        t.addColumn(" Full_Name ", Patient::getFullName);
        t.addColumn(" Address ", Patient::getAddress);
        t.addColumn(" Phone_Number ", Patient::getPhoneNumber);
        t.addColumn(" Medical_Record ", Patient::getMedicalRecordNumber);
        t.addColumn(" Medical_Diagnosis ", Patient::getMedicalDiagnosis);
        t.addColumn(" Last_Date_Visit ", Patient::getLastDateVisit);
        t.addColumn(" Current_Year_Visit_Count ", Patient::getCurrentYearVisitCount);

        String s = t.createString(patients);
        printer(s);
    }

    public void mapPrinter(String description, Map<String, List<Patient>> patientsDiagnosis) {
        for(Map.Entry<String, List<Patient>> entry : patientsDiagnosis.entrySet()) {
            System.out.println(description + ": " + entry.getKey());
            showPatient(entry.getValue());
            System.out.println();
        }
    }

    public void mapPrinter(Map<String, Patient> patientsDiagnosis) {
        for(Map.Entry<String, Patient> entry : patientsDiagnosis.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }

    public void printer(String description){
        System.out.print(description);
    }

    public void printerIndividualInfo(String description, int value){
        if(value != -1) System.out.println(description + value);
        else System.out.println("There are no patient with this name.");
    }
}