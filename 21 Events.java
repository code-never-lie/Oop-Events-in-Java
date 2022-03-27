Events
     - Major topic of windows Programming
     - All Hanpening are events in windows


What is Event in java?
Events
– Objects that describe what happened

Event sources 
– The generator of an event object, deciphers it, and processes the user’s interaction

Event handlers
– A method that receives an event
.......................................................................................
How To Apply events in java?

Step 1 : Determine what type of listener is of interest
   11 Standard Awt types
ActionListener, AdjustmentListener, ComponentListener, ContainerListener, FocusListener, ItemListener, KeyListener, MouseListener, MouseMotionListener, TextListener, WindowListener

Step 2: Define a class of that type

-Implement interface (ActionListener, KeyListener, MouseListener, etc.)
- Extend class (KeyAdapter, MouseAdapter, etc.)

Step 3: Register an object of your listener class with the window

button.addXxxListener(new MyListenerClass());

......................................................................
ActionListener

ActionEvent

Source
- Buttons
 Generates action events when the button is pressed.
- MenuItem
  Generates action events when a menu item is selected; generates item
  events when a checkable menu item is selected or deselected.
- List 
   Generates action events when an item is double-clicked; generates item
   events when an item is selected or deselected.
  

actionPerformed(ActionEvent e)
........................................................................
Example 1 : Display name of Buttons in Lable

import java.awt.*;
import java.awt.event.*;
class ButtonCheck  implements ActionListener{
ButtonCheck () { 
	f= new Frame("My Frame");
        b1= new Button("Save");
        b2= new Button("close");
        b1.addActionListener(this);
        b2.addActionListener(this);
        l= new Label("Just For FUn");
        f.setSize(400,400);
        f.setLayout(new FlowLayout());
        f.add(b1); f.add(b2);
        f.add(l);
        f.setVisible(true);	
}
public void actionPerformed(ActionEvent e) {
     String name=e.getActionCommand();
     l.setText (name);
}
Frame f;
Button b1,b2;
Label l;

}
class Test {
public static void main (String o[]){
 ButtonCheck  mc = new ButtonCheck();
}
}
...................................................................................
Example 2: (Again)  Same example with Separate Handler Class

import java.awt.*;
import java.awt.event.*;
class ButtonCheck{
ButtonCheck () { 
	f= new Frame("My Frame");
        b1= new Button("Save");
        b2= new Button("close");
        l= new Label("Just For FUn");
        b1.addActionListener(new ButtonHandler(l));
        b2.addActionListener(new ButtonHandler(l));
                f.setSize(400,400);
        f.setLayout(new FlowLayout());
        f.add(b1); f.add(b2);
        f.add(l);
        f.setVisible(true);	
}

Frame f;
Button b1,b2;
Label l;
}
class ButtonHandler implements ActionListener{
Label l;
ButtonHandler(Label l){ this.l=l;}
public void actionPerformed(ActionEvent e) {
     String name=e.getActionCommand();
     l.setText (name);
}
}
class Test {
public static void main (String o[]){
 ButtonCheck  mc = new ButtonCheck();
}
}
...................................................................................
Example 3 : Two Buttons and One Text Box

import java.awt.*;
import java.awt.event.*;
class MyGui extends Frame implements ActionListener{
Button b1,b2;
TextField tf;
public void m() {
  setLayout(new FlowLayout()); 
  setSize(300,300);
   b1= new Button("1");
   add(b1);
   b2= new Button("2");
   add(b2);
   tf=new TextField(50);
   add(tf);
   b1.addActionListener(this);
   b2.addActionListener(this);
   setVisible(true);
}
public void actionPerformed(ActionEvent e ) {
   String name=e.getActionCommand();
   if(name.equals("1"))
      tf.setText("Buttion 1 pressed");
    else
      tf.setText("Buttion 2 pressed");
}
}
class Test {
public static void main (String a[]){
MyGui g= new MyGui();
g.m();

}
}

.........................................................................................
Example 4 Add and mutiply two numbers given by user

import java.awt.*;
import java.awt.event.*;
class ButtonCheck  implements ActionListener{
ButtonCheck () { 
	f= new Frame("My Frame");
        t1=new TextField("Enter Value of AHere");
        t2=new TextField("Enter Value  B Here");
        t3=new TextField("See ans here");
        b1= new Button("add");
        b2= new Button("mul");
        b1.addActionListener(this);
        b2.addActionListener(this);
        f.setSize(400,400);
        f.setLayout(new FlowLayout());
        f.add(t1); f.add(t2);f.add(t3);
        f.add(b1); f.add(b2);
        f.setVisible(true);	
}
public void actionPerformed(ActionEvent e) {
     String name=e.getActionCommand();
     int a,b,c;
     a= Integer.parseInt(t1.getText());
     b= Integer.parseInt(t2.getText());
     if ( name.equals("add")){
          c=a+b;          
        
      } else 
   		c=a*b;
     String s= ""+c;
     t3.setText(s);       
         
}
Frame f;
Button b1,b2;
TextField t1,t2,t3;

}
class Test {
public static void main (String o[]){
 ButtonCheck  mc = new ButtonCheck();
 

}
}
........................................................................
Example 5  ActionListener on Multiple Buttons


import java.awt.*;
import java.awt.event.*;
class ButtonCheck  implements ActionListener{
ButtonCheck () { 
	f= new Frame("My Frame");
        f.setLength(300,300);
        a= new Button[13];
        for (int i=0;i<10;i++)
          a[i]= new Button(""+i);

        a[10]= new Button("+");
        a[11]= new Button("*");
        a[12]= new Button("=");
        for (int i=0;i<a.length;i++)
	        a[i].addActionListener(this);
        f.setLayout(new FlowLayout());
        t=new TextField(30);
        f.add(t);
        for (int i=0;i<a.length;i++)
		f.add(a[i]);
        
        f.setVisible(true);	
}
public void actionPerformed(ActionEvent e) {
     String name=e.getActionCommand();
     st= st+name;
     t.setText(st);     

         
}
Frame f;
Button a[];
TextField t;
String st="";
}
class Test {
public static void main (String o[]){
 ButtonCheck  mc = new ButtonCheck();
}
}
...............................................................................
Example 6  Add and mutiply two numbers given by user using Menu and Buttons

import java.awt.*;
import java.awt.event.*;
class MenuCheck  implements ActionListener{
MenuCheck () { 
	f= new Frame("My Frame");
        t1=new TextField("Enter Value of AHere");
        t2=new TextField("Enter Value  B Here");
        t3=new TextField("See ans here");
        b1= new Button("add");
        b2= new Button("mul");
        mb= new MenuBar();
        f.setMenuBar(mb);
        m=new Menu("Functions");
        mb.add(m);
        add=new MenuItem("add");
        mul=new MenuItem("mul");
        m.add(add);m.add(mul);
        b1.addActionListener(this);
        b2.addActionListener(this);
        add.addActionListener(this);
        mul.addActionListener(this);
        f.setSize(400,400);
        f.setLayout(new FlowLayout());
        f.add(t1); f.add(t2);f.add(t3);
        f.add(b1); f.add(b2);
        f.setVisible(true);	
}
public void actionPerformed(ActionEvent e) {
     String name=e.getActionCommand();
     int a,b,c=0;
     a= Integer.parseInt(t1.getText());
     b= Integer.parseInt(t2.getText());
     if ( name.equals("add")){
          c=a+b;          
        
      } else if ( name.equals("mul"))
   		c=a*b;
     String s= ""+c;
     t3.setText(s);       
         
}
Frame f;
Button b1,b2;
TextField t1,t2,t3;
MenuBar mb;
Menu m;
MenuItem add;
MenuItem mul;
}
class Test {
public static void main (String o[]){
 MenuCheck  mc = new MenuCheck();
 

}
}

...........................................................................................
MouseListener
Applies to basic mouse events

mouseEntered(MouseEvent event)
mouseExited(MouseEvent event)
mousePressed(MouseEvent event)
mouseReleased(MouseEvent event)
mouseClicked(MouseEvent event)  -- Release without drag

- Applies on release if no movement since press
..............................................................................
MouseMotionListener

Handles mouse movement

mouseMoved(MouseEvent event)
mouseDragged(MouseEvent event)

.............................................................................
MouseListener and MouseMotionListener share event types
Location of clicks
-event.getX() and event.getY()

Double clicks
-Determined by OS, not by programmer
-Call event.getClickCount()

Distinguishing mouse buttons
- Call event.getModifiers() and compare to MouseEvent.Button2_MASK for a middle click and - MouseEvent.Button3_MASK for right click.
- Can also trap Shift-click, Alt-click, etc.

........................................................................................................
Example 7  Display Mouse Coordinates, Mouse Move and Mouse Drag (Mouse Event)

import java.awt.*;
import java.awt.event.*;
class MouseCheck implements MouseMotionListener {
 MouseCheck () { 
	f= new Frame("My Frame");
        f.addMouseMotionListener(this);
        f.setSize(400,400);
        l= new Label("See         Mouse     Drag         Here");
        f.setLayout(new FlowLayout());
        f.add(l);
        f.setVisible(true);	
 }

 public  void mouseDragged(MouseEvent e){
	x=e.getX(); y=e.getY();
	l.setText("Mosue Dragged  x=" +x + " y= " + y);
 }
 public  void mouseMoved (MouseEvent e){ 
	x=e.getX(); y=e.getY();
	System.out.println("Mosue MOved  x=" +x + " y= " + y);
 }
Frame f;
Label l;
int x,y;
}
class Test {
public static void main (String o[]){
 MouseCheck  mc = new MouseCheck();

}
}
............................................................................
Example 8  Display popup menu using MouseListener

import java.awt.*;
import java.awt.event.*;
class MyFrame implements MouseListener{
 MyFrame() {
  f = new Frame("UCP");
  pop = new PopupMenu("Popup");
  MenuItem file= new MenuItem("File");
  MenuItem edit= new MenuItem("Edit");
  MenuItem help= new MenuItem("Help");
  pop.add(file);pop.add(edit);
  pop.add(help);
  f.addMouseListener(this);
  f.add(pop);
  f.setSize(300,300);
  f.setVisible(true);
 
 }
public void mouseEntered(MouseEvent event){}
public void mouseExited(MouseEvent event){}
public void mousePressed(MouseEvent event){}
public void mouseReleased(MouseEvent event){}
public void mouseClicked(MouseEvent event) {
 pop.show(f,event.getX(),event.getY());
} 

Frame f;
PopupMenu pop;
}
class Test{
public static void main(String a[]){
    MyFrame frame= new MyFrame();
  
}
}
...........................................................................
Example 9 : Draw blue circles on Frame  
			(Method 1  Separate Listener Class)
Solution
-Call event.getSource to obtain a reference to window or GUI component from which event originated
-Cast result to type of interest
-Call methods on that reference

import java.awt.*;
import java.awt.event.*;
class CircleDrawer1 extends Frame {
CircleDrawer1() {
    setLayout(new FlowLayout());
    setForeground(Color.blue);
    addMouseListener(new CircleListener());
    setSize(500,500);
    setVisible(true);
  }
}

class CircleListener extends MouseAdapter {
  private int radius = 25;

public void mousePressed(MouseEvent event) {
    Frame app = (Frame)event.getSource();
    Graphics g = app.getGraphics();
    g.fillOval(event.getX()-radius,
               event.getY()-radius,
               2*radius,
               2*radius);
  }
}
class Test {
public static void main (String o[]){
 CircleDrawer1  cd = new CircleDrawer1();
System.out.println("End of Program");
}
}
...........................................................................................
Example 10 (again): Draw blue circles on Frame (with MouseListener Interface)
					(Method 2 implementing Listener Interface)
import java.awt.*;
import java.awt.event.*;
class CircleDrawer1 extends Frame implements MouseListener{
 private int radius = 25;
 CircleDrawer1() {
    setLayout(new FlowLayout());
    setForeground(Color.blue);
    addMouseListener(this);
    setSize(500,500);
    setVisible(true);
  }
  public void mouseEntered(MouseEvent event) {}
  public void mouseExited(MouseEvent event) {}
  public void mouseReleased(MouseEvent event) {}
  public void mouseClicked(MouseEvent event) {}

 public void mousePressed(MouseEvent event) {
    Frame app = (Frame)event.getSource();
    Graphics g = app.getGraphics();
    g.fillOval(event.getX()-radius,
               event.getY()-radius,
               2*radius,
               2*radius);
  }
}
class Test {
 public static void main (String o[]){
  CircleDrawer1  cd = new CircleDrawer1();
  System.out.println("End of Program");
}
}
...................................................................................
Example 11 (again): Draw blue circles on Frame (with MouseListener Interface)
         	(Method 3 Named Inner Class)
import java.awt.*;
import java.awt.event.*;
class CircleDrawer1 extends Frame {
CircleDrawer1() {
    setLayout(new FlowLayout());
    setForeground(Color.blue);
    addMouseListener(new CircleListener());
    setSize(500,500);
    setVisible(true);
  }

private class CircleListener extends MouseAdapter {
     private int radius = 25;

   public void mousePressed(MouseEvent event) {
     Frame app = (Frame)event.getSource();
     Graphics g = app.getGraphics();
     g.fillOval(event.getX()-radius,
               event.getY()-radius,
               2*radius,
               2*radius);
  }
}
}
class Test {
public static void main (String o[]){
 CircleDrawer1  cd = new CircleDrawer1();
System.out.println("End of Program");
}
}
................................................................................
Example 12 (again): Draw blue circles on Frame (with MouseListener Interface)
         	(Method 4 Anonymous Inner Classes)

import java.awt.*;
import java.awt.event.*;
class CircleDrawer1 extends Frame {
CircleDrawer1() {
    setLayout(new FlowLayout());
    setForeground(Color.blue);
    addMouseListener(new MouseAdapter() {
         private int radius = 25;
         public void mousePressed(MouseEvent event) {
           Graphics g = getGraphics();
           g.fillOval(event.getX()-radius,
                      event.getY()-radius,
                      2*radius,
                      2*radius);
         }
      });//end of addMouseListener
      setSize(500,500);
      setVisible(true);
  }
}
class Test {
public static void main (String o[]){
 CircleDrawer1  cd = new CircleDrawer1();
System.out.println("End of Program");
}
}
...............................................................................
Event Handling Strategies: Pros and Cons

1- Separate Listener
Advantages
-Can extend adapter and thus ignore unused methods 
-Separate class easier to manage

Disadvantage
- Need extra step to call methods in main window

2- Main window that implements interface
 
Advantage
- No extra steps needed to call methods in main window

Disadvantage
- Must implement methods you might not care about

3- Named inner class

Advantages
-Can extend adapter and thus ignore unused methods
- No extra steps needed to call methods in main window

Disadvantage
-A bit harder to understand

4-Anonymous inner class

Advantages
- Same as named inner classes
- Even shorter

Disadvantage
- Much harder to understand
.........................................................................
Example 13 : Free hand White Board 

import java.awt.*;
import java.awt.event.*;

class SimpleWhiteboard extends Frame {
  protected int lastX=0, lastY=0;

 SimpleWhiteboard () {
    setBackground(Color.white);
    setForeground(Color.blue);
    addMouseListener(new PositionRecorder());
    addMouseMotionListener(new LineDrawer());
    setSize(500,500);
    setVisible(true);
  }

  protected void record(int x, int y) {
    lastX = x; lastY = y;
  }
 private class PositionRecorder extends MouseAdapter {
    public void mouseEntered(MouseEvent event) {
      requestFocus(); // Plan ahead for typing
      record(event.getX(), event.getY());
    }

    public void mousePressed(MouseEvent event) {
      record(event.getX(), event.getY());
    }
  }
 private class LineDrawer extends MouseMotionAdapter {
    public void mouseDragged(MouseEvent event) {
      int x = event.getX();
      int y = event.getY();
      Graphics g = getGraphics();
      g.drawLine(lastX, lastY, x, y);
      record(x, y);
    }
  }
}

.............................................................................
The KeyListener Interface

This interface defines three methods. 
The keyPressed(KeyEvent e ) and keyReleased(KeyEvent e ) methods are invoked when a key is pressed and released, respectively. 
The keyTyped(KeyEvent e ) method is invoked when a character has been entered.

For example, if a user presses and releases the A key, three events are generated in sequence:
keyPressed( ) keyTyped( ) keyReleased( ) 
........................................................................................................
Example 14  Check what character typed in a textField

import java.awt.*;
import java.awt.event.*;
class TextFieldCheck  implements KeyListener{
TextFieldCheck () { 
	f= new Frame("My Frame");
        tf= new TextField(20);

        tf.addKeyListener(this);
        l= new Label("Just For FUn");
        f.setSize(400,400);
        f.setLayout(new FlowLayout());
        f.add(tf); 
        f.add(l);
        f.setVisible(true);	
}
public void keyPressed(KeyEvent e) {

}
public void keyTyped(KeyEvent e) {
l.setText("key typed = " + e.getKeyChar());

}
public void keyReleased(KeyEvent e) {

}

Frame f;
TextField tf
Label l;

}
class Test {
public static void main (String o[]){
 TextFieldCheck  mc = new TextFieldCheck();
}
}
...................................................................................................................
Example 15  Write a program which has a text field on the frame. The user inputs the characters on it. 
If the input char is vowel then it tells that the input char is vowel otherwise show character is Not Vowel. 

import java.awt.*;
import java.awt.event.*;
class TextFieldCheck  implements KeyListener{
TextFieldCheck () { 
	f= new Frame("My Frame");
        tf= new TextField(20);
        ta=new TextArea();
        tf.addKeyListener(this);
        l= new Label("Just For FUn");
        f.setSize(400,400);
        f.setLayout(new FlowLayout());
        f.add(tf); 
        f.add(l);
        f.add(ta);
        f.setVisible(true);	
}
public void keyPressed(KeyEvent e) {

}
public void keyTyped(KeyEvent e) {
String st=""+e.getKeyChar();
l.setText("key typed = " + e.getKeyChar());
String d=ta.getText();
if (st.matches("[aeiou]"))
    ta.setText(d+" Vowel \n");
else
    ta.setText(d+"Not  Vowel \n");
}
public void keyReleased(KeyEvent e) {

}

Frame f;
TextField tf;
Label l;
TextArea ta;

}
class Test {
public static void main (String o[]){
 TextFieldCheck  mc = new TextFieldCheck();
}
}
............................................................................................


Example 16 Free Hand White Board with key Events
                  (WhiteBoard class extends SimpleWhiteBoard)
import java.awt.*;
import java.awt.event.*;

class SimpleWhiteboard extends Frame {
  protected int lastX=0, lastY=0;

 SimpleWhiteboard () {
    setBackground(Color.white);
    setForeground(Color.blue);
    addMouseListener(new PositionRecorder());
    addMouseMotionListener(new LineDrawer());
    setSize(500,500);
    setVisible(true);
  }

  protected void record(int x, int y) {
    lastX = x; lastY = y;
  }
 private class PositionRecorder extends MouseAdapter {
    public void mouseEntered(MouseEvent event) {
      requestFocus(); // Plan ahead for typing
      record(event.getX(), event.getY());
    }

    public void mousePressed(MouseEvent event) {
      record(event.getX(), event.getY());
    }
  }
 private class LineDrawer extends MouseMotionAdapter {
    public void mouseDragged(MouseEvent event) {
      int x = event.getX();
      int y = event.getY();
      Graphics g = getGraphics();
      g.drawLine(lastX, lastY, x, y);
      record(x, y);
    }
  }
}
class Whiteboard extends SimpleWhiteboard {
  protected FontMetrics fm;

  Whiteboard() {
    super();
    Font font = new Font("Serif", Font.BOLD, 20);
    setFont(font);
    fm = getFontMetrics(font);
    addKeyListener(new CharDrawer());
  }
private class CharDrawer extends KeyAdapter {
    // When user types a printable character,
    // draw it and shift position rightwards.
    
    public void keyTyped(KeyEvent event) {
      String s = String.valueOf(event.getKeyChar());
      getGraphics().drawString(s, lastX, lastY);
      record(lastX + fm.stringWidth(s), lastY);
    }
  }
}

class Test {
public static void main (String o[]){
 Whiteboard  wb = new Whiteboard();
}
}
........................................................................
ItemListener

itemStateChanged(ItemEvent)

ItemEvent

-CheckBox
   Generates item events when the check box is selected or deselected.
- RadioButton
   Generates item events when the check box is selected 
- Choice
  Generates item events when the choice is changed.
- List 
   Generates action events when an item is double-clicked; generates item
   events when an item is selected or deselected.
- MenuItem 
     generates item events when a checkable menu item is selected or deselected.
.......................................................................
Example17  Listening Choice Box through ItemListener

import java.awt.*;
import java.awt.event.*;
class MyFrame implements ItemListener{
 MyFrame() {
  Frame f = new Frame("UCP");
  f.setLayout(new FlowLayout());
  Label l = new Label("Select Course");  
  Choice c = new Choice();
  msg=new Label("                ");
  c.addItem("Data Structures");
  c.addItem("Analysis of Algorithms");
  c.addItem("Database Systems");
  c.addItem("Computer Architecture");
  c.addItemListener(this);
  f.add(l);f.add(c);f.add(msg);
  f.setSize(1000,100);
  f.setVisible(true);
 }
public void itemStateChanged(ItemEvent e){
  msg.setText("you Choose = " + e.getItem());
}
Label msg;
}
class Test{
public static void main(String a[]){
    MyFrame frame= new MyFrame();
  
}
}
...................................................................
Example 18  Listening Checkbox through ItemListener

import java.awt.*;
import java.awt.event.*;
class MyFrame implements ItemListener{
 MyFrame() {
  Frame f = new Frame("UCP");
  f.setLayout(new FlowLayout());
  Label l = new Label("Check Menu");    
  Checkbox cb1= new Checkbox("ZingerBurger", true);
  Checkbox cb2= new Checkbox("MightyZingerBurger", true);
  Checkbox cb3= new Checkbox("Pepsi", false);
  Checkbox cb4= new Checkbox("FrenchFries", false);
  Checkbox cb5= new Checkbox("coffee", false);
  cb1.addItemListener(this);
  cb2.addItemListener(this);
  cb3.addItemListener(this);
  cb4.addItemListener(this);
  cb5.addItemListener(this);
  f.add(l);f.add(cb1);f.add(cb2);f.add(cb3);
  f.add(cb4);f.add(cb5);
  f.setSize(400,400);
  f.setVisible(true);
 }
public void itemStateChanged(ItemEvent e){
  String state="deselected";
  if (e.getStateChange() == ItemEvent.SELECTED)
      state = "selected";
 System.out.println(e.getItem() + " " + state);
  
}
}
class Test{
public static void main(String a[]){
    MyFrame frame= new MyFrame();
  
}
}
...............................................................................
Example 19  Listening RadioButton(CheckboxGroup) through ItemListener

import java.awt.*;
import java.awt.event.*;
class MyFrame implements ItemListener{
 MyFrame() {
  Frame f = new Frame("UCP");
  f.setLayout(new FlowLayout());
  Label l = new Label("Check Menu"); 
  CheckboxGroup cbg=new CheckboxGroup();   
  Checkbox cb1= new Checkbox("ZingerBurger",cbg, true);
  Checkbox cb2= new Checkbox("MightyZingerBurger",cbg, false);
  Checkbox cb3= new Checkbox("Pepsi",cbg, false);
  Checkbox cb4= new Checkbox("FrenchFries",cbg, false);
  Checkbox cb5= new Checkbox("coffee",cbg, false);
  cb1.addItemListener(this);
  cb2.addItemListener(this);
  cb3.addItemListener(this);
  cb4.addItemListener(this);
  cb5.addItemListener(this);
  f.add(l);f.add(cb1);f.add(cb2);f.add(cb3);
  f.add(cb4);f.add(cb5);
  f.setSize(400,400);
  f.setVisible(true);
 }
public void itemStateChanged(ItemEvent e){
  String state="deselected";
  if (e.getStateChange() == ItemEvent.SELECTED)
      state = "selected";
 System.out.println(e.getItem() + " " + state);
  
}
}
class Test{
public static void main(String a[]){
    MyFrame frame= new MyFrame();
  
}
}
.............................................................................
Example 20  Listening List through ItemListener

import java.awt.*;
import java.awt.event.*;
class MyFrame implements ItemListener{
 MyFrame() {
  Frame f = new Frame("UCP");
  f.setLayout(new FlowLayout());
  Label l = new Label("Select Courses");
  List list= new List(4,true);
  list.add("Data Structures");
  list.add("Analysis of Algorithms");
  list.add("Database Systems");
  list.add("Computer Architecture");
  list.addItemListener(this);
  f.add(l);f.add(list);
  f.setSize(600,600);
  f.setVisible(true);
 }
public void itemStateChanged(ItemEvent e){
  String state="deselected";
  if (e.getStateChange() == ItemEvent.SELECTED)
      state = "selected";
 System.out.println(e.getItem() + " " + state);
  
}
}
class Test{
public static void main(String a[]){
    MyFrame frame= new MyFrame();
  
}
}
...................................................................

WindowListener
Defines seven methods to recognize when a window is activated,closed, deactivated, deiconified, iconified, opened, or quit.

void windowActivated(WindowEvent we) 
void windowClosed(WindowEvent we) 
void windowClosing(WindowEvent we) 
void windowDeactivated(WindowEvent we) 
void windowDeiconified(WindowEvent we) 
void windowIconified(WindowEvent we) 
void windowOpened(WindowEvent we)

..........................................................................
Example 21  Check Window Listener on Frame

import java.awt.*;
import java.awt.event.*;
class WindowCheck extends Frame implements WindowListener{
WindowCheck () { 
	setSize(400,400);
        setLayout(new FlowLayout());
        addWindowListener(this);
        setVisible(true);	
}
public void windowActivated(WindowEvent we){
System.out.println("Window Activated ");
} 
public void windowClosed(WindowEvent we){
System.out.println("Window Closed ");
}  
public void windowClosing(WindowEvent we){
System.out.println("Window Closing ");
System.exit(0);
}  
public void windowDeactivated(WindowEvent we){
System.out.println("Window Deactivated ");
}  
public void windowDeiconified(WindowEvent we) {
System.out.println("Window Deiconified ");
} 
public void windowIconified(WindowEvent we) {
System.out.println("Window Iconified ");
} 
public void windowOpened(WindowEvent we){
System.out.println("Window Opened ");
} 

}
class Test {
public static void main (String o[]){
 WindowCheck  mc = new WindowCheck();
}
}

................................................................................
The TextListener Interface
This interface defines the textChanged( ) method that is invoked when a change occurs in a text area or text field. 


void textChanged(TextEvent te)

........................................................................................







