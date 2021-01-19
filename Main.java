package DSProject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
public class Main {
    static Scanner sc = null;
    static int index =0;
    static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy");
    static LocalDateTime date = LocalDateTime.now();
    static HashSet<Person> fazian;
    static int cur = Integer.parseInt(dtf.format(date));
    static JFileChooser chooser = new JFileChooser("D:\\Alireza\\Tuturials\\Uni\\Data Structure\\Project\\SampleData (2)");
    static CityGraph graph = new CityGraph();
    public static void main(String[] args) throws InterruptedException {
        selectFolder();
        showMainMenu();
    }
    static void selectFolder()
    {
        chooser.setDragEnabled(true);
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int choice = chooser.showOpenDialog(null);
        if (choice != JFileChooser.APPROVE_OPTION) {
            System.out.println("File not selected");
        }
    }
    static void showMainMenu() throws InterruptedException {
        JFrame frameMain = new JFrame();
        JButton people = new JButton("People");
        JButton accounts = new JButton("Accounts");
        JButton calls = new JButton("Calls");
        JButton cars = new JButton("Cars");
        JButton homes = new JButton("Homes");
        JButton ownerships = new JButton("Ownerships");
        JButton phones = new JButton("Phones");
        JButton relationships = new JButton("Relationships");
        JButton transactions = new JButton("Transactions");
        JButton faz2 = new JButton("Faz 2");
        JButton faz3 = new JButton("Faz 3");
        JButton faz4 = new JButton("Faz 4");
        JPanel panel1 = new JPanel(new GridLayout(4 , 3));
        panel1.add(people);
        panel1.add(accounts);
        panel1.add(calls);
        panel1.add(cars);
        panel1.add(homes);
        panel1.add(ownerships);
        panel1.add(phones);
        panel1.add(relationships);
        panel1.add(transactions);
        panel1.add(faz2);
        panel1.add(faz3);
        panel1.add(faz4);
        frameMain.add(panel1);
        frameMain.setLocationRelativeTo(null);
        frameMain.setSize(400 , 200);
        frameMain.setVisible(true);
        frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        people.addActionListener(actionEvent -> {
            try {
                showPeople();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        accounts.addActionListener(actionEvent -> {
            try {
                showAccounts();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        calls.addActionListener(actionEvent -> {
            try {
                showCalls();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        cars.addActionListener(actionEvent -> {
            try {
                showCars();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        homes.addActionListener(actionEvent -> {
            try {
                showHomes();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        ownerships.addActionListener(actionEvent -> {
            try {
                showOwn();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        phones.addActionListener(actionEvent -> {
            try {
                showPhones();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        relationships.addActionListener(actionEvent -> {
            try {
                showRelations();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        transactions.addActionListener(actionEvent -> {
            try {
                showTrans();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        faz2.addActionListener(actionEvent -> {
            try {
                faz2();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        faz3.addActionListener(actionEvent -> {
            try {
                faz3();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        faz4.addActionListener(actionEvent -> faz4());
        showPeople();
        showAccounts();
        showHomes();
        showPhones();
        showCars();
        showCalls();
        showTrans();
        showOwn();
        showRelations();
    }
    static void showPeople() throws InterruptedException {
        File file = new File(chooser.getSelectedFile().getAbsolutePath()+"\\people.csv");
        scanner(file, 6);
    }

    private static void scanner(File file, int i2) throws InterruptedException {
        try {
            sc = new Scanner(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<String[]> values = new ArrayList<>();
        assert sc != null;
        while (sc.hasNextLine())
        {
            String line = sc.nextLine();
            line = line.substring(1 , line.length()-1);
            String[] vals = line.split("\",\"");
            values.add(vals);
        }
        String[][] strings = new String[values.size()-1][i2];
        String[] raw = values.get(0);
        for (int i=1;i<values.size();i++)
            strings[i-1] = values.get(i);
        for (String[] i : strings)
        {
                switch (file.getName())
                {
                    case "people.csv": graph.add_person(new Person(i[0] , i[1] , i[2] , i[3] , i[4] , i[5]));break;
                    case "accounts.csv": graph.add_bankAccount(new BankAccount(Long.parseLong(i[0]) , i[1] , i[2] , i[3]));break;
                    case "phones.csv": graph.add_mobile(new Mobile(Long.parseLong(i[0])  , i[1] , i[2]));break;
                    case "cars.csv": graph.add_car(new Car(i[0] , i[1] , i[2] , i[3]));break;
                    case "homes.csv": graph.add_home(new Home(Long.parseLong(i[0]) , i[1] , i[2] , Integer.parseInt(i[3]) , i[4]));break;
                    case "ownerships.csv": graph.add_own(i);break;
                    case "transactions.csv": graph.add_transaction(i);break;
                    case "calls.csv": graph.add_call(i);break;
                    case "relationships.csv": graph.add_relation(i);break;
                }
        }
        JFrame jFrame = new JFrame();
        JTable table = new JTable(strings, raw);
        JScrollPane scrollPane = new JScrollPane(table);
        jFrame.add(scrollPane);
        jFrame.setLocationRelativeTo(null);
        jFrame.setExtendedState( jFrame.getExtendedState()|JFrame.MAXIMIZED_BOTH );
        jFrame.setVisible(true);
        System.out.println(table.getRowCount() + " " + file.getName().substring(0 , file.getName().length()-4));
        jFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
//        Thread.sleep(300);
        jFrame.dispatchEvent(new WindowEvent(jFrame , WindowEvent.WINDOW_CLOSING));
    }

    static void showAccounts() throws InterruptedException {
        File file = new File(chooser.getSelectedFile().getAbsolutePath()+"\\accounts.csv");
        scanner(file, 4);
    }
    static void showOwn() throws InterruptedException {
        File file = new File(chooser.getSelectedFile().getAbsolutePath()+"\\ownerships.csv");
        scanner(file, 5);
    }
    static void showPhones() throws InterruptedException {
        File file = new File(chooser.getSelectedFile().getAbsolutePath()+"\\phones.csv");
        scanner(file, 3);
    }
    static void showRelations() throws InterruptedException {
        File file = new File(chooser.getSelectedFile().getAbsolutePath()+"\\relationships.csv");
        scanner(file, 4);
    }
    static void showTrans() throws InterruptedException {
        File file = new File(chooser.getSelectedFile().getAbsolutePath()+"\\transactions.csv");
        scanner(file, 5);
    }
    static void showCalls() throws InterruptedException {
        File file = new File(chooser.getSelectedFile().getAbsolutePath()+"\\calls.csv");
        scanner(file, 5);
    }
    static void showCars() throws InterruptedException {
        File file = new File(chooser.getSelectedFile().getAbsolutePath()+"\\cars.csv");
        scanner(file, 4);
    }
    static void showHomes() throws InterruptedException {
        File file = new File(chooser.getSelectedFile().getAbsolutePath()+"\\homes.csv");
        scanner(file, 5);
    }
    static void faz2() throws IOException {
        HashMap<String,Person> persons= graph.persons;
        fazian = new HashSet<>();
        for(Person p:persons.values())
        {
            if(p.job.equals("گمرک") || p.job.equals("سازمان بنادر"))
            {
                if (checkfaz2(p))
                    fazian.add(p);
                for (Node node : p.connected.values())
                    if (node instanceof Person)
                        if (checkfaz2((Person) node))
                            fazian.add(p);
            }
        }
        File file = new File("d:\\maznonin 2.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        for (Person person : fazian)
        {
            String text = (++index) + "  ->  " + person.toString() + "\n";
            fileOutputStream.write(text.getBytes());
        }
    }

    static void faz3() throws IOException {
        HashMap<String,Person> persons= graph.persons;
        for(Person p:persons.values()) {
            if (p.job.equals("قاچاقچی"))
            {
                Person maz = checkfaz3(p);
                if (maz !=null)
                {
                    System.out.println(maz);
                    File file = new File("d:\\maznonin 3.txt");
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    String text = (++index) + "  ->  " + maz.toString() + "\n";
                    fileOutputStream.write(text.getBytes());
                }
                else fazian.remove(p);
            }
        }
    }
    static void faz4()
    {

    }
    static boolean checkfaz2(Person person)
    {
        for (Own own : person.owns.values())
        {
            int year = Integer.parseInt(own.time.substring(0 , 4));
            if (cur-year <= 3)
            {
                return true;
            }
        }
        return false;
    }
    static int i=0;
    static Person checkfaz3(Person person)
    {
        for (Edge e : person.edges.values())
        {
            if (e instanceof Transaction && i<=5)
            {
                i++;
                if (fazian.contains(((Transaction)e).to))
                {
                    i=0;
                    return (Person) ((Transaction) e ).to;
                }
                if (i==5)
                {
                    i=0;
                }
                return checkfaz3((Person) ((Transaction) e ).to);
            }
        }
        return null;
    }
}