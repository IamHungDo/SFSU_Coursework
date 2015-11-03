package converter;

public class Converter {

    public static void main(String[] args) {

        System.out.println("Given: 1 liter = 0.26 gallons");

        // 1A
        double gallon = 0.26;
        System.out.println("A)How many gallons is 26 liters?");
        int liter = 26;
        System.out.println("The answer is " + gallon * liter + ".");

        // 1B
        System.out.println("B)How many gallons is 3.58 liters?");
        double waterliter = 3.58;
        System.out.println("The answer is " + gallon * waterliter + ".");

        // 1C
        System.out.println("C)How many liters is 4.5 galloons?");
        double questiongallon = 4.5;
        double total = questiongallon / gallon;
        System.out.println("The answer is " + total);

        System.out.println("Given: 1 kilogram is 2.2 pounds");

        //2A
        float pounds = 2.2F;
        System.out.println("A)How many pounds is 56 kilogram?");
        double kilogram = 56;
        System.out.println("The answer is " + pounds * kilogram + ".");

        //2B
        double questionpounds = 198.23;
        System.out.println("B)How many kilogram is 198.23 pounds?");
        double totalkilo = questionpounds / pounds;
        System.out.println("The answer is " + totalkilo);

    }

}
