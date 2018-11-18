/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gymattendence;

import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

/**
 *
 * @author MANTU
 */
public class TestPane {
     

        public TestPane() {
           

           // add(new JScrollPane(new JTextArea(10, 10)));

            }
        public void setpane()
        {
            KeyStroke enter = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0);
            KeyStroke tab = KeyStroke.getKeyStroke(KeyEvent.VK_TAB, 0);
            KeyStroke ctrlTab = KeyStroke.getKeyStroke(KeyEvent.VK_TAB, KeyEvent.CTRL_DOWN_MASK);
            Set<KeyStroke> keys = new HashSet<>();
            keys.add(enter);
            keys.add(tab);
            keys.add(ctrlTab);
            KeyboardFocusManager.getCurrentKeyboardFocusManager().setDefaultFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, keys);
        
        }
    }

    

