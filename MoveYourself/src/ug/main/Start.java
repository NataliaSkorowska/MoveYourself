/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ug.main;
import ug.frontend.StartFrame;
/**
 *
 * @author deerx
 */
public class Start {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       StartFrame sf=new StartFrame();
        sf.setSize(640,480);
        sf.setTitle("Welcome");
        sf.setVisible(true);
    }
    
}
