/*
 * Copyright (c) 2016, WSO2 Inc. (http://wso2.com) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.demo.recipeService.application;

import com.demo.recipeService.models.Recipe;
import com.demo.recipeService.services.RecipeService;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * This is the Microservice resource class.
 * See <a href="https://github.com/wso2/msf4j#getting-started">https://github.com/wso2/msf4j#getting-started</a>
 * for the usage of annotations.
 *
 * @since 1.0.0-SNAPSHOT
 */
@Path("/recipe")
public class RecipeResource {

    @GET
    @Path("/")
    public String get() {
        // TODO: Implementation for HTTP GET request
        System.out.println("GET invoked");
        return "Hello World!";
    }
    
    @GET
    @Path("/recipelist")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Recipe> getAllRecipes() {
        // TODO: Implementation for HTTP GET request
        RecipeService rs = new RecipeService();
        return rs.getAllRecipe();
    }

    @POST
    @Path("addrecipe/{chefName}/{recipeName}/{ingredients}/{instructions}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Recipe addRecipe(@PathParam("chefName") String chefName,
                          @PathParam("recipeName") String recipeName,
                          @PathParam("ingredients") String ingredients,
                          @PathParam("instructions") String instructions) {
        RecipeService rs = new RecipeService();
        Recipe recipe = new Recipe(0, chefName, recipeName, ingredients, instructions, 0);
        rs.addRecipe(recipe);
        return recipe;
    }
    
    @DELETE
    @Path("deleterecipe/{recipeName}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Recipe deleteRecipe(@PathParam("recipeName") String recipeName){
        RecipeService rs = new RecipeService();
        Recipe recipe = rs.getRecipe(recipeName);
        rs.deleteRecipe(recipe);
        return recipe;
    }
    
    @PUT
    @Path("editrecipe/{chefName}/{recipeName}/{ingredients}/{instructions}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Recipe editRecipe(@PathParam("chefName") String chefName,
                           @PathParam("recipeName") String recipeName,
                           @PathParam("ingredients") String ingredients,
                           @PathParam("instructions") String instructions){
        RecipeService rs = new RecipeService();
        Recipe recipe = rs.getRecipe(recipeName);
        recipe.setChefName(chefName);
        recipe.setRecipeName(recipeName);
        recipe.setIngredients(ingredients);
        recipe.setInstructions(instructions);
        rs.editRecipe(recipe);
        return recipe;
    }
    
    @PUT
    @Path("raterecipe/{recipeName}/{rating}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Recipe rateRecipe(@PathParam("recipeName")String recipeName,
                           @PathParam("rating") String rating){
        RecipeService rs = new RecipeService();
        Recipe recipe = rs.getRecipe(recipeName);
        recipe.setRating(Integer.parseInt(rating));
        rs.editRecipe(recipe);
        return recipe;
    }
}
