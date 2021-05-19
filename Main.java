import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;



public class Main {
 public static void main(String[] args) {
		String filename = "input.txt";
		List<String> list = new ArrayList<>();
		try(BufferedReader br = Files.newBufferedReader(Paths.get(filename))){
		
			list = br.lines().collect(Collectors.toList()); 
			int arraySize = Integer.parseInt(list.get(0));
			int a[] = new int[arraySize];
			String[] str = list.get(1).split(" ");
			for(int i=0;i<arraySize;i++)
				a[i] = Integer.parseInt(str[i]);
			int loopcount = Integer.parseInt(list.get(2));
			for(int c=0;c<loopcount;c++)
			{
				String[] res = list.get(c + 3).split(" ");
				if(res[0].equals("U")){
					int index = Integer.parseInt(res[1]);
					int value = Integer.parseInt(res[2]);
					a[index]= value;
				}else if(res[0].equals("Q")){
					int max=0;
					int x = Integer.parseInt(res[1]);
					int y = Integer.parseInt(res[2]);
					for(int i=0;i<arraySize;i++)
						for(int j=0;j<arraySize;j++)
							if(x<=i && j<=y && i!=j && a[i]+a[j]>max)
								max= a[i]+a[j];  
					System.out.println(max);
				}
				
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
