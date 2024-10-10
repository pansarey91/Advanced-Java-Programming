import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Assign4SetB2 extends JFrame {
    private JTextField txtName, txtPhone;
    private JButton btnDelete, btnUpdate, btnNext, btnPrevious;
    private JLabel lblStatus;
    private ArrayList<Contact> contacts;
    private int currentIndex = 0;

    public Assign4SetB2() {
        setTitle("Phone Book Application");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Initialize the contact list
        contacts = new ArrayList<>();
        contacts.add(new Contact("Alice", 1234567890L));
        contacts.add(new Contact("Bob", 9876543210L));
        contacts.add(new Contact("Charlie", 1112223334L));

        // Create the form panel
        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.add(new JLabel("Name:"));
        txtName = new JTextField();
        panel.add(txtName);

        panel.add(new JLabel("Phone:"));
        txtPhone = new JTextField();
        panel.add(txtPhone);

        // Status label
        lblStatus = new JLabel("Status: Viewing Contact");
        panel.add(lblStatus);
        add(panel, BorderLayout.CENTER);

        // Create button panel
        JPanel btnPanel = new JPanel(new GridLayout(1, 4));
        btnDelete = new JButton("Delete");
        btnUpdate = new JButton("Update");
        btnNext = new JButton("Next");
        btnPrevious = new JButton("Previous");

        btnPanel.add(btnDelete);
        btnPanel.add(btnUpdate);
        btnPanel.add(btnNext);
        btnPanel.add(btnPrevious);

        add(btnPanel, BorderLayout.SOUTH);

        // Add listeners for buttons
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteContact();
            }
        });

        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    updateContact();
                } catch (InvalidDataException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnNext.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showNextContact();
            }
        });

        btnPrevious.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showPreviousContact();
            }
        });

        // Show the first contact initially
        displayContact(0);
    }

    // Method to display the contact at the given index
    private void displayContact(int index) {
        if (index >= 0 && index < contacts.size()) {
            Contact contact = contacts.get(index);
            txtName.setText(contact.getName());
            txtPhone.setText(String.valueOf(contact.getPhone()));
            lblStatus.setText("Viewing contact " + (index + 1) + " of " + contacts.size());
        }
    }

    // Method to delete the current contact
    private void deleteContact() {
        if (contacts.size() > 0) {
            contacts.remove(currentIndex);
            if (contacts.size() == 0) {
                txtName.setText("");
                txtPhone.setText("");
                lblStatus.setText("No contacts available.");
            } else {
                currentIndex = Math.min(currentIndex, contacts.size() - 1);
                displayContact(currentIndex);
            }
        }
    }

    // Method to update the current contact with validation
    private void updateContact() throws InvalidDataException {
        String name = txtName.getText().trim();
        long phone;

        if (name.isEmpty()) {
            throw new InvalidDataException("Name cannot be blank.");
        }

        try {
            phone = Long.parseLong(txtPhone.getText());
            if (phone < 0) {
                throw new InvalidDataException("Phone number cannot be negative.");
            }
        } catch (NumberFormatException ex) {
            throw new InvalidDataException("Invalid phone number.");
        }

        Contact contact = contacts.get(currentIndex);
        contact.setName(name);
        contact.setPhone(phone);
        lblStatus.setText("Contact updated.");
    }

    // Method to show the next contact
    private void showNextContact() {
        if (contacts.size() > 0) {
            currentIndex = (currentIndex + 1) % contacts.size();
            displayContact(currentIndex);
        }
    }

    // Method to show the previous contact
    private void showPreviousContact() {
        if (contacts.size() > 0) {
            currentIndex = (currentIndex - 1 + contacts.size()) % contacts.size();
            displayContact(currentIndex);
        }
    }

    // Custom exception class for invalid data
    class InvalidDataException extends Exception {
        public InvalidDataException(String message) {
            super(message);
        }
    }

    // Contact class representing each entry in the phone book
    class Contact {
        private String name;
        private long phone;

        public Contact(String name, long phone) {
            this.name = name;
            this.phone = phone;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public long getPhone() {
            return phone;
        }

        public void setPhone(long phone) {
            this.phone = phone;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Assign4SetB2().setVisible(true);
            }
        });
    }
}
