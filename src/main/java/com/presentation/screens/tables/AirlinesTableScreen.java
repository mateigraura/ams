package com.presentation.screens.tables;

import lombok.Getter;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;

@Getter
public class AirlinesTableScreen {

    private JScrollPane airlinesTableScroll;
    private JTable airlinesTable;

    public AirlinesTableScreen() {
        initComponents();
    }

    private void initComponents() {
        airlinesTableScroll = new JScrollPane();
        airlinesTable = new JTable();

        airlinesTableScroll.setBackground(new Color(238, 238, 238));
        airlinesTableScroll.setBorder(null);
        airlinesTableScroll.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

        airlinesTable.setFont(new Font("Segoe UI", 1, 14));
        airlinesTable.setForeground(new Color(91, 91, 91));
        airlinesTable.setModel(new DefaultTableModel(
                new Object[][]{
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String[]{
                        "Id", "Name", "Alliance", "Main Hub"
                }
        ) {
            Class[] types = new Class[]{
                    Integer.class, String.class, String.class, String.class
            };
            boolean[] canEdit = new boolean[]{
                    false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        airlinesTable.setEnabled(false);
        airlinesTable.setFocusable(false);
        airlinesTable.setGridColor(new Color(204, 204, 204));
        airlinesTable.setIntercellSpacing(new Dimension(0, 0));
        airlinesTable.setOpaque(false);
        airlinesTable.setRowHeight(36);
        airlinesTable.setSelectionBackground(new Color(238, 238, 238));
        airlinesTable.setShowGrid(false);
        airlinesTable.getTableHeader().setReorderingAllowed(false);
        airlinesTableScroll.setViewportView(airlinesTable);

        JTableHeader airlinesTableHeader = airlinesTable.getTableHeader();
        airlinesTableHeader.setFont(new Font("Segoe UI", Font.BOLD, 18));
        airlinesTableHeader.setOpaque(false);
        airlinesTableHeader.setBackground(new Color(238, 238, 238));
        airlinesTableHeader.setForeground(new Color(91, 91, 91));

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int columnIndex = 0; columnIndex < airlinesTable.getColumnCount(); columnIndex++) {
            airlinesTable.getColumnModel().getColumn(columnIndex).setCellRenderer(centerRenderer);
        }

        ((DefaultTableCellRenderer) airlinesTable.getTableHeader().getDefaultRenderer())
                .setHorizontalAlignment(JLabel.CENTER);
    }
}
