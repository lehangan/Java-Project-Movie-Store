package AimsProject.src.hust.soict.globalict.aims.disc;

public class TestPassingParameter {
    public static void main(String[] args){
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");
        //wrapperDVD dvd1 = new wrapperDVD(jungleDVD);
        //wrapperDVD dvd2 = new wrapperDVD(cinderellaDVD);
        swap(jungleDVD,cinderellaDVD);
        // swapActually(dvd1, dvd2);
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("cinderrella dvd title: " + cinderellaDVD.getTitle());

        // System.out.println("jungle dvd title: " + dvd1.dvd.getTitle());
        // System.out.println("cinderrella dvd title: " + dvd2.dvd.getTitle());

        changeTitle(jungleDVD,cinderellaDVD.getTitle());
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
    }

    public static void swap(Object o1, Object o2){
        Object tmp = o1;
        o1 = o2;
        o2 = tmp;
    } 

    public static void swapActually(wrapperDVD o1, wrapperDVD o2){
        DigitalVideoDisc tmp = o1.dvd;
        o1.dvd = o2.dvd;
        o2.dvd = tmp;
    }

    public static void changeTitle(DigitalVideoDisc dvd, String title){
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);
        dvd = new DigitalVideoDisc(oldTitle);
    }
}
