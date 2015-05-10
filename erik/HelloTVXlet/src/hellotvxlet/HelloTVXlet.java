package hellotvxlet;

import java.awt.event.ActionEvent;
import javax.tv.xlet.*;
import org.dvb.event.UserEvent;
import org.havi.ui.*;
import org.dvb.ui.*;
import java.awt.event.*;
import org.havi.ui.event.*;
import hellotvxlet.Images;
import org.dvb.event.*;
import java.util.Timer;



public class HelloTVXlet implements Xlet, HActionListener, UserEventListener
{
    
    private XletContext actueleXletContext;
    private HScene scene;
    private boolean debug =  true;

    private HTextButton knop1,knop2;
    private HStaticText tekstLabel, tekstLabel2;
    
    public Images img = new Images("paard", 100, 325);
    public MijnTimer objMijnTimer=new MijnTimer();
            Timer timer = new Timer();
            
            
  
    public HelloTVXlet() {

    }

    public void initXlet(XletContext context) throws XletStateChangeException {
        if(debug) System.out.println("Xlet Initialiseren");
        this.actueleXletContext = context;
        
        HSceneTemplate sceneTemplate = new HSceneTemplate();
        
        sceneTemplate.setPreference(HSceneTemplate.SCENE_SCREEN_DIMENSION, 
                new HScreenDimension(1.0f, 1.0f), HSceneTemplate.REQUIRED);
        sceneTemplate.setPreference(HSceneTemplate.SCENE_SCREEN_LOCATION, 
                new HScreenPoint(0.0f, 0.0f), HSceneTemplate.REQUIRED);
        
        scene = HSceneFactory.getInstance().getBestScene(sceneTemplate);
        
        knop1 = new HTextButton("Start");
        knop1.setLocation(50, 50);
        knop1.setSize(100,100);
        knop1.setBackground(new DVBColor(0,0,0,179));
        knop1.setBackgroundMode(HVisible.BACKGROUND_FILL);
        
        knop2 = new HTextButton("Stop");
        knop2.setLocation(450,400);
        knop2.setSize(100,100);
        knop2.setBackground(new DVBColor(0,0,0,179));
        knop2.setBackgroundMode(HVisible.BACKGROUND_FILL);
        
        knop1.setFocusTraversal(null, knop2, null, null);
        knop1.setActionCommand("Knop1_actioned");
        knop1.addHActionListener(this);
        knop2.setFocusTraversal(knop1, null, null, null);
        knop2.setActionCommand("Knop2_Actioned");
        knop2.addHActionListener(this);
        
        tekstLabel = new HStaticText("Random");
        tekstLabel2 = new HStaticText("Vul in hier");
        
        tekstLabel.setLocation(125,175);
        tekstLabel.setSize(400,50);
        tekstLabel.setBackground(new DVBColor(50,255,225,179));
        tekstLabel.setBackgroundMode(HVisible.BACKGROUND_FILL);
        
        tekstLabel2.setLocation(125,250);
        tekstLabel2.setSize(400,50);
        tekstLabel2.setBackground(new DVBColor(255,50,225,179));
        tekstLabel2.setBackgroundMode(HVisible.BACKGROUND_FILL);
        
        
        
        scene.add(tekstLabel);
        scene.add(tekstLabel2);
        scene.add(knop2);
        scene.add(knop1);
       
        knop1.requestFocus();
        
        
        
        
    
   
     
    }


    public void startXlet() throws XletStateChangeException{
        if(debug) System.out.println("Xlet Starten");
         scene.validate();
         scene.setVisible(true);
         
         //gebruiksinvoer
         EventManager manager = EventManager.getInstance();
         UserEventRepository repository = new UserEventRepository("Voorbeeld");
         
         
         repository.addKey(org.havi.ui.event.HRcEvent.VK_A);
         repository.addKey(org.havi.ui.event.HRcEvent.VK_B);
         repository.addKey(org.havi.ui.event.HRcEvent.VK_C);
         repository.addKey(org.havi.ui.event.HRcEvent.VK_D);
         
         manager.addUserEventListener( this, repository);
         
       
       
       
         
    }

    public void pauseXlet() {
     
    }

    public void destroyXlet(boolean unconditional) throws XletStateChangeException{
    
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        scene.add(img);
        timer.scheduleAtFixedRate(objMijnTimer, 0, 5000);
        
        
        
    }

    public void userEventReceived(UserEvent e) {
        if(e.getType()== KeyEvent.KEY_PRESSED){
            System.out.println("ik wil poepen");
            switch( e.getCode()){
                
                case HRcEvent.VK_A:
                    System.out.println("A gepressed");
                    tekstLabel.setTextContent("bla", 0);
                    break;
                case HRcEvent.VK_B:
                    System.out.println("B gepressed");
                    break;
                case HRcEvent.VK_C:
              
                    break;
                case HRcEvent.VK_D:
              
                    break;
                case HRcEvent.VK_E:
              
                    break;
                case HRcEvent.VK_F:
              
                    break;
                case HRcEvent.VK_G:
              
                    break;
                case HRcEvent.VK_H:
              
                    break;
                case HRcEvent.VK_I:
              
                    break;
                    
              
                         
               
            }
        }
       
        
  }
     
    }

    



