//ceng344-LAB3
//201611018
//Ecem Emiroðlu
import java.util.ArrayList;
import java.util.List;


public class Team {
	
	//initialize:
	
	private ArrayList <String> PlayerList;
	private String color;
	private int currentMatchPoint;
	private String teamName;
	
	//constructor
	public Team() {
		PlayerList=new ArrayList<String>();
		
	}
	
	//addplayer
	public void addPlayer(String player) {
		
		if(PlayerList.contains(player)) {
			System.out.println("This name is exist.Write another name");
		}else {
			PlayerList.add(player);
		}
		
		
		/*
		for(String s:PlayerList) {
			if(s.contains(player)) {
				System.out.println("This name is exist.");
			}else {
				PlayerList.add(player);		
				System.out.println("adding success");
				}
		}*/
	}
	//delete player
	public void deletePlayer(String plyr) {
		if(PlayerList.contains(plyr)) {
		PlayerList.remove(plyr);
		}else {
			System.out.println("This name is not exist.");
		}
		
	}
	//display information regarding team
	   public void displayTeamInfo(String plname) {
		   if(this.teamName.equals(plname)) {
	       System.out.println("Name : "+this.getTeamName()+", color :"+this.getColor());
	       System.out.println("Players Name: ");
	       for(String s : this.PlayerList) {
	    	   
	           System.out.println(s);
	       }
	   }else {
		   System.out.println("EMPTY");
	   }
	   }
	   
	   //this method return boolean true if the player is present in the team otherwise false
	   public boolean isAPlayer(String name) {
	       if(this.PlayerList.contains(name)) {
	           return true;
	       }
	       return false;
	   }
	   
	   //getter and setter:
	   
	   public ArrayList<String> getPlayerList() {
			return PlayerList;
		}
		public void setPlayerList(ArrayList<String> playerList) {
			PlayerList = playerList;
		}
		public String getColor() {
			return color;
		}
		public void setColor(String color) {
			this.color = color;
		}
		public int getCurrentMatchPoint() {
			return currentMatchPoint;
		}
		public void setCurrentMatchPoint(int currentMatchPoint) {
			this.currentMatchPoint = currentMatchPoint;
		}
		public String getTeamName() {
			return teamName;
		}
		public void setTeamName(String teamName) {
			this.teamName = teamName;
		}
}
