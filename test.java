import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JList;

/** @see https://stackoverflow.com/a/5255930/230513 */
public class test {

    private void display() {
        JFrame f = new JFrame("Test");
        String[] data = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5"};
        f.add(new JList(data));
        f.pack();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setVisible(true);          
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new test()::display);
    }
}
