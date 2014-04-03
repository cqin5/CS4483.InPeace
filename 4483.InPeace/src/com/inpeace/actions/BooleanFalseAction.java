package com.inpeace.actions;

public class BooleanFalseAction extends AbstractAction {

	public Boolean action;
	
	public BooleanFalseAction(Boolean i) {
		
		action = i;
		
	}

	@Override
	public void execute() {
		
		action = false;
		
	}
	
	public boolean getBoolean(int i) {
		
		return action;
	}
	
}