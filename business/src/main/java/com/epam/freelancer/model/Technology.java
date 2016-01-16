package com.epam.freelancer.model;

import com.epam.test.transformer.annotation.Column;
import com.epam.test.transformer.annotation.Id;
import com.epam.test.transformer.annotation.Table;

/**
 * Created by Максим on 16.01.2016.
 */
@Table(name = "technology")
public class Technology implements BaseEntity<Integer> {
    @Id
    private Integer id;
    @Column
    private String name;
    @Column(name = "is_deleted")
    private Boolean isDeleted;
    @Column
    private Integer version;


    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public Boolean getDeleted() {
        return isDeleted;
    }

    @Override
    public void setDeleted(Boolean deleted) {
        this.isDeleted = deleted;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Integer getVersion() {
        return version;
    }

    @Override
    public void setVersion(Integer version) {
        this.version = version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Technology that = (Technology) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return !(isDeleted != null ? !isDeleted.equals(that.isDeleted) : that.isDeleted != null);

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (isDeleted != null ? isDeleted.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Technology{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isDeleted=" + isDeleted +
                ", version=" + version +
                '}';
    }
}
