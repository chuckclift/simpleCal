import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CalendarGUI extends JFrame {


    JTextField addField = new JTextField();
    JButton addBtn = new JButton("add task");
    JList<String> calData;
    DefaultListModel<String> listModel  = new DefaultListModel<>();

    JPanel taskTimePanel = new JPanel();
    JTextField taskHourField = new JTextField();
    JTextField taskMinuteField = new JTextField();



    JPanel addBar = new JPanel();

    JPanel taskPanel = new JPanel();
    JPanel eventPanel = new JPanel();

    JPanel eventSelectPanel = new JPanel();
    JPanel dayPanel = new JPanel();
    JCheckBox sunday = new JCheckBox("Sun");
    JCheckBox monday = new JCheckBox("Mon");
    JCheckBox tuesday = new JCheckBox("Tue");
    JCheckBox wednesday = new JCheckBox("Wed");
    JCheckBox thursday = new JCheckBox("Thu");
    JCheckBox friday = new JCheckBox("Fri");
    JCheckBox saturday = new JCheckBox("Sat");

    JPanel eventTimePanel = new JPanel();
    JPanel eventDayPanel = new JPanel();
    JPanel eventYearPanel = new JPanel();
    JTextField eventHourField = new JTextField();
    JTextField eventMinuteField = new JTextField();
    JTextField eventDayField = new JTextField();
    JTextField eventMonthField = new JTextField();
    JTextField eventYearField = new JTextField();
    JButton eventSubmitBtn = new JButton("Submit event");

    ActionListener foo = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String hour = taskHourField.getText();
            String min = taskMinuteField.getText();
            String days = genDayString();
            String label = addField.getText();
            System.out.println("Duck");

            listModel.addElement(days + ":" + hour + ":" + min + ":" + label);

        }
    };

    public CalendarGUI() {
        super("Calendar");
        setPreferredSize(new Dimension(1300, 500));
        setLayout(new GridLayout(1,3));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        /*
            Setting up the day panel
         */
        dayPanel.setLayout(new GridLayout(1, 7));

        dayPanel.add(sunday);
        dayPanel.add(monday);
        dayPanel.add(tuesday);
        dayPanel.add(wednesday);
        dayPanel.add(thursday);
        dayPanel.add(friday);
        dayPanel.add(saturday);

        /*
            Setting up the time panel
         */

        taskTimePanel.setLayout(new GridLayout(1, 4));

        taskTimePanel.add(new JLabel("Hour"));
        taskTimePanel.add(taskHourField);
        taskTimePanel.add(new JLabel("Min"));
        taskTimePanel.add(taskMinuteField);


        /*
            Creating the left task field
         */

        addBtn.addActionListener(foo);
        calData = new JList<>(listModel);

        addBar.setLayout(new GridLayout(4,1));
        addBar.add(taskTimePanel);
        addBar.add(dayPanel);
        addBar.add(addField);
        addBar.add(addBtn);

        taskPanel = new JPanel();
        taskPanel.setLayout(new BorderLayout(5,5));
        taskPanel.add(addBar, BorderLayout.PAGE_START);

        /*
            Event panel
         */

        // eventTimePanel.setLayout(new GridLayout(3,4));

        eventTimePanel.setLayout(new GridLayout(1, 4));
        eventTimePanel.add(new JLabel("Hour:"));
        eventTimePanel.add(eventHourField);
        eventTimePanel.add(new JLabel("Min:"));
        eventTimePanel.add(eventMinuteField);

        eventDayPanel.setLayout(new GridLayout(1, 4));
        eventDayPanel.add(new JLabel("Month:"));
        eventDayPanel.add(eventMonthField);
        eventDayPanel.add(new JLabel("Day:"));
        eventDayPanel.add(eventDayField);

        eventYearPanel.setLayout(new GridLayout(1, 4));
        eventYearPanel.add(new JLabel("Year:"));
        eventYearPanel.add(eventYearField);
        eventYearPanel.add(new JLabel(" "));
        eventYearPanel.add(new JLabel("  "));






        eventSelectPanel.setLayout(new GridLayout(4,1));
        eventSelectPanel.add(eventTimePanel);
        eventSelectPanel.add(eventDayPanel);
        eventSelectPanel.add(eventYearPanel);
        eventSelectPanel.add(eventSubmitBtn);


        eventPanel.setLayout(new BorderLayout(5,5));
        eventPanel.add(eventSelectPanel, BorderLayout.PAGE_START); // eventTimePanel, BorderLayout.PAGE_START );

        add(taskPanel);
        add(new JScrollPane(calData));
        add(eventPanel);

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
