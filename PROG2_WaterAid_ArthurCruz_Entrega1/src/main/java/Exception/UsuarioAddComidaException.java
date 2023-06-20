/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exception;

/**
 *
 * @author Usuário
 */
public class UsuarioAddComidaException extends Exception{
    public UsuarioAddComidaException(){
        super("Somente Administradores podem Cadastrar Novas Comidas");
    }
}
