package org.lotus;

import java.awt.Frame;
import java.awt.EventQueue;

import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;

import static java.lang.System.out;

public class Launch {

    public static void main(String[] args) {
		// create thread for this work(optional but recommended)
		EventQueue.invokeLater(new UiBuilder());
    }
}

class UiBuilder implements Runnable {

    @Override
    public void run() {
        Frame f = new Frame("My AWT Frame"); //set title
		f.addWindowListener(new WindowEventHandler()); // add frame observer/handler
        f.setSize(300, 200);
        f.setLocationRelativeTo(null); //put in center of screen
		f.setVisible(true); //show to the user
    }
}

class Killer implements Runnable {

	private Frame frame;

	public Killer(WindowEvent event) {
		this.frame = (Frame) event.getSource();
	}

	@Override
	public void run() {
		frame.setVisible(false);
		out.println("Killing application ...");
		System.exit(0); // normal termination of application
	}
}

class WindowEventHandler implements WindowListener {

    @Override
    public void windowClosing(WindowEvent event) {
        out.println("Closing window ...");
		EventQueue.invokeLater(new Killer(event));
    }

    @Override
    public void windowClosed(WindowEvent event) {
        out.println("Closed window ...");
    }

    @Override
    public void windowOpened(WindowEvent event) {
        out.println("Opened window ...");
    }
	
    @Override
    public void windowIconified(WindowEvent event) {
        out.println("Iconified window ...");
    }
	
    @Override
    public void windowDeiconified(WindowEvent event) {
        out.println("Deiconified window ...");
    }
	
    @Override
    public void windowActivated(WindowEvent event) {
        out.println("Activated window ...");
    }

    @Override
    public void windowDeactivated(WindowEvent event) {
        out.println("Deactivated window ...");
    }
}