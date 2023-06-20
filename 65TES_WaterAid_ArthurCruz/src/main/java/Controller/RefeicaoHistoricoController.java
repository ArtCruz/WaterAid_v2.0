/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import static DAO.RefeicaoDAO.refeicoes;
import Model.Comparators.ComparatorNomeCrescenteRefeicao;
import Model.Refeicao;
import View.RefeicaoHistoricoView;
import java.awt.event.ActionEvent;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Filipe Zulian
 */
public class RefeicaoHistoricoController {
    
    private RefeicaoHistoricoView refeicaoHistoricoView;

    public RefeicaoHistoricoController(RefeicaoHistoricoView refeicaoHistoricoView) {
        this.refeicaoHistoricoView = refeicaoHistoricoView;
        inicializarBotaoVisualizar();
        inicializarBotaoLimpar();
        inicializarRBData();
        inicializarRBUsuario();
    }
    
    
    
    public void exibirTela(){
        refeicaoHistoricoView.exibirTela();
    }
    public void inicializarBotaoVisualizar(){
        refeicaoHistoricoView.adicionarAcaoVisualizarRefHist((ActionEvent e ) -> {
            visualizarRefHist();
        });
    }
    
    public void inicializarRBData(){
        refeicaoHistoricoView.adicionarAcaoRBDataRefHist((ActionEvent e ) -> {
            RBDataRefHist();
        });
    }
    
    public void inicializarRBUsuario(){
        refeicaoHistoricoView.adicionarAcaoRBUsuarioRefHist((ActionEvent e ) -> {
            RBUsuarioRefHist();
        });
    }
    
    public void inicializarBotaoLimpar(){
        refeicaoHistoricoView.adicionarAcaoLimparRefHist((ActionEvent e ) -> {
            limparTextAreaRefHist();
        });
    }
    
    public void limparTextAreaRefHist(){
        refeicaoHistoricoView.limparTextAreaRefHist();;
    }
        
    public void visualizarRefHist(){
        if(refeicaoHistoricoView.getStateData()==true){
            for(Refeicao r : refeicoes){
                if(r.getData().equals(refeicaoHistoricoView.getRefeicao())){
                    refeicaoHistoricoView.preencherTextAreaRefHist(r.toString()+"\n");
                }
            }
            if(refeicaoHistoricoView.StateTextAreaRefHist().equals("")){
                refeicaoHistoricoView.preencherTextAreaRefHist("Não há Nenhuma Refeição Cadastrada"+"\n");
            }
        }if(refeicaoHistoricoView.getStateUsuario()==true){
            for(Refeicao r : refeicoes){
                String aux = "Nome: "+r.getPessoa().getNome()+", CPF: "+r.getPessoa().getCpf();
                if(aux.equals(refeicaoHistoricoView.getRefeicao())){
                    refeicaoHistoricoView.preencherTextAreaRefHist(r.toString()+"\n");
                }            
            }
            if(refeicaoHistoricoView.StateTextAreaRefHist().equals("")){
                refeicaoHistoricoView.preencherTextAreaRefHist("Não há Nenhuma Refeição Cadastrada"+"\n");
            }
        }
    }
    
    private static void imprimirListaRefeicaoOrdenada(List<Refeicao> refeicoes){
        refeicoes.sort((r1, r2) -> {
            String aux = r1.getData();
            return aux.compareTo(r2.getData());            
        });
    }
    
    public void RBDataRefHist(){
        if(refeicaoHistoricoView.getStateData() == true){
            refeicaoHistoricoView.setEnableRBUsuario(false);
            refeicaoHistoricoView.removeAllItensCMBRefHist();
            if(refeicaoHistoricoView.getStateData()==true){
                imprimirListaRefeicaoOrdenada(refeicoes);
                int cont = 1;
                String aux = "";
                for(Refeicao r : refeicoes){
                    if(cont == 1){
                        refeicaoHistoricoView.addItemCMBRefHist(r.getData());
                        aux = r.getData();
                        cont++;
                    }else{
                        if(r.getData().equals(aux)){
                            cont++;
                        }else{
                            refeicaoHistoricoView.addItemCMBRefHist(r.getData());
                            aux = r.getData();
                            cont++;
                        }    
                    }   
                }
            }
        }else{
            refeicaoHistoricoView.setEnableRBUsuario(true);
            refeicaoHistoricoView.removeAllItensCMBRefHist();
        }
    }
    
    public void RBUsuarioRefHist(){
        if(refeicaoHistoricoView.stateRBUsuario()){
            refeicaoHistoricoView.setEnableRBData(false);
            refeicaoHistoricoView.removeAllItensCMBRefHist();
            Collections.sort(refeicoes, new ComparatorNomeCrescenteRefeicao());
            int cont = 1;
            String aux = "";
            for(Refeicao r : refeicoes){
                if(cont == 1){
                    refeicaoHistoricoView.addItemCMBRefHist("Nome: "+r.getPessoa().getNome() + ", CPF: "+r.getPessoa().getCpf());
                    aux = r.getPessoa().getNome();
                    cont++;
                }else{
                    if(r.getPessoa().getNome().equals(aux)){
                        cont++;
                    }else{
                        refeicaoHistoricoView.addItemCMBRefHist("Nome: "+r.getPessoa().getNome() + ", CPF: "+r.getPessoa().getCpf());
                        aux = r.getPessoa().getNome();
                        cont++;
                    }    
                }
            } 
        }else{
            refeicaoHistoricoView.setEnableRBData(true);
            refeicaoHistoricoView.removeAllItensCMBRefHist();
        }
    }
}
