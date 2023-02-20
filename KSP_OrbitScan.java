/*

    double[] orbitData = new double[7];
    double SMA = 9488.8189123274042; //semi-major axis
    double ECC = 0.96357709671861402; //Eccentricity
    double INC = 13.850626293425266; //Inclination (degrees)
    double LPE = 90.095547423987398; //Longitude of Periapsis (degrees)
    double LAN = 172.32625389558666; //Longitude of ascending node (degrees)
    double MNA = 3.1409887464453106; //mean anomaly (this is fraction of the way around the orbit. In KSP it goes from 0 to 2π, though it's really more of period than the actual angular position)
    double EPH = 17959158.171556897; //epoch, I think seconds since the start of the game.
    int REF = 13; //reference body. I'd have to see if there's a listing in the KSP wiki

*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class KSP_OrbitScan {

    private static final String FILENAME = "persistent.sfs";
    public static void main(String[] args) {

        
        Vessel[] VesselList = new Vessel[20];

        String tempPID = "";
        String tempName = "";
        double[] tempOrbitData = new double[8];
   
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
            
        Boolean orbitDataBool = false;
        String strCurrentLine;
        int linecount = 1;  
        int i = 0;
        int vesselCount = 0;

        while ((strCurrentLine = br.readLine()) != null) {
            //GET SHIP NAME and PID
            if(strCurrentLine.trim().contains("pid = ")){
                orbitDataBool = true;
                linecount = 0;
            }
            if(linecount == 0 && strCurrentLine.trim().equals("{") == false){
                tempPID = (strCurrentLine.trim().split("= ")[1]);
                //System.out.println(strCurrentLine.trim());
                orbitDataBool = false;
            }
            if(linecount == 2 && strCurrentLine.trim().equals("{") == false){
                tempName = (strCurrentLine.trim().split("= ")[1]);
                //System.out.println(strCurrentLine.trim());
            }
            
            // GET ORBITAL DATA
            if(strCurrentLine.trim().contains("SMA = ")){
                orbitDataBool = true;
            }
 
            if(orbitDataBool){
                //System.out.println(strCurrentLine.trim());
                tempOrbitData[i] = Double.valueOf(strCurrentLine.split("= ")[1]);
                i++;
            }

            if(strCurrentLine.trim().contains("REF = ")){
                i = 0;
                orbitDataBool=false;
                VesselList[vesselCount]=(new Vessel(tempPID,tempName,tempOrbitData));
                vesselCount++;
                //System.out.println("\n");
            }
            
            linecount++;
        }

        for(int u = 0; u<vesselCount;u++){System.out.println(VesselList[u].toString());}
        
        } catch (IOException e) {
        e.printStackTrace();
        }
        
    }
   }
   