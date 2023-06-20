package tests.sistema;

import DAO.PessoaDAO;
import Exception.*;
import Model.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class RefeicaoHistoricoControllerTest {
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

    @Test
    public void RelatorioRefeicaoData() throws CampoVazioException, PesoComidaInvalidoException, CpfExistenteException, CpfInvalidoException, IdadeNegativaException, ComidaRepetidaException {
        //Criando Pessoa
        Pessoa pessoa = criarPessoa("Matheus Daora","95687234159",30,"Carnivoro","Usuario");

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

        String ref1 = refeicao1.toString();
        String dataRef1 = refeicao1.getData();

        boolean contemData1 = ref1.contains(dataRef1);

        assertTrue(contemData1);

        String ref2 = refeicao2.toString();
        String dataRef2 = refeicao2.getData();

        boolean contemData2 = ref2.contains(dataRef2);

        assertTrue(contemData2);

        String ref3 = refeicao3.toString();
        String dataRef3 = refeicao3.getData();

        boolean contemData3 = ref3.contains(dataRef3);

        assertTrue(contemData3);
    }

    @Test
    public void RelatorioRefeicaoPessoa() throws PesoComidaInvalidoException, CampoVazioException, IdadeNegativaException, CpfExistenteException, CpfInvalidoException, ComidaRepetidaException {
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

        String ref1 = refeicao1.toString();
        String pessoaRef1 = refeicao1.getPessoa().getNome();

        boolean contemPessoa1 = ref1.contains(pessoaRef1);

        assertTrue(contemPessoa1);

        String ref2 = refeicao2.toString();
        String pessoaRef2 = refeicao2.getPessoa().getNome();

        boolean contemPessoa2 = ref2.contains(pessoaRef2);

        assertTrue(contemPessoa2);

        String ref3 = refeicao3.toString();
        String pessoaRef3 = refeicao3.getPessoa().getNome();

        boolean contemPessoa3 = ref3.contains(pessoaRef3);

        assertTrue(contemPessoa3);
    }
}
