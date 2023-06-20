/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;

import Model.Refeicao;
import java.util.List;

/**
 *
 * @author Usuário
 */
public interface IRefeicaoDAO {
    public void adicionarRefeicao(Refeicao r);
    public List<Refeicao> recuperarTodasRefeicoes();
    public void removerRefeicao(Refeicao r);
}
