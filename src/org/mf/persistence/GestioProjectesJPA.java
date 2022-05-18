package org.mf.persistence;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.mf.classes.Estat;
import org.mf.classes.Projecte;
import org.mf.classes.Tasca;
import org.mf.classes.Usuari;

public class GestioProjectesJPA implements IGestioProjectes {

    private EntityManager em;

    /**
     * Constructor que estableix connexió amb el servidor a partir de les dades
     * informades en fitxer de propietats de nom EPSedna.properties.
     *
     * @throws GestioProjectesException si hi ha algun problema en el fitxer de
     * propietats o en establir la connexió
     */
    public GestioProjectesJPA() throws GestioProjectesException {
        this("GestioProjectesJPA.properties");
    }

    /**
     * Constructor que estableix connexió amb el servidor a partir de les dades
     * informades en fitxer de propietats, i en cas de ser null cercarà el
     * fitxer de nom EPJPA.properties.
     *
     * @param nomFitxerPropietats
     * @throws GestioProjectesException si hi ha algun problema en el fitxer de
     * propietats o en establir la connexió
     */
    public GestioProjectesJPA(String nomFitxerPropietats) throws GestioProjectesException {
        if (nomFitxerPropietats == null) {
            nomFitxerPropietats = "GestioProjectesJPA.properties";
        }
        Properties props = new Properties();
        try {
            props.load(new FileReader(nomFitxerPropietats));
        } catch (FileNotFoundException ex) {
            throw new GestioProjectesException("No es troba fitxer de propietats", ex);
        } catch (IOException ex) {
            throw new GestioProjectesException("Error en carregar fitxer de propietats", ex);
        }

        String up = props.getProperty("up");
        if (up == null) {
            throw new GestioProjectesException("Fitxer de propietats no conté propietat obligatòria <up>");
        }
        props.remove(up);

        EntityManagerFactory emf = null;
        try {
            emf = Persistence.createEntityManagerFactory(up, props);
            em = emf.createEntityManager();
        } catch (Exception ex) {
            if (emf != null) {
                emf.close();
            }
            throw new GestioProjectesException("Error en crear EntityManagerFactory o EntityManager", ex);
        }

    }

    @Override
    public List<Object> Login(String user, String password) throws GestioProjectesException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Projecte> GetProjectes(String session_id) throws GestioProjectesException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Tasca> GetTasquesAssignades(String session_id) throws GestioProjectesException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Tasca> GetDetallTasca(String session_id, int tasca_id) throws GestioProjectesException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Tasca> GetNotificacionsPendents(String session_id) throws GestioProjectesException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Usuari> LlistaUsuaris(String session_id) throws GestioProjectesException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int NovaEntrada(String session_id, String novaEntrada, Estat estat, Usuari nouResponsable) throws GestioProjectesException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int NovaEntrada(String session_id, String novaEntrada, Usuari nouResponsable) throws GestioProjectesException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int NovaEntrada(String session_id, String novaEntrada, Estat estat) throws GestioProjectesException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int NovaEntrada(String session_id, String novaEntrada) throws GestioProjectesException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Tanca la capa de persistència, tancant la connexió amb la BD.
     *
     * @throws GestioProjectesException si hi ha algun problema en tancar la
     * connexió
     */
    @Override
    public void closeCapa() throws GestioProjectesException {
        if (em != null) {
            EntityManagerFactory emf = null;
            try {
                emf = em.getEntityManagerFactory();
                em.close();
            } catch (Exception ex) {
                throw new GestioProjectesException("Error en tancar la connexió", ex);
            } finally {
                em = null;
                if (emf != null) {
                    emf.close();
                }
            }
        }
    }

    /**
     * Tanca la transacció activa validant els canvis a la BD.
     *
     * @throws GestioProjectesException si hi ha algun problema
     */
    @Override
    public void commit() throws GestioProjectesException {
        try {
            if (!em.getTransaction().isActive()) {
                em.getTransaction().begin();
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            throw new GestioProjectesException("Error en fer commit.", ex);
        }
    }

    /**
     * Tanca la transacció activa sense validar els canvis a la BD.
     *
     * @throws GestioProjectesException si hi ha algun problema
     */
    @Override
    public void rollback() throws GestioProjectesException {
        try {
            if (!em.getTransaction().isActive()) {
                em.getTransaction().begin();
            }
            em.getTransaction().rollback();
        } catch (Exception ex) {
            throw new GestioProjectesException("Error en fer rollback.", ex);
        }
    }

    @Override
    public void close() throws GestioProjectesException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Tanca la transacció activa fent commit o rollback segons paràmetre
     *
     * @param typeClose r o R per rollback / c o C per commit
     */
    @Override
    public void closeTransaction(char typeClose) throws GestioProjectesException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
