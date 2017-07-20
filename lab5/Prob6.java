package lab5;

import java.io.*;
import java.util.*;

class Prob6 {
    private static Vector<Train> vector;
    
    public Prob6() {
        vector = new Vector<>();
    }
    
    public static void read(String file) throws FormatOraInvalid, TipInvalid {
       try {
		RandomAccessFile fisier = new RandomAccessFile (file, "rws");
		String first = fisier.readLine();
		int lines = Integer.parseInt(first);
		for (int i = 0; i < lines; ++i)
		{
			String origin, destination;
			int m1, h1, m2, h2;
			String tip;
			int type;
			tip = fisier.readLine();
			type = Integer.parseInt(tip);
			System.out.println(type);
			if (type != 1 && type != 2)
				throw new TipInvalid("Tip de calatorie invalid!");
			boolean local;
			if (type == 1)
				local = true;
			else
				local = false;
			origin = fisier.readLine();
			destination = fisier.readLine();
			String hour_one = fisier.readLine();
			String hour_two = fisier.readLine();
			String[] one = hour_one.split(":");
			String[] two = hour_two.split(":");
			h1 = Integer.parseInt(one[0]);
			m1 = Integer.parseInt(one[1]);
			h2 = Integer.parseInt(two[0]);
			m2 = Integer.parseInt(two[1]);
			if (m1 < 0 || m1 > 59 || m2 < 0 || m2 > 59 || h1 < 0 || h1 > 23 || h2 < 0 || h2 > 23)
				throw new FormatOraInvalid ("Formatul orei este invalid!");
			Train tren = new Train (local, origin, destination, h1, m1, h2, m2);
			vector.add(tren);
			System.out.println(tren.toString());
		}
		fisier.close();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
       
    }
    



    public static void main(String args[]) throws FormatOraInvalid, TipInvalid {
        Prob6 p6 = new Prob6();
      	read("D:\\\\Java Things\\\\lab5\\\\src\\\\lab5\\\\test03.in");
        System.out.println(p6);
    }
}


class FormatOraInvalid extends Exception {
	public FormatOraInvalid (String message)
	{
		super(message);
	}
}

class TipInvalid extends Exception {
	public TipInvalid (String message)
	{
		super(message);
	}
}

class ClockTime {
    int hour, minute;
    
    public ClockTime(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }
    
    public int getTime() {
        int result = 0;
        result = hour * 60 + minute;
        return result;
    }
    
    public int compareTo(ClockTime time) {
        int t1, t2;
        t1 = this.hour*60 + this.minute;
        t2 = time.hour*60 + this.minute;
        if(t1 > t2) {
            return 1;
        } else if(t1 < t2) {
            return -1;
        } else {
            return 0;
        }
    }
    public String toString(){
        return ""+hour+":"+minute;
    }
}

class Schedule {
    ClockTime departure, arrival;
    
    public Schedule(ClockTime departure, ClockTime arrival) {
        this.departure = departure;
        this.arrival = arrival;
    }
    
    public int getDuration() {
        int result;
        if(arrival.compareTo(departure) == 1) {
            result = arrival.getTime() - departure.getTime();
        } else {
            result = 24*60 + arrival.getTime() - departure.getTime();
        }
        return result;
    }
    public String toString(){
        return "Ora: " + departure.toString()+"-"+arrival.toString()+"\n";
    }
        
}
class Route {
    String origin, destination;
    
    public Route(String origin, String destination) {
        this.origin = origin;
        this.destination = destination;
    }
    
    public boolean retur(Route r) {
        if(r.origin.equals(this.destination) && r.destination.equals(this.origin)) {
            return true;
        } else {
            return false;
        }
    }
    public String toString(){
        return "Ruta: "+ origin+ " - "+ destination + " ";
    }
}

class Train {
    Route r;
    Schedule s;
    boolean local;
    
    public Train(boolean local, Schedule s, Route r) {
        this.local = local;
        this.s = s;
        this.r = r;
    }
    
    public Train(boolean l, String org, String dest, int h1, int m1, int h2, int m2) {
        this.s = new Schedule(new ClockTime(h1, m1), new ClockTime(h2, m2));
        this.r = new Route(org, dest);
        this.local = l;
    }
    
    public int getPrice() {
        if(local == true) {
            return s.getDuration();
        } else {
            return 2*s.getDuration();
        }
    }  
    public String toString(){
        String result = r.toString() + s.toString();
        return result;
    }
    
}