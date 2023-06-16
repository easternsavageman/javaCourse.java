// Part 1

/*
SaturnSL1 sl = new SaturnSL1( ); // will compile WITHOUT errors, will run WITHOUT errors			
HondaCivic hc = new HondaCivic( ); // will compile WITHOUT errors, will run WITHOUT errors
Japanese jp = new Japanese( ); // will compile WITH errors, reason for error: Japanese is not a class object, therefore it cannot be instantiated		
German gr = new MercedesC230( ); // will compile WITHOUT errors, will run WITHOUT errors	
ChevyS10 cs = new Truck( );	// will compile WITH errors, reason for error: Truck is not a class object, therefore it cannot be instantiated	
SubaruOutback sb = new SubaruOutback( ); // will compile WITHOUT errors, will run WITHOUT errors		
Domestic dm = sl; // will compile WITHOUT errors, will run WITHOUT errors
dm = hc; // will compile WITH errors, reason for error: Domestic is not implemented by the class HondaCivic		
dm = (Domestic) hc;	// will compile WITHOUT errors, will run WITHOUT errors	
dm = cs; // will compile WITHOUT errors, will run WITHOUT errors			
dm = (Domestic) cs; // will compile WITHOUT errors, will run WITHOUT errors 
Import im = sb;	// will compile WITHOUT errors, will run WITHOUT errors		
gr = im; // will compile WITH errors, will run WITHOUT errors			
gr = (German) im; // will compile WITH errors, reason for error: class SubaruOutback is not implemented by interface German
jp = im; // will compile WITHOUT errors, will run WITHOUT errors			
jp = (German) im; // will compile WITH errors, reason for error: class SubaruOutback is not implemented by interface German			
jp = (Japanese) im;	// will compile WITHOUT errors, will run WITHOUT errors
Automobile a = cs; // will compile WITHOUT errors, will run WITHOUT errors
a = hc; // will compile WITHOUT errors, will run WITHOUT errors	
 */

// Part 2

interface Domestic { }
interface Import { }
interface Japanese extends Import { }
interface German extends Import { }
interface Detroit extends Domestic { }
interface SpringHill extends Domestic { }
   
interface Vehicle {
    int getWeightInPounds( );
}
interface Automobile extends Vehicle { }
interface LargeAutomobile extends Vehicle { }
interface Sedan extends Automobile { }
interface Van extends LargeAutomobile { }
interface Truck extends LargeAutomobile { }
interface Compact extends Automobile { }
interface SportsUtilityVehicle extends Truck, Van { }
   
class SubaruOutback implements Japanese, SportsUtilityVehicle {
    public int getWeightInPounds() {
        return 1000;
    } }
class SaturnSL1 implements SpringHill, Sedan {
    public int getWeightInPounds() {
        return 1000;
    } }
class HondaCivic implements Japanese, Compact {
    public int getWeightInPounds() {
        return 1000;
    } }
class MercedesC230 implements German, Sedan {
    public int getWeightInPounds() {
        return 1000;
    } }
class ChevyS10 implements Detroit, Truck {
    public int getWeightInPounds() {
        return 2500;
    } }

class ParkingGarage {

    private static int numParkingGaragesCreated = 0;
    private static int numCars = 0;
    private static int totalWeight = 0;

    public ParkingGarage() {
        ++ numParkingGaragesCreated;
    }

    // add an amount to a running total and increments the amount of weight in the garage
    public void AddWeight(int weight) {
        if ((totalWeight + weight) > 25000) {
            System.out.println("Could not accept car");
        } else {
            if (numCars >= 20) {
            System.out.println("Could not accept car");
            } else {
                totalWeight += weight;
                ++ numCars;
            } 
        }
    }
    
    // returns the number of parking garages created
    public static int GarageCount() {
        return numParkingGaragesCreated;
    }
    
    // returns the number of cars in the garage
    public static int CarCount() {
        return numCars;
    }

    // returns the sum of all the cars weights
    public static int TotalWeight() {
        return totalWeight;
    }

    public static void main(String[] argv)
    {
        ParkingGarage Spot = new ParkingGarage();

        Vehicle red = new HondaCivic();
        Vehicle blue = new ChevyS10();
        Vehicle green = new ChevyS10();
        Vehicle brown = new ChevyS10();
        Vehicle black = new ChevyS10();
        Vehicle purple = new ChevyS10();
        Vehicle yellow = new ChevyS10();
        Vehicle orange = new ChevyS10();
        Vehicle grey = new ChevyS10();
        Vehicle maroon = new ChevyS10();
        Vehicle lime = new MercedesC230();
        Vehicle pink = new SaturnSL1();
        
        Spot.AddWeight(red.getWeightInPounds());
        Spot.AddWeight(blue.getWeightInPounds());
        Spot.AddWeight(green.getWeightInPounds());
        Spot.AddWeight(brown.getWeightInPounds());
        Spot.AddWeight(black.getWeightInPounds());
        Spot.AddWeight(purple.getWeightInPounds());
        Spot.AddWeight(yellow.getWeightInPounds());
        Spot.AddWeight(orange.getWeightInPounds());
        Spot.AddWeight(grey.getWeightInPounds());
        Spot.AddWeight(maroon.getWeightInPounds());
        Spot.AddWeight(lime.getWeightInPounds());
        Spot.AddWeight(pink.getWeightInPounds());

        System.out.println("The number of parking garages is " + GarageCount());
        System.out.println("The total number of cars in the garage is " + CarCount());
        System.out.println("The total amount weight for all of the cars in the garage is " + TotalWeight());
    }
}
