// --== CS400 Spring 2023 File Header Information ==--
// Name: <Hyeonmin Yang>
// Email: <hyang486@wisc.edu>
// Team: <BJ>
// TA: <Naman Gupta>
// Lecturer: <CS400 Lecture002>
// Notes to Grader: <optional extra notes>
public interface SortedCollectionInterface<T extends Comparable<T>>{

    public boolean insert(T data) throws NullPointerException, IllegalArgumentException;

    public boolean remove(T data) throws NullPointerException, IllegalArgumentException;

    public boolean contains(T data);

    public int size();

    public boolean isEmpty();

}
