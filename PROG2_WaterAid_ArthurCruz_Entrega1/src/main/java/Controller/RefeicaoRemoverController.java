/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.PessoaDAO;
import static DAO.PessoaDAO.pessoas;
import DAO.RefeicaoDAO;
import static DAO.RefeicaoDAO.refeicoes;
import Model.Comparators.ComparatorDataCrescenteRefeicao;
import Model.Pessoa;
import Model.Refeicao;
import View.RefeicaoRemoverView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import javax.swing.JOptionPane;

/**
 *
 * @author Filipe Zulian
 */
public class RefeicaoRemoverController {
    private RefeicaoRemoverView refRemView;

    public RefeicaoRemoverController(RefeicaoRemoverView refRemView) {
        this.refRemView = refRemView;
        inicializarDados();
        inicializarAcoes();
    }
    
    
    
    public void exibirTela(){
        refRemView.exibirTela();
    }
        
    public void inicializarAcoes(){
        refRemView.adicionarAcaoBotaoRemoverRef((ActionEvent e) -> {
            removerRefeicao();
        });
        
        refRemView.adicionarAcaoCMBPessoas((ActionEvent e) -> {
            acaoCMBPessoas();
        });
    }
    
    public void removerRefeicao(){
        RefeicaoDAO refeicaoDAO = new RefeicaoDAO();
        if(refRemView.getContagem() == 0){
            JOptionPane.showMessageDialog(null, "Esta Pessoa Não Possui Nenhuma Refeição Cadastrada");
        }else{
            refeicaoDAO.removerRefeicao((Refeicao) refRemView.getRefeicaoRemover());
            JOptionPane.showMessageDialog(null, "Refeição Removida com Sucesso");
            atualizarCmbRefeicoes();
        }
    }
    
    public void inicializarDados(){
        ArrayList pessoasList = new ArrayList(pessoas);
        Collections.sort(pessoasList);
        for(Object p : pessoasList){
            refRemView.addPessoaCMB((Pessoa) p);
        }        
        for(Refeicao r : refeicoes){
            if(r.getPessoa().equals(refRemView.getPessoaSelecionada())){
                refRemView.addRefCMB(r);
            }
        }
        
    }
    
    public void atualizarCmbRefeicoes(){
        refRemView.removerAllItemsCMBRefeicoes();
        Collections.sort(refeicoes, new ComparatorDataCrescenteRefeicao());
        for(Refeicao r : refeicoes){
            if(r.getPessoa().equals(refRemView.getPessoaSelecionada())){
                refRemView.addRefCMB(r);
            }
        }
    }
    
    public void acaoCMBPessoas(){
        refRemView.removerAllItemsCMBRefeicoes();
        for(Refeicao r : refeicoes){
            if(r.getPessoa().equals(refRemView.getPessoaSelecionada())){
                refRemView.addRefCMB(r);
            }
        }
        atualizarCmbRefeicoes();
    }
    
}
