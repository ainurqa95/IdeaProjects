package models;

/**
 * Created by ainur on 31.10.16.
 */
public class LifeTable {
    private int id;
    private int cord_i;
    private int cord_j;
    private  int generation;

    public int getId() {
        return id;
    }

    public LifeTable(int cord_i, int cord_j, int generation) {
        this.cord_i = cord_i;
        this.cord_j = cord_j;
        this.generation = generation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LifeTable lifeTable = (LifeTable) o;

        if (id != lifeTable.id) return false;
        if (cord_i != lifeTable.cord_i) return false;
        if (cord_j != lifeTable.cord_j) return false;
        return generation == lifeTable.generation;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + cord_i;
        result = 31 * result + cord_j;
        result = 31 * result + generation;
        return result;
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
