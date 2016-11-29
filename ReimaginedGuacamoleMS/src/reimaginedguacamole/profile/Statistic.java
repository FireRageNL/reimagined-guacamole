/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.profile;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import reimaginedguacamole.game.Category;

/**
 * Class that holds information about right or wrong answers per category.
 * @author Marc
 */
public class Statistic extends UnicastRemoteObject implements IStatistic,Serializable {

    private Category category;
    private int right;
    private int wrong;
    
    public Statistic(Category category, int right, int wrong) throws RemoteException {
        this.category = category;
        this.right = right;
        this.wrong = wrong;
    }

    @Override
    public Category getCategory() {
        return category;
    }
        
    @Override
    public int getRight() {
        return right;
    }

    @Override
    public void setRight(int right) {
        this.right = right;
    }

    @Override
    public int getWrong() {
        return wrong;
    }

    @Override
    public void setWrong(int wrong) {
        this.wrong = wrong;
    }

    /**
     * Percentage of category questions anwsered right
     * @return Percentage(int)
     */
    @Override
    public int returnPercentage(){
        int whole = right + wrong;
        double percentage = (double)right/(double)whole * 100;
        System.out.println(percentage);
        return (int)percentage;
    }

    

    
}
