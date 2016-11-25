
package moneycalculator;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import moneycalculator.ui.swing.SwingMoneyDialog;
import moneycalculator.ui.swing.SwingMoneyDisplay;

public class MainFrame extends JFrame{
    private SwingMoneyDialog moneyDialog;
    private SwingMoneyDisplay moneyDisplay;

    public MainFrame(){
        setTitle("MoneyCalculator");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        add(moneyDialog(),BorderLayout.NORTH);
        add(moneyDisplay());
        add(toolbar(),BorderLayout.SOUTH);
        setVisible(true);
    }
    private Component moneyDialog(){
        SwingMoneyDialog dialog=new SwingMoneyDialog();
        moneyDialog=dialog;
        return dialog;
        
    }
    
    private Component moneyDisplay(){
        SwingMoneyDisplay display=new SwingMoneyDisplay();
        moneyDisplay=display;
        return display;
    }

    private Component toolbar() {
        JPanel panel=new JPanel(new FlowLayout());
        panel.add(calculatteButton());
        return panel;
    }

    private Component calculatteButton() {
        JButton button=new JButton("Calculate");
        button.addActionListener(calculate());
        return button;
    }

    private ActionListener calculate() {
        return new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent e){
                moneyDisplay.display(moneyDialog.get());
            }
        };
    }
    
    
}
