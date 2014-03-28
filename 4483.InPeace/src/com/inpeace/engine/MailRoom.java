package com.inpeace.engine;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   27 Mar 2014
 */
public class MailRoom {
	
	/**   */
	private static MailRoom instance = null;
	
	/**   */
	private final Queue<Request> requests;
	
	/**
	 * Constructs a new MailRoom object.
	 *
	 */
	private MailRoom() {
		requests = new LinkedList<Request>();
	}
	
	/**
	 * 
	 */
	public static MailRoom getInstance() {
		if (instance == null) {
			instance = new MailRoom();
		}
		return instance;
	}
	
	/**
	 * @return
	 */
	public Request getRequest() {
		if (!requests.isEmpty()) {
			return requests.remove();
		}
		return null;
	}
	
	/**
	 * @param propertyName
	 * @param value
	 * @param requestType
	 * @param routingCode
	 */
	public void postRequest(String propertyName, Object value, int requestType, int routingCode) {
		requests.add(new Request(propertyName, value, requestType, routingCode));
	}
	
	/**
	 * @param propertyName
	 * @param value
	 * @param requestType
	 */
	public void postRequest(String propertyName, Object value, int requestType) {
		requests.add(new Request(propertyName, value, requestType, Request.ROUTE_TO_DATA));
	}

	public void postRequest(String propertyName, Object value) {
		requests.add(new Request(propertyName, value, Request.CHANGE_PROPERTY_REQUEST,
				Request.ROUTE_TO_DATA));
	}
}
