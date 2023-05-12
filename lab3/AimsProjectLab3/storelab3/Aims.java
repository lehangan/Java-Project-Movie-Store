package lab3.aimsprojectlab3.storelab3;

public class Aims {
    public static void main(String[] args){
        Cart anOrder = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King" , "Animation" , "Roger Allers",87, 19.95f);
        anOrder.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars" , "Science Fiction" , "George Lucas",87, 24.95f);
        anOrder.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin" , "Animation", 18.995f);
        anOrder.addDigitalVideoDisc(dvd3);
        
        anOrder.removeDigitalVideoDisc(dvd1);
        DigitalVideoDisc[] dvdList = new DigitalVideoDisc[4];
        dvdList[0] = new DigitalVideoDisc("dvd1","type1",10f);
        dvdList[1] = new DigitalVideoDisc("dvd2" ,"type2" , 10f);
        dvdList[2] = new DigitalVideoDisc("dvd3", "type3" , 10f);
        dvdList[3] = new DigitalVideoDisc("dvd4", "type4" , 10f);

        anOrder.addDigitalVideoDisc(dvdList);
        System.out.println("Total Cost is:");
        System.out.println(anOrder.getTotalCost());

       
    }
}
