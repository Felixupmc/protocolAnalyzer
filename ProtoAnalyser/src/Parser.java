import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Parser {

	public static List<String> Parser(String fileName) throws IOException{
		BufferedReader br = null;
		List<String> res =new ArrayList<>();
		try {
			br = new BufferedReader(new FileReader(fileName));
			String line;
			while((line=br.readLine())!=null) {
				res.add(line);
			}
		} catch (IOException io) {
			System.out.println("Erreur lors de la lecture du fichier\n");
			io.printStackTrace();
		
		} finally {
			if(br!=null) {
				br.close();
			}
		}
		
		return res;
	}

}
