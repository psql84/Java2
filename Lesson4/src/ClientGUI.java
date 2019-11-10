import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.*;
import java.util.List;

public class ClientGUI  extends JFrame implements ActionListener, Thread.UncaughtExceptionHandler {

    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;

    private final JTextArea log = new JTextArea();
    private final JPanel panelTop = new JPanel(new GridLayout(2, 3));
    private final JTextField tfIPAddress = new JTextField("127.0.0.1");
    private final JTextField tfPort = new JTextField("8189");
    private final JCheckBox cbAlwaysOnTop = new JCheckBox("Always on top", true);
    private final JTextField tfLogin = new JTextField("ivan");
    private final JPasswordField tfPassword = new JPasswordField("123");
    private final JButton btnLogin = new JButton("Login");

    private final JPanel panelBottom = new JPanel(new BorderLayout());
    private final JButton btnDisconnect = new JButton("<html><b>Disconnect</b></html>");
    private final JTextField tfMessage = new JTextField();
    private final JButton btnSend = new JButton("Send");

    private final JList<String> userList = new JList<>();
    private Object Data;
    private Object Time;

    public static void main(String[] args)  {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ClientGUI();
            }
        });
    }

    private ClientGUI() {
        Thread.setDefaultUncaughtExceptionHandler(this);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(WIDTH, HEIGHT);
        setTitle("Chat Client");
        setAlwaysOnTop(true);
        JScrollPane scrollLog = new JScrollPane(log);
        JScrollPane scrollUsers = new JScrollPane(userList);
        String[] users = {"user1", "user2", "user3", "user4",
                "user5", "user6", "user7", "user8", "a very_long_named_user_in_this_chat"};
        userList.setListData(users);
        scrollUsers.setPreferredSize(new Dimension(100, 0));
        cbAlwaysOnTop.addActionListener(this);


        panelTop.add(tfIPAddress);
        panelTop.add(tfPort);
        panelTop.add(cbAlwaysOnTop);
        panelTop.add(tfLogin);
        panelTop.add(tfPassword);
        panelTop.add(btnLogin);
        panelBottom.add(btnDisconnect, BorderLayout.WEST);
        panelBottom.add(tfMessage, BorderLayout.CENTER);
        panelBottom.add(btnSend, BorderLayout.EAST);
        btnSend.addActionListener(this);
        tfMessage.addKeyListener(new KeyAdapter() {             // по кнопке ENTER
            @Override
            public void keyPressed(KeyEvent e) {
               if(e.getKeyCode() ==KeyEvent.VK_ENTER) {
                   try {
                       run();
                   } catch (IOException ex) {
                       ex.printStackTrace();
                   }
               }
               }
        });
                add(scrollLog, BorderLayout.CENTER);
    add(scrollUsers, BorderLayout.EAST);
    add(panelBottom, BorderLayout.SOUTH);
    add(panelTop, BorderLayout.NORTH);
    setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == cbAlwaysOnTop) {
            setAlwaysOnTop(cbAlwaysOnTop.isSelected());
        }
        else if (src == btnSend){       //нажатие на кнопку
            try {
                run();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        else {
            throw new RuntimeException("Unknown source: " + src);
        }
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        e.printStackTrace();
        String msg;
        StackTraceElement[] ste = e.getStackTrace();
        msg = e.getClass().getCanonicalName() + ": " +
                e.getMessage() + "\n\t" + ste[0];

        JOptionPane.showMessageDialog(this, msg, "Exception", JOptionPane.ERROR_MESSAGE);
        System.exit(1);
    }
    public void logFile() throws IOException {   //ЛОГ ФАЙЛ   намудрил конечно но задался целью вести лог  всего чата
       // int k=log.getLineCount();              //  конечно это работает при нажатие на клавишу или Enter надо было 
         String logTEXT=log.getText();           // наверно привязать к временным рамкам

        String[] arr= logTEXT.split("\n");
        ArrayList<String> arrList = new ArrayList<String>();
        for(String line: arr){
          arrList.add(line);//System.out.println(arrList);

        }
        List<String> links1 =  Files.readAllLines(Paths.get("LOGFILE.txt"), StandardCharsets.UTF_8);
          
           links1.addAll(arrList);
           LinkedHashSet<String> set = new LinkedHashSet<>(links1);
           Files.write(Paths.get("LOGFILE.txt"), set, StandardCharsets.UTF_8);
          // System.out.println(set);
      /*  try
                (FileWriter writer = new FileWriter("LOGFILE.txt", false)){
              //writer.append(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT))
              //        +"   "+tfMessage.getText()+"\n");

           //writer.append(log.getText())  ;
            writer.append((CharSequence) arrList);

        } catch (IOException e) {
            e.printStackTrace();
        }    */

    }


  private void run() throws IOException {         // добавление по кнопке или нажатию
         log.append(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)) +
                 "   " + tfMessage.getText() + "\n");
         logFile();
         tfMessage.setText("");
                }
     
}
