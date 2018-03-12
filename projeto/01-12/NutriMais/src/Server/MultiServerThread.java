/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import beans.Antropometria;
import beans.Dieta;
import beans.Paciente;
import beans.PassaDados;
import beans.Usuario;
import controladores.AntropometriaJpaController;
import controladores.DietaJpaController;
import controladores.PacienteJpaController;
import controladores.UsuarioJpaController;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

/**
 *
 * @author Leonardo Vasconcelos
 */
public class MultiServerThread extends Thread {

    /*
    MultiServerThread(Socket accept) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    */  
    
    private Socket socket = null;
    private UsuarioJpaController usuarioDao;
    private PacienteJpaController pacDao;
    private AntropometriaJpaController antroDao;
    private DietaJpaController dietaDao;
    public MultiServerThread(Socket socket) {
        super("MultiServerThread");
        this.socket = socket;
        usuarioDao = new UsuarioJpaController(Persistence.createEntityManagerFactory("NutriMaisPU"));
        pacDao = new PacienteJpaController(Persistence.createEntityManagerFactory("NutriMaisPU"));
        antroDao = new AntropometriaJpaController(Persistence.createEntityManagerFactory("NutriMaisPU"));
        dietaDao = new DietaJpaController(Persistence.createEntityManagerFactory("NutriMaisPU"));
    }
    
    @Override
    public void run() {

        try {
            DataOutputStream outFromServer = new DataOutputStream(socket.getOutputStream());
            DataInputStream inFromClient = new DataInputStream(socket.getInputStream());
            DataOutputStream outFromServer2 = new DataOutputStream(socket.getOutputStream());
            ObjectInputStream inFromClient2 = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream outFromServer3 = new ObjectOutputStream(socket.getOutputStream());
            ObjectOutputStream outFromServer4 = new ObjectOutputStream(socket.getOutputStream());
            //try
            //{
                System.out.println("veio 1");
                if(inFromClient.read() == 1)
                {
                    System.out.println("veio 2");
                    outFromServer.writeBoolean(true);
                    
                    Usuario us = new Usuario();
                    Paciente pa = new Paciente();
                    Antropometria antro = new Antropometria();
                    PassaDados p = new PassaDados();
                    PassaDados pd2 = new PassaDados();
                    
                    PassaDados[] pd3 = new PassaDados[7];
                    List<Dieta> di = new ArrayList();
                    try{
                        Object o = inFromClient2.readObject();
                        p = ((PassaDados) o);
                    }catch(Exception e)
                    {
                        System.out.println("\nErro: " + e);
                    }
                    if(usuarioDao.conta(p.getDado1(), p.getDado2())>0)  
                    {
                        System.out.println("veio 3");
                        pa = usuarioDao.acha(p.getDado1(), p.getDado2());
                        antro = antroDao.findAntropometria(antroDao.ultimaAntro(pa)); 
                        outFromServer2.writeBoolean(true);
                        pd2.setDado1(pa.getNome());
                        pd2.setDado2(pa.getMotivo());
                        pd2.setDado3(antro.getClassificacaoAdequacaoPeso());
                        pd2.setDado4(String.valueOf(antro.getPorcentagemGordura()));
                        pd2.setDado5(String.valueOf(antro.getPesoGordura()));
                        pd2.setDado6(String.valueOf(antro.getPesoMassaMagra()));
                        pd2.setDado7(String.valueOf(antro.getPeso()));
                        pd2.setDado8(String.valueOf(antro.getPesoIdeal()));   
                        outFromServer3.writeObject(pd2); 
                        System.out.println("veio 4: "); 
                        
                        di.add(dietaDao.findDietaByIdDia(dietaDao.maxId(pa),"Segunda"));
                        di.add(dietaDao.findDietaByIdDia(dietaDao.maxId(pa),"Terça"));
                        di.add(dietaDao.findDietaByIdDia(dietaDao.maxId(pa),"Quarta")); 
                        di.add(dietaDao.findDietaByIdDia(dietaDao.maxId(pa),"Quinta"));
                        di.add(dietaDao.findDietaByIdDia(dietaDao.maxId(pa),"Sexta"));
                        di.add(dietaDao.findDietaByIdDia(dietaDao.maxId(pa),"Sabado"));
                        di.add(dietaDao.findDietaByIdDia(dietaDao.maxId(pa),"Domingo"));
                         System.out.println("veio 5: "); 
                        for(int n=0;n<7;n++)
                        {
                            pd3[n] = new PassaDados();
                            pd3[n].setDado1(di.get(n).getCafeDaManha());
                            pd3[n].setDado2(di.get(n).getLancheDaManha());
                            pd3[n].setDado3(di.get(n).getAlmoco());
                            pd3[n].setDado4(di.get(n).getLancheDaTarde());
                            pd3[n].setDado5(di.get(n).getJantar());
                            pd3[n].setDado6(di.get(n).getCeia());
                            pd3[n].setDado7("");
                            pd3[n].setDado7("");
                            System.out.println("volta #" + n);
                        }
                        

                        System.out.println("veio 6: "); 
                        outFromServer4.writeObject(pd3); 
                        
                    }
                    else
                    {
                        System.out.println("veio e deu erro");
                        outFromServer2.writeBoolean(false);
                    }
                }
                
            //}
            //catch(Exception e)
            //{
           //     System.out.println("\nErro de IO: " + e.getMessage());
            //}
            
            inFromClient2.close();
            //outFromServer2.close();
            inFromClient.close();
            outFromServer.close();
            socket.close();
        } catch (IOException e) {
            System.err.println("Erro: " + e.getMessage());
        }
        /*
        catch (ClassNotFoundException ex) {
            Logger.getLogger(MultiServerThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
    }
    
}
