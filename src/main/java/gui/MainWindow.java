package gui;

import java.awt.*;
import javax.swing.*;

import gui.window.listener.GraphyWindowListener;
import models.*;
import views.*;
import controllers.*;

public class MainWindow extends JFrame
{
  private static MainWindow instance = null;
  public static WorkspaceView centerPanel = new WorkspaceView();
  public WorkspaceModel workspaceModel = new WorkspaceModel();
  public WorkspaceController workspaceController = new WorkspaceController(workspaceModel, centerPanel);

  public static MainWindow get_instance()
  {
    if (instance == null) { instance = new MainWindow(); }
    return instance;
  }

  private MainWindow()
  {
    super();

    try
    {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
      SwingUtilities.updateComponentTreeUI(this);
    }
    catch (Exception e) { e.printStackTrace(); }

    this.setTitle("Graphy");
    this.setSize(1000, 600);
    this.setLocationRelativeTo(null);
    this.setJMenuBar(new MenuBar());
    this.add(new TopPanel(), BorderLayout.NORTH);
    this.add(new RightPanel(), BorderLayout.EAST);
    this.add(new BottomPanel(800, 600), BorderLayout.SOUTH);
    this.add(new LeftPanel(), BorderLayout.WEST);
    this.add(this.centerPanel, BorderLayout.CENTER);
    this.setVisible(true);
    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    ImageIcon img = new ImageIcon("images/Logo.png");
    this.setIconImage(img.getImage());

    addWindowListener(new GraphyWindowListener());
  }
}
