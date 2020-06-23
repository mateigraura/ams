package com.presentation.screens.tables;

import lombok.Getter;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

@Getter
public class InboundTableScreen {

    private JScrollPane inboundTableScroll;
    private JTable inboundTable;

    public InboundTableScreen() {
        initComponents();
    }

    private void initComponents() {
        inboundTableScroll = new JScrollPane();
        inboundTable = new JTable();

        inboundTableScroll.setBackground(new Color(238, 238, 238));
        inboundTableScroll.setBorder(null);
        inboundTableScroll.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

        inboundTable.setFont(new Font("Segoe UI", 1, 14));
        inboundTable.setForeground(new Color(91, 91, 91));
        inboundTable.setModel(new DefaultTableModel(
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
                        {null, null, null, null}
                },
                new String[]{
                        "Id", "Source", "Destination", "Status"
                }
        ) {
            Class[] types = new Class[]{
                    Integer.class, String.class, String.class, Object.class
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
        inboundTable.setFocusable(false);
        inboundTable.setGridColor(new Color(204, 204, 204));
        inboundTable.setIntercellSpacing(new Dimension(0, 0));
        inboundTable.setName("");
        inboundTable.setOpaque(false);
        inboundTable.setRowHeight(40);
        inboundTable.setSelectionBackground(new Color(109, 150, 244));
        inboundTable.setShowGrid(false);
        inboundTable.getTableHeader().setReorderingAllowed(false);
        inboundTableScroll.setViewportView(inboundTable);

        inboundTable.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 18));
        inboundTable.getTableHeader().setOpaque(false);
        inboundTable.getTableHeader().setBackground(new Color(238, 238, 238));
        inboundTable.getTableHeader().setForeground(new Color(91, 91, 91));

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int columnIndex = 0; columnIndex < inboundTable.getColumnCount(); columnIndex++) {
            inboundTable.getColumnModel().getColumn(columnIndex).setCellRenderer(centerRenderer);
        }

        ((DefaultTableCellRenderer) inboundTable.getTableHeader().getDefaultRenderer())
                .setHorizontalAlignment(JLabel.CENTER);
    }
}
