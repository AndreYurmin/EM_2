import java.util.ArrayList;
import java.util.HashMap;

public class ExpensesManager {
    HashMap<String, ArrayList<Double>> expensesByCategories;

    ExpensesManager() {
        expensesByCategories = new HashMap<>();
    }

    double saveExpense(double moneyBeforeSalary, String category, double expense) {
        moneyBeforeSalary = moneyBeforeSalary - expense;
        System.out.println("Значение сохранено! Ваш текущий баланс в рублях: " + moneyBeforeSalary);
        if (expensesByCategories.containsKey(category)) {
            ArrayList<Double> expenses = expensesByCategories.get(category);
            expenses.add(expense);
        } else {
            ArrayList<Double> expenses = new ArrayList<>();
            expenses.add(expense);
            expensesByCategories.put(category, expenses);
        }
        if (moneyBeforeSalary < 1000) {
            System.out.println("На вашем счету осталось совсем немного. Стоит начать экономить!");
        }
        return moneyBeforeSalary;
    }

    void printAllExpensesByCategories() {
        for (String category : expensesByCategories.keySet()) {
            System.out.println(category);
            ArrayList<Double> expenses = expensesByCategories.get(category);
            for (Double expense : expenses) {
                System.out.println(expense);
            }
        }
    }

    double findMaxExpenseInCategory(String category) {
        double maxExpense = 0;
        if (expensesByCategories.containsKey(category)) {
            ArrayList<Double> expenses = expensesByCategories.get(category);
            for (Double expense : expenses) {
                if (expense > maxExpense) {
                    maxExpense = expense;
                }
            }
        } else {
            System.out.println("Такой категории пока нет.");
        }
        return maxExpense;
    }

    void removeAllExpenses() {
        expensesByCategories.clear();
        System.out.println("Траты удалены.");
    }

    double getExpensesSum() { // Напишите метод для получения суммы всех трат
        // Для реализации метода double getExpensesSum() нужно использовать values() и цикл for.   Пункт 7 меню.
        //   С их помощью просуммируйте все траты в таблице и сохраните — result += expense.
        //   Значение result верните с помощью return
        double result = 0;
        for (ArrayList<Double> expenses : expensesByCategories.values()) { // Здесь должен быть обход по значениям
            for (double expense : expenses) {
                result += expense;
            }
        }
        return result;
    }

    void removeCategory(String name) { // Напишите метод для удаления категории.  Пункт 9 меню.
        //      expensesByCategories.get(name);
        if (expensesByCategories.containsKey(name)) {              // эту строку можно удалить
            expensesByCategories.remove(name);
            System.out.println("Категория" + name + " удалена!"); // эту строку можно удалить
        } else {                                                   // эту строку можно удалить
            System.out.println("Такой категории нет.");             // эту строку можно удалить
        }
    }

    String getMaxCategoryName() { // похожую логику с методом для печати трат по категориям и должен возвращать название категории, где самый большой размер сохранённых трат.
        double maxCategorySum = 0; // Для сохранения промежуточных значений сумм трат по категориям. в них будет сохранён результат.
        String maxCategoryName = ""; // Для сохранения промежуточных значений названий категорий. в них будет сохранён результат.
        double sum = 0;
            for (String category : expensesByCategories.keySet()) {
            ArrayList<Double> expenses = expensesByCategories.get(category);
            //  внешний для того, чтобы проходить по всем ключам в таблице- нужно получить названия категорий через keySet() и списки по каждой категории.
            for (Double expense : expenses) {
//                System.out.println(expense);
                sum += expense; // Во внутреннем цикле для подсчёта суммарного количества трат в категории -нужно суммировать траты в списке и сохранить
                if (sum > maxCategorySum) {
                    maxCategorySum = sum;
                    maxCategoryName = category;
                }
            }
            sum = 0;
        }
        return maxCategoryName;   //  В конце метод должен вернуть maxCategoryName.
    }
}
