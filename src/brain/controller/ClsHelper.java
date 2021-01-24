
package brain.controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ClsHelper {
    public static DefaultTableModel dtm;
    public static PreparedStatement pst = null;
    public static ResultSet rs = null;
    
    public static void loadPanel(JPanel pnl1, JPanel pnl2)
    {
        pnl1.removeAll();
        pnl1.add(pnl2);
        pnl1.revalidate();
        pnl1.repaint();
    }
    
    public static void loadTable(JTable table, String Querry) throws Exception
    {        
        dtm = new DefaultTableModel();
        pst = DbConnect.connectDb().prepareStatement(Querry);
        rs = pst.executeQuery();
        //savoir combien de colonnes a notre querry
        for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) 
        {
            dtm.addColumn(rs.getMetaData().getColumnName(i + 1).toUpperCase());
            //toUpperCase transforme les nom en majuscule
        }        
        table.setModel(dtm);
        dtm.setRowCount(0);
        while (rs.next()) 
        {
            ObservableList<Object> liste = FXCollections.observableArrayList();
            for (int i = 1; i < rs.getMetaData().getColumnCount() + 1; i++) 
            {
                //ObservableList commence a zero tandis que ResultSet commence a 1
                //ObservableList+1 pour egaler avec le ResultSet
                liste.add(rs.getObject(i));
            }
            dtm.addRow(liste.toArray());
        }
        table.setModel(dtm);
        
    }
    
    public static void tableToForm(JTable table,Object obj[]) throws Exception
{
    try 
    {
        if (table.getSelectedRow()>=0)
        {
            for(int m=0;m<table.getColumnCount();m++)
            {
                obj[m]=table.getValueAt(table.getSelectedRow(), m).toString();
            }
        }
    } catch (Exception e) 
    {
        throw new Exception(e.getMessage());
    }
}
    
    //fonction pour charger les comboBox
    public static void loadComboBox(JComboBox comboBox,String Requette) throws Exception
    {        
        comboBox.removeAllItems();
        pst = DbConnect.connectDb().prepareStatement(Requette);
        rs = pst.executeQuery();    
        while (rs.next())
        { 
            comboBox.addItem(rs.getObject(1));
        }
       
    }
    
    public static int incrementIdTable(String table) throws Exception
    {        
        pst = DbConnect.connectDb().prepareStatement("SELECT COALESCE(MAX(id),0) FROM "+table+"");
        rs = pst.executeQuery();
        while (rs.next())
        {
            return (rs.getInt(1)+1);
        }        
        return 0;
    } 
    
    public static void txtClean(JTextField txt)
    {
        txt.setText("");
    }
}
