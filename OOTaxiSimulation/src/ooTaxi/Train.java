package ooTaxi;

/**
 * The train brings a number of passengers to a station in the simulation.
 *
 * @author Nils Kimman s1007368
 * @author Ole ten Hove s1007616
 */
public class Train implements Runnable {

    private int nrOfPassengers;
    private final Station station;
    private int nrOfTrips = 0;

    public Train(Station station) {
        this.station = station;
        this.nrOfPassengers = 0;
    }

    /**
     * Populate this train with number nrOfPassengers
     *
     * @param number the number of passengers of this train
     */
    public void loadPassengers(int number) {
        nrOfPassengers = number;
    }

    @Override
    public void run() {
        while (nrOfTrips < 10) {
            if (station.getWaitingPassengers() == 0 && nrOfTrips < 10) {
                loadPassengers(Util.getRandomNumber(60, 90));
                unloadPassengers();
                nrOfTrips++;
            }
        }
        station.close();
    }

    /**
     * empties this train and augment the number of Passengers at the station
     * with this nrOfPassenegers
     */
    public void unloadPassengers() {
        nrOfTrips += 1;
        station.enterStation(nrOfPassengers);
    }

    public void closeStation() {
        station.close();
    }

    public int getNrOfTrips() {
        return nrOfTrips;
    }
}
