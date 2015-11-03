package timedcomputations;

public class TimedComputations {

    public static void main(String[] args) {
        long startTime;
        long endTime;
        double time;

        startTime = System.currentTimeMillis();

        double width, height, hypotenuse;
        width = 3.0;
        height = 4.0;
        hypotenuse = Math.sqrt(width * width + height * height);
        System.out.print("A triangle with sides 42 and 17 has hypotenuse");
        System.out.println(hypotenuse);

        System.out.println("\nMathematically, sin(x)*sin(x) + " + "cos(x) * cos(x) - 1 should should be 0.");
        System.out.println("Let's check this for x = 1:");
        System.out.print("sin(1)*sin(1) + cos (1)*cos(1) - 1 is ");
        System.out.println(Math.sin(1) * Math.sin(1) + Math.cos(1) * Math.cos(1) - 1);

        System.out.print("\nHere is a random number: ");
        System.out.println(Math.random());

        System.out.printf("Random number: %.3f", Math.random());

        endTime = System.currentTimeMillis();
        time = (endTime - startTime) / 1000.0;

        System.out.print("\nRun time in seconds was :  ");
        System.out.println(time);

    }

}
