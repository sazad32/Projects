
/**
 * The class <b>MontyHall</b> simulates one game. Is uses three <b>Door</b> objects
 * to simulate the three doors. One game consists of the following steps
 * <ol>
 * <li>Resets all three doors</li>
 * <li>Simulates the selection of one of the doors by the player</li>
 * <li>Simulates opening of an empty door by the host</li>
 * <li> provide the outcome for switching and not switching door</li>
 * </ol>
 * @author gvj (gvj@eecs.uottawa.ca)
 *
 */
 
import java.util.Random;
import java.util.ArrayList;

public class MontyHall {
	
	public Door Door1, Door2, Door3;
	public Door[] doorArray;
	public int prize_door_int,player_door_int,host_door_int,other_door_int;
	
 	public MontyHall()
		{
		Door1 = new Door("Door 1");
		Door2 = new Door("Door 2");
		Door3 = new Door("Door 3");
		doorArray = new Door[]{Door1,Door2,Door3};
		}
	

 	public void oneGame(){
		for(int i=0;i<3;i++)
		{
			doorArray[i].reset();
		}
		
		
		Random r= new Random();
		prize_door_int= r.nextInt(3);
		doorArray[prize_door_int].setPrize();
		Door player_door = pickADoor();
		Door host_door = openOtherDoor(doorArray[prize_door_int],player_door);
		
		
		String[] letters= new String[]{"A","B","C"};
		System.out.println("The prize is behind door "+letters[prize_door_int]+".");
		System.out.println("The player selected door "+letters[player_door_int]+".");
		System.out.println("The host opened door "+letters[host_door_int]+".");
		
		
		
		for(int i=0;i<3;i++)
				{
					if(doorArray[i].isChosen() || doorArray[i].isOpen())
					{
						}else{
	
							other_door_int = i;
							Door switch_door = doorArray[i];
						}
				}
		
		System.out.println("Switching to door "+letters[other_door_int]+".");
		
		if(other_door_int!=prize_door_int){
			System.out.println("Switching strategy would have lost.");
		} else{
			System.out.println("Switching strategy would have won.");	
		}
		
	}


 	private Door pickADoor()
	{	Random r= new Random();
		player_door_int= r.nextInt(3);
		doorArray[player_door_int].choose();
		
	return doorArray[player_door_int];}
	

 	private Door openOtherDoor(Door prizeDoor, Door selectedDoor)

		{
			ArrayList<Integer> host_doors = new ArrayList<Integer>();
			for(int i=0;i<3;i++)
				{
					if(doorArray[i].hasPrize() || doorArray[i].isChosen())
					{
						}else{
							host_doors.add(i);
						}
				}
				
			Random x= new Random();
			host_door_int = host_doors.get(x.nextInt(host_doors.size()));
			doorArray[host_door_int].open();
			return doorArray[host_door_int];
		}
	

	public static void main(String[] args) {

		MontyHall montyHall;
		
		StudentInfo.display();
		montyHall = new MontyHall();		
		montyHall.oneGame();
	}

}
