-- 회원DB
CREATE TABLE Users (
    UserID INT AUTO_INCREMENT PRIMARY KEY,
    Password VARCHAR(255),
    PhoneNumber VARCHAR(100),
    Email VARCHAR(100)
);

-- 레시피DB
CREATE TABLE Recipes (
    RecipeID INT AUTO_INCREMENT PRIMARY KEY,
    Category VARCHAR(100),
    RecipeTitle VARCHAR(255),
    UserID INT,
    ImageURL VARCHAR(255),
    FOREIGN KEY (UserID) REFERENCES Users(UserID)
);

-- 재료DB
CREATE TABLE Ingredients (
    IngredientID INT AUTO_INCREMENT PRIMARY KEY,
    RecipeID INT,
    Ingredient VARCHAR(255),
    FOREIGN KEY (RecipeID) REFERENCES Recipes(RecipeID)
);

-- 요리법DB
CREATE TABLE gastronomy (
    InstructionID INT AUTO_INCREMENT PRIMARY KEY,
    RecipeID INT,
    Instruction TEXT,
    FOREIGN KEY (RecipeID) REFERENCES Recipes(RecipeID)
);


select *from users;
select *from recipes;
select * from ingredients;
select * from gastronomy