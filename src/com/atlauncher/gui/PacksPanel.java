/**
 * Copyright 2013 by ATLauncher and Contributors
 *
 * ATLauncher is licensed under CC BY-NC-ND 3.0 which allows others you to
 * share this software with others as long as you credit us by linking to our
 * website at http://www.atlauncher.com. You also cannot modify the application
 * in any way or make commercial use of this software.
 *
 * Link to license: http://creativecommons.org/licenses/by-nc-nd/3.0/
 */
package com.atlauncher.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.atlauncher.listeners.InstanceListener;

@SuppressWarnings("serial")
public class PacksPanel extends JPanel {

    private JFrame parent;
    private JTable packsTable;
    private JSplitPane splitPane;
    private JPanel packActions;
    private JButton newInstance;
    private JButton showMods;
    private InstanceListener instanceListener;

    public PacksPanel(final JFrame parent) {
        this.parent = parent;
        setLayout(new BorderLayout());

        final PacksTable packsTable = new PacksTable();
        packsTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                packActions.setVisible(true);
            }
        });

        packActions = new JPanel(new FlowLayout());

        newInstance = new JButton("New Instance");
        newInstance.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new NewInstanceDialog(parent, packsTable.getSelectedPack(), instanceListener);
            }
        });
        packActions.add(newInstance);

        showMods = new JButton("Show Mods");
        packActions.add(showMods);
        packActions.setVisible(false);

        splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, new JScrollPane(
                packsTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER), packActions);
        splitPane.setEnabled(false);
        splitPane.setDividerLocation(375);
        add(splitPane, BorderLayout.CENTER);
    }

    public void setInstanceListener(InstanceListener instanceListener) {
        this.instanceListener = instanceListener;
    }
}