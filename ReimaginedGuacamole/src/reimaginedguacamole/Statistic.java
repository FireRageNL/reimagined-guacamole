/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole;

import java.util.List;

/**
 *
 * @author Marc
 */
public class Statistic {

    private Category category;
    private int right;
    private int wrong;
    private List<GameInfo> QuestionStatistics;
    
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
    public int returnPercenntage(){
        return 0;
    }

    

    
}
