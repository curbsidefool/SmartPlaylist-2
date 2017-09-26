import com.echonest.api.v4.Artist;
import com.echonest.api.v4.EchoNestAPI;
import com.echonest.api.v4.EchoNestException;
import com.echonest.api.v4.Song;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class Driver {
    @SuppressWarnings("resource")
	public static void main(String[] args) throws EchoNestException {
    	
    	Scanner sc = new Scanner(System.in);
    	String s = sc.nextLine();
        String API_KEY = "SHCVOVEYFZ3D5XVVJ";
        EchoNestAPI echoNest = new EchoNestAPI(API_KEY);
        int x = 0;
        List<Artist> hotArtists = echoNest.topHotArtists(x, 1000);
        
        List<Song> songList = new ArrayList<Song>();
        boolean flag = true;
        for(int i = 0; i < hotArtists.size(); i++){
        	if(hotArtists.get(i).getName().equals(s)){
        		flag = true;
        		songList = hotArtists.get(i).getSongs();
        		break;
                }
        	else{
        		flag = false;
        	}
        }
        if(flag == false){
        	System.out.println("We couldnt find your artist.");
        	System.exit(0);
        }
        
        String songInput = sc.nextLine();
        String placeHolder = "SOSIFOJ14F33E91E6B";
        Song currentSong = new Song(echoNest,placeHolder);
        for(int i = 0; i < songList.size(); i++){
        	if(songList.get(i).getTitle().equals(songInput)){
        		flag = true;
        		currentSong = songList.get(i);
        		break;
        	}
        	else{
        		flag = false;
        	}
        }
        if(flag == false){
        	System.out.println("We couldnt find your song.");
        	System.exit(0);
        }
        try {
        	FileInputStream fis= new FileInputStream("/Users/Swellio/Downloads/Hotline Bling.mp3");
        	if(currentSong.getTitle().equals("Work")){
        	fis= new FileInputStream("/Users/Swellio/Downloads/Rihanna - Work ft. Drake (lyrics).mp3");
        	}
			try {
				Player playMP3 = new Player(fis);
				playMP3.play();
			} catch (JavaLayerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        List<DanceMoves> danceMoves = new ArrayList<DanceMoves>();
        DanceMoves move1 = new DanceMoves(12,135,"Hotline Bling");
        DanceMoves move2 = new DanceMoves(12,95,"Work");
        danceMoves.add(move1);
        danceMoves.add(move2);
       for(int i = 0; i < danceMoves.size(); i++){
    	   if(Math.abs((danceMoves.get(i).getKey() - currentSong.getKey())) <= 5 && Math.abs((danceMoves.get(i).getTempo() - currentSong.getTempo())) <= 5){
    		  
		
    	   }
       }
    }
}