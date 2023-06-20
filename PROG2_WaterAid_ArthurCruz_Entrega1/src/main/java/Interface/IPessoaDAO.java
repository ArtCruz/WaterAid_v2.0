/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interface;

import Model.Pessoa;
import java.util.Set;

public interface IPessoaDAO {
    
    public void adicionarPessoa(Pessoa p);
    public Set<Pessoa> retornarTodasPessoas();
    public void removerPessoa(Pessoa p);
}
