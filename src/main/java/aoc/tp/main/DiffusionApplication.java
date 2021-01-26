package aoc.tp.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import aoc.tp.afficheur.Afficheur;
import aoc.tp.afficheur.ObserverDeCapteur;
import aoc.tp.capteur.Capteur;
import aoc.tp.capteur.CapteurImpl;
import aoc.tp.configuration.BaseConfiguration;

public class DiffusionApplication {


    public static void main(String[] args) {
//        System.out.println("Hello world");
//        
//        Capteur capteur = BaseConfiguration.getCapteur();
//
//        int n = 0;
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String input = "";
//        boolean looping = true;
//        while(looping) {
//            n++;
//
//            for (Canal c : BaseConfiguration.getCanals()) {
//                c.tick();
//            }
//
//            try {
//                input = br.readLine();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            System.out.println("Tick: " + String.valueOf(n) + " Please press q to stop or Enter to continue");
//            if(input.equals("q")) {
//                looping = false;
//            }
//        }
    	
    	Capteur capteur = new CapteurImpl();
    	ObserverDeCapteur afficheur = new Afficheur();
    	
    	capteur.tick();
    	
    }
}
