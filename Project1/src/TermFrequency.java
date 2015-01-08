import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

/**
 * Created by swanand on 1/7/2015.
 */
public class TermFrequency {

    public static void main(String[] args) throws FileNotFoundException {
        List<String> stopWordList = new ArrayList<String>();
        Map<String, Integer> termFreqMap = new TreeMap<String, Integer>();

        Scanner stopWordFileScanner = new Scanner(new File("../stop_words.txt")).useDelimiter(",");
        while(stopWordFileScanner.hasNext()){
            stopWordList.add(stopWordFileScanner.next());
        }

        Scanner corpusFileScanner = new Scanner(new File(args[0]));

        while(corpusFileScanner.hasNext()){
            String term = corpusFileScanner.next().toLowerCase().replaceAll("\\W", "");
            if(!stopWordList.contains(term)){
                Integer freq = termFreqMap.containsKey(term) ? termFreqMap.put(term, (termFreqMap.get(term)) + 1) : termFreqMap.put(term, 1);
            }
        }

        for(String key : termFreqMap.keySet()){
            System.out.println(key + "  " + termFreqMap.get(key));
        }

    }
}
