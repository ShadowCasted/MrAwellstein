package com.shadowcasted.mrawellstein.eventsystem.example;

import com.shadowcasted.mrawellstein.eventsystem.EventSystem;

public class ExampleListenerEventThing {
/*
 * For Lack Of A Better Name
 * 
 */
	public static void register() throws Exception{
		EventSystem.addListener(Listener.class);
	}
	
	public static void formEvent(String message){
		Event.form(message);
	}
	
	
	public static class Event{
		
		public String message;
		
		public Event(String message){
			this.message = message;
		}
		
		public static void form(String message){
			try{
				EventSystem.Listen(new Event(message));
			}catch(Exception e){
				if(e instanceof EventSystem.NoAssignedListenerException){  //if no listener for the event exist
					try {
						EventSystem.addListener(Listener.class);
						EventSystem.Listen(new Event(message));
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		}
	}
	
	
	
	public static class Listener implements EventSystem.Listener{

		@SuppressWarnings("rawtypes")
		@Override
		public Class tolistenfor() {return Event.class;}

		@Override
		public void parse(Object o) {
			if(o instanceof Event){
				System.out.println("Message From Event: "+((Event)o).message);
			}
		}
		
	}
}
