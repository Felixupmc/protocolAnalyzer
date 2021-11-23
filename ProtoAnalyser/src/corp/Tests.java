package corp;

import java.io.IOException;
import java.util.List;

public class Tests {
	public static void main(String[] args) throws IOException {
		try {
			List<String> t1 = input.Parser.parser("C:\\Users\\fnifn\\git\\protocolAnalyzer\\ProtoAnalyser\\data\\tramePure.txt");
		} catch (IOException e){
			System.out.println("Problème de lécture du fichier dans main");
		}
	}
}

