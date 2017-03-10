import javax.swing.*;
import java.awt.*;


public class CalendarGUI extends JFrame {


    JTextField addField;
    JButton addBtn;
    JList<String> calData;
    DefaultListModel<String> listModel;

    JPanel timePanel;
    JTextField hourField;
    JTextField minuteField;


    JPanel dayPanel;
    JCheckBox monday;
    JCheckBox tuesday;
    JCheckBox wednesday;
    JCheckBox thursday;
    JCheckBox friday;
    JCheckBox saturday;
    JCheckBox sunday;




    public CalendarGUI() {
        super("Calendar");




        /*
            Settin up the day panel
         */
        dayPanel = new JPanel();
        dayPanel.setLayout(new GridLayout(1, 7));

        monday = new JCheckBox("Mon");
        tuesday = new JCheckBox("Tue");
        wednesday = new JCheckBox("Wed");
        thursday = new JCheckBox("Thu");
        friday = new JCheckBox("Fri");
        saturday = new JCheckBox("Sat");
        sunday = new JCheckBox("Sun");

        dayPanel.add(monday);
        dayPanel.add(tuesday);
        dayPanel.add(wednesday);
        dayPanel.add(friday);
        dayPanel.add(saturday);
        dayPanel.add(sunday);



        /*
            Setting up the time panel
         */

        timePanel = new JPanel();
        timePanel.setLayout(new GridLayout(1, 4));

        minuteField = new JTextField();
        hourField = new JTextField();

        timePanel.add(new JLabel("Hour"));
        timePanel.add(hourField);
        timePanel.add(new JLabel("Min"));
        timePanel.add(minuteField);


        /*
            Creating the entire top field
         */
        addField = new JTextField();
        calData = new JList<>();
        addBtn = new JButton("add task");
        addBtn.addActionListener(e -> listModel.addElement(
                hourField.getText() + ":" +
                        minuteField.getText()+ ":" +
                        genDayString() + " : " +
                        addField.getText()));
        JPanel addBar = new JPanel();


        listModel = new DefaultListModel<>();
        calData = new JList<>(listModel);

        addBar.setLayout(new GridLayout(2,2));
        addBar.add(timePanel);
        addBar.add(dayPanel);
        addBar.add(addField);
        addBar.add(addBtn);

        setPreferredSize(new Dimension(700, 500));
        setLayout(new BorderLayout(5,5)); // new GridLayout(1, 2));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // JFrame.EXIT_ON_CLOSE);

        add(addBar, BorderLayout.PAGE_START);
        add(new JScrollPane(calData), BorderLayout.CENTER);

        pack();
        setVisible(true);
    }

    private String genDayString() {
        String result = "";

        if (monday.isSelected()) {result += "m";}
        if (tuesday.isSelected()) {result += "t";}
        if (wednesday.isSelected()) {result += "w";}
        if (thursday.isSelected()) {result += "h";}
        if (friday.isSelected()) {result += "f";}
        if (saturday.isSelected()) {result += "s";}
        if (sunday.isSelected()) {result += "u";}
        return result;
    }


    public static void main(String[] args) {
        new CalendarGUI();

    }

}
