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
    HISTORY {
        @Override
        public String toString(){
            return "Geschiedenis";
        }
    },
    ART{
        @Override
        public String toString(){
            return "Kunst";
        }
    },
    GAMES{
        @Override
        public String toString(){
            return "Spellen";
        }
    },
    ENTERTAINMENT{
        @Override
        public String toString(){
            return "Entertainment";
        }
    },
    MUSIC{
        @Override
        public String toString(){
            return "Muziek";
        }
    },
    SPORT{
        @Override
        public String toString(){
            return "Sport";
        }
    },
    SCIENCE{
        @Override
        public String toString(){
            return "Wetenschap";
        }
    }, Music  
}
