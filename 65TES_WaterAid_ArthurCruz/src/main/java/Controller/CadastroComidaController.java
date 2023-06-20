/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Exception.CampoVazioException;
import Exception.ComidaRepetidaException;
import Exception.UsuarioAddComidaException;
import Model.Carne;
import Model.Comida;
import Model.Grao;
import Model.Pessoa;
import Model.Usuario;
import Model.Vegetal;
import View.CadastroComidaView;
import javax.swing.JOptionPane;
import DAO.ComidaDAO;
import DAO.PessoaDAO;
import java.awt.event.ActionEvent;
import java.util.Set;

/**
 *
 * @author Filipe Zulian
 */
public class CadastroComidaController {
    
    private CadastroComidaView cadastroComidaView;
    
    public CadastroComidaController(CadastroComidaView cadastroComidaView) {
        this.cadastroComidaView = cadastroComidaView;
        inicializarDadosTela();
        inicializarBotoes();
    }
    
    public void inicializarBotoes(){
        cadastroComidaView.adicionarAcaoBotaoCadastroComida((ActionEvent e) -> {
            cadastrarComida();
        });
    }
    
    public void exibirTela(){
        cadastroComidaView.exibirTela();
    }
    
    public void inicializarDadosTela(){
        PessoaDAO pessoaDAO = new PessoaDAO();
        Set<Pessoa> pessoas = pessoaDAO.retornarTodasPessoas();
        popularPessoas(pessoas);
    }    
    
    private Pessoa validaTipoPessoa(Pessoa pes) throws UsuarioAddComidaException{
        Pessoa p = cadastroComidaView.getPessoa();
        if(p instanceof Usuario){
            throw new UsuarioAddComidaException();
        }    
        else{
            return p;
        }        
    }
    
    public void popularPessoas(Set<Pessoa> pessoas){
        for(Pessoa p : pessoas)
            cadastroComidaView.addCMBPessoas(p);
    }
    
    public void cadastrarComida(){
        ComidaDAO comidaDAO = new ComidaDAO();
        
        Pessoa pessoaCadastroComida = cadastroComidaView.getPessoa();
        String nomeComida = cadastroComidaView.getNomeComida();
        String tipoComida = cadastroComidaView.getTipoComida();
        String detalheComida = cadastroComidaView.getDetalheComida();
        
        Comida c = null;
        
        if(detalheComida.equals("Escolha uma das opções")){
            JOptionPane.showMessageDialog(null, "Escolha um tipo de Comida");
        }else{
            try{
                float razao = Float.parseFloat(cadastroComidaView.getRelComidaAgua());
                
                if(tipoComida.equals("Escolha uma das opções")){
                    JOptionPane.showMessageDialog(null, "Escolha um tipo de Comida");
                }else{
                    switch (tipoComida) {
                        case "Carne":
                            tipoComida = "Carne";
                            c = new Carne();
                            break;
                        case "Grão":
                            tipoComida = "Grão";
                            c = new Grao();
                            break;
                        case "Vegetal":
                            tipoComida = "Vegetal";
                            c = new Vegetal();
                            break;
                        default:
                            break;
                    }
                    
                    validaTipoPessoa(pessoaCadastroComida);
                    c.setNome(nomeComida);
                    c.setTipoComida(tipoComida);
                    c.setDetalheComida(detalheComida);
                    c.setRelComidaAgua(razao);
                    comidaDAO.adicionarComida(c);
                    JOptionPane.showMessageDialog(null, c.getTipoComida()+" Salvo(a) com Sucesso");

                }
            }catch(CampoVazioException | UsuarioAddComidaException | ComidaRepetidaException e){
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
            catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Preencha o Campo 'Razão...' com Apenas Números Positivos");       
            }
        }         
    }       
}
