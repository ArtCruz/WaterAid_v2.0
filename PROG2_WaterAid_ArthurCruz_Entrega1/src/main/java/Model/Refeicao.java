/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Exception.CampoVazioException;
import Exception.PesoComidaInvalidoException;

/**
 *
 * @author Usuário
 */
public class Refeicao{
    private String data;
    private String nome;
    private Pessoa pessoa;
    private Carne tipoCarne;
    private float pesoTipoCarne;
    private Grao tipoGrao;
    private float pesoTipoGrao;
    private Vegetal tipoVegetal;
    private float pesoTipoVegetal;
    private float impactoRef;

    public float getImpactoRef() {
        return impactoRef;
    }

    public void setImpactoRef(float impactoRef) {
        this.impactoRef = impactoRef;
    }

    public void setData(String data) throws CampoVazioException{
        if(data.isBlank()){
            throw new CampoVazioException();
        }
        this.data = data;        
    }   
    
    public void setNome(String nome) throws CampoVazioException{
        if(nome.isBlank()){
           throw new CampoVazioException();
        }
        this.nome= nome;
    }    

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    
    
    public String getData(){
        return data;
    }
    
    
    public void setTipoCarne(Carne tipoCarne){
        this.tipoCarne = tipoCarne;
    }    
    public void setPesoTipoCarne(float pesoTipoCarne) throws PesoComidaInvalidoException{
        if(pesoTipoCarne<0){
            throw new PesoComidaInvalidoException();
        }
        this.pesoTipoCarne = pesoTipoCarne;
    }
    
    public void setTipoGrao(Grao tipoGrao){
        this.tipoGrao = tipoGrao;
    }
    
    public void setPesoTipoGrao(float pesoTipoGrao) throws PesoComidaInvalidoException{
        if(pesoTipoGrao<0){
            throw new PesoComidaInvalidoException();
        }
        this.pesoTipoGrao = pesoTipoGrao;
    }
    
    public void setTipoVegetal(Vegetal tipoVegetal){
        this.tipoVegetal = tipoVegetal;
    }
    public void setPesoTipoVegetal(float pesoTipoVegetal) throws PesoComidaInvalidoException{
        if(pesoTipoVegetal<0){
            throw new PesoComidaInvalidoException();
        }     
        this.pesoTipoVegetal = pesoTipoVegetal;
    }
    
    
    
    public String getNome(){
        return nome;
    }

    public Carne getTipoCarne() {
        return tipoCarne;
    }

    public float getPesoTipoCarne() {
        return pesoTipoCarne;
    }

    public Grao getTipoGrao() {
        return tipoGrao;
    }

    public float getPesoTipoGrao() {
        return pesoTipoGrao;
    }

    public Vegetal getTipoVegetal() {
        return tipoVegetal;
    }

    public float getPesoTipoVegetal() {
        return pesoTipoVegetal;
    }
    
    @Override
    public String toString(){
        return "Data: "+data+", Pessoa: ("+pessoa.getNome()+"), Nome Refeição: "+nome+", Tipo Carne: "+tipoCarne+", Peso: "+pesoTipoCarne
                +", Tipo Grão: "+tipoGrao+", Peso: "+pesoTipoGrao+", Tipo Vegetal: "+tipoVegetal+", Peso: "+pesoTipoVegetal
                +", Impac. Ref.: "+impactoRef;
    }  
    
}
