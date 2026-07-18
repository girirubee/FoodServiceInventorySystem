package com.foodservice.inventory;

import com.foodservice.inventory.database.Database;
import com.foodservice.inventory.gui.LoginFrame;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public final class Main {

    private Main() {
    }

    public static void main(String[] args) {
        Database.initialize();

        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(
                        UIManager.getSystemLookAndFeelClassName()
                );
            } catch (Exception exception) {
                System.out.println("Default appearance will be used.");
            }

            LoginFrame loginFrame = new LoginFrame();
            loginFrame.setVisible(true);
        });
    }
}
///
