package Oving10Oppgave1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * The class represents a register of events.
 * It has methods to sort the register by time, type of event and place.
 * It has methods to search for events in a specific place and a specific time.
 * It has a method for adding new events to the register.
 */
public class EventRegister {
  private ArrayList<Event> eventRegister;

  /**
   * The constructor creates an empty list of events.
   */
  public EventRegister() {
    eventRegister = new ArrayList<Event>();
  }

  /**
   * The method checks if an event exists in the event register.
   *
   * @param eventNumber Event number.
   * @return Returns true if the event exists and false if not.
   */
  public boolean eventExists(String eventNumber){
      boolean eventExists = false;
      for (int i = 0; i < eventRegister.size(); i++) {
        if (eventRegister.get(i).getEventNumber().equals(eventNumber)) {
          eventExists = true;
          break;
        }
      }
      if (eventExists) {
        return true;
      } else {
        return false;
      }

  }

  /**
   * The method adds a new event to the event register.
   *
   * @param eventNumber Event number. As a String.
   * @param eventName Event Name. As a String.
   * @param eventPlace Event place. As a String.
   * @param eventOrganizer Event organizer. As a String.
   * @param eventType Event type. As a String.
   * @param eventTimestamp Event time as YYYYMMDDTTTT. As an integer.
   */
 public void addNewEvent(String eventNumber, String eventName, String eventPlace,
                         String eventOrganizer, String eventType, double eventTimestamp) {
    if (eventExists(eventNumber)) {
      throw new IllegalArgumentException("This event already exists.");
    } else {
      Event newEvent = new Event(eventNumber, eventName, eventPlace,
              eventOrganizer, eventType, eventTimestamp);
      eventRegister.add(newEvent);
    }

  }

  /**
   * The method collects all the events from a specific place and makes a list of them.
   * @param eventPlace The event place.
   * @return A list of events from the chosen place.
   */
 public ArrayList<Event> getEventsInPlace(String eventPlace){
   ArrayList<Event> eventsInPlace = new ArrayList<>();
   for(int i = 0; i < eventRegister.size(); i ++){
     if(eventRegister.get(i).getEventPlace().equals(eventPlace)){
       eventsInPlace.add(eventRegister.get(i));
     }
   }
   return eventsInPlace;
 }

  /**
   * The method collects all the events from a specific date and makes a list of them.
   *
   * @param date The date.
   * @return A list of events from the chosen date.
   */
  public ArrayList<Event> getEventsFromDate(double date){
    ArrayList<Event> eventsDate = new ArrayList<>();
    for(int i = 0; i < eventRegister.size(); i ++){
      int eventDate = (int)Math.floor(eventRegister.get(i).getEventTimestamp() / 10000);
      if (eventDate == (int)date) {
        eventsDate.add(eventRegister.get(i));
      }
    }
    return eventsDate;
  }

  /**
   * THe Method collects all the events in a given time interval and sorts them in a list by time.
   *
   * @param date1 Start date. As a double.
   * @param date2 End date. As a double.
   * @return A list with events in the given time interval sorted by time.
   */
  public ArrayList<Event> getEventsFromTimeInterval(double date1, double date2) {
      ArrayList<Event> eventsTimeInterval = new ArrayList<>();
      for (int i = 0; i < eventRegister.size(); i++) {
        int eventDate = (int)Math.floor(eventRegister.get(i).getEventTimestamp() / 10000);
        if (eventDate >= (int)date1 && eventDate <= (int)date2) {
          eventsTimeInterval.add(eventRegister.get(i));
        }
      }
      Comparator<Event> sortByTime = (Event a1, Event a2) -> (int)a1.getEventTimestamp() - (int)a2.getEventTimestamp();
      Collections.sort(eventsTimeInterval, sortByTime);
      return eventsTimeInterval;
  }

  /**
   * The method sorts the event register by time.
   *
   * @return A list of all events in the register sorted by time.
   */
  public ArrayList<Event> getEventRegisterSortedTime() {
    Comparator<Event> sortByTime = (Event a1, Event a2) -> (int)a1.getEventTimestamp() - (int)a2.getEventTimestamp();
    Collections.sort(eventRegister, sortByTime);
    return eventRegister;
  }

  /**
   * The method sorts the event register by event type.
   *
   * @return A list of all events in the register sorted by time.
   */
  public ArrayList<Event> getEventRegisterSortedType() {
    Comparator<Event> sortByType = (Event a1, Event a2) -> a1.getEventType().compareTo(a2.getEventType());
    Collections.sort(eventRegister, sortByType);
    return eventRegister;
  }

  /**
   * The method sorts the event register by place.
   *
   * @return A list of all events in the register sorted by time.
   */
  public ArrayList<Event> getEventRegisterSortedPlace() {
    Comparator<Event> sortByPlace = (Event a1, Event a2) -> a1.getEventType().compareTo(a2.getEventType());
    Collections.sort(eventRegister, sortByPlace);
    return eventRegister;
  }

  @Override
  public String toString() {
    return "EventRegister{" +
            "EventRegister=" + eventRegister +
            '}';
  }
}
