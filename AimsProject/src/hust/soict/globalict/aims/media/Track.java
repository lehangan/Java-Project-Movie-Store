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
        if (this.getLength() != 0) {
            System.out.println("Playing DVD: " + this.getTitle());
            System.out.println("DVD length: " + this.getLength());
        } else {
            System.out.println("this DVD can not be play");
        }

    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof Track))
            return false;
        Track track = (Track) obj;
        return this.title == track.getTitle() && this.length == track.getLength();
    }

}
