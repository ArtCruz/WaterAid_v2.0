/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import static DAO.PessoaDAO.pessoas;
import Model.Pessoa;
import View.RelatorioPessoaView;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Filipe Zulian
 */
public class RelatorioPessoaController {
    
    private RelatorioPessoaView relPessoaView;

    public RelatorioPessoaController(RelatorioPessoaView relPessoaView) {
        this.relPessoaView = relPessoaView;
        inicializarBotaoLimpar();
        inicializarBotaovisualizarRelatorioComida();
        inicializarCMBPessoas();
    }
    
    public void exibeTela(){
        relPessoaView.exibeTela();
    }
    
    public void inicializarBotaovisualizarRelatorioComida(){
        relPessoaView.adicionarAcaoRetornarTodasRelatorioPessoa((ActionEvent e) -> {
        visualizarRelatorioPessoa();
        });    
    }
    
    public void visualizarRelatorioPessoa(){
        relPessoaView.limparTextArea();
        ArrayList pessoasList = new ArrayList(pessoas);
        Collections.sort(pessoasList);
        for(Object p : pessoasList){
            if(relPessoaView.getTipoPessoa().equals("Administradores")){
                relPessoaView.preencherTextArea(p.toString()+"\n");
            }
        }
        for(Object p : pessoasList){
            if(relPessoaView.getTipoPessoa().equals("Usuários")){
                relPessoaView.preencherTextArea(p.toString()+"\n");
            }
        }
    }
    
    public void inicializarBotaoLimpar(){
        relPessoaView.adicionarAcaoLimparRelatorioPessoa((ActionEvent e) -> {
        limparRelatorioPessoa();
        }); 
    }
    
    public void limparRelatorioPessoa(){
        relPessoaView.limparTextArea();
    }
    
    public void inicializarCMBPessoas(){
        relPessoaView.adicionarAcaoCMBPessoas((ActionEvent e) -> {
            popularTextAreaCMB();
        });
    }
    
    public void popularTextAreaCMB(){
        if(relPessoaView.getTipoPessoa().equals("Administradores")){
            for(Pessoa p : pessoas){
                if(p.getTipoPessoa().equals("Administrador")){
                    relPessoaView.preencherTextArea(p.toString()+"\n");
                }
            }
        }
        if(relPessoaView.getTipoPessoa().equals("Usuários")){
            for(Pessoa p : pessoas){
                if(p.getTipoPessoa().equals("Usuario")){
                    relPessoaView.preencherTextArea(p.toString()+"\n");
                }
            }
        }
    }
    
}
