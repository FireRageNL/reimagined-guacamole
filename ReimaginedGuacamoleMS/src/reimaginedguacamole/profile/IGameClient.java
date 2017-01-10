/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.profile;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import reimaginedguacamole.game.GameState;

/**
 *
 * @author roy_v
 */
public interface IGameClient extends Remote {

    /**
     * Get the profile that is associated with the gameclient
     *
     * @return the profile associated with the gameclient
     * @throws RemoteException
     */
    public IProfile getProfile() throws RemoteException;

    /**
     * Function that gets called when a gameclient joins a game
     *
     * @throws RemoteException
     */
    public void joinGame() throws RemoteException;

    /**
     * Function to disable or enable the start button of a game
     *
     * @param state boolean to set the start button
     * @throws RemoteException
     */
    public void disableStartButton(boolean state) throws RemoteException;

    /**
     * Function to disable all buttons of a client
     *
     * @param state boolean to set all the buttons
     * @throws RemoteException
     */
    public void disableButtons(boolean state) throws RemoteException;

    /**
     * Function to disable the spin button
     *
     * @param state boolean to set the spin button
     * @throws RemoteException
     */
    public void disableSpinButton(boolean state) throws RemoteException;

    /**
     * Function that gets called when a gamestate changes or when a gamestate is
     * used for something else.
     *
     * @param gameState the gamestate that has been set
     * @throws RemoteException
     */
    public void checkGameState(GameState gameState) throws RemoteException;

    /**
     * Function to set the current user index
     * @param i the index to set
     * @throws RemoteException 
     */
    public void setUserIndex(int i) throws RemoteException;

    /**
     * Function to spin the wheel when the spin button is clicked
     * @param wheelspeed the amount of pixels the wheel has to turn each tick
     * @param time the time that the wheel has to spin
     * @throws RemoteException 
     */
    public void spinWheel(int wheelspeed, int time) throws RemoteException;

    /**
     * Function to refresh the current gameUI
     * @param scores a array of scores
     * @param names the names associated with the scores
     * @throws RemoteException 
     */
    public void refreshUI(int[] scores, List<String> names) throws RemoteException;
    
    
    public IClient getChatClient() throws RemoteException;
}
