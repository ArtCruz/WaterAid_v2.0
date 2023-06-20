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

public class PessoaRefeicaoRemoverControllerTest {

    public Pessoa pessoa1;
    public PessoaDAO pessoaDAO;
    public RefeicaoDAO refeicaoDAO;
    public List<Refeicao> refeicoes;

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

    private Carne criarCarne(String tipoComida, String nome, float relComidaAgua, String detalheComida) throws CampoVazioException, ComidaRepetidaException {
        Carne carne = new Carne();
        carne.setTipoComida(tipoComida);
        carne.setNome(nome);
        carne.setRelComidaAgua(relComidaAgua);
        carne.setDetalheComida(detalheComida);

        return carne;
    }

    private Grao criarGrao(String tipoComida, String nome, float relComidaAgua, String detalheComida) throws CampoVazioException, ComidaRepetidaException {
        Grao grao = new Grao();
        grao.setTipoComida(tipoComida);
        grao.setNome(nome);
        grao.setRelComidaAgua(relComidaAgua);
        grao.setDetalheComida(detalheComida);
        return grao;
    }

    private Vegetal criarVegetal(String tipoComida, String nome, float relComidaAgua, String detalheComida) throws CampoVazioException, ComidaRepetidaException {
        Vegetal vegetal = new Vegetal();
        vegetal.setTipoComida(tipoComida);
        vegetal.setNome(nome);
        vegetal.setRelComidaAgua(relComidaAgua);
        vegetal.setDetalheComida(detalheComida);
        return vegetal;
    }

    private Refeicao criarRefeicao(String data, String nomeRefeicao, Pessoa pessoa,Carne tipoCarne, Grao tipoGrao, Vegetal tipoVegetal, float pesoTipoCarne, float pesoTipoGrao, float pesoTipoVegetal) throws CampoVazioException, PesoComidaInvalidoException {
        Refeicao refeicao = new Refeicao();
        refeicao.setData(data);
        refeicao.setNome(nomeRefeicao);
        refeicao.setPessoa(pessoa);
        refeicao.setTipoCarne(tipoCarne);
        refeicao.setTipoGrao(tipoGrao);
        refeicao.setTipoVegetal(tipoVegetal);
        refeicao.setPesoTipoCarne(pesoTipoCarne);
        refeicao.setPesoTipoGrao(pesoTipoGrao);
        refeicao.setPesoTipoVegetal(pesoTipoVegetal);
        return refeicao;
    }

    @BeforeEach
    public void setUp() {
        pessoaDAO = new PessoaDAO(); // Cria instância
        refeicaoDAO = new RefeicaoDAO(); // Cria instância
        refeicoes = new ArrayList<>();
    }

    @Test
    public void RemoverPessoaNome() throws PesoComidaInvalidoException, CampoVazioException, IdadeNegativaException, CpfExistenteException, CpfInvalidoException, ComidaRepetidaException {
        //Criando Pessoa
        Pessoa pessoa = criarPessoa("Matheus Daora","95687234158",30,"Carnivoro","Usuario");

        //Criando Comidas
        Carne cQueijo = criarCarne("Carne", "Queijo", 5.06f, "Uso de Técnicas Nocivas");
        Grao gArroz = criarGrao("Grão", "Arroz", 2.5f, "Uso de Técnicas Nocivas");
        Vegetal vBatata = criarVegetal("Vegetal", "Batata", 0.3f, "Uso de Técnicas Nocivas");

        Carne cAves = criarCarne("Carne", "Aves", 4.34f, "100% Natural / Orgânico");
        Grao gGraoBico = criarGrao("Grão", "Grão de Bico", 4.2f, "Uso de Técnicas Nocivas");
        Vegetal vAlface = criarVegetal("Vegetal", "Alface", 0.24f, "100% Natural / Orgânico");

        Carne cPorco = criarCarne("Carne", "Porco", 6f, "Uso de Técnicas Nocivas");
        Grao gMilho = criarGrao("Grão", "Milho", 1.2f, "100% Natural / Orgânico");
        Vegetal vTomate = criarVegetal("Vegetal", "Tomate", 0.2f, "Uso de Técnicas Nocivas");

        //Criando Refeições
        Refeicao refeicao1 = criarRefeicao("15/09/2023", "Café da Tarde", pessoa, cQueijo, gArroz, vBatata, 300, 200, 150);
        Refeicao refeicao2 = criarRefeicao("15/09/2023", "Almoço", pessoa, cAves, gGraoBico, vAlface, 300, 200, 150);
        Refeicao refeicao3 = criarRefeicao("15/09/2023", "Café da Manhã", pessoa, cPorco, gMilho, vTomate, 150, 100, 50);

        pessoaDAO.adicionarPessoa(pessoa);

        refeicaoDAO.adicionarRefeicao(refeicao1);
        refeicaoDAO.adicionarRefeicao(refeicao2);
        refeicaoDAO.adicionarRefeicao(refeicao3);

        Assert.assertFalse(pessoaDAO.retornarTodasPessoas().isEmpty());
        Assert.assertFalse(refeicaoDAO.recuperarTodasRefeicoes().isEmpty());

        removerPessoaNomeTest(pessoa);

        Assert.assertTrue(pessoaDAO.retornarTodasPessoas().isEmpty());
        Assert.assertTrue(refeicaoDAO.recuperarTodasRefeicoes().isEmpty());
    }

    public void removerPessoaNomeTest(Pessoa p){
        PessoaDAO pessoaDAO = new PessoaDAO();
        RefeicaoDAO refeicaoDAO = new RefeicaoDAO();

        if(RefeicaoDAO.refeicoes.size() == 0){
            System.out.println( "Nenhuma Refeição Cadastrada");
        }else{
            Iterator<Refeicao> iterator = RefeicaoDAO.refeicoes.iterator();
            while (iterator.hasNext()) {
                Refeicao r = iterator.next();
                if (r.getPessoa().getNome().equals(p.getNome())) {
                    iterator.remove();
                    refeicaoDAO.removerRefeicao(r);
                }
            }
            pessoaDAO.removerPessoa(p);
        }
    }

    @Test
    public void RemoverPessoaOrientacaoAlimentar() throws PesoComidaInvalidoException, CampoVazioException, IdadeNegativaException, CpfExistenteException, CpfInvalidoException, ComidaRepetidaException {
        //Criando Pessoa
        Pessoa pessoa = criarPessoa("Matheus Daora","95687234158",30,"Carnivoro","Usuario");

        //Criando Comidas
        Carne cQueijo = criarCarne("Carne", "Queijo", 5.06f, "Uso de Técnicas Nocivas");
        Grao gArroz = criarGrao("Grão", "Arroz", 2.5f, "Uso de Técnicas Nocivas");
        Vegetal vBatata = criarVegetal("Vegetal", "Batata", 0.3f, "Uso de Técnicas Nocivas");

        Carne cAves = criarCarne("Carne", "Aves", 4.34f, "100% Natural / Orgânico");
        Grao gGraoBico = criarGrao("Grão", "Grão de Bico", 4.2f, "Uso de Técnicas Nocivas");
        Vegetal vAlface = criarVegetal("Vegetal", "Alface", 0.24f, "100% Natural / Orgânico");

        Carne cPorco = criarCarne("Carne", "Porco", 6f, "Uso de Técnicas Nocivas");
        Grao gMilho = criarGrao("Grão", "Milho", 1.2f, "100% Natural / Orgânico");
        Vegetal vTomate = criarVegetal("Vegetal", "Tomate", 0.2f, "Uso de Técnicas Nocivas");

        //Criando Refeições
        Refeicao refeicao1 = criarRefeicao("15/09/2023", "Café da Tarde", pessoa, cQueijo, gArroz, vBatata, 300, 200, 150);
        Refeicao refeicao2 = criarRefeicao("15/09/2023", "Almoço", pessoa, cAves, gGraoBico, vAlface, 300, 200, 150);
        Refeicao refeicao3 = criarRefeicao("15/09/2023", "Café da Manhã", pessoa, cPorco, gMilho, vTomate, 150, 100, 50);

        pessoaDAO.adicionarPessoa(pessoa);

        refeicaoDAO.adicionarRefeicao(refeicao1);
        refeicaoDAO.adicionarRefeicao(refeicao2);
        refeicaoDAO.adicionarRefeicao(refeicao3);

        Assert.assertFalse(pessoaDAO.retornarTodasPessoas().isEmpty());
        Assert.assertFalse(refeicaoDAO.recuperarTodasRefeicoes().isEmpty());

        removerPessoaOrientacaoAlimentarTest(pessoa);

        Assert.assertTrue(pessoaDAO.retornarTodasPessoas().isEmpty());
        Assert.assertTrue(refeicaoDAO.recuperarTodasRefeicoes().isEmpty());
    }

    public void removerPessoaOrientacaoAlimentarTest(Pessoa p){
        PessoaDAO pessoaDAO = new PessoaDAO();
        RefeicaoDAO refeicaoDAO = new RefeicaoDAO();

        if(RefeicaoDAO.refeicoes.size() == 0){
            System.out.println( "Nenhuma Refeição Cadastrada");
        }else{
            Iterator<Refeicao> iterator = RefeicaoDAO.refeicoes.iterator();
            while (iterator.hasNext()) {
                Refeicao r = iterator.next();
                if (r.getPessoa().getOrientacaoAlimentar().equals(p.getOrientacaoAlimentar())) {
                    iterator.remove();
                    refeicaoDAO.removerRefeicao(r);
                }
            }
            pessoaDAO.removerPessoa(p);
        }
    }

    @Test
    public void RemoverPessoaCPF() throws PesoComidaInvalidoException, CampoVazioException, IdadeNegativaException, CpfExistenteException, CpfInvalidoException, ComidaRepetidaException {
        //Criando Pessoa
        Pessoa pessoa = criarPessoa("Matheus Daora","95687234158",30,"Carnivoro","Usuario");

        //Criando Comidas
        Carne cQueijo = criarCarne("Carne", "Queijo", 5.06f, "Uso de Técnicas Nocivas");
        Grao gArroz = criarGrao("Grão", "Arroz", 2.5f, "Uso de Técnicas Nocivas");
        Vegetal vBatata = criarVegetal("Vegetal", "Batata", 0.3f, "Uso de Técnicas Nocivas");

        Carne cAves = criarCarne("Carne", "Aves", 4.34f, "100% Natural / Orgânico");
        Grao gGraoBico = criarGrao("Grão", "Grão de Bico", 4.2f, "Uso de Técnicas Nocivas");
        Vegetal vAlface = criarVegetal("Vegetal", "Alface", 0.24f, "100% Natural / Orgânico");

        Carne cPorco = criarCarne("Carne", "Porco", 6f, "Uso de Técnicas Nocivas");
        Grao gMilho = criarGrao("Grão", "Milho", 1.2f, "100% Natural / Orgânico");
        Vegetal vTomate = criarVegetal("Vegetal", "Tomate", 0.2f, "Uso de Técnicas Nocivas");

        //Criando Refeições
        Refeicao refeicao1 = criarRefeicao("15/09/2023", "Café da Tarde", pessoa, cQueijo, gArroz, vBatata, 300, 200, 150);
        Refeicao refeicao2 = criarRefeicao("15/09/2023", "Almoço", pessoa, cAves, gGraoBico, vAlface, 300, 200, 150);
        Refeicao refeicao3 = criarRefeicao("15/09/2023", "Café da Manhã", pessoa, cPorco, gMilho, vTomate, 150, 100, 50);

        pessoaDAO.adicionarPessoa(pessoa);

        refeicaoDAO.adicionarRefeicao(refeicao1);
        refeicaoDAO.adicionarRefeicao(refeicao2);
        refeicaoDAO.adicionarRefeicao(refeicao3);

        Assert.assertFalse(pessoaDAO.retornarTodasPessoas().isEmpty());
        Assert.assertFalse(refeicaoDAO.recuperarTodasRefeicoes().isEmpty());

        removerPessoaCPFTest(pessoa);

        Assert.assertTrue(pessoaDAO.retornarTodasPessoas().isEmpty());
        Assert.assertTrue(refeicaoDAO.recuperarTodasRefeicoes().isEmpty());
    }

    public void removerPessoaCPFTest(Pessoa p){
        PessoaDAO pessoaDAO = new PessoaDAO();
        RefeicaoDAO refeicaoDAO = new RefeicaoDAO();

        if(RefeicaoDAO.refeicoes.size() == 0){
            System.out.println( "Nenhuma Refeição Cadastrada");
        }else{
            Iterator<Refeicao> iterator = RefeicaoDAO.refeicoes.iterator();
            while (iterator.hasNext()) {
                Refeicao r = iterator.next();
                if (r.getPessoa().getCpf().equals(p.getCpf())) {
                    iterator.remove();
                    refeicaoDAO.removerRefeicao(r);
                }
            }
            pessoaDAO.removerPessoa(p);
        }
    }

    @Test
    public void RemoverPessoaIdade() throws PesoComidaInvalidoException, CampoVazioException, IdadeNegativaException, CpfExistenteException, CpfInvalidoException, ComidaRepetidaException {
        //Criando Pessoa
        Pessoa pessoa = criarPessoa("Matheus Daora","95687234158",30,"Carnivoro","Usuario");

        //Criando Comidas
        Carne cQueijo = criarCarne("Carne", "Queijo", 5.06f, "Uso de Técnicas Nocivas");
        Grao gArroz = criarGrao("Grão", "Arroz", 2.5f, "Uso de Técnicas Nocivas");
        Vegetal vBatata = criarVegetal("Vegetal", "Batata", 0.3f, "Uso de Técnicas Nocivas");

        Carne cAves = criarCarne("Carne", "Aves", 4.34f, "100% Natural / Orgânico");
        Grao gGraoBico = criarGrao("Grão", "Grão de Bico", 4.2f, "Uso de Técnicas Nocivas");
        Vegetal vAlface = criarVegetal("Vegetal", "Alface", 0.24f, "100% Natural / Orgânico");

        Carne cPorco = criarCarne("Carne", "Porco", 6f, "Uso de Técnicas Nocivas");
        Grao gMilho = criarGrao("Grão", "Milho", 1.2f, "100% Natural / Orgânico");
        Vegetal vTomate = criarVegetal("Vegetal", "Tomate", 0.2f, "Uso de Técnicas Nocivas");

        //Criando Refeições
        Refeicao refeicao1 = criarRefeicao("15/09/2023", "Café da Tarde", pessoa, cQueijo, gArroz, vBatata, 300, 200, 150);
        Refeicao refeicao2 = criarRefeicao("15/09/2023", "Almoço", pessoa, cAves, gGraoBico, vAlface, 300, 200, 150);
        Refeicao refeicao3 = criarRefeicao("15/09/2023", "Café da Manhã", pessoa, cPorco, gMilho, vTomate, 150, 100, 50);

        pessoaDAO.adicionarPessoa(pessoa);

        refeicaoDAO.adicionarRefeicao(refeicao1);
        refeicaoDAO.adicionarRefeicao(refeicao2);
        refeicaoDAO.adicionarRefeicao(refeicao3);

        Assert.assertFalse(pessoaDAO.retornarTodasPessoas().isEmpty());
        Assert.assertFalse(refeicaoDAO.recuperarTodasRefeicoes().isEmpty());

        removerPessoaIdadeTest(pessoa);

        Assert.assertTrue(pessoaDAO.retornarTodasPessoas().isEmpty());
        Assert.assertTrue(refeicaoDAO.recuperarTodasRefeicoes().isEmpty());
    }

    public void removerPessoaIdadeTest(Pessoa p){
        PessoaDAO pessoaDAO = new PessoaDAO();
        RefeicaoDAO refeicaoDAO = new RefeicaoDAO();

        if(RefeicaoDAO.refeicoes.size() == 0){
            System.out.println( "Nenhuma Refeição Cadastrada");
        }else{
            Iterator<Refeicao> iterator = RefeicaoDAO.refeicoes.iterator();
            while (iterator.hasNext()) {
                Refeicao r = iterator.next();
                if (r.getPessoa().getIdade() == p.getIdade()) {
                    iterator.remove();
                    refeicaoDAO.removerRefeicao(r);
                }
            }
            pessoaDAO.removerPessoa(p);
        }
    }

    @Test
    public void RemoverPessoaTipoPessoa() throws PesoComidaInvalidoException, CampoVazioException, IdadeNegativaException, CpfExistenteException, CpfInvalidoException, ComidaRepetidaException {
        //Criando Pessoa
        Pessoa pessoa = criarPessoa("Matheus Daora","95687234158",30,"Carnivoro","Usuario");

        //Criando Comidas
        Carne cQueijo = criarCarne("Carne", "Queijo", 5.06f, "Uso de Técnicas Nocivas");
        Grao gArroz = criarGrao("Grão", "Arroz", 2.5f, "Uso de Técnicas Nocivas");
        Vegetal vBatata = criarVegetal("Vegetal", "Batata", 0.3f, "Uso de Técnicas Nocivas");

        Carne cAves = criarCarne("Carne", "Aves", 4.34f, "100% Natural / Orgânico");
        Grao gGraoBico = criarGrao("Grão", "Grão de Bico", 4.2f, "Uso de Técnicas Nocivas");
        Vegetal vAlface = criarVegetal("Vegetal", "Alface", 0.24f, "100% Natural / Orgânico");

        Carne cPorco = criarCarne("Carne", "Porco", 6f, "Uso de Técnicas Nocivas");
        Grao gMilho = criarGrao("Grão", "Milho", 1.2f, "100% Natural / Orgânico");
        Vegetal vTomate = criarVegetal("Vegetal", "Tomate", 0.2f, "Uso de Técnicas Nocivas");

        //Criando Refeições
        Refeicao refeicao1 = criarRefeicao("15/09/2023", "Café da Tarde", pessoa, cQueijo, gArroz, vBatata, 300, 200, 150);
        Refeicao refeicao2 = criarRefeicao("15/09/2023", "Almoço", pessoa, cAves, gGraoBico, vAlface, 300, 200, 150);
        Refeicao refeicao3 = criarRefeicao("15/09/2023", "Café da Manhã", pessoa, cPorco, gMilho, vTomate, 150, 100, 50);

        pessoaDAO.adicionarPessoa(pessoa);

        refeicaoDAO.adicionarRefeicao(refeicao1);
        refeicaoDAO.adicionarRefeicao(refeicao2);
        refeicaoDAO.adicionarRefeicao(refeicao3);

        Assert.assertFalse(pessoaDAO.retornarTodasPessoas().isEmpty());
        Assert.assertFalse(refeicaoDAO.recuperarTodasRefeicoes().isEmpty());

        removerPessoaTipoPessoaTest(pessoa);

        Assert.assertTrue(pessoaDAO.retornarTodasPessoas().isEmpty());
        Assert.assertTrue(refeicaoDAO.recuperarTodasRefeicoes().isEmpty());
    }

    public void removerPessoaTipoPessoaTest(Pessoa p){
        PessoaDAO pessoaDAO = new PessoaDAO();
        RefeicaoDAO refeicaoDAO = new RefeicaoDAO();

        if(RefeicaoDAO.refeicoes.size() == 0){
            System.out.println( "Nenhuma Refeição Cadastrada");
        }else{
            Iterator<Refeicao> iterator = RefeicaoDAO.refeicoes.iterator();
            while (iterator.hasNext()) {
                Refeicao r = iterator.next();
                if (r.getPessoa().getTipoPessoa().equals(p.getTipoPessoa())) {
                    iterator.remove();
                    refeicaoDAO.removerRefeicao(r);
                }
            }
            pessoaDAO.removerPessoa(p);
        }
    }

}

