package AimsProject.src.hust.soict.globalict.aims.media;


public class Track implements Playable {
    private String title;
    private int length;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getTitle() {
        return this.title;
    }

    public int getLength() {
        return this.length;
    }

    public Track(String title) {
        this.setTitle(title);
    }

    public Track(String title, int length) {
        this(title);
        this.setLength(length);
    }

    @Override
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }

    public boolean equals(Track o){
        if(o == this){
            return true;
        }
        if(!(o instanceof Track)){
            return false;
        }
        Track t = (Track) o;
        return title == t.getTitle() && length == t.getLength();
    }
}
