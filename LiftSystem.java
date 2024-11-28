package programs;

import java.util.ArrayList;
import java.util.List;
class Passenger{
    private int destinationFloor;

    public Passenger(int destinationFloor){
        this.destinationFloor = destinationFloor;
    }
    public int getdestinationFloor(){
        return destinationFloor;
    }

}

class Lift{

        private int currentFloor;
        private String state;
        private List <Passenger> passengers;

        public Lift(){
            this.currentFloor=1;
            this.state="stopped";
            this.passengers=new ArrayList<>();
        }

        public int getCurrentFloor(){
            return currentFloor;
        }
        public String getState(){
            return state;
        }
        public List<Passenger> getPassengers(){
            return passengers;
        }

        public void addPassenger(Passenger passenger){
            passengers.add(passenger);
        }
        public boolean move(int destinationFloor) {
            if(destinationFloor==currentFloor){
                return false;
            }
            state=(destinationFloor>currentFloor)?"moving up":"moving down";

            //update the current floor
            currentFloor=destinationFloor;
            state="stopped";
            return true;
        } 

        public List<Passenger> openDoors(){
            List<Passenger> exitedPassengers=new ArrayList<>();
            List<Passenger> remainingPassengers=new ArrayList<>();
            for(Passenger passenger:passengers ){
                if (passenger.getdestinationFloor() == currentFloor) {
                    exitedPassengers.add(passenger);
                }
                
                else{
                remainingPassengers.add(passenger);
                  }
                }
            
        passengers=remainingPassengers;
        return exitedPassengers;

       }   
    
        public void closeDoors(){
            System.out.println("the door is closed");
        }


}

public class LiftSystem{
    public static void main(String[] args) {
        Lift lift=new Lift();
        lift.addPassenger(new Passenger(5));
        lift.addPassenger(new Passenger(3));
        boolean moved=lift.move(5);
        System.out.println(moved);
        System.out.println(lift.getCurrentFloor());
        List<Passenger> exitedPassengers=lift.openDoors();
        
        
        System.out.println(exitedPassengers.size());
        System.out .println(lift.getCurrentFloor());
        lift.closeDoors();
    }
}