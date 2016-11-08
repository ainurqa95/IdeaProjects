package models;

import java.util.Set;

/**
 * Created by ainur on 23.10.16.
 */
public class Clinic {
    //private Client[] clients;
    private Set<Client> clients;
   // public Clinic(final int size) {
   //     clients = new Client[size];
   // }
    public void addClient (final Client client){
            this.clients.add(client);

    }
//    public Client findClientByPetName (String name){
//
//
//        }



}
