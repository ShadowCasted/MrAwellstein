package com.shadowcasted.mrawellstein.eventsystem.example;

import com.shadowcasted.mrawellstein.eventsystem.EventSystem;

public class ExampleUsage {

	public static void main(String[] args){
		try{
			ExampleListenerEventThing.register();
			ExampleListenerEventThing.formEvent(new String("Hello World 1"));
			EventSystem.Listen(new ExampleListenerEventThing.Event("Hello World 2"));
			CancelableExampleListenerEventThing.register();
			CancelableExampleListenerEventThing.Event event = new CancelableExampleListenerEventThing.Event("hello world");
			EventSystem.Listen(event);
			if(event.canceled){
				System.out.println("Event Was Canceled");
			}
			CancelableExampleListenerEventThing.Event event2 = new CancelableExampleListenerEventThing.Event("hello there");
			EventSystem.Listen(event2);
			if(!event2.canceled){
				System.out.println("Event Wasn't Canceled");
			}
		}catch(Exception e){e.printStackTrace();}
	}
}
