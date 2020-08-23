package appLaunchTwo.Classes;

import java.util.Objects;

public class Program {
    private int id;
    private String path;
    private String name;
    private String description;

    public Program() {
    }

    public Program( String path,String name, String description) {
        this.path = path;
        this.name = name;
        this.description = description;
    }

    public Program(int id,  String path,String name, String description) {
        this.id = id;
        this.path = path;
        this.name = name;
        this.description = description;
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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Program program = (Program) o;
        return id == program.id &&
                Objects.equals(path, program.path) &&
                Objects.equals(name, program.name)&&
                Objects.equals(description, program.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,  path,name, description);
    }

    @Override
    public String toString() {
        return "Program{" +
                "id =" + id +
                ", path ='" + path + '\'' +
                ", name ='" + name + '\'' +
                ", description ='" + description + '\'' +
                '}';
    }
}
