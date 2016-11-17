package sio2.rapportvisite.data;

import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import sio2.rapportvisite.Main;

public final class Persistence{

    /***
     * Constructeur caché pour éviter son utilisation accidentelle;
     */
    private Persistence(){}

    private static Connection openConnection() throws SQLException {
        String dbIp = "192.168.222.72";
        String dbName = "gsbjm";
        String dbUser = "JeanMedicament";
        String dbPassword = "zouzou";

        Connection cn;
        try{
            //METHODE DE JAVA JDBC : A ADAPTER
            cn = DriverManager.getConnection("jdbc:sqlserver://" + dbIp + ";database=" + dbName + ";user=" + dbUser + ";password=" + dbPassword);
        } catch (Exception e){
            throw e;
        }
        return cn;
    }

    private static void closeConnection(Connection cn) throws SQLException{
        try {
            cn.close();
        } catch (SQLException e) {
            throw e;
        }
    }

    public static void refreshDB() throws SQLException {
        try {
            Connection cn = openConnection();
            //actions
            closeConnection(cn);
            Main.setAppInfos("Base locale rafraîchie");
            Log.i("debug_dev", "Refresh DB OK");
        }catch(Exception e){
            Main.setAppInfosError(e.getMessage());
            Log.i("debug_dev", "Refresh DB Fail");
        }
    }

    public static void updateDB() throws SQLException {
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

    /**
     *  Méthode pour mettre à jour les practiciens
     * @param id (le numéro d'identification du practicien)
     * @param sector (le secteur dans lequel exerce le practicien)
     * @param activity (l'activité que pratique le practicien)
     * @param activityPrecisions (des éventuelles précisions sur l'activité du practicien)
     * @throws SQLException
     */
    public static void updatePractitioner(int id, String sector, String activity, String activityPrecisions) throws SQLException{
        Connection cn = openConnection();
        Statement stmt;
        try{
            stmt = cn.createStatement();
            if(sector.equals("")){
                stmt.executeUpdate("UPDATE practitioner SET sector = "+sector+"WHERE id ="+id);
            }
            if(activity.equals("")){
                stmt.executeUpdate("UPDATE practitioner SET activity = "+activity+"WHERE id = "+id);
            }
            if(activityPrecisions.equals("")) {
                stmt.executeUpdate("UPDATE practitioner SET activityPrecisions = " + activityPrecisions + "WHERE id = " + id);
            }
        }
        catch (SQLException e){
            throw e;
        }
        finally {
            closeConnection(cn);
        }
    }

    /**
     * Méthode pour mettre à jour les opinions des practiciens
     * @param idPractitioner (le numéro d'identification du practicien)
     * @param idLabo (le numéro d'identification du laboratoire)
     * @param opinion (l'opinion qu'à le practicien d'un laboratroire)
     * @param comment (un éventuel commentaire sur l'opinion du practicien à propos du laboratoire)
     * @throws SQLException
     */
    public static void updateOpinion(int idPractitioner, int idLabo, int opinion, String comment, int participate, String participComment) throws SQLException {
        Connection cn = openConnection();
        Statement stmt;
        try{
                stmt = cn.createStatement();
                stmt.executeUpdate("UPDATE opinon SET opinion = " + opinion + " WHERE idPractioner = " + idPractitioner + " AND idLabo = " + idLabo);
                if (comment.equals("")) {
                    stmt.executeUpdate("UPDATE opinon SET comment = " + comment + " WHERE idPractioner = " + idPractitioner + " AND idLabo = " + idLabo);
                }
            if(participate == 1)
            {
                stmt.executeUpdate("UPDATE opinion SET participComment = "+participComment +"WHERE idPractioner = " + idPractitioner + " AND idLabo = " + idLabo);
            }
        }
        catch (SQLException e){
            throw e;
        }
        finally {
            closeConnection(cn);
        }

    }

    public static void update

   /* public static void updateKnowing(int idPractitioner, int idProduct,remplace le bit de SQL int knowing,)*/




}
