package main.logic;

import java.io.Serializable;

public class Patient implements Serializable {
    private int id;
    private String fullName;
    private String address;
    private String phoneNumber;
    private int medicalRecordNumber;
    private String medicalDiagnosis;
    private String lastDateVisit;
    private int currentYearVisitCount;

    public Patient(int id, String fullName, String address, String phoneNumber, int medicalRecordNumber,
                   String medicalDiagnosis, String lastDateVisit, int currentYearVisitCount) {
        this.id = id;
        this.fullName = fullName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.medicalRecordNumber = medicalRecordNumber;
        this.medicalDiagnosis = medicalDiagnosis;
        this.lastDateVisit = lastDateVisit;
        this.currentYearVisitCount = currentYearVisitCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getMedicalRecordNumber() {
        return medicalRecordNumber;
    }

    public void setMedicalRecordNumber(int medicalRecordNumber) {
        this.medicalRecordNumber = medicalRecordNumber;
    }

    public String getMedicalDiagnosis() {
        return medicalDiagnosis;
    }

    public void setMedicalDiagnosis(String medicalDiagnosis) {
        this.medicalDiagnosis = medicalDiagnosis;
    }

    public String getLastDateVisit() {
        return lastDateVisit;
    }

    public void setLastDateVisit(String lastDateVisit) {
        this.lastDateVisit = lastDateVisit;
    }

    public int getCurrentYearVisitCount() {
        return currentYearVisitCount;
    }

    public void setCurrentYearVisitCount(int currentYearVisitCount) {
        this.currentYearVisitCount = currentYearVisitCount;
    }

    @Override
    public String toString() {
        return "\nPatient {" +
                "\nid = " + id +
                "\nfullName = " + fullName +
                "\naddress = " + address +
                "\nphoneNumber = " + phoneNumber +
                "\nmedicalRecordNumber = " + medicalRecordNumber +
                "\nmedicalDiagnosis = " + medicalDiagnosis +
                "\nlastDateVisit = " + lastDateVisit +
                "\ncurrentYearVisitCount = " + currentYearVisitCount +
                "\n}";
    }
}
