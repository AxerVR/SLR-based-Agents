package com.slr;

import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;

public class SLRAgent extends Agent {
	
	private SLRGui myGui;

  protected void setup() {
	  
	myGui = new SLRGui(this);
	myGui.showGui();
  }
  
  // Put agent clean-up operations here
	protected void takeDown() {
		// Close the GUI
		myGui.dispose();
		// Printout a dismissal message
		System.out.println("SLR-agent "+getAID().getName()+" terminating.");
	}
  
  public void getX(double x) {
		addBehaviour(new OneShotBehaviour() {
			public void action() {
				double[][] dataSet = new double[][]{
						{651,23},
						{762,26},
						{856,30},
						{1063,34},
						{1190,43},
						{1298,48},
						{1421,52},
						{1440,57},
						{1518,58}
				};

				SLR slr = new SLR(dataSet);

				System.out.println("Y = " + slr.beta0() + " + "+ slr.beta1() + "(" + x + ")");
				System.out.println("Y = " + slr.predictY(x));
			}
		} );
	}
}
