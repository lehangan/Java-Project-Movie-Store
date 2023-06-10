package AimsProject.src.hust.soict.globalict.aims.media;

import java.util.List;
import java.util.ArrayList;

public class Book extends Media{
    private List<String> authors = new ArrayList<String>();

    public Book(String title){
        super(title);
    }

    public Book(String title, String category, float cost){
        super(title,category,cost);
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public List<String> getAuthors() {
        return this.authors;
    }

    public void addAuthor(String authorName){
        if(!authors.contains(authorName)){
            authors.add(authorName);
        }
        else System.out.println(authorName+ "already in author list");
    }

    public void removeAuthor(String authorName){
        if(authors.remove(authorName))
        {
            System.out.println("Remove successful");
        }
        else System.out.println("Fail");
    }

    @Override
    public String toString(){
        return  getTitle() + " - " + getCategory() + " - " +  getAuthors() + ": " + getCost() + "$" ;
    }
}
