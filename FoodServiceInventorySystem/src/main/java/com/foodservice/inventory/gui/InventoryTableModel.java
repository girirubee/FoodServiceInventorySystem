package com.foodservice.inventory.gui;
import com.foodservice.inventory.model.InventoryItem; import javax.swing.table.AbstractTableModel; import java.util.*;
public class InventoryTableModel extends AbstractTableModel {
  private final String[] cols={"ID","Item","Category","Qty","Unit","Supplier","Price","Expiration","Minimum","Status"}; private List<InventoryItem> items=new ArrayList<>();
  public void setItems(List<InventoryItem> v){items=new ArrayList<>(v);fireTableDataChanged();} public InventoryItem getItemAt(int r){return items.get(r);} public int getRowCount(){return items.size();} public int getColumnCount(){return cols.length;} public String getColumnName(int c){return cols[c];}
  public Object getValueAt(int r,int c){InventoryItem i=items.get(r);return switch(c){case 0->i.getId();case 1->i.getName();case 2->i.getCategory();case 3->i.getQuantity();case 4->i.getUnit();case 5->i.getSupplier();case 6->String.format("$%.2f",i.getUnitPrice());case 7->i.getExpirationDate();case 8->i.getMinimumStock();case 9->i.isLowStock()?"LOW STOCK":"Available";default->"";};}
}
