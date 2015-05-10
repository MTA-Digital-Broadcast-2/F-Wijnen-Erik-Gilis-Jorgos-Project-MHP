/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;


import javax.tv.xlet.Xlet;
import javax.tv.xlet.XletContext;
import org.havi.ui.*;
import java.awt.*;


/**
 * 
 * @author student
 */
public class Images extends HComponent {

    private Image Bmap;
    private MediaTracker mtrack;
    
    public Images (String paard, int x, int y){
        Bmap=this.getToolkit().getImage("paard.jpg");
        mtrack=new MediaTracker(this);
        mtrack.addImage(Bmap, 0);
        try{
            mtrack.waitForAll();
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
    this.setBounds(x, y, Bmap.getWidth(null), Bmap.getWidth(null));
    }
    public void paint(Graphics g){
        g.drawImage(Bmap, 0, 0, null);
    }

}
