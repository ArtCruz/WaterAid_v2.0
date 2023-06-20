/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Interface.IRefeicaoDAO;
import Model.Refeicao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuário
 */
public class RefeicaoDAO implements IRefeicaoDAO{
    public static List<Refeicao> refeicoes = new ArrayList<>();

    @Override
    public void adicionarRefeicao(Refeicao r) {
        refeicoes.add(r);
    }

    @Override
    public List<Refeicao> recuperarTodasRefeicoes() {
        return refeicoes;
    }

    @Override
    public void removerRefeicao(Refeicao r) {
        refeicoes.remove(r);
    }
    
    
}
