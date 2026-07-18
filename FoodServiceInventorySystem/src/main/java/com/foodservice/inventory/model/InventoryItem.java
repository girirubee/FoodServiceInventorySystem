package com.foodservice.inventory.model;
public class InventoryItem {
  private int id, quantity, minimumStock; private String name, category, unit, supplier, expirationDate; private double unitPrice;
  public InventoryItem() {}
  public InventoryItem(int id,String name,String category,int quantity,String unit,String supplier,double unitPrice,String expirationDate,int minimumStock){this.id=id;this.name=name;this.category=category;this.quantity=quantity;this.unit=unit;this.supplier=supplier;this.unitPrice=unitPrice;this.expirationDate=expirationDate;this.minimumStock=minimumStock;}
  public boolean isLowStock(){return quantity<=minimumStock;} public double getInventoryValue(){return quantity*unitPrice;}
  public int getId(){return id;} public void setId(int v){id=v;} public int getQuantity(){return quantity;} public void setQuantity(int v){quantity=v;} public int getMinimumStock(){return minimumStock;} public void setMinimumStock(int v){minimumStock=v;}
  public String getName(){return name;} public void setName(String v){name=v;} public String getCategory(){return category;} public void setCategory(String v){category=v;} public String getUnit(){return unit;} public void setUnit(String v){unit=v;} public String getSupplier(){return supplier;} public void setSupplier(String v){supplier=v;} public String getExpirationDate(){return expirationDate;} public void setExpirationDate(String v){expirationDate=v;}
  public double getUnitPrice(){return unitPrice;} public void setUnitPrice(double v){unitPrice=v;}
}
