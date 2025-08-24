package stepdefinitions;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
    private final TestContext context;

    public Hooks(TestContext context) {
        this.context = context;
    }

    @Before(order = 1)
    public void beforeScenario() {
        // Базовая настройка уже выполнена в конструкторе TestContext
    }

    @Before(value = "@api_registration", order = 10)
    public void registerUserViaApi() {
        context.createdUser = context.dataHelper.createRandomUser();
        context.registerUserViaApi(context.createdUser);
    }

    @After
    public void afterScenario() {
        context.cleanup();
    }
}
