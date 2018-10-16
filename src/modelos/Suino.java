 
package modelos;

import java.sql.Date;

/**
 *
 * @author Aluno
 */
public class Suino implements Comparable<Suino> {
    
    private int id;
    private String nome;
    private Date data_nasc;
    private Date data_aqui;

    public Suino(int id, String nome, Date data_nasc, Date data_aqui) {
        this.id = id;
        this.nome = nome;
        this.data_nasc = data_nasc;
        this.data_aqui = data_aqui;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(Date data_nasc) {
        this.data_nasc = data_nasc;
    }

    public Date getData_aqui() {
        return data_aqui;
    }

    public void setData_aqui(Date data_aqui) {
        this.data_aqui = data_aqui;
    }

    @Override
    public int compareTo(Suino t) {
        return this.getNome().compareTo(t.getNome());
    }
  
}
