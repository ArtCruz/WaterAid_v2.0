package tests.unitario;

import DAO.PessoaDAO;
import Model.Administrador;
import Model.Pessoa;
import Model.Usuario;
import Exception.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CadastroPessoaControllerTest {

    private Pessoa pessoa1;
    private Pessoa pessoa2;
    private Pessoa pessoa3;

    public CadastroPessoaControllerTest() throws CampoVazioException, CpfExistenteException, CpfInvalidoException, IdadeNegativaException{
        pessoa1 = new Administrador();
        pessoa1.setNome("Fernando Fernandes");
        pessoa1.setCpf("84593602751");
        //pessoa1.setIdade(-1);
        pessoa1.setOrientacaoAlimentar("Carnívoro");
        pessoa1.setTipoPessoa("Administrador");

        pessoa2 = new Administrador();
        pessoa2.setNome("Fernando Fernandes");
        pessoa2.setCpf("84593602751");
        //pessoa2.setIdade(0);
        pessoa2.setOrientacaoAlimentar("Carnívoro");
        pessoa2.setTipoPessoa("Administrador");

        pessoa3 = new Administrador();
        pessoa3.setNome("Fernando Fernandes");
        pessoa3.setCpf("84593602751");
        //pessoa3.setIdade(1);
        pessoa3.setOrientacaoAlimentar("Carnívoro");
        pessoa3.setTipoPessoa("Administrador");
    }
    @Test
    public void ValidarIdadePessoaNegativo() throws IdadeNegativaException {
        assertThrows(IdadeNegativaException.class, () -> pessoa1.setIdade(-1));
    }

    @Test
    public void ValidarIdadePessoaNeutro(){
        assertDoesNotThrow(() -> pessoa2.setIdade(0));
    }
    @Test
    public void ValidarIdadePessoaPositivo(){
        assertDoesNotThrow(() -> pessoa3.setIdade(1));
    }

}
