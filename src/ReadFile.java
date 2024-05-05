import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {

    public static List<String> toList(String path){
        BufferedReader reader = null;
        List<String> lines = new ArrayList<>();
        try {
            // Membuat objek FileReader
            FileReader fileReader = new FileReader(path);
            
            // Membuat objek BufferedReader
            reader = new BufferedReader(fileReader);
            
            String line;
            // Membaca file baris per baris dan menyimpannya dalam list
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // Tutup BufferedReader setelah selesai membaca file
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return lines;

    }
}
