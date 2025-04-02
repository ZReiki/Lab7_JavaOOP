package main.io;

public class Printer {
    public void menuOptions() {
        System.out.print("""
                    +-------------------------------------------------------------------------------------------+
                    |                                           Menu                                            |
                    +-------------------------------------------------------------------------------------------+
                    |                                   Operations with list:                                   |
                    | 1. List of Patients with the specified diagnosis;                                         |
                    | 2. List of Patients whose medical record number is within the specified interval;         |
                    | 3. Quantity and list of Patients whose phone number begins with the specified digit;      |
                    | 4. The list of patients in descending order of the number of visits in the current year;  |
                    | If it is the same, in ascending order of medical record numbers;                          |
                    | 5. Patient's medical record number by id;                                                 |
                    | 6. A list of patients with this diagnosis in ascending order of the medical record number;|
                    | 7. For each patient diagnosis with the highest number of visits;                          |
                    +-------------------------------------------------------------------------------------------+
                    |                                   Changing the list:                                      |
                    | 8. Add new Patient to the list;                                                           |
                    | 9. Delete a patient from the list by id;                                                  |
                    | 10. Show all patients in the list;                                                        |
                    +-------------------------------------------------------------------------------------------+
                    |                                          Files:                                           |
                    | 11. Files operations;                                                                     |
                    +-------------------------------------------------------------------------------------------+
                    | 0. Exit                                                                                   |
                    +-------------------------------------------------------------------------------------------+
                    Your option >>\s""");
    }

    public void menuFileManagement(){
        System.out.print("""
                +---------------------------------------------------+
                |                    Files menu                     |
                +---------------------------------------------------+
                |                    Txt files:                     |
                | 1. Write the list of Patients in the txt file;    |
                | 2. Read the list of Patients from the txt file;   |
                +---------------------------------------------------+
                |                   Binary files:                   |
                | 3. Write the list of Patients in the binary file; |
                | 4. Read the list of Patients from the binary file;|
                +---------------------------------------------------+
                |                    JSON files:                    |
                | 5. Write the list of Patients in the JSON file;   |
                | 6. Read the list of Patients from the JSON file;  |
                +---------------------------------------------------+
                | 7. Back <-                                        |
                +---------------------------------------------------+
                Your option >>\s""");
    }

    public void successWriteToFile(){
        System.out.println("""
                +-------------------------------------------------+
                |The data was successfully written to the file    |
                +-------------------------------------------------+
                """);
    }

    public void successReadFromFile(){
        System.out.println("""
                +-------------------------------------------------+
                |The data was successfully read from the file     |
                +-------------------------------------------------+
                """);
    }
}
