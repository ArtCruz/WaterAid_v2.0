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
import View.ImpactoCalcularView;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

/**
 *
 * @author Filipe Zulian
 */
public class ImpactoCalcularController {
    
    private ImpactoCalcularView impacCalcView;

    public ImpactoCalcularController(ImpactoCalcularView impacCalcView) {
        this.impacCalcView = impacCalcView;
        inicializarBotoes();
        inicializarDadosTela();
    }   
    
    
    public void exibirTela(){
        impacCalcView.exibirTela();
    }
    
    public void inicializarDadosTela(){
        PessoaDAO pessoaDAO = new PessoaDAO();
        Set<Pessoa> pessoas = pessoaDAO.retornarTodasPessoas();
        popularPessoas(pessoas);
    }
    
    public void inicializarBotoes(){
        impacCalcView.adicionarAcaoBotaoCalcTodasRef((ActionEvent e) ->{
            calcImpacTodasRef();
        });
        impacCalcView.adicionarAcaoBotaoCalcImpacTodasPes((ActionEvent e) ->{
            calcImpacTodasPes();
        });
        impacCalcView.adicionarAcaoBotaoLimparTela((ActionEvent e )->{
            limparTela();
        });
        
    }
    
    public void popularPessoas(Set<Pessoa> pessoas){
        ArrayList pessoasList = new ArrayList(pessoas);
        Collections.sort(pessoasList);
        for(Object p : pessoasList){
            impacCalcView.addCMBPessoas((Pessoa)p);
        }
    }
    
    public void calcImpacTodasRef(){
        for(Refeicao r : refeicoes){
            if(r.getPessoa().equals(impacCalcView.getPessoaSelecionada())){
                if(r.getImpactoRef()==0){
                    float impacCarneRed = r.getTipoCarne().getRelComidaAgua() * r.getPesoTipoCarne();
                    float impacGraoRed = r.getTipoGrao().getRelComidaAgua() * r.getPesoTipoGrao();
                    float impacVegetalRed = r.getTipoVegetal().getRelComidaAgua() * r.getPesoTipoVegetal();
                    float impacRef = impacCarneRed+impacGraoRed+impacVegetalRed; 
                    r.setImpactoRef(impacRef);
                    r.getPessoa().adicionarImpactoGeral(impacRef);
                    impacCalcView.preencherTextArea("Data: "+r.getData()+", Nome Ref: "+r.getNome()+", Impacto Ref: "+new DecimalFormat("#,###.#").format(r.getImpactoRef())+" Litros de Àgua"+"\n");
                }else{
                    impacCalcView.preencherTextArea("Data: "+r.getData()+", Nome Ref: "+r.getNome()+", Impacto Ref: "+new DecimalFormat("#,###.#").format(r.getImpactoRef())+" Litros de Àgua"+"\n");
                }
            }
        }
        if(impacCalcView.getTextArea().equals("")){
            for(Pessoa p : pessoas){
                if(impacCalcView.getPessoaSelecionada().equals(p) && p.getImpacGeral() == 0){
                    impacCalcView.preencherTextArea(p.getNome()+" Não Possui Nenhuma Refeição Cadastrada"+"\n");
                }
            }
        }
    }
    public void calcImpacTodasPes(){
        for(Pessoa p :pessoas){
            for(Refeicao r : refeicoes){
                if(r.getPessoa().equals(p)){
                    if(r.getImpactoRef()==0){
                        float impacCarneRed = r.getTipoCarne().getRelComidaAgua() * r.getPesoTipoCarne();
                        float impacGraoRed = r.getTipoGrao().getRelComidaAgua() * r.getPesoTipoGrao();
                        float impacVegetalRed = r.getTipoVegetal().getRelComidaAgua() * r.getPesoTipoVegetal();
                        float impacRef = impacCarneRed+impacGraoRed+impacVegetalRed; 
                        r.setImpactoRef(impacRef);
                        r.getPessoa().adicionarImpactoGeral(impacRef);
                    }
                }
            }
            impacCalcView.preencherTextArea("Nome: "+p.getNome()+", CPF: "+p.getCpf()+", Impacto Geral: "+new DecimalFormat("#,###.#").format(p.getImpacGeral())+"\n");
        }
        if(impacCalcView.getTextArea().equals("")){
            for(Pessoa p : pessoas){
                if(p.getImpacGeral() == 0){
                    impacCalcView.preencherTextArea(p.getNome()+" Não Possui Nenhuma Refeição Cadastrada"+"\n");
                }
            }
        }
    }
    public void limparTela(){
        impacCalcView.limparTextArea();
    }
}
