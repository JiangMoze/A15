package com.weikun.po;

import javax.persistence.*;

/**
 * Created by Administrator on 2016/11/13.
 */
@Entity
@Table(name = "son", catalog = "test")
public class Son {
    private int sid;
    private String sname;
    private Father father;

    @Id
    @Column(name = "sid", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    @Basic
    @Column(name = "sname", nullable = true, length = 10)
    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Son son = (Son) o;

        if (sid != son.sid) return false;
        if (sname != null ? !sname.equals(son.sname) : son.sname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sid;
        result = 31 * result + (sname != null ? sname.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    public Father getFather() {
        return father;
    }

    public void setFather(Father father) {
        this.father = father;
    }
}
