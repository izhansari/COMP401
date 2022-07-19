package lec12.ex5;

public abstract class Service {

	abstract public void doService();
	
	static boolean online;
	
	static public void goOnline() {
		online = true;
	}
	
	static public void goOffline() {
		online = false;
	}
	
	static public Service getService() {
		if (online) {
			return new OnlineService();
		}
		else {
			return new OfflineService();
		}
	}
}

class OnlineService extends Service {

	public void doService() {
		System.out.println("Doing service on-line");
	}
}

class OfflineService extends Service {

	public void doService() {
		System.out.println("Doing service off-line");
	}
}