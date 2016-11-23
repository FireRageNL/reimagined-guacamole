/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.profile;

import reimaginedguacamole.game.Category;

/**
 * Class that holds information about right or wrong answers per category.
 * @author Marc
 */
public class Statistic {

    private Category category;
    private int right;
    private int wrong;
    
    public Statistic(Category category, int right, int wrong) {
        this.category = category;
        this.right = right;
        this.wrong = wrong;
    }

    public Category getCategory() {
        return category;
    }
        
    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }

    public int getWrong() {
        return wrong;
    }

    public void setWrong(int wrong) {
        this.wrong = wrong;
    }

    /**
     * Percentage of category questions anwsered right
     * @return Percentage(int)
     */
    public int returnPercentage(){
        int whole = right + wrong;
        double percentage = (double)right/(double)whole * 100;
        System.out.println(percentage);
        return (int)percentage;
    }

    //test commit
    //123
    
}
