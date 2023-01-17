
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
//JOptionPane=pop up a standard dialog box to prompt user to enter a value or to inform something
public class JOption {
    public static void main(String[] args) {
        //JOptionPane.showConfirmDialog(Parent Component, message,title,message type);
        JOptionPane.showMessageDialog(null, "This is an plain message", "This is a title",JOptionPane.PLAIN_MESSAGE);
        JOptionPane.showMessageDialog(null, "This is an information message", "This is a title",JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, "This is an warning message", "This is a title",JOptionPane.WARNING_MESSAGE);
        JOptionPane.showMessageDialog(null, "This is an question message", "This is a title",JOptionPane.QUESTION_MESSAGE);
        JOptionPane.showMessageDialog(null, "This is an error message", "This is a title",JOptionPane.ERROR_MESSAGE);

        JOptionPane.showConfirmDialog(null, "Do you code", "Title",JOptionPane.YES_NO_CANCEL_OPTION);

        //yes=0,no=1,cancel=2,x=-1
        System.out.print(JOptionPane.showConfirmDialog(null, "Do you code", "Title",JOptionPane.YES_NO_CANCEL_OPTION));
        int answer=JOptionPane.showConfirmDialog(null, "Do you code", "Title",JOptionPane.YES_NO_CANCEL_OPTION);
        System.out.print(answer);

        //Use dialog box to input name
        String name=JOptionPane.showInputDialog("What is your name");
        System.out.print(name);

        //JOptionPane.showConfirmDialog(parent Component, message, title,option type,message type, icon, option, initial value)
        JOptionPane.showOptionDialog(null,"You are awesome", "This is my title",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE, null, null, null);

        //import png:open source file, drag image
        ImageIcon icon=new ImageIcon("2444615.jpg");
        JOptionPane.showOptionDialog(null,"You are awesome", "This is my title",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE,icon, null, null);

        String[] responds= {"No, you are aewsome", "Thank You!", "Blush",};
        JOptionPane.showOptionDialog(null,"You are awesome", "This is my title",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE,icon,responds, null);

        //Annoying message will
		/*
		while(true) {
			JOptionPane.showMessageDialog(null, "Your computer has a virus", "Danger",JOptionPane.WARNING_MESSAGE);
		}
		*/
    }
}