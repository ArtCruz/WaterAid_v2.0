/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import DAO.ComidaDAO;
import Exception.CampoVazioException;
import Exception.ComidaRepetidaException;
import javax.swing.JOptionPane;

public abstract class Comida implements Comparable<Comida>{
    protected String nome;
    protected String tipoComida;
    protected String detalheComida;
    protected float relComidaAgua;
   
    public void setNome(String nome) throws CampoVazioException, ComidaRepetidaException{
        ComidaDAO comidaDAO = new ComidaDAO();
        for(Comida c : comidaDAO.retornarTodasComidas()){
            if(c.getNome().equals(nome)){
                throw new ComidaRepetidaException();
            }
        } 
        if(nome.isBlank()){
            throw new CampoVazioException();
        }
        this.nome = nome;
    }  
    
    public void setTipoComida(String tipoComida) throws CampoVazioException{
        if(tipoComida.isBlank()){
            throw new CampoVazioException();
        }
        this.tipoComida = tipoComida;
    }  

    public String getDetalheComida() {
        return detalheComida;
    }

    public void setDetalheComida(String detalheComida) throws CampoVazioException{
        if(detalheComida.isBlank()){
            throw new CampoVazioException();
        }       
        this.detalheComida = detalheComida;
    }
    
    
    public void setRelComidaAgua(float relComidaAgua) throws CampoVazioException{  
        if(relComidaAgua<0){
            JOptionPane.showMessageDialog(null, "Insira uma Comida Válida");
        }
        this.relComidaAgua = relComidaAgua;
    }

    public String getNome() {
        return nome;
    }

    public String getTipoComida() {
        return tipoComida;
    }

    public float getRelComidaAgua() {
        return relComidaAgua;
    }
    
    @Override
    public String toString() {
        return nome + ", Relação Comida Agua: " + relComidaAgua;
    }

    @Override
    public int compareTo(Comida o) {
        return this.nome.compareTo(o.nome);
    }
    
    
}
