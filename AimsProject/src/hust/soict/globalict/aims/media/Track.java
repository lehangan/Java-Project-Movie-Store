package AimsProject.src.hust.soict.globalict.aims.media;

public class Track {
    private String title;
    private int length;

    public void setTitle(String title){
        this.title = title;
    }

    public void setLength(int length){
        this.length = length;
    }

    public String getTitle(){
        return this.title;
    }

    public int getLength(){
        return this.length;
    }

    public Track(String title){
        this.setTitle(title);
    }

    public Track(String title, int length){
        this(title);
        this.setLength(length);
    }



}
