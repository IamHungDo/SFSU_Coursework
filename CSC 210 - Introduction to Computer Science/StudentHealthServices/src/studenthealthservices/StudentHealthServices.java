package studenthealthservices;

import java.util.Scanner;

public class StudentHealthServices {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner nc = new Scanner(System.in);

        EMR p1 = new EMR("Kendrick Lamar", "11/18/1995"); // These 5 entries are objects.
        p1.addCount();
        EMR p2 = new EMR("Frank Ocean", "06/03/1978");
        p2.addCount();
        EMR p3 = new EMR("Tupac Shakur", "08/24/1981");
        p3.addCount();
        EMR p4 = new EMR("Katy Perry", "02/13/1980");
        p4.addCount();
        EMR p5 = new EMR("Selena Gomez", "01/30/1982");
        p5.addCount();

        System.out.println("Welcome to the Student Health Services. We currently have 3 of out " + EMR.count + " patients available.");
        System.out.println("The available patients are: " + p1.getName() + " " + p1.getDob() + "," + p3.getName() + " " + p3.getDob() + "," + p5.getName() + " " + p5.getDob());
        String reason;
        System.out.println("Hello " + p1.getName() + ". What is your reason of visit?"); // Gets the reason
        reason = sc.nextLine();
        p1.setReason(reason);

        System.out.println("Okay come right in. Lets check your heart rate and body temperature. Put this on. *Heart check is checking* Great, your heart rate is");
        double hr;
        hr = nc.nextDouble();
        p1.setHR(hr);
        System.out.println("And your body temperature is: "); // Gets HR and Body temp
        double bt;
        bt = nc.nextDouble();
        p1.setBodyTemp(bt);

        System.out.println("Lets move on and find out what you have. *checks* Oh no, you have: "); // Gets the diagnosis
        String diagnosis;
        diagnosis = sc.nextLine();
        p1.setDiagnosis(diagnosis);

        System.out.println("I have just the right solution for you! Lets prescribe you: "); // Medicine
        String med;
        med = sc.nextLine();
        p1.setPrescribedMed(med);

        System.out.println("The second patient curiously walks toward you");

        System.out.println("Hello " + p2.getName() + ". What is your reason of visit?"); // Some thing as above, but for patient 2.
        reason = sc.nextLine();
        p2.setReason(reason);

        System.out.println("Okay come right in. Lets check your heart rate and body temperature. Put this on. *Heart check is checking* Great, your heart rate is");
        hr = nc.nextDouble();
        p2.setHR(hr);
        System.out.println("And your body temperature is: ");

        bt = nc.nextDouble();
        p2.setBodyTemp(bt);

        System.out.println("Lets move on and find out what you have. *checks* Oh no, you have: ");
        diagnosis = sc.nextLine();
        p2.setDiagnosis(diagnosis);

        System.out.println("I have just the right solution for you! Lets prescribe you: ");
        med = sc.nextLine();
        p2.setPrescribedMed(med);

        System.out.println("The  patient rushes over to you");

        System.out.println("Hello " + p3.getName() + ". What is your reason of visit?"); // Some thing as above, but for patient 3.
        reason = sc.nextLine();
        p3.setReason(reason);

        System.out.println("Okay come right in. Lets check your heart rate and body temperature. Put this on. *Heart check is checking* Great, your heart rate is");
        hr = nc.nextDouble();
        p3.setHR(hr);
        System.out.println("And your body temperature is: ");

        bt = nc.nextDouble();
        p3.setBodyTemp(bt);

        System.out.println("Lets move on and find out what you have. *checks* Oh no, you have: ");
        diagnosis = sc.nextLine();
        p3.setDiagnosis(diagnosis);

        System.out.println("I have just the right solution for you! Lets prescribe you: ");
        med = sc.nextLine();
        p3.setPrescribedMed(med);

        System.out.println("Today's results are: ");
        System.out.println(p1.getName() + ", " + p1.getDob());// These lines of codes print out the updated values of the patients.
        System.out.println("Heartrate :" + p1.getHR() + "\n" + "Body Temperature: " + p1.getbodytemp() + "\n" + "Does this person have normal vitals? " + EMR.redFlags(p1.getbodytemp(), p1.getHR()) + "\n" + "Diagnosed with: " + p1.getDiagnosis() + "\n" + "Prescirbed with: " + p1.getPrescribedmed());

        System.out.println(p2.getName() + ", " + p2.getDob());
        System.out.println("Heartrate :" + p2.getHR() + "\n" + "Body Temperature: " + p2.getbodytemp() + "\n" + "Does this person have normal vitals? " + EMR.redFlags(p2.getbodytemp(), p2.getHR()) + "\n" + "Diagnosed with: " + p2.getDiagnosis() + "\n" + "Prescirbed with: " + p2.getPrescribedmed());

        System.out.println(p3.getName() + ", " + p3.getDob());
        System.out.println("Heartrate :" + p3.getHR() + "\n" + "Body Temperature: " + p3.getbodytemp() + "\n" + "Does this person have normal vitals? " + EMR.redFlags(p3.getbodytemp(), p3.getHR()) + "\n" + "Diagnosed with: " + p3.getDiagnosis() + "\n" + "Prescirbed with: " + p3.getPrescribedmed());

    }

}
