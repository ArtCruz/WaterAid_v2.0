package tests.TDD;

import Controller.RemoverPessoaController;
import DAO.PessoaDAO;
import DAO.RefeicaoDAO;
import Exception.*;
import Model.*;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PessoaRemoverControllerTest {
    public PessoaDAO pessoaDAO;

    public Pessoa criarPessoa(String nome, String cpf, int idade, String orientAlimentar, String tipoPessoa) throws CampoVazioException, CpfExistenteException, CpfInvalidoException, IdadeNegativaException {
        Pessoa pessoa = new Usuario();
        pessoa.setNome(nome);
        pessoa.setCpf(cpf);
        pessoa.setIdade(idade);
        pessoa.setOrientacaoAlimentar(orientAlimentar);
        pessoa.setTipoPessoa(tipoPessoa);
        PessoaDAO.pessoas.add(pessoa);
        return pessoa;
    }

    @BeforeEach
    public void setUp() {
        pessoaDAO = new PessoaDAO();
    }

    @Test
    public void RemoverPessoaNome() throws PesoComidaInvalidoException, CampoVazioException, IdadeNegativaException, CpfExistenteException, CpfInvalidoException, ComidaRepetidaException {
        //Criando Pessoa
        Pessoa pessoa = criarPessoa("Matheus Daora","95687234158",30,"Carnivoro","Usuario");

        pessoaDAO.adicionarPessoa(pessoa);

        Assert.assertFalse(pessoaDAO.retornarTodasPessoas().isEmpty());

        removerPessoaNomeTest(pessoa);

        Assert.assertTrue(pessoaDAO.retornarTodasPessoas().isEmpty());
    }

    public void removerPessoaNomeTest(Pessoa p){
        PessoaDAO pessoaDAO = new PessoaDAO();

        String nome = "Matheus Daora";

        if(p.getNome().equals(nome)){
            pessoaDAO.removerPessoa(p);
            System.out.println("Pessoa Removida com base no Nome");
        }else{
            System.out.println("Pessoa Não Removida");
        }
    }

    @Test
    public void RemoverPessoaOrientacaoAlimentar() throws PesoComidaInvalidoException, CampoVazioException, IdadeNegativaException, CpfExistenteException, CpfInvalidoException, ComidaRepetidaException {
        //Criando Pessoa
        Pessoa pessoa = criarPessoa("Matheus Daora","95687234158",30,"Carnivoro","Usuario");

        pessoaDAO.adicionarPessoa(pessoa);

        Assert.assertFalse(pessoaDAO.retornarTodasPessoas().isEmpty());

        removerPessoaOrientacaoAlimentarTest(pessoa);

        Assert.assertTrue(pessoaDAO.retornarTodasPessoas().isEmpty());
    }

    public void removerPessoaOrientacaoAlimentarTest(Pessoa p){
        PessoaDAO pessoaDAO = new PessoaDAO();

        String orientAlimentar = "Carnivoro";

        if(p.getOrientacaoAlimentar().equals(orientAlimentar)){
            pessoaDAO.removerPessoa(p);
            System.out.println("Pessoa Removida com base na Orientação Alimentar");
        }else{
            System.out.println("Pessoa Não Removida");
        }
    }

    @Test
    public void RemoverPessoaCPF() throws PesoComidaInvalidoException, CampoVazioException, IdadeNegativaException, CpfExistenteException, CpfInvalidoException, ComidaRepetidaException {
        //Criando Pessoa
        Pessoa pessoa = criarPessoa("Matheus Daora", "95687234158", 30, "Carnivoro", "Usuario");

        pessoaDAO.adicionarPessoa(pessoa);

        Assert.assertFalse(pessoaDAO.retornarTodasPessoas().isEmpty());

        removerPessoaCPFTest(pessoa);

        Assert.assertTrue(pessoaDAO.retornarTodasPessoas().isEmpty());
    }

    public void removerPessoaCPFTest(Pessoa p){

        String cpf = "95687234158";

        if(p.getCpf().equals(cpf)){
            pessoaDAO.removerPessoa(p);
            System.out.println("Pessoa Removida com base no CPF");
        }else{
            System.out.println("Pessoa Não Removida");
        }
    }

    @Test
    public void RemoverPessoaIdade() throws PesoComidaInvalidoException, CampoVazioException, IdadeNegativaException, CpfExistenteException, CpfInvalidoException, ComidaRepetidaException {
        //Criando Pessoa
        Pessoa pessoa = criarPessoa("Matheus Daora","95687234158",30,"Carnivoro","Usuario");

        pessoaDAO.adicionarPessoa(pessoa);

        Assert.assertFalse(pessoaDAO.retornarTodasPessoas().isEmpty());

        removerPessoaIdadeTest(pessoa);

        Assert.assertTrue(pessoaDAO.retornarTodasPessoas().isEmpty());
    }

    public void removerPessoaIdadeTest(Pessoa p){
        PessoaDAO pessoaDAO = new PessoaDAO();

        int idade = 30;

        if(p.getIdade() == idade){
            pessoaDAO.removerPessoa(p);
            System.out.println("Pessoa Removida com base na Idade");
        }else{
            System.out.println("Pessoa Não Removida");
        }
    }

    @Test
    public void RemoverPessoaTipoPessoa() throws PesoComidaInvalidoException, CampoVazioException, IdadeNegativaException, CpfExistenteException, CpfInvalidoException, ComidaRepetidaException {
        //Criando Pessoa
        Pessoa pessoa = criarPessoa("Matheus Daora","95687234158",30,"Carnivoro","Usuario");

        pessoaDAO.adicionarPessoa(pessoa);

        Assert.assertFalse(pessoaDAO.retornarTodasPessoas().isEmpty());

        removerPessoaTipoPessoaTest(pessoa);

        Assert.assertTrue(pessoaDAO.retornarTodasPessoas().isEmpty());
    }

    public void removerPessoaTipoPessoaTest(Pessoa p){
        PessoaDAO pessoaDAO = new PessoaDAO();

        String tipoPessoa = "Usuario";

        if(p.getTipoPessoa().equals(tipoPessoa)){
            pessoaDAO.removerPessoa(p);
            System.out.println("Pessoa Removida com base no Tipo Pessoa");
        }else{
            System.out.println("Pessoa Não Removida");
        }
    }

}
