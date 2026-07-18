package com.foodservice.inventory.database;
import java.sql.*;
public final class Database {
  private static final String URL = "jdbc:sqlite:food_inventory.db";
  private Database() {}
  public static Connection getConnection() throws SQLException { return DriverManager.getConnection(URL); }
  public static void initialize() {
    String sql = """
      CREATE TABLE IF NOT EXISTS inventory_items (
        id INTEGER PRIMARY KEY AUTOINCREMENT,
        name TEXT NOT NULL,
        category TEXT NOT NULL,
        quantity INTEGER NOT NULL CHECK(quantity >= 0),
        unit TEXT NOT NULL,
        supplier TEXT,
        unit_price REAL NOT NULL CHECK(unit_price >= 0),
        expiration_date TEXT,
        minimum_stock INTEGER NOT NULL CHECK(minimum_stock >= 0)
      )
      """;
    try (Connection c = getConnection(); Statement s = c.createStatement()) { s.execute(sql); }
    catch (SQLException e) { throw new IllegalStateException("Database setup failed: " + e.getMessage(), e); }
  }
}
