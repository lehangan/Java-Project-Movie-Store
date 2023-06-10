package AimsProject.src.hust.soict.globalict.aims.media;

public class Disc extends Media{
    private int length;
    private String director;

    public int getLength(){
        return this.length;
    }

    public String getDirector(){
        return this.director;
    }

    public Disc(String title){
        super(title);
    }

    public Disc(String title, String category, float cost){
        super(title, category, cost);
    }

    public Disc(String director, String category, String title, float cost)
    {
        this(title,category,cost);
        this.director = director;
    }

    public Disc(String title, String category, String diretor, int length, float cost)
    {
        this(diretor, category, title, cost);
        this.length = length;
    }

}
