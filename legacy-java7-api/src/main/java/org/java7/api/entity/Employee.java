package org.java7.api.entity;

import java.util.Objects;

/**
 * The employee entity. It must represent an employee or a boss.
 */
public class Employee {

    private int id;

    private String name;

    private int tieline;

    private boolean boss;

    /**
     * Builds an employee from scratch.
     */
    public Employee() {
    }

    /**
     * Builds an employee or a boss.
     *
     * @param id      the employee registration code
     * @param name    the employee name
     * @param tieline the employee tie line
     * @param boss    qualifies the employee as an employee if <code>false</code> or as a boss if <code>true</code>
     */
    public Employee(int id, String name, int tieline, boolean boss) {
        this.id = id;
        this.name = name;
        this.tieline = tieline;
        this.boss = boss;
    }

    /**
     * Utility method to build an employee.
     *
     * @param id      the employee registration code
     * @param name    the employee name
     * @param tieline the employee tie line
     * @return a Employee instance that is qualified as an employee
     */
    public static Employee buildAnEmployee(int id, String name, int tieline) {
        return new Employee(id, name, tieline, false);
    }

    /**
     * Utility method to build a boss.
     *
     * @param id      the boss registration code
     * @param name    the boss name
     * @param tieline the boss tie line
     * @return a Employee instance that is qualified as a boss
     */
    public static Employee buildABoss(int id, String name, int tieline) {
        return new Employee(id, name, tieline, true);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTieline() {
        return tieline;
    }

    public void setTieline(int tieline) {
        this.tieline = tieline;
    }

    public boolean isBoss() {
        return boss;
    }

    public void setBoss(boolean boss) {
        this.boss = boss;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Employee employee = (Employee) o;
        return id == employee.id &&
            tieline == employee.tieline &&
            boss == employee.boss &&
            Objects.equals(name, employee.name);
    }

    @Override public int hashCode() {
        return Objects.hash(id, name, tieline, boss);
    }

    @Override public String toString() {
        final StringBuilder sb = new StringBuilder("Employee{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", tieline=").append(tieline);
        sb.append(", boss=").append(boss);
        sb.append('}');
        return sb.toString();
    }
}
