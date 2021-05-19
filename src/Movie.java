import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;

public class Movie implements Serializable {
    private String title;
    private String duration;
    private String genre;
    private HashMap<Date,Room> date_time = new HashMap<Date,Room>();

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
    public HashMap<Date,Room> getDayTime(){
        return date_time;
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
    public void setDayTime(ArrayList<String> dates){
        //date_time = dates;
    }


}
