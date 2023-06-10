package AimsProject.src.hust.soict.globalict.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
    public static int nbDigitalVideoDisc = 0;

    public DigitalVideoDisc(String title) {
        super(title);
        nbDigitalVideoDisc++;
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        super(title, category, cost);
        nbDigitalVideoDisc++;
    }

    public DigitalVideoDisc(String director, String category, String title, float cost) {
        super(director, category, title, cost);
        nbDigitalVideoDisc++;
    }

    public DigitalVideoDisc(String title, String category, String diretor, int length, float cost) {
        super(title, category, diretor, length, cost);
        nbDigitalVideoDisc++;
    }


    public static int getnbDigitalVideoDisc() {
        return nbDigitalVideoDisc;
    }

    public String toString() {
        return getTitle() + " - " + getCategory() + " - " + getDirector() + " - " + getLength() + ": " + getCost()
                + "$";
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
}
