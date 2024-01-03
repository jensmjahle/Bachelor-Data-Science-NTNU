package Oving10Oppgave1;

public class Event {
  private String eventNumber;
  private String eventName;
  private String eventPlace;
  private String eventOrganizer;
  private String eventType;
  private double eventTimestamp;

  /**
   * The constructor creates an event with the following parameters.
   *
   * @param eventNumber A unique event number consisting of numbers and letters. As a String.
   * @param eventName The name of the event. As a String.
   * @param eventPlace The place of the event. As a String.
   * @param eventOrganizer The name of the organizer. As a String.
   * @param eventType The type of event. As a String.
   * @param eventTimestamp The time and date of the event (YYYYMMDDTTTT). As a double.
   */

  public Event(String eventNumber, String eventName, String eventPlace, String eventOrganizer, String eventType, double eventTimestamp) {
    this.eventNumber = eventNumber;
    this.eventName = eventName;
    this.eventPlace = eventPlace;
    this.eventOrganizer = eventOrganizer;
    this.eventType = eventType;
    this.eventTimestamp = eventTimestamp;
  }

  /**
   * The method retrieves the event number.
   *
   * @return The event number. As a String.
   */
  public String getEventNumber() {
    return eventNumber;
  }

  /**
   * The method sets a new event number.
   *
   * @param eventNumber The new event number. As a String.
   */
  public void setEventNumber(String eventNumber) {
    this.eventNumber = eventNumber;
  }

  /**
   * The method retrieves the event name.
   *
   * @return The event name. As a String.
   */
  public String getEventName() {
    return eventName;
  }

  /**
   * The method sets a new event name.
   *
   * @param eventName The new event name. As a String.
   */
  public void setEventName(String eventName) {
    this.eventName = eventName;
  }

  /**
   * The method retrieves the event place.
   *
   * @return The event place. As a String.
   */
  public String getEventPlace() {
    return eventPlace;
  }

  /**
   * The method sets a new event place.
   *
   * @param eventPlace The new event place.
   */
  public void setEventPlace(String eventPlace) {
    this.eventPlace = eventPlace;
  }

  /**
   * The method retrieves the event organizer.
   *
   * @return The event organizer. As a String.
   */
  public String getEventOrganizer() {
    return eventOrganizer;
  }

  /**
   * The method sets a new event organizer.
   *
   * @param eventOrganizer The new event organizer. As a String.
   */
  public void setEventOrganizer(String eventOrganizer) {
    this.eventOrganizer = eventOrganizer;
  }

  /**
   * The method retrieves the event type.
   *
   * @return The event type. As a String.
   */
  public String getEventType() {
    return eventType;
  }

  /**
   * The method sets a new event type.
   *
   * @param eventType The new event type. As a String.
   */
  public void setEventType(String eventType) {
    this.eventType = eventType;
  }

  /**
   * The method retrieves the event time, date and year (YYYYMMDDTTTT). As a double.
   *
   * @return The time, date and year (YYYYMMDDTTTT). As a double.
   */
  public double getEventTimestamp() {
    return eventTimestamp;
  }

  /**
   * The method sets a new time, date and year for the event (YYYYMMDDTTTT). As a double.
   *
   * @param eventTimestamp The new time, date and year (YYYYMMDDTTTT). As a double.
   */
  public void setEventTimestamp(int eventTimestamp) {
    this.eventTimestamp = eventTimestamp;
  }

  @Override
  public String toString() {
    return "Event{" +
            "eventNumber=" + eventNumber +
            ", eventName='" + eventName + '\'' +
            ", eventPlace='" + eventPlace + '\'' +
            ", eventOrganizer='" + eventOrganizer + '\'' +
            ", eventType='" + eventType + '\'' +
            ", eventTimestamp=" + eventTimestamp +
            '}';
  }
}
