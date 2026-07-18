package com.foodservice.inventory.gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class DashboardFrame extends JFrame {

    public DashboardFrame() {
        setTitle("Food Service Inventory - Dashboard");
        setSize(760, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JLabel titleLabel = new JLabel(
                "Food Service Inventory Dashboard",
                SwingConstants.CENTER
        );
        titleLabel.setFont(new Font("Arial", Font.BOLD, 26));

        JPanel cardsPanel = new JPanel(new GridLayout(2, 2, 18, 18));
        cardsPanel.setBorder(
                BorderFactory.createEmptyBorder(25, 35, 25, 35)
        );

        cardsPanel.add(createCard(
                "Total Inventory Items",
                "View all stored products"
        ));

        cardsPanel.add(createCard(
                "Low Stock Items",
                "Products that need reordering"
        ));

        cardsPanel.add(createCard(
                "Expiring Soon",
                "Products near expiration"
        ));

        cardsPanel.add(createCard(
                "Inventory Value",
                "Total value of current stock"
        ));

        JButton inventoryButton = new JButton("Open Inventory");
        JButton logoutButton = new JButton("Logout");

        inventoryButton.addActionListener(event -> {
            MainFrame mainFrame = new MainFrame();
            mainFrame.setVisible(true);
            dispose();
        });

        logoutButton.addActionListener(event -> {
            LoginFrame loginFrame = new LoginFrame();
            loginFrame.setVisible(true);
            dispose();
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(inventoryButton);
        buttonPanel.add(logoutButton);

        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.setBorder(
                BorderFactory.createEmptyBorder(20, 20, 20, 20)
        );

        contentPanel.add(titleLabel, BorderLayout.NORTH);
        contentPanel.add(cardsPanel, BorderLayout.CENTER);
        contentPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(contentPanel);
    }

    private JPanel createCard(String heading, String description) {
        JPanel card = new JPanel(new BorderLayout());

        card.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createEtchedBorder(),
                        BorderFactory.createEmptyBorder(20, 15, 20, 15)
                )
        );

        JLabel headingLabel = new JLabel(
                heading,
                SwingConstants.CENTER
        );
        headingLabel.setFont(new Font("Arial", Font.BOLD, 18));

        JLabel descriptionLabel = new JLabel(
                description,
                SwingConstants.CENTER
        );

        card.add(headingLabel, BorderLayout.CENTER);
        card.add(descriptionLabel, BorderLayout.SOUTH);

        return card;
    }
}