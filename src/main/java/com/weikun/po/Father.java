package com.weikun.po;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2016/11/13.
 */

@Entity
@Table(name = "father", catalog = "test")
public class Father {
    private int id;
    private String fname;
    private Set<Son> sons=new HashSet<Son>();

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "fname", nullable = false, length = 10)
    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Father father = (Father) o;

        if (id != father.id) return false;
        if (fname != null ? !fname.equals(father.fname) : father.fname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (fname != null ? fname.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "father" ,cascade = CascadeType.ALL)
    public Set<Son> getSons() {
        return sons;
    }

    public void setSons(Set<Son> sons) {
        this.sons = sons;
    }
}
