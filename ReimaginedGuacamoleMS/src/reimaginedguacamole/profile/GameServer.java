/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.profile;

import java.net.UnknownHostException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import reimaginedguacamole.game.GameRoom;
import reimaginedguacamole.game.GameState;
import reimaginedguacamole.game.IGameRoom;
import reimaginedguacamolems.database.ProfileDB;

/**
 *
 * @author roy_v
 */
public class GameServer extends UnicastRemoteObject implements IGameServer {

    private List<IGameRoom> gameRooms = new ArrayList<>();
    
    public GameServer() throws RemoteException{
        //Wooo new thingy :D
    }
    
    @Override
    public boolean tryLogin(String username, String password) throws RemoteException {
        ProfileDB pdb = new ProfileDB();
        boolean login = pdb.login(password, username);
        if (!login) {
            Logger.getLogger(GameServer.class.getName()).log(Level.INFO, "Login try for user " + username + " failed");
        } else {
            Logger.getLogger(GameServer.class.getName()).log(Level.INFO, "Login try for user " + username + " succeded");
        }
        return login;
    }

    @Override
    public IProfile getCurrentProfile(String email) throws RemoteException {
        ProfileDB pdb = new ProfileDB();
        return pdb.getProfileData(email);
    }

    @Override
    public void registerNewUser(Map profileData) throws RemoteException {
        ProfileDB pdb = new ProfileDB();
        pdb.newUserRegistration(profileData);
        Logger.getLogger(Register.class.getName()).log(Level.INFO, "User registration!");
    }

    @Override
    public IGameRoom createGameRoom(int duration, int rounds,String roomname, String ip) throws RemoteException {
        GameRoom gr;
        try {
            gr = new GameRoom(duration,rounds,roomname,ip,this);
            gameRooms.add(gr);
            sendGameRoomData();
            Logger.getLogger(GameServer.class.getName()).log(Level.INFO,"Added a new GameRoom: {0}",gr.getName());
            return gr;
        } catch (NotBoundException | UnknownHostException ex) {
            Logger.getLogger(GameServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<IGameRoom> sendGameRoomData() throws RemoteException {
        return gameRooms;      
    }


    @Override
    public void joinRoom(IGameClient user, IGameRoom room) throws RemoteException{
        try {
            
            room.joinRoom(user);
            user.joinGame();
            if(room.getNrOfPlayers() == 4){
            user.disableStartButton(false);
            }
        } catch (RemoteException ex) {
            Logger.getLogger(GameServer.class.getName()).log(Level.SEVERE, null, ex);
        }
 }

    @Override
    public void startGame(IGameRoom joinedRoom) throws RemoteException {
        joinedRoom.getGameController().startNextRound();
        joinedRoom.getGameController().setGameState(GameState.WAITINGFORCATEGORY);
        this.getUserIndex(joinedRoom);
    }
    @Override
    public void broadcastGameState(GameState gameState, IGameRoom gr) throws RemoteException {
        for(IGameClient c: gr.getPlayers()){
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
        for(IGameClient c: joinedRoom.getPlayers()){
            c.setUserIndex(i);
            i++;
        }
    }

    @Override
    public void spinWheel(IGameRoom joinedRoom) throws RemoteException {
        Random rng = new Random();
        int speed = 200+ rng.nextInt(200);
        int time = 5000 + rng.nextInt(3000);
        System.out.println("SPIN THE WHEEL" + speed + "--"+time);
        for(IGameClient c: joinedRoom.getPlayers()){
            c.spinWheel(speed,time);
        }
    }

    @Override
    public void stopSpin(IGameRoom joinedRoom, double rotation) throws RemoteException {
        joinedRoom.addPlayerDone();
        System.out.println("one player done spinning");
        if(joinedRoom.getPlayersDone() == 4){
            joinedRoom.getGameController().giveRoundQuestion(joinedRoom.getGameController().chooseCategory(rotation));
            joinedRoom.setPlayersDone();
            System.out.println("ALl players done spinning");
            this.broadcastGameState(GameState.SPINNINGFINISHED, joinedRoom);
        }
    }

    @Override
    public String getCategory(IGameRoom joinedRoom) throws RemoteException {
        return joinedRoom.getGameController().getCurrentRound().getQuestion().getCategory().toString();
    }

    @Override
    public void startRound(IGameRoom joinedRoom) throws RemoteException {
        joinedRoom.addPlayerDone();
        if(joinedRoom.getPlayersDone() == 4){
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
    public void playerAnswered(IGameRoom joinedRoom) throws RemoteException {
        joinedRoom.addPlayerDone();
        if(joinedRoom.getPlayersDone() == 4){
            joinedRoom.setPlayersDone();
            this.broadcastGameState(GameState.ANSWERED, joinedRoom);
        }
    }

    @Override
    public synchronized void checkAnswers(IGameRoom joinedRoom, int userIndex, int givenAnswer, double timeLeft) throws RemoteException {
        joinedRoom.addPlayerDone();
        int score = 0;
        System.out.println("in de methode!");
        System.out.println("index "+userIndex+" GivenAnswer "+ givenAnswer+" en timeleft" + timeLeft);
        if(givenAnswer == joinedRoom.getGameController().getCorrectAnswer()){
            score = 50 + ( 100 + (int)(timeLeft*100));
            System.out.println(score);
            System.out.println("antwoord goed!");
            joinedRoom.getPlayers().get(userIndex).getProfile().addScore(score);
            
        }
        if(joinedRoom.getPlayersDone() == 4){
            joinedRoom.setPlayersDone();
            System.out.println("ik ben de laatste, dus we gaan lekker door!");
            this.broadcastGameState(GameState.WAITINGFORPLAYERS, joinedRoom);
        }
    }

    @Override
    public void refreshUI(IGameRoom joinedRoom) throws RemoteException {
        int[] scores = new int[4];
        List<String> names = new ArrayList();
        int i = 0;
        for (IGameClient c : joinedRoom.getPlayers()){
            scores[i] = c.getProfile().getScore();
            System.out.println(scores[i]);
            names.add(c.getProfile().getNickname());
        }
        for(IGameClient c : joinedRoom.getPlayers()){
            
            c.refreshUI(scores,names);
        }
    }
    
    
    
    
    
}
