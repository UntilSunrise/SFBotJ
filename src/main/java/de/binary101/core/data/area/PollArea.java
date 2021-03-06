package de.binary101.core.data.area;

import lombok.Getter;
import lombok.Setter;

import org.apache.logging.log4j.ThreadContext;

import de.binary101.core.data.account.Account;
import de.binary101.core.request.PollRequest;
import de.binary101.core.response.Response;

public class PollArea extends BaseArea implements Runnable {

	@Getter @Setter private Thread pollThread;

	public PollArea(Account account) {
		super(account);
	}

	@Override
	public void performArea() {
		if (account.getIsLoggedIn()) {
			String responseString = sendRequest(new PollRequest());
			new Response(responseString, account);
		}
	}

	@Override
	public void run() {
		ThreadContext.put("logFileName", this.account.toString());

		while (this.account.getIsLoggedIn()) {
			try {
				Thread.sleep(10000);

				synchronized (this.account.getRequestCount()) {
					this.performArea();
				}

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
