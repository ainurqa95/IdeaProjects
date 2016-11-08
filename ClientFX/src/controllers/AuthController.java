package controllers;

import models.NetworкConnection;

/**
 * Created by ainur on 04.11.16.
 */
public class AuthController {

    private NetworкConnection connection;

    public AuthController(NetworкConnection connection) {
        this.connection = connection;
    }
}
