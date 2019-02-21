package observer.concept;

import java.util.ArrayList;

abstract class Subject {
    protected ArrayList<Observer> observers = new ArrayList<>();

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void detach(Observer observer) {
        observers.remove(observer);
    }

    public abstract void notifyObservers();
}

class ConcreteSubject extends Subject {

    @Override
    public void notifyObservers() {
        observers.forEach(Observer::update);
    }
}

interface Observer {
    public void update();
}

class ConcreteObserver implements Observer {

    @Override
    public void update() {
        System.out.println("concrete observer updating ... ");
    }
}


