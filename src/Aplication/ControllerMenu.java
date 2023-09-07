
package Aplication;

import View.FormUser;
import View.Menu;
import View.SearchUser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ControllerMenu implements ActionListener {

    Menu mn;

    public ControllerMenu(Menu mn) {
        this.mn = mn;
        this.mn.btn_exit.addActionListener(this);
        this.mn.btn_register.addActionListener(this);
        this.mn.btn_search.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == mn.btn_exit){
            System.exit(0);
            
        }else if(e.getSource() == mn.btn_register){
            FormUser fru = new FormUser();
            fru.setVisible(true);
            
        }else if(e.getSource() == mn.btn_search){
            SearchUser shu = new SearchUser();
            shu.setVisible(true);
        }
    }
    
}
