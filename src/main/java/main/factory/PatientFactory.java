package main.factory;

import main.logic.Patient;

import java.util.ArrayList;
import java.util.List;

public class PatientFactory {
    public static List<Patient> createPatient(){
        return new ArrayList<>(List.of(
                new Patient(1, "Petrenko Oleksandr Ivanovych", "15 Khreshchatyk St., Kyiv, Ukraine",
                        "+380671234567", 202401, "Hypertension", "10.12.2024", 4),
                new Patient(2, "Kovalchuk Maryna Serhiivna", "10 Doroshenko St., Lviv, Ukraine",
                        "+380931112233", 202402, "Bronchial asthma", "04.11.2024", 2),
                new Patient(3, "Ivanenko Andrii Vasylovych", "5 Deribasovskaya St., Odesa, Ukraine",
                        "+380503332211", 202403, "Gastric ulcer", "20.01.2025", 3),
                new Patient(4, "Vasilenko Natalia Petrovna", "22 Sumska St., Kharkiv, Ukraine",
                        "+380671234890", 202404, "Type 2 diabetes mellitus", "24.02.2025", 9),
                new Patient(5, "Melnyk Volodymyr Hryhorovych", "30, Dmytro Yavornytskyi ave.",
                        "+380951112244", 202405, "Osteochondrosis of the cervical spine", "02.03.2025", 9),
                new Patient(6, "Shevchenko Oleg Mykolaiovych", "8 Haharina St., Dnipro, Ukraine",
                "+380661223344", 202406, "Hypertension", "15.03.2025", 5),
                new Patient(7, "Tkachenko Inna Volodymyrivna", "12 Peremohy Ave., Zaporizhzhia, Ukraine",
                        "+380931234567", 202407, "Bronchial asthma", "28.02.2025", 3),
                new Patient(8, "Pavlenko Serhii Oleksiiovych", "19 Volodymyrska St., Kyiv, Ukraine",
                        "+380991112233", 202408, "Type 2 diabetes mellitus", "05.01.2025", 7),
                new Patient(9, "Kryvonos Bohdan Viktorovych", "45 Shevchenka St., Lviv, Ukraine",
                        "+380671223355", 202409, "Gastric ulcer", "12.02.2025", 6),
                new Patient(10, "Bondarenko Kateryna Mykolaivna", "6 Bohdana Khmelnytskoho St., Odesa, Ukraine",
                        "+380503445566", 202410, "Hypertension", "01.04.2025", 4)
        ));
    }
}
