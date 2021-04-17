import java.util.ArrayList;

public class Movie {
    private String title;
    private String duration;
    private String genre;
    private ArrayList<String> date_time = new ArrayList<>();
    
    
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
    public ArrayList<String> getDayTime(){
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
        date_time = dates;
    }


}
