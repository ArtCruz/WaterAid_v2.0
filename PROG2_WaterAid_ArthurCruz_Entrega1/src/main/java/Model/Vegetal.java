/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Exception.CampoVazioException;

/**
 *
 * @author Usuário
 */
public class Vegetal extends Comida{
    public Vegetal() {
    }

    @Override
    public String toString() {
        return super.toString() + ", Detalhe Vegetal: "+getDetalheComida();
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
