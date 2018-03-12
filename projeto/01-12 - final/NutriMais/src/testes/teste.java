/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import beans.Dieta;
import controladores.DietaJpaController;
import javax.persistence.Persistence;

/**
 *
 * @author Leonardo Vasconcelos
 */
public class teste {
    public static void main(String[] args) {
        // TODO code application logic here
        DietaJpaController dietaDAO = new DietaJpaController(Persistence.createEntityManagerFactory("NutriMaisPU"));
        Dieta dS = dietaDAO.findDietaByIdDia(3, "Segunda");
        System.out.println(dS.getDia() + dS.getCafeDaManha());
        
        Dieta dT = dietaDAO.findDietaByIdDia(3, "Terça");
        System.out.println(dT.getDia() + dT.getCafeDaManha());
    }
}
