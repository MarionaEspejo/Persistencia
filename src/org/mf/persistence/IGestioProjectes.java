package org.mf.persistence;

import java.util.List;
import org.milaifontanals.model.Projecte;
import org.milaifontanals.model.Rol;
import org.milaifontanals.model.Usuari;

public interface IGestioProjectes {
    
    List<Object> Login(String user, String password) throws GestioProjectesException;

    /* List<Projecte> GetProjectes(String session_id) throws GestioProjectesException;

    List<Tasca> GetTasquesAssignades(String session_id) throws GestioProjectesException;

    List<Tasca> GetDetallTasca(String session_id, int tasca_id) throws GestioProjectesException;

    List<Tasca> GetNotificacionsPendents(String session_id) throws GestioProjectesException;

    List<Usuari> LlistaUsuaris(String session_id) throws GestioProjectesException;
     */
    public List<Usuari> getLlistaUsuaris() throws GestioProjectesException;

    public List<Projecte> getLlistaProjectes(Usuari usuari) throws GestioProjectesException;

    public Usuari getUsuari(int id) throws GestioProjectesException;

    public Projecte getProjecte(int id) throws GestioProjectesException;

    public Rol getRol(int id) throws GestioProjectesException;

    public Rol getRolUsu(Projecte idProj, Usuari idUsu) throws GestioProjectesException;

    public int deleteUsuari(int id) throws GestioProjectesException;

    public int insertUsuari(Usuari usu) throws GestioProjectesException;

    public int updateUsuari(Usuari usu) throws GestioProjectesException;

    public List<Projecte> getLlistaProjectesNoAssignats(Usuari usuari) throws GestioProjectesException;

    public void desassignarProjecte(Usuari usu, Projecte proj, Rol rol) throws GestioProjectesException;

    public void assignarProjecte(Usuari usu, Projecte proj, Rol rol) throws GestioProjectesException;

    /*
    int NovaEntrada(String session_id, String novaEntrada, Estat estat, Usuari nouResponsable) throws GestioProjectesException;

    int NovaEntrada(String session_id, String novaEntrada, Usuari nouResponsable) throws GestioProjectesException;

    int NovaEntrada(String session_id, String novaEntrada, Estat estat) throws GestioProjectesException;

    int NovaEntrada(String session_id, String novaEntrada) throws GestioProjectesException;*/
    /**
     * Tanca la connexió amb el SGBD
     *
     * @throws GestioProjectesException en cas que es produeixi alguna excepció
     */
    void close() throws GestioProjectesException;

    /**
     * Tanca la transacció activa fent commit o rollback segons paràmetre
     *
     * @param typeClose r o R per rollback / c o C per commit
     */
    void closeTransaction(char typeClose) throws GestioProjectesException;

    /**
     * Tanca la capa de persistència, tancant la connexió amb la BD.
     *
     * @throws GestioProjectesException si hi ha algun problema en tancar la
     * connexió
     */
    public void closeCapa() throws GestioProjectesException;

    /**
     * Tanca la transacció activa validant els canvis a la BD.
     *
     * @throws GestioProjectesException si hi ha algun problema
     */
    public void commit() throws GestioProjectesException;

    /**
     * Tanca la transacció activa sense validar els canvis a la BD.
     *
     * @throws GestioProjectesException si hi ha algun problema
     */
    public void rollback() throws GestioProjectesException;

}
