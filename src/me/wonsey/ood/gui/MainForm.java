package me.wonsey.ood.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.event.MenuKeyListener;

import me.wonsey.ood.commands.BeginTaskCommand;
import me.wonsey.ood.commands.CompleteTaskCommand;
import me.wonsey.ood.containers.Node;
import me.wonsey.ood.states.CompletedState;
import me.wonsey.ood.states.InProgressState;
import me.wonsey.ood.states.WaitingState;
import me.wonsey.ood.tasks.ITask;
import me.wonsey.ood.tasks.Task;

import javax.swing.event.MenuKeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class MainForm
{

   private JFrame frame;
   private final ButtonGroup buttonGroup = new ButtonGroup();
   JRadioButton all_RadioButton;
   JRadioButton waiting_RadioButton;
   JRadioButton inprogress_RadioButton;
   JRadioButton complete_RadioButton;
   private JTextField addNewTaskField;
   JTextArea textArea;
   JLabel task_name_label;
   JLabel task_status_label;
   JButton moveToInProgressButton;
   int reee = 0;
   
   DefaultListModel<Task> listModel1 = new DefaultListModel<Task>();
   
   Manager task_manager;
   ITask selectedTask;
   
   private static final int ALL_TASKS        = 0;
   private static final int WAITING_TASKS    = 1;
   private static final int INPROGRESS_TASKS = 2;
   private static final int COMPLETED_TASKS  = 3;

   /**
    * Launch the application.
    */
   public static void main(String[] args)
   {
      EventQueue.invokeLater(new Runnable()
      {
         public void run()
         {
            try
            {
               MainForm window = new MainForm();
               window.frame.setVisible(true);
            }
            catch (Exception e)
            {
               e.printStackTrace();
            }
         }
      });
   }
   
   void taskDetailFormUpdate()
   {
      if (selectedTask == null)
      {
         selectedTask = new Task();
      }
      textArea.setText(((Task) selectedTask).getTaskNotes());
      task_name_label.setText(((Task) selectedTask).getTaskName());
      task_status_label.setText(((Task) selectedTask).getState().toString());
      
      boolean isWaiting = ((Task) selectedTask).getState() instanceof WaitingState;
      moveToInProgressButton.setEnabled(isWaiting);
   }
   
   void populateTaskList()
   {
      me.wonsey.ood.containers.Iterable<Task> ll_iter = task_manager.getList().createIterator(); //list.createIterator();
      listModel1.clear();
      Task task = null;
      while (ll_iter.hasNext())
      {
         if (all_RadioButton.isSelected())
         {
            listModel1.addElement(ll_iter.next());
         }
         else
         {
            task = ll_iter.next();
            if (waiting_RadioButton.isSelected() && (task.getState() instanceof WaitingState))
               listModel1.addElement(task);
            if (inprogress_RadioButton.isSelected() && (task.getState() instanceof InProgressState))
               listModel1.addElement(task);
            if (complete_RadioButton.isSelected() && (task.getState() instanceof CompletedState))
               listModel1.addElement(task);
            
         }
      }
      
      if (listModel1.getSize() > 0)
         selectedTask = listModel1.firstElement();
      else
         selectedTask = new Task();
      
      taskDetailFormUpdate();
   }

   /**
    * Create the application.
    */
   public MainForm()
   {
      task_manager = new Manager();
      selectedTask = new Task();
      
      task_manager.openFile();
      
      initialize();
      populateTaskList();
      taskDetailFormUpdate();
   }

   /**
    * Initialize the contents of the frame.
    */
   private void initialize()
   {
      frame = new JFrame();
      frame.setBounds(100, 100, 759, 542);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().setLayout(null);
      frame.setTitle("Task Tracker (Zane Wonsey)");
      
      all_RadioButton = new JRadioButton("All");
      all_RadioButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
      all_RadioButton.addMouseListener(new MouseAdapter()
      {
         @Override
         public void mouseClicked(MouseEvent e)
         {
            System.out.println("All radio");
            populateTaskList();
         }
      });
      all_RadioButton.setSelected(true);
      buttonGroup.add(all_RadioButton);
      all_RadioButton.setBounds(6, 7, 42, 23);
      frame.getContentPane().add(all_RadioButton);
      
      waiting_RadioButton = new JRadioButton("Waiting");
      waiting_RadioButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
      waiting_RadioButton.addMouseListener(new MouseAdapter()
      {
         @Override
         public void mouseClicked(MouseEvent e)
         {
            System.out.println("waiting radio");
            populateTaskList();
         }
      });
      buttonGroup.add(waiting_RadioButton);
      waiting_RadioButton.setBounds(50, 7, 61, 23);
      frame.getContentPane().add(waiting_RadioButton);
      
      inprogress_RadioButton = new JRadioButton("In Progress");
      inprogress_RadioButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
      inprogress_RadioButton.addMouseListener(new MouseAdapter()
      {
         @Override
         public void mouseClicked(MouseEvent e)
         {
            System.out.println("in progress radio");
            populateTaskList();
         }
      });
      buttonGroup.add(inprogress_RadioButton);
      inprogress_RadioButton.setBounds(113, 7, 81, 23);
      frame.getContentPane().add(inprogress_RadioButton);
      
      complete_RadioButton = new JRadioButton("Completed");
      complete_RadioButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
      complete_RadioButton.addMouseListener(new MouseAdapter()
      {
         @Override
         public void mouseClicked(MouseEvent e)
         {
            System.out.println("Completed radio");
            populateTaskList();
         }
      });
      buttonGroup.add(complete_RadioButton);
      complete_RadioButton.setBounds(196, 7, 97, 23);
      frame.getContentPane().add(complete_RadioButton);
      
      JScrollPane scrollPane = new JScrollPane();
      scrollPane.setBounds(16, 37, 265, 369);
      frame.getContentPane().add(scrollPane);
      
      JList<Task> list = new JList<Task>(listModel1);
      list.addListSelectionListener(new ListSelectionListener()
      {
         public void valueChanged(ListSelectionEvent arg0)
         {
            // ########################33
            System.out.println("list selection change");
            selectedTask = list.getSelectedValue();
            taskDetailFormUpdate();
         }
      });
      list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      scrollPane.setViewportView(list);
      
      JLabel lblNewLabel = new JLabel("Task:");
      lblNewLabel.setBounds(299, 11, 46, 14);
      frame.getContentPane().add(lblNewLabel);
      
      JLabel lblNewLabel_1 = new JLabel("Status:");
      lblNewLabel_1.setBounds(299, 36, 46, 14);
      frame.getContentPane().add(lblNewLabel_1);
      
      task_status_label = new JLabel("task_status");
      task_status_label.setBounds(344, 37, 389, 14);
      frame.getContentPane().add(task_status_label);
      
      task_name_label = new JLabel("task_name");
      task_name_label.setBounds(344, 11, 389, 14);
      frame.getContentPane().add(task_name_label);
      
      JButton completeTaskButton = new JButton("Complete Task");
      completeTaskButton.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e)
         {
            System.out.println("Complete Task");
            CompleteTaskCommand ctc = new CompleteTaskCommand((Task) selectedTask);
            ctc.Execute();
            populateTaskList();
         }
      });
      completeTaskButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
      completeTaskButton.setBounds(291, 416, 207, 53);
      frame.getContentPane().add(completeTaskButton);
      
      JLabel lblNewLabel_4 = new JLabel("Notes:");
      lblNewLabel_4.setBounds(299, 97, 46, 14);
      frame.getContentPane().add(lblNewLabel_4);
      
      textArea = new JTextArea();
      textArea.setBounds(291, 118, 442, 287);
      frame.getContentPane().add(textArea);
      
      JButton updateNotesButton = new JButton("Update task notes");
      updateNotesButton.addMouseListener(new MouseAdapter()
      {
         @Override
         public void mouseReleased(MouseEvent e)
         {
            System.out.println("Update task notes");
            ((Task) selectedTask).setTaskNotes(textArea.getText());
            populateTaskList();
         }
      });
      updateNotesButton.setBounds(344, 93, 389, 23);
      frame.getContentPane().add(updateNotesButton);
      
      moveToInProgressButton = new JButton("Move to in progress");
      moveToInProgressButton.addMouseListener(new MouseAdapter()
      {
         @Override
         public void mouseReleased(MouseEvent arg0)
         {
            BeginTaskCommand btc = new BeginTaskCommand((Task) selectedTask);
            btc.Execute();
            populateTaskList();
            System.out.println("Move to in progress");
         }
      });
      moveToInProgressButton.setEnabled(false);
      moveToInProgressButton.setBounds(344, 61, 389, 23);
      frame.getContentPane().add(moveToInProgressButton);
      
      JButton addNewTaskButton = new JButton("+ Add New");
      addNewTaskButton.addMouseListener(new MouseAdapter()
      {
         @Override
         public void mouseClicked(MouseEvent e)
         {
            task_manager.addNewTask(addNewTaskField.getText());
            populateTaskList();
            addNewTaskField.setText("");
            System.out.println("+ Add New");
         }
      });
      addNewTaskButton.setBounds(83, 448, 89, 23);
      frame.getContentPane().add(addNewTaskButton);
      
      JButton removeTaskButton = new JButton("Remove Task");
      removeTaskButton.addMouseListener(new MouseAdapter()
      {
         @Override
         public void mouseClicked(MouseEvent e)
         {
            System.out.println("Remove Task");
            task_manager.removeTask(selectedTask);
            populateTaskList();
         }
      });
      removeTaskButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
      removeTaskButton.setBounds(511, 416, 222, 53);
      frame.getContentPane().add(removeTaskButton);
      
      addNewTaskField = new JTextField();
      addNewTaskField.setBounds(16, 417, 261, 29);
      frame.getContentPane().add(addNewTaskField);
      addNewTaskField.setColumns(10);
      
      JMenuBar menuBar = new JMenuBar();
      frame.setJMenuBar(menuBar);
      
      JMenu mnNewMenu = new JMenu("File");
      menuBar.add(mnNewMenu);
      
      JMenuItem mntmNewMenuItem_3 = new JMenuItem("Save");
      mntmNewMenuItem_3.addMouseListener(new MouseAdapter()
      {
         @Override
         public void mouseReleased(MouseEvent e)
         {
            task_manager.saveFile();
            System.out.println("Save");
         }
      });
      mnNewMenu.add(mntmNewMenuItem_3);
      
      JMenu mnNewMenu_1 = new JMenu("Exit");
      menuBar.add(mnNewMenu_1);
      
      JMenuItem mntmNewMenuItem = new JMenuItem("Exit (Save)");
      mntmNewMenuItem.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseReleased(MouseEvent arg0)
         {
            System.out.println("Exit (Save)");
            task_manager.saveFile();
            System.exit(0);
         }
      });
      mnNewMenu_1.add(mntmNewMenuItem);
      
      JMenuItem mntmNewMenuItem_1 = new JMenuItem("Exit");
      mntmNewMenuItem_1.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseReleased(MouseEvent e)
         {
            System.out.println("Exit");
            System.exit(0);
         }
      });
      mnNewMenu_1.add(mntmNewMenuItem_1);
   }
}
