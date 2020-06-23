package com.presentation.screens.tables;

import lombok.Getter;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;

@Getter
public class IssuesTableScreen {

    private JScrollPane issuesTableScroll;
    private JTable issuesTable;

    public IssuesTableScreen() {
        initComponents();
    }

    private void initComponents() {
        issuesTableScroll = new JScrollPane();
        issuesTable = new JTable();

        issuesTableScroll.setBackground(new Color(238, 238, 238));
        issuesTableScroll.setBorder(null);
        issuesTableScroll.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

        issuesTable.setFont(new Font("Segoe UI", 1, 14));
        issuesTable.setForeground(new Color(91, 91, 91));
        issuesTable.setModel(new DefaultTableModel(
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

        issuesTable.setFocusable(false);
        issuesTable.setGridColor(new Color(204, 204, 204));
        issuesTable.setIntercellSpacing(new Dimension(0, 0));
        issuesTable.setName("");
        issuesTable.setOpaque(false);
        issuesTable.setRowHeight(40);
        issuesTable.setSelectionBackground(new Color(109, 150, 244));
        issuesTable.setShowGrid(false);
        issuesTable.getTableHeader().setReorderingAllowed(false);
        issuesTableScroll.setViewportView(issuesTable);

        JTableHeader header = issuesTable.getTableHeader();
        header.setFont(new Font("Segoe UI", Font.BOLD, 18));
        header.setOpaque(false);
        header.setBackground(new Color(238, 238, 238));
        header.setForeground(new Color(91, 91, 91));

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int columnIndex = 0; columnIndex < issuesTable.getColumnCount(); columnIndex++) {
            issuesTable.getColumnModel().getColumn(columnIndex).setCellRenderer(centerRenderer);
        }

        ((DefaultTableCellRenderer) issuesTable.getTableHeader().getDefaultRenderer())
                .setHorizontalAlignment(JLabel.CENTER);
    }
}
