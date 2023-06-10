package AimsProject.src.hust.soict.globalict.aims.media;

public abstract class Media {
    private int id;
    private String title;
    private String category;
    private float cost;
    public static int nbMedia = 0;

    public void setId(int id){
        this.id = id;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setCategory(String category){
        this.category = category;
    }

    public void setCost(float cost){
        this.cost = cost;
    }

    public int getId(){
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public float getCost() {
        return this.cost;
    }

    public String getCategory() {
        return this.category;
    }

    public Media(String title){
        this.title = title;
        this.id = nbMedia;
        nbMedia++;
    }

    public Media(String title, String category, float cost){
        this(title);
        this.category = category;
        this.cost = cost;
    }

}
