package main;

import main.controller.*;
import main.factory.PatientFactory;

public class Main {
    private final PatientController controller = new PatientController();
    public static void main(String[] args){
        new Main().run();
    }

    private void run() {
        controller.controller(PatientFactory.createPatient());
    }
}
