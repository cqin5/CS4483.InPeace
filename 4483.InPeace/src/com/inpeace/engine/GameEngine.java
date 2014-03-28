package com.inpeace.engine;

import com.inpeace.engine.Request.RequestType;
import com.inpeace.engine.Request.RouteTo;
import com.inpeace.engine.StateManager.StateID;
import com.inpeace.events.AbstractEvent;
import com.inpeace.exceptions.StateException;
import com.inpeace.views.DefaultView;

/**
 * 
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   23 Mar 2014
 */
public class GameEngine implements Runnable {

	/**   */
	private boolean running;

	/**   */
	private long runTime, startTime;

	/**   */
	private DataManager data;
	private StateManager states;

	/**
	 * Constructs a new GameEngine object.
	 *
	 */
	public GameEngine() {
		running = false;
		runTime = 0;
		startTime = 0;
		data = new DataManager();
		states = new StateManager();
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		running = true;
		startTime = System.currentTimeMillis();

		routeRequest(new Request(DataManager.VIEW, new DefaultView(),
				RequestType.REGISTER, RouteTo.DATA));
		routeRequest(new Request(DataManager.VIEW, new AudioManager(), 
				RequestType.REGISTER, RouteTo.DATA));

		routeRequest(new Request(StateManager.STATE, GameProperties.LAUNCH_STATE,
				RequestType.CHANGE_PROPERTY, RouteTo.STATES));

		while (running) {
			runTime = System.currentTimeMillis() - startTime;

			Scheduler.getInstance().updateRunTime(runTime);
			executeMaturedEvents();
			processRequests();
			data.callRefresh();

			try {
				Thread.sleep(1000 / GameProperties.FPS);
			} catch (Exception e) {
				//NULL BODY
			}
		}
		running = false;

	}

	/**
	 * 
	 */
	public void executeMaturedEvents() {
		AbstractEvent event = Scheduler.getInstance().getMaturedEvent();
		while (event != null) {
			event.execute();
			event = Scheduler.getInstance().getMaturedEvent();
		}
	}

	/**
	 * 
	 */
	public void processRequests() {
		Request request = MailRoom.getInstance().getRequest();
		while (request != null) {
			routeRequest(request);
			request = MailRoom.getInstance().getRequest();
		}
	}

	/**
	 * @param request
	 */
	private void routeRequest(Request request) {
		switch (request.routingCode) {
		case STATES:
			try {
				states.loadState((StateID) request.value);
			} catch (StateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case DATA:
			data.processRequest(request);
			break;
		}
	}

	/**
	 * @return
	 */
	public long getRunTime() {
		return runTime;
	}

}
