package AimsProject.src.hust.soict.globalict.aims.screen;

import java.awt.*; // Using AWT's layouts
import java.awt.event.*; // Using AWT's event classes and listener interfaces
import java.util.ArrayList;

import javax.swing.*; // Using Swing components and containers

import AimsProject.src.hust.soict.globalict.aims.media.Media;
import AimsProject.src.hust.soict.globalict.aims.store.Store;

public class StoreScreen extends JFrame{
    private Store store;
    JPanel createNorth(){
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north , BoxLayout.Y_AXIS)); 

        // sets the layout manager for the container north to be a vertical BoxLayout. 
        // This means that components added to the north container will be arranged in a vertical column,
        //  one on top of another.

        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    JMenuBar createMenuBar(){
        JMenu menu = new JMenu("Options");

        JMenu smUpdateStore = new JMenu("Update Store");
        smUpdateStore.add(new JMenuItem("Add Book"));
        smUpdateStore.add(new JMenuItem("Add CD"));
        smUpdateStore.add(new JMenuItem("Add DVD"));
        menu.add(smUpdateStore);
        menu.add(new JMenuItem("View store"));
        menu.add(new JMenuItem("View cart"));

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        // This means that components added to the container will be arranged 
        // in a flow from left to right, wrapping to the next line if necessary.
        
        menuBar.add(menu);

        return menuBar;
    }

    JPanel createHeader(){
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName() , Font.PLAIN , 50));

        title.setForeground(Color.CYAN);

        JButton cart = new JButton("View cart");
        cart.setPreferredSize(new Dimension(100, 50));
        cart.setMaximumSize(new Dimension(100, 50));

        header.add(Box.createRigidArea(new Dimension(10,10))); // create area
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(cart);
        header.add(Box.createRigidArea(new Dimension(10, 10)));
        return header;
    }

    JPanel createCenter(){
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2));

        ArrayList<Media> mediaInstore = (ArrayList) store.getItemsInStore();
        for( int i = 0 ; i<9 ; i++){
            MediaStore cell = new MediaStore(mediaInstore.get(i));
            center.add(cell);
        }

        return center;
    }

    public StoreScreen(Store store){
        this.store = store;
        Container cp  = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createNorth() , BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);
        setVisible(true);
        setTitle("Store");
        setSize(1024,768);
    }
}
