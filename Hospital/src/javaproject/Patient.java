package javaproject;

public class Patient extends person {
    private int id;
    private int days;
    private boolean admitted;

    public Patient(int id, String name, int age, int days) {
        super(name, age);
        this.id = id;
        this.days = days;
        this.admitted = true;
    }

    public int getId() {
        return id;
    }

    public int getDays() {
        return days;
    }

    public boolean isAdmitted() {
        return admitted;
    }

    public void discharge() {
        admitted = false;
    }

    public String toString() {
        return id + " | " + name + " | " + age + " | Days: " + days;
    }
}