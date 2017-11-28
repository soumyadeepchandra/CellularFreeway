/*
 * @(#)Street.java
 * @(#)Main.java
 *
 * This program simulates the cellular automaton model for freeway traffic
 * as laid out by Kai Nagel and Michael Schreckenberg
 * (Journal de Physique I, EDP Sciences, 1992, 2 (12), pp.2221-2229).
 *
 * This program uses the license found in the LICENSE.md file.
 */

/**
 * The public class Main takes four command line arguments
 * as settings for the freeway traffic simulation
 * that will be launched afterwards.
 *
 * @version 1.00 27 Nov 2017
 * @author Daniel Kostuj
 */

public class Main {

    public static void main(String[] args) {

        if (args.length != 4)
            throw new IllegalArgumentException
                    ("\n\tNeed 4 arguments:\n\tfreeway length (int), " +
                            "amount of cars (int), random limit number (double)," +
                            " time interval in milliseconds (long)");


        //1st parameter: length of freeway (in slots)
        int freewayLength = Integer.parseInt(args[0]);
        //2nd parameter: amount of cars on freeway
        int carsAmount = Integer.parseInt(args[1]);
        //3rd parameter: value of random number propability limit
        //4th parameter: time interval in milliseconds
        double probabilityLimit = Double.parseDouble(args[2]);
        long intervalms = Long.parseLong(args[3]);

        if (freewayLength < 1)
            throw new IllegalArgumentException("Need a street of length bigger than 0");
        else if (freewayLength < carsAmount || carsAmount < 0)
            throw new IllegalArgumentException
                    ("\nAmount of cars has to be a positive number " +
                            "that is equal to or less than street length");
        else if (probabilityLimit < 0 || probabilityLimit > 1)
            throw new IllegalArgumentException("Random limit needs to be a decimal number between 0 and 1");
        else if (intervalms < 0)
            throw new IllegalArgumentException("Time interval needs to be a positive integer");



        Street freeway = new Street(freewayLength);
        freeway.insertCars(carsAmount);
        freeway.simulateTraffic(probabilityLimit, intervalms);
    }
}
