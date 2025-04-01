package main.service;

import main.logic.Patient;
import main.io.*;

import java.util.*;

public class PatientService {
    private final Input input = new Input();

    // List operations
    public List<Patient> listOfPatientsWithTheSpecifiedDiagnosis(List<Patient> patients, String diagnosis){
        var resultList = new ArrayList<Patient>();
        for (Patient patient : patients){
            if(patient.getMedicalDiagnosis().equals(diagnosis)){
                resultList.add(patient);
            }
        }
        return resultList;
    }

    public List<Patient> listOfPatientsWhoseMedicalRecordNumberIsWithinTheSpecifiedInterval(List<Patient> patients, int minInterval, int maxInterval){
        var resultList = new ArrayList<Patient>();
        for (Patient patient : patients){
            if(patient.getMedicalRecordNumber() >= minInterval && patient.getMedicalRecordNumber() <= maxInterval){
                resultList.add(patient);
            }
        }
        return resultList;
    }

    public List<Patient> quantityAndListOfPatientsWhosePhoneNumberBeginsWithTheSpecifiedDigit(List<Patient> patients, String phoneNumberDigit){
        var resultList = new ArrayList<Patient>();
        for (Patient patient : patients){
            String phoneNumberFirstDigit = patient.getPhoneNumber().substring(4, 5);
            if(phoneNumberDigit.equals(phoneNumberFirstDigit)){
                resultList.add(patient);
            }
        }
        return resultList;
    }

    // Changing the list
    public void addNewPatient(List<Patient> patients){
        patients.add(input.newPatient());
        checkTheCorrectOder(patients);
    }

    public void deletePatientFromList(List<Patient> patients, int id){
        patients.removeIf(patient -> patient.getId() == id);
        checkTheCorrectOder(patients);
    }

    public void checkTheCorrectOder(List<Patient> patients){
        for(int i = 0; i < patients.size(); i++){
            if(patients.get(i).getId() != i + 1){
                patients.get(i).setId(i + 1);
            }
        }
    }

    //Список пацієнтів у порядку спадання кількості візитів у поточному році. Якщо вона
    //однакова - за зростанням номерів медичної картки.
    public List<Patient> listOfPatientsByCurrentYearVisitCount(List<Patient> patients){
        List<Patient> t = new ArrayList<>(patients);
        t.sort(new Comparator<>() {
            @Override
            public int compare(Patient o1, Patient o2) {
                int t = Integer.compare(o2.getCurrentYearVisitCount(), o1.getCurrentYearVisitCount());
                if(t != 0){
                    return t;
                }
                return Integer.compare(o1.getMedicalRecordNumber(), o2.getMedicalRecordNumber());
            }
        });
        return t;
    }

    public int findPatientById(List<Patient> patients, int id){
        for(Patient patient : patients){
            if(patient.getId() == id){
                return patient.getMedicalRecordNumber();
            }
        }
        return -1;
    }

    // Map operations
    public HashMap<String, List<Patient>> createMap(List<Patient> patients){
        var resultMap = new HashMap<String, List<Patient>>();
        for (Patient patient : patients){
            if (!resultMap.containsKey(patient.getMedicalDiagnosis())) {
                resultMap.put(patient.getMedicalDiagnosis(), new ArrayList<>());
            }
            resultMap.get(patient.getMedicalDiagnosis()).add(patient);
        }
        return resultMap;
    }

    public HashMap<String, List<Patient>> mapOfPatientsByDiagnosisWithMedicalRecordNumber(List<Patient> patients){
        var resultMap = createMap(patients);
        for(Map.Entry<String, List<Patient>> entry : resultMap.entrySet()){
            entry.getValue().sort(new Comparator<>() {
                @Override
                public int compare(Patient o1, Patient o2) {
                    return Integer.compare(o1.getMedicalRecordNumber(), o2.getMedicalRecordNumber());
                }
            });
        }

        return resultMap;
    }

    public HashMap<String, Patient> mapOfPatientsByDiagnosisWithMaxVisitCount(List<Patient> patients){
        var resultMap = new HashMap<String, Patient>();
        for(Patient patient : patients){
            String diagnosis = patient.getMedicalDiagnosis();

            if (!resultMap.containsKey(diagnosis)) {
                resultMap.put(diagnosis, patient);
            } else {
                Patient existingPatient = resultMap.get(diagnosis);
                if (patient.getCurrentYearVisitCount() > existingPatient.getCurrentYearVisitCount()) {
                    resultMap.put(diagnosis, patient);
                }
            }
        }
        return resultMap;
    }
}
