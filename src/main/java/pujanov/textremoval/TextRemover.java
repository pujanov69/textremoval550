package pujanov.textremoval;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TextRemover {

	static String everythingz, everythingremoved;
	
	static BufferedReader br;
	
	static StringBuilder sb;
	
	static StringBuilder removedsb;
	
	static int j=0, k=0;
	
	
	public static void main(String args[]) {
		
		System.out.println("Hello text removal");
		
		try {
		 br = new BufferedReader(new FileReader("C:\\Users\\pujan\\Downloads\\550-avec-indus.txt"));
		
		    sb = new StringBuilder();
		    
		    removedsb = new StringBuilder();
		    
		    String line;

		    
		    int i=0;
		    
		    do {
		    	
		    	line = br.readLine();
		    	 
		    	j++;
		    	System.out.println("Line-->" + line);
		    	 
		    	//added
			        
		    	 StringBuilder stringToBeAdded = new StringBuilder();
		    	 
		    	 if(line.startsWith("0128000CP")) {
		    		 System.out.println("new block started");
		    		 i=0;
		    		 
		    		 stringToBeAdded.append(line);
		    		 stringToBeAdded.append(System.lineSeparator());
		    		 do {
		    		 
		    			 line = br.readLine();
		    			 
		    			 System.out.println("Line->" + line);
		    			 
		    			 stringToBeAdded.append(line);
			    		 stringToBeAdded.append(System.lineSeparator());
		  
		    		 i++;
		    		 
		    		 }while(!line.startsWith("0128999CP"));
		    		 
		    		 if(i<=2) {
		    		 sb.append(stringToBeAdded);
		    		 k++;
		    		 
		    		 }else {
		    			 removedsb.append(stringToBeAdded);
		    		 }
		    		 
		    	 }
			        
			    //ends
		    	 
		        //sb.append(line);
		        //sb.append(System.lineSeparator());
		        //line = br.readLine();
		        
		        
		    }while (line != null);
		    String everything = sb.toString();
		    everythingz = everything;
		    
		    everythingremoved = removedsb.toString();
		    
		    br.close();
		    
		    System.out.println(everything);
		}catch(Exception ex) {
			ex.printStackTrace();
			
			String everything = sb.toString();
		    everythingz = everything;
		    everythingremoved = removedsb.toString();
		    
		    try {
		    br.close();}catch(Exception e) {
		    	e.printStackTrace();
		    }
		    
		    System.out.println(everything);
		}
		
		System.out.println("Total line--->" + j);
		System.out.println("Added--->" + k);
		
		try(FileWriter writer = new FileWriter("C:\\\\Users\\\\pujan\\\\Downloads\\\\output.txt")) {
		    writer.write(everythingz); 
		}
		catch(IOException e){
		    // Handle the exception
			e.printStackTrace();
		}
		
		try(FileWriter writer = new FileWriter("C:\\\\Users\\\\pujan\\\\Downloads\\\\outputremoved.txt")) {
		    writer.write(everythingremoved); 
		}
		catch(IOException e){
		    // Handle the exception
			e.printStackTrace();
		}
		
	}
}
