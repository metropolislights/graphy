package shapes;

import java.awt.*;
import java.awt.geom.*;

import helpers.*;

public class StarShape extends AbstractShape
{
  public StarShape(Vec2f position, float size)
  {
    super(position, size);
    this.construct_shape();
  }

  public StarShape(Vec2f position, float size, Color stroke, Color fill)
  {
    super(position, size, stroke, fill);
    this.construct_shape();
  }

  public void construct_shape()
  {
    int sides = 10;
    float step = 2.0f * (float)Math.PI / (float)sides;
    float radius = this.get_size() * 0.5f;

    ((GeneralPath)this.get_shape()).moveTo(radius, 0.0f);
    for (int i = 1; i < sides; i++)
    {
      if (i % 2 == 0)
      {
        ((GeneralPath)this.get_shape()).lineTo(radius * Math.cos(i * step), radius * Math.sin(i * step));
      }
      else
      {
        ((GeneralPath)this.get_shape()).lineTo((radius / 2.0f) * Math.cos(i * step), (radius / 2.0f) * Math.sin(i * step));
      }
    }
    ((GeneralPath)this.get_shape()).closePath();
  }
}
