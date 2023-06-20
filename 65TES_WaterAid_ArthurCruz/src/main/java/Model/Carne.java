/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Exception.CampoVazioException;
import java.util.ArrayList;

/**
 *
 * @author Usuário
 */
public class Carne extends Comida{
    
    public Carne() {
        
    }

    @Override
    public String toString() {
        return super.toString() + ", Detalhe Carne: "+getDetalheComida();
    }   

    @Override
    public void setDetalheComida(String detalheComida) throws CampoVazioException{
        if(detalheComida.isBlank()){
            throw new CampoVazioException();
        }       
        this.detalheComida = detalheComida;
    }

    public String getDetalheComida() {
        return detalheComida;
    }
    
    
}
