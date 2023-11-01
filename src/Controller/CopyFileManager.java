/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import common.Library;
import view.Menu;

/**
 *
 * @author DELL
 */
public class CopyFileManager extends Menu<String> {
    static String[] mc = {"Copy Files", "Exit"};
    
    public CopyFileManager(){
        super("\tFILE COPY PROGRAM", mc);
    }

    @Override
    public void execute(int n) {
        switch(n) {
            case 1-> Library.readFileConfig(); 
            case 2-> System.exit(0);  
        }
    }

}
