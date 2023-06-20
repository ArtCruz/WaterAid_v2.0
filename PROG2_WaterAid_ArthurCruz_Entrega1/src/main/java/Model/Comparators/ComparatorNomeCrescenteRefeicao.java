/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Comparators;

import Model.Refeicao;
import java.util.Comparator;

/**
 *
 * @author Usuário
 */
public class ComparatorNomeCrescenteRefeicao implements Comparator<Refeicao>{
    @Override
    public int compare(Refeicao r1, Refeicao r2) {
        if(r1.getPessoa().getNome().compareTo(r2.getPessoa().getNome())>0){
                return 1;
        }
        return -1;
    }
}
