import java.awt.Color;
import java.awt.Component;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JFrame;

public class MyMouseAdapter extends MouseAdapter {
	public void mousePressed(MouseEvent e) {
		
		switch (e.getButton()) {
		case 1:		//Left mouse button
			Component c = e.getComponent();
			while (!(c instanceof JFrame)) {
				c = c.getParent();
				if (c == null) {
					return;
				}
			}
			JFrame myFrame = (JFrame) c;
			MyPanel myPanel = (MyPanel) myFrame.getContentPane().getComponent(0);
			Insets myInsets = myFrame.getInsets();
			int x1 = myInsets.left;
			int y1 = myInsets.top;
			e.translatePoint(-x1, -y1);
			int x = e.getX();
			int y = e.getY();
			myPanel.x = x;
			myPanel.y = y;
			myPanel.mouseDownGridX = myPanel.getGridX(x, y);
			myPanel.mouseDownGridY = myPanel.getGridY(x, y);
			myPanel.repaint();
			break;
		case 3:		//Right mouse button
			//Do nothing
			Component r = e.getComponent();
			while (!(r instanceof JFrame)) {
				r = r.getParent();
				if (r == null) {
					return;
				}
			}
			JFrame myFrameR = (JFrame) r;
			MyPanel myPanelR = (MyPanel) myFrameR.getContentPane().getComponent(0);
			Insets myInsetsR = myFrameR.getInsets();
			int x1R = myInsetsR.left;
			int y1R = myInsetsR.top;
			e.translatePoint(-x1R, -y1R);
			int xR = e.getX();
			int yR = e.getY();
			myPanelR.x = xR;
			myPanelR.y = yR;
			myPanelR.mouseDownGridX = myPanelR.getGridX(xR, yR);
			myPanelR.mouseDownGridY = myPanelR.getGridY(xR, yR);
			myPanelR.repaint();
			
			break;
		default:    //Some other button (2 = Middle mouse button, etc.)
			//Do nothing
			break;
		}
	}
	public void mouseReleased(MouseEvent e) {
		switch (e.getButton()) {
		case 1:		//Left mouse button
			Component c = e.getComponent();
			while (!(c instanceof JFrame)) {
				c = c.getParent();
				if (c == null) {
					return;
				}
			}
			JFrame myFrame = (JFrame)c;
			MyPanel myPanel = (MyPanel) myFrame.getContentPane().getComponent(0);  //Can also loop among components to find MyPanel
			Insets myInsets = myFrame.getInsets();
			int x1 = myInsets.left;
			int y1 = myInsets.top;
			e.translatePoint(-x1, -y1);
			int x = e.getX();
			int y = e.getY();
			myPanel.x = x;
			myPanel.y = y;
			
			int gridX = myPanel.getGridX(x, y);
			int gridY = myPanel.getGridY(x, y);
			if ((myPanel.mouseDownGridX == -1) || (myPanel.mouseDownGridY == -1)) {
				//Had pressed outside
				//Do nothing
			} else {
				if ((gridX == -1) || (gridY == -1)) {
					//Is releasing outside
					//Do nothing
				} else {
					if ((myPanel.mouseDownGridX != gridX) || (myPanel.mouseDownGridY != gridY)) {
						//Released the mouse button on a different cell where it was pressed
						//Do nothing
					} else {
						//Released the mouse button on bomb
						for (int i = 0; i <myPanel.numBombs ; i++){


								int rx = i+1;
								int lx = i-1;
								int ty = i+1;
								int by = i-1;
								int nearBombs = 0;
								if( (gridX == myPanel.bombGenX[i]) && (gridY == myPanel.bombGenY[i])){

									myPanel.colorArray[myPanel.bombGenX[i]][myPanel.bombGenY[i]] = Color.blue;

									JFrame gameOver = new JFrame("Game Over =(");
									gameOver.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
									gameOver.setLocation(800, 150);
									gameOver.setSize(400, 400);
									gameOver.setBackground(Color.black);	
									gameOver.setVisible(true);								
								}	
								else{
//									if (rx >=0 && by >=0 && myPanel.minesOnField[rx][by]) nearBombs++;
//									if ( rx >= 0 && myPanel.minesOnField[rx][j]) nearBombs++;
//									if (rx >=0 && ty < myPanel.numBombs && myPanel.minesOnField[lx][ty]) nearBombs++;
//
//									if ( by >= 0 && myPanel.minesOnField[i][by]) nearBombs++;	
//									if ( ty < myPanel.numBombs && myPanel.minesOnField[i][ty]) nearBombs++;
									
									
									

								



							//	click in grid, not bomb
								
							}	
								myPanel.colorArray[myPanel.bombGenX[i]][myPanel.bombGenY[i]] = Color.blue;
								myPanel.repaint();
						}    //put code here


					}
					//put code here
					
				}
			}
			myPanel.repaint();
			break;
		case 3:		//Right mouse button
			//Do nothing
			Component r = e.getComponent();
			while (!(r instanceof JFrame)) {
				r = r.getParent();
				if (r == null) {
					return;
				}
			}
			JFrame myFrameR = (JFrame) r;
			MyPanel myPanelR = (MyPanel) myFrameR.getContentPane().getComponent(0);
			Insets myInsetsR = myFrameR.getInsets();
			int x1R = myInsetsR.left;
			int y1R = myInsetsR.top;
			e.translatePoint(-x1R, -y1R);
			int xR = e.getX();
			int yR = e.getY();
			myPanelR.x = xR;
			myPanelR.y = yR;
			myPanelR.mouseDownGridX = myPanelR.getGridX(xR, yR);
			myPanelR.mouseDownGridY = myPanelR.getGridY(xR, yR);
			myPanelR.repaint();
			
			int gridXR = myPanelR.getGridX(xR, yR);
			int gridYR = myPanelR.getGridY(xR, yR);
			if ((myPanelR.mouseDownGridX == -1) || (myPanelR.mouseDownGridY == -1)) {
				//Had pressed outside
				//Do nothing
			} else {
				if ((gridXR == -1) || (gridYR == -1)) {
					//Is releasing outside
					//Do nothing
				} else {
					if ((myPanelR.mouseDownGridX != gridXR) || (myPanelR.mouseDownGridY != gridYR)) {
						//Released the mouse button on a different cell where it was pressed
						//Do nothing
					} else {
						//Released the mouse button on bomb
						for (int i = 0; i <myPanelR.numBombs ; i++){
							if( (gridXR == myPanelR.bombGenX[i]) && (gridYR == myPanelR.bombGenY[i])){
								
							}
							//	click in grid, not bomb
							
							else{	
								
							}	
							
							myPanelR.colorArray[gridXR][gridYR] = Color.red;
							myPanelR.repaint();
						}//put code here


					}
					//put code here
					
				}
			}
			myPanelR.repaint();
			break;
		default:    //Some other button (2 = Middle mouse button, etc.)
			//Do nothing
			break;
		}
	}
}