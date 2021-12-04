
package model;

public class Nota {
    
    
    private double valor_nota;
    
    
    public Nota(){
        
    }
    
    public Nota(double valor_nota){
        this.valor_nota = valor_nota;
    }

    public double getValor_nota() {
        return valor_nota;
    }

    public void setValor_nota(double valor_nota) {
        this.valor_nota = valor_nota;
    }
    
    public void regNota(){
        System.out.println("Nota Registrada");
    }
    
    
    
    
}
