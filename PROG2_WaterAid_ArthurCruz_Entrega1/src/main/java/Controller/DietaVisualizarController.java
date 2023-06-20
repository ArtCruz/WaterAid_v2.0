/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import static DAO.PessoaDAO.pessoas;
import static DAO.RefeicaoDAO.refeicoes;
import Model.Pessoa;
import Model.Refeicao;
import View.DietaVisualizarView;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Filipe Zulian
 */
public class DietaVisualizarController {
    
    private DietaVisualizarView dietaVisView;

    public DietaVisualizarController(DietaVisualizarView dietaVisView) {
        this.dietaVisView = dietaVisView;
        popularComboBox();
        acaoCMBPessoaDietaVis();
        
        inicializarAcaoCMBPessoas();
    }
    
    public void exibirTela(){
        dietaVisView.exibirTela();
    }
    
    public void inicializarAcaoCMBPessoas(){
        dietaVisView.adicionarAcaoCMBPessoas((ActionEvent e) -> {
            acaoCMBPessoaDietaVis();
        });
    }
    
    public void popularComboBox(){
        ArrayList pessoasList = new ArrayList(pessoas);
        Collections.sort(pessoasList);
        for(Object p: pessoasList){
            dietaVisView.listarCMBPessoas((Pessoa)p);
        }
    }  
    
    public void acaoCMBPessoaDietaVis(){
        dietaVisView.limparTodosTextArea();
        
        double pesoCarneDieta = 0;
        double pesoGraoDieta = 0;
        double pesoVegetalDieta = 0;
        double impacDieta = 0;
        for(Refeicao r : refeicoes){            
            if(r.getPessoa().equals(dietaVisView.getSelectedPessoa())){
                pesoCarneDieta += r.getTipoCarne().getRelComidaAgua() * (r.getPesoTipoCarne()*0.8);
                pesoGraoDieta += r.getTipoGrao().getRelComidaAgua() * (r.getPesoTipoGrao()+(r.getPesoTipoCarne()*0.15));
                pesoVegetalDieta += r.getTipoVegetal().getRelComidaAgua() * (r.getPesoTipoVegetal()+(r.getPesoTipoCarne()*0.05));
            }
        }
        impacDieta += pesoCarneDieta+pesoGraoDieta+pesoVegetalDieta;
        dietaVisView.preencherTALitAgua(String.valueOf( new DecimalFormat("#,##0.000").format(impacDieta)));
        
        double impacRef = 0;
        for(Refeicao r : refeicoes){
            if(r.getPessoa().equals(dietaVisView.getSelectedPessoa())){
                impacRef += (r.getTipoCarne().getRelComidaAgua() * r.getPesoTipoCarne())+
                        (r.getTipoGrao().getRelComidaAgua()* r.getPesoTipoGrao())+
                        (r.getTipoVegetal().getRelComidaAgua()*r.getPesoTipoVegetal());
            }
        }
        double impacDifRefDieta = impacRef-impacDieta;
        dietaVisView.preencherTADifAgua(new DecimalFormat("#,##0.000").format(impacDifRefDieta));
        
        String impacLitBanho5min = new DecimalFormat("#,##0.00").format(impacDifRefDieta/45);
        dietaVisView.preencherTABanhos(String.valueOf(impacLitBanho5min));

        String impactLitReais = new DecimalFormat("#,##0.00").format((impacDifRefDieta/1000) * 3.8);
        dietaVisView.preencherTAReais(String.valueOf(impactLitReais));
    }
}
