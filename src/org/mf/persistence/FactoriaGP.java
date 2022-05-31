package org.mf.persistence;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FactoriaGP {

    private FactoriaGP() {

    }

    public static IGestioProjectes getGestorEmpresa(String nomCapa) throws GestioProjectesException {
        try {
            Class compo = Class.forName(nomCapa);
            IGestioProjectes cp = (IGestioProjectes) compo.newInstance();
            return cp;
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            throw new GestioProjectesException("Error en invocar getGestorEmpresa", ex);
        }
    }

    public static IGestioProjectes getGestorEmpresa(String nomCapa, String nomFitxerPropietatsCapa) throws GestioProjectesException {
        try {
            Class classe = Class.forName(nomCapa);
            Constructor con = classe.getConstructor(String.class);
            IGestioProjectes cp = (IGestioProjectes) con.newInstance(nomFitxerPropietatsCapa);
            return cp;
        } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            throw new GestioProjectesException("Error en invocar getGestorEmpresa",ex);
        }
    }
}
