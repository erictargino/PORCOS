/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author Heverton
 */
public class PorcoEmBaia implements Comparable<PorcoEmBaia> {
    
    private int id;
    private int id_porco;
    private int id_baia;
   
            

    public PorcoEmBaia(int id, int id_porco, int id_baia) {
        this.id = id;
        this.id_porco = id_porco;
        this.id_baia = id_baia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_porco() {
        return id_porco;
    }

    public void setId_porco(int id_porco) {
        this.id_porco = id_porco;
    }

    public int getId_baia() {
        return id_baia;
    }

    public void setId_baia(int id_baia) {
        this.id_baia = id_baia;
    }

    @Override
    public int compareTo(PorcoEmBaia t) {
      
         throw new UnsupportedOperationException("Not supported yet.");
      
    }

   
    
}
