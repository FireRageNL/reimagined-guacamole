/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.game;

/**
 *Enum for different categories in the game
 * @author Marc
 */
public enum Category {
    History {
        @Override
        public String toString(){
            return "Geschiedenis";
        }
    },
    Art{
        @Override
        public String toString(){
            return "Kunst";
        }
    },
    Games{
        @Override
        public String toString(){
            return "Spellen";
        }
    },
    Entertainment,
    Music{
        @Override
        public String toString(){
            return "Muziek";
        }
    },
    Sport,
    Science{
        @Override
        public String toString(){
            return "Wetenschap";
        }
    }  
}
