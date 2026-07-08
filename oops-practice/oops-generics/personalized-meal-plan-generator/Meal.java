
public class Meal<T extends MealPlan> {
    private String mealName;
    private T mealPlan;

    public Meal(String mealName, T mealPlan) {
        this.mealName = mealName;
        this.mealPlan = mealPlan;
    }

    public String getMealName() {
        return mealName;
    }

    public T getMealPlan() {
        return mealPlan;
    }

    @Override
    public String toString() {
        return "Meal{name='" + mealName + "', plan=" + mealPlan + "}";
    }
}
