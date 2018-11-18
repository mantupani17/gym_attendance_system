
package gymattendence;

/**
 *
 * @author mantu
 */
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.*;
import javax.swing.plaf.basic.BasicTextFieldUI;
import javax.swing.text.JTextComponent;

public class testHint extends BasicTextFieldUI implements FocusListener {
private String hint;
private Color col;
public testHint(String hint,Color col){
    this.hint=hint;
    this.col=col;
}
    private void repaint(){
        if(getComponent()!=null)
        {
            getComponent().repaint();
        }
    }
    public void paintSafely(Graphics g){
        super.paintSafely(g);
        JTextComponent comp=getComponent();
        if(comp.getText().length()==0 && ! comp.hasFocus() ){
            g.setColor(col);
            int pad=(comp.getHeight()-comp.getFont().getSize())/2;
            int ins=3;
            g.drawString(hint, ins, comp.getHeight()-pad-ins);
        }
    }
    @Override
    public void focusGained(FocusEvent e) {
        repaint();
    }

    @Override
    public void focusLost(FocusEvent e) {
       repaint();
    }
}