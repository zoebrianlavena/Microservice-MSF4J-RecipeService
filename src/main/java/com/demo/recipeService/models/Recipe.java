/*
 * Copyright 2019 WSO2.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.demo.recipeService.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Zoe Brian Lavena
 */
@Entity
@Table(name = "recipe")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Recipe.findAll", query = "SELECT r FROM Recipe r")
    , @NamedQuery(name = "Recipe.findByRecipeID", query = "SELECT r FROM Recipe r WHERE r.recipeID = :recipeID")
    , @NamedQuery(name = "Recipe.findByChefName", query = "SELECT r FROM Recipe r WHERE r.chefName = :chefName")
    , @NamedQuery(name = "Recipe.findByRecipeName", query = "SELECT r FROM Recipe r WHERE r.recipeName = :recipeName")
    , @NamedQuery(name = "Recipe.findByIngredients", query = "SELECT r FROM Recipe r WHERE r.ingredients = :ingredients")
    , @NamedQuery(name = "Recipe.findByInstructions", query = "SELECT r FROM Recipe r WHERE r.instructions = :instructions")
    , @NamedQuery(name = "Recipe.findByRating", query = "SELECT r FROM Recipe r WHERE r.rating = :rating")})
public class Recipe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "recipeID")
    private Integer recipeID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "chefName")
    private String chefName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "recipeName")
    private String recipeName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ingredients")
    private String ingredients;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "instructions")
    private String instructions;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rating")
    private int rating;

    public Recipe() {
    }

    public Recipe(Integer recipeID) {
        this.recipeID = recipeID;
    }

    public Recipe(Integer recipeID, String chefName, String recipeName, String ingredients, String instructions, int rating) {
        this.recipeID = recipeID;
        this.chefName = chefName;
        this.recipeName = recipeName;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.rating = rating;
    }

    public Integer getRecipeID() {
        return recipeID;
    }

    public void setRecipeID(Integer recipeID) {
        this.recipeID = recipeID;
    }

    public String getChefName() {
        return chefName;
    }

    public void setChefName(String chefName) {
        this.chefName = chefName;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (recipeID != null ? recipeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Recipe)) {
            return false;
        }
        Recipe other = (Recipe) object;
        if ((this.recipeID == null && other.recipeID != null) || (this.recipeID != null && !this.recipeID.equals(other.recipeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.demo.recipeService.models.Recipe[ recipeID=" + recipeID + " ]";
    }
    
}
