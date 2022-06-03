package org.mf.persistence;

import java.util.List;
import org.milaifontanals.model.Entrada;
import org.milaifontanals.model.Estat;
import org.milaifontanals.model.Projecte;
import org.milaifontanals.model.Rol;
import org.milaifontanals.model.Tasca;
import org.milaifontanals.model.Usuari;
import org.milaifontanals.model.UsuariToken;

public interface IGestioProjectes {

    public UsuariToken Login(String user, String password) throws GestioProjectesException;

    public int ultimID() throws GestioProjectesException;

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

    public List<Rol> getRols() throws GestioProjectesException;

    public void desassignarProjecte(Usuari usu, Projecte proj, Rol rol) throws GestioProjectesException;

    public void assignarProjecte(Usuari usu, Projecte proj, Rol rol) throws GestioProjectesException;

    public List<Tasca> GetTasquesAssignades(Usuari usu) throws GestioProjectesException;

    public int getID(String login, String pwd) throws GestioProjectesException;

    public int getProjIDTasca(int id) throws GestioProjectesException;

    public List<Projecte> getProjectes() throws GestioProjectesException;

    public List<Tasca> getTasquesIDProj(int idProj) throws GestioProjectesException;

    public List<Entrada> getEntradaIDTasca(int idTask) throws GestioProjectesException;

    public List<Tasca> getTasquesIDProjTots(int idProj) throws GestioProjectesException;

    public List<Projecte> getProjecteFiltreNom(String nom) throws GestioProjectesException;

    public List<Estat> getEstats() throws GestioProjectesException;

    public List<Projecte> getLlistaProjectesTascaEstat(String nomEstat) throws GestioProjectesException;

    public int NovaEntrada(Entrada newEntrada, int idTask) throws GestioProjectesException;

    void close() throws GestioProjectesException;

    void closeTransaction(char typeClose) throws GestioProjectesException;

    public void closeCapa() throws GestioProjectesException;

    public void commit() throws GestioProjectesException;

    public void rollback() throws GestioProjectesException;

    public int getNumeroEntrada(int idTaca) throws GestioProjectesException;

    public Estat getEstat(String nomEstat) throws GestioProjectesException;

    public List<Projecte> getProjecteFiltreTextTasca(String testTask) throws GestioProjectesException;
}
