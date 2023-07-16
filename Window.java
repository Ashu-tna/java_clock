import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;
import java.util.Date;
import java.text.*;

public class Window extends Frame{ 
	
	private Label clock_heading, clock_time;
	private Label date_heading, date;
	private Label timeZone_heading, timeZone;
	private Label spacer1, spacer2, spacer3, spacer4, last_spacer1, last_spacer2, last_spacer3, last_spacer4;

	Window(String s){
		setTitle(s); 
		setSize(700, 400);
		setLocation(300, 200);
		setBackground(Color.CYAN);
		setForeground(Color.black);
		Font fn = new Font("MONOSPACED", Font.ROMAN_BASELINE, 32);
		Font fn2 = new Font("Forte", Font.BOLD, 32);
		Font fn3 = new Font("Forte", Font.BOLD, 26);


		setFont(fn);
		clock_heading = new Label("Time: ");
		clock_time = new Label("Clock");

		date_heading = new Label("Date: ");
		date = new Label("Date");

		timeZone_heading = new Label("TimeZone: ");
		timeZone = new Label("TimeZone");

		spacer1 = new Label();
		spacer2 = new Label();
		spacer3 = new Label();
		spacer4 = new Label();

		last_spacer1 = new Label();
		last_spacer2 = new Label();
		
		clock_time.setFont(fn2);
		clock_heading.setFont(fn);
		date_heading.setFont(fn);
		date.setFont(fn3);
		timeZone_heading.setFont(fn);
		timeZone.setFont(fn2);

		add(spacer1);
		this.add(clock_heading);
		this.add(clock_time);
		add(spacer3);

		this.add(spacer2);
		add(date_heading);
		add(date);
		this.add(spacer4);
		startClock();

		add(last_spacer1);
		add(timeZone_heading);
		add(timeZone);
		add(last_spacer2);
		
		setLayout(new GridLayout(3, 4));

		setVisible(true);
		setResizable(false);
		

		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
	}
	
	public void startClock(){
		
		Thread t = new Thread(){
			@Override
			public void run(){
				try{
					while(true){
						Date d = new Date();
						SimpleDateFormat sdf = new SimpleDateFormat("hh : mm : ss ");
						String dateTime = sdf.format(d); 

						clock_time.setText(dateTime); 
						SimpleDateFormat dateFormat = new SimpleDateFormat("MMMMM dd, yyyy");
						String dateString = dateFormat.format(Calendar.getInstance().getTime());
            			date.setText(dateString);
						
						timeZone.setText("  "+d.toString().substring(20, d.toString().length()));

						Thread.currentThread().sleep(1000); 
					}
				} catch (InterruptedException e){
					e.printStackTrace();
				}
			}
		};
		t.start();
	}

	
}