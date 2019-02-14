 import com.opencsv.CSVWriter;;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
 
 class CSVExample {
 
    public static void main(String[] args) throws IOException {
        CSVWriter csvWriter = new CSVWriter(new FileWriter("example.csv"));
 
        List<String[]> rows = new LinkedList<String[]>();
        rows.add(new String[]{"1", "jan", "Male", "20"});
        rows.add(new String[]{"2", "con", "Male", "24"});
        rows.add(new String[]{"3", "jane", "Female", "18"});
        rows.add(new String[]{"4", "ryo", "Male", "28"});
        csvWriter.writeAll(rows);
 
        csvWriter.close();
    }
}
