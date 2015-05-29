package model;

/**
 * Created by dle on 29.05.2015.
 */
public class Person {
  private Integer id;

  private String name;

  public Person(Integer id, String name) {
    this.id = id;
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

}
