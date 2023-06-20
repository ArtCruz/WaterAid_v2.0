/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import static DAO.PessoaDAO.pessoas;
import static DAO.RefeicaoDAO.refeicoes;
import Model.Pessoa;
import Model.Refeicao;
import View.RankingGeralView;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Filipe Zulian
 */
public class RankingGeralController {

    private RankingGeralView rankGeralView;
    
    public RankingGeralController(RankingGeralView rankGeralView) {
        this.rankGeralView = rankGeralView;
        
        inicializarBotaoLimpar();
        inicializarBotaoMedia();
        inicializarBotaoTotal();
    }
    
    public void exibirTela(){
        rankGeralView.exibirTela();
    }
    
    public void inicializarBotaoMedia(){
        rankGeralView.adicionarAcaoBotaoMedia((ActionEvent e) -> {
        rankMedia();
        });
    }
    
    public void inicializarBotaoTotal(){
        rankGeralView.adicionarAcaoBotaoTotal((ActionEvent e) -> {
        rankTotal();
        });
    }
    
    public void inicializarBotaoLimpar(){
        rankGeralView.adicionarAcaoBotaoLimpar((ActionEvent e) -> {
        LimparTextArea();
        });
    }
    
    public void rankMedia(){
        List rankingPesMedia = new ArrayList();
        for(Pessoa p :pessoas){
            float impacRefMedia = 0;
            int contRef = 0;
            for(Refeicao r : refeicoes){
                if(r.getPessoa().equals(p)){
                    float impacCarneRed = r.getTipoCarne().getRelComidaAgua() * r.getPesoTipoCarne();
                    float impacGraoRed = r.getTipoGrao().getRelComidaAgua() * r.getPesoTipoGrao();
                    float impacVegetalRed = r.getTipoVegetal().getRelComidaAgua() * r.getPesoTipoVegetal();
                    float impacRef = impacCarneRed+impacGraoRed+impacVegetalRed; 
                    contRef++;
                    impacRefMedia += impacRef;
                }
            }
            rankingPesMedia.add(impacRefMedia/contRef);
        }
        Collections.sort(rankingPesMedia);
        Map<Integer, String> mapRankPesMedia = new HashMap<>();
        int cont = 0;
        for(int i =0;i<rankingPesMedia.size();i++){
            for(Pessoa p : pessoas){
                int contRef = 0;
                for(Refeicao r : refeicoes){
                    if(r.getPessoa().equals(p))
                        contRef++;
                }
                if(rankingPesMedia.get(i).equals(p.getImpacGeral()/contRef)){
                    cont++;
                    mapRankPesMedia.put(cont, "º Lugar | Nome: "+p.getNome()+",  CPF: "
                    +p.getCpf()+", Orientação Alimentar: "+p.getOrientacaoAlimentar()
                    +", Média Impacto por Refeição: "+new DecimalFormat("#,###.#").format(rankingPesMedia.get(i))
                    +", Qtd. Refeições: "+contRef);
                }
            }
        }
        for(Map.Entry mp : mapRankPesMedia.entrySet()){
            rankGeralView.preencherTextArea(mp.getKey()+""+mp.getValue()+"\n");
        }
        if(mapRankPesMedia.isEmpty())
            rankGeralView.preencherTextArea(" Vá para a sessão 'Impacto - Calcular Impacto' para calcular os Impactos das Refeições de cada Pessoa.");
        
    }
    
    public void rankTotal(){
        List rankingPesTotal = new ArrayList();
        for(Pessoa p :pessoas){
            float impacRefTotal = 0;
            for(Refeicao r : refeicoes){
                if(r.getPessoa().equals(p)){
                    float impacCarneRed = r.getTipoCarne().getRelComidaAgua() * r.getPesoTipoCarne();
                    float impacGraoRed = r.getTipoGrao().getRelComidaAgua() * r.getPesoTipoGrao();
                    float impacVegetalRed = r.getTipoVegetal().getRelComidaAgua() * r.getPesoTipoVegetal();
                    float impacRef = impacCarneRed+impacGraoRed+impacVegetalRed; 
                    impacRefTotal += impacRef;
                }
            }
            rankingPesTotal.add(impacRefTotal);
        }
        Collections.sort(rankingPesTotal);
        Map<Integer, String> mapRankPesTotal = new HashMap<>();
        int cont = 0;
        for(int i =0;i<rankingPesTotal.size();i++){
            for(Pessoa p : pessoas){
                if(rankingPesTotal.get(i).equals(p.getImpacGeral())){
                    cont++;
                    mapRankPesTotal.put(cont, "º Lugar | Nome: "+p.getNome()+",  CPF: "
                    +p.getCpf()+", Orientação Alimentar: "+p.getOrientacaoAlimentar()
                    +", Impacto: "+new DecimalFormat("#,###.#").format(rankingPesTotal.get(i)));
                }
            }
        }
        for(Map.Entry mp : mapRankPesTotal.entrySet()){
            rankGeralView.preencherTextArea(mp.getKey()+""+mp.getValue()+"\n");
        }
        if(mapRankPesTotal.isEmpty())
            rankGeralView.preencherTextArea(" Vá para a sessão 'Impacto - Calcular Impacto' para calcular os Impactos das Refeições de cada Pessoa.");
        
    }
    
    public void LimparTextArea(){
        rankGeralView.limparTextArea();
    }
    
}
