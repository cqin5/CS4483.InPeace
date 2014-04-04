package com.inpeace.actions;

public class ConditionalAction  extends AbstractAction {

	BooleanTrueAction condition;
	AbstractAction exec;
	
	public ConditionalAction(BooleanTrueAction i, AbstractAction j) {
		
		condition = i;
		exec = j;
		
	}

	@Override
	public void execute() {
		
		if (condition.getBoolean(0)) {
			exec.execute();
			
		}
		
	}
	
}
