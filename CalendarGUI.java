import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CalendarGUI extends JFrame {

    DefaultListModel<String> listModel  = new DefaultListModel<>();
    JList<String> calData = new JList<>(listModel);



    // tasks
    JPanel taskTimePanel = new JPanel();
    JTextField taskHourField = new JTextField();
    JTextField taskMinuteField = new JTextField();

    JPanel taskPanel = new JPanel();
    JPanel taskAddPanel = new JPanel();

    JPanel dayPanel = new JPanel();
    JCheckBox sunday = new JCheckBox("Sun");
    JCheckBox monday = new JCheckBox("Mon");
    JCheckBox tuesday = new JCheckBox("Tue");
    JCheckBox wednesday = new JCheckBox("Wed");
    JCheckBox thursday = new JCheckBox("Thu");
    JCheckBox friday = new JCheckBox("Fri");
    JCheckBox saturday = new JCheckBox("Sat");

    JTextField taskDescField = new JTextField();
    JButton taskDeleteBtn = new JButton("remove task");
    JButton taskSubmitBtn = new JButton("add task");

    DefaultListModel<String> taskListModel  = new DefaultListModel<>();
    JList<String> taskList = new JList<>(taskListModel);




    // events
    DefaultListModel<String> eventListModel  = new DefaultListModel<>();
    JList<String> eventList = new JList<>(eventListModel);


    JPanel eventSelectPanel = new JPanel();
    JPanel eventPanel = new JPanel();


    JPanel eventTimePanel = new JPanel();
    JPanel eventDayPanel = new JPanel();
    JPanel eventYearPanel = new JPanel();
    JTextField eventHourField = new JTextField();
    JTextField eventMinuteField = new JTextField();
    JTextField eventDayField = new JTextField();
    JTextField eventMonthField = new JTextField();
    JTextField eventYearField = new JTextField();
    JButton eventSubmitBtn = new JButton("Submit event");
    JButton eventDeleteBtn = new JButton("Delete event");

    ActionListener taskDelete = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            int deleteIndex = taskList.getSelectedIndex();
            taskListModel.removeElementAt(deleteIndex);

        }
    };


    ActionListener taskSubmit = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String hour = taskHourField.getText();
            String min = taskMinuteField.getText();
            String days = genDayString();
            String label = taskDescField.getText();
            System.out.println("Duck");

            taskListModel.addElement(days + ":" + hour + ":" + min + ":" + label);

        }
    };

    ActionListener eventSubmit = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String hour = eventHourField.getText();
            String min = eventMinuteField.getText();
            String day = eventDayField.getText();
            String month = eventMonthField.getText();
            String year = eventYearField.getText();
            eventListModel.addElement(hour + ":" + min + " " + month + "/" + day + "/" + year);

            System.out.println(min + hour + day + month + year);
        }
    };

    ActionListener eventDelete = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            int deleteIndex = eventList.getSelectedIndex();
            eventListModel.removeElementAt(deleteIndex);

        }
    };

    public CalendarGUI() {
        super("Calendar");
        setPreferredSize(new Dimension(1300, 500));
        setLayout(new GridLayout(1,3));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        /*
            Task Panel:
         */

        //    Row 1:  Setting up the time panel
        taskTimePanel.setLayout(new GridLayout(1, 4));
        taskTimePanel.add(new JLabel("Hour"));
        taskTimePanel.add(taskHourField);
        taskTimePanel.add(new JLabel("Min"));
        taskTimePanel.add(taskMinuteField);

        //    Row 2: Setting up the day panel
        dayPanel.setLayout(new GridLayout(1, 7));
        dayPanel.add(sunday);
        dayPanel.add(monday);
        dayPanel.add(tuesday);
        dayPanel.add(wednesday);
        dayPanel.add(thursday);
        dayPanel.add(friday);
        dayPanel.add(saturday);

        taskSubmitBtn.addActionListener(taskSubmit);


        taskAddPanel.setLayout(new GridLayout(4,1));
        taskAddPanel.add(taskTimePanel);
        taskAddPanel.add(dayPanel);
        taskAddPanel.add(taskDescField);
        taskAddPanel.add(taskSubmitBtn);

        taskPanel = new JPanel();
        taskPanel.setLayout(new BorderLayout(5,5));
        taskPanel.add(taskAddPanel, BorderLayout.PAGE_START);
        taskPanel.add(new JScrollPane(taskList), BorderLayout.CENTER);
        taskPanel.add(taskDeleteBtn, BorderLayout.PAGE_END);


        taskDeleteBtn.addActionListener(taskDelete);

        /*
            Event panel
         */

        // Row 1
        eventTimePanel.setLayout(new GridLayout(1, 4));
        eventTimePanel.add(new JLabel("Hour:"));
        eventTimePanel.add(eventHourField);
        eventTimePanel.add(new JLabel("Min:"));
        eventTimePanel.add(eventMinuteField);

        // Row 2
        eventDayPanel.setLayout(new GridLayout(1, 4));
        eventDayPanel.add(new JLabel("Month:"));
        eventDayPanel.add(eventMonthField);
        eventDayPanel.add(new JLabel("Day:"));
        eventDayPanel.add(eventDayField);

        // Row 3
        eventYearPanel.setLayout(new GridLayout(1, 4));
        eventYearPanel.add(new JLabel("Year:"));
        eventYearPanel.add(eventYearField);
        eventYearPanel.add(new JLabel(" "));
        eventYearPanel.add(new JLabel("  "));

        // Row 4
        eventSubmitBtn.addActionListener(eventSubmit);
        eventDeleteBtn.addActionListener(eventDelete);

        eventSelectPanel.setLayout(new GridLayout(4,1));
        eventSelectPanel.add(eventTimePanel);
        eventSelectPanel.add(eventDayPanel);
        eventSelectPanel.add(eventYearPanel);
        eventSelectPanel.add(eventSubmitBtn);

        eventPanel.setLayout(new BorderLayout(5,5));
        eventPanel.add(eventSelectPanel, BorderLayout.PAGE_START);
        eventPanel.add(new JScrollPane(eventList), BorderLayout.CENTER);
        eventPanel.add(eventDeleteBtn, BorderLayout.PAGE_END);

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
