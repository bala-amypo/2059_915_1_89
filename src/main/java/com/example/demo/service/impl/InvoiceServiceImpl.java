@Service
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepository invoiceRepo;
    private final UserRepository userRepo;
    private final VendorRepository vendorRepo;
    private final CategorizationRuleRepository ruleRepo;
    private final InvoiceCategorizationEngine engine;

    // ✅ EXACTLY 5 ARGUMENTS (tests expect this)
    public InvoiceServiceImpl(
            InvoiceRepository invoiceRepo,
            UserRepository userRepo,
            VendorRepository vendorRepo,
            CategorizationRuleRepository ruleRepo,
            InvoiceCategorizationEngine engine
    ) {
        this.invoiceRepo = invoiceRepo;
        this.userRepo = userRepo;
        this.vendorRepo = vendorRepo;
        this.ruleRepo = ruleRepo;
        this.engine = engine;
    }
}
