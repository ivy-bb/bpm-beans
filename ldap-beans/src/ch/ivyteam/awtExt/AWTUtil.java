/*
 * Copyright (C) 2016 AXON IVY AG
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package ch.ivyteam.awtExt;

import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

public class AWTUtil 
{
  /**
   * Adds a component to a container and sets the layout correctly.
   * 
   * @param container the container to add the component
   * @param component the component to add
   * @param gridX x position in grid
   * @param gridY y position in grid
   * @param gridW the number of cells in the row for the component 
   * @param gridH the number of cells in the column for the component
   * @param fill how the component fills up empty space or not
   * @param anchor where to align the component
   * @param wX the weight in x 
   * @param wY the weight in y
   * @param top inset on top
   * @param left inset on left
   * @param bottom inset on bottom
   * @param right inset on right
   */
  // po 24.03.1997: Taken from "Nutshell" book
  public static void constrain(Container container, Component component,
    int gridX, int gridY, int gridW, int gridH,
    int fill, int anchor, double wX, double wY,
    int top, int left, int bottom, int right)
  {
    GridBagConstraints c = new GridBagConstraints();
    c.gridx = gridX;
    c.gridy = gridY;
    c.gridwidth = gridW;
    c.gridheight = gridH;
    c.fill = fill;
    c.anchor = anchor;
    c.weightx = wX;
    c.weighty = wY;
    if (top+bottom+right+left > 0)
    {
      c.insets = new Insets(top, left, bottom, right);
    }

    ((GridBagLayout)container.getLayout()).setConstraints(component,c);
    container.add(component);
  }

}
