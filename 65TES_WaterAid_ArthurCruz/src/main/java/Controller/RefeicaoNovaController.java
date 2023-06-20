/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import static DAO.ComidaDAO.comidas;
import static DAO.PessoaDAO.pessoas;
import DAO.RefeicaoDAO;
import Exception.CampoVazioException;
import Exception.PesoComidaInvalidoException;
import Model.Carne;
import Model.Comida;
import Model.Grao;
import Model.Pessoa;
import Model.Refeicao;
import Model.Vegetal;
import View.RefeicaoNovaView;
import java.awt.event.ActionEvent;
import java.util.Collections;
import java.util.Set;
import javax.swing.JOptionPane;

/**
 *
 * @author Filipe Zulian
 */
public class RefeicaoNovaController {
    private RefeicaoNovaView refeicaoNovaView;  

    public RefeicaoNovaController(RefeicaoNovaView refeicaoNovaView) {
        this.refeicaoNovaView = refeicaoNovaView;
        inicializarDadosTelas();
        inicializarBotoes();
    }
    
    public void exibirTela(){
        refeicaoNovaView.exibirTela();
    }
    
    public void inicializarDadosTelas(){
        addCMBComidas();
        popularPessoas(pessoas);
    }
    
    public void inicializarBotoes(){
        refeicaoNovaView.adicionarAcaoBotaoRefNova((ActionEvent e) ->{
        salvarRefeicaoNova();
        });
    }
    
    public void addCMBComidas(){
        Collections.sort(comidas);
        for(Comida c : comidas){
            if(c.getTipoComida().equals("Carne")){
                refeicaoNovaView.addCMBCarne(c);
            }
            if(c.getTipoComida().equals("Grão")){
                refeicaoNovaView.addCMBGrao(c);
            }
            if(c.getTipoComida().equals("Vegetal")){
                refeicaoNovaView.addCMBVegetal(c);
            }
        }   
    }
    
    public void popularPessoas(Set<Pessoa> pessoas){
        for(Pessoa p : pessoas)
            refeicaoNovaView.addCMBPessoa(p);
    }
        
    public void salvarRefeicaoNova(){
        Refeicao r = null;
        RefeicaoDAO refeicaoDAO = new RefeicaoDAO();
        
        String dataRefNova = refeicaoNovaView.getDataRefNova();
        String nomeRefNova = refeicaoNovaView.getNomeRefNova();
        Object userRefNova = refeicaoNovaView.getUserRefNova();
        
        Object tipoCarneRefNova = refeicaoNovaView.getTipoCarneRefNova();
        Object tipoGraoRefNova = refeicaoNovaView.getTipoGraoRefNova();
        Object tipoVegetalRefNova = refeicaoNovaView.getTipoVegetalRefNova();
        
        r = new Refeicao();
        try{
            float pesoTipoCarne = Float.parseFloat(refeicaoNovaView.getPesoTipoCarne());
            float pesoTipoGrao = Float.parseFloat(refeicaoNovaView.getPesoTipoGrao());
            float pesoTipoVegetal = Float.parseFloat(refeicaoNovaView.getPesoTipoVegetal());
        
            r.setData(dataRefNova);
            r.setNome(nomeRefNova);
            if(pessoas.isEmpty()){
                JOptionPane.showMessageDialog(null, "Cadastre uma Pessoa");
            }else{
                r.setPessoa((Pessoa)userRefNova);
                r.setTipoCarne((Carne) tipoCarneRefNova);
                r.setTipoGrao((Grao) tipoGraoRefNova);
                r.setTipoVegetal((Vegetal) tipoVegetalRefNova);
                r.setPesoTipoCarne(pesoTipoCarne);
                r.setPesoTipoGrao(pesoTipoGrao);
                r.setPesoTipoVegetal(pesoTipoVegetal);
                refeicaoDAO.adicionarRefeicao(r);
                JOptionPane.showMessageDialog(null, "Refeição salva com sucesso!");
            }
        } catch (CampoVazioException |PesoComidaInvalidoException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Preencha os campos 'Peso:' com Números Inteiros e/ou Decimais ");
        }
    }
}
