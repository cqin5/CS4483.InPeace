package com.inpeace.actions;

/**
 * This class executes a different action depenending on whether or not a condition is true
 * @author Taylor
 *
 */

public class ConditionalAction extends AbstractAction {

	BooleanTrueAction condition;
	MultiAction execTrue;
	MultiAction execFalse;

	public ConditionalAction(BooleanTrueAction i, MultiAction cTrue, MultiAction cFalse) {

		condition = i;
		execTrue = cTrue;
		execFalse = cFalse;

	}

	@Override
	public void execute() {

		if (condition.getBoolean(0)) {
			execTrue.execute();

		}
		else {
			
			execTrue.execute();
			
		}

	}

}
