package com.shadowcasted.mrawellstein.eventsystem;

import java.util.HashMap;

public class EventSystem {
	public static void Listen(Object o){
		try{
			if(listeners.containsKey(o.getClass())){
				listeners.get(o.getClass()).parse(o);
			}else{
				throw new NoAssignedListenerException("No Listener Assigned...");
			}
		}catch(Exception e){e.printStackTrace();}
	}
	
	public static void addListener(Listener l){listeners.put(l.tolistenfor(), l);}
	
	public static void addListener(@SuppressWarnings("rawtypes") Class c) throws Exception{
		Listener l = ((Listener)c.newInstance());
		listeners.put(l.tolistenfor(),l);
	}
	
	@SuppressWarnings("rawtypes")
	private static HashMap<Class, Listener> listeners = new HashMap<Class, Listener>();	
	
	public static class NoAssignedListenerException extends RuntimeException{
		private static final long serialVersionUID = 1L;
		public NoAssignedListenerException(String string) {super(string);}
	}
	
	public static interface Listener {
		
		@SuppressWarnings("rawtypes")
		public Class tolistenfor();
		
		public void parse(Object o);
		
	}

}
