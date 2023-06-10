package AimsProject.src.hust.soict.globalict.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<Track>();

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getArtist() {
        return this.artist;
    }

    public CompactDisc(String title) {
        super(title);
    }

    public CompactDisc(String title, String category, float cost) {
        super(title, category, cost);
    }

    public CompactDisc(String director, String category, String title, float cost) {
        super(director, category, title, cost);
    }

    public CompactDisc(String title, String category, String director, int length, float cost) {
        super(title, category, director, length, cost);
    }

    public void addTrack(Track trackName) {
        if (!tracks.contains(trackName)) {
            tracks.add(trackName);
        } else
            System.out.println(trackName + "already in track list");
    }

    public void removeTrack(Track trackName) {
        if (tracks.remove(trackName)) {
            System.out.println("Remove successful");
        } else
            System.out.println("Fail remove");
    }

    public int getLength() {
        int trackLength = 0;
        for (Track t : tracks) {
            trackLength += t.getLength();
        }
        return trackLength;
    }

    @Override
    public void play() {
        for (Track t : tracks) {
            t.play();
        }
    }

    @Override
    public String toString(){
        return getId() + " - " + getTitle() + " - " + getCategory() + " - " + getArtist() + " - " + getDirector() + ": " + getCost() + "$";
    }
}
