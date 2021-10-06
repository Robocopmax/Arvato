import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Aufgabe1 {

    public static void main(String[] args) throws Exception {
        //TODO: 
    }
    //Übergebe Dateipfade
    //Verifiziere Dateipfade
    //Verifiziere Dateiinhalt
    
    public String[] readList(String filepath){
        String[] out = new String[0];
        //Reads an file from filepath and transfers its contents into an array line for line
        try {
            Scanner sc = new Scanner(new File(filepath));
            ArrayList<String> workCopy = new ArrayList<String>();
            while(sc.hasNextLine()){
                workCopy.add(sc.nextLine().trim());
            }
            workCopy.trimToSize();
            out = new String[workCopy.size()];
            out =(String[])workCopy.toArray();
        } catch (Exception e) {
            //TODO: handle exception
        }
        return out;
    }
    
    public void core(String[] liste1, String[] liste2) throws Exception{
        //gleiche Listen Ab und Speichere Ergebnisse
        //assumption: all entries are valid and singular, no duplicate entries; notation is consistent
        ArrayList<String> a1 = new ArrayList<String>(liste1.length);
        for(String a : liste1) a1.add(a);
        ArrayList<String> a2 = new ArrayList<String>(liste2.length);
        for(String a : liste2) a2.add(a);
        ArrayList<String> onlyInList1 = new ArrayList<String>(liste1.length);
        ArrayList<String> onlyInList2 = new ArrayList<String>(liste2.length);
        ArrayList<String> inBothLists = new ArrayList<String>(Math.min(liste1.length, liste2.length));
        //ermittle Schnittmengen
        for(String a : a1){
            if(a2.contains(a)){
                inBothLists.add(a);
                a2.remove(a);
            }else{
                onlyInList1.add(a);
            }
            a1.remove(a);
        }
        for(String a : a2){
            onlyInList2.add(a);
            a2.remove(a);
        }
        onlyInList1.trimToSize();
        onlyInList2.trimToSize();
        inBothLists.trimToSize();
        //Prüfe, ob alle Elemente Verteilt Wurden; a1 & a2 leer?
        if(!(a1.isEmpty() && a2.isEmpty())){
            throw new Exception("Lists are not empty.");
        }
        //Gebe Ergebnisse als json Format aus
        String jsonOut = "{\n\t\"onlyInList1\":  [\n";
        for(String a: onlyInList1){
            jsonOut += "\t\t" + "\"" + a + "\"";
            if(onlyInList1.indexOf(a) != onlyInList1.size()){
                jsonOut += ",\n";
            }
        }
        jsonOut += "\n\t],\n\t\"onlyInList2\":  [\n";
        for(String a: onlyInList2){
            jsonOut += "\t\t" + "\"" + a + "\"";
            if(onlyInList2.indexOf(a) != onlyInList2.size()){
                jsonOut += ",\n";
            }
        }
        jsonOut += "\n\t],\n\t\"inBothLists\":  [\n";
        for(String a: inBothLists){
            jsonOut += "\t\t" + "\"" + a + "\"";
            if(inBothLists.indexOf(a) != inBothLists.size()){
                jsonOut += ",\n";
            }
        }
        jsonOut += "\n\t]\n}";
        System.out.print(jsonOut);
    }


}
