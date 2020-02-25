import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GUI {
    private JFrame frame;
    public ArrayList<JTextField> textFields = new ArrayList<>();
    public ArrayList<JButton> buttons = new ArrayList<>();

    public GUI(){
        frame = new JFrame();
        frame.setTitle("Multimedia");
        frame.setLayout(null);
        frame.setBackground(Color.DARK_GRAY);
        frame.addWindowListener(new WindowAdapter() {public void windowClosing(WindowEvent e) {System.exit(0);}});
        frame.setSize(600,500);
    }
    public void makeTextField(int x, int y, int width, int height){
        JTextField textField = new JTextField();
        textField.setBounds(x, y,width,height);

        textFields.add(textField);
    }
    public void makeLabel(String value ,int x, int y, int width, int height){
        Label label = new Label(value);
        label.setBounds(x,y,width,height);
        label.setForeground(Color.white);
        frame.add(label);
    }
    public void makeButton(String value, int x, int y, int width, int height){
        JButton button = new JButton(value);
        button.setBounds(x,y,width,height);
        button.setBackground(Color.darkGray);
        button.setForeground(Color.white);
        buttons.add(button);
    }
    public void buttonAction(JButton button, String value){
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                makeLabel(value,20,240,250,40);
            }
        };
        button.addActionListener(listener);
    }
    public void tf(JTextField t){
        frame.add(t);
        frame.add(t);
    }
    public void showFrame(){frame.setVisible(true);}
}