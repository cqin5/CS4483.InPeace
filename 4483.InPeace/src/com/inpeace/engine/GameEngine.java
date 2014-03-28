package com.inpeace.engine;

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
				Request.REGISTRATION_REQUEST, Request.ROUTE_TO_DATA));
		routeRequest(new Request(DataManager.VIEW, new AudioManager(), 
				Request.REGISTRATION_REQUEST, Request.ROUTE_TO_DATA));

		routeRequest(new Request(StateManager.LOAD_STATE, GameProperties.LAUNCH_STATE,
				Request.CHANGE_PROPERTY_REQUEST, Request.ROUTE_TO_STATES));

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
		case Request.ROUTE_TO_STATES:
			try {
				states.loadState((Integer) request.value);
			} catch (StateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case Request.ROUTE_TO_DATA:
			data.makeRequest(request);
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
