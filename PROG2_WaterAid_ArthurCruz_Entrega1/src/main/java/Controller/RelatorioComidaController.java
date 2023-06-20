/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import static DAO.ComidaDAO.comidas;
import Model.Comida;
import View.RelatorioComidaView;
import java.awt.event.ActionEvent;
import java.util.Collections;

/**
 *
 * @author Filipe Zulian
 */
public class RelatorioComidaController {
    
    private RelatorioComidaView relComidaView;

    public RelatorioComidaController(RelatorioComidaView relComidaView) {
        this.relComidaView = relComidaView;
        inicializarBotaoLimpar();
        inicializarBotaovisualizarRelatorioComida();
        inicializarCMBComidas();
    }
    
    
    
    public void exibirTela(){
        relComidaView.exibirTela();
    }
    
    public void inicializarBotaovisualizarRelatorioComida(){
        relComidaView.adicionarAcaoRetornarTodasRelatorioComida((ActionEvent e) -> {
        visualizarRelatorioComida();
        });    
    }
    
    public void visualizarRelatorioComida(){
        relComidaView.limparTextArea();
        Collections.sort(comidas);
        relComidaView.preencherTextArea("Carnes: "+"\n");
        for(Comida c : comidas){
            if(c.getTipoComida().equals("Carne")){
                    relComidaView.preencherTextArea("    "+c.toString()+"\n");
            }
        }
        relComidaView.preencherTextArea("Grãos: "+"\n");
        for(Comida c : comidas){
            if(c.getTipoComida().equals("Grão")){
                    relComidaView.preencherTextArea("    "+c.toString()+"\n");
            }
        }
        relComidaView.preencherTextArea("Vegetais: "+"\n");
        for(Comida c : comidas){
            if(c.getTipoComida().equals("Vegetal")){
                    relComidaView.preencherTextArea("    "+c.toString()+"\n");
            }
        }        
    }

    
    public void inicializarBotaoLimpar(){
        relComidaView.adicionarAcaoLimpar((ActionEvent e) -> {
        limparRelatorioComida();
        }); 
    }
    
    public void limparRelatorioComida(){
        relComidaView.limparTextArea();
    }
    
    public void inicializarCMBComidas(){
        relComidaView.adicionarAcaoCMBComidas((ActionEvent e) -> {
            popularTextAreaCMB();
        });
    }
    
    public void popularTextAreaCMB(){
        relComidaView.limparTextArea();
        Collections.sort(comidas);
        if(relComidaView.getTipoCarne().equals("Carnes")){
            relComidaView.preencherTextArea("Carnes: "+"\n");
            for(Comida c : comidas){
                if(c.getTipoComida().equals("Carne")){
                    relComidaView.preencherTextArea("    "+c.toString()+"\n");
                }
            }
        }
        if(relComidaView.getTipoCarne().equals("Grãos")){
            relComidaView.preencherTextArea("Grãos: "+"\n");
            for(Comida c : comidas){
                if(c.getTipoComida().equals("Grão")){
                    relComidaView.preencherTextArea("    "+c.toString()+"\n");
                }
            }
        }
        if(relComidaView.getTipoCarne().equals("Vegetais")){
            relComidaView.preencherTextArea("Vegetais: "+"\n");
            for(Comida c : comidas){
                if(c.getTipoComida().equals("Vegetal")){
                    relComidaView.preencherTextArea("    "+c.toString()+"\n");
                }
            }
        }
    }
}
