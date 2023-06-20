package tests.integracao;

import DAO.PessoaDAO;
import Model.Administrador;
import Model.*;
import Exception.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class RefeicaoNovaControllerTest {

    private Pessoa pessoa1;
    private Carne cCarne;
    private Grao cGrao;
    private Vegetal cVegetal;
    private Refeicao refeicao;

    public RefeicaoNovaControllerTest() throws CampoVazioException, CpfExistenteException, CpfInvalidoException, IdadeNegativaException, ComidaRepetidaException, PesoComidaInvalidoException {

        refeicao = new Refeicao();

        pessoa1 = new Usuario();
        pessoa1.setNome("Arthur Cruz");
        pessoa1.setCpf("74182563969");
        pessoa1.setIdade(19);
        pessoa1.setOrientacaoAlimentar("Carnívoro");
        pessoa1.setTipoPessoa("Administrador");

        cCarne = new Carne();
        cCarne.setNome("Vaca");
        cCarne.setTipoComida("Carne");
        cCarne.setDetalheComida("Uso de Técnicas Nocivas");
        cCarne.setRelComidaAgua(15.4f);

        cGrao = new Grao();
        cGrao.setNome("Fejão");
        cGrao.setTipoComida("Grão");
        cGrao.setDetalheComida("Uso de Técnicas Nocivas");
        cGrao.setRelComidaAgua(1.32f);

        cVegetal = new Vegetal();
        cVegetal.setNome("Tomate");
        cVegetal.setTipoComida("Vegetal");
        cVegetal.setDetalheComida("Uso de Técnicas Nocivas");
        cVegetal.setRelComidaAgua(0.2f);

        refeicao.setData("15/05/2023");
        refeicao.setNome("Primeira Janta");
        refeicao.setPessoa(pessoa1);
        refeicao.setTipoCarne(cCarne);
        refeicao.setTipoGrao(cGrao);
        refeicao.setTipoVegetal(cVegetal);
        //refeicao.setPesoTipoCarne();
        refeicao.setPesoTipoGrao(200);
        refeicao.setPesoTipoVegetal(150);
    }
    @Test
    public void CadastroNovaRefeicaoValido() throws PesoComidaInvalidoException{
        assertDoesNotThrow(() -> refeicao.setPesoTipoCarne(250));
    }

    @Test
    public void CadastroNovaRefeicaoInvalido(){
        assertThrows(PesoComidaInvalidoException.class, () -> refeicao.setPesoTipoCarne(-1));
    }

}
