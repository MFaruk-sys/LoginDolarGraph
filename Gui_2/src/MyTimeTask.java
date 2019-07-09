import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;





class MyTimeTask extends TimerTask
{
	Connection conn = sqliteconnect.dbConnector();
	//GetInfoFromNet G3 = new GetInfoFromNet();
	public int id = 1;
    public void run()
    {//write your code here
    		try {
				GetInfoFromNet.main(null);//aþaðýdaki deðerleri null olmasýn diye çaðýroyruz bunu
			} catch (Exception e) {
				e.printStackTrace();
			}
    		try{
    			String query="Update DolarInfo set Dolar='"+(String.valueOf(GetInfoFromNet.dolar3)+String.valueOf(GetInfoFromNet.dolar4))+"' where ID='"+id+"'";
				PreparedStatement pstt = conn.prepareStatement(query);
								
				pstt.execute();
				
				pstt.close();
				
			}
			catch(Exception a){
				a.printStackTrace();
			}
    		id++;
    }
   

public static void main(String[] args) throws ParseException {

	DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	Date date = dateFormatter .parse("2019-07-03 14:56:00");

    //Now create the time and schedule it
    Timer timer = new Timer();

    /*****Use this if you want to execute it once*/
    
	//timer.schedule(new MyTimeTask(), date);

    /*****Use this if you want to execute it repeatedly*/
    int period = 60000;// 1 DAKÝKA DA BÝR DATABASE Ý GÜNCELLEÝYORUM
    timer.schedule(new MyTimeTask(), date, period );
   
}
}