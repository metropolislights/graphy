package states;

import java.awt.*;
import java.awt.event.*;

import gui.*;
import helpers.*;
import shapes.*;

public class TriangleState extends State
{
  @Override
  public void mouse_pressed(MouseEvent e)
  {
    PolygonShape triangle = new PolygonShape(new Vec2f(e.getX(), e.getY()), 100.0f, Color.BLACK, Color.GREEN, 3);
    MainWindow.get_instance().workspaceController.get_model().get_documents().get(0).get_view().get_context().add_shape(triangle);
  }
}
