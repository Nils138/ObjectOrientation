package ooTaxi;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * main Class: create a Simulation and execute it.
 *
 * @author Nils Kimman s1007368
 * @author Ole ten Hove s1007616
 */
public class OOTaxiMain {

    public static void main(String[] args) {
        Station station = new Station();
        Taxi[] taxis = new Taxi[4];
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 4; i++) {
            taxis[i] = i < 2
                    ? new Taxi(i + 1, 4, 2, station)
                    : new Taxi(i + 1, 7, 3, station);
            executor.execute(taxis[i]);
        }
        Train train = new Train(station);
        executor.execute(train);
        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        showStatistics(taxis, station);
    }

    public static void showStatistics(Taxi[] taxis, Station station) {
        System.out.println("All persons have been transported");
        System.out.println("Total transport time in this simulation:" + getTotalTime(taxis));
        System.out.println("Total number of train travelers: " + station.getTotalNrOfPassengers());
        System.out.println("Total number of persons transported in this simulation: " + getTotalNrOfPassengers(taxis));
    }

    private static int getTotalTime(Taxi[] taxis) {
        int time = 0;
        for (Taxi taxi : taxis) {
            time += taxi.getTotalTransportationTime();
        }
        return time;
    }

    /**
     * Calculates the total number of passengers that has been transported by
     * looping over all taxis
     *
     * @param taxis
     * @return total number of passengers
     */
    private static int getTotalNrOfPassengers(Taxi[] taxis) {
        int total = 0;
        for (Taxi taxi : taxis) {
            total += taxi.getTotalNrOfPassengers();
        }
        return total;
    }
}
