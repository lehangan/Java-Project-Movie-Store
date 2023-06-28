package AimsProject.src.hust.soict.globalict.aims.screen;

import java.awt.*; // Using AWT's layouts
import java.awt.event.*; // Using AWT's event classes and listener interfaces
import javax.swing.*; // Using Swing components and containers

import AimsProject.src.hust.soict.globalict.aims.cart.Cart;
import AimsProject.src.hust.soict.globalict.aims.media.Media;
import AimsProject.src.hust.soict.globalict.aims.media.Playable;

public class MediaStore extends JPanel {
    private Media media;
    private Cart cart;

    public MediaStore(Media media) {
        this.media = media;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel("" + media.getCost() + "$");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton addToCartButton = new JButton("Add to cart");
        container.add(addToCartButton);
        addToCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    cart.addMedia(media);
                    JOptionPane.showMessageDialog(null, "Media added to cart: " + media.getTitle(), "Playable Media",
                            JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, exception.getMessage(), exception.toString(),
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        // container.add(new JButton("Add to cart"));

        // how the code checks if the Media implements the Playable interface to create
        // a “Play” button
        if (media instanceof Playable) {
            // container.add(new JButton("Play"));
            JButton playButton = new JButton("Play");
            container.add(playButton);

            playButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Play button clicked, show media in a dialog window
                    JDialog dialog = new JDialog();
                    dialog.setSize(400, 300); // Set dialog size as per your requirements
                    // Add code to display the media in the dialog
                    String playable = ((Playable)media).toString();
                    JLabel label = new JLabel("Playing " + playable );
                    dialog.add(label);
                    dialog.setVisible(true);
                }
            });
        }

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createHorizontalGlue());
        this.add(container);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));

    }
}
