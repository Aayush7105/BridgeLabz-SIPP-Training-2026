
public class VeganMeal implements MealPlan {
    @Override
    public String getPlanType() {
        return "Vegan";
    }

    @Override
    public String toString() {
        return "Vegan Meal Plan";
    }
}
