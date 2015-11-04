package studenthealthservices;

public class EMR {

    private String name;
    private String dob; // Data fields
    private String reason;
    private double bodytemp;
    private double hr;
    private String diagnosis;
    private String prescribedMed;
    static int count = 0;

    public void addCount() {
        count++; // These count the number of available patients
    }

    public int getCount() { // Gets the coint
        return count;
    }

    public EMR() { // Constructs the class

    }

    public EMR(String newName, String newDob) { // Contructor that makes the object
        name = newName;
        dob = newDob;
    }

    public EMR(String newReason, double newBodyTemp, double newHR, String newProblem, String newSolution) { // Constructor
        reason = newReason;
        bodytemp = newBodyTemp;
        hr = newHR;
        diagnosis = newProblem;
        prescribedMed = newSolution;
    }

    public String getName() { // Get name
        return name;
    }

    public String getDob() { // Get date of birth
        return dob;
    }

    public String getReason() { //Get reason
        return reason;
    }

    public void setReason(String SS) { // Set the reason
        reason = SS;
    }

    public double getbodytemp() { // Get body temp.
        return bodytemp;
    }

    public void setBodyTemp(double sBT) { //Set body temp
        bodytemp = sBT;
    }

    public double getHR() { // Get Heart rate
        return hr;
    }

    public void setHR(double nR) { // Set heart ret
        hr = nR;
    }

    public String getDiagnosis() { // get diagnosis
        return diagnosis;
    }

    public void setDiagnosis(String SD) { // set diagonsis
        diagnosis = SD;
    }

    public String getPrescribedmed() { // Get med
        return prescribedMed;
    }

    public void setPrescribedMed(String SPM) { // Set med
        prescribedMed = SPM;
    }

    public static boolean redFlags(double chr, double cbt) { // Determines if the user is normal or abnormal
        boolean checker;
        String a = null;
        if ((cbt < 99.1 && cbt > 97.3 && chr < 100 && chr > 60)) {
            checker = true;
        } else {
            checker = false;
        }

        return checker;

    }

}
