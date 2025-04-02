package main.service;

import main.io.Printer;
import main.logic.PatientRepository;

import main.logic.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.*;

public class PatientRepositoryTextImpl implements PatientRepository {
    private final Printer printer = new Printer();

    @Override
    public void outputList(List<Patient> patients, File file){
        try(PrintWriter out = new PrintWriter(Files.newBufferedWriter(file.toPath(), StandardCharsets.UTF_8))){
            if(patients != null){
                for(Patient patient : patients){
                    out.println(patient.getId() + "; " +
                            patient.getFullName() + "; " +
                            patient.getAddress() + "; " +
                            patient.getPhoneNumber() + "; " +
                            patient.getMedicalRecordNumber() + "; " +
                            patient.getMedicalDiagnosis() + "; " +
                            patient.getLastDateVisit() + "; " +
                            patient.getCurrentYearVisitCount() + ";");
                }
            }
            printer.successWriteToFile();
        }catch (IOException e){
            System.out.println("File not found");
        }
    }

    @Override
    public void outputList(List<Patient> patients, String fileName){
        File file = new File(fileName);
        outputList(patients, file);
    }

    @Override
    public List<Patient> readList(File file){
        List<Patient> patients = new ArrayList<>();
        try(BufferedReader in = Files.newBufferedReader(file.toPath(), StandardCharsets.UTF_8)) {
            String line;
            while((line = in.readLine()) != null) {
                String[] tokens = line.split("; ");
                if (tokens.length == 8) {
                    patients.add(new Patient(
                            Integer.parseInt(tokens[0]),
                            tokens[1],
                            tokens[2],
                            tokens[3],
                            Integer.parseInt(tokens[4]),
                            tokens[5],
                            tokens[6],
                            Integer.parseInt(tokens[7])
                    ));
                }
            }
            printer.successReadFromFile();
        }catch (IOException e){
            System.out.println("File not found");
        }
        return new ArrayList<>(patients);
    }

    @Override
    public List<Patient> readList(String fileName){
        File file = new File(fileName);
        return readList(file);
    }
}
