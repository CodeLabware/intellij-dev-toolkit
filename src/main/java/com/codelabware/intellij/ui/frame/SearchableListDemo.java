package com.codelabware.intellij.ui.frame;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SearchableListDemo extends JPanel {
    private final String[] categories = {"Fruits", "Vegetables", "Meat"};
    private final String[][] items = {
            {"Apple", "Banana", "Cherry", "Grape", "Kiwi", "Orange", "Pear", "Pineapple", "Strawberry", "Watermelon"},
            {"Carrot", "Celery", "Cucumber", "Eggplant", "Potato", "Tomato", "Spinach", "Pepper", "Onion", "Garlic"},
            {"Beef", "Pork", "Chicken", "Fish", "Lamb", "Shrimp", "Crab", "Duck", "Turkey", "Ham"}
    };
    private final JList<String> list = new JList<>(categories);
    private final JTextField searchField = new JTextField();
    private final DefaultListModel<String> model = new DefaultListModel<>();
    private final JList<String> result = new JList<>(model);

    public SearchableListDemo() {
//        setTitle("Searchable List Demo");
        setSize(400, 300);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JScrollPane scrollPane = new JScrollPane(result);

        list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int index = list.getSelectedIndex();
                model.clear();
                for (String item : items[index]) {
                    model.addElement(item);
                }
            }
        });
        searchField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                filter();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                filter();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                filter();
            }

            private void filter() {
                String query = searchField.getText().trim().toLowerCase();
                model.clear();
                for (int i = 0; i < items.length; i++) {
                    for (int j = 0; j < items[i].length; j++) {
                        if (items[i][j].toLowerCase().contains(query)) {
                            model.addElement(categories[i] + " - " + items[i][j]);
                        }
                    }
                }
            }
        });

        panel.add(list, BorderLayout.WEST);
        panel.add(searchField, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);

        add(panel);

        result.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    JOptionPane.showMessageDialog(SearchableListDemo.this, result.getSelectedValue());
                }
            }
        });

        setVisible(true);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new SearchableListDemo();
    }
}
