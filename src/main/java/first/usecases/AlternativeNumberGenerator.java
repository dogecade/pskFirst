package first.usecases;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;

@ApplicationScoped
@Alternative

public class AlternativeNumberGenerator implements INumberGenerator {
    public int generateInt() {
        return 2;
    }
}
