
public class VegetarianMeal implements MealPlan {
    @Override
    public String getPlanType() {
        return "Vegetarian";
    }

    @Override
    public String toString() {
        return "Vegetarian Meal Plan";
    }
}
