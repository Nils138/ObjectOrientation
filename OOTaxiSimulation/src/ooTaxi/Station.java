package ooTaxi;

/**
 * Class that holds the number of persons arriving by train at the station and
 * is waiting for a taxi.
 *
 * @author Nils Kimman s1007368
 * @author Ole ten Hove s1007616
 */
public class Station {

    private int nrOfPassengersAtStation = 0;
    private int totalNrOfPassengers = 0;
    private boolean isClosed = false;
    private int nextTaxi = 1;

    public void enterStation(int nrOfPassengers) {
        nrOfPassengersAtStation += nrOfPassengers;
        totalNrOfPassengers += nrOfPassengers;
        System.out.println(nrOfPassengers + " passengers arrived at station");
    }

    /**
     * Ask for nrOfPassengers Passengers to leave the station
     *
     * @param nrOfPassengers
     */
    public void leaveStation(int nrOfPassengers) {
        nextTaxi = (nextTaxi % 4) + 1;
        if (nrOfPassengers <= nrOfPassengersAtStation) {
            nrOfPassengersAtStation -= nrOfPassengers;
        } else {
            System.out.println("leaveStation(" + nrOfPassengers + ") there are only "
                    + nrOfPassengersAtStation + " passengers at the station.");
        }
    }

    public int getWaitingPassengers() {
        return nrOfPassengersAtStation;
    }

    public void close() {
        isClosed = true;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public int getTotalNrOfPassengers() {
        return totalNrOfPassengers;
    }

    public int getNextTaxi() {
        return nextTaxi;
    }
}
