/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.PessoaDAO;
import static DAO.PessoaDAO.pessoas;
import DAO.RefeicaoDAO;
import static DAO.RefeicaoDAO.refeicoes;
import Model.Pessoa;
import Model.Refeicao;
import View.RemoverPessoaView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import javax.swing.JOptionPane;

/**
 *
 * @author Gabriela
 */
public class RemoverPessoaController {
    
    private RemoverPessoaView removerPessoaView;
    public Object pessoaSelecionada;
    
    public RemoverPessoaController(RemoverPessoaView removerPessoaView) {
        this.removerPessoaView = removerPessoaView;
        
        inicializarAcoes();
    }
    
    public void exibirTela(){
        removerPessoaView.exibirTela();
    }

    public void inicializarAcoes(){
        removerPessoaView.adicionarAcaoBuscarRemPes((ActionEvent e ) -> {
            visualizarPessoas();
        });
        
        removerPessoaView.adicionarAcaoBotaoRemoverPes((ActionEvent e) -> {
            removerPessoa();
        });
    }
    
    public void visualizarPessoas(){

        removerPessoaView.limparCMBPessoa();
        
        if(removerPessoaView.getCategoriaRemPes().equals("Nome")){
            ArrayList pessoasList = new ArrayList(pessoas);
            Collections.sort(pessoasList);
        
            for(Object p : pessoasList){
                if(p.toString().contains(removerPessoaView.getTextField())){
                    removerPessoaView.addCMBPessoas((Pessoa) p);
                }
            }  
        }else if(removerPessoaView.getCategoriaRemPes().equals("Orientação Alimentar")){
            ArrayList pessoasList = new ArrayList(pessoas);
            Collections.sort(pessoasList);
        
            for(Object p : pessoasList){
                if(p.toString().contains(removerPessoaView.getTextField())){
                    removerPessoaView.addCMBPessoas((Pessoa) p);
                }
            }  
        }else if(removerPessoaView.getCategoriaRemPes().equals("CPF")){
            ArrayList pessoasList = new ArrayList(pessoas);
            Collections.sort(pessoasList);
        
            for(Object p : pessoasList){
                if(p.toString().contains(removerPessoaView.getTextField())){
                    removerPessoaView.addCMBPessoas((Pessoa) p);
                }
            }  
        }else if(removerPessoaView.getCategoriaRemPes().equals("Idade")){
            ArrayList pessoasList = new ArrayList(pessoas);
            Collections.sort(pessoasList);
        
            for(Object p : pessoasList){
                if(p.toString().contains(removerPessoaView.getTextField().toString())){
                    removerPessoaView.addCMBPessoas((Pessoa) p);
                }
            }  
        }else if(removerPessoaView.getCategoriaRemPes().equals("Tipo Pessoa")){
            ArrayList pessoasList = new ArrayList(pessoas);
            Collections.sort(pessoasList);
        
            for(Object p : pessoasList){
                if(p.toString().contains(removerPessoaView.getTextField())){
                    removerPessoaView.addCMBPessoas((Pessoa) p);
                }
            }  
        }
        if(removerPessoaView.getQtdElemtosCMB() == 0){
            JOptionPane.showMessageDialog(null, "Pessoa Não Encontrada");
        }
    }
    
    public void removerPessoa(){
        PessoaDAO pessoaDAO = new PessoaDAO();
        RefeicaoDAO refeicaoDAO = new RefeicaoDAO();
        Iterator<Refeicao> iterator = refeicoes.iterator();
        
        if(removerPessoaView.getQtdElemtosCMB() == 0){
            JOptionPane.showMessageDialog(null, "Selecione uma Pessoa para Remover");
        }else{
            while(iterator.hasNext()){
                Refeicao r = iterator.next();
                if(r.getPessoa().equals(removerPessoaView.getPessoaRemover())){
                    iterator.remove();
                    refeicaoDAO.removerRefeicao(r);
                }
            }            
            pessoaDAO.removerPessoa((Pessoa) removerPessoaView.getPessoaRemover());
            JOptionPane.showMessageDialog(null, "Pessoa e Dependências Removidas com Sucesso");
            visualizarPessoas();
        }
    }


}
