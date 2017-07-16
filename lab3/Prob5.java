package lab3;

class ClockTime {
	int hour;
	int minute;
	public ClockTime (int ora, int minut)
	{
		this.hour = ora;
		this.minute = minut;
	}
	
	public int compare (ClockTime clock)
	{
		if (hour == clock.hour)
		{
			if (minute > clock.minute)
				return 1;
			else return 0;
		}
		else if (hour > clock.hour)
			return 1;
		else return 0;
	}
}

class Route {
	String origin, destination;
	public Route (String origin, String destination)
	{
		this.origin = origin;
		this.destination = origin;
	}
	
	public boolean check (Route kek)
	{
		if (kek.origin.equals(destination) && kek.destination.equals(origin))
			return true;
		else
			return false;
	}
}

class Schedule {
	ClockTime departure, arrival;
	public Schedule (ClockTime departure, ClockTime arrival)
	{
		this.departure = departure;
		this.arrival = arrival;
	}
	
	public int minutes ()
	{
		int time = 0;
		if (arrival.minute >= departure.minute)
			time = arrival.minute - departure.minute;
		else
			time = 60 - departure.minute + arrival.minute;
		if (arrival.hour >= departure.hour)
			time += (arrival.hour - departure.hour) * 60;
		else
			time += (24 - departure.hour + arrival.hour) * 60;
		return time;
		
	}
}

class Train {
	Route r;
	Schedule s;
	int local;
	
	public Train (Route route, Schedule schedule, int local)
	{
		this.r = route;
		this.s = schedule;
		this.local = local;
	}
	
	public int price ()
	{
		int pret = local * s.minutes();
		return pret;
	}
}

public class Prob5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
