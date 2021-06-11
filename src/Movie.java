import java.awt.Component;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Movie implements Serializable {
    private String title;
    private String duration;
    private String genre;
    private HashMap<String,Room> Screenings = new HashMap<String,Room>();

    Movie(){}
    
    Movie(String title, String duration, String genre){
        this.title = title;
        this.duration = duration;
        this.genre = genre;
    }

    public String getTitle(){
        return title;
    }
    public String getDuration(){
        return duration;
    }
    public String getGenre(){
        return genre;
    }



    public HashMap<String, Room> getScreenings() {
		return Screenings;
	}
    
    public void delscreen(String date) {
    	Set<String> keys = Screenings.keySet();
    	for(String key:keys) {
    		if(key.equals(date)) {
    			Screenings.remove(key);
    		}
    	}
    }

    public void printScreenings() {

    }

    
	public void setScreenings(HashMap<String, Room> screenings) {
		Screenings = screenings;
	}
	
	public void AddScreening(String date,Room room) {
		Screenings.put(date, room);
	}

	public void setTitle(String title){
        this.title=title;
    }
    public void setDuration(String duration){
        this.duration=duration;
    }
    public void setGenre(String genre){
        this.genre=genre;
    }



}
