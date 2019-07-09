import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;

import java.io.InputStreamReader;

import java.net.URL;

import java.util.Scanner;

public class GetInfoFromNet {
	
	public static String dolar1;
	public static String dolar2;
	public static String dolar3;
	public static String dolar4;
	
    
	
	public void bul(String kelime) {

        int boy = kelime.length();

        int i, sayac = 0;

        for (i = 0; i < boy; i++) {

            if (kelime.charAt(i) == 'A') {
                if (kelime.charAt(i + 1) == 'l') {
                    if (kelime.charAt(i + 2) == 'i') {
                    	if (kelime.charAt(i + 3) == 's') {
                    		if (kelime.charAt(i + 4) == '"') {
                    			if (kelime.charAt(i + 5) == ':') {
                    				if (kelime.charAt(i + 6) >'4' && kelime.charAt(i + 6) <'9' ) {
                       
                        if(sayac==0){//ilk gelen veri dolarýn ki diðerleri baþka o yüzden ilkini alýyorum sadece
                        /*System.out.println(kelime.charAt(i+6));
                        System.out.println(kelime.charAt(i+7));
                        System.out.println(kelime.charAt(i+8));
                        System.out.println(kelime.charAt(i+9));*/
                         	
                        dolar1 = String.valueOf(kelime.charAt(i+6));
                        dolar2 = String.valueOf(kelime.charAt(i+7));
                        dolar3 = String.valueOf(kelime.charAt(i+8));
                        dolar4 = String.valueOf(kelime.charAt(i+9));
                        break;
                        }
                        
                        sayac++;
                    				}
                    			}
                        
                    		}
                    	}
                    }
                }
            }

        }
       // System.out.println("Dizide " + sayac + " tane alis vardýr");
    

    }
	
	
	
	
	public static void main(String[] args) throws Exception
	  {
		
		FileWriter myWriter = new FileWriter("filename.txt");
		
	    String urlString = "http://bigpara.hurriyet.com.tr/doviz/dolar/";
	    
	    // create the url
	    URL url = new URL(urlString);
	    
	    // open the url stream, wrap it an a few "readers"
	    BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));

	    // write the output to stdout
	    String line;
	    while ((line = reader.readLine()) != null)
	    {
	      
	      myWriter.write(line);//dosyaya yazýyorum dolarý çekicem
	    }
	    
	    myWriter.close();
	    
	    GetInfoFromNet deneme = new GetInfoFromNet();
	    try {
	        File myObj = new File("filename.txt");
	        Scanner myReader = new Scanner(myObj); 
	        while (myReader.hasNextLine()) {
	          String data = myReader.nextLine();
	          deneme.bul(data);
	        }
	        myReader.close();
	      } catch (FileNotFoundException e) {
	        System.out.println("An error occurred.");
	        e.printStackTrace();
	      } 
	    	
	  }//main bitiþ parantezi
	
	public  String getDolarInfo(){
		return String.valueOf(dolar1)+String.valueOf(dolar2)+String.valueOf(dolar3)+String.valueOf(dolar4);
	}




	
}
