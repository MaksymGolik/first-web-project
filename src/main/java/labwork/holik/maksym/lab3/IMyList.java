package labwork.holik.maksym.lab3;

import labwork.holik.maksym.lab2.Apartment;
import labwork.holik.maksym.lab2.Estate;

public interface IMyList extends Iterable<Estate> {
    void add (Estate o);
    void clear();
    boolean remove(Estate o);
    boolean remove(int i);
    Object[] toArray();
    int size();
    boolean contains(Estate o);
    boolean add (Estate o, Estate added);
}