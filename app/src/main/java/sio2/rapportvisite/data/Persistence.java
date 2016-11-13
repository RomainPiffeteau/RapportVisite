package sio2.rapportvisite.data;

import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;

import sio2.rapportvisite.Main;

public final class Persistence{

    /***
     * Constructeur caché pour éviter son utilisation accidentelle;
     */
    private Persistence(){}

    private static Connection openConnection() throws Exception {
        String dbIp = "";
        String dbName = "";
        String dbUser = "";
        String dbPassword = "";

        Connection cn = null;
        try{
            //METHODE DE JAVA JDBC : A ADAPTER
            cn = DriverManager.getConnection("jdbc:sqlserver://" + dbIp + ";database=" + dbName + ";user=" + dbUser + ";password=" + dbPassword);
        } catch (Exception e){
            throw e;
        }
        return cn;
    }

    private static void closeConnection(Connection cn) throws Exception{
        try {
            cn.close();
        } catch (Exception e) {
            throw e;
        }
    }

    public static void refreshDB() throws Exception {
        try {
            Connection cn = openConnection();
            //actions
            closeConnection(cn);
            Main.setAppInfos("Base locale rafraîchie");
            Log.i("debug_dev","Refresh DB OK");
        }catch(Exception e){
            Main.setAppInfosError(e.getMessage());
            Log.i("debug_dev", "Refresh DB Fail");
        }
    }

    public static void updateDB() throws Exception {
        try {
            Connection cn = openConnection();
            //actions
            closeConnection(cn);
            Main.setAppInfos("Base mise à jour");
            Log.i("debug_dev", "Update DB OK");
        }catch(Exception e){
            Main.setAppInfosError(e.getMessage());
            Log.i("debug_dev", "Update DB Fail");
        }
    }
}
