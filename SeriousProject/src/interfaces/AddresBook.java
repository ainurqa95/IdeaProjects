package interfaces;
import models.Person;

/**
 * Created by Айнур on 03.10.2016.
 */
public interface AddresBook {

    public void addPerson (Person human);
    public void deletePerson (Person human);
    public void updateHuman(Person human);
}
