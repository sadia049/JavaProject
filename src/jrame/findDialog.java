/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jrame;

import java.awt.Color;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Document;
import javax.swing.text.Highlighter;
import javax.swing.text.JTextComponent;
import java.awt.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Acer
 */
public class findDialog extends javax.swing.JDialog {

    /**
     * Creates new form findDialog
     */
      
  
 

    
    
    
    

    NewJFrame parent;
    findDialog()
    {
        
    }
    public findDialog(NewJFrame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.parent=parent;
        findDialog fd= new findDialog();
        settitle();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        textarea = new javax.swing.JTextField();
        findNext = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        match = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Find what");

        findNext.setText("Find Next");
        findNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findNextActionPerformed(evt);
            }
        });

        cancel.setText("Cancel");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        match.setText("match case");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(match)
                        .addGap(73, 73, 73)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(findNext, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                            .addComponent(cancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(textarea, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 27, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textarea, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(findNext)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(cancel)
                        .addContainerGap(26, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(match)
                        .addGap(35, 35, 35))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void findNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findNextActionPerformed
        String findnext=textarea.getText();
        String upper1=findnext.toUpperCase();
        String maintext=parent.ta.getText();
        String upper2=maintext.toUpperCase();
        findDialog fd= new findDialog();
        //System.out.println(maintext);
        
        if(match.isSelected())
        { 
             //findnext=textarea.getText().trim();
             //maintext=parent.ta.getText().trim();
            if(maintext.equals(findnext))
            {
                searchTextArea(parent.ta,findnext);
            }
            else{
               JOptionPane.showMessageDialog(this,"Can not find "+findnext);
               fd.show(); 
            }
      }
      else if(maintext==null||findnext==null)
      {
          JOptionPane.showMessageDialog(this,"Can not find");
          fd.show();
      }
      else{
          if(upper2.contains(upper1) )
         {
            searchTextArea(parent.ta,findnext);
         }
        else{
            JOptionPane.showMessageDialog(this,"Can not find "+findnext);
            fd.show();
        }
     }
        
       
    }//GEN-LAST:event_findNextActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
         removeHighlighter(parent.ta);
        
        this.setVisible(false);
    }//GEN-LAST:event_cancelActionPerformed

   

    private void settitle() {
        this.setTitle("Find");
    }
class myHighlighter extends DefaultHighlighter.DefaultHighlightPainter{
      
        public myHighlighter(Color color) {
            super(color);
        }
      
  }
 JTextComponent textcomp;
DefaultHighlighter.HighlightPainter highlighter = new myHighlighter(Color.YELLOW);
public void removeHighlighter(JTextComponent textcomp)
{
    Highlighter removehighlighter =textcomp.getHighlighter();
    Highlighter.Highlight[] remove;
    remove = removehighlighter.getHighlights();
    for(int i=0; i<remove.length; i++)
    {
        if(remove[i].getPainter() instanceof myHighlighter)
        {
           removehighlighter.removeHighlight(remove[i]);
        }
    }
    
}
public void searchTextArea(JTextComponent textcomp,String textString)
{
    removeHighlighter(textcomp);
    try{
       Highlighter hilight = textcomp.getHighlighter();
       Document doc = textcomp.getDocument();
       String text = doc.getText(0, doc.getLength());
       int pos=0;
       while((pos=text.toLowerCase().indexOf(textString.toLowerCase(),pos))>=0)
       {
          hilight.addHighlight(pos, pos+textString.length(), highlighter);
          pos+=textString.length();
       }
    }catch(Exception e)
    {
        System.out.println(e);
    }
} 
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(findDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(findDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(findDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(findDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                findDialog dialog = new findDialog(new NewJFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancel;
    private javax.swing.JButton findNext;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JCheckBox match;
    private javax.swing.JTextField textarea;
    // End of variables declaration//GEN-END:variables
}
