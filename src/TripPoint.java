import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class TripPoint {
	
	private double lat;
	private double lon;
	private int time;
	private static ArrayList<TripPoint> trip;
	
	/**

	Constructs a TripPoint object with the specified time, latitude and longitude.
	@param time the time of the point
	@param lat the latitude of the point
	@param lon the longitude of the point
	*/
	public TripPoint (int time, double lat, double lon) {
		this.time = time;
		this.lat = lat;
		this.lon = lon;
	}
	
	/**

	Returns the time of the point.
	@return the time of the point
	*/
	public int getTime() {
		return time;
	}
	/**

	Returns the latitude of the point.
	@return the latitude of the point
	*/
	public double getLat() {
		return lat;
	}
	/**

	Returns the longitude of the point.
	@return the longitude of the point
	*/
	public double getLon() {
		return lon;
	}
	/**

	Returns a copy of the ArrayList of TripPoint objects representing a trip.
	@return a copy of the ArrayList of TripPoint objects representing a trip
	*/
	public static ArrayList<TripPoint> getTrip(){
		ArrayList<TripPoint> copyTrip = new ArrayList<TripPoint>();
		for (int i = 0; i < trip.size(); i++) {
			TripPoint copy = trip.get(i);
			copyTrip.add(copy);
		}
		return copyTrip;
	}
	
	/**

	Calculates the haversine distance between two TripPoint objects using their latitude and longitude.

	@param a the first TripPoint object

	@param b the second TripPoint object

	@return the haversine distance between the two TripPoint objects
	*/
	public static double haversineDistance(TripPoint a, TripPoint b) {
		final int R = 6371; 
	    double latDistance = Math.toRadians(b.getLat() - a.getLat());
	    double lonDistance = Math.toRadians(b.getLon() - a.getLon());
	    double a1 = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
	            + Math.cos(Math.toRadians(a.getLat())) * Math.cos(Math.toRadians(b.getLat()))
	            * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
	    double c = 2 * Math.atan2(Math.sqrt(a1), Math.sqrt(1 - a1));
	    double distance = R * c;

	    return distance;
	}
	/**

	Calculates the average speed between two TripPoint objects using their distance and time.
	@param a the first TripPoint object
	@param b the second TripPoint object
	@return the average speed between the two TripPoint objects
	*/
	public static double avgSpeed(TripPoint a, TripPoint b) {
		final int SECONDS_PER_HOUR = 3600;
	    double distance = haversineDistance(a, b);
	    int timeInSeconds = (b.getTime() - a.getTime()) * 60; 
	    double avgSpeed = distance / timeInSeconds * SECONDS_PER_HOUR;

	    return Math.abs(avgSpeed);
	}
	
	
	public static double totalTime() {
		
	}
	public static double totalDistance() {
		  
	}
	
	
	public static void readFile(String filename) throws FileNotFoundException {
		
	}
}
