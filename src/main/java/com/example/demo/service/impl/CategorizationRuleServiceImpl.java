@Service
public class CategorizationRuleServiceImpl {

    private final CategorizationRuleRepository repository;

    public CategorizationRuleServiceImpl(CategorizationRuleRepository repository) {
        this.repository = repository;
    }

    public CategorizationRule createRule(CategorizationRule rule) {
        return repository.save(rule);
    }

    public List<CategorizationRule> getAllRules() {
        return repository.findAll();
    }
}
