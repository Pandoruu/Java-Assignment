import java.io.IOException;
import java.util.ArrayList;
import java.util.*;
public class Player {
    private String name;
    private Board board;
    private ArrayList<Ship> ships ;
    //contractor
    public Player(){
        this.ships = new ArrayList<>();
        this.board = new Board();
        ships.add(new Ship("Patrol Boat", 2));
        ships.add(new Ship("Patrol Boat", 2));
        ships.add(new Ship("Destroyer Boat", 4));
        ships.add(new Ship("Submarine", 3));
        ships.add(new Ship("Battle Ship", 5));
    }
    //setter
    public void setName(String name){
        this.name=name;
    }
    //getter
    public Board getBoard(){
        return board;
    }
    public String getName(){
        return name;
    }

    public void placeShips() throws IOException {
        Scanner sc = new Scanner(System.in);

        while(!ships.isEmpty()){
            board.showBoard("owner");
            System.out.println(name + ", Place your ship(s): ");
            System.out.println("Available ships to place:");
            for(int i=0; i<ships.size(); i++){
                System.out.println((i + 1) + ". " + ships.get(i).getShipName() + ": Size = " + ships.get(i).getShipLength());
            }
            System.out.print("Select ship number: ");
            int num = sc.nextInt() - 1;
            if(num<0 || num>=ships.size()){
                System.out.println("Invalid! Choose again!");
                continue;
            }
            System.out.print("Enter coordinates of the ship's head (Ex:A 1): ");
            char tmp = sc.next().toUpperCase().charAt(0);
            int r = tmp - 'A';
            int c = sc.nextInt() - 1;
            System.out.print("Enter direction of the ship (H for horizontal, V for vertical): ");
            char direction = sc.next().toUpperCase().charAt(0);
            if(board.placeShip(ships.get(num),r,c,direction)){
                ships.remove(ships.get(num));
            }
            else{
                System.out.println("Invalid! Try again!");
                System.out.println("<<press any key to Try again>>");
                System.in.read();
            }
            GameManager.clearScreen();
        }
    }

    public boolean receiveAttack(int r, int c){
        boolean hit = board.attackCoordinates(r,c);
        if(hit){
            for(Ship ship: ships){
                if(ship.checkHit(r,c)){
                    ship.hit();
                    if(ship.isSunk()){
                        System.out.println(name + " lost a ship!");
                    }
                    break;
                }
            }
        }
        return hit;
    }
    public boolean hasLost() {
        for (Ship ship : ships) {
            if (!ship.isSunk()) return false;
        }
        return true;
    }
}