/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import DAO.PessoaDAO;
import Exception.CampoVazioException;
import Exception.CpfExistenteException;
import Exception.CpfInvalidoException;
import Exception.IdadeNegativaException;
        
public abstract class Pessoa implements Comparable<Pessoa>{
    protected String nome;
    protected String cpf;
    protected int idade;
    protected String orientacaoAlimentar;
    protected String tipoPessoa;
    protected int identificador;
    protected float impacGeral = 0;
    protected static int geradorID = 0;
    
    public Pessoa(){
        this.identificador = gerarID();//Quando eu tento criar alguma pessoa, só que ela possui alguma exceção o gerador ainda conta
    }
    
    private static int gerarID(){
        return ++geradorID;
    }

    public float getImpacGeral() {
        return impacGeral;
    }
       
    public void adicionarImpactoGeral(float impacGeral){
        this.impacGeral += impacGeral;
    }

    public void setNome(String nome) throws CampoVazioException{
        if(nome.isBlank()){
            throw new CampoVazioException();
        }
        this.nome = nome;
    }
    
    public void setIdade(int idade) throws IdadeNegativaException{
        if(idade<0){
            throw new IdadeNegativaException();
        }
        this.idade = idade;
    }
            
    public void setCpf(String cpf) throws CpfInvalidoException, CpfExistenteException, CampoVazioException{
        if(cpf.isBlank()){
            throw new CampoVazioException();
        }
        if(cpf.length() < 11 || cpf.length()>11){
            throw new CpfInvalidoException();
        }
        
        PessoaDAO pessoaDAO = new PessoaDAO();
        for(Pessoa p : pessoaDAO.retornarTodasPessoas()){
            if(p.getCpf().equals(cpf)){
                throw new CpfExistenteException();
            }
        } 
        this.cpf = cpf;
    }
    public void setOrientacaoAlimentar(String orientacaoAlimentar) throws CampoVazioException{
        if(orientacaoAlimentar.isBlank()){
            throw new CampoVazioException();
        }
        this.orientacaoAlimentar = orientacaoAlimentar;
    }
    
    public void setTipoPessoa(String tipoPessoa) throws CampoVazioException{
        if(tipoPessoa.isBlank()){
            throw new CampoVazioException();
        }
        this.tipoPessoa = tipoPessoa;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public int getIdade() {
        return idade;
    }

    public String getOrientacaoAlimentar() {
        return orientacaoAlimentar;
    }
    
    public String getTipoPessoa(){
        return this.tipoPessoa;
    }
    
    
    public String toString(){
        return "Nome: "+nome+", ID: "+identificador+", CPF: "+cpf+
                ", Idade: "+idade+", Orientação Alimentar: "+orientacaoAlimentar+", Impacto Geral: "+impacGeral;
    }
    
    @Override
    public int compareTo(Pessoa o) {
        return this.nome.compareTo(o.nome);
    }
}
