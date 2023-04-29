package store;

public class DigitalVideoDisc {
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;

    DigitalVideoDisc(String _title) {
        this.title = _title;
    }

    DigitalVideoDisc(String _title, String _category, float _cost) {
        this(_title);
        this.category = _category;
        this.cost = _cost;
    }

    DigitalVideoDisc(String _director, String _category, String _title, float _cost) {
        this(_category, _title, _cost);
        this.category = _category;
    }

    DigitalVideoDisc(String _title, String _category, String _diretor, int _length, float _cost) {
        this(_diretor, _category, _title, _cost);
        this.length = _length;
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

    public int getLength() {
        return this.length;
    }

    public String getDirector() {
        return this.director;
    }


}
