import java.util.ArrayList;
import java.util.List;

public class TaskCollection {
  private List<Student> students;
  private int StudAmount = 0;

  /**
   * The constructor creates an empty list with students.
   */
  public TaskCollection() {
    students = new ArrayList<>();
  }

  /**
   * The method retrieves the amount of students in the list.
   * @return Amount of students. As an integer.
   */
  public int getAmountOfStudents(){
    return students.size();
  }

  /**
   * The method increases the amount of tasks for a spesific student.
   * @param student Student.
   * @param increasement Task increasement.
   */
  public void increaseTaskAmountStud(Student student, int increasement){
    student.increaseTaskAmount(increasement);
  }

  /**
   * The method retrieves the amount of tasks the chosen student has completed.
   * @param student The chosen student.
   * @return Amount of tasks the chosen student has completed.
   */
  public int getTaskAmountStud(Student student){
    return student.getTaskAmount();
  }

  /**
   * The method retrieves a specific student.
   * @param index Witch student.
   * @return the chosen student.
   */
  public Student getStudent(int index){
    return students.get(index);
  }

  /**
   * The method adds a new student to the list.
   * Throws an illegal argument exception if the student already exists in the list.
   * @param name Name of the new student.
   * @param taskAmount Task amount of the new student.
   */
  public void addNewStudent(String name, int taskAmount){
    boolean existingStudent = false;
    for(int i = 0; i < students.size(); i++){
      if(students.get(i).getName().equals(name)){
        existingStudent = true;
        break;
      }
    }
    if (existingStudent){
      throw new IllegalArgumentException("This student already exists");
    } else {
      Student newStudent = new Student(name, taskAmount);
      students.add(newStudent);
      StudAmount = StudAmount + 1;
    }
  }

  /**
   * The method retrieves the students position in the list of students.
   * @param name The name of the student.
   * @return Witch position the chosen student have in the list.
   */
  public int getStudId(String name){
    int index = -1;
    for(int i = 0; i < getAmountOfStudents(); i++){
      if(students.get(i).getName().equals(name)){
        index = i;
        break;
      }
    }
    return index;
  }

  @Override
  public String toString() {
    return "TaskCollection{" +
            "students=" + students +
            ", StudAmount=" + StudAmount +
            '}';
  }
}
