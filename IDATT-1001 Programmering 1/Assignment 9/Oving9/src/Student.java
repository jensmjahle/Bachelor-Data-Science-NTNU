/**
 * @author jahle
 * @version 1.0.0
 */
public class Student {
  private final String name;
  private int taskAmount;

  /**
   * The constructor creates a student.
   * @param name Name of the student.
   * @param taskAmount Task amount of the student.
   */
  public Student(String name, int taskAmount) {
    this.name = name;
    setTaskAmount(taskAmount);
  }

  /**
   * The method retrieves the students name.
   * @return Name of the student.
   */
  public String getName() {
    return name;
  }

  /**
   * The method retrieves the students amount of completed tasks.
   * @return Amount of completed tasks.
   */
  public int getTaskAmount() {
    return taskAmount;
  }

  public void setTaskAmount(int taskAmount) {
    if(taskAmount < 0){
      throw new IllegalArgumentException("Task amount must be over 0");
    } else {
      this.taskAmount = taskAmount;
    }
  }

  /**
   * The method increases the amount of completed tasks for a student.
   * @param increasement How much the amount of tasks increases with.
   */
  public void increaseTaskAmount(int increasement){
    setTaskAmount(taskAmount + increasement);
  }

  @Override
  public String toString() {
    return "Student{" +
            "name='" + name + '\'' +
            ", taskAmount=" + taskAmount +
            '}';
  }
}
