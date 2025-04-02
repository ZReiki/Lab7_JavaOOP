package main.service;

import main.io.Printer;
import main.logic.Patient;
import main.logic.PatientRepository;

import java.io.*;
import java.nio.file.Files;
import java.util.*;

public class PatientRepositoryBinaryImpl implements PatientRepository {
    private final Printer printer = new Printer();

    @Override
    public void outputList(List<Patient> patients, File file){
        try(ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(file.toPath()))){
            out.writeObject(patients);
            printer.successWriteToFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void outputList(List<Patient> patients, String fileName){
        File file = new File(fileName);
        outputList(patients, file);
    }

    @Override
    public List<Patient> readList(File file){
        try(ObjectInputStream in = new ObjectInputStream(Files.newInputStream(file.toPath()))){
            printer.successReadFromFile();
            return (List<Patient>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Patient> readList(String fileName){
        File file = new File(fileName);
        return readList(file);
    }
}
