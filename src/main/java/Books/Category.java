package Books;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name= "category")
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "catId")
    private int _id = -1;

    @Column(name = "catName")
    private String _name;

    public int getId() {
        return _id;
    }

    public void setId(int id) {
        _id = id;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    @Override
    public int hashCode() {
        if (_id < 0) {
            return _name.hashCode();
        }
        return _id;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Category)) {
            return false;
        }
        Category other = (Category) object;
        if (_id < 0 && other._id < 0) {
            return _name.equals(other._name);
        }
        return _id == other._id;
    }

    @Override
    public String toString() {
        return "Category[ id=" + _id + "] " + _name;
    }
}
