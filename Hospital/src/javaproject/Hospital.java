package javaproject;

import java.util.*;

public class Hospital {

    private Map<Ward, List<Patient>> wardMap = new HashMap<>();
    private int maxBeds = 2;

    public Hospital() {
        for (Ward w : Ward.values()) {
            wardMap.put(w, new ArrayList<>());
        }
    }

    public void admitPatient(Ward ward, Patient p) throws BedUnavailableException {
        if (wardMap.get(ward).size() >= maxBeds) {
            throw new BedUnavailableException("No beds available in " + ward);
        }
        wardMap.get(ward).add(p);
        System.out.println("Patient admitted to " + ward);
    }

    public void dischargePatient(Ward ward, int id) throws InvalidPatientStateException {
        for (Patient p : wardMap.get(ward)) {
            if (p.getId() == id) {
                p.discharge();
                wardMap.get(ward).remove(p);
                System.out.println("Patient discharged");
                return;
            }
        }
        throw new InvalidPatientStateException("Patient not found");
    }

    public void listPatients() {
        for (Ward w : wardMap.keySet()) {
            System.out.println("Ward: " + w);
            for (Patient p : wardMap.get(w)) {
                System.out.println(p);
            }
        }
    }

    public void occupancy() {
        for (Ward w : wardMap.keySet()) {
            double percent = (wardMap.get(w).size() * 100.0) / maxBeds;
            System.out.println(w + " Occupancy: " + percent + "%");
        }
    }
}