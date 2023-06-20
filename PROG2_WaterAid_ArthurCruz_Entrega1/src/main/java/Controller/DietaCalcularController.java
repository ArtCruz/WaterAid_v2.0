/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.PessoaDAO;
import static DAO.PessoaDAO.pessoas;
import static DAO.RefeicaoDAO.refeicoes;
import Model.Pessoa;
import Model.Refeicao;
import View.DietaCalcularView;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import javax.swing.JOptionPane;

/**
 *
 * @author Filipe Zulian
 */
public class DietaCalcularController {
    
    private DietaCalcularView dietaCalcView;
    public Object pessoaSelecionada;
    public int cont = 1;

    public DietaCalcularController(DietaCalcularView dietaCalcView) {
        this.dietaCalcView = dietaCalcView;        
        popularComboBox();
        adicionarCMBRefeicoesDietaCalcular();
        
        inicializarAcaoCMBPessoas();
        inicializarAcaoCMBRefeicoes();

    }   
    
    public void popularComboBox(){
        ArrayList pessoasList =  new ArrayList(pessoas);
        Collections.sort(pessoasList);
        for(Object p : pessoasList){
            dietaCalcView.adicionarAcaoCMBPessoas((Pessoa)p);
        }
        pessoaSelecionada = dietaCalcView.getPessoaSelecionada();
        inicializarAcaoCMBRefeicoes();
        
    }
    
    public void inicializarAcaoCMBPessoas(){
        dietaCalcView.adicionarAcaoCMBPessoas((ActionEvent e) -> {
            adicionarCMBRefeicoesDietaCalcular();
        });
    }
    
    public void inicializarAcaoCMBRefeicoes(){
        dietaCalcView.adicionarAcaoCMBRefeicoes((ActionEvent e) -> {
            acaoCMBefDietaCalc();
        });
    }
    
    public void exibirTela(){
        dietaCalcView.exibirTela();
    }
    
    public void adicionarCMBRefeicoesDietaCalcular(){
        //esse if cont e para corrigir o erro do "Essa Pessoa já está Selecionada"
        if(cont == 1){
            for(Refeicao r : refeicoes){
                if(dietaCalcView.getPessoaSelecionada().equals(r.getPessoa())){
                    dietaCalcView.addCMBRefDietaCalc(r);
                }            
            }
            for(Refeicao r : refeicoes){
                if(!dietaCalcView.getPessoaSelecionada().equals(r.getPessoa())){
                    dietaCalcView.removeCMBRefDietaCalc(r);
                }
            }
            cont++;
        }else{
            if(dietaCalcView.getPessoaSelecionada().equals(pessoaSelecionada)){
                JOptionPane.showMessageDialog(null, "Essa Pessoa já está Selecionada");
            }else{
                for(Refeicao r : refeicoes){
                    if(dietaCalcView.getPessoaSelecionada().equals(r.getPessoa())){
                        dietaCalcView.addCMBRefDietaCalc(r);
                    }            
                }
                for(Refeicao r : refeicoes){
                    if(!dietaCalcView.getPessoaSelecionada().equals(r.getPessoa())){
                        dietaCalcView.removeCMBRefDietaCalc(r);
                    }
                }
        }        
        pessoaSelecionada = dietaCalcView.getPessoaSelecionada();
        }
//        if(dietaCalcView.getPessoaSelecionada().equals(pessoaSelecionada)){
//            JOptionPane.showMessageDialog(null, "Essa Pessoa já está Selecionada");
//        }else{
//            for(Refeicao r : refeicoes){
//                if(dietaCalcView.getPessoaSelecionada().equals(r.getPessoa())){
//                    dietaCalcView.addCMBRefDietaCalc(r);
//                }            
//            }
//            for(Refeicao r : refeicoes){
//                if(!dietaCalcView.getPessoaSelecionada().equals(r.getPessoa())){
//                    dietaCalcView.removeCMBRefDietaCalc(r);
//                }
//            }
//        }        
//        pessoaSelecionada = dietaCalcView.getPessoaSelecionada();
    }
    
    public void acaoCMBefDietaCalc(){
        dietaCalcView.limparTodosTextArea();
        
        Refeicao ref = (Refeicao) dietaCalcView.getRefDietaSelecionada();
        dietaCalcView.preencherTACarneOriginal("Nome: "+ref.getTipoCarne().getNome()+", Relação: "+ref.getTipoCarne().getRelComidaAgua());
        dietaCalcView.preencherTAPesoCarneOriginal(String.valueOf(new DecimalFormat("#,##0.00").format(ref.getPesoTipoCarne())+" gramas"));
        dietaCalcView.preencherTAGraoOriginal("Nome: "+ref.getTipoGrao().getNome()+", Relação: "+ref.getTipoGrao().getRelComidaAgua());
        dietaCalcView.preencherTAPesoGraoOriginal(String.valueOf(new DecimalFormat("#,##0.00").format(ref.getPesoTipoGrao())+" gramas"));
        dietaCalcView.preencherTAVegetalOriginal("Nome: "+ref.getTipoVegetal().getNome()+", Relação: "+ref.getTipoVegetal().getRelComidaAgua());
        dietaCalcView.preencherTAPesoVegetalOriginal(String.valueOf(new DecimalFormat("#,##0.00").format(ref.getPesoTipoVegetal())+" gramas"));
        
        dietaCalcView.preencherTACarneDieta("Nome: "+ref.getTipoCarne().getNome()+", Relação: "+ref.getTipoCarne().getRelComidaAgua());
        double pesoCarneDieta = ref.getPesoTipoCarne()*0.8;
        dietaCalcView.preencherTAPesoCarneDieta(String.valueOf(new DecimalFormat("#,##0.00").format(pesoCarneDieta)+" gramas"));
        dietaCalcView.preencherTAGraoDieta("Nome: "+ref.getTipoGrao().getNome()+", Relação: "+ref.getTipoGrao().getRelComidaAgua());
        double pesoGraoDieta = ref.getPesoTipoGrao()+(ref.getPesoTipoCarne()*0.15);
        dietaCalcView.preencherTAPesoGraoDieta(String.valueOf(new DecimalFormat("#,##0.00").format(pesoGraoDieta)+" gramas"));
        dietaCalcView.preencherTAVegetalDieta("Nome: "+ref.getTipoVegetal().getNome()+", Relação: "+ref.getTipoVegetal().getRelComidaAgua());
        double pesoVegetalDieta = ref.getPesoTipoVegetal()+(ref.getPesoTipoCarne()*0.05);
        dietaCalcView.preencherTAPesoVegetalDieta(String.valueOf(new DecimalFormat("#,##0.00").format(pesoVegetalDieta)+" gramas"));
        
        dietaCalcView.limparTAEconomizouDieta();
        double economia = 0;
        double refOriginal = 0;
        double refDieta = 0;
        refOriginal = (ref.getTipoCarne().getRelComidaAgua()*ref.getPesoTipoCarne())+(ref.getTipoGrao().getRelComidaAgua()*ref.getPesoTipoGrao())
                +(ref.getTipoVegetal().getRelComidaAgua()*ref.getPesoTipoVegetal());
        refDieta = (ref.getTipoCarne().getRelComidaAgua()*pesoCarneDieta)+(ref.getTipoGrao().getRelComidaAgua()*pesoGraoDieta)
                +(ref.getTipoVegetal().getRelComidaAgua()*pesoVegetalDieta);
        economia = refOriginal - refDieta;
        dietaCalcView.preencherTAEconomizouDieta(new DecimalFormat("#,##0.00").format(economia)+" Litros de Àgua");
    }
    
    
}
