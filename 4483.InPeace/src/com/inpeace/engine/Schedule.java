package com.inpeace.engine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.inpeace.events.AbstractEvent;

/**
 * 
 * 
 * @author  James Anderson
 * @version 1.0
 * @since   26 Mar 2014
 */
public class Schedule {

	/**   */
	private ArrayList<AbstractEvent> schedule;
	
	/**   */
	private Comparator<AbstractEvent> comparator;

	/**
	 * Constructs a new Scheduler object.
	 *
	 */
	public Schedule() {
		schedule = new ArrayList<AbstractEvent>();
		comparator = new Comparator<AbstractEvent>() {
			@Override
			public int compare(AbstractEvent o1, AbstractEvent o2) {
				return o1.getTime().compareTo(o2.getTime());
			}
		};
	}

	/**
	 * @param event
	 * @return
	 */
	public boolean add(AbstractEvent event) {
		boolean result = schedule.add(event);
		Collections.sort(schedule, comparator);
		return result;
	}

	/**
	 * @param eventID
	 * @return
	 */
	public AbstractEvent remove(Integer eventID) {
		int i = indexOf(eventID);
		if (i < 0) {
			System.out.print("error");
			return null;
		}
		return schedule.remove(i);
	}
	
	/**
	 * @return
	 */
	public AbstractEvent removeFirst() {
		if (schedule.isEmpty()) {
			return null;
		}
		return schedule.remove(0);
	}

	/**
	 * @param eventID
	 * @return
	 */
	public AbstractEvent get(int index) {
		if (index < 0 || index >= schedule.size()) {
			return null;
		}
		return schedule.get(index);
	}

	/**
	 * @param eventID
	 * @return
	 */
	private int indexOf(Integer eventID) {
		for(int i = 0; i < schedule.size(); i++) {
			if(schedule.get(i) != null) {
				if (schedule.get(i).getEventID().equals(eventID)) {
					return i;
				}
			}
		}
		return -1;
	}
	
	/**
	 * @return
	 */
	public int size() {
		return schedule.size();
	}
	
	/**
	 * @return
	 */
	public ArrayList<AbstractEvent> getSnapshot() {
		return schedule;
	}
	
	/**
	 * @param snapshot
	 */
	public void restoreSnapshot(ArrayList<AbstractEvent> snapshot) {
		schedule = snapshot;
	}
	
}
