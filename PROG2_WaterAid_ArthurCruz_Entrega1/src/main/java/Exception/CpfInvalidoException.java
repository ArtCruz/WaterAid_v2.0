/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exception;

/**
 *
 * @author Usuário
 */
public class CpfInvalidoException extends Exception{
    
    public CpfInvalidoException(){
        super("Insira um CPF válido");
    }
}
