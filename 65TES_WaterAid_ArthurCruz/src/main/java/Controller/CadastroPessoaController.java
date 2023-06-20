/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.PessoaDAO;
import Exception.CampoVazioException;
import Exception.CpfExistenteException;
import Exception.CpfInvalidoException;
import Exception.IdadeNegativaException;
import Model.Administrador;
import Model.Pessoa;
import Model.Usuario;
import View.CadastroPessoaView;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Filipe Zulian
 */
public class CadastroPessoaController {
    
    private CadastroPessoaView cadastroPessoaView;

    public CadastroPessoaController(CadastroPessoaView cadastroPessoaView) {
        this.cadastroPessoaView = cadastroPessoaView;
        inicializarBotoes();
    }
    
    public void inicializarBotoes(){
        cadastroPessoaView.adicionarAcaoBotaoCadastroPessoa((ActionEvent e) -> {
            cadastrarPessoa();
        });
    }
    
    public void exibirTela(){
        cadastroPessoaView.exibirTela();
    }
    
    public void cadastrarPessoa(){
        PessoaDAO pessoaDAO = new PessoaDAO();
        
        String nome = cadastroPessoaView.getNomePessoa();
        String cpf = cadastroPessoaView.getCPFPessoa();

        String orientAlimen = cadastroPessoaView.getOrientacaoPessoa();
        String tipoPessoa = cadastroPessoaView.getTipoPessoa();
        
        Pessoa p = null;
        
        if(orientAlimen.equals("Escolha uma das opções")){
            JOptionPane.showMessageDialog(null, "Selecione uma Orientação Alimentar");
        }else{
            try {
                int idade = Integer.parseInt(cadastroPessoaView.getIdadePessoa());

                if(tipoPessoa.equals("Escolha uma das opções")){
                    JOptionPane.showMessageDialog(null, "Selecione um Tipo de Pessoa");
                }else{
                    if(tipoPessoa.equals("Usuário")){
                        tipoPessoa = "Usuario";
                        p = new Usuario();
                    }else if(tipoPessoa.equals("Administrador")){
                        tipoPessoa = "Administrador";
                        p = new Administrador();
                    }
                    p.setNome(nome);
                    p.setCpf(cpf);
                    p.setIdade(idade);
                    p.setOrientacaoAlimentar(orientAlimen);
                    p.setTipoPessoa(tipoPessoa);
                    pessoaDAO.adicionarPessoa(p);
                    JOptionPane.showMessageDialog(null, "Pessoa Salva com Sucesso");
            }
            }catch(CampoVazioException | CpfExistenteException | CpfInvalidoException | IdadeNegativaException e){
                JOptionPane.showMessageDialog(null, e.getMessage());            
            }  
            catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Preencha o Campo 'Idade' com Apenas Números Positivos");       
            }
        }        
    }
}
