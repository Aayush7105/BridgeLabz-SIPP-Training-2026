
public class MealPlanGenerator {
    public static <T extends MealPlan> Meal<T> generateMeal(String mealName, T plan) {
        if (plan == null) {
            throw new IllegalArgumentException("Invalid meal plan");
        }
        return new Meal<>(mealName, plan);
    }

    public static void main(String[] args) {
        VegetarianMeal vegPlan = new VegetarianMeal();
        Meal<VegetarianMeal> vegMeal = generateMeal("Veggie Salad", vegPlan);
        System.out.println(vegMeal);

        KetoMeal ketoPlan = new KetoMeal();
        Meal<KetoMeal> ketoMeal = generateMeal("Grilled Chicken with Avocado", ketoPlan);
        System.out.println(ketoMeal);
    }
}
