package models;

/**
 * Created by ainur on 31.10.16.
 */
public class LifeTable {
    private int id;
    private int cord_i;
    private int cord_j;
    private  int generation;
    public LifeTable( int cord_i, int cord_j, int generation) {
        this.cord_i = cord_i;
        this.cord_j = cord_j;
        this.generation = generation;
    }

    public LifeTable(int id, int cord_i, int cord_j, int generation) {
        this.id = id;
        this.cord_i = cord_i;
        this.cord_j = cord_j;
        this.generation = generation;
    }

    public int getCord_i() {
        return cord_i;
    }

    public int getCord_j() {
        return cord_j;
    }

    public int getGeneration() {
        return generation;
    }

    public void setCord_i(int cord_i) {
        this.cord_i = cord_i;
    }

    public void setCord_j(int cord_j) {
        this.cord_j = cord_j;
    }

    public void setGeneration(int generation) {
        this.generation = generation;
    }
}
