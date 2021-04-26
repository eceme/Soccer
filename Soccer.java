//ceng344-LAB3
//201611018
//Ecem Emiroðlu

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Soccer {
	
	//Soccer attributes:
	ArrayList<Team> TeamList;
	int [] startDate=new int[3];
	int[] endDate=new int[3];
	int currentWeek;
	Team currentChampion;
	
	//constructor
	public Soccer() {
		TeamList=new ArrayList<Team>();
		currentChampion=new Team();
	}
	
	public void addSeasonInfo(int[]a,int[]b,int c) {
		this.startDate[0]=a[0];
		this.startDate[1]=a[1];
		this.startDate[2]=a[2];
		
		this.endDate[0]=b[0];
		this.endDate[1]=b[1];
		this.endDate[2]=b[2];
		
		this.currentWeek=c;
		
		
	}
	public void addTeam(Team t) {
		//Team t=new Team();
		TeamList.add(t);
	}
	public void deleteTeam(String nameT) {
		if(TeamList.removeIf(t->t.getTeamName().equals(nameT))) {
			System.out.println("remove object");
		}else {
			System.out.println("There are no teams with the given name in the system");
		}
	}
	
	//find champion
	public Team findChampion() {
		int max=0;
		Team temp=null;
		for(Team t1:this.TeamList) {
			if(t1.getCurrentMatchPoint()> max) {
				max=t1.getCurrentMatchPoint();
				temp=t1;
			}
		}
		
		return temp;
	}
	public void displayAllTeams() {
		 System.out.println(this.startDate[0]+"/"+this.startDate[1]+"/"+this.startDate[2]+"-"+this.endDate[0]+"/"+this.endDate[1]+"/"+this.endDate[2]+","+this.currentWeek+","+this.currentChampion.getTeamName());
	       for(Team t1 : this.TeamList) {
	           System.out.println(t1.getTeamName()+",Color("+t1.getColor()+")");
	       }
	}
	public void findPlayer(String pname) {
		 for(Team t1 : this.TeamList) {
	           if(t1.getPlayerList().contains(pname)) {
	               System.out.println(t1.getTeamName()+",Color("+t1.getColor()+")");
	           }
	           
	       }
	}
	
	public static void main(String[] args) {
		Soccer s =new Soccer();
		
			while(true) {
				System.out.println("Enter the number of the operation you want to choose");
				System.out.println("1. Add information about the current season\r\n"
						+ "2. Add a team\r\n"
						+ "3. Remove a team\r\n"
						+ "4. Add a player to the team\r\n"
						+ "5. Remove a player from the team\r\n"
						+ "6. Display all registered teams\r\n"
						+ "7. Display detailed information about a particular team\r\n"
						+ "8. Find which team(s) a player is playing for\r\n"
						+ "9. Find current champion\r\n"
						+ "10.Find out if a player is playing for a specific team\r\n"
						+ "11.Exit\n");
				
				Scanner sc=new Scanner(System.in);
				int num=sc.nextInt();
				sc.nextLine();//I added it so that it does not detect enter when receiving input
				
				if(num==1) {
					int[] s_input=new int[3];
					int[] e_input=new int[3];
					int a;
					System.out.println("Input start date(day,month,year)");
					for(int i=0;i<3;i++) {
						s_input[i]=sc.nextInt();
					}
					System.out.println("Input end date(day,month,year)");
					for(int i=0;i<3;i++) {
						e_input[i]=sc.nextInt();
					}
					System.out.println("Input current week(just number/3,4,5)");
					a=sc.nextInt();
					
					s.addSeasonInfo(s_input, e_input, a);
					
				}
				//add team (input from user name,color,current match point)
				if(num==2) {
					
					System.out.println("Add Team");
					Team t=new Team();
					System.out.println("Input Team Name: ");
					String teamname=sc.nextLine();
					//sc.nextLine();
					t.setTeamName(teamname);
					System.out.println("Input Team Color");
					String colorname=sc.nextLine();
					t.setColor(colorname);
					System.out.println("Input Current Match Point");
					int cur=sc.nextInt();
					t.setCurrentMatchPoint(cur);
					
					s.addTeam(t);
				}
				if(num==3) {
					System.out.println("Delete Team");
					System.out.println("Enter the name of the team you want to delete");
					String delteam=sc.nextLine();
					s.deleteTeam(delteam);
				}
				//I get a team name to know which team will be adding players
				if(num==4) {
					System.out.println("Add a player to the team");
					System.out.println("Which team will you add player to?-Input Team Name");
					String tname=sc.nextLine();
					for(Team t1 : s.TeamList) {
				           if(t1.getTeamName().equals(tname)) {
				        	   System.out.println("Input player name: ");
				        	   String pp=sc.nextLine();
				        	   t1.addPlayer(pp);
				           }
				       }
				}
				//I get a team name to know which team will be removing players
				if(num==5) {
					System.out.println("Remove a player to the team");
					System.out.println("Which team will you remove player to?-Input Team Name");
					String tname=sc.nextLine();
					for(Team t1 : s.TeamList) {
				           if(t1.getTeamName().equals(tname)) {
				        	   System.out.println("Input player name: ");
				        	   String pp=sc.nextLine();
				        	   t1.deletePlayer(pp);
				           }
				       }
				}
				//Show registered all teams:
				if(num==6) {
					System.out.println("All registered teams: ");
					s.displayAllTeams();
				}
				//Detailed info for enetered name of team:
				if(num==7) {
					System.out.println("Enter the name of the team whose detailed information you want to see: ");
					String tname=sc.nextLine();
					for(Team t1 : s.TeamList) {
				           if(t1.getTeamName().equals(tname)) {
				        	   t1.displayTeamInfo(tname);
				           }
					
				}
				
			}
				
				//Information on which teams the x player is playing
				if(num==8) {
					System.out.println("Find which team a player is playing for");
					System.out.println("Input Player Name");
					String iname=sc.nextLine();
					
					s.findPlayer(iname);
				}
				//Current champ :
				if(num==9) {
					System.out.println("Find Current Champion");
					
					System.out.println(s.findChampion().getTeamName());
				}
				//x users play for this team or not u
				if(num==10) {
					System.out.println("Input team name: ");
					String tname=sc.nextLine();
					System.out.println("Input player name: ");
					String inam=sc.nextLine();
					for(Team t1 : s.TeamList) {
				           if(t1.getTeamName().equals(tname)) {
				        	   if(t1.isAPlayer(inam)) {
				        		   System.out.println("This player plays in this team");
				        	   }else {
				        		   System.out.println("This player do not  plays in this team");
				        	   }
				           }
				}
				}
				//exit program
				if(num==11) {
					break;
				}
			}
		
		
		
		
		
		}
}
