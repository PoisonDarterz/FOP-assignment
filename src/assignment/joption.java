/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

import javax.swing.*;
import javax.swing.JOptionPane;
public class joption {
   
  public static void main(String[] args) {
    /* Simple JOptionPane ShowOptionDialogJava example */    
    String[] options = { "rock", "paper", "scissors" };
    var selection = JOptionPane.showOptionDialog(null, "Select one:\n 1. show total \n2.show happa", "Let's play a game!", 
                                                      0, 3, null, options, options[0]);
    if (selection == 0) {
      JOptionPane.showMessageDialog(null, "You chose rock!");
    }
    if (selection == 1) { 
      JOptionPane.showMessageDialog(null, "You chose paper.");
    }
    if (selection == 2) { 
      JOptionPane.showMessageDialog(null, "You chose scissors!");
    }
  }

}
