package chapter10;

import annotation.GuardedBy;
import annotation.MaybeDeadlock;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

@MaybeDeadlock
public class Taxi {
    @GuardedBy("this")
    private Point location, destination;
    private final Dispatcher dispatcher;

    public Taxi(Dispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    public synchronized Point getLocation() {
        return location;
    }

    public synchronized void setLocation(Point location) {
        this.location = location;

        if (location.equals(destination)) {
            dispatcher.notifyAvailable(this);
        }
    }
}

class Dispatcher {
    @GuardedBy("this")
    private final Set<Taxi> taxis;
    @GuardedBy("this")
    private final Set<Taxi> availableTaxis;

    public Dispatcher() {
        taxis = new HashSet<>();
        availableTaxis = new HashSet<>();
    }

    public synchronized void notifyAvailable(Taxi taxi) {
        availableTaxis.add(taxi);
    }

    public synchronized Object getImage() {
        for (Taxi taxi : taxis) {
            // do something
        }
        return new Object();
    }
}
