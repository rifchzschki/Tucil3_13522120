import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main{
    public static Scanner scanner = new Scanner(System.in);

    public static String getAlgo(String i){
        String res;
        if(i.equalsIgnoreCase("1")){
            res = "ucs";
        }else if(i.equalsIgnoreCase("2")){
            res = "gbfs";
        }else if(i.equalsIgnoreCase("3")){
            res = "A*";
        }else{
            res = null;
        }
        return res;
    }

    public static void run(){
        String algo, lagi, start,target, path;
        do{            
            boolean onlyAlphabetic1;
            boolean onlyAlphabetic2;
            do{
                System.out.print("Start : ");
                start = scanner.nextLine();
                System.out.print("Target : ");
                target = scanner.nextLine();

                // Mengecek apakah string hanya mengandung karakter alfabet
                onlyAlphabetic1 = Pattern.matches("[a-zA-Z]+", start);
                onlyAlphabetic2 = Pattern.matches("[a-zA-Z]+", target);
                if(start.length()!=target.length() || (!onlyAlphabetic1 || !onlyAlphabetic2)){
                    System.out.println("Masukkan string dengan panjang yang sesuai");
                }
            }while(start.length()!=target.length() || (!onlyAlphabetic1 || !onlyAlphabetic2));
            path = "../assets/Graph/"+ start.length() + ".txt";
            
            // load graph
            Graph graph = Graph.readFromCSV(path);
            
            // mainkan
            System.out.println("--------------------------------------");
            System.out.println("Tersedia 3 Algoritma: ");
            System.out.println("1. UCS (Uniform Cost Search)");
            System.out.println("2. GBFS (Greedy Best-First Search)");
            System.out.println("3. A* (Uniform Cost Search)");
            do{
                System.out.print("Pilih: ");
                algo = scanner.nextLine();
                algo = getAlgo(algo);
                if(algo==null){
                    System.out.println("Pilih algoritma yang tersedia!");
                }
            }while (algo==null);
            System.out.println("--------------------------------------");
            
            
            
            Algorithm game = new Algorithm(algo);
            long startTime = System.currentTimeMillis();
            List<String> res = game.routeSearch(graph, start, target);
            if(res != null){
                System.out.println("---------------Jawaban---------------");
                System.out.println("Rute: "+ res);
                System.out.println("Banyak kata dikunjungi: "+ game.getVisitedList().size());
                System.out.println("Durasi pencarian: "+ (System.currentTimeMillis()-startTime) + "ms");
                System.out.println("--------------------------------------");
            }else{
                System.out.println("-------Pencarian tidak ditemukan-------");
                System.out.println("Durasi pencarian: "+ (System.currentTimeMillis()-startTime) + "ms");
                System.out.println("--------------------------------------");

            }

            System.out.print("Lagi? (y/n): ");
            lagi = scanner.nextLine();
        }while(lagi.equalsIgnoreCase("y"));
        System.out.println("Terima Kasih sudah bermain...");
    }

    public static void scrap(){
        Integer num;
        System.out.print("Jumlah suku kata: ");
        num = Integer.parseInt(scanner.nextLine());

        List<String> lines = ReadFile.toList("../assets/Dict/Dict.txt");
        Graph graph = Graph.buildGraph(num, lines);
        graph.saveToCSV("../assets/Graph"+num+".txt");
    }

    public static void main(String[] args) {

        boolean valid = true;
        do{
            System.out.print("Masukkan perintah: ");
            String inputString = scanner.nextLine();
            
            if(inputString.equalsIgnoreCase("Scrap")){
                long startTime = System.currentTimeMillis();
                scrap();
                System.err.println(System.currentTimeMillis()-startTime);
            }else if(inputString.equalsIgnoreCase("Run")){
                run();
            }else{
                System.out.println("Masukkan perintah yang valid!");
                System.out.println("");
                valid=false;
            }
        }while(!valid);
    

    }
    
}