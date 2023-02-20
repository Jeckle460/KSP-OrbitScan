public class Vessel {
    private double[] orbitData = new double[8];
    private String pid; // pid
    private String nme; // name
    /* 
    private double SMA = 9488.8189123274042; //semi-major axis
    private double ECC = 0.96357709671861402; //Eccentricity
    private double INC = 13.850626293425266; //Inclination (degrees)
    private double LPE = 90.095547423987398; //Longitude of Periapsis (degrees)
    private double LAN = 172.32625389558666; //Longitude of ascending node (degrees)
    private double MNA = 3.1409887464453106; //mean anomaly (this is fraction of the way around the orbit. In KSP it goes from 0 to 2π, though it's really more of period than the actual angular position)
    private double EPH = 17959158.171556897; //epoch, I think seconds since the start of the game.
    private double REF = 13; //reference body. I'd have to see if there's a listing in the KSP wiki
    */  

    public Vessel(){
        pid = "0";
    }

    public Vessel(String NEW_pid, String NEW_name, double[] NEW_orbitData){
        pid = NEW_pid;
        orbitData = NEW_orbitData;
        nme = NEW_name;
    }
    
    public String getPID(){
        return pid;
    }
    public String getNME(){
        return nme;
    }
    public double[] getOrbitData(){
        return orbitData;
    }
    public String toString(){
       
        String returnString =("pid = "+pid+"\nName = "+nme+"\nSMA = "+orbitData[0]+"\nECC = "+orbitData[1]+"\nINC = "+orbitData[2]+"\nLPE = "+orbitData[3]+"\nLAN = "+orbitData[4]+"\nMNA = "+orbitData[5]+"\nEPH = "+orbitData[6]+"\nREF = "+orbitData[7]+"\n");
        return returnString;
    }
}
