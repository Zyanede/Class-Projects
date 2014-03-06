class SingletonFactory {

	private static SingletonObject singletonObject;
	
	private SingletonFactory() {
	}

	public static SingletonObject getSingletonObject() {
		if (singletonObject == null) {
			singletonObject = new SingletonObject();
		}
		return singletonObject;
	}

	public static void nullifySingletonObject() {
		singletonObject = null;
		System.out.println("All of the cookies have been eaten...");
	}
}