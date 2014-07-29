package com.shadowcasted.mrawellstein.eventsystem.example;

import com.shadowcasted.mrawellstein.eventsystem.EventSystem;

public class CancelableExampleListenerEventThing {
/*
 * For Lack Of A Better Name
 * 
 */
	public static void register() throws Exception{
		EventSystem.addListener(Listener.class);
	}
	
	public static Event formEvent(String message){
		return new Event(message);
	}
	
	public static class Event{
		
		public String message;
		public boolean canceled = false;
		
		public Event(String message){
			this.message = message;
		}
		
	}
	
	public static class Listener implements EventSystem.Listener{
		
		@Override@SuppressWarnings("rawtypes")
		public Class tolistenfor() {return Event.class;}

		@Override
		public void parse(Object o) {
			if(o instanceof Event){
				
				System.out.println("Message From Cancelable Event: "+((Event)o).message);
				if(((Event)o).message.equalsIgnoreCase("hello world")){
					((Event)o).canceled = true;
				}
			}
		}
		
	}
	
}
