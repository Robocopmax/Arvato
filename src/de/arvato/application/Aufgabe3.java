package de.arvato.application;
import java.util.ArrayList;
import java.util.List;


public class Aufgabe3 {

    static int bestRes;
    static float bestPrice;
    
    public static void main(String[] args) throws Exception {
          
    }

    public static int getOptimalValue(float money, List<Flear> flears){
        int res = 0;
        bestRes = 0;
        bestPrice = money;
        ArrayList<Flear> bestBuy = recursiveHelpFunction(money,flears, new ArrayList<Flear>());

        res = bestRes;
        return res;
    }

    //Help function to brute-force Solution via recursive depth search
    public static ArrayList<Flear> recursiveHelpFunction(float money, List<Flear> flears, ArrayList<Flear> boughtFleas){
        ArrayList<Flear> re = null;
        boolean canCram = false;
        for(Flear a : flears){
            if(!boughtFleas.contains(a) && (money - a.getPrice() >= 0)){
                canCram = true;
                ArrayList<Flear> workCopy = boughtFleas;
                workCopy.add(a);
                workCopy = recursiveHelpFunction(money -a.getPrice(), flears, workCopy);
                if(workCopy != null){
                    re = workCopy;
                }
            }
        }
        if(!canCram){
            //sum Up Flea values
            int compRes = 0;
            float compPrice = 0;
            for(Flear a : boughtFleas){
                compRes += a.getRating();
                compPrice += a.getPrice();
            }
            //compare values, if better, overwrite
            if((compRes > bestRes) || ((compRes == bestRes) && (compPrice < bestPrice))){
                bestRes = compRes;
                bestPrice = compPrice;
                re = boughtFleas;
            }
        }
        return re;
    }
}
