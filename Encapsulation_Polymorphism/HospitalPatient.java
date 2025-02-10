import java.util.*;
abstract class Patient {
    private String patientId;
    private String name;
    private int age;

    public Patient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    public String getPatientId() {
        return patientId;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }

    public abstract double calculateBill();

    public String getPatientDetails() {
        return "Patient ID: " + patientId + ", Name of Patient: " + name + ", Age of Patient: " + age;
    }
}

interface MedicalRecord {
    public void addRecord(String record);
    public void viewRecords();
}

class InPatient extends Patient implements MedicalRecord {
    private double dailyCharge;
    private int numberOfDays;
    private List<String> medicalHistory;

    public InPatient(String patientId, String name, int age, double dailyCharge, int numberOfDays) {
        super(patientId, name, age);
        this.dailyCharge = dailyCharge;
        this.numberOfDays = numberOfDays;
        this.medicalHistory = new ArrayList<>();
    }

    public double calculateBill() {
        return dailyCharge * numberOfDays;
    }

    public void addRecord(String record) {
        medicalHistory.add(record);
    }
    public void viewRecords() {
        System.out.println("Medical Records for " + getName() + ": " + medicalHistory);
    }
}

class OutPatient extends Patient implements MedicalRecord {
    private double consultationFee;
    private List<String> medicalHistory;

    public OutPatient(String patientId, String name, int age, double consultationFee) {
        super(patientId, name, age);
        this.consultationFee = consultationFee;
        this.medicalHistory = new ArrayList<>();
    }

    public double calculateBill() {
        return consultationFee;
    }
    public void addRecord(String record) {
        medicalHistory.add(record);
    }
    public void viewRecords() {
        System.out.println("Medical Records for " + getName() + ": " + medicalHistory);
    }
}
public class HospitalPatient {
    public static void main(String[] args) {
        List<Patient> patients = new ArrayList<>();
        patients.add(new InPatient("A103", "Anil Kumar Bansal", 58, 2000.0, 5));
        patients.add(new OutPatient("R458", "Radhika Bansal", 11, 500.0));

        for (Patient patient : patients) {
            System.out.println(patient.getPatientDetails());
            System.out.println("Total Bill: Rs. " + patient.calculateBill());
            if (patient instanceof MedicalRecord) {
                MedicalRecord medicalRecordPatient = (MedicalRecord) patient;
                medicalRecordPatient.addRecord("Routine check-up");
                medicalRecordPatient.viewRecords();
            }
            System.out.println();
        }
    }
}
