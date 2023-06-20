    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interface;

import Model.Comida;
import java.util.List;

/**
 *
 * @author Usuário
 */
public interface IComidaDAO {
    
    public void adicionarComida(Comida a);
    public List<Comida> retornarTodasComidas();
}
