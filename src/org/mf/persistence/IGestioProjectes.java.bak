package org.mf.persistence;

import java.util.List;
import org.mf.classes.Estat;
import org.mf.classes.Projecte;
import org.mf.classes.Tasca;
import org.mf.classes.Usuari;

public interface IGestioProjectes {

    List<Object> Login(String user, String password) throws GestioProjectesException;

    List<Projecte> GetProjectes(String session_id) throws GestioProjectesException;

    List<Tasca> GetTasquesAssignades(String session_id) throws GestioProjectesException;

    List<Tasca> GetDetallTasca(String session_id, int tasca_id) throws GestioProjectesException;

    List<Tasca> GetNotificacionsPendents(String session_id) throws GestioProjectesException;

    List<Usuari> LlistaUsuaris(String session_id) throws GestioProjectesException;

    int NovaEntrada(String session_id, String novaEntrada, Estat estat, Usuari nouResponsable) throws GestioProjectesException;

    int NovaEntrada(String session_id, String novaEntrada, Usuari nouResponsable) throws GestioProjectesException;

    int NovaEntrada(String session_id, String novaEntrada, Estat estat) throws GestioProjectesException;

    int NovaEntrada(String session_id, String novaEntrada) throws GestioProjectesException;

}
