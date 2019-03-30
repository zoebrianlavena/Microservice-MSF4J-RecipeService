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
package com.demo.recipeService.services;

import com.demo.recipeService.database.RecipeBroker;
import com.demo.recipeService.models.Recipe;
import java.util.List;

/**
 *
 * @author Zoe Brian Lavena
 */
public class RecipeService {
    
    private RecipeBroker rb = new RecipeBroker();
    
    public int addRecipe(Recipe recipe){
        return rb.addRecipe(recipe);
    }
    
    public int deleteRecipe(Recipe recipe){
        return rb.deleteRecipe(recipe);
    }
    
    public int editRecipe(Recipe recipe){
        return rb.editRecipe(recipe);
    }
    
    public List<Recipe> getAllRecipe(){
        return rb.getAllRecipes();
    }
    
    public Recipe getRecipe(String name){
        return rb.getRecipe(name);
    }
    
}
