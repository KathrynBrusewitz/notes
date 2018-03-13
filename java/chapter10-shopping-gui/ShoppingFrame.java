/**
 *
 * @author Reges and Stepp, Building Java Programs
 * modified by W.P. Iverson, Bellevue College, 2015
 * for CS211 class
 *
 * Stuart Reges
 * 3/28/07
 * Class ShoppingFrame provides the user interface for a simple shopping
 * program, starting with Building Java Programs, chapter 10, project 1.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class ShoppingFrame extends JFrame {
    private ShoppingCart items;
    private JTextField total;

    public ShoppingFrame(ArrayList<Item> products)      {
        // Create frame and order list
        setTitle("CS Gift Catalog");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        items = new ShoppingCart();

        // Set up text field with order total
        total = new JTextField("$0.00", 12);
        total.setEditable(false);
        total.setEnabled(false);
        total.setDisabledTextColor(Color.BLACK);
        JPanel p = new JPanel();
        p.setBackground(Color.blue);
        JLabel l = new JLabel("order total");
        l.setForeground(Color.YELLOW);
        p.add(l);
        p.add(total);
        add(p, BorderLayout.NORTH);

        p = new JPanel(new GridLayout(products.size(), 1));
        for (int i = 0; i < products.size(); i++)
            addItem(products.get(i), p);
        add(p, BorderLayout.CENTER);

        p = new JPanel();
       add(makeCheckBoxPanel(), BorderLayout.SOUTH);

        // Adjust size to just fit
        pack();
    }

    // Set up the Discount Checkbox
    private JPanel makeCheckBoxPanel() {
        JPanel p = new JPanel();
        p.setBackground(Color.blue);
        final JCheckBox cb = new JCheckBox("qualify for discount");
        p.add(cb);

        cb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                items.setDiscount(cb.isSelected());
                updateTotal();
            }
        });

        return p;
    }

    // Adds a product to the panel
    private void addItem(final Item product, JPanel p) {
        JPanel sub = new JPanel(new FlowLayout(FlowLayout.LEFT));
        sub.setBackground(new Color(0, 180, 0));
        final JTextField quantity = new JTextField(3);
        quantity.setHorizontalAlignment(SwingConstants.CENTER);

        quantity.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateItem(product, quantity);
                quantity.transferFocus();
            }
        });

        quantity.addFocusListener(new FocusAdapter() {
            public void focusLost(FocusEvent e) {
                updateItem(product, quantity);
            }
        });

        sub.add(quantity);
        JLabel l = new JLabel("" + product);
        l.setForeground(Color.white);
        sub.add(l);
        p.add(sub);
    }

    // When the user types a new value into one of the quantity fields,
    // parse the input and update ShoppingCart. Display an error
    // message if text is not a number or is negative.
    private void updateItem(Item product, JTextField quantity) {
        int number;
        String text = quantity.getText().trim();
        try {
            number = Integer.parseInt(text);
        } catch (NumberFormatException error) {
            number = 0;
        }
        if (number <= 0 && text.length() > 0) {
            Toolkit.getDefaultToolkit().beep();
            quantity.setText("");
            number = 0;
        }
        items.add(new ItemOrder(product, number));
        updateTotal();
    }

    // Reset order total
    private void updateTotal() {
        double amount = items.getTotal();
        total.setText(NumberFormat.getCurrencyInstance().format(amount));
    }

    public static void main(String[] args) {
        ArrayList<Item> list = new ArrayList<Item>();

        list.add(new Item("item 1", 49.99));
        list.add(new Item("item 2", 3.95, 10, 19.99));
        list.add(new Item("item 3", 0.99));
        list.add(new Item("item 4", 49.99));
        list.add(new Item("item 5", 3.50, 10, 14.95));
        list.add(new Item("item 6", 0.99, 20, 8.95));
        list.add(new Item("item 7", 3.40));
        list.add(new Item("item 8", 0.99, 10, 5.0));
        list.add(new Item("item 9", 389.99));
        list.add(new Item("item 10", 9.10));
        list.add(new Item("item 11", 19.99));

        ShoppingFrame f = new ShoppingFrame(list);
        f.setVisible(true);
    }

}
