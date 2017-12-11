package mainServer;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import lejos.hardware.BrickFinder;
import lejos.hardware.lcd.LCD;
import lejos.remote.ev3.RMIRegulatedMotor;
import lejos.remote.ev3.RemoteEV3;

public class Robot {
	
	private RemoteEV3 ev3;
	private RMIRegulatedMotor B, C;
	
	
	public Robot() throws RemoteException {
		
		/*try {
			ev3 = new RemoteEV3(ip);
		} catch (RemoteException | MalformedURLException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		ev3 = (RemoteEV3) BrickFinder.getDefault();
		ev3.setDefault();
		
		LCD.drawString("Sie sehen mich", 0,4);
		LCD.drawString("rollen", 0,5);
		LCD.drawString("Sie hassen", 0, 6);
		
		B = ev3.createRegulatedMotor("B", 'L');
	    C = ev3.createRegulatedMotor("C", 'L');
	}
	
	public void readinput(int[] input) throws RemoteException {

		if (input[1] < 100) {
			if (input[0] > 100 && input[2] > 100 && input[3] > 100 && input[4] > 100) {
				input[1] = (100-input[1])*7;
				B.backward();
				C.backward();
				B.setSpeed(input[1]);
				C.setSpeed(input[1]);
			}
		}
		
		else {
			B.setSpeed(0);
			C.setSpeed(0);
		}
	}
	
	public void close() throws RemoteException	{
		B.stop(false);
		C.stop(false);
		
	}
	
	
}