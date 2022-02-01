package assassinnamegenerator;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Generator {
	public static void main (String[] args) throws Exception {
		//gets file
		File file = new File("C:\\Users\\Thomas\\Desktop\\Test.txt");
		
		//set up reader for the file
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		//reads file and creates string from contents
		String name = br.readLine();
		
		//splits content into an array base on "," character
		String[] names = name.split(", ");
		
		//creates a new arraylist with same values
		ArrayList<String> assignees = new ArrayList<String>();
		for (int i = 0; i < names.length; i++) {
			assignees.add(names[i]);
		}
		
		//random order
		shuffleArray(names);
		
		String[][] pairList = new String[names.length][2];
				
		for (int i = 0; i < names.length; i++) {
			int randnum = (int) (Math.random() * assignees.size());
			pairList[i][0] = names[i];
			pairList[i][1] = assignees.get(randnum);
			assignees.remove(randnum);
		}
		
		for (int i = 0; i < pairList.length; i++) {
			System.out.print(pairList[i][0] + " : ");
			System.out.println(pairList[i][1]);
		}
		
		br.close();
		
	}
	
	static void shuffleArray(String[] arr) {
		for (int i = arr.length - 1; i > 0; i--) {
			int randNum = (int) (Math.random() * (arr.length));
			String oldVal = arr[randNum];
			
			arr[randNum] = arr[i];
			arr[i] = oldVal;	
		}
	}
}
