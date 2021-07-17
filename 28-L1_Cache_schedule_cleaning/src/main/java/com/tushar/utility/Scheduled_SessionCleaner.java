package com.tushar.utility;

import java.util.TimerTask;

import org.hibernate.Session;

public class Scheduled_SessionCleaner extends TimerTask {
	Session ses = null;

	public Scheduled_SessionCleaner(Session ses) {
		this.ses = ses;
	}

	@Override
	public void run() {
		System.out.println("Scheduled_SessionCleaner called:"+ses.isOpen());
		if (ses.isOpen()) {
			ses.clear();
		}
	}

}
