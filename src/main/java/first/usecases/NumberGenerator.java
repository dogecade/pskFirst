package first.usecases;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;

@ApplicationScoped
@Default
public class NumberGenerator implements INumberGenerator {
    public int generateInt() {
        return 1;
    }
}
