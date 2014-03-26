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
public class Schedule extends ArrayList<AbstractEvent> {

	/** Eclipse generated version ID.  */
	private static final long serialVersionUID = 8323157983870116071L;

	/**   */
	Comparator<AbstractEvent> comparator;

	/**
	 * Constructs a new Scheduler object.
	 *
	 */
	public Schedule() {
		super();
		this.comparator = new Comparator<AbstractEvent>() {
			@Override
			public int compare(AbstractEvent o1, AbstractEvent o2) {
				return o1.getTime().compareTo(o2.getTime());
			}
		};
	}

	/* (non-Javadoc)
	 * @see java.util.ArrayList#add(java.lang.Object)
	 */
	@Override
	public boolean add(AbstractEvent event) {
		boolean result = add(event);
		Collections.sort(this, comparator);
		return result;
	}

	/**
	 * @param eventID
	 * @return
	 */
	public AbstractEvent remove(Integer eventID) {
		int i = indexOf(eventID);
		if (i < 0) {
			return null;
		}
		return remove(i);
	}

	/**
	 * @param eventID
	 * @return
	 */
	public AbstractEvent get(Integer eventID) {
		int i = indexOf(eventID);
		if (i < 0) {
			return null;
		}
		return get(i);
	}

	/**
	 * @param eventID
	 * @return
	 */
	public int indexOf(Integer eventID) {
		for(int i = 0; i < size(); i++) {
			if(get(i) != null && get(i).getEventID().equals(eventID)) {
				return i;
			}
		}
		return -1;
	}
}
