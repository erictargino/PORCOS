package modelos;
/**
 *
 * @author Aluno
 */
public class Baia implements Comparable<Baia>{
    
    private int id;
    private double tamanho;
    private String baiaLimpa;
    private Suino suinos;

    public Baia(int id, double tamanho,String baiaLimpa) {
        this.id = id;
        this.tamanho = tamanho;
        this.baiaLimpa = baiaLimpa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTamanho() {
        return tamanho;
    }

    public void setTamanho(double tamanho) {
        this.tamanho = tamanho;
    }

    public String isBaiaLimpa() {
        return baiaLimpa;
    }

    public void setBaiaLimpa(String baiaLimpa) {
        this.baiaLimpa = baiaLimpa;
    }

    @Override
    public int compareTo(Baia t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
