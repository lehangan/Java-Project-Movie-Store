package lab3.aimsprojectlab3.storelab3;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private int qtyOrdered = 0;
    private float totalCost = 0f;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];

    public int getQtyOrderd() {
        return this.qtyOrdered;
    }

    public boolean isFulled() {
        if (qtyOrdered == MAX_NUMBERS_ORDERED)
            return true;
        else
            return false;
    }

    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (isFulled())
            System.out.println("The Cart is almost full");
        itemsOrdered[qtyOrdered] = disc;
        qtyOrdered++;
        System.out.println("The disc has been added");
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        int index = -1;
        for (int i = 0; i < 20; i++)
            if (itemsOrdered[i] == disc)
                index = i;
        if (index == -1) {
            System.out.println("Can't find the disc");
        } else {
            qtyOrdered--;
            for (int i = index; i < qtyOrdered; i++) {
                itemsOrdered[i] = itemsOrdered[i + 1];
            }
        }
        System.out.println("The disc has been removed");
    }

    public float getTotalCost() {
        for (int i = 0; i < qtyOrdered; i++) {

                totalCost += itemsOrdered[i].getCost();
        }
        return totalCost;
    }

    public void searchID(int id){
        int index = -1;
        for( int i = 0 ;i<qtyOrdered ; i++)
            if( itemsOrdered[i].getId() == id){
                index = i;
            }
        if(index == -1){
            System.out.println("Can't find the disc have " + id +" id");
        }
        else{
            System.out.println(itemsOrdered[index].getTitle());
        }
    }

    public void searchTitle(String title){
        int index = -1;
        for( int i = 0 ;i<qtyOrdered ; i++)
            if( itemsOrdered[i].isMatch(title)){
                index = i;
            }
        if(index == -1){
            System.out.println("Can't find the disc have " + title +" title");
        }
        else{
            System.out.println(itemsOrdered[index].getTitle());
        }
    }



}
