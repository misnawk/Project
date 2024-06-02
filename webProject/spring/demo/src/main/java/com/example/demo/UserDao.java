package com.example.demo;

import java.sql.*;

public class UserDao {
    public static void main(String[] args) {
        Connection c = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC 드라이버를 로드하는데 문제 발생: " + e.getMessage());
            e.printStackTrace();
        }

        try {
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bbs", "root", "1234");
            System.out.println("연결 완료!!!");

            Statement statement = c.createStatement();

            // Users 테이블 데이터 조회
            String queryUsers = "SELECT * FROM Users";
            ResultSet resultSetUsers = statement.executeQuery(queryUsers);

            System.out.println("----------유저정보----------------");
            while (resultSetUsers.next()) {
                int userId = resultSetUsers.getInt("UserID");
                String password = resultSetUsers.getString("Password");
                String phoneNumber = resultSetUsers.getString("PhoneNumber");
                String email = resultSetUsers.getString("Email");

                System.out.println("UserID: " + userId + ", Password: " + password + ", PhoneNumber: " + phoneNumber + ", Email: " + email);
            }

            // Recipes 테이블 데이터 조회
            String queryRecipes = "SELECT * FROM Recipes";
            ResultSet resultSetRecipes = statement.executeQuery(queryRecipes);

            System.out.println("--------------레시피정보---------------");
            while (resultSetRecipes.next()) {
                int recipeId = resultSetRecipes.getInt("RecipeID");
                String category = resultSetRecipes.getString("Category");
                String recipeTitle = resultSetRecipes.getString("RecipeTitle");
                int userId = resultSetRecipes.getInt("UserID");
                String imageUrl = resultSetRecipes.getString("ImageURL");

                System.out.println("RecipeID: " + recipeId + ", Category: " + category + ", RecipeTitle: " + recipeTitle + ", UserID: " + userId + ", ImageURL: " + imageUrl);
            }

            // Ingredients 테이블 데이터 조회
            String queryIngredients = "SELECT * FROM Ingredients";
            ResultSet resultSetIngredients = statement.executeQuery(queryIngredients);

            System.out.println("--------------재료DB---------------");
            while (resultSetIngredients.next()) {
                int recipeId = resultSetIngredients.getInt("RecipeID");
                String ingredient = resultSetIngredients.getString("Ingredient");
                System.out.println("RecipeID: " + recipeId + ", Ingredient: " + ingredient);
            }

            // gastronomy 테이블 데이터 조회
            String queryGastronomy = "SELECT * FROM gastronomy";
            ResultSet resultSetGastronomy = statement.executeQuery(queryGastronomy);

            System.out.println("--------------요리법DB---------------");
            while (resultSetGastronomy.next()) {
                int recipeId = resultSetGastronomy.getInt("RecipeID");
                String instruction = resultSetGastronomy.getString("Instruction");
                System.out.println("RecipeID: " + recipeId + ", Instruction: " + instruction);
            }

        } catch (SQLException e) {
            System.out.println("연결 오류: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (c != null) {
                    c.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
