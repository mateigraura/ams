package com.presentation.screens.tables;

import lombok.Getter;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

@Getter
public class OutboundTableScreen {

    private JScrollPane outboundTableScroll;
    private JTable outboundTable;

    public OutboundTableScreen() {
        initComponents();
    }

    private void initComponents() {
        outboundTableScroll = new JScrollPane();
        outboundTable = new JTable();

        outboundTableScroll.setBackground(new Color(238, 238, 238));
        outboundTableScroll.setBorder(null);
        outboundTableScroll.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

        outboundTable.setFont(new Font("Segoe UI", 1, 14));
        outboundTable.setForeground(new Color(91, 91, 91));
        outboundTable.setModel(new DefaultTableModel(
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
                        "Id", "Category", "Status", "Filed at"
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
        outboundTable.setFocusable(false);
        outboundTable.setGridColor(new Color(204, 204, 204));
        outboundTable.setIntercellSpacing(new Dimension(0, 0));
        outboundTable.setName("");
        outboundTable.setOpaque(false);
        outboundTable.setRowHeight(40);
        outboundTable.setSelectionBackground(new Color(109, 150, 244));
        outboundTable.setShowGrid(false);
        outboundTable.getTableHeader().setReorderingAllowed(false);
        outboundTableScroll.setViewportView(outboundTable);

        outboundTable.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 18));
        outboundTable.getTableHeader().setOpaque(false);
        outboundTable.getTableHeader().setBackground(new Color(238, 238, 238));
        outboundTable.getTableHeader().setForeground(new Color(91, 91, 91));

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int columnIndex = 0; columnIndex < outboundTable.getColumnCount(); columnIndex++) {
            outboundTable.getColumnModel().getColumn(columnIndex).setCellRenderer(centerRenderer);
        }

        ((DefaultTableCellRenderer) outboundTable.getTableHeader().getDefaultRenderer())
                .setHorizontalAlignment(JLabel.CENTER);
    }
}
