/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.gameserver;

import java.net.UnknownHostException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import reimaginedguacamole.game.GameRoom;
import reimaginedguacamole.game.GameState;
import reimaginedguacamole.game.IGameRoom;
import reimaginedguacamole.game.Score;
import reimaginedguacamole.networking.IMasterServer;
import reimaginedguacamole.profile.ChatServer;
import reimaginedguacamole.profile.IChatServer;
import reimaginedguacamole.profile.IGameClient;
import reimaginedguacamole.profile.IGameServer;

/**
 *
 * @author roy_v
 */
public class GameServer extends UnicastRemoteObject implements IGameServer {

    private GameRoom gameRoom;
    private IChatServer chatServer;
    private String ip;

    /**
     * Constructor to override default constructor
     * @throws RemoteException 
     */
    public GameServer() throws RemoteException {
        //Such override
        chatServer = new ChatServer();
    }


    @Override
    public IGameRoom createGameRoom(int duration, int rounds, String roomname, String ip, IMasterServer ms) throws RemoteException {
        this.ip = ip;
        try {
            gameRoom = new GameRoom(duration, rounds, roomname, ip, this,ms);
            sendGameRoomData();
            Logger.getLogger(GameServer.class.getName()).log(Level.INFO, "Added a new GameRoom: {0}", gameRoom.getName());
            return gameRoom;
        } catch (NotBoundException | UnknownHostException ex) {
            Logger.getLogger(GameServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public IGameRoom sendGameRoomData() throws RemoteException {
        return gameRoom;
    }

    @Override
    public void joinRoom(IGameClient user) throws RemoteException {
        try {

            gameRoom.joinRoom(user);
            user.joinGame();
            if (gameRoom.getNrOfPlayers() == 4) {
                user.disableStartButton(false);
            }
        } catch (RemoteException ex) {
            Logger.getLogger(GameServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void leaveRoom(IGameClient user) throws RemoteException{
        gameRoom.leaveRoom(user);
    }
    @Override
    public synchronized void startGame(IGameRoom joinedRoom) throws RemoteException {
        joinedRoom.getGameController().startNextRound();
        joinedRoom.getGameController().setGameState(GameState.WAITINGFORCATEGORY);
        this.getUserIndex(joinedRoom);
    }

    @Override
    public synchronized void nextRound(IGameRoom joinedRoom) throws RemoteException {
        joinedRoom.addPlayerDone();
        if (joinedRoom.getPlayersDone() == 4) {
            joinedRoom.setPlayersDone();
            if (joinedRoom.getGameController().getCurrentRoundIndex() < Integer.parseInt(joinedRoom.getNumberOfRounds()) - 1 ) {
                joinedRoom.getGameController().startNextRound();
                joinedRoom.getGameController().setGameState(GameState.WAITINGFORCATEGORY);
            } else {
                broadcastGameState(GameState.GAMEFINISHED, joinedRoom);
            }
        }
    }

    @Override
    public void broadcastGameState(GameState gameState, IGameRoom gr) throws RemoteException {
        for (IGameClient c : gr.getPlayers()) {
            c.checkGameState(gameState);
        }
    }

    @Override
    public int getCurrentUser(IGameRoom joinedRoom) throws RemoteException {
        return joinedRoom.getGameController().getCurrentUser();
    }

    @Override
    public void getUserIndex(IGameRoom joinedRoom) throws RemoteException {
        int i = 0;
        for (IGameClient c : joinedRoom.getPlayers()) {
            c.setUserIndex(i);
            i++;
        }
    }

    @Override
    public void spinWheel(IGameRoom joinedRoom) throws RemoteException {
        Random rng = new Random();
        int speed = 200 + rng.nextInt(200);
        int time = 5000 + rng.nextInt(3000);
        for (IGameClient c : joinedRoom.getPlayers()) {
            c.spinWheel(speed, time);
        }
    }

    @Override
    public synchronized void stopSpin(IGameRoom joinedRoom, double rotation) throws RemoteException {
        joinedRoom.addPlayerDone();
        if (joinedRoom.getPlayersDone() == 4) {
            joinedRoom.getGameController().giveRoundQuestion(joinedRoom.getGameController().chooseCategory(rotation));
            joinedRoom.setPlayersDone();
            Logger.getLogger(GameServer.class.getCanonicalName()).log(Level.INFO,"All players stopped spinning!");
            this.broadcastGameState(GameState.SPINNINGFINISHED, joinedRoom);
        }
    }

    @Override
    public String getCategory(IGameRoom joinedRoom) throws RemoteException {
        return joinedRoom.getGameController().getCurrentRound().getQuestion().getCategory().toString();
    }

    @Override
    public synchronized void startRound(IGameRoom joinedRoom) throws RemoteException {
        joinedRoom.addPlayerDone();
        if (joinedRoom.getPlayersDone() == 4) {
            joinedRoom.setPlayersDone();
            this.broadcastGameState(GameState.GAMERUNNING, joinedRoom);
        }
    }

    @Override
    public List<String> getQuestion(IGameRoom joinedRoom) throws RemoteException {
        List<String> question = new ArrayList();
        question.add(joinedRoom.getGameController().getCurrentRound().getQuestion().getQuestionContents());
        question.add(joinedRoom.getGameController().getCurrentRound().getQuestion().getAnswer1());
        question.add(joinedRoom.getGameController().getCurrentRound().getQuestion().getAnswer2());
        question.add(joinedRoom.getGameController().getCurrentRound().getQuestion().getAnswer3());
        question.add(joinedRoom.getGameController().getCurrentRound().getQuestion().getAnswer4());
        question.add(String.valueOf(joinedRoom.getGameController().getCurrentRound().getQuestion().getCorrectAnswer()));
        return question;
    }

    @Override
    public synchronized void playerAnswered(IGameRoom joinedRoom) throws RemoteException {
        joinedRoom.addPlayerDone();
        if (joinedRoom.getPlayersDone() == 4) {
            joinedRoom.setPlayersDone();
            this.broadcastGameState(GameState.ANSWERED, joinedRoom);
        }
    }

    @Override
    public synchronized void checkAnswers(IGameRoom joinedRoom, int userIndex, int score) throws RemoteException {
        joinedRoom.addPlayerDone();
        joinedRoom.getPlayers().get(userIndex).getProfile().addScore(score);

        if (joinedRoom.getPlayersDone() == 4) {
            joinedRoom.setPlayersDone();
            Logger.getLogger(GameServer.class.getCanonicalName()).log(Level.INFO,"All players finished submitting scores!");
            this.broadcastGameState(GameState.WAITINGFORPLAYERS, joinedRoom);
        }
    }

    @Override
    public void refreshUI(IGameRoom joinedRoom) throws RemoteException {
        List<String> names = new ArrayList();
        List<Score> scores = new ArrayList<Score>();
        int i = 0;
        for (IGameClient c : joinedRoom.getPlayers()) {
            Score s = new Score(c.getProfile().getNickname(),c.getProfile().getScore());
            scores.add(s);
        }
        Collections.sort(scores);
        Collections.reverse(scores);
        for (IGameClient c : joinedRoom.getPlayers()) {

            c.refreshUI(scores);
        }
    }
    
    @Override 
    public IChatServer getChatServer(){
        return chatServer;
    }

    @Override
    public String getIp() throws RemoteException {
        return ip;
    }

}
