/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.PessoaDAO;
import static DAO.RefeicaoDAO.refeicoes;
import Model.Pessoa;
import Model.Refeicao;
import View.ImpactoVisualizarView;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

/**
 *
 * @author Filipe Zulian
 */
public class ImpactoVisualizarController {
    
    private ImpactoVisualizarView impacVisView;

    public ImpactoVisualizarController(ImpactoVisualizarView impacVisView) {
        this.impacVisView = impacVisView;
        inicializarDadosTela();
        inicializarAcaoCMBPessoas();
        acaoCMBPessoas();
    }
    
    public void exibirTela(){
        impacVisView.exibirTela();
    }
    
    public void inicializarDadosTela(){
        PessoaDAO pessoaDAO = new PessoaDAO();
        Set<Pessoa> pessoas = pessoaDAO.retornarTodasPessoas();
        popularPessoas(pessoas);
    }
    
    public void inicializarAcaoCMBPessoas(){
        impacVisView.adicionarAcaoCMBPessoas((ActionEvent e) -> {
            acaoCMBPessoas();
        });
    }
    
    public void popularPessoas(Set<Pessoa> pessoas){
        ArrayList pessoasList = new ArrayList(pessoas);
        Collections.sort(pessoasList);
        for(Object p: pessoasList){
            impacVisView.addCMBPessoa((Pessoa)p);
        }
    }
    
    public void acaoCMBPessoas(){
        impacVisView.limparTAImpacLitAgua();
        impacVisView.limparTAImpacLitAguaCarne();
        impacVisView.limparTABanhosCarne();
        impacVisView.limparTAReaisCarne();

        double pesoCarneImpac = 0;
        double pesoGraoImpac = 0;
        double pesoVegetalImpac = 0;
        double impac = 0;
        for(Refeicao r : refeicoes){
            if(r.getPessoa().equals(impacVisView.getPessoaSelecionada())){
                pesoCarneImpac += r.getTipoCarne().getRelComidaAgua() * r.getPesoTipoCarne();
                pesoGraoImpac += r.getTipoGrao().getRelComidaAgua() * r.getPesoTipoGrao();
                pesoVegetalImpac += r.getTipoVegetal().getRelComidaAgua() * r.getPesoTipoVegetal();
            }
        }
        impac += pesoCarneImpac+pesoGraoImpac+pesoVegetalImpac;
        impacVisView.preencherTAImpacLitAgua(String.valueOf( new DecimalFormat("#,##0.000").format(impac)));

        impacVisView.preencherTAImpacLitAguaCarne(new DecimalFormat("#,##0.000").format(pesoCarneImpac));

        String impacLitBanho5min = new DecimalFormat("#,##0.00").format(pesoCarneImpac/45);
        impacVisView.preencherTABanhosCarne(String.valueOf(impacLitBanho5min));

        String impactLitReais = new DecimalFormat("#,##0.00").format((pesoCarneImpac/1000) * 3.8);
        impacVisView.preencherTAReaisCarne(String.valueOf(impactLitReais));
    }
    
}
