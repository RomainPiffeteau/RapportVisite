package sio2.rapportvisite;

import sio2.rapportvisite.data.Persistence;

public class Controller {

    public Controller() {
        try {
            Persistence.refreshDB();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
