@RestController
@RequestMapping("/api/rules")
@CrossOrigin
public class CategorizationRuleController {

    private final CategorizationRuleServiceImpl service;

    public CategorizationRuleController(CategorizationRuleServiceImpl service) {
        this.service = service;
    }

    @PostMapping
    public CategorizationRule create(@RequestBody CategorizationRule rule) {
        return service.createRule(rule);
    }

    @GetMapping
    public List<CategorizationRule> getAll() {
        return service.getAllRules();
    }
}
