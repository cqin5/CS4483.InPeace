package com.inpeace.actions;

public class BooleanTrueAction extends AbstractAction {

	public Boolean action;
	
	public BooleanTrueAction(Boolean i) {
		
		action = i;
		
	}

	@Override
	public void execute() {
		
		action = true;
		
	}
	
	public boolean getBoolean(int i) {
		
		return action;
	}
	
}
