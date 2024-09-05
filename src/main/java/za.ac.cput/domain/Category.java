/**
 * E-Commerce Web Application for selling clothes
 * Category.java
 * This POJO class for the Category entity. Domain class using Builder Pattern
 * Author: Mthandeni Mbobo - 218223579
 * Date: 22 March 2024
 */

package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class Category implements Serializable {
    @Id
    private  Long categoryId;
    private String categoryName;
    private  String subCategoryName;

    public Category() {
    }

    public Category(Builder builder) {
        this.categoryId = builder.categoryId;
        this.categoryName = builder.categoryName;
        this.subCategoryName = builder.subCategoryName;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getSubCategoryName() {
        return subCategoryName;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(categoryId, category.categoryId) && Objects.equals(categoryName, category.categoryName) && Objects.equals(subCategoryName, category.subCategoryName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryId, categoryName, subCategoryName);
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", subCategoryName='" + subCategoryName + '\'' +
                '}';
    }

    public static class Builder {
        private Long categoryId;
        private String categoryName;
        private String subCategoryName;

        public Builder setCategoryId(Long categoryId) {
            this.categoryId = categoryId;
            return this;
        }

        public Builder setCategoryName(String categoryName) {
            this.categoryName = categoryName;
            return this;
        }

        public Builder setSubCategoryName(String subCategoryName) {
            this.subCategoryName = subCategoryName;
            return this;
        }

        public Builder copy(Category category) {
            this.categoryId = category.categoryId;
            this.categoryName = category.categoryName;
            this.subCategoryName = category.subCategoryName;
            return this;
        }

        public Category build() {
            return new Category(this);
        }
    }
}