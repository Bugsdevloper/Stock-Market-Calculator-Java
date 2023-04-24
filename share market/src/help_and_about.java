import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URI;

public class help_and_about extends JFrame {
    private JLabel contactLabel;
    private JLabel linkLabel;

    public help_and_about() {
        // Set up the JFrame properties
    	
    	 ImageIcon icon = new ImageIcon(getClass().getResource("tool2.png"));
         setIconImage(icon.getImage());
        setTitle("About");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Set up the font
        Font font = new Font("SansSerif", Font.PLAIN, 14);

        // Create the label with contact information and bug reporting link
        contactLabel = new JLabel("Loading...");
        linkLabel = new JLabel("");

        // Set up the font for the labels
        contactLabel.setFont(font);
        linkLabel.setFont(font);

        // Create the panel to hold the label
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.add(contactLabel, BorderLayout.NORTH);
        panel.add(linkLabel, BorderLayout.CENTER);

        // Add the panel to the JFrame
        add(panel);

        // Start the SwingWorker
        new ContactLoader().execute();
    }

    private class ContactLoader extends SwingWorker<Void, Void> {
        private String contactInfo;

        @Override
        protected Void doInBackground() throws Exception {
            // Simulate a long-running task of loading the contact information from a remote server
            Thread.sleep(2000);
            contactInfo = loadContactInfoFromServer();
            return null;
        }

        @Override
        protected void done() {
            // Update the UI with the loaded contact information
            contactLabel.setText(contactInfo);
            linkLabel.setText("<html><a href=\"https://www.instagram.com/techo_savvy/\">https://www.instagram.com/techo_savvy/</a></html>");
            linkLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
            linkLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    try {
                        Desktop.getDesktop().browse(new URI("https://www.instagram.com/techo_savvy/"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            });
        }

        private String loadContactInfoFromServer() {
            // Load the contact information from a remote server
            return "For bug reports or contact, please visit: https://www.instagram.com/techo_savvy/";
        }
    }

    public static void main(String[] args) {
        
    }
}
