/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TimetableGA;

import java.awt.Component;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;

/**
 *
 * @author Anand
 */
public class GUIUtil {
    	public static void toCenter(Component comp) {
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		Rectangle rec = ge.getDefaultScreenDevice().getDefaultConfiguration().getBounds();
		comp.setLocation(((int) rec.getWidth() - comp.getWidth()) / 2, ((int) rec.getHeight() - comp.getHeight()) / 2);
	}
    
}
